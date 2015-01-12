/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.dao.impl;

import com.valhala.gerenciador.batch.dao.api.Dao;
import com.valhala.gerenciador.batch.modelo.Area;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Bruno
 * @param <T>
 */
public abstract class BaseDao <T> implements Dao<T> {

    @Inject
    protected EntityManager em;
    
    @Override
    public void inserir(T t) {
        em.persist(t);
    }

    @Override
    public void atualizar(T t) {
        em.merge(t);
    }

    @Override
    public void deletar(Serializable t) {
        em.remove(em.getReference(Area.class, t));
    }
    
    
    
}
