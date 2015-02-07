/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.servico.impl;

import com.valhala.gerenciador.batch.dao.api.ServidorDao;
import com.valhala.gerenciador.batch.modelo.Servidor;
import com.valhala.gerenciador.batch.servico.api.ServidorService;
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
public class ServidorServiceImpl implements ServidorService {
    
    @Inject
    private ServidorDao servidorDao;

    @Override
    @Logavel
    public void cadastrarServidor(Servidor servidor) {
        servidorDao.inserir(servidor);
    }

    @Override
    @Logavel
    public void atualizarServidor(Servidor servidor) {
        servidorDao.atualizar(servidor);
    }

    @Override
    @Logavel
    public void deletarServidor(Servidor servidor) {
        servidorDao.deletar(servidor.getId());
    }

    @Override
    @Logavel
    public List<Servidor> listarTodosServidores() {
        return servidorDao.listarTodos();
    }

    @Override
    @Logavel
    public Servidor buscarPorId(Serializable id) {
        return servidorDao.buscarPorId(id);
    }
    
}
