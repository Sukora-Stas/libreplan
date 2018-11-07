package org.libreplan.business.orders.daos.PPO;

import org.libreplan.business.common.daos.GenericDAOHibernate;
import org.libreplan.business.orders.entities.PPO.ProjectTeamCharter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sukora Stas.
 */

@Repository
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ProjectTeamCharterDAO extends GenericDAOHibernate<ProjectTeamCharter, Long>
        implements IProjectTeamCharterDAO {

  @Override
  public List<ProjectTeamCharter> getAll() {
    return list(ProjectTeamCharter.class);
  }

  @Override
  public List<ProjectTeamCharter> getAllByCode(String code) {
    return null;
  }
}
