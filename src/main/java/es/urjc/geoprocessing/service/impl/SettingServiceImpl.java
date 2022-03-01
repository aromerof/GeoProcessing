package es.urjc.geoprocessing.service.impl;

import es.urjc.geoprocessing.model.Setting;
import es.urjc.geoprocessing.service.SettingService;
import org.springframework.stereotype.Service;

@Service("settingService")
public class SettingServiceImpl extends ParentServiceImpl<Setting, Integer> implements SettingService {
}
