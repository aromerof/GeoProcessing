package es.urjc.geoprocessing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("flight")
public class FlightController extends ParentController<FlightController> {

    @RequestMapping(value = "/{idProject}", method = RequestMethod.GET)
    public ModelAndView view(@PathVariable("idProject") Integer idProject) {
        return new ModelAndView("flight");
    }
}
