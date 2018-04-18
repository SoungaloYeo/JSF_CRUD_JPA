/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.service.Impl;

import com.parc.dao.Impl.DAO;
import com.parc.service.IService;
import java.io.Serializable;
import java.util.List;
import com.parc.dao.IDAO;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author yeo_sglo
 * @param <T>
 * @param <PK>
 */
public abstract class Service<T, PK extends Serializable> implements IService<T, PK> {

    protected IDAO<T, PK> dao;
    Collection<T> collection;
    Class<T> maClasse;

    public Service() {
    }

    
    public Service(IDAO<T, PK> dao) {
        this.maClasse = maClasse;
        this.dao = dao;
    }

    @Override
    public T save(T t) {
        return dao.save(t);
    }

    @Override
    public T update(T t) {
        return dao.update(t);
    }

    @Override
    public boolean delete(T t) {
        return dao.delete(t);
    }

    @Override
    public List<T> findAll() {
        return dao.findAll();
    }

    @Override
    public Long count() {
        return dao.count();
    }

    @Override
    public boolean deleteAll() {
        return dao.deleteAll();
    }

    @Override
    public boolean delete(PK pk) {
        return dao.delete(pk);
    }

    @Override
    public T findOne(PK pk) {
        return (T) dao.findOne(pk);
    }

    @Override
    public Collection<T> saveRenge(Collection<T> t) {
        collection = new LinkedList<>();
        Iterator<T> iterator = t.iterator();
        while (iterator.hasNext()) {
            T next = iterator.next();
            dao.save(next);
            collection.add(dao.save(next));
        }
        return collection;
    }
    //test
//    public Iterator<T> saveRenge(Iterator<T> t) {
//        
//    }

    @Override
    public boolean deleteRange(Collection<T> t) {
         Iterator iterator = t.iterator();
         while (iterator.hasNext()) {
           T next = (T) iterator.next();
           dao.delete(next);            
        }
         return true;
    }

    @Override
    public List<T> findAll(String sortProperty) {
        return dao.findAll(sortProperty, true);
    }

    @Override
    public List<T> findAll(String sortProperty, boolean sortOrder) {
        return dao.findAll(sortProperty, sortOrder);
    }

}
