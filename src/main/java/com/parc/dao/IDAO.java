/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author yeo_sglo
 * @param <T>
 * @param <PK>
 */
public interface IDAO<T, PK extends Serializable> {

    public Long count();

    public T save(final T t);

    public T update(final T t);

    public boolean deleteAll();

    public boolean delete(final T t);
    
//    public boolean delete(final Collection<T> t);

    public boolean delete(final PK pk);
    
    public List<T> executeQuery(Query query);

    public T findOne(final PK pk);

    public List<T> findAll();

    public List<T> findAll(String sortProperty, boolean sortOrder);

}
