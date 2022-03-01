package es.urjc.geoprocessing.service.impl;

import es.urjc.geoprocessing.model.Image;
import es.urjc.geoprocessing.service.ImageService;
import org.springframework.stereotype.Service;

@Service("imageService")
public class ImageServiceImpl extends ParentServiceImpl<Image, Integer> implements ImageService {
}
