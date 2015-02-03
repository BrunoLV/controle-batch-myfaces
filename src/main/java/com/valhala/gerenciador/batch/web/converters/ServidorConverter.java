/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valhala.gerenciador.batch.web.converters;

import com.valhala.gerenciador.batch.vo.ServidorVO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Bruno
 */
@FacesConverter("servidorConverter")
public class ServidorConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println("Valor: " + value);
        Long id = Long.parseLong(value);
        ServidorVO o = new ServidorVO(id, null, null);
        System.out.println("asObject > " + o.toString());
        return o;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("value> " + ((ServidorVO) value).getNome());
        return ((ServidorVO) value).getNome();
    }
    
}
