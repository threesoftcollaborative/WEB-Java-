/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.presentacion;

//import cl.duoc.threesoft.entities.Profiles;
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
@WebServlet(name = "ProfileServlet", urlPatterns = {"/profileservlet", "/cargaPerfil"})
public class ProfileServlet extends HttpServlet {

    @EJB
    //private ProfileDAOSessionBean profileDAOSessionBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session= request.getSession();
        //List<Profiles>listadoPerfiles = this.profileDAOSessionBean.listPerfiles();
        //session.setAttribute("listadoPerfiles", listadoPerfiles);
        
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
