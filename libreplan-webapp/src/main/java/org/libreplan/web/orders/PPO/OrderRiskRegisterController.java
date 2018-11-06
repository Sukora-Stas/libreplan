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

import org.libreplan.business.orders.entities.PPO.RiskRegister;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.*;

/**
 * libreplan
 * Created by 8_Sukora_671  on 29/10/18 12:10.
 *
 * @author 8_Sukora_671
 */
public class OrderRiskRegisterController extends GenericForwardComposer {

    private Component window;

    private Textbox textBDescription;

    private Textbox textBResponse;

    private Textbox textBExecutor;

    private Datebox dateBEndRisk;

    private Textbox textBStatus;

    private Grid appRiskGrid;


    private IRiskRegisterModel riskRegisterModel;

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

        comp.setAttribute("orderRiskRegisterController", this, true);
        this.window = comp;

        riskRegisterModel = (IRiskRegisterModel) SpringUtil.getBean("riskRegisterModel");

        initGrid();
    }

    public void saveRisk() {

        RiskRegister riskRegister = new RiskRegister();

        riskRegister.setDescription(textBDescription.getValue());
        riskRegister.setResponse(textBResponse.getValue());
        riskRegister.setExcecutor(textBExecutor.getValue());
        riskRegister.setDateEndRisk(dateBEndRisk.getValue());
        riskRegister.setStatus(textBStatus.getValue());

        riskRegisterModel.confirmSave(riskRegister);

        initGrid();
        //TODO: add mesage "done" and clear all value in view
    }

    private void initGrid() {
        appRiskGrid.setModel(new ListModelList<RiskRegister>
                (riskRegisterModel.getRiskRegister()));

        appRiskGrid.setRowRenderer(gridRenderRow());
    }

    private RowRenderer<RiskRegister> gridRenderRow() {
        return (row, data, index) -> {
            row.appendChild(new Label(String.valueOf(index)));
            row.appendChild(new Label(data.getDescription()));
            row.appendChild(new Label(data.getResponse()));
            row.appendChild(new Label(data.getExcecutor()));
            row.appendChild(new Label(data.getDateEndRisk().toString()));
            row.appendChild(new Label(data.getStatus()));
        };
    }
}
