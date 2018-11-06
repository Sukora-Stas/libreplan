package org.libreplan.web.orders.PPO;/*
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

import org.libreplan.business.orders.daos.PPO.IResourceApprovalSheetDAO;
import org.libreplan.business.orders.entities.PPO.ResourceApprovalSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * libreplan
 * Created by 8_Sukora_671  on 05/10/18 10:38.
 *
 * @author 8_Sukora_671
 */

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ResourceApprovalSheetModel implements IResourceApprovalSheetModel {

  @Autowired
  private IResourceApprovalSheetDAO resourceApprovalSheetDAO;

  @Override
  @Transactional
  public void confirmSave(ResourceApprovalSheet resourceApprovalSheet) {

    resourceApprovalSheetDAO.save(resourceApprovalSheet);
  }

  @Override
  @Transactional
  public List<ResourceApprovalSheet> getApprovalSheet() {
    return resourceApprovalSheetDAO.getAll();
  }
}
