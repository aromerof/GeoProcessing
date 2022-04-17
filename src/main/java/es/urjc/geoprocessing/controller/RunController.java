package es.urjc.geoprocessing.controller;

import es.urjc.geoprocessing.model.Flight;
import es.urjc.geoprocessing.service.FlightService;
import es.urjc.geoprocessing.service.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("run")
public class RunController extends ParentController<RunController> {

    @Autowired
    private FlightService flightService;

    @Autowired
    private RunService runService;

    @RequestMapping(value = "/{idFlight}", method = RequestMethod.GET)
    public ModelAndView view(@PathVariable("idFlight") Integer idFlight) {
        ModelAndView view = new ModelAndView("run");

        Flight flight = flightService.findById(idFlight);

        view.addObject("flight", flight);
        view.addObject("runs", runService.findAllByFlight(flight));

        return view;
    }
}
