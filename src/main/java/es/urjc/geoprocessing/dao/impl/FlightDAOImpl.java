package es.urjc.geoprocessing.dao.impl;

import es.urjc.geoprocessing.model.Flight;
import org.springframework.stereotype.Repository;

@Repository("flightDAO")
public class FlightDAOImpl extends ParentDAOImpl<Flight, Integer> {
}
