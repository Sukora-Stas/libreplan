package org.libreplan.business.orders.entities.PPO;/*
 * This file is part of LibrePlan
 *
 * Copyright (C) 2009-2010 Fundación para o Fomento da Calidade Industrial e
 *                         Desenvolvemento Tecnolóxico de Galicia
 * Copyright (C) 2010-2011 Igalia, S.L.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import org.libreplan.business.common.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * libreplan
 * Created by 8_Sukora_671  on 05/10/18 15:38.
 *
 * @author 8_Sukora_671
 */
public class ResourceApprovalSheet extends BaseEntity {

  private String unit;

  private String projectRole;

  private String FIO;

  private String position;

  private Date dateStart;

  private Date dateEnd;

  private String duration;

  private String percentLoad;

  private String peopleDay;

  /**
   * Constructor for Hibernate. Do not use!
   */
  public ResourceApprovalSheet() {
  }

  public ResourceApprovalSheet(String unit, String projectRole, String FIO, String position, Date dateStart, Date dateEnd, String duration, String percentLoad, String peopleDay) {
    this.unit = unit;
    this.projectRole = projectRole;
    this.FIO = FIO;
    this.position = position;
    this.dateStart = dateStart;
    this.dateEnd = dateEnd;
    this.duration = duration;
    this.percentLoad = percentLoad;
    this.peopleDay = peopleDay;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public String getProjectRole() {
    return projectRole;
  }

  public void setProjectRole(String projectRole) {
    this.projectRole = projectRole;
  }

  public String getFIO() {
    return FIO;
  }

  public void setFIO(String FIO) {
    this.FIO = FIO;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public Date getDateStart() {
    return dateStart;
  }

  public void setDateStart(Date dateStart) {
    this.dateStart = dateStart;
  }

  public Date getDateEnd() {
    return dateEnd;
  }

  public void setDateEnd(Date dateEnd) {
    this.dateEnd = dateEnd;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getPercentLoad() {
    return percentLoad;
  }

  public void setPercentLoad(String percentLoad) {
    this.percentLoad = percentLoad;
  }

  public String getPeopleDay() {
    return peopleDay;
  }

  public void setPeopleDay(String peopleDay) {
    this.peopleDay = peopleDay;
  }

  @Override
  public String toString() {
    return "ResourceApprovalSheet{" +
            "unit='" + unit + '\'' +
            ", projectRole='" + projectRole + '\'' +
            ", FIO='" + FIO + '\'' +
            ", position='" + position + '\'' +
            ", dateStart=" + dateStart +
            ", dateEnd=" + dateEnd +
            ", duration='" + duration + '\'' +
            ", percentLoad='" + percentLoad + '\'' +
            ", peopleDay='" + peopleDay + '\'' +
            '}';
  }
}
