/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.facade.impl;

import com.valhala.gerenciador.batch.facade.api.ProgramaServiceFacade;
import com.valhala.gerenciador.batch.modelo.Programa;
import com.valhala.gerenciador.batch.modelo.Servidor;
import com.valhala.gerenciador.batch.servico.api.AreaService;
import com.valhala.gerenciador.batch.servico.api.PlataformaService;
import com.valhala.gerenciador.batch.servico.api.ProgramaService;
import com.valhala.gerenciador.batch.servico.api.ServidorService;
import com.valhala.gerenciador.batch.support.interceptors.LogInterceptor;
import com.valhala.gerenciador.batch.support.interceptors.TransactionInterceptor;
import com.valhala.gerenciador.batch.support.qualifiers.Logavel;
import com.valhala.gerenciador.batch.support.qualifiers.Transacionavel;
import com.valhala.gerenciador.batch.vo.ProgramaVO;
import com.valhala.gerenciador.batch.vo.ServidorVO;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

/**
 *
 * @author Bruno
 */
@Interceptors({LogInterceptor.class, TransactionInterceptor.class})
public class ProgramaServiceFacadeImpl implements ProgramaServiceFacade {

    @Inject 
    private ProgramaService programaService;
    @Inject 
    private AreaService areaService;
    @Inject 
    private PlataformaService plataformaService;
    @Inject 
    private ServidorService servidorService;
    
    @Override @Logavel @Transacionavel
    public void cadastrarPrograma(ProgramaVO vO) {
        Programa p = montarPrograma(vO);
        this.programaService.cadastrarPrograma(p);
    } // fim do metodo cadastrarPrograma

    @Override @Logavel @Transacionavel
    public void atualizarPrograma(ProgramaVO vO) {
        Programa p = montarPrograma(vO);
        this.programaService.atualizarPrograma(p);
    }

    @Override @Logavel @Transacionavel
    public void deletarPrograma(ProgramaVO vO) {
        Programa p = ProgramaVO.returnAsModel(vO);
        this.programaService.deletarPrograma(p);
    }

    @Override @Logavel
    public List<ProgramaVO> listarTodosProgramas() {
        List<Programa> programas;
        List<ProgramaVO> vOs;
        programas = this.programaService.listarTodosProgramas();
        vOs = new ArrayList<>();
        for (Programa programa : programas) {
            ProgramaVO vO = ProgramaVO.createFromModel(programa);
            vOs.add(vO);
        }
        return vOs;
    }

    @Override @Logavel
    public ProgramaVO buscarProgramaComServidores(ProgramaVO programaVO) {
        Programa p = ProgramaVO.returnAsModel(programaVO);
        p = this.programaService.buscarProgramaJuntoComServidor(p);
        ProgramaVO pvo = ProgramaVO.createFromModel(p);
        return pvo;
    }
    
    private Programa montarPrograma(ProgramaVO vO) {
        Programa p = new Programa(vO.getId(), vO.getNome());
        p.setArea(areaService.buscarPorId(vO.getArea().getId()));
        p.setPlataforma(plataformaService.buscarPorId(vO.getPlataforma().getId()));
        List<ServidorVO> vOs = vO.getServidores();
        for (ServidorVO vO1 : vOs) {
            Servidor s = servidorService.buscarPorId(vO1.getId());
            if (!p.getServidores().contains(s)) {
                p.getServidores().add(s);   
            } // fim do bloco if
        } // fim do bloco for
        return p;
    }
    
}
