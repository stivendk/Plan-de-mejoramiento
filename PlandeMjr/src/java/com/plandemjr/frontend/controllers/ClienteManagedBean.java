/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plandemjr.frontend.controllers;

import com.plandemjr.backend.persistence.entities.Cliente;
import com.plandemjr.backend.persistence.facade.ClienteFacadeLocal;
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
@Named(value = "clienteManagedBean")
@SessionScoped
public class ClienteManagedBean implements Serializable, Managedbean<Cliente> {

    private Cliente cliente;
    @EJB
    private ClienteFacadeLocal clientefc;

    public ClienteManagedBean() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @PostConstruct
    public void init() {
        cliente = new Cliente();
    }

    public String registrarCliente() {
        clientefc.create(cliente);
        return "/pages/inicio";
    }

    public void modificarCliente() {
        clientefc.edit(cliente);
    }

    public void eliminarCliente(Cliente c) {
        clientefc.remove(cliente);
    }

    public String actualizarCliente(Cliente cl) {
        cliente = cl;
        return "";
    }

    public List<Cliente> listarCliente() {
        return clientefc.findAll();
    }

    @Override
    public Cliente getObject(Integer i) {
        return clientefc.find(i);
    }
}
