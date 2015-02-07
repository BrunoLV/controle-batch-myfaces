/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.dao.impl;

import com.valhala.gerenciador.batch.dao.api.PlataformaDao;
import com.valhala.gerenciador.batch.modelo.Plataforma;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 * Implementacao de PlataformaDao
 * @author Bruno
 */
public class PlataformaDaoImpl extends BaseDao<Plataforma> implements PlataformaDao {

    public PlataformaDaoImpl() {
        super();
        classePersistente = Plataforma.class;
    } // fim do construtor
    
    @Override
    public List<Plataforma> listarTodos() {
        String jpql = "SELECT p FROM Plataforma AS p";
        TypedQuery<Plataforma> tq = em.createQuery(jpql, Plataforma.class);
        List<Plataforma> plataformas = tq.getResultList();
        return plataformas;
    } // fim do metodo listarTodos
    
} // fim da classe PlataformaDaoImpl