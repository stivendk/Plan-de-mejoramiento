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
import javax.persistence.TypedQuery;

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
    public List<Vehiculo> marcaReciente() {
        TypedQuery<Vehiculo> query;
        query = em.createQuery("SELECT v.idVehiculo, v.marca, v.modelo, v.imagen, MAX(v.lanzamiento)FROM Vehiculo v", Vehiculo.class);
        List<Vehiculo> reciente = query.getResultList();
        return reciente;
    }

    @Override
    public List<Vehiculo> precioAlto(int precio) {
        return em.createNamedQuery("Vehiculo.consultaPrecio").setParameter("precio", precio).getResultList();
    }
}
