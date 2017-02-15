/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plandemjr.frontend.controllers;

import com.plandemjr.backend.persistence.entities.Concesionario;
import com.plandemjr.backend.persistence.facade.ConcesionarioFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author StivenDavid
 */
@Named(value = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {

    private Concesionario conce;
    @EJB
    private ConcesionarioFacadeLocal concefc;

    public LoginManagedBean() {
    }

    public Concesionario getConce() {
        return conce;
    }

    public void setConce(Concesionario conce) {
        this.conce = conce;
    }

    @PostConstruct
    public void init() {
        conce = (Concesionario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }

    public String cerrarSesion() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("usuario");
        context.getExternalContext().invalidateSession();
        conce = null;
        return "/index.xhtml?faces-redirect=true";
    }

}
