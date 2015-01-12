/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.modelo;

import java.io.Serializable;
import javax.inject.Inject;
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
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private SistemaOperacional sistemaOperacional;

    public Servidor() {
        super();
    }

    public Servidor(Long id, String nome, SistemaOperacional sistemaOperacional) {
        super();
        this.id = id;
        this.nome = nome;
        this.sistemaOperacional = sistemaOperacional;
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

    public SistemaOperacional getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(SistemaOperacional sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    @Override
    public String toString() {
        return "Servidor{" + "id=" + id + ", nome=" + nome + ", sistemaOperacional=" + sistemaOperacional + '}';
    }
    
}
