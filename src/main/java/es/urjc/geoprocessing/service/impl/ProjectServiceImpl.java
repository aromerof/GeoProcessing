package es.urjc.geoprocessing.service.impl;

import es.urjc.geoprocessing.model.Flight;
import es.urjc.geoprocessing.model.Image;
import es.urjc.geoprocessing.model.Project;
import es.urjc.geoprocessing.model.Run;
import es.urjc.geoprocessing.model.views.ProjectView;
import es.urjc.geoprocessing.service.FlightService;
import es.urjc.geoprocessing.service.ImageService;
import es.urjc.geoprocessing.service.ProjectService;
import es.urjc.geoprocessing.service.RunService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectService")
public class ProjectServiceImpl extends ParentServiceImpl<Project, Integer> implements ProjectService {

    @Autowired
    private FlightService flightService;

    @Autowired
    private RunService runService;

    @Autowired
    private ImageService imageService;

    @Override
    public void createProject(ProjectView project) throws Exception {
        Project newProject = new Project();

        if (StringUtils.isNotBlank(project.getCode())) {
            newProject.setCode(project.getCode());
        } else {
            throw new Exception("Missing code parameter");
        }

        if (StringUtils.isNotBlank(project.getCountry())) {
            newProject.setCountry(project.getCountry());
        } else {
            newProject.setCountry(null);
        }

        if (StringUtils.isNotBlank(project.getState())) {
            newProject.setState(project.getState());
        } else {
            newProject.setState(null);
        }

        if (StringUtils.isNotBlank(project.getCity())) {
            newProject.setCity(project.getCity());
        } else {
            newProject.setCity(null);
        }

        if (project.getYear() != null) {
            newProject.setYear(project.getYear());
        } else {
            newProject.setYear(null);
        }

        if (StringUtils.isNotBlank(project.getAoiWkt())) {
            try {
                newProject.setAoi(createMultiPolygonFromWkt(project.getAoiWkt()));
            } catch (ParseException e) {
                throw new Exception(e.getMessage());
            }
        } else {
            throw new Exception("Missing AOI wkt parameter");
        }

        if (StringUtils.isNotBlank(project.getComment())) {
            newProject.setComment(project.getComment());
        } else {
            newProject.setComment(null);
        }

        save(newProject);
    }

    private MultiPolygon createMultiPolygonFromWkt(String wkt) throws ParseException {
        WKTReader wktReader = new WKTReader(new GeometryFactory(new PrecisionModel(), 4326));

        return (MultiPolygon) wktReader.read(wkt);
    }

    @Override
    public void deleteProject(Project project) {
        List<Flight> flights = flightService.findAllByProject(project);

        if (CollectionUtils.isNotEmpty(flights)) {
            for (Flight flight : flights) {
                List<Run> runs = runService.findAllByFlight(flight);

                if (CollectionUtils.isNotEmpty(runs)) {
                    for (Run run : runs) {
                        List<Image> images = imageService.findAllByRun(run);

                        if (CollectionUtils.isNotEmpty(images)) {
                            imageService.deleteAll(images);
                        }

                        runService.delete(run);
                    }
                }

                flightService.delete(flight);
            }
        }

        delete(project);
    }
}
