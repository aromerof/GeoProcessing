package es.urjc.geoprocessing.dao;

import es.urjc.geoprocessing.model.Flight;
import es.urjc.geoprocessing.model.Project;

import java.util.List;

public interface FlightDAO extends IParentDAO<Flight, Integer> {

    List<Flight> findAllByProject(Project project);
}
