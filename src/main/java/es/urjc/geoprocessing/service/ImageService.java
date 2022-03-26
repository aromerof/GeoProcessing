package es.urjc.geoprocessing.service;

import es.urjc.geoprocessing.model.Image;
import es.urjc.geoprocessing.model.Run;

import java.util.List;

public interface ImageService extends IParentService<Image, Integer> {

    List<Image> findAllByRun(Run run);
}
