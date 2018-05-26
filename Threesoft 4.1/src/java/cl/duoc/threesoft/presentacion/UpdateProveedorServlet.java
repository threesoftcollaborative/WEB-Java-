/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.presentacion;

import cl.duoc.threesoft.entities.SgaProducto;
import cl.duoc.threesoft.entities.SgaProveedor;
import cl.duoc.threesoft.entities.SgaUsuario;
import cl.duoc.threesoft.persistencia.ProductoDAOSessionBean;
import cl.duoc.threesoft.persistencia.ProveedorDAOSessionBean;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.toIntExact;
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
@WebServlet(name = "UpdateProveedorServlet", urlPatterns = {"/updateproveedor"})
public class UpdateProveedorServlet extends HttpServlet {

     @EJB
    private ProveedorDAOSessionBean proveedorDAOSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int proveedor_id = Integer.parseInt(request.getParameter("proveedor_id"));
        SgaProveedor proveedor = proveedorDAOSessionBean.proveedorById(proveedor_id);
        
        if (proveedor != null) {
            session.setAttribute("proveedorEncontrado", proveedor);
            response.sendRedirect("UpdateProveedor.jsp");
        }else{
            session.setAttribute("errorUpdateIns", "no se puede modificar el proveedor");
            response.sendRedirect("ListadoProveedor.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        try {

            String nombre = request.getParameter("txtNombre");
            String rut = request.getParameter("txtRut");
            int telefono = Integer.parseInt(request.getParameter("txtTelefono"));
            String email = request.getParameter("txtEmail");
            String direccion = request.getParameter("txtDireccion");
            int comuna = Integer.parseInt(request.getParameter("ddlComuna"));
            int id_proveedor = Integer.parseInt(request.getParameter("id_Proveedor"));

            if (this.proveedorDAOSessionBean.updateProveedor(id_proveedor, nombre, rut, telefono, email, direccion, comuna)) {
                session.setAttribute("exitoProveedorUpdate", "Proveedor Modificado");
                response.sendRedirect("ListadoProveedor.jsp");
            } else {
                session.setAttribute("errorProveedorUpdate", "Proveedor NO Modificado");
                response.sendRedirect("ListadoProveedor.jsp");
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