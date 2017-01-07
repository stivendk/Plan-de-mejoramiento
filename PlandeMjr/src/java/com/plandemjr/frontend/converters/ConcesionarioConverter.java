/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plandemjr.frontend.converters;

import com.plandemjr.backend.persistence.entities.Concesionario;
import com.plandemjr.frontend.util.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author StivenDavid
 */
@FacesConverter(forClass = Concesionario.class)
public class ConcesionarioConverter extends AbstractConverter{

    public ConcesionarioConverter() {
        this.nombreMB = "concesionarioManagedBean";
    }
}
