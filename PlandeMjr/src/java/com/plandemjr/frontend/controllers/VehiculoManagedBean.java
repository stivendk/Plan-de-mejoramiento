/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plandemjr.frontend.controllers;

import com.plandemjr.backend.persistence.entities.Vehiculo;
import com.plandemjr.backend.persistence.facade.VehiculoFacadeLocal;
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
@Named(value = "vehiculoManagedBean")
@SessionScoped
public class VehiculoManagedBean implements Serializable, Managedbean <Vehiculo> {

    private Vehiculo vehi;
    @EJB
    private VehiculoFacadeLocal vehifc;
    private String resultado;
    
    public VehiculoManagedBean() {
    }

    public Vehiculo getVehi() {
        return vehi;
    }

    public void setVehi(Vehiculo vehi) {
        this.vehi = vehi;
    }
    
    @PostConstruct
    public void init(){
        vehi = new Vehiculo();
    }
    
    public void registrarVehiculo(){
        vehifc.create(vehi);
    }
    
    public void eliminarVehiculo(Vehiculo v){
        vehifc.remove(v);
    }
    
    public void modificarVehiculo(){
        vehifc.edit(vehi);
    }
    
    public String actualizarVehiculo(Vehiculo vs){
        vehi = vs;
        return "/pages/vehiculo";
    }
    
    public String verVehiculo(Vehiculo v){
        vehi = v;
        return "/pages/infoVehi";
    }
    
    public List<Vehiculo> listarVehiculo(){
        return vehifc.findAll();
    }

    public List<Vehiculo> consultarReciente(){
        return vehifc.marcaReciente();
    }
            
    @Override
    public Vehiculo getObject(Integer i) {
        return vehifc.find(i);
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
}
