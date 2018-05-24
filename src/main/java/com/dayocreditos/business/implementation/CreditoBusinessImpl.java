/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dayocreditos.business.implementation;

import com.dayocreditos.business.ICreditoBusiness;
import com.dayocreditos.dao.Implementation.CreditoDaoImpl;
import com.dayocreditos.model.Credito;
import java.util.List;

/**
 *
 * @author yypv2
 */
public class CreditoBusinessImpl implements ICreditoBusiness {

    private CreditoDaoImpl creditoDaoImpl = new CreditoDaoImpl();

    @Override
    public List<Credito> obtenerListaCredito() {
        return creditoDaoImpl.obtenerListaCredito();
    }

    @Override
    public Credito obtenerCredito(String idCredito) {
        return creditoDaoImpl.obtenerCredito(idCredito);
    }

    @Override
    public String crearCredito(Credito credito) {
        String respuesta = "";
        Credito credito1 = obtenerCredito(credito.getNumeroCredito());
        if (credito1 == null) {
            respuesta = creditoDaoImpl.crearCredito(credito);
        }
        return respuesta;
    }

    @Override
    public String modificarCredito(Credito credito) {
        String respuesta = "Credito no existe";
        Credito creditol = obtenerCredito(credito.getNumeroCredito());
        if (creditol != null) {
            respuesta = creditoDaoImpl.modificarCredito(credito);
        }
        return respuesta;
    }

    @Override
    public String eliminarCredito(String idCredito) {
        String respuesta = "Credito no existe";
        Credito creditol = obtenerCredito(idCredito);
        if (creditol != null) {
            respuesta = creditoDaoImpl.eliminarCredito(idCredito);
        }
        return respuesta;
    }

}
