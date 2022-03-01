package es.urjc.geoprocessing.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface IParentService<T, ID extends Serializable> {

    boolean existsById(ID id);

    long count();

    T getOne(ID id);

    T findById(ID id);

    List<T> findAll();

    List<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);

    List<T> findAllById(Iterable<ID> ids);

    T save(T entity);

    <S extends T> S saveAndFlush(S entity);

    <S extends T> List<S> saveAll(Iterable<S> entities);

    void delete(T entity);

    void deleteById(ID id);

    void deleteInBatch(Iterable<T> entities);

    void deleteAll();

    void deleteAll(Iterable<? extends T> entities);

    void deleteAllInBatch();

    void flush();
}
