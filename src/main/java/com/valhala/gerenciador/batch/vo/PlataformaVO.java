/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.vo;

import com.valhala.gerenciador.batch.modelo.Plataforma;
import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public class PlataformaVO implements Serializable {
    
    private Long id;
    private String nome;

    public PlataformaVO() {
        super();
    }

    public PlataformaVO(Long id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
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

    @Override
    public String toString() {
        return "PlataformaVO{" + "id=" + id + ", nome=" + nome + '}';
    }
    
    /**
     *
     * @param p
     * @return
     */
    public static PlataformaVO createFromModel(final Plataforma p) {
        return new PlataformaVO(p.getId(), p.getNome());
        
    }
    
    /**
     *
     * @param vO
     * @return
     */
    public static Plataforma returnAsModel(final PlataformaVO vO) {
        return new Plataforma(vO.getId(), vO.getNome());
    }
    
}
