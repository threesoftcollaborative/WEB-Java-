/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.persistencia;


import cl.duoc.threesoft.entities.SgaMenu;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Max
 */
@Stateless
public class MenuDAOSessionBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    private StoredProcedureQuery spq;

    public List<SgaMenu> menuListById(int profile_id) {
        spq = this.em.createStoredProcedureQuery("pkg_app_web_entorno.prc_obtener_menu", SgaMenu.class);
        spq.registerStoredProcedureParameter("p_id_perfil", int.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("p_recordset", void.class, ParameterMode.REF_CURSOR);
        
        spq.setParameter("p_id_perfil", profile_id);
        
        spq.execute();
        
        List<SgaMenu> result = (List<SgaMenu>) spq.getOutputParameterValue("p_recordset");
        return result;
    }
}
