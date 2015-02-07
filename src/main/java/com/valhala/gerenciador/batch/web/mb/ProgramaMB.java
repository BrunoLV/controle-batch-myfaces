/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.web.mb;

import com.valhala.gerenciador.batch.facade.api.AreaServiceFacade;
import com.valhala.gerenciador.batch.facade.api.PlataformaServiceFacade;
import com.valhala.gerenciador.batch.facade.api.ProgramaServiceFacade;
import com.valhala.gerenciador.batch.facade.api.ServidorServiceFacade;
import com.valhala.gerenciador.batch.support.qualifiers.Logavel;
import com.valhala.gerenciador.batch.vo.AreaVO;
import com.valhala.gerenciador.batch.vo.PlataformaVO;
import com.valhala.gerenciador.batch.vo.ProgramaVO;
import com.valhala.gerenciador.batch.vo.ServidorVO;
import java.io.Serializable;
import java.util.ArrayList;
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
@Named("programaMB")
@RequestScoped
public class ProgramaMB extends BaseMB implements Serializable {
    
    private ProgramaVO programa;
    private List<ProgramaVO> programas;
    
    private List<AreaVO> areas;
    private List<PlataformaVO> plataformas;
    private List<ServidorVO> servidores;
    
    private String[] servidoresSelecionados;
    
    @Inject 
    private AreaServiceFacade areaService;
    @Inject 
    private ServidorServiceFacade servidorService;
    @Inject 
    private PlataformaServiceFacade plataformaService;
    @Inject 
    private ProgramaServiceFacade programaService;
    
    @PostConstruct
    public void init() {
        programa = new ProgramaVO();
        montarListas();
    }
    
    private void montarListas() {
        this.programas = this.programaService.listarTodosProgramas();
        this.plataformas = this.plataformaService.listarTodasPlataformas();
        this.servidores = this.servidorService.listarTodosServidores();
        this.areas = this.areaService.listarTodasAreas();
        this.servidoresSelecionados = new String[0];
    }

    public String[] getServidoresSelecionados() {
        return servidoresSelecionados;
    }
    
    public void editar(ProgramaVO pvo) {
        this.programa = this.programaService.buscarProgramaComServidores(pvo);
        this.servidoresSelecionados = devolverServidoresRelacionados(this.programa.getServidores().toArray(new ServidorVO[0]));
    }

    public void setServidoresSelecionados(String[] servidoresSelecionados) {
        this.servidoresSelecionados = servidoresSelecionados;
    } 
   
    public List<AreaVO> getAreas() {
        return areas;
    }

    public void setAreas(List<AreaVO> areas) {
        this.areas = areas;
    }

    public List<PlataformaVO> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(List<PlataformaVO> plataformas) {
        this.plataformas = plataformas;
    }

    public List<ServidorVO> getServidores() {
        return servidores;
    }

    public void setServidores(List<ServidorVO> servidores) {
        this.servidores = servidores;
    }

    public ProgramaVO getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaVO programa) {
        this.programa = programa;
    }

    public List<ProgramaVO> getProgramas() {
        return programas;
    }

    public void setProgramas(List<ProgramaVO> programas) {
        this.programas = programas;
    }
    
    private List<ServidorVO> gerarListaServidores() {
        List<ServidorVO> svos = new ArrayList<>();
        for (String valor : servidoresSelecionados) {
            ServidorVO svo = new  ServidorVO(Long.parseLong(valor), null, null);
            svos.add(svo);
        }
        return svos;
    }
    
    @Logavel
    public void salvar() {
        this.programa.setServidores(gerarListaServidores());
        try {
            if (this.programa.getId() != null && this.programa.getId() > 0) {
                this.programaService.atualizarPrograma(programa);
                inserirMensagem(FacesMessage.SEVERITY_INFO, "Sucesso", "Programa atualizado com sucesso.");
            } else {
                this.programa.setId(null);
                this.programaService.cadastrarPrograma(this.programa);
                inserirMensagem(FacesMessage.SEVERITY_INFO, "Sucesso", "Programa incluido com sucesso.");
            }
        } finally {
            init();
        }
    }
    
    public void deletar(ProgramaVO pvo) {
        try {
            this.programaService.deletarPrograma(pvo);
            inserirMensagem(FacesMessage.SEVERITY_INFO, "Sucesso", "Programa removido com sucesso.");
        } finally {
            init();
        }
    }
    
    /*
    Metodo utilizado para retornar em forma de Array os id de Servidores relacionados.
    */
    private String[] devolverServidoresRelacionados(ServidorVO[] svos) {
        String[] array = new String[svos.length];
        for (int i = 0; i < svos.length; i++) {
            array[i] = String.valueOf(svos[i].getId());
        } // fim do bloco for
        return array;
    } // fim do metodo devolverServidoresRelacionados
    
    public void limpar() {
        this.programa = new ProgramaVO();
        this.servidoresSelecionados = new String[0];
    }
    
}
