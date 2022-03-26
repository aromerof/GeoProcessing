package es.urjc.geoprocessing.dao;

import es.urjc.geoprocessing.model.Flight;
import es.urjc.geoprocessing.model.Run;

import java.util.List;

public interface RunDAO extends IParentDAO<Run, Integer> {

    List<Run> findAllByFlight(Flight flight);
}
