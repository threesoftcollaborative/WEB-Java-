/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.presentacion;

import cl.duoc.threesoft.persistencia.ProductoDAOSessionBean;
import cl.duoc.threesoft.persistencia.ProveedorDAOSessionBean;
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
@WebServlet(name = "DeshabilitarProveedorServlet", urlPatterns = {"/deshabilitarproveedor"})
public class DeshabilitarProveedorServlet extends HttpServlet {

    @EJB
    ProveedorDAOSessionBean proveedorDAOSessionBean;

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion= request.getSession();
        
        int id_proveedor = Integer.parseInt(request.getParameter("proveedor_id"));

        if(proveedorDAOSessionBean.disableProveedor(id_proveedor)){
            sesion.setAttribute("proveedorDeshabilitado", "Proveedor correctamente deshabilitado!");
            response.sendRedirect("ListadoProveedor.jsp");
        }else{
            sesion.setAttribute("proveedorNoDeshabilitado", "no se pudo deshabilitar el Proveedor");
            response.sendRedirect("ListadoProveedor.jsp");
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
