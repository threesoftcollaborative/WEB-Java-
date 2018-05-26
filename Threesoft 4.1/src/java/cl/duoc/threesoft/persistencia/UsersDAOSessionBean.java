/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.persistencia;

import cl.duoc.threesoft.entities.SgaUsuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import sun.security.util.Password;

/**
 *
 * @author Max
 */
@Stateless
public class UsersDAOSessionBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    private StoredProcedureQuery spq;

//    public int validaUsuario(String username, String password) {
//        int mensaje = 0;
//        //StoredProcedureQuery storedProcedure;
//        try {
//            spq = this.em.createStoredProcedureQuery("sp_login");
//            spq.registerStoredProcedureParameter("p_user", String.class, ParameterMode.IN);
//            spq.registerStoredProcedureParameter("p_pass", String.class, ParameterMode.IN);
//            spq.registerStoredProcedureParameter("mensaje", int.class, ParameterMode.OUT);
//            
//            spq.setParameter("p_user", username);
//            spq.setParameter("p_pass", password);
//            spq.execute();
//            
//            mensaje = (int) spq.getOutputParameterValue("mensaje");
//
//        } catch (NoResultException ex) {
//            System.out.println(ex.getMessage());
//        } catch (NonUniqueResultException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return mensaje;
//    }
    
    public SgaUsuario validaUsuario(String username) {
        SgaUsuario user = null;
        try {
            spq = this.em.createStoredProcedureQuery("pkg_app_web_entorno.prc_login", SgaUsuario.class);
            spq.registerStoredProcedureParameter("p_username", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_recordset", void.class, ParameterMode.REF_CURSOR);
            
            spq.setParameter("p_username", username);
            spq.execute();
            
            user = (SgaUsuario) spq.getSingleResult();

        } catch (NoResultException ex) {
            System.out.println(ex.getMessage());
        } catch (NonUniqueResultException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }
    
//    public List<Users> userList() {
//        spq = this.em.createStoredProcedureQuery("sp_login_2");
//        spq.registerStoredProcedureParameter("p_recordset", void.class, ParameterMode.REF_CURSOR);
//        spq.execute();
//        
//        List<Users> result = (List<Users>)spq.getOutputParameterValue("p_recordset");
//        return result;
//        return em.createNamedQuery("User.findAll")
//                .getResultList();
//    }
    
}
