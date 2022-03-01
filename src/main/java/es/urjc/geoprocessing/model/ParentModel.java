package es.urjc.geoprocessing.model;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class ParentModel<T extends ParentModel, ID extends Serializable> implements Serializable {
}
