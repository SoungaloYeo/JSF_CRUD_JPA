/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author yeo_sglo IService est une interface generique qui comporte la
 * declaration des methodes du CRUD communes à toutes les classes.
 * @param <T>
 * @param <PK>
 */
public interface IService<T, PK extends Serializable> {

    public Long count();

    public T save(final T t);
    
    public Collection<T> saveRenge( Collection<T> t);

    public T update(final T t);

    public boolean deleteAll();

    public boolean delete(final T t);
    
    public boolean delete(final PK pk);

    public boolean deleteRange(final Collection<T> t);

    public T findOne(final PK pk);

    public List<T> findAll();

    public List<T> findAll(String sortProperty);
    
    public List<T> findAll(String sortProperty, boolean sortOrder);
    
}
