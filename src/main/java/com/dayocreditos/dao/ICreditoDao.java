/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dayocreditos.dao;

import com.dayocreditos.model.Credito;
import java.util.List;

/**
 *
 * @author yypv2
 */
public interface ICreditoDao {
    List<Credito> obtenerListaCredito();
    Credito obtenerCredito(String idCredito);
    String crearCredito(Credito credito);
    String modificarCredito(Credito credito);
    String eliminarCredito(String idCredito);
}
