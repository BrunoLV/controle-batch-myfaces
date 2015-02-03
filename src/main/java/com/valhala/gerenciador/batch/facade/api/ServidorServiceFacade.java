/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.facade.api;

import com.valhala.gerenciador.batch.vo.ServidorVO;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface ServidorServiceFacade {
    
    /**
     *
     * @param vO
     */
    void cadastrarServidor(final ServidorVO vO);

    /**
     *
     * @param vO
     */
    void atualizarServidor(final ServidorVO vO);

    /**
     *
     * @param vO
     */
    void deletarServidor(final ServidorVO vO);

    /**
     *
     * @return
     */
    List<ServidorVO> listarTodosServidores();
    
}
