/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.modelo;

/**
 *
 * @author Bruno
 */
public enum SistemaOperacional {
    
    /**
     *
     */
    WINDOWS("Windows"),

    /**
     *
     */
    LINUX("Linux"),

    /**
     *
     */
    UNIX("Unix");
    
    private String nome;

    private SistemaOperacional(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
}
