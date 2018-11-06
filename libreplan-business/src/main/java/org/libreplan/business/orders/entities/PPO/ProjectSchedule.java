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

import java.util.Date;

/**
 * libreplan
 * Created by 8_Sukora_671  on 30/10/18 18:45.
 *
 * @author 8_Sukora_671
 */
public class ProjectSchedule extends BaseEntity {

  private String task;

  private Date dateStart;

  private Date dateEnd;

  private String response;

  private Double cost;

  public ProjectSchedule() {
  }

  public ProjectSchedule(String task, Date dateStart, Date dateEnd, String response, Double cost) {
    this.task = task;
    this.dateStart = dateStart;
    this.dateEnd = dateEnd;
    this.response = response;
    this.cost = cost;
  }

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
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

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ProjectSchedule that = (ProjectSchedule) o;

    if (task != null ? !task.equals(that.task) : that.task != null) return false;
    if (dateStart != null ? !dateStart.equals(that.dateStart) : that.dateStart != null) return false;
    if (dateEnd != null ? !dateEnd.equals(that.dateEnd) : that.dateEnd != null) return false;
    if (response != null ? !response.equals(that.response) : that.response != null) return false;
    return cost != null ? cost.equals(that.cost) : that.cost == null;
  }

  @Override
  public int hashCode() {
    int result = task != null ? task.hashCode() : 0;
    result = 31 * result + (dateStart != null ? dateStart.hashCode() : 0);
    result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
    result = 31 * result + (response != null ? response.hashCode() : 0);
    result = 31 * result + (cost != null ? cost.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ProjectSchedule{" +
            "task='" + task + '\'' +
            ", dateStart=" + dateStart +
            ", dateEnd=" + dateEnd +
            ", response='" + response + '\'' +
            ", cost=" + cost +
            '}';
  }
}
