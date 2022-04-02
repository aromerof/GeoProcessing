package es.urjc.geoprocessing.controller;

import es.urjc.geoprocessing.model.Project;
import es.urjc.geoprocessing.model.views.ProjectView;
import es.urjc.geoprocessing.service.ProjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController extends ParentController<IndexController> {

    private static final Logger logger = LogManager.getLogger(IndexController.class);

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView view() {
        ModelAndView view = new ModelAndView("index");

        view.addObject("projects", projectService.findAll());

        return view;
    }

    @RequestMapping(value = "/create-project", method = RequestMethod.POST)
    public ResponseEntity createProject(@RequestBody ProjectView project) {
        try {
            if (project != null) {
                projectService.createProject(project);

                return ResponseEntity.status(HttpStatus.OK).body("Project created");
            } else {
                logger.error("Data from request is null");

                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Cannot create project");
            }
        } catch (Exception e) {
            logger.error("Cannot create project. Error: {}", e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Cannot create project");
        }
    }

    @RequestMapping(value = "/delete-project/{idProject}", method = RequestMethod.GET)
    public ModelAndView deleteProject(@PathVariable("idProject") Integer idProject, HttpServletRequest request) {
        try {
            Project project = projectService.findById(idProject);

            if (project != null) {
                projectService.deleteProject(project);
            } else {
                logger.error("Cannot find project with id {} to delete project", idProject);
            }
        } catch (Exception e) {
            logger.error("Cannot delete project. Error: {}", e.getMessage());
        }

        return new ModelAndView("redirect:" + request.getHeader("Referer"));
    }
}
