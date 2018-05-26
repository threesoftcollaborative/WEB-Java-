/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.persistencia;

import cl.duoc.threesoft.entities.SgaCliente;
import cl.duoc.threesoft.entities.SgaProducto;
import java.util.Date;
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
public class ClienteDAOSessionBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    private StoredProcedureQuery spq;

    public List<SgaCliente> clienteListById(int almacen_id) {
        spq = this.em.createStoredProcedureQuery("pkg_app_web_cliente.prc_lst_cliente", SgaCliente.class);
        spq.registerStoredProcedureParameter("p_id_almacen", int.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("p_recordset", void.class, ParameterMode.REF_CURSOR);

        spq.setParameter("p_id_almacen", almacen_id);

        spq.execute();

        List<SgaCliente> result = (List<SgaCliente>) spq.getOutputParameterValue("p_recordset");
        return result;
    }
    
    public SgaCliente clienteById(int cliente_id) {
        SgaCliente cliente = null;
        try {
            spq = this.em.createStoredProcedureQuery("pkg_app_web_cliente.prc_lst_id_cliente", SgaCliente.class);
            spq.registerStoredProcedureParameter("p_id_cliente", int.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_recordset", void.class, ParameterMode.REF_CURSOR);

            spq.setParameter("p_id_cliente", cliente_id);
            spq.execute();

            cliente = (SgaCliente) spq.getSingleResult();

        } catch (NoResultException ex) {
            System.out.println(ex.getMessage());
        } catch (NonUniqueResultException ex) {
            System.out.println(ex.getMessage());
        }
        return cliente;
    }
    
    public int existeCliente(String rut) {
        int existe = 0;
        try {
            spq = this.em.createStoredProcedureQuery("pkg_app_web_existencia.prc_existe_cliente", int.class);
            spq.registerStoredProcedureParameter("p_rut", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_mensaje", int.class, ParameterMode.OUT);

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
    
    public Boolean insertCliente(String rut, String nombre, String apellido, int telefono, String email, Date fecha_nacimiento, String direccion, int id_almacen, int id_comuna) {
        try {

            spq = this.em.createStoredProcedureQuery("pkg_app_web_cliente.prc_add_cliente");
            spq.registerStoredProcedureParameter("p_rut", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_apellido", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_telefono", int.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_email", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_fecha_nacimiento", Date.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_direccion", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_id_almacen", int.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_id_comuna", int.class, ParameterMode.IN);


            spq.setParameter("p_rut", rut);
            spq.setParameter("p_nombre", nombre);
            spq.setParameter("p_apellido", apellido);
            spq.setParameter("p_telefono", telefono);
            spq.setParameter("p_email", email);
            spq.setParameter("p_fecha_nacimiento", fecha_nacimiento);
            spq.setParameter("p_direccion", direccion);
            spq.setParameter("p_id_almacen", id_almacen);
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
    
    public Boolean updateCliente(int cliente_id, String nombre, String apellido, int telefono, String email, Date fecha_nacimiento, String direccion, int id_comuna) {
        try {

            spq = this.em.createStoredProcedureQuery("pkg_app_web_cliente.prc_upd_cliente");
            spq.registerStoredProcedureParameter("p_id_cliente", int.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_apellido", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_telefono", int.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_email", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_fecha_nacimiento", Date.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_direccion", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_id_comuna", int.class, ParameterMode.IN);


            spq.setParameter("p_id_cliente", cliente_id);
            spq.setParameter("p_nombre", nombre);
            spq.setParameter("p_apellido", apellido);
            spq.setParameter("p_telefono", telefono);
            spq.setParameter("p_email", email);
            spq.setParameter("p_fecha_nacimiento", fecha_nacimiento);
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
    
    public Boolean disableCliente(int cliente_id){
        
        try {

            spq = this.em.createStoredProcedureQuery("pkg_app_web_cliente.prc_del_cliente");
            spq.registerStoredProcedureParameter("p_id_cliente", int.class, ParameterMode.IN);

            spq.setParameter("p_id_cliente", cliente_id);

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
