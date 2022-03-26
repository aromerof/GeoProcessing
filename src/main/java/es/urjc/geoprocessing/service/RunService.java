package es.urjc.geoprocessing.service;

import es.urjc.geoprocessing.model.Flight;
import es.urjc.geoprocessing.model.Run;

import java.util.List;

public interface RunService extends IParentService<Run, Integer> {

    List<Run> findAllByFlight(Flight flight);
}
