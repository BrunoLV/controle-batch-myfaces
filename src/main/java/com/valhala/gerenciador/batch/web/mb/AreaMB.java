/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.web.mb;

import com.valhala.gerenciador.batch.modelo.Area;
import com.valhala.gerenciador.batch.servico.api.AreaService;
import com.valhala.gerenciador.batch.support.interceptors.LogInterceptor;
import com.valhala.gerenciador.batch.support.qualifiers.Logavel;
import com.valhala.gerenciador.batch.web.mb.vo.AreaVO;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Bruno
 */
@Named("areaMB")
@RequestScoped
@Interceptors({LogInterceptor.class})
public class AreaMB implements Serializable {

    private AreaVO areaVO;
    private List<AreaVO> areas;
    
    @PostConstruct
    public void init() {
        System.out.println("Iniciando areaVO");
        this.areaVO = new AreaVO();
        System.out.println("Iniciando lista");
        areas = montarLista();
    }

    @Inject
    private AreaService as;

    @Logavel
    public void salvar() {
        try {
            System.out.println("Servico: " + as.toString());
            Area area = new Area();
            BeanUtils.copyProperties(area, areaVO);
            if (area.getId() != null && area.getId().intValue() > 0) {
                this.as.atualizarArea(area);
            } else {
                area.setId(null);
                this.as.cadastroArea(area);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            init();
        }
    }
    
    public void deletar(AreaVO areaVO) {
        try {
            System.out.println("Servico: " + as.toString());
            Area area = new Area();
            BeanUtils.copyProperties(area, areaVO);
            this.as.deletarArea(area);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            init();
        }
    }
    
    public void editar(AreaVO areaVO) {
        this.areaVO = areaVO;
    }

    public AreaVO getAreaVO() {
        return areaVO;
    }

    public void setAreaVO(AreaVO areaVO) {
        this.areaVO = areaVO;
    }

    public List<AreaVO> getAreas() {
        return areas;
    }

    public void setAreas(List<AreaVO> areas) {
        this.areas = areas;
    }
    
    private List<AreaVO> montarLista()  {
        List<AreaVO> os = new ArrayList<>();
        List<Area> lista;
        lista = this.as.listarTodasAreas();
        for (Area a : lista) {
            AreaVO o = new AreaVO();
            try {
                BeanUtils.copyProperties(o, a);
            } catch (IllegalAccessException | InvocationTargetException ex) {
                Logger.getLogger(AreaMB.class.getName()).log(Level.SEVERE, null, ex);
            }
            os.add(o);
        }
        return os;
    }

}
