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
    public void init(){
        conce = new Concesionario();
    }
    
    public String iniciarSesion(Concesionario cl){
        String redir = null;
        try {
            if (concefc.iniciarSesion(conce)!=null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("concesionario", conce);
            redir = "/pages/inicio?faces-redirect=true";
            }else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aviso Error!"));
        }
        return redir;
    }
    
    public void verificarSesion() throws IOException{
        if(FacesUtils.getUsuarioLogueado() == null){
            FacesUtils.redireccionar();
        }
    }
    
    public void cerrarSesion (){
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

}
