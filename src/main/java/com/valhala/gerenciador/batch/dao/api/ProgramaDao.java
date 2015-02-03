/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.dao.api;

import com.valhala.gerenciador.batch.modelo.Programa;
import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public interface ProgramaDao extends Dao<Programa> {
    
    Programa buscarProgramaTrazendoServidores(Serializable id);
    
}
