/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.persistencia;

import cl.duoc.threesoft.entities.SgaProducto;
import cl.duoc.threesoft.entities.SgaProveedor;
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
public class ProveedorDAOSessionBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    private StoredProcedureQuery spq;

    public List<SgaProveedor> proveedorListById(int almacen_id) {
        spq = this.em.createStoredProcedureQuery("pkg_app_web_proveedor.prc_lst_proveedor", SgaProveedor.class);
        spq.registerStoredProcedureParameter("p_id_almacen", int.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("p_recordset", void.class, ParameterMode.REF_CURSOR);

        spq.setParameter("p_id_almacen", almacen_id);

        spq.execute();

        List<SgaProveedor> result = (List<SgaProveedor>) spq.getOutputParameterValue("p_recordset");
        return result;
    }
    
    public int existeProveedor(String nombre_proveedor, String rut) {
        int existe = 0;
        try {
            spq = this.em.createStoredProcedureQuery("pkg_app_web_existencia.prc_existe_proveedor", int.class);
            spq.registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_rut", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_mensaje", int.class, ParameterMode.OUT);

            spq.setParameter("p_nombre", nombre_proveedor);
            spq.setParameter("p_rut", rut);
            spq.execute();

            existe = (int) spq.getOutputParameterValue("p_mensaje");

        } catch (NoResultException ex) {
            System.out.println(ex.getMessage());
        } catch (NonUniqueResultException ex) {
            System.out.println(ex.getMessage());
        }
        return existe;
    }
    
    public Boolean insertProveedor(String nombre, String rut, int telefono, String email, String direccion, int id_comuna, int id_almacen) {
        try {

            spq = this.em.createStoredProcedureQuery("pkg_app_web_proveedor.prc_add_proveedor");
            spq.registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_rut", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_fono", int.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_email", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_direccion", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_id_comuna", int.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_id_almacen", int.class, ParameterMode.IN);

            spq.setParameter("p_nombre", nombre);
            spq.setParameter("p_rut", rut);
            spq.setParameter("p_fono", telefono);
            spq.setParameter("p_email", email);
            spq.setParameter("p_direccion", direccion);
            spq.setParameter("p_id_comuna", id_comuna);
            spq.setParameter("p_id_almacen", id_almacen);

            spq.execute();

            return true;

        } catch (NoResultException ex) {
            System.out.println(ex.getMessage());
        } catch (NonUniqueResultException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }
    
    public SgaProveedor proveedorById(int proveedor_id) {
        SgaProveedor product = null;
        try {
            spq = this.em.createStoredProcedureQuery("pkg_app_web_proveedor.prc_lst_id_proveedor", SgaProveedor.class);
            spq.registerStoredProcedureParameter("p_id_proveedor", int.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_recordset", void.class, ParameterMode.REF_CURSOR);

            spq.setParameter("p_id_proveedor", proveedor_id);
            spq.execute();

            product = (SgaProveedor) spq.getSingleResult();

        } catch (NoResultException ex) {
            System.out.println(ex.getMessage());
        } catch (NonUniqueResultException ex) {
            System.out.println(ex.getMessage());
        }
        return product;
    }
    
    public Boolean updateProveedor(int id_proveedor, String nombre, String rut, int telefono, String email, String direccion, int id_comuna) {

        try {

            spq = this.em.createStoredProcedureQuery("pkg_app_web_proveedor.prc_upd_proveedor");
            spq.registerStoredProcedureParameter("p_id_proveedor", int.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_rut", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_fono", int.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_email", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_direccion", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_id_comuna", int.class, ParameterMode.IN);

            spq.setParameter("p_id_proveedor", id_proveedor);
            spq.setParameter("p_nombre", nombre);
            spq.setParameter("p_rut", rut);
            spq.setParameter("p_fono", telefono);
            spq.setParameter("p_email", email);
            spq.setParameter("p_direccion", direccion);
            spq.setParameter("p_id_comuna", id_comuna);

            spq.execute();

            return true;
        } catch (NoResultException ex) {
            System.out.println(ex.getMessage());
        } catch (NonUniqueResultException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }
    
    public Boolean disableProveedor(int id_proveedor){
        
        try {

            spq = this.em.createStoredProcedureQuery("pkg_app_web_proveedor.prc_del_proveedor");
            spq.registerStoredProcedureParameter("p_id_proveedor", int.class, ParameterMode.IN);


            spq.setParameter("p_id_proveedor", id_proveedor);

            spq.execute();

            return true;
        } catch (NoResultException ex) {
            System.out.println(ex.getMessage());
        } catch (NonUniqueResultException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }
    
}
