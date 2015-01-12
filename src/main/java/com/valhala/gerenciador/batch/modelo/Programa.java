/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "tb_programa") 
public class Programa implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    
    @ManyToOne
    private Plataforma plataforma;
    
    @ManyToOne
    private Area area;
    
    @ManyToMany
    @JoinTable(name = "tb_batch_servidor", joinColumns = {@JoinColumn(name = "id_batch")}, inverseJoinColumns = {@JoinColumn(name = "id_servidor")})
    private List<Servidor> servidores;
    
    public Programa() {
        super();
    }

    public Programa(Long id, String nome, Plataforma plataforma, Area area, List<Servidor> servidores) {
        super();
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

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Servidor> getServidores() {
        return servidores;
    }

    public void setServidores(List<Servidor> servidores) {
        this.servidores = servidores;
    }

    @Override
    public String toString() {
        return "Programa{" + "id=" + id + ", nome=" + nome + '}';
    }
    
} // fim da classe Programa