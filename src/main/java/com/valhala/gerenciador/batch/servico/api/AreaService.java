/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.servico.api;

import com.valhala.gerenciador.batch.modelo.Area;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface AreaService {
    
    /**
     *
     * @param area
     */
    void cadastrarArea(final Area area);

    /**
     *
     * @param area
     */
    void atualizarArea(final Area area);

    /**
     *
     * @param area
     */
    void deletarArea(final Area area);

    Area buscarPorId(final Serializable id);
    
    /**
     *
     * @return
     */
    List<Area> listarTodasAreas();
    
}
