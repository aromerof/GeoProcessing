package es.urjc.geoprocessing.service.impl;

import es.urjc.geoprocessing.dao.ImageDAO;
import es.urjc.geoprocessing.model.Image;
import es.urjc.geoprocessing.model.Run;
import es.urjc.geoprocessing.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("imageService")
public class ImageServiceImpl extends ParentServiceImpl<Image, Integer> implements ImageService {

    @Autowired
    private ImageDAO imageDAO;

    @Override
    public List<Image> findAllByRun(Run run) {
        return imageDAO.findAllByRun(run);
    }
}
