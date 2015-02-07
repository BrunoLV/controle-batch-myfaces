/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.dao.api;

import com.valhala.gerenciador.batch.modelo.Programa;
import java.io.Serializable;

/**
 * Interface que define o que um DAO faz especificamente com a Entidade Programa.
 * @author Bruno
 */
public interface ProgramaDao extends Dao<Programa> {
    
    /**
     * Método utilizado para buscar um Programa no banco de dados já retornandos os servidores ao qual ele
     * esta vinculado.
     * @param id
     * @return 
     */
    Programa buscarProgramaTrazendoServidores(Serializable id);
    
} // fim da interface ProgramaDao