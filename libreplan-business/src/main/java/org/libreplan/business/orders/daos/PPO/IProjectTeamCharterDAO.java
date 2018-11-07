package org.libreplan.business.orders.daos.PPO;

import org.libreplan.business.common.daos.IGenericDAO;
import org.libreplan.business.orders.entities.PPO.ProjectTeamCharter;

import java.util.List;

/**
 * Created by Sukora Stas.
 */
public interface IProjectTeamCharterDAO extends IGenericDAO<ProjectTeamCharter, Long> {

  List<ProjectTeamCharter> getAll();

  List<ProjectTeamCharter> getAllByCode(String code);
}
