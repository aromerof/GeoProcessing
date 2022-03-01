package es.urjc.geoprocessing.dao.impl;

import es.urjc.geoprocessing.model.Setting;
import org.springframework.stereotype.Repository;

@Repository("settingDAO")
public class SettingDAOImpl extends ParentDAOImpl<Setting, Integer> {
}
