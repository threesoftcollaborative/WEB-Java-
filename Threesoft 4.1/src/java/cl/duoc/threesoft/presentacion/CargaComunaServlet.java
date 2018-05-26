/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.presentacion;

import cl.duoc.threesoft.entities.SgaComuna;
import cl.duoc.threesoft.entities.SgaMarca;
import cl.duoc.threesoft.entities.SgaUsuario;
import cl.duoc.threesoft.persistencia.ComunaDAOSessionBean;
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
@WebServlet(name = "CargaComunaServlet", urlPatterns = {"/cargacomuna"})
public class CargaComunaServlet extends HttpServlet {

    @EJB
    private ComunaDAOSessionBean comunaDAOSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        List<SgaComuna> comunaList = comunaDAOSessionBean.comunaList();
        session.setAttribute("comunaList", comunaList);
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