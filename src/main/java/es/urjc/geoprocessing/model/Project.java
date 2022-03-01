package es.urjc.geoprocessing.model;

import org.locationtech.jts.geom.MultiPolygon;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "project", uniqueConstraints = {@UniqueConstraint(columnNames = {"code"})})
public class Project extends ParentModel<Project, Integer> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project", nullable = false, unique = true)
    private Integer idProject;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "year")
    private Integer year;

    @Column(name = "aoi", columnDefinition = "org.postgis.MultiPolygon", nullable = false)
    private MultiPolygon aoi;

    @Column(name = "area")
    private Double area;

    @Column(name = "comment")
    private String comment;

    public Integer getIdProject() {
        return idProject;
    }

    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public MultiPolygon getAoi() {
        return aoi;
    }

    public void setAoi(MultiPolygon aoi) {
        this.aoi = aoi;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
