/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plandemjr.frontend.controllers;

import com.plandemjr.backend.persistence.entities.Rol;
import com.plandemjr.backend.persistence.facade.RolFacadeLocal;
import com.plandemjr.frontend.util.Managedbean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author StivenDavid
 */
@Named(value = "rolManagedBean")
@SessionScoped
public class RolManagedBean implements Serializable, Managedbean<Rol> {

    private Rol rol;
    @EJB
    private RolFacadeLocal rolfc;
    
    public RolManagedBean() {
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    @PostConstruct
    public void init(){
        rol = new Rol();
    }
    
    @Override
    public Rol getObject(Integer i) {
        return rolfc.find(i);
    }
}
