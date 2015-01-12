/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.servico.impl;

import com.valhala.gerenciador.batch.dao.api.AreaDao;
import com.valhala.gerenciador.batch.modelo.Area;
import com.valhala.gerenciador.batch.servico.api.AreaService;
import com.valhala.gerenciador.batch.support.interceptors.LogInterceptor;
import com.valhala.gerenciador.batch.support.interceptors.TransactionInterceptor;
import com.valhala.gerenciador.batch.support.qualifiers.Logavel;
import com.valhala.gerenciador.batch.support.qualifiers.Transacionavel;
import java.util.List;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

/**
 *
 * @author Bruno
 */
@Interceptors({LogInterceptor.class, TransactionInterceptor.class})
public class AreaServiceImpl implements AreaService {

    @Inject
    private AreaDao ad;

    @Override
    @Logavel @Transacionavel
    public void cadastroArea(Area area) {
        try {
            ad.inserir(area);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    @Logavel @Transacionavel
    public void atualizarArea(Area area) {
        ad.atualizar(area);
    }

    @Override
    @Logavel
    public List<Area> listarTodasAreas() {
        return ad.listarTodos();
    }

    @Override
    public void deletarArea(Area area) {
        ad.deletar(area.getId());
    }

}
