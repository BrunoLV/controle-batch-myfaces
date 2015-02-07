/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.web.mb;

import com.valhala.gerenciador.batch.facade.api.PlataformaServiceFacade;
import com.valhala.gerenciador.batch.support.interceptors.LogInterceptor;
import com.valhala.gerenciador.batch.support.qualifiers.Logavel;
import com.valhala.gerenciador.batch.vo.PlataformaVO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;

/**
 *
 * @author Bruno
 */
@Named("plataformaMB")
@RequestScoped
@Interceptors({LogInterceptor.class})
public class PlataformaMB extends BaseMB implements Serializable {
    
    private PlataformaVO plataformaVO;
    private List<PlataformaVO> plataformas;
    
    @Inject
    private PlataformaServiceFacade plataformaService;
    
    @PostConstruct
    public void init() {
        this.plataformaVO = new PlataformaVO();
        this.plataformas = montarLista();
    }

    public PlataformaVO getPlataformaVO() {
        return plataformaVO;
    }

    public void setPlataformaVO(PlataformaVO plataformaVO) {
        this.plataformaVO = plataformaVO;
    }

    public List<PlataformaVO> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(List<PlataformaVO> plataformas) {
        this.plataformas = plataformas;
    }
    
    /**
     * Metodo utilizado para acao de salvar o que foi feito pelo usuario via tela.
     */
    @Logavel
    public void salvar() {
        try {
            if (plataformaVO.getId() != null && plataformaVO.getId().intValue() > 0) {
                this.plataformaService.atualizarArea(plataformaVO);
                inserirMensagem(FacesMessage.SEVERITY_INFO, "Sucesso", "Plataforma atualizada com sucesso.");
            } else {
                plataformaVO.setId(null);
                this.plataformaService.cadastrarArea(plataformaVO);
                inserirMensagem(FacesMessage.SEVERITY_INFO, "Sucesso", "Plataforma inserida com sucesso.");
            } // fim do bloco if/else
        } finally {
            init();
        } // fim do bloco try/catch
    } // fim do metodo salvar                                                     
    
    /**
     *
     * @param plataformaVO
     */
    public void deletar(PlataformaVO plataformaVO) {
        try {
            this.plataformaService.deletarArea(plataformaVO);
            inserirMensagem(FacesMessage.SEVERITY_INFO, "Sucesso", "Plataforma removida com sucesso.");
        } finally {
            init();
        } // fim do bloco try/catch
    } // fim do metodo deletar
    
    /**
     *
     * @param plataformaVO
     */
    public void editar(PlataformaVO plataformaVO) {
        this.plataformaVO = plataformaVO;
    }
    
    private List<PlataformaVO> montarLista() {
        List<PlataformaVO> vOs = this.plataformaService.listarTodasPlataformas();
        if (vOs == null) {
            vOs = new ArrayList<>();
        }
        return vOs;
    }
    
    public void limpar() {
        this.plataformaVO = new PlataformaVO();
    }
     
}
