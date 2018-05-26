/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.presentacion;

import cl.duoc.threesoft.entities.SgaCliente;
import cl.duoc.threesoft.entities.SgaProveedor;
import cl.duoc.threesoft.persistencia.ClienteDAOSessionBean;
import cl.duoc.threesoft.persistencia.ProveedorDAOSessionBean;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.toIntExact;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "UpdateClienteServlet", urlPatterns = {"/updatecliente"})
public class UpdateClienteServlet extends HttpServlet {

    @EJB
    private ClienteDAOSessionBean clienteDAOSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int cliente_id = Integer.parseInt(request.getParameter("cliente_id"));
        SgaCliente cliente = clienteDAOSessionBean.clienteById(cliente_id);
        
        if (cliente != null) {
            session.setAttribute("clienteEncontrado", cliente);
            response.sendRedirect("UpdateCliente.jsp");
        }else{
            session.setAttribute("errorUpdateIns", "no se puede modificar el cliente");
            response.sendRedirect("ListadoCliente.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        try {

            int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            int telefono = Integer.parseInt(request.getParameter("txtTelefono"));
            String email = request.getParameter("txtEmail");

            String todayString = request.getParameter("datePicker");
            SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
            Date fecha = sm.parse(todayString);
            
            String Direccion = request.getParameter("txtDireccion");
            int comuna = Integer.parseInt(request.getParameter("ddlComuna"));

            if (this.clienteDAOSessionBean.updateCliente(id_cliente, nombre, apellido, telefono, email, fecha, Direccion, comuna)) {
                session.setAttribute("exitoClienteUpdate", "Cliente Modificado");
                response.sendRedirect("ListadoCliente.jsp");
            } else {
                session.setAttribute("errorClienteUpdate", "Cliente NO Modificado");
                response.sendRedirect("ListadoCliente.jsp");
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