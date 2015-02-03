/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.dao.impl;

import com.valhala.gerenciador.batch.dao.api.ProgramaDao;
import com.valhala.gerenciador.batch.modelo.Programa;
import java.io.Serializable;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Bruno
 */
public class ProgramaDaoImpl extends BaseDao<Programa> implements ProgramaDao {

    public ProgramaDaoImpl() {
        classePersistente = Programa.class;
    }

    @Override
    public List<Programa> listarTodos() {
        String jpql = "SELECT p FROM Programa AS p";
        TypedQuery<Programa> tq = em.createQuery(jpql, Programa.class);
        List<Programa> programas = tq.getResultList();
        return programas;
    }

    @Override
    public Programa buscarProgramaTrazendoServidores(Serializable id) {
        String jpql = "SELECT DISTINCT p FROM Programa AS p JOIN FETCH p.servidores WHERE p.id = :id";
        TypedQuery<Programa> tq = em.createQuery(jpql, Programa.class);
        tq.setParameter("id", id);
        Programa p = tq.getSingleResult();
        return p;
    }
    
}
