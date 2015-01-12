/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.web.mb.vo;

import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public class AreaVO implements Serializable {
    
    private Long id;
    private String nome;

    public AreaVO() {
        super();
    }

    public AreaVO(Long id, String nome) {
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
    
}
