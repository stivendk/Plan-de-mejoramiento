/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plandemjr.frontend.controllers;

import com.plandemjr.backend.persistence.entities.Cliente;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author StivenDavid
 */
@Named
@ViewScoped
public class SeguridadController implements Serializable{

    public void verificarSesion() throws Exception {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Cliente cl = (Cliente) context.getExternalContext().getSessionMap().get("cliente");
            if (cl == null) {
                context.getExternalContext().redirect("../permisos.xhtml");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
