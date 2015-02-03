/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.facade.api;

import com.valhala.gerenciador.batch.vo.AreaVO;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface AreaServiceFacade {
    
    /**
     *
     * @param areaVO
     */
    void cadastrarArea(final AreaVO areaVO);

    /**
     *
     * @param areaVO
     */
    void atualizarArea(final AreaVO areaVO);

    /**
     *
     * @param areaVO
     */
    void deletarArea(final AreaVO areaVO);

    /**
     *
     * @return
     */
    List<AreaVO> listarTodasAreas();
    
}
