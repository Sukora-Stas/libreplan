package org.libreplan.business.orders.entities.PPO;

/*
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

import java.util.Objects;

/**
 * Created by Sukora Stas.
 */
public class ProjectTeamCharter extends BaseEntity {

  private String refOrder;

  private String FIOPTeam;

  private String FIOPPrepared;

  private String positionPTeam;

  private String positionPPrepared;

  public ProjectTeamCharter() {
  }

  public ProjectTeamCharter(String refOrder, String FIOPTeam, String FIOPPrepared, String positionPTeam, String positionPPrepared) {
    this.refOrder = refOrder;
    this.FIOPTeam = FIOPTeam;
    this.FIOPPrepared = FIOPPrepared;
    this.positionPTeam = positionPTeam;
    this.positionPPrepared = positionPPrepared;
  }

  public String getRefOrder() {
    return refOrder;
  }

  public void setRefOrder(String refOrder) {
    this.refOrder = refOrder;
  }

  public String getFIOPTeam() {
    return FIOPTeam;
  }

  public void setFIOPTeam(String FIOPTeam) {
    this.FIOPTeam = FIOPTeam;
  }

  public String getFIOPPrepared() {
    return FIOPPrepared;
  }

  public void setFIOPPrepared(String FIOPPrepared) {
    this.FIOPPrepared = FIOPPrepared;
  }

  public String getPositionPTeam() {
    return positionPTeam;
  }

  public void setPositionPTeam(String positionPTeam) {
    this.positionPTeam = positionPTeam;
  }

  public String getPositionPPrepared() {
    return positionPPrepared;
  }

  public void setPositionPPrepared(String positionPPrepared) {
    this.positionPPrepared = positionPPrepared;
  }


}


