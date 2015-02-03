/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.facade.impl;

import com.valhala.gerenciador.batch.facade.api.PlataformaServiceFacade;
import com.valhala.gerenciador.batch.modelo.Plataforma;
import com.valhala.gerenciador.batch.servico.api.PlataformaService;
import com.valhala.gerenciador.batch.support.interceptors.LogInterceptor;
import com.valhala.gerenciador.batch.support.interceptors.TransactionInterceptor;
import com.valhala.gerenciador.batch.support.qualifiers.Logavel;
import com.valhala.gerenciador.batch.support.qualifiers.Transacionavel;
import com.valhala.gerenciador.batch.vo.PlataformaVO;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

/**
 *
 * @author Bruno
 */
@Interceptors({LogInterceptor.class, TransactionInterceptor.class})
public class PlataformaServiceFacadeImpl implements PlataformaServiceFacade {
    
    @Inject
    private PlataformaService ps;

    @Override @Logavel @Transacionavel
    public void cadastrarArea(PlataformaVO vO) {
        Plataforma p = PlataformaVO.returnAsModel(vO);
        this.ps.cadastrarPlataforma(p);
    }

    @Override @Logavel @Transacionavel
    public void atualizarArea(PlataformaVO vO) {
        Plataforma p = PlataformaVO.returnAsModel(vO);
        this.ps.atualizarPlataforma(p);
    }

    @Override @Logavel @Transacionavel
    public void deletarArea(PlataformaVO vO) {
        Plataforma p = PlataformaVO.returnAsModel(vO);
        this.ps.deletarPlataforma(p);
    }

    @Override @Logavel
    public List<PlataformaVO> listarTodasPlataformas() {
        List<Plataforma> plataformas;
        List<PlataformaVO> vOs;
        plataformas = this.ps.listarTodasPlataformas();
        vOs = new ArrayList<>();
        for (Plataforma plataforma : plataformas) {
            PlataformaVO vO = PlataformaVO.createFromModel(plataforma);
            vOs.add(vO);
        }
        return vOs;
    }
    
}
