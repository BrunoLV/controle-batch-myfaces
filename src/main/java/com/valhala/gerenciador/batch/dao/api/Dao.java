/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.dao.api;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Bruno
 * @param <T>
 */
public interface Dao<T> {
    
    /**
     *
     * @param t
     */
    void inserir(T t);

    /**
     *
     * @param t
     */
    void atualizar(T t );

    /**
     *
     * @param t
     */
    void deletar(Serializable t);
    
    /**
     *
     * @param id
     * @return
     */
    T buscarPorId(Serializable id);
    
    /**
     *
     * @return
     */
    List<T> listarTodos();
    
}
