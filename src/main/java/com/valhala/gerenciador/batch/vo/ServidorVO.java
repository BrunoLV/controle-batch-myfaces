/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.vo;

import com.valhala.gerenciador.batch.modelo.Servidor;
import com.valhala.gerenciador.batch.modelo.SistemaOperacional;
import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public class ServidorVO implements Serializable {
    
    private Long id;
    private String nome;
    private SistemaOperacional sistemaOperacional;

    /**
     * Construtor
     */
    public ServidorVO() {
        super();
    }

    /**
     *
     * @param id
     * @param nome
     * @param sistemaOperacional
     */
    public ServidorVO(Long id, String nome, SistemaOperacional sistemaOperacional) {
        super();
        this.id = id;
        this.nome = nome;
        this.sistemaOperacional = sistemaOperacional;
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
     * @return
     */
    public SistemaOperacional getSistemaOperacional() {
        return sistemaOperacional;
    }

    /**
     *
     * @param sistemaOperacional
     */
    public void setSistemaOperacional(SistemaOperacional sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }
    
    @Override
    public String toString() {
        return "ServidorVO{" + "id=" + id + ", nome=" + nome + ", sistemaOperacional=" + sistemaOperacional + '}';
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static ServidorVO createFromModel(final Servidor s) {
        return new ServidorVO(s.getId(), s.getNome(), s.getSistemaOperacional());
    }
    
    /**
     *
     * @param vO
     * @return
     */
    public static Servidor returnAsModel(final ServidorVO vO) {
        return new Servidor(vO.getId(), vO.getNome(), vO.getSistemaOperacional());
    }
    
}
