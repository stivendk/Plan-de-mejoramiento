/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plandemjr.frontend.converters;

import com.plandemjr.backend.persistence.entities.Rol;
import com.plandemjr.frontend.util.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author StivenDavid
 */
@FacesConverter(forClass = Rol.class)
public class RolConverter extends AbstractConverter {

    public RolConverter() {
        this.nombreMB = "rolManagedBean";
    }
    
}
