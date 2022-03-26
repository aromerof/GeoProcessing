package es.urjc.geoprocessing.dao;

import es.urjc.geoprocessing.model.Image;
import es.urjc.geoprocessing.model.Run;

import java.util.List;

public interface ImageDAO extends IParentDAO<Image, Integer> {

    List<Image> findAllByRun(Run run);
}
