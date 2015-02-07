/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.facade.api;

import com.valhala.gerenciador.batch.vo.AreaVO;
import java.util.List;

/**
 * Fachada para as regras de negócio que envolvem a entidade Area.
 * @author Bruno
 */
public interface AreaServiceFacade {
    
    /**
     * Metodo para invocar a ação de cadastro de areas.
     * @param areaVO
     */
    void cadastrarArea(final AreaVO areaVO);

    /**
     * Metodo para invocar a ação de atualização de areas.
     * @param areaVO
     */
    void atualizarArea(final AreaVO areaVO);

    /**
     * Metodo para invocar a ação de exclusão de areas.
     * @param areaVO
     */
    void deletarArea(final AreaVO areaVO);

    /**
     * Metodo utilizado para invocar a ação de listagem de areas.
     * @return
     */
    List<AreaVO> listarTodasAreas();
    
} // fim da interface ProgramaServiceFacade