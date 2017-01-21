/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plandemjr.backend.persistence.facade;

import com.plandemjr.backend.persistence.entities.Concesionario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author StivenDavid
 */
@Stateless
public class ConcesionarioFacade extends AbstractFacade<Concesionario> implements ConcesionarioFacadeLocal {

    @PersistenceContext(unitName = "PlandeMjrPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConcesionarioFacade() {
        super(Concesionario.class);
    }

    @Override
    public Concesionario iniciarSesion(Concesionario c) throws Exception {
        Concesionario concesionario = null;
        TypedQuery<Concesionario> query;
        try {
            query = em.createQuery("FROM Concesionario c WHERE c.nombre = ?1 and c.password = ?2", Concesionario.class);
            query.setParameter(1, c.getNombre());
            query.setParameter(2, c.getPassword());
            if(!query.getResultList().isEmpty()){
                concesionario = query.getResultList().get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return concesionario;
    }
    
}
