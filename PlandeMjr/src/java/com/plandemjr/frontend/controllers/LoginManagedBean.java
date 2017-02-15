/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plandemjr.frontend.controllers;

import com.plandemjr.backend.persistence.entities.Concesionario;
import javax.inject.Named;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author StivenDavid
 */
@Named(value = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {

    private Concesionario conce;
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
        conce = (Concesionario) FacesUtils.getUsuarioLogueado();
        System.out.println(conce);
    }

    public String cerrarSesion() {
        FacesUtils.removerUsuario();
        conce = null;
        return "/index.xhtml?faces-redirect=true";
    }

}