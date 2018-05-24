/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dayocreditos.dao.Implementation;

import com.dayocreditos.dao.ICreditoDao;
import com.dayocreditos.data.CreditosData;
import com.dayocreditos.model.Credito;
import java.util.List;

/**
 *
 * @author yypv2
 */
public class CreditoDaoImpl implements ICreditoDao{

    @Override
    public List<Credito> obtenerListaCredito() {
        return CreditosData.getListaCreditos();
    }

    @Override
    public Credito obtenerCredito(String idCredito) {
       Credito credito =null;
       List<Credito> listaCreditos= CreditosData.getListaCreditos();
        for (Credito lCredito : listaCreditos) {
            if(lCredito.getNumeroCredito().equals(idCredito)){
                credito=lCredito;
            }
            
        }
        return credito;
    }

    @Override
    public String crearCredito(Credito credito) {
        List<Credito> lista = CreditosData.getListaCreditos();
        lista.add(credito);
        CreditosData.setListaCreditos(lista);
        return "credito creado"; 
    }

    @Override
    public String modificarCredito(Credito credito) {
        List<Credito> lista = CreditosData.getListaCreditos();
        lista.set(lista.indexOf(credito), credito);
        CreditosData.setListaCreditos(lista);
        return "credito modificado"; 
    }

    @Override
    public String eliminarCredito(String idCredito) {
        List<Credito> lista = CreditosData.getListaCreditos();
        lista.remove(obtenerCredito(idCredito));
        CreditosData.setListaCreditos(lista);
        return "credito eliminado";    
    }
    
}
