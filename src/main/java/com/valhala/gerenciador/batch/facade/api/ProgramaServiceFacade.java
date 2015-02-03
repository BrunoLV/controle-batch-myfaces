/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.facade.api;

import com.valhala.gerenciador.batch.vo.ProgramaVO;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface ProgramaServiceFacade {
 
    /**
     *
     * @param vO
     */
    void cadastrarPrograma(final ProgramaVO vO);

    /**
     *
     * @param vO
     */
    void atualizarPrograma(final ProgramaVO vO);

    /**
     *
     * @param vO
     */
    void deletarPrograma(final ProgramaVO vO);

    /**
     *
     * @return
     */
    List<ProgramaVO> listarTodosProgramas();
    
    ProgramaVO buscarProgramaComServidores(ProgramaVO programaVO);
    
}
