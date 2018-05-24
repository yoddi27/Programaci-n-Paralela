/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dayocreditos.model;

import java.util.Objects;

/**
 *
 * @author yypv2
 */
public class Credito {
    private String numeroCredito;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    private String montoAprestar;
    private String tipoTrabajador;
    private String tipoCredito;
    private String trabajaEnlaEmpresa;

    public Credito(String numeroCredito, String numeroDocumento, String nombres, String apellidos, String montoAprestar, String tipoTrabajador, String tipoCredito, String trabajaEnlaEmpresa) {
        this.numeroCredito = numeroCredito;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.montoAprestar = montoAprestar;
        this.tipoTrabajador = tipoTrabajador;
        this.tipoCredito = tipoCredito;
        this.trabajaEnlaEmpresa = trabajaEnlaEmpresa;
    }

    public Credito() {
    }

    public String getNumeroCredito() {
        return numeroCredito;
    }

    public void setNumeroCredito(String numeroCredito) {
        this.numeroCredito = numeroCredito;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getMontoAprestar() {
        return montoAprestar;
    }

    public void setMontoAprestar(String montoAprestar) {
        this.montoAprestar = montoAprestar;
    }

    public String getTipoTrabajador() {
        return tipoTrabajador;
    }

    public void setTipoTrabajador(String tipoTrabajador) {
        this.tipoTrabajador = tipoTrabajador;
    }

    public String getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(String tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    public String getTrabajaEnlaEmpresa() {
        return trabajaEnlaEmpresa;
    }

    public void setTrabajaEnlaEmpresa(String trabajaEnlaEmpresa) {
        this.trabajaEnlaEmpresa = trabajaEnlaEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.numeroCredito);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Credito other = (Credito) obj;
        if (!Objects.equals(this.numeroCredito, other.numeroCredito)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
