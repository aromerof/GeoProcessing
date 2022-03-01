package es.urjc.geoprocessing.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "image", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_run", "code"})})
public class Image extends ParentModel<Image, Integer> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image", nullable = false, unique = true)
    private Integer idImage;

    @Fetch(FetchMode.SELECT)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_run", referencedColumnName = "id_run", nullable = false)
    private Run run;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "captured_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date capturedAt;

    @Column(name = "camera", nullable = false)
    private String camera;

    @Column(name = "orientation", nullable = false)
    private String orientation;

    @Column(name = "shot", columnDefinition = "org.postgis.Point", nullable = false)
    private Point shot;

    @Column(name = "footprint", columnDefinition = "org.postgis.Polygon", nullable = false)
    private Polygon footprint;

    @Column(name = "status", nullable = false)
    private Integer status;

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }

    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCapturedAt() {
        return capturedAt;
    }

    public void setCapturedAt(Date capturedAt) {
        this.capturedAt = capturedAt;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public Point getShot() {
        return shot;
    }

    public void setShot(Point shot) {
        this.shot = shot;
    }

    public Polygon getFootprint() {
        return footprint;
    }

    public void setFootprint(Polygon footprint) {
        this.footprint = footprint;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
