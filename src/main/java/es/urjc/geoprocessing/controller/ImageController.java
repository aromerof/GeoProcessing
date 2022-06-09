package es.urjc.geoprocessing.controller;

import es.urjc.geoprocessing.service.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("image")
public class ImageController extends ParentController<ImageController> {

    @Autowired
    private RunService runService;

    @RequestMapping(value = "/{idRun}", method = RequestMethod.GET)
    public ModelAndView view(@PathVariable("idRun") Integer idRun) {
        ModelAndView view = new ModelAndView("image");

        view.addObject("run", runService.findById(idRun));

        return view;
    }
}
