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

import org.libreplan.business.orders.entities.PPO.ProjectTeamCharter;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.*;

/**
 * libreplan
 * Created by 8_Sukora_671  on 31/10/18 15:42.
 *
 * @author 8_Sukora_671
 */
public class OrderProjectCharterController extends GenericForwardComposer {

  private Component window;

  private Textbox textPositionCommandCharter;

  private Textbox textFIOCommandCharter;

  private Grid appCommandCharterGrid;


  private IProjectTeamCharterModel projectTeamCharterModel;

  /**
   * Auto forward events and wire accessible variables of the specified
   * component into a controller Java object; a subclass that
   * override this method should remember to call super.doAfterCompose(comp)
   * or it will not work.
   *
   * @param comp
   */
  @Override
  public void doAfterCompose(Component comp) throws Exception {
    super.doAfterCompose(comp);

    comp.setAttribute("orderProjectCharterController", this, true);
    this.window = comp;

    projectTeamCharterModel = (IProjectTeamCharterModel) SpringUtil.getBean("projectTeamCharterModel");

    initGridTeam();
  }

  public void saveCommandCharter() {
    ProjectTeamCharter projectTeamCharter = new ProjectTeamCharter();

    projectTeamCharter.setFIOPTeam(textFIOCommandCharter.getValue());

    projectTeamCharter.setPositionPTeam(textPositionCommandCharter.getValue());

    projectTeamCharterModel.confirmSave(projectTeamCharter);

    initGridTeam();
  }

  private void initGridTeam() {
    appCommandCharterGrid.setModel(new ListModelList<>(projectTeamCharterModel.getProjectTeamCharter()));

    appCommandCharterGrid.setRowRenderer(gridRenderRowTeam());
  }

  private RowRenderer<ProjectTeamCharter> gridRenderRowTeam() {
    return ((row, projectTeamCharter, i) -> {
      row.appendChild(new Label(String.valueOf(i + 1)));
      row.appendChild(new Label(projectTeamCharter.getFIOPTeam()));
      row.appendChild(new Label(projectTeamCharter.getPositionPTeam()));
    });
  }
}
