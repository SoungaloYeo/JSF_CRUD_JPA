/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parc.dao.Impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.parc.dao.IDAO;

/**
 *
 * @author yeo_sglo la classe Service comporte la logic Metier commune à toute
 * nos classe d'ou l'implementation des methodes du CRUD
 * @param <T>
 * @param <PK>
 */
public abstract class DAO<T, PK extends Serializable> implements IDAO<T, PK> {

    protected EntityManager em = SingletonEMF.getEntityManagerFactory().createEntityManager();

    /**
     * pour le gestion dynamique des classes pouvant contenir le parametre T de
     * notre classe, nous utilisons l'API Reflexion à fin de permetre
     * l'introspection:charger une classe ou même creer une instance sans
     * connaitre cette classe à fin de beneficier de ces savoir faire
     */
    private final Class<T> entityClass;

    /**
     * un constructure de la classe Service qui prend en parametre un objet
     * toujour avec l'API Reflexion declaré dynamy
     *
     * @param entityClass represente la classe sur laquelle portera le
     * traitement
     */
    public DAO(Class<T> entityClass) {
        this.entityClass = entityClass;
        em = SingletonEMF.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public T save(T t) {
        em.getTransaction().begin();
        em.persist(t);
        em.flush();
        em.getTransaction().commit();
//        em.close();
        return t;
    }

    @Override
    public T update(T t) {
        em.getTransaction().begin();
        em.merge(t);
        em.flush();
        em.getTransaction().commit();
//        em.close();
        return t;
    }

    @Override
    public boolean delete(T t) {
        em.getTransaction().begin();
        em.remove(t);
        em.flush();
        em.getTransaction().commit();
//        em.close();
        return true;
    }

    @Override
    public boolean delete(PK pk) {
        T t = em.find(entityClass, pk);
        if (t != null) {
            em.getTransaction().begin();
            em.remove(t);
            em.flush();
            em.getTransaction().commit();
//            em.close();
            return true;
        }
        return true;
    }

    @Override
    @SuppressWarnings("JPQLValidation")
    public boolean deleteAll() {
        em.getTransaction().begin();
        int executQ = em.createQuery("DELETE FROM " + entityClass.getSimpleName()).executeUpdate();
        em.flush();
        em.getTransaction().commit();
//        em.close();
        return (executQ >= 0);
    }

    @Override
    @SuppressWarnings("JPQLValidation")
    public Long count() {
        return (Long) em.createQuery("SELECT COUNT (t) FROM " + entityClass.getSimpleName() + " t").getSingleResult();
    }

    @Override
    public T findOne(PK pk) {
        return em.find(entityClass, pk);
    }

    @Override
    @SuppressWarnings("JPQLValidation")
    public List<T> findAll() {
        return em.createQuery("SELECT t FROM " + entityClass.getSimpleName() + " t").getResultList();
    }

    @Override
    public List<T> findAll(String sortProperty, boolean sortOrder) {
        return em.createQuery("SELECT t FROM " + entityClass.getSimpleName()
                + " t ORDER BY t." + sortProperty + " " + ((!sortOrder) ? "DESC" : "ASC")).getResultList();
    }

    @Override
    public List<T> executeQuery(Query query) {
        return (List<T>) query.getResultList();
    }

}
