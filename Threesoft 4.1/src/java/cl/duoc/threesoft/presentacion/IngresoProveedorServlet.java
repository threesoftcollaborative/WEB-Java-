/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.presentacion;

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
@WebServlet(name = "IngresoProveedorServlet", urlPatterns = {"/ingresoproveedor"})
public class IngresoProveedorServlet extends HttpServlet {

    @EJB
    private ProveedorDAOSessionBean proveedorDAOSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        try {

            SgaUsuario loggedUser = (SgaUsuario) request.getSession().getAttribute("usuarioConectado");

            String nombre = request.getParameter("txtNombre");
            String rut = request.getParameter("txtRut");
            int telefono = Integer.parseInt(request.getParameter("txtTelefono"));
            String email = request.getParameter("txtEmail");
            String Direccion = request.getParameter("txtDireccion");
            int comuna = Integer.parseInt(request.getParameter("ddlComuna"));
            int almacen_id = toIntExact(loggedUser.getIdAlmacen().getIdAlmacen().intValueExact());

            int existe = this.proveedorDAOSessionBean.existeProveedor(nombre, rut);

            if (existe == 1) {
                session.setAttribute("proveedorExiste", "Nombre de proveedor o rut ya Existe. Elija Otro");
                response.sendRedirect("IngresarProveedor.jsp");
            } else {
                if (this.proveedorDAOSessionBean.insertProveedor(nombre, rut, telefono, email, Direccion, comuna, almacen_id)) {
                    session.setAttribute("exitoProveedor", "Proveedor ingresado");
                    response.sendRedirect("ListadoProveedor.jsp");
                } else {
                    session.setAttribute("errorProveedor", "Proveedor NO ingresado");
                    response.sendRedirect("ListadoProveedor.jsp");
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
