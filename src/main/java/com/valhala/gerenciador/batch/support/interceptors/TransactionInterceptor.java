/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.support.interceptors;

import com.valhala.gerenciador.batch.support.qualifiers.Logavel;
import com.valhala.gerenciador.batch.support.qualifiers.Transacionavel;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

/**
 *
 * @author Bruno
 */
@Interceptor @Transacionavel
@Interceptors({LogInterceptor.class})
public class TransactionInterceptor {
    
    @Inject
    private EntityManager em;
    
    /**
     *
     * @param ic
     * @return
     * @throws Exception
     */
    @AroundInvoke @Logavel
    public Object controlarTransacao(InvocationContext ic) throws Exception {
        Object o = null;
        em.getTransaction().begin();
        try {
            o = ic.proceed();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw  e;
        } // fim do bloco try/catch
        return o;
    } // fim do metodo 
    
} // fim da classe TransactionInterceptor