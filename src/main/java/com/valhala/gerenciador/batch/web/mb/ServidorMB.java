/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.web.mb;

import com.valhala.gerenciador.batch.facade.api.ServidorServiceFacade;
import com.valhala.gerenciador.batch.modelo.SistemaOperacional;
import com.valhala.gerenciador.batch.support.qualifiers.Logavel;
import com.valhala.gerenciador.batch.vo.ServidorVO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Bruno
 */
@Named("servidorMB")
@RequestScoped

public class ServidorMB extends BaseMB implements Serializable {
    
    private ServidorVO servidorVO;
    private List<ServidorVO> servidores;
    
    @Inject
    private ServidorServiceFacade ssf;
    
    @PostConstruct
    public void init() {
        this.servidorVO = new ServidorVO();
        this.servidores = montarLista();
    }

    public ServidorVO getServidorVO() {
        return servidorVO;
    }

    public void setServidorVO(ServidorVO servidorVO) {
        this.servidorVO = servidorVO;
    }

    public List<ServidorVO> getServidores() {
        return servidores;
    }

    public void setServidores(List<ServidorVO> servidores) {
        this.servidores = servidores;
    }
    
    /**
     * Metodo utilizado para acao de salvar o que foi feito pelo usuario via tela.
     */
    @Logavel
    public void salvar() {
        try {
            if (servidorVO.getId() != null && servidorVO.getId().intValue() > 0) {
                this.ssf.atualizarServidor(servidorVO);
                inserirMensagem(FacesMessage.SEVERITY_INFO, "Sucesso", "Servidor de negocio atualizada com sucesso.");
            } else {
                servidorVO.setId(null);
                this.ssf.cadastrarServidor(servidorVO);
                inserirMensagem(FacesMessage.SEVERITY_INFO, "Sucesso", "Servidor de negocio inserida com sucesso.");
            } // fim do bloco if/else
        } finally {
            init();
        } // fim do bloco try/catch
    } // fim do metodo salvar                                                     
    
    /**
     *
     * @param servidorVO
     */
    public void deletar(ServidorVO servidorVO) {
        try {
            this.ssf.deletarServidor(servidorVO);
            inserirMensagem(FacesMessage.SEVERITY_INFO, "Sucesso", "Servidor de negocio removida com sucesso.");
        } finally {
            init();
        } // fim do bloco try/catch
    } // fim do metodo deletar
    
    public void limpar() {
        this.servidorVO = new ServidorVO();
    }
    
    /**
     *
     * @param servidorVO
     */
    public void editar(ServidorVO servidorVO) {
        this.servidorVO = servidorVO;
    }
    
    private List<ServidorVO> montarLista() {
        List<ServidorVO> vOs = this.ssf.listarTodosServidores();
        if (vOs == null) {
            vOs = new ArrayList<>();
        }
        return vOs;
    }
    
    public List<SistemaOperacional> getSistemasOperacionais() {
        return Arrays.asList(SistemaOperacional.values());
    }
    
}
