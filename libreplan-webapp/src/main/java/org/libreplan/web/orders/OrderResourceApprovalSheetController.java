package org.libreplan.web.orders;

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

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Textbox;

import java.util.Calendar;
import java.util.Date;

/**
 * libreplan
 * Лист согласований ресурсов
 * Created by 8_Sukora_671  on 01/10/18 11:11.
 *
 * @author 8_Sukora_671
 */
public class OrderResourceApprovalSheetController extends GenericForwardComposer {

    private Component window;

    private Textbox textBUnit;

    private Textbox textBProjectRole;

    private Textbox textBFIO;

    private Textbox textBPosition;

    private Datebox dateBStart;

    private Datebox dateBEnd;

    private Textbox textBDuration;//auto

    private Textbox textBPercentLoad;

    private Textbox textBPeopleDay;//auto

    // private Label labFIjkO;


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
        comp.setAttribute("orderResourceApprovalSheetController", this, true);
        this.window = comp;

        textBProjectRole.setValue("Project role");
        textBFIO.setValue("test");
    }

    public void saveApprovalSheet() {
        textBProjectRole.setValue("it's work");
    }

    public void onChange$dateBEnd(Event event) {
        textBDuration.setValue(
                String.valueOf(
                        getDuration(dateBEnd.getValue(),
                                dateBStart.getValue())));
        textBPeopleDay.setValue(
                getPeopleDay(
                        textBDuration.getValue(),
                        textBPercentLoad.getValue()));
    }

    public void onChange$textBPercentLoad(Event event) {
        textBPeopleDay.setValue(
                getPeopleDay(
                        textBDuration.getValue(),
                        textBPercentLoad.getValue()));
    }

    private int getDuration(Date first, Date second) {
        Calendar firstCal = Calendar.getInstance();
        firstCal.setTime(first);

        Calendar secondCal = Calendar.getInstance();
        secondCal.setTime(second);

        long fullMiliSecond = firstCal.getTimeInMillis() - secondCal.getTimeInMillis();

        fullMiliSecond = fullMiliSecond / 1000 / 60 / 60 / 24;

        return (int) fullMiliSecond;
    }

    private String getPeopleDay(String percent, String duration) {
        if(percent.equals("") || percent.isEmpty()){
            return null;
        }
        if(duration.equals("") || duration.isEmpty()){
            return null;
        }

        double IPercent = new Double(percent);
        double IDuratiom = new Double(duration);

        return String.valueOf((IPercent * IDuratiom) / 100);
    }

}
