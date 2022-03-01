package es.urjc.geoprocessing.service.impl;

import es.urjc.geoprocessing.model.Project;
import es.urjc.geoprocessing.service.ProjectService;
import org.springframework.stereotype.Service;

@Service("projectService")
public class ProjectServiceImpl extends ParentServiceImpl<Project, Integer> implements ProjectService {
}
