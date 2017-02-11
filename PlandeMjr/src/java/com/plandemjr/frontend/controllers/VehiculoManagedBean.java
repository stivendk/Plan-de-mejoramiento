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
public class VehiculoManagedBean implements Serializable, Managedbean<Vehiculo> {

    private Vehiculo vehi;
    @EJB
    private VehiculoFacadeLocal vehifc;
    private int precio;
    private int vehiculo;
    private int preciob = 9;
    private List<Vehiculo> resultado;
    private int lanzamiento = 2017;

    public VehiculoManagedBean() {
    }

    public Vehiculo getVehi() {
        return vehi;
    }

    public void setVehi(Vehiculo vehi) {
        this.vehi = vehi;
    }

    public List<Vehiculo> getResultado() {
        return resultado;
    }

    public void setResultado(List<Vehiculo> resultado) {
        this.resultado = resultado;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(int lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public int getPreciob() {
        return preciob;
    }

    public void setPreciob(int preciob) {
        this.preciob = preciob;
    }

    @PostConstruct
    public void init() {
        vehi = new Vehiculo();
    }

    public void registrarVehiculo() {
        vehifc.create(vehi);
    }

    public void eliminarVehiculo(Vehiculo v) {
        vehifc.remove(v);
    }

    public void modificarVehiculo() {
        vehifc.edit(vehi);
    }

    public String actualizarVehiculo(Vehiculo vs) {
        vehi = vs;
        return "/pages/vehiculo";
    }

    public String verVehiculo(Vehiculo v) {
        vehi = v;
        return "/pages/vehiculo1?faces-redirect=true";
    }

    public List<Vehiculo> listarVehiculo() {
        return vehifc.findAll();
    }

    public void consultarReciente() {
        resultado = vehifc.marcaReciente(lanzamiento);
    }

    @Override
    public Vehiculo getObject(Integer i) {
        return vehifc.find(i);
    }

    public void precioSuministrado() {
        resultado = vehifc.precioAlto(precio);
    }

    public void precioEconomico() {
        resultado = vehifc.precioBajo(preciob);
    }

    public int getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(int vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    /*public void masVendido(){
        resultado = vehifc.masVendido(vehiculo);
    }
    */
}
