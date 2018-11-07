package org.libreplan.web.orders.PPO;

import org.libreplan.business.orders.daos.PPO.IProjectTeamCharterDAO;
import org.libreplan.business.orders.entities.PPO.ProjectSchedule;
import org.libreplan.business.orders.entities.PPO.ProjectTeamCharter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sukora Stas.
 */

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProjectTeamCharterModel implements IProjectTeamCharterModel {

  @Autowired
  private IProjectTeamCharterDAO projectTeamCharterDAO;

  @Override
  @Transactional
  public void confirmSave(ProjectTeamCharter projectTeamCharter) {
    projectTeamCharterDAO.save(projectTeamCharter);
  }

  @Override
  @Transactional
  public List<ProjectTeamCharter> getProjectTeamCharter() {
    return projectTeamCharterDAO.getAll();
  }
}
