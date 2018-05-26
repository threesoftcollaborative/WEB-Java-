/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.presentacion;

import cl.duoc.threesoft.entities.SgaMarca;
import cl.duoc.threesoft.entities.SgaUsuario;
import cl.duoc.threesoft.persistencia.MarcaDAOSessionBean;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.toIntExact;
import java.util.List;
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
@WebServlet(name = "CargarProductoByProveedorServlet", urlPatterns = {"/cargarproductobyproveedor"})
public class CargarProductoByProveedorServlet extends HttpServlet {

    @EJB
    private MarcaDAOSessionBean marcaDAOSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        SgaUsuario loggedUser = (SgaUsuario) request.getSession().getAttribute("usuarioConectado");
        int almacen_id = toIntExact(loggedUser.getIdAlmacen().getIdAlmacen().intValueExact());
        List<SgaMarca> marcaList = marcaDAOSessionBean.marcaListById(almacen_id);
        session.setAttribute("marcaList", marcaList);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}