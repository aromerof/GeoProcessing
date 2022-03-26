package es.urjc.geoprocessing.service.impl;

import es.urjc.geoprocessing.dao.RunDAO;
import es.urjc.geoprocessing.model.Flight;
import es.urjc.geoprocessing.model.Run;
import es.urjc.geoprocessing.service.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("runService")
public class RunServiceImpl extends ParentServiceImpl<Run, Integer> implements RunService {

    @Autowired
    private RunDAO runDAO;

    @Override
    public List<Run> findAllByFlight(Flight flight) {
        return runDAO.findAllByFlight(flight);
    }
}
