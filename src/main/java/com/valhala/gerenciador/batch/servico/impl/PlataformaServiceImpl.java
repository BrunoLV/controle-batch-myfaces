/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.servico.impl;

import com.valhala.gerenciador.batch.dao.api.PlataformaDao;
import com.valhala.gerenciador.batch.modelo.Plataforma;
import com.valhala.gerenciador.batch.servico.api.PlataformaService;
import com.valhala.gerenciador.batch.support.interceptors.LogInterceptor;
import com.valhala.gerenciador.batch.support.qualifiers.Logavel;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

/**
 *
 * @author Bruno
 */
@Interceptors({LogInterceptor.class})
public class PlataformaServiceImpl implements PlataformaService {
    
    @Inject
    private PlataformaDao plataformaDao;

    @Override
    @Logavel
    public void cadastrarPlataforma(Plataforma plataforma) {
        plataformaDao.inserir(plataforma);
    }

    @Override
    @Logavel
    public void atualizarPlataforma(Plataforma plataforma) {
        plataformaDao.atualizar(plataforma);
    }

    @Override
    @Logavel
    public void deletarPlataforma(Plataforma plataforma) {
        plataformaDao.deletar(plataforma.getId());
    }

    @Override
    @Logavel
    public List<Plataforma> listarTodasPlataformas() {
        return plataformaDao.listarTodos();
    }

    @Override
    @Logavel
    public Plataforma buscarPorId(Serializable id) {
        return plataformaDao.buscarPorId(id);
    }
    
}
