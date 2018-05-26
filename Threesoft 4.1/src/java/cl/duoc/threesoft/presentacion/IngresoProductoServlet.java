/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.presentacion;

import cl.duoc.threesoft.entities.SgaProducto;
import cl.duoc.threesoft.persistencia.ProductoDAOSessionBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author Max
 */
@WebServlet(name = "IngresoProductoServlet", urlPatterns = {"/ingresoproducto"})
public class IngresoProductoServlet extends HttpServlet {

    @EJB
    private ProductoDAOSessionBean productoDAOSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        try {

            String nombre = request.getParameter("txtNombre");
            int compra = Integer.parseInt(request.getParameter("txtCompra"));
            int venta = Integer.parseInt(request.getParameter("txtVenta"));
            int stock = Integer.parseInt(request.getParameter("txtStock"));
            int marca = Integer.parseInt(request.getParameter("ddlMarca"));

            int existe = this.productoDAOSessionBean.existeProducto(nombre);

            if (existe == 1) {
                session.setAttribute("productoExiste", "Nombre de porducto ya Existe. Elija Otro");
                response.sendRedirect("IngresarProducto.jsp");
            } else {
                if (this.productoDAOSessionBean.insertProduct(nombre, compra, venta, stock, marca)) {
                    session.setAttribute("exitoProducto", "Producto ingresado");
                    response.sendRedirect("ListadoProducto.jsp");
                } else {
                    session.setAttribute("errorProducto", "Producto NO ingresado");
                    response.sendRedirect("IngresarProducto.jsp");
                }
            }
        } catch (Exception e) {
            System.out.println("Error msg " + e.getMessage());
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
