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
import java.util.ArrayList;
import java.util.Date;
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
    private int vehiculo;
    private List<Venta> resultado;
    private LoginManagedBean conce;

    public LoginManagedBean getConce() {
        return conce;
    }

    public VentaManagedBean() {
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<Venta> getResultado() {
        return resultado;
    }

    public void setResultado(List<Venta> resultado) {
        this.resultado = resultado;
    }

    public int getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(int vehiculo) {
        this.vehiculo = vehiculo;
    }

    @PostConstruct
    public void init() {
        venta = new Venta();
    }

    public void registrarVenta() {
        venta.setFecha(new Date());
        ventafc.create(venta);
    }

    public List<Venta> listarVenta() {
        return ventafc.findAll();
    }

    public String masVendio() {
        String a = null;
        String b = null;
        for (Venta v : listarVenta()) {
            a = a + " " + v.getIdVehiculo().getMarca();
        }
        b = obtenerMarca(a);
        return b;
    }
    
    public String obtenerMarca(String _frase)
    {
        String palabras [] = _frase.split(" ");
        String palabrasB [] = _frase.split(" ");
        
        int cantidad = palabras.length;
        String resultado = "";
        int contadorMasRepet =  0;
 
        for (int i = 0; i < cantidad; i++) {
                int contador = 0;
//          resultado += palabras[i];
                String palabra = palabras[i];
 
                for (int j = 0; j < cantidad; j++) {
 
                        if (palabra.equalsIgnoreCase(palabrasB[j])){
                                contador++;
                                palabras[j] = "";
 
                        }
                }
 
                if ((contador > 1)&& (contador > contadorMasRepet)){
                        resultado = palabra;
                        contadorMasRepet = contador;
                        System.out.print(palabras[i]);
                }
                else if ((contador > 1)&& (contador == contadorMasRepet)){
                    resultado += " " + palabra;
                }       
        }
        if (resultado == "")
            resultado = "Solo hay un venta ";
        
        return resultado;
    }
    public  List<Venta> ventaConces(){
        List<Venta> l = new ArrayList<>();
     for( Venta venta: listarVenta()){
         if(venta.getIdVehiculo().getIdConcecionario().equals(conce.getConce())){
             l.add(venta);
         }
     }
     return  l;
    }
}
