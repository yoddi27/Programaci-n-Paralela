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
                rd = request.getRequestDispatcher("/View/ListaCreditos.jsp");
                break;
             case "creditosMasUsados":
                listaCreditos = cBusinessImpl.obtenerListaCredito();
                session.setAttribute("LISTADO", listaCreditos);
                rd = request.getRequestDispatcher("/View/ListaCreditos.jsp");
                break;
             case "AcomuladoDePrestamos":
                listaCreditos = cBusinessImpl.obtenerListaCredito();
                session.setAttribute("LISTADO", listaCreditos);
                rd = request.getRequestDispatcher("/View/ListaCreditos.jsp");
                break;
             case "quienesPrestan":
                listaCreditos = cBusinessImpl.obtenerListaCredito();
                session.setAttribute("LISTADO", listaCreditos);
                rd = request.getRequestDispatcher("/View/ListaCreditos.jsp");
                break;

            default:
                break;

        }
        rd.forward(request, response);
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
