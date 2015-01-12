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
 */
public interface Dao<T> {
    
    void inserir(T t);
    void atualizar(T t );
    void deletar(Serializable t);
    
    List<T> listarTodos();
    
}
