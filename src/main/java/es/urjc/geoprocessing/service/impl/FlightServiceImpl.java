package es.urjc.geoprocessing.service.impl;

import es.urjc.geoprocessing.dao.FlightDAO;
import es.urjc.geoprocessing.model.Flight;
import es.urjc.geoprocessing.model.Project;
import es.urjc.geoprocessing.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("flightService")
public class FlightServiceImpl extends ParentServiceImpl<Flight, Integer> implements FlightService {

    @Autowired
    private FlightDAO flightDAO;

    @Override
    public List<Flight> findAllByProject(Project project) {
        return flightDAO.findAllByProject(project);
    }
}
