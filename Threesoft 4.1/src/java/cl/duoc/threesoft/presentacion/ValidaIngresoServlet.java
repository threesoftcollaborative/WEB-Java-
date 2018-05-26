/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.presentacion;

import cl.duoc.threesoft.entities.SgaUsuario;
import cl.duoc.threesoft.persistencia.UsersDAOSessionBean;
//import cl.duoc.threesoft.entities.Users;
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
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author amontess
 */
@WebServlet(name = "ValidaIngresoServlet", urlPatterns = {"/validaIngresoServlet", "/validaIngreso"})
public class ValidaIngresoServlet extends HttpServlet {

    @EJB
    private UsersDAOSessionBean userDAOSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String login = request.getParameter("txtUserName");
        String pass = request.getParameter("txtPass");
        int msj = 0;
        
        SgaUsuario objUsuario = this.userDAOSessionBean.validaUsuario(login);
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
//        String encryptpass = passwordEncryptor.encryptPassword("123");
//        String a = null;
        try {
            if (objUsuario != null) {
                if (passwordEncryptor.checkPassword(pass, objUsuario.getPass())) {
                    sesion.setAttribute("usuarioConectado", objUsuario);
                    response.sendRedirect("AdminHome.jsp");
                }else{
                    sesion.setAttribute("errorPass", "Password incorrecta");
                    response.sendRedirect("Login.jsp");
                }
            } else {
                sesion.setAttribute("errorLogin", "El Usuario no Existe");
                response.sendRedirect("Login.jsp");
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
