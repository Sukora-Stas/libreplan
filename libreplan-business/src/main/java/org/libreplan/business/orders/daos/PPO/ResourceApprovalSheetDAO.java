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

import org.hibernate.SessionFactory;
import org.libreplan.business.common.daos.GenericDAOHibernate;
import org.libreplan.business.orders.entities.PPO.ResourceApprovalSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO for {@link ResourceApprovalSheet}
 * <p>
 * libreplan
 * Created by 8_Sukora_671  on 05/10/18 10:29.
 *
 * @author 8_Sukora_671
 */

@Repository
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ResourceApprovalSheetDAO extends GenericDAOHibernate<ResourceApprovalSheet, Long>
        implements IResourceApprovalSheetDAO {

    static IResourceApprovalSheetDAO res;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ResourceApprovalSheet> getAll() {
        /*try {

            Session session = sessionFactory.getCurrentSession();
            List list = session.createCriteria(ResourceApprovalSheet.class).list();

            org.hibernate.Transaction tx = session.beginTransaction();
            list = session.createSQLQuery("SELECT * FROM resourse_approval_sheet").list();
            if (list.size() > 0) {
                System.out.println(list.size());
                ResourceApprovalSheet res = new ResourceApprovalSheet();
                for (int i = 0; i < list.size(); i++) {
                    res = (ResourceApprovalSheet) list.get(i);
                    System.out.println(res.toString());
                }
                return list;
            }
            return null;
        } catch (Exception e) {
            throw e;
        }*/


        return list(ResourceApprovalSheet.class);
    }


}
