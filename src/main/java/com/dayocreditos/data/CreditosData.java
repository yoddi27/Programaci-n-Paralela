/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dayocreditos.data;

import com.dayocreditos.model.Credito;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yypv2
 */
public class CreditosData {
    private static List<Credito> listaCreditos;
     
     static {
         listaCreditos=new ArrayList<Credito>(){
            {
                
            }
            
        };
     }

    public static List<Credito> getListaCreditos() {
        return listaCreditos;
    }

    public static void setListaCreditos(List<Credito> aListaCreditos) {
        listaCreditos = aListaCreditos;
    }

       
}
