package com.ferrestock.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

    // Manejo de peticiones GET (Ej: Consultar o buscar)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        if ("buscar".equals(accion)) {
            String id = request.getParameter("id");
            // Lógica de consulta a la base de datos (JDBC)
            request.setAttribute("mensajeResultado", "Consultando el producto con ID: " + id);
            request.getRequestDispatcher("listar-productos.jsp").forward(request, response);
        } else {
            response.sendRedirect("form-producto.jsp");
        }
    }

    // Manejo de peticiones POST (Ej: Registrar o insertar)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");

        if ("registrar".equals(accion)) {
            String nombre = request.getParameter("nombre");
            double precio = Double.parseDouble(request.getParameter("precio"));
            int stock = Integer.parseInt(request.getParameter("stock"));

            // Aquí invocarías tu DAO y conexión JDBC para guardar en MySQL
            boolean registrado = true; // Simulación de éxito

            if (registrado) {
                request.setAttribute("exito", "¡Producto '" + nombre + "' registrado exitosamente!");
            } else {
                request.setAttribute("error", "No se pudo registrar el producto.");
            }

            // Redirección a la vista JSP de resultados
            request.getRequestDispatcher("listar-productos.jsp").forward(request, response);
        }
    }
}