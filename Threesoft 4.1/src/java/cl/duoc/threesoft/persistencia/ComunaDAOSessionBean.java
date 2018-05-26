/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.persistencia;

import cl.duoc.threesoft.entities.SgaComuna;
import cl.duoc.threesoft.entities.SgaMarca;
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
public class ComunaDAOSessionBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    private StoredProcedureQuery spq;
    
    public List<SgaComuna> comunaList() {
        spq = this.em.createStoredProcedureQuery("pkg_app_web_entorno.prc_lst_comuna", SgaComuna.class);
        spq.registerStoredProcedureParameter("p_recordset", void.class, ParameterMode.REF_CURSOR);
        
        spq.execute();
        
        List<SgaComuna> result = (List<SgaComuna>) spq.getOutputParameterValue("p_recordset");
        return result;
    }
}
