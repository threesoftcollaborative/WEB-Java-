/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.presentacion;

import cl.duoc.threesoft.persistencia.ClienteDAOSessionBean;
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
@WebServlet(name = "DeshabilitarClienteServlet", urlPatterns = {"/deshabilitarcliente"})
public class DeshabilitarClienteServlet extends HttpServlet {

    @EJB
    ClienteDAOSessionBean clienteDAOSessionBean;

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion= request.getSession();
        
        int cliente_id = Integer.parseInt(request.getParameter("cliente_id"));

        if(clienteDAOSessionBean.disableCliente(cliente_id)){
            sesion.setAttribute("ClienteDeshabilitado", "Cliente correctamente deshabilitado!");
            response.sendRedirect("ListadoCliente.jsp");
        }else{
            sesion.setAttribute("clienteNoDeshabilitado", "no se pudo deshabilitar el Cliente");
            response.sendRedirect("ListadoCliente.jsp");
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

