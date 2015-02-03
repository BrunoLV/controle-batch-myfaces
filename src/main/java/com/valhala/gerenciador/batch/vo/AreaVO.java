/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.vo;

import com.valhala.gerenciador.batch.modelo.Area;
import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public class AreaVO implements Serializable {
    
    private Long id;
    private String nome;

    /**
     * Construtor
     */
    public AreaVO() {
        super();
    }

    /**
     *
     * @param id
     * @param nome
     */
    public AreaVO(Long id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     *
     * @param a
     * @return
     */
    public static AreaVO createFromModel(final Area a) {
        return new AreaVO(a.getId(), a.getNome());
    }
    
    /**
     *
     * @param vO
     * @return
     */
    public static Area returnAsModel(final AreaVO vO) {
        return new Area(vO.getId(), vO.getNome());
    }
    
}
