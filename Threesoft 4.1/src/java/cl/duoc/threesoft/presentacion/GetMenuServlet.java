/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.presentacion;

import cl.duoc.threesoft.entities.SgaUsuario;
//import cl.duoc.threesoft.entities.Users;
import cl.duoc.threesoft.persistencia.MenuDAOSessionBean;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AllMenuServlet", urlPatterns = {"/allmenuservlet", "/allMenu"})
public class GetMenuServlet extends HttpServlet {
    
    @EJB
    private MenuDAOSessionBean menuDAOSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        SgaUsuario loggedUser = (SgaUsuario) request.getSession().getAttribute("usuarioConectado");
        int profile_id = loggedUser.getIdPerfil().getIdPerfil().intValueExact();
        List listadoMenu = menuDAOSessionBean.menuListById(profile_id);
        request.setAttribute("listadoMenu", listadoMenu);
        
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
