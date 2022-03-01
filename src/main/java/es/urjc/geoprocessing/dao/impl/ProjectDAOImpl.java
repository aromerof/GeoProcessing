package es.urjc.geoprocessing.dao.impl;

import es.urjc.geoprocessing.model.Project;
import org.springframework.stereotype.Repository;

@Repository("projectDAO")
public class ProjectDAOImpl extends ParentDAOImpl<Project, Integer> {
}
