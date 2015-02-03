/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.vo;

import com.valhala.gerenciador.batch.modelo.Area;
import com.valhala.gerenciador.batch.modelo.Plataforma;
import com.valhala.gerenciador.batch.modelo.Programa;
import com.valhala.gerenciador.batch.modelo.Servidor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class ProgramaVO implements Serializable {
    
    private Long id;
    private String nome;
    private PlataformaVO plataforma;
    private AreaVO area;
    private List<ServidorVO> servidores;

    public ProgramaVO() {
        super();
        this.id = null;
        this.nome = null;
        this.plataforma = new PlataformaVO();
        this.area = new AreaVO();
        this.servidores = new ArrayList<>();
    }
    
    public ProgramaVO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
        this.plataforma = new PlataformaVO();
        this.area = new AreaVO();
        this.servidores = new ArrayList<>();
    }

    public ProgramaVO(Long id, String nome, PlataformaVO plataforma, AreaVO area, List<ServidorVO> servidores) {
        this.id = id;
        this.nome = nome;
        this.plataforma = plataforma;
        this.area = area;
        this.servidores = servidores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PlataformaVO getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(PlataformaVO plataforma) {
        this.plataforma = plataforma;
    }

    public AreaVO getArea() {
        return area;
    }

    public void setArea(AreaVO area) {
        this.area = area;
    }

    public List<ServidorVO> getServidores() {
        return servidores;
    }

    public void setServidores(List<ServidorVO> servidores) {
        this.servidores = servidores;
    }

    @Override
    public String toString() {
        return "ProgramaVO{" + "id=" + id + ", nome=" + nome + '}';
    }
    
    /**
     *
     * @param p
     * @return
     */
    public static ProgramaVO createFromModel(final Programa p) {
        ProgramaVO pvo = new ProgramaVO(p.getId(), p.getNome());
        pvo.setArea(p.getArea() != null ? AreaVO.createFromModel(p.getArea()) : new AreaVO());
        pvo.setPlataforma(p.getPlataforma() != null ? PlataformaVO.createFromModel(p.getPlataforma()) : new PlataformaVO());
        List<Servidor> servidores = p.getServidores();
        if (servidores != null && !servidores.isEmpty()) {
            for (Servidor servidor : servidores) {
                ServidorVO svo = ServidorVO.createFromModel(servidor);
                pvo.getServidores().add(svo);
            } // fim do bloco for
        } // fim do bloco if
        return pvo;
    } // fim do metodo createFromModel
    
    /**
     *
     * @param vO
     * @return
     */
    public static Programa returnAsModel(final ProgramaVO vO) {
        Programa p = new Programa(vO.getId(), vO.getNome());
        p.setArea(vO.getArea() != null ? AreaVO.returnAsModel(vO.getArea()) : new Area());
        p.setPlataforma(vO.getPlataforma() != null ? PlataformaVO.returnAsModel(vO.getPlataforma()) : new Plataforma());
        System.out.println("Servidores: " + vO.getServidores());
        List<ServidorVO> svos = vO.getServidores();
        if (svos != null && !svos.isEmpty()) {
            for (ServidorVO svo : svos) {
                Servidor s = ServidorVO.returnAsModel(svo);
                p.getServidores().add(s);
            }
        } // fim do bloco if
        return p;
    } // fim do metodo returnAsModel
    
} // fim da classe ProgramaVO