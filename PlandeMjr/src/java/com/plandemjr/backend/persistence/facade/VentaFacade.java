/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plandemjr.backend.persistence.facade;

import com.plandemjr.backend.persistence.entities.Venta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author StivenDavid
 */
@Stateless
public class VentaFacade extends AbstractFacade<Venta> implements VentaFacadeLocal {

    @PersistenceContext(unitName = "PlandeMjrPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaFacade() {
        super(Venta.class);
    }

    @Override
    public List<Venta> masVendido(int vehiculo) {
        return em.createNamedQuery("Venta.masVendido").setParameter("idVehiculo", vehiculo).getResultList();
    }
    
}
