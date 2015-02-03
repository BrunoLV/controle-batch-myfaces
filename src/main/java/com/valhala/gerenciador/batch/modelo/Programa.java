/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.modelo;

import java.io.Serializable;
import java.util.ArrayList;
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
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    @ManyToOne
    private Plataforma plataforma;
    
    @ManyToOne
    private Area area;
    
    @ManyToMany
    @JoinTable(name = "tb_programa_x_servidor", joinColumns = {@JoinColumn(name = "id_programa")}, inverseJoinColumns = {@JoinColumn(name = "id_servidor")})
    private List<Servidor> servidores;
    
    /**
     * Construtor
     */
    public Programa() {
        super();
    }
    
    public Programa(Long id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
        this.area = new Area();
        this.plataforma = new Plataforma();
        this.servidores = new ArrayList<>();
    }

    /**
     *
     * @param id
     * @param nome
     * @param plataforma
     * @param area
     * @param servidores
     */
    public Programa(Long id, String nome, Plataforma plataforma, Area area, List<Servidor> servidores) {
        super();
        this.id = id;
        this.nome = nome;
        this.plataforma = plataforma;
        this.area = area;
        this.servidores = servidores;
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
    public Plataforma getPlataforma() {
        return plataforma;
    }

    /**
     *
     * @param plataforma
     */
    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    /**
     *
     * @return
     */
    public Area getArea() {
        return area;
    }

    /**
     *
     * @param area
     */
    public void setArea(Area area) {
        this.area = area;
    }

    /**
     *
     * @return
     */
    public List<Servidor> getServidores() {
        return servidores;
    }

    /**
     *
     * @param servidores
     */
    public void setServidores(List<Servidor> servidores) {
        this.servidores = servidores;
    }

    @Override
    public String toString() {
        return "Programa{" + "id=" + id + ", nome=" + nome + '}';
    }
    
} // fim da classe Programa