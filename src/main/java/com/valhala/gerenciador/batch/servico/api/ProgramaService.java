/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.servico.api;

import com.valhala.gerenciador.batch.modelo.Programa;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface ProgramaService {
    
    /**
     *
     * @param programa
     */
    void cadastrarPrograma(final Programa programa);

    /**
     *
     * @param programa
     */
    void atualizarPrograma(final Programa programa);

    /**
     *
     * @param programa
     */
    void deletarPrograma(final Programa programa);

    /**
     *
     * @return
     */
    List<Programa> listarTodosProgramas();
    
    Programa buscarProgramaJuntoComServidor(Programa p);
    
}
