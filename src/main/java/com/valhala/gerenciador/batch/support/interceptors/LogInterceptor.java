/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.support.interceptors;

import com.valhala.gerenciador.batch.support.qualifiers.Logavel;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.slf4j.Logger;

/**
 *
 * @author Bruno
 */
@Interceptor @Logavel
public class LogInterceptor {
    
    @Inject
    private Logger logger; 
    
    /**
     *
     * @param ic
     * @return
     * @throws Exception
     */
    @AroundInvoke
    public Object logarAcao(InvocationContext ic) throws Exception {
        Object o = null;
        try {
            logger.info("Chamando o metodo: " + ic.getMethod() + " - classe: " + ic.getTarget().getClass().getName()) ;
            o =  ic.proceed();
        } catch (Exception e) {
            logger.error("Ocorreu um erro.", e);
            throw  e;
        } // fim do bloco try/catch
        return o;
    } // fim do metodo logarAcao
    
} // fim da classe LogInterceptor