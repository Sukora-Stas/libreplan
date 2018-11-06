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
 * Created by 8_Sukora_671  on 30/10/18 10:21.
 *
 * @author 8_Sukora_671
 */
public class RiskRegister extends BaseEntity {

    private String description;

    private String response;

    private String excecutor;

    private Date dateEndRisk;

    private String status;

    public RiskRegister() {
    }

    public RiskRegister(String description, String response, String excecutor, Date dateEndRisk, String status) {
        this.description = description;
        this.response = response;
        this.excecutor = excecutor;
        this.dateEndRisk = dateEndRisk;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getExcecutor() {
        return excecutor;
    }

    public void setExcecutor(String excecutor) {
        this.excecutor = excecutor;
    }

    public Date getDateEndRisk() {
        return dateEndRisk;
    }

    public void setDateEndRisk(Date dateEndRisk) {
        this.dateEndRisk = dateEndRisk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RiskRegister that = (RiskRegister) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (response != null ? !response.equals(that.response) : that.response != null) return false;
        if (excecutor != null ? !excecutor.equals(that.excecutor) : that.excecutor != null) return false;
        if (dateEndRisk != null ? !dateEndRisk.equals(that.dateEndRisk) : that.dateEndRisk != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (response != null ? response.hashCode() : 0);
        result = 31 * result + (excecutor != null ? excecutor.hashCode() : 0);
        result = 31 * result + (dateEndRisk != null ? dateEndRisk.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RiskRegister{" +
                "description='" + description + '\'' +
                ", response='" + response + '\'' +
                ", excecutor='" + excecutor + '\'' +
                ", dateEndRisk=" + dateEndRisk +
                ", status='" + status + '\'' +
                '}';
    }
}
