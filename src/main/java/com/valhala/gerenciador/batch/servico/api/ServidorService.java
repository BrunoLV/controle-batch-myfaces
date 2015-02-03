/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.servico.api;

import com.valhala.gerenciador.batch.modelo.Servidor;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface ServidorService {
    
            /**
     *
     * @param servidor
     */
    void cadastrarServidor(final Servidor servidor);

    /**
     *
     * @param servidor
     */
    void atualizarServidor(final Servidor servidor);

    /**
     *
     * @param servidor
     */
    void deletarServidor(final Servidor servidor);
    
    Servidor buscarPorId(final Serializable id);

    /**
     *
     * @return
     */
    List<Servidor> listarTodosServidores();
    
}
