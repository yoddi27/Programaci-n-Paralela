/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dayocreditos.controller;

import com.dayocreditos.business.implementation.CreditoBusinessImpl;
import com.dayocreditos.model.Credito;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yypv2
 */
public class CreditosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher rd = null;
        CreditoBusinessImpl cBusinessImpl = new CreditoBusinessImpl();
        String accion = request.getParameter("accion");
        String numeroCredito;
        String numeroDocumento;
        String nombres;
        String apellidos;
        String montoAprestar;
        String tipoTrabajador;
        String tipoCredito;
        String trabajaEnlaEmpresa;
        Credito credito;
        String mensaje;
        List<Credito> listaCreditos;
        List<String> listaInforme;
        switch (accion) {
            case "prepararCrear":
                rd = request.getRequestDispatcher("/view/Creditos.jsp");
                break;
            case "crear":
                numeroCredito = request.getParameter("txtnumerocredito");
                numeroDocumento = request.getParameter("txtdocumento");
                nombres = request.getParameter("txtnombres");
                apellidos = request.getParameter("txtapellidos");
                montoAprestar = request.getParameter("txtMontoPrestar");
                tipoTrabajador = request.getParameter("txttipotrabajador");
                tipoCredito = request.getParameter("txtipocredito");
                trabajaEnlaEmpresa = request.getParameter("txttrabajaempresa");
                credito = new Credito(numeroCredito, numeroDocumento, nombres, apellidos, montoAprestar, tipoTrabajador, tipoCredito, trabajaEnlaEmpresa);
                mensaje = cBusinessImpl.crearCredito(credito);
                session.setAttribute("MENSAJE", mensaje);
                rd = request.getRequestDispatcher("/mensaje.jsp");
                break;
            case "listar":
                listaCreditos = cBusinessImpl.obtenerListaCredito();
                session.setAttribute("LISTADO", listaCreditos);
                session.setAttribute("INFORME", new ArrayList<String>());
                rd = request.getRequestDispatcher("/View/ListaCreditos.jsp");
                break;
             case "creditosMasUsados":
                listaCreditos = cBusinessImpl.obtenerListaCredito();
                session.setAttribute("LISTADO", listaCreditos);
                session.setAttribute("TIPOINFORME", "Credito mas usado");
                session.setAttribute("INFORME", informeCreditoMasUsado(listaCreditos));
                
                rd = request.getRequestDispatcher("/View/ListaCreditos.jsp");
                break;
             case "AcomuladoDePrestamos":
                listaCreditos = cBusinessImpl.obtenerListaCredito();
                session.setAttribute("LISTADO", listaCreditos);
                session.setAttribute("TIPOINFORME", "Acumulado de Prestamos");
                session.setAttribute("INFORME", informeAcumuladoPrestamos(listaCreditos));
                
                rd = request.getRequestDispatcher("/View/ListaCreditos.jsp");
                break;
             case "quienesPrestan":
                listaCreditos = cBusinessImpl.obtenerListaCredito();
                session.setAttribute("LISTADO", listaCreditos);
                   session.setAttribute("TIPOINFORME", "Quines prestan más");
                session.setAttribute("INFORME", informeQuienesPrestanMas(listaCreditos));
                
                rd = request.getRequestDispatcher("/View/ListaCreditos.jsp");
                break;

            default:
                break;

        }
        rd.forward(request, response);
    }

    
    public List<String> informeCreditoMasUsado(List<Credito> listaCreditos){
        Integer[] acomuladores= new Integer[3];
       
        List<String> resultado=new ArrayList<>();
        Integer maximo=0;
        for (int i = 0; i < acomuladores.length; i++) {
            acomuladores[i]=0;            
        }
        if(listaCreditos.size()>0){
            for (Credito listaCredito : listaCreditos) {
                acomuladores[Integer.parseInt(listaCredito.getTipoCredito())-1]++;                
            }
            for (int i = 0; i < acomuladores.length; i++) {
                Integer acomuladore = acomuladores[i];
                maximo=Integer.max(maximo, acomuladore);
            }
            for (int i = 0; i < acomuladores.length; i++) {
                Integer acomuladore = acomuladores[i];
                if(maximo.equals(acomuladore)){
                    resultado.add(getDescripcionTipoCredito((i+1)+""));
                }
            }
        }else{
            resultado.add("No hay créditos registrados.");
        }
        return resultado;
    }
    
    public String getDescripcionTipoCredito(String tipo){
        switch(tipo){
            case "1":
                return "Vivienda";
            case "2":
                return "Estudio";
            case "3":
                return "Libre Inversión";
            default:
                return "sin tipo";
        }
    }
    
    
    public List<String> informeQuienesPrestanMas(List<Credito> listaCreditos){
        Integer[] acomuladores= new Integer[2];
       
        List<String> resultado=new ArrayList<>();
        Integer maximo=0;
        Integer acomuladore;
        for (int i = 0; i < acomuladores.length; i++) {
            acomuladores[i]=0;            
        }
        if(listaCreditos.size()>0){
            for (Credito listaCredito : listaCreditos) {
                acomuladores[Integer.parseInt(listaCredito.getTipoTrabajador())-1]++;                
            }
            for (int i = 0; i < acomuladores.length; i++) {
                acomuladore = acomuladores[i];
                maximo=Integer.max(maximo, acomuladore);
            }
            for (int i = 0; i < acomuladores.length; i++) {
                acomuladore = acomuladores[i];
                if(maximo.equals(acomuladore)){
                    resultado.add(getDescripcionTipoTrabajador((i+1)+""));
                }
            }
        }else{
            resultado.add("No hay registros de quienes prestan.");
        }
        return resultado;
    }
    
    public String getDescripcionTipoTrabajador(String tipo){
        switch(tipo){
            case "1":
                return "Independiente";
            case "2":
                return "Dependiente";
            default:
                return "sin tipo";
        }
    }
    
     public List<String> informeAcumuladoPrestamos(List<Credito> listaCreditos){

        Integer[] acomuladores= new Integer[3];
        List<String> resultado=new ArrayList<>();
        Integer maximo=0;
        Integer acomuladore;
        for (int i = 0; i < acomuladores.length; i++) {
            acomuladores[i]=0;            
        }
        if(listaCreditos.size()>0){
            for (Credito listaCredito : listaCreditos) {
//                acomuladores[Integer.parseInt(listaCredito.getTipoCredito())-1]++;
                acomuladores[Integer.parseInt(listaCredito.getTipoCredito())-1]=acomuladores[Integer.parseInt(listaCredito.getTipoCredito())-1]+Integer.parseInt(listaCredito.getMontoAprestar());
            }
            for (int i = 0; i < acomuladores.length; i++) {
                acomuladore = acomuladores[i];
                maximo=Integer.max(maximo, acomuladore);
            }
            for (int i = 0; i < acomuladores.length; i++) {
                acomuladore = acomuladores[i];
                if(maximo.equals(acomuladore)){
                    resultado.add(getDescripcionTipoCredito((i+1)+"")+" - Valor: "+maximo);
                }
            }
        }else{
            resultado.add("No hay registros acumulados.");
        }
        return resultado;
    }
    
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
