package es.urjc.geoprocessing.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.locationtech.jts.geom.LineString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "run", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_flight", "code"})})
public class Run extends ParentModel<Run, Integer> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_run", nullable = false, unique = true)
    private Integer idRun;

    @Fetch(FetchMode.SELECT)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_flight", referencedColumnName = "id_flight", nullable = false)
    private Flight flight;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "trajectory", columnDefinition = "org.postgis.LineString", nullable = false)
    private LineString trajectory;

    public Integer getIdRun() {
        return idRun;
    }

    public void setIdRun(Integer idRun) {
        this.idRun = idRun;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LineString getTrajectory() {
        return trajectory;
    }

    public void setTrajectory(LineString trajectory) {
        this.trajectory = trajectory;
    }
}
