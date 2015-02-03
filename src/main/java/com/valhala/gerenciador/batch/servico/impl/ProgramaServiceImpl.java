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
    private ProgramaDao pd;
    
    @Override
    @Logavel
    public void cadastrarPrograma(Programa programa) {
        pd.inserir(programa);
    }

    @Override
    @Logavel
    public void atualizarPrograma(Programa programa) {
        pd.atualizar(programa);
    }

    @Override
    @Logavel
    public void deletarPrograma(Programa programa) {
        pd.deletar(programa.getId());
    }

    @Override
    @Logavel
    public List<Programa> listarTodosProgramas() {
        return pd.listarTodos();
    }

    @Override
    @Logavel
    public Programa buscarProgramaJuntoComServidor(Programa p) {
        return pd.buscarProgramaTrazendoServidores(p.getId());
    }
    
}
