/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.dao.impl;

import com.valhala.gerenciador.batch.dao.api.AreaDao;
import com.valhala.gerenciador.batch.modelo.Area;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Bruno
 */
public class AreaDaoImpl extends BaseDao<Area> implements AreaDao {

    public AreaDaoImpl() {
        super();
        classePersistente = Area.class;
    }
    
    @Override
    public List<Area> listarTodos() {
        String jpql = "SELECT a FROM Area AS a";
        TypedQuery<Area> tq = em.createQuery(jpql, Area.class);
        List<Area> areas = tq.getResultList();
        return areas;
    }
    
}
