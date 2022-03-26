package es.urjc.geoprocessing.service;

import es.urjc.geoprocessing.model.Project;
import es.urjc.geoprocessing.model.views.ProjectView;

public interface ProjectService extends IParentService<Project, Integer> {

    void createProject(ProjectView project) throws Exception;

    void deleteProject(Project project);
}
