/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.dao.api;

import java.io.Serializable;
import java.util.List;

/**
 * Interface genérica que define as ações básicas de todos os DAO's do sistema.
 * @author Bruno
 * @param <T>
 */
public interface Dao<T> {
    
    /**
     * Funcionalidade de inclusão.
     * @param t
     */
    void inserir(T t);

    /**
     * Funcionalidade de atualização.
     * @param t
     */
    void atualizar(T t );

    /**
     * Fucionalidade de exclusão.
     * @param t
     */
    void deletar(Serializable t);
    
    /**
     * Funcionalidade de busca por Id.
     * @param id
     * @return
     */
    T buscarPorId(Serializable id);
    
    /**
     * Funcionalidade de listagem.
     * @return
     */
    List<T> listarTodos();
    
} // fim da interface Dao