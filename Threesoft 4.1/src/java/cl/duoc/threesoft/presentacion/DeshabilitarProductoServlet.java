/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.presentacion;

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
@WebServlet(name = "DeshabilitarProductoServlet", urlPatterns = {"/deshabilitarproducto"})
public class DeshabilitarProductoServlet extends HttpServlet {
    
    @EJB
    ProductoDAOSessionBean productoDAOSessionBean;

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion= request.getSession();
        
        int product_id = Integer.parseInt(request.getParameter("product_id"));

        if(productoDAOSessionBean.disableProducto(product_id)){
            sesion.setAttribute("productoDeshabilitado", "Producto correctamente deshabilitado!");
            response.sendRedirect("ListadoProducto.jsp");
        }else{
            sesion.setAttribute("productoNoDeshabilitado", "no se pudo deshabilitar el producto");
            response.sendRedirect("ListadoProducto.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
