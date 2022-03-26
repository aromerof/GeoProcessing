package es.urjc.geoprocessing.model.views;

import es.urjc.geoprocessing.model.Project;

public class ProjectView extends Project {

    private String aoiWkt;

    public String getAoiWkt() {
        return aoiWkt;
    }

    public void setAoiWkt(String aoiWkt) {
        this.aoiWkt = aoiWkt;
    }
}
