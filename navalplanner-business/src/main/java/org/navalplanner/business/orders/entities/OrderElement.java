package org.navalplanner.business.orders.entities;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.validator.NotNull;
import org.navalplanner.business.planner.entities.TaskElement;

public abstract class OrderElement {

    private Long id;

    private Long version;

    @NotNull
    private String name;

    private Date initDate;

    private Date endDate;

    private Boolean mandatoryInit = false;

    private Boolean mandatoryEnd = false;

    private String description;

    private String code;

    private Set<TaskElement> taskElements = new HashSet<TaskElement>();

    public abstract Integer getWorkHours();

    public abstract List<HoursGroup> getHoursGroups();

    public long getId() {
        return id;
    }

    /**
     * @return the duration in milliseconds
     */
    public long getDuration() {
        return endDate.getTime() - initDate.getTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract boolean isLeaf();

    public abstract List<OrderElement> getChildren();

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setMandatoryInit(Boolean mandatoryInit) {
        this.mandatoryInit = mandatoryInit;
    }

    public Boolean isMandatoryInit() {
        return mandatoryInit;
    }

    public void setMandatoryEnd(Boolean mandatoryEnd) {
        this.mandatoryEnd = mandatoryEnd;
    }

    public Boolean isMandatoryEnd() {
        return mandatoryEnd;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract OrderLine toLeaf();

    public abstract OrderLineGroup toContainer();

    public abstract void forceLoadHourGroups();

    public abstract void forceLoadHourGroupsCriterions();

    public void makeTransientAgain() {
        // FIXME Review reattachment
        id = null;
        version = null;
        for (HoursGroup hoursGroup : getHoursGroups()) {
            hoursGroup.makeTransientAgain();
        }
    }

    public boolean isTransient() {
        // FIXME Review reattachment
        return id == null;
    }

    public Set<HoursGroup> getTransientHoursGroups() {
        // FIXME Review reattachment
        Set<HoursGroup> transientHoursGroups = new HashSet<HoursGroup>();

        for (HoursGroup hoursGroup : getHoursGroups()) {
            if (hoursGroup.isTransient()) {
                transientHoursGroups.add(hoursGroup);
            }
        }
        return transientHoursGroups;
    }

    public Set<TaskElement> getTaskElements() {
        return Collections.unmodifiableSet(taskElements);
    }

    public boolean isScheduled() {
        return !taskElements.isEmpty();
    }

    public boolean checkAtLeastOneHoursGroup() {
        return (getHoursGroups().size() > 0);
    }

}
