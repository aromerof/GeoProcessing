package es.urjc.geoprocessing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController extends ParentController<IndexController> {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView view() {
        return new ModelAndView("index");
    }
}
