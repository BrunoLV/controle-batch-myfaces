/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.dao.impl;

import com.valhala.gerenciador.batch.dao.api.ServidorDao;
import com.valhala.gerenciador.batch.modelo.Servidor;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Bruno
 */
public class ServidorDaoImpl extends BaseDao<Servidor> implements ServidorDao {

    public ServidorDaoImpl() {
        classePersistente =  Servidor.class;
    }
    
    @Override
    public List<Servidor> listarTodos() {
        String jpql = "SELECT s FROM Servidor AS s";
        TypedQuery tq = em.createQuery(jpql, Servidor.class);
        List<Servidor> servidores = tq.getResultList();
        return servidores;
    }
    
}
