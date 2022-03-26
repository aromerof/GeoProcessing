package es.urjc.geoprocessing.service;

import es.urjc.geoprocessing.model.Flight;
import es.urjc.geoprocessing.model.Project;

import java.util.List;

public interface FlightService extends IParentService<Flight, Integer> {

    List<Flight> findAllByProject(Project project);
}
