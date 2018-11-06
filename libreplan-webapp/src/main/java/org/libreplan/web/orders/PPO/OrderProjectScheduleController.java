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

import org.libreplan.business.orders.entities.PPO.ProjectSchedule;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.*;

/**
 * libreplan
 * Created by 8_Sukora_671  on 30/10/18 17:52.
 *
 * @author 8_Sukora_671
 */
public class OrderProjectScheduleController extends GenericForwardComposer {

  private Component window;

  private Textbox textBTask;

  private Datebox dateBStartSchedule;

  private Datebox dateBFinishSchedule;

  private Textbox textBResponseSchedule;

  private Textbox textBCostSchedule;


  private Grid appScheduleGrid;

  private IProjectScheduleModel projectScheduleModel;

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

    comp.setAttribute("orderProjectScheduleController", this, true);
    this.window = comp;

    projectScheduleModel = (IProjectScheduleModel) SpringUtil.getBean("projectScheduleModel");

    initGrid();
  }

  public void saveSchedule() {

    ProjectSchedule projectSchedule = new ProjectSchedule();

    projectSchedule.setTask(textBTask.getValue());
    projectSchedule.setDateStart(dateBStartSchedule.getValue());
    projectSchedule.setDateEnd(dateBFinishSchedule.getValue());
    projectSchedule.setResponse(textBResponseSchedule.getValue());
    projectSchedule.setCost(Double.valueOf(textBCostSchedule.getValue()));
//TODO: checked value cost from char ',' to '.'
    projectScheduleModel.confirmSave(projectSchedule);

    initGrid();
    //TODO: add mesage "done" and clear all value in view

  }

  private void initGrid() {

    appScheduleGrid.setModel(new ListModelList<ProjectSchedule>
            (projectScheduleModel.getProjectSchedule()));

    appScheduleGrid.setRowRenderer(gridRenderRow());
  }

  private RowRenderer<ProjectSchedule> gridRenderRow() {
    return ((row, data, index) -> {
      row.appendChild(new Label(String.valueOf(index) + 1));
      row.appendChild(new Label(data.getTask()));
      row.appendChild(new Label(data.getDateStart().toString()));
      row.appendChild(new Label(data.getDateEnd().toString()));
      row.appendChild(new Label(data.getResponse()));
      row.appendChild(new Label(data.getCost().toString()));
    });
  }
}
