/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.servico.impl;

import com.valhala.gerenciador.batch.dao.api.ProgramaDao;
import com.valhala.gerenciador.batch.modelo.Programa;
import com.valhala.gerenciador.batch.servico.api.ProgramaService;
import com.valhala.gerenciador.batch.support.qualifiers.Logavel;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Bruno
 */
public class ProgramaServiceImpl implements ProgramaService {
    
    @Inject
    private ProgramaDao programaDao;
    
    @Override
    @Logavel
    public void cadastrarPrograma(Programa programa) {
        programaDao.inserir(programa);
    }

    @Override
    @Logavel
    public void atualizarPrograma(Programa programa) {
        programaDao.atualizar(programa);
    }

    @Override
    @Logavel
    public void deletarPrograma(Programa programa) {
        programaDao.deletar(programa.getId());
    }

    @Override
    @Logavel
    public List<Programa> listarTodosProgramas() {
        return programaDao.listarTodos();
    }

    @Override
    @Logavel
    public Programa buscarProgramaJuntoComServidor(Programa p) {
        return programaDao.buscarProgramaTrazendoServidores(p.getId());
    }
    
}
