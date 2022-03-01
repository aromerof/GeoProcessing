package es.urjc.geoprocessing.service.impl;

import es.urjc.geoprocessing.dao.IParentDAO;
import es.urjc.geoprocessing.service.IParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public class ParentServiceImpl<T, ID extends Serializable> implements IParentService<T, ID> {

    @Autowired
    private IParentDAO<T, ID> parentDAO;

    @Override
    public boolean existsById(ID id) {
        return parentDAO.exists(id);
    }

    @Override
    public long count() {
        return parentDAO.count();
    }

    @Override
    public T getOne(ID id) {
        return parentDAO.getOne(id);
    }

    @Override
    public T findById(ID id) {
        return parentDAO.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return parentDAO.findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return parentDAO.findAll(sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return parentDAO.findAll(pageable);
    }

    @Override
    public List<T> findAllById(Iterable<ID> ids) {
        return parentDAO.findAll(ids);
    }

    @Override
    public T save(T entity) {
        return parentDAO.saveAndFlush(entity);
    }

    @Override
    public <S extends T> S saveAndFlush(S entity) {
        return parentDAO.saveAndFlush(entity);
    }

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        return parentDAO.save(entities);
    }

    @Override
    public void delete(T entity) {
        parentDAO.delete(entity);
    }

    @Override
    public void deleteById(ID id) {
        parentDAO.delete(id);
    }

    @Override
    public void deleteInBatch(Iterable<T> entities) {
        parentDAO.deleteInBatch(entities);
    }

    @Override
    public void deleteAll() {
        parentDAO.deleteAll();
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        parentDAO.delete(entities);
    }

    @Override
    public void deleteAllInBatch() {
        parentDAO.deleteAllInBatch();
    }

    @Override
    public void flush() {
        parentDAO.flush();
    }
}
