/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.web.mb;

import com.valhala.gerenciador.batch.facade.api.AreaServiceFacade;
import com.valhala.gerenciador.batch.support.interceptors.LogInterceptor;
import com.valhala.gerenciador.batch.support.qualifiers.Logavel;
import com.valhala.gerenciador.batch.vo.AreaVO;
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
@Named("areaMB")
@RequestScoped
@Interceptors({LogInterceptor.class})
public class AreaMB extends BaseMB implements Serializable {

    private AreaVO areaVO;
    private List<AreaVO> areas;
    
    /**
     * Metodo que inicia o bean
     */
    @PostConstruct
    public void init() {
        this.areaVO = new AreaVO();
        areas = montarLista();
    }

    @Inject
    private AreaServiceFacade areaService;

    /**
     * Metodo utilizado para acao de salvar o que foi feito pelo usuario via tela.
     */
    @Logavel
    public void salvar() {
        try {
            if (areaVO.getId() != null && areaVO.getId().intValue() > 0) {
                this.areaService.atualizarArea(areaVO);
                inserirMensagem(FacesMessage.SEVERITY_INFO, "Sucesso", "Area de negocio atualizada com sucesso.");
            } else {
                areaVO.setId(null);
                this.areaService.cadastrarArea(areaVO);
                inserirMensagem(FacesMessage.SEVERITY_INFO, "Sucesso", "Area de negocio inserida com sucesso.");
            } // fim do bloco if/else
        } finally {
            init();
        } // fim do bloco try/catch
    } // fim do metodo salvar                                                     
    
    /**
     *
     * @param areaVO
     */
    public void deletar(AreaVO areaVO) {
        try {
            this.areaService.deletarArea(areaVO);
            inserirMensagem(FacesMessage.SEVERITY_INFO, "Sucesso", "Area de negocio removida com sucesso.");
        } finally {
            init();
        } // fim do bloco try/catch
    } // fim do metodo deletar
    
    /**
     *
     * @param areaVO
     */
    public void editar(AreaVO areaVO) {
        this.areaVO = areaVO;
    }

    /**
     *
     * @return
     */
    public AreaVO getAreaVO() {
        return areaVO;
    }

    /**
     *
     * @param areaVO
     */
    public void setAreaVO(AreaVO areaVO) {
        this.areaVO = areaVO;
    }

    /**
     *
     * @return
     */
    public List<AreaVO> getAreas() {
        return areas;
    }

    /**
     *
     * @param areas
     */
    public void setAreas(List<AreaVO> areas) {
        this.areas = areas;
    }
    
    private List<AreaVO> montarLista()  {
        List<AreaVO> os = this.areaService.listarTodasAreas();
        if (os == null) {
            os = new ArrayList<>();
        } // fim do bloco if
        return os;
    } // fim od metodo montarLista
    
    public void limpar() {
        this.areaVO = new AreaVO();
    }

}
