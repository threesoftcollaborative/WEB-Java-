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

/**
 *
 * @author Max
 */
@WebServlet(name = "UpdateProductoServlet", urlPatterns = {"/updateproducto"})
public class UpdateProductoServlet extends HttpServlet {
    
    @EJB
    private ProductoDAOSessionBean productoDAOSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int product_id = Integer.parseInt(request.getParameter("product_id"));
        SgaProducto producto = productoDAOSessionBean.productoById(product_id);
        
        if (producto != null) {
            session.setAttribute("productoEncontrado", producto);
            response.sendRedirect("UpdateProducto.jsp");
        }else{
            session.setAttribute("errorUpdateIns", "no se puede modificar el producto");
            response.sendRedirect("ListadoProducto.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        try {
            
            int producto_id = Integer.parseInt(request.getParameter("id_producto"));
            String nombre = request.getParameter("txtNombre");
            int compra = Integer.parseInt(request.getParameter("txtCompra"));
            int venta = Integer.parseInt(request.getParameter("txtVenta"));


            if (this.productoDAOSessionBean.updateProducto(producto_id, nombre, compra, venta)) {
                session.setAttribute("exitoProductoUpdate", "Producto Modificado");
                response.sendRedirect("ListadoProducto.jsp");
            } else {
                session.setAttribute("errorProductoUpdate", "Producto NO Modificado");
                response.sendRedirect("ListadoProducto.jsp");
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