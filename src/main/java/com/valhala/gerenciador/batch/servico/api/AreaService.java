/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.servico.api;

import com.valhala.gerenciador.batch.modelo.Area;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface AreaService {
    
    void cadastroArea(final Area area);
    void atualizarArea(final Area area);
    void deletarArea(final Area area);
    List<Area> listarTodasAreas();
    
}
