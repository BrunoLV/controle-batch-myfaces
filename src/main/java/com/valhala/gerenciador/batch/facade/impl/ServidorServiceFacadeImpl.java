/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.facade.impl;

import com.valhala.gerenciador.batch.facade.api.ServidorServiceFacade;
import com.valhala.gerenciador.batch.modelo.Servidor;
import com.valhala.gerenciador.batch.servico.api.ServidorService;
import com.valhala.gerenciador.batch.support.interceptors.TransactionInterceptor;
import com.valhala.gerenciador.batch.support.qualifiers.Logavel;
import com.valhala.gerenciador.batch.support.qualifiers.Transacionavel;
import com.valhala.gerenciador.batch.vo.ServidorVO;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

/**
 *
 * @author Bruno
 */
@Interceptors({TransactionInterceptor.class})
public class ServidorServiceFacadeImpl implements ServidorServiceFacade {
    
    @Inject
    private ServidorService servidorService;

    @Override @Logavel @Transacionavel
    public void cadastrarServidor(ServidorVO vO) {
        Servidor p = ServidorVO.returnAsModel(vO);
        this.servidorService.cadastrarServidor(p);
    }

    @Override @Logavel @Transacionavel
    public void atualizarServidor(ServidorVO vO) {
        Servidor p = ServidorVO.returnAsModel(vO);
        this.servidorService.atualizarServidor(p);
    }

    @Override @Logavel @Transacionavel
    public void deletarServidor(ServidorVO vO) {
        Servidor p = ServidorVO.returnAsModel(vO);
        this.servidorService.deletarServidor(p);
    }

    @Override @Logavel
    public List<ServidorVO> listarTodosServidores() {
        List<Servidor> servidores;
        List<ServidorVO> vOs;
        servidores = this.servidorService.listarTodosServidores();
        vOs = new ArrayList<>();
        for (Servidor servidor : servidores) {
            ServidorVO vO = ServidorVO.createFromModel(servidor);
            vOs.add(vO);
        }
        return vOs;
    }
    
}
