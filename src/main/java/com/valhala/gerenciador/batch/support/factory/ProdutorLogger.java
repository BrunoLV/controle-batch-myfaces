/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.support.factory;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Bruno
 */
public class ProdutorLogger {
    
    @Produces
    public Logger produzirLogger(InjectionPoint ip) {
        return LoggerFactory.getLogger(ip.getBean().getBeanClass());
    }
    
}
