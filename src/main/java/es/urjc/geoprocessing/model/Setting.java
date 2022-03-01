package es.urjc.geoprocessing.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "setting", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Setting extends ParentModel<Setting, Integer> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_setting", nullable = false, unique = true)
    private Integer idSetting;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "value", nullable = false)
    private String value;

    public Integer getIdSetting() {
        return idSetting;
    }

    public void setIdSetting(Integer idSetting) {
        this.idSetting = idSetting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
