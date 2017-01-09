/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plandemjr.frontend.controllers;

import com.plandemjr.backend.persistence.entities.Cliente;
import com.plandemjr.backend.persistence.facade.ClienteFacadeLocal;
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

    private Cliente cliente;
    @EJB
    private ClienteFacadeLocal clientefc;
    
    public LoginManagedBean() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @PostConstruct
    public void init(){
        cliente = new Cliente();
    }
    
    public String iniciarSesion(){
        String redir = null;
        try {
            if (clientefc.iniciarSesion(cliente)!=null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", cliente);
            redir = "/pages/inicio?faces-redirect=true";
            }else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aviso Error!"));
        }
        return redir;
    }
    
    public void cerrarSesion (){
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
