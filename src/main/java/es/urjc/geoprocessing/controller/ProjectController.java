package es.urjc.geoprocessing.controller;

import es.urjc.geoprocessing.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("project")
public class ProjectController extends ParentController<ProjectController> {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/{idProject}", method = RequestMethod.GET)
    public ModelAndView view(@PathVariable("idProject") Integer idProject) {
        ModelAndView view = new ModelAndView("project");

        view.addObject("project", projectService.findById(idProject));

        return view;
    }
}
