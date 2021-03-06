/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "tb_servidor")
public class Servidor implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private SistemaOperacional sistemaOperacional;

    /**
     * Construtor
     */
    public Servidor() {
        super();
    }

    /**
     *
     * @param id
     * @param nome
     * @param sistemaOperacional
     */
    public Servidor(Long id, String nome, SistemaOperacional sistemaOperacional) {
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
        return "Servidor{" + "id=" + id + ", nome=" + nome + ", sistemaOperacional=" + sistemaOperacional + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Servidor other = (Servidor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
