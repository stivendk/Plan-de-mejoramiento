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
@Named(value = "concesionarioManagedBean")
@SessionScoped
public class ConcesionarioManagedBean implements Serializable, Managedbean <Concesionario> {

    private Concesionario conce;
    @EJB
    private ConcesionarioFacadeLocal concefc;

    public ConcesionarioManagedBean() {
    }

    public Concesionario getConce() {
        return conce;
    }

    public void setConce(Concesionario conce) {
        this.conce = conce;
    }

    @PostConstruct
    public void init() {
        conce = new Concesionario();
    }

    public void registrarConcesionario() {
        concefc.create(conce);
    }

    public void modificarConcesionario() {
        concefc.edit(conce);
    }

    public String editarConcesionario(Concesionario c) {
        conce = c;
        return "";
    }

    public void eliminarConcesionario(Concesionario cs) {
        concefc.remove(conce);
    }

    public List<Concesionario> listarConcesionario() {
        return concefc.findAll();
    }

    @Override
    public Concesionario getObject(Integer i) {
       return concefc.find(i);
    }
}
