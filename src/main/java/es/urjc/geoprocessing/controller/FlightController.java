package es.urjc.geoprocessing.controller;

import es.urjc.geoprocessing.model.Project;
import es.urjc.geoprocessing.service.FlightService;
import es.urjc.geoprocessing.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("flight")
public class FlightController extends ParentController<FlightController> {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private FlightService flightService;

    @RequestMapping(value = "/{idProject}", method = RequestMethod.GET)
    public ModelAndView view(@PathVariable("idProject") Integer idProject) {
        ModelAndView view = new ModelAndView("flight");

        Project project = projectService.findById(idProject);

        view.addObject("project", project);
        view.addObject("flights", flightService.findAllByProject(project));

        return view;
    }
}
