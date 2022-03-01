package es.urjc.geoprocessing.service.impl;

import es.urjc.geoprocessing.model.Flight;
import es.urjc.geoprocessing.service.FlightService;
import org.springframework.stereotype.Service;

@Service("flightService")
public class FlightServiceImpl extends ParentServiceImpl<Flight, Integer> implements FlightService {
}
