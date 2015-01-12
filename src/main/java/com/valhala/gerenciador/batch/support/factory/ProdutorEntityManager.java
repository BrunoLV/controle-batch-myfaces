/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.support.factory;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Produtor de EntityManager
 * @author Bruno
 */
public class ProdutorEntityManager {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("batchsPU");
    
    /**
     * Metodo que realiza a ação de criacao de Entity Managers.
     * Os objetos ficam no escopo de requisicao.
     * @return 
     */
    @Produces @RequestScoped
    public EntityManager gerarEntityManager()  {
        return emf.createEntityManager();
    } // fim do metodo gerarEntityManager
    
    /**
     * Metodo que executa o encerramento do entity manager.
     * @param em 
     */
    public void encerrar(@Disposes EntityManager em) {
        em.close();
    } // fim do metodo encerrar
    
} // fim da classe ProdutorEntityManager