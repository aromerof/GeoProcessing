package es.urjc.geoprocessing.service.impl;

import es.urjc.geoprocessing.model.Run;
import es.urjc.geoprocessing.service.RunService;
import org.springframework.stereotype.Service;

@Service("runService")
public class RunServiceImpl extends ParentServiceImpl<Run, Integer> implements RunService {
}
