/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.facade.api;

import com.valhala.gerenciador.batch.vo.PlataformaVO;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface PlataformaServiceFacade {
    
    /**
     *
     * @param vO
     */
    void cadastrarArea(final PlataformaVO vO);

    /**
     *
     * @param vO
     */
    void atualizarArea(final PlataformaVO vO);

    /**
     *
     * @param vO
     */
    void deletarArea(final PlataformaVO vO);

    /**
     *
     * @return
     */
    List<PlataformaVO> listarTodasPlataformas();
    
}
