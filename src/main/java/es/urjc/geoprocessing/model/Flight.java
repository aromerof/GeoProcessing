package es.urjc.geoprocessing.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "flight", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_project", "code"})})
public class Flight extends ParentModel<Flight, Integer> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_flight", nullable = false, unique = true)
    private Integer idFlight;

    @Fetch(FetchMode.SELECT)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_project", referencedColumnName = "id_project", nullable = false)
    private Project project;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "flight_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date flightDate;

    @Column(name = "num_images")
    private Integer numImages;

    @Column(name = "comment")
    private String comment;

    public Integer getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(Integer idFlight) {
        this.idFlight = idFlight;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public Integer getNumImages() {
        return numImages;
    }

    public void setNumImages(Integer numImages) {
        this.numImages = numImages;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
