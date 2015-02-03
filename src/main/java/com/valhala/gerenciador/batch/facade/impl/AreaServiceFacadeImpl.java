/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.facade.impl;

import com.valhala.gerenciador.batch.facade.api.AreaServiceFacade;
import com.valhala.gerenciador.batch.modelo.Area;
import com.valhala.gerenciador.batch.servico.api.AreaService;
import com.valhala.gerenciador.batch.support.interceptors.LogInterceptor;
import com.valhala.gerenciador.batch.support.interceptors.TransactionInterceptor;
import com.valhala.gerenciador.batch.support.qualifiers.Transacionavel;
import com.valhala.gerenciador.batch.vo.AreaVO;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

/**
 * Classe de fachada para chamar os metodos de negocio existentes na aplicacao.
 * @author Bruno
 */
@Interceptors({LogInterceptor.class, TransactionInterceptor.class})
public class AreaServiceFacadeImpl implements AreaServiceFacade {
    
    @Inject
    private AreaService as;

    @Override @Transacionavel
    public void cadastrarArea(AreaVO areaVO) {
        Area a;
        a = AreaVO.returnAsModel(areaVO);
        this.as.cadastrarArea(a);
    } // fim do metodo cadastrarArea

    @Override @Transacionavel
    public void atualizarArea(AreaVO areaVO) {
        Area a;
        a = AreaVO.returnAsModel(areaVO);
        this.as.atualizarArea(a);
    } // fim do metodo atualizarArea

    @Override @Transacionavel
    public void deletarArea(AreaVO areaVO) {
        Area a;
        a = AreaVO.returnAsModel(areaVO);
        this.as.deletarArea(a);
    } // fim do metodo deletarArea

    @Override
    public List<AreaVO> listarTodasAreas() {
        List<Area> areas;
        List<AreaVO> areaVOs;
        areas = this.as.listarTodasAreas();
        areaVOs = new ArrayList<>();
        for (Area a : areas) {
            AreaVO o = AreaVO.createFromModel(a);
            areaVOs.add(o);
        } // fim do bloco for
        return areaVOs;
    } // fim do metodo listarTodas
    
} // fim da classe AreaServiceImpl