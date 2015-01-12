/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.web.mb;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Bruno
 */
@Named("skinMB")
@SessionScoped
public class SkinMB implements Serializable {
    
    private String skin = "Casablanca";

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getSkin() {
        return skin;
    }
    
}
