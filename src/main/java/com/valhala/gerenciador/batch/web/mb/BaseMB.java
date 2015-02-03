/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.web.mb;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 *
 * @author Bruno
 */
public abstract class BaseMB implements Serializable {
    
    /**
     *
     * @param s
     * @param sumario
     * @param detalhe
     */
    public void inserirMensagem(Severity s, String sumario, String detalhe) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(s, sumario, detalhe));
    }
    
}
