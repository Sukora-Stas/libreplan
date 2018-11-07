package org.libreplan.web.orders.PPO;

import org.libreplan.business.orders.entities.PPO.ProjectTeamCharter;

import java.util.List;

/**
 * Created by Sukora Stas.
 */
public interface IProjectTeamCharterModel {

  void confirmSave(ProjectTeamCharter projectTeamCharter);

  List<ProjectTeamCharter> getProjectTeamCharter();

}
