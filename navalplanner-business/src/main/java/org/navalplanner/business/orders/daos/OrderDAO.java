/*
 * This file is part of ###PROJECT_NAME###
 * 
 * Copyright (C) 2009 Fundación para o Fomento da Calidade Industrial e
 * Desenvolvemento Tecnolóxico de Galicia
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.navalplanner.business.orders.daos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.joda.time.LocalDate;
import org.navalplanner.business.common.daos.GenericDAOHibernate;
import org.navalplanner.business.common.exceptions.InstanceNotFoundException;
import org.navalplanner.business.costcategories.daos.CostCategoryDAO;
import org.navalplanner.business.costcategories.daos.ITypeOfWorkHoursDAO;
import org.navalplanner.business.costcategories.entities.TypeOfWorkHours;
import org.navalplanner.business.orders.entities.Order;
import org.navalplanner.business.orders.entities.OrderElement;
import org.navalplanner.business.orders.entities.TaskSource;
import org.navalplanner.business.planner.daos.ITaskSourceDAO;
import org.navalplanner.business.reports.dtos.OrderCostsPerResourceDTO;
import org.navalplanner.business.planner.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Dao for {@link Order}
 * 
 * @author Óscar González Fernández <ogonzalez@igalia.com>
 * @author Lorenzo Tilve Álvaro <ltilve@igalia.com>
 */
@Repository
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class OrderDAO extends GenericDAOHibernate<Order, Long> implements
        IOrderDAO {

    @Autowired
    private ITaskSourceDAO taskSourceDAO;

    @Autowired
    private ITypeOfWorkHoursDAO typeOfWorkHoursDAO;

    @Override
    public List<Order> getOrders() {
        return list(Order.class);
    }

    @Override
    public void remove(Long id) throws InstanceNotFoundException {
        Order order = find(id);
        List<TaskSource> sources = order.getTaskSourcesFromBottomToTop();
        for (TaskSource each : sources) {
            taskSourceDAO.remove(each.getId());
        }
        super.remove(id);
    }

    private boolean isOrderNameContained(String code, List<Order> orders) {
        for (Order each : orders) {
            if (each.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    @Transactional(readOnly = true)
    public List<OrderCostsPerResourceDTO> getOrderCostsPerResource(
            List<Order> orders, Date startingDate, Date endingDate) {

        String orderStrQuery = "FROM Order order ";
        Query orderQuery = getSession().createQuery(orderStrQuery);
        List<Order> orderList = orderQuery.list();
        String strQuery = "SELECT new org.navalplanner.business.reports.dtos.OrderCostsPerResourceDTO(worker, wrl) "
                + "FROM Worker worker, WorkReportLine wrl "
                + "LEFT OUTER JOIN wrl.resource resource "
                + "WHERE resource.id = worker.id ";

        // Set date range
        if (startingDate != null && endingDate != null) {
            strQuery += "AND wrl.date BETWEEN :startingDate AND :endingDate ";
        }
        if (startingDate != null && endingDate == null) {
            strQuery += "AND wrl.date >= :startingDate ";
        }
        if (startingDate == null && endingDate != null) {
            strQuery += "AND wrl.date <= :endingDate ";
        }

        // Order by
        strQuery += "ORDER BY worker.id, wrl.date";

        Query query = getSession().createQuery(strQuery);

        if (startingDate != null) {
            query.setParameter("startingDate", startingDate);
        }
        if (endingDate != null) {
            query.setParameter("endingDate", endingDate);
        }

        List<OrderCostsPerResourceDTO> list = query.list();

        List<OrderCostsPerResourceDTO> filteredList = new ArrayList<OrderCostsPerResourceDTO>();
        for (OrderCostsPerResourceDTO each : list) {

            Order order = each.getOrderElement().getOrder();

            // Apply filtering
            if (orders.isEmpty()
                    || isOrderNameContained(order.getCode(), orders)) {

                // Attach ordername value
                each.setOrderName(order.getName());

                // Attach calculated pricePerHour
                BigDecimal pricePerHour = CostCategoryDAO
                        .getPriceByResourceDateAndHourType(each.getWorker(),
                                new LocalDate(each.getDate()), each
                                        .getHoursType());
                if (pricePerHour == null) {
                    for (TypeOfWorkHours defaultprice : typeOfWorkHoursDAO
                            .list(TypeOfWorkHours.class)) {
                        if (defaultprice.getCode().equals(each.getHoursType())) {
                            pricePerHour = defaultprice.getDefaultPrice();
                        }
                    }
                }

                each.setCostPerHour(pricePerHour);
                each.setCost(each.getCostPerHour().multiply(
                        new BigDecimal(each.getNumHours())));
                filteredList.add(each);
            }
        }
        return filteredList;
    }

    @Override
    public List<Task> getTasksByOrder(Order order) {
        reattach(order);

        final List<OrderElement> orderElements = order.getAllChildren();
        if (orderElements.isEmpty()) {
            return new ArrayList<Task>();
        }

        final String strQuery = "SELECT taskSource.task "
                + "FROM TaskSource taskSource "
                + "WHERE taskSource.orderElement IN (:orderElements) "
                + " AND taskSource.task IN (FROM Task)";
        Query query = getSession().createQuery(strQuery);
        query.setParameterList("orderElements", orderElements);

        return (List<Task>) query.list();
    }

}