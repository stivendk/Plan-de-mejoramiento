/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plandemjr.backend.persistence.facade;

import com.plandemjr.backend.persistence.entities.Vehiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author StivenDavid
 */
@Stateless
public class VehiculoFacade extends AbstractFacade<Vehiculo> implements VehiculoFacadeLocal {

    @PersistenceContext(unitName = "PlandeMjrPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoFacade() {
        super(Vehiculo.class);
    }

    @Override
    public List<Vehiculo> precioAlto(int precio) {
        return em.createNamedQuery("Vehiculo.consultaPrecio").setParameter("precio", precio).getResultList();
    }

    @Override
    public List<Vehiculo> marcaReciente(int lanzamiento) {
        return em.createNamedQuery("Vehiculo.consultaReciente").setParameter("lanzamiento", lanzamiento).getResultList();
    }

    @Override
    public List<Vehiculo> precioBajo(int precio) {
        return em.createNamedQuery("Vehiculo.consultaPrecioE").setParameter("precio", precio).getResultList();
    }

    /*@Override
    //public List<Vehiculo> masVendido(int vehiculo) {
        return em.createNamedQuery("Vehiculo.masVendido").setParameter("idVehiculo", vehiculo).getResultList();
    }
    */
}
