package es.urjc.geoprocessing.controller;

import es.urjc.geoprocessing.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController extends ParentController<IndexController> {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView view() {
        ModelAndView view = new ModelAndView("index");

        view.addObject("projects", projectService.findAll());

        return view;
    }
}
