/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.servico.api;

import com.valhala.gerenciador.batch.modelo.Plataforma;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface PlataformaService {
    
        /**
     *
     * @param plataforma
     */
    void cadastrarPlataforma(final Plataforma plataforma);

    /**
     *
     * @param plataforma
     */
    void atualizarPlataforma(final Plataforma plataforma);

    /**
     *
     * @param plataforma
     */
    void deletarPlataforma(final Plataforma plataforma);
    
    Plataforma buscarPorId(final Serializable id);

    /**
     *
     * @return
     */
    List<Plataforma> listarTodasPlataformas();
    
}
