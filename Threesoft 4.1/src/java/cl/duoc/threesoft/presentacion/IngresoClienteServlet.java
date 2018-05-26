/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.presentacion;

import cl.duoc.threesoft.entities.SgaUsuario;
import cl.duoc.threesoft.persistencia.ClienteDAOSessionBean;
import cl.duoc.threesoft.persistencia.ProveedorDAOSessionBean;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.toIntExact;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
@WebServlet(name = "IngresoClienteServlet", urlPatterns = {"/ingresocliente"})
public class IngresoClienteServlet extends HttpServlet {

    @EJB
    private ClienteDAOSessionBean clienteDAOSessionBean;

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

            String rut = request.getParameter("txtRut");
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            int telefono = Integer.parseInt(request.getParameter("txtTelefono"));
            String email = request.getParameter("txtEmail");

            String dateString = request.getParameter("datePicker");
            SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
            Date fecha = sm.parse(dateString);

            String Direccion = request.getParameter("txtDireccion");
            int comuna = Integer.parseInt(request.getParameter("ddlComuna"));
            int almacen_id = toIntExact(loggedUser.getIdAlmacen().getIdAlmacen().intValueExact());
            
            int existe = this.clienteDAOSessionBean.existeCliente(rut);
            
            if (existe == 1) {
                session.setAttribute("clienteExiste", "Cliente ya Existe. Ingrese Otro");
                response.sendRedirect("IngresarCliente.jsp");
            } else {
                if (this.clienteDAOSessionBean.insertCliente(rut, nombre, apellido, telefono, email, fecha, Direccion, almacen_id, comuna)) {
                    session.setAttribute("exitoCliente", "Cliente ingresado");
                    response.sendRedirect("ListadoCliente.jsp");
                } else {
                    session.setAttribute("errorCliente", "Cliente NO ingresado");
                    response.sendRedirect("ListadoCliente.jsp");
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
