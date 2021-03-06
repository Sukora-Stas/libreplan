package org.libreplan.business.orders.daos.PPO;/*
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

import org.libreplan.business.common.daos.IGenericDAO;
import org.libreplan.business.common.daos.IIntegrationEntityDAO;
import org.libreplan.business.orders.entities.PPO.ResourceApprovalSheet;

import java.util.List;

/**
 * libreplan
 * Created by 8_Sukora_671  on 08/10/18 14:12.
 *
 * @author 8_Sukora_671
 */
public interface IResourceApprovalSheetDAO extends IGenericDAO<ResourceApprovalSheet, Long> {

  List<ResourceApprovalSheet> getAll();

  //  void save(ResourceApprovalSheet resourceApprovalSheet);

}
