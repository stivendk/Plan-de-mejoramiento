/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plandemjr.frontend.controllers;

import com.plandemjr.backend.persistence.entities.Concesionario;
import com.plandemjr.backend.persistence.facade.ConcesionarioFacadeLocal;
import com.plandemjr.frontend.util.Managedbean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author StivenDavid
 */
@Named(value = "conceseionarioManagedBean")
@SessionScoped
public class ConceseionarioManagedBean implements Serializable, Managedbean <Concesionario> {

    private Concesionario conc;
    @EJB
    private ConcesionarioFacadeLocal concfc;
    
    public ConceseionarioManagedBean() {
    }

    public Concesionario getConc() {
        return conc;
    }

    public void setConc(Concesionario conc) {
        this.conc = conc;
    }
    
    @PostConstruct
    public void init(){
        conc = new Concesionario();
    }
    
    public List<Concesionario> listarConsesionario(){
        return concfc.findAll();
    }

    @Override
    public Concesionario getObject(Integer i) {
        return concfc.find(i);
    }
}
