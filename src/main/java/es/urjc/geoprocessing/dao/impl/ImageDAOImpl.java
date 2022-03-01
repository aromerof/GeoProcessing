package es.urjc.geoprocessing.dao.impl;

import es.urjc.geoprocessing.model.Image;
import org.springframework.stereotype.Repository;

@Repository("imageDAO")
public class ImageDAOImpl extends ParentDAOImpl<Image, Integer> {
}
