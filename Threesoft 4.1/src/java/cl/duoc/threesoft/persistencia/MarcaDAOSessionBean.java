/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.persistencia;

import cl.duoc.threesoft.entities.SgaMarca;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Max
 */
@Stateless
public class MarcaDAOSessionBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    private StoredProcedureQuery spq;
    
    public List<SgaMarca> marcaListById(int marca_id) {
        spq = this.em.createStoredProcedureQuery("pkg_app_web_entorno.prc_lst_marca", SgaMarca.class);
        spq.registerStoredProcedureParameter("p_id_almacen", int.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("p_recordset", void.class, ParameterMode.REF_CURSOR);
        
        spq.setParameter("p_id_almacen", marca_id);
        
        spq.execute();
        
        List<SgaMarca> result = (List<SgaMarca>) spq.getOutputParameterValue("p_recordset");
        return result;
    }
    
    
}
