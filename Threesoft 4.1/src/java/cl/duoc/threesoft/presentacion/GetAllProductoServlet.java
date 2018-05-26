/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.presentacion;

import cl.duoc.threesoft.entities.SgaAlmacen;
import cl.duoc.threesoft.entities.SgaProducto;
import cl.duoc.threesoft.entities.SgaUsuario;
//import cl.duoc.threesoft.entities.Users;
import cl.duoc.threesoft.persistencia.ProductoDAOSessionBean;
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
@WebServlet(name = "GetAllProductoServlet", urlPatterns = {"/getallproducto"})
public class GetAllProductoServlet extends HttpServlet {

@EJB
    private ProductoDAOSessionBean productoDAOSessionBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        SgaUsuario loggedUser = (SgaUsuario) request.getSession().getAttribute("usuarioConectado");
        int almacen_id = toIntExact(loggedUser.getIdAlmacen().getIdAlmacen().intValueExact());
        List<SgaProducto> productList = this.productoDAOSessionBean.productListById(almacen_id);
        session.setAttribute("productList", productList);
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
