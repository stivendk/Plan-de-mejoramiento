/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plandemjr.frontend.controllers;

import com.plandemjr.backend.persistence.entities.Venta;
import com.plandemjr.backend.persistence.facade.VentaFacadeLocal;
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
@Named(value = "ventaManagedBean")
@SessionScoped
public class VentaManagedBean implements Serializable {

    private Venta venta;
    @EJB
    private VentaFacadeLocal ventafc;

    public VentaManagedBean() {
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @PostConstruct
    public void init() {
        venta = new Venta();
    }

    public void registrarVenta() {
        ventafc.create(venta);
    }

    public void modificarVenta() {
        ventafc.edit(venta);
    }

    public String actualizarVenta(Venta v) {
        venta = v;
        return "";
    }

    public void eliminarVenta(Venta va) {
        ventafc.remove(venta);
    }

    public List<Venta> listarVenta() {
        return ventafc.findAll();
    }
}
