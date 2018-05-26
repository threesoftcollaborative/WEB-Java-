/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.threesoft.persistencia;

import cl.duoc.threesoft.entities.SgaAlmacen;
import cl.duoc.threesoft.entities.SgaProducto;
//import cl.duoc.threesoft.entities.Warehouse;
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
public class ProductoDAOSessionBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    private StoredProcedureQuery spq;

    public List<SgaProducto> productListById(int almacen_id) {
        spq = this.em.createStoredProcedureQuery("pkg_app_web_producto.prc_lst_producto", SgaProducto.class);
        spq.registerStoredProcedureParameter("p_id_almacen", int.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("p_recordset", void.class, ParameterMode.REF_CURSOR);

        spq.setParameter("p_id_almacen", almacen_id);

        spq.execute();

        List<SgaProducto> result = (List<SgaProducto>) spq.getOutputParameterValue("p_recordset");
        return result;
    }
    
    public List<SgaProducto> productListByIdProveedor(int proveedor_id) {
        spq = this.em.createStoredProcedureQuery("pkg_app_web_producto.prc_lst_producto", SgaProducto.class);
        spq.registerStoredProcedureParameter("p_id_almacen", int.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("p_recordset", void.class, ParameterMode.REF_CURSOR);

        spq.setParameter("p_id_almacen", proveedor_id);

        spq.execute();

        List<SgaProducto> result = (List<SgaProducto>) spq.getOutputParameterValue("p_recordset");
        return result;
    }

    public SgaProducto productoById(int product_id) {
        SgaProducto product = null;
        try {
            spq = this.em.createStoredProcedureQuery("pkg_app_web_producto.prc_lst_id_producto", SgaProducto.class);
            spq.registerStoredProcedureParameter("p_id_producto", int.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_recordset", void.class, ParameterMode.REF_CURSOR);

            spq.setParameter("p_id_producto", product_id);
            spq.execute();

            product = (SgaProducto) spq.getSingleResult();

        } catch (NoResultException ex) {
            System.out.println(ex.getMessage());
        } catch (NonUniqueResultException ex) {
            System.out.println(ex.getMessage());
        }
        return product;
    }
    
    public int existeProducto(String nombre_producto) {
        int existe = 0;
        try {
            spq = this.em.createStoredProcedureQuery("pkg_app_web_existencia.prc_existe_producto", int.class);
            spq.registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_mensaje", int.class, ParameterMode.OUT);

            spq.setParameter("p_nombre", nombre_producto);
            spq.execute();

            existe = (int) spq.getOutputParameterValue("p_mensaje");

        } catch (NoResultException ex) {
            System.out.println(ex.getMessage());
        } catch (NonUniqueResultException ex) {
            System.out.println(ex.getMessage());
        }
        return existe;
    }

    public Boolean insertProduct(String nombre, int compra, int venta, int stock, int marca) {
        try {

            spq = this.em.createStoredProcedureQuery("pkg_app_web_producto.prc_add_producto");
            spq.registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_precio_compra", int.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_precio_venta", int.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_stock", int.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_id_marca", int.class, ParameterMode.IN);

            spq.setParameter("p_nombre", nombre);
            spq.setParameter("p_precio_compra", compra);
            spq.setParameter("p_precio_venta", venta);
            spq.setParameter("p_stock", stock);
            spq.setParameter("p_id_marca", marca);

            spq.execute();

            return true;

        } catch (NoResultException ex) {
            System.out.println(ex.getMessage());
        } catch (NonUniqueResultException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    public Boolean updateProducto(int id_producto, String nombre, int compra, int venta) {

        try {

            spq = this.em.createStoredProcedureQuery("pkg_app_web_producto.prc_upd_producto");
            spq.registerStoredProcedureParameter("p_id_producto", int.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_nombre", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_precio_compra", int.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("p_precio_venta", int.class, ParameterMode.IN);

            spq.setParameter("p_id_producto", id_producto);
            spq.setParameter("p_nombre", nombre);
            spq.setParameter("p_precio_compra", compra);
            spq.setParameter("p_precio_venta", venta);

            spq.execute();

            return true;
        } catch (NoResultException ex) {
            System.out.println(ex.getMessage());
        } catch (NonUniqueResultException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }
    
    public Boolean disableProducto(int id_producto){
        
        try {

            spq = this.em.createStoredProcedureQuery("pkg_app_web_producto.prc_del_producto");
            spq.registerStoredProcedureParameter("p_id_producto", int.class, ParameterMode.IN);


            spq.setParameter("p_id_producto", id_producto);

            spq.execute();

            return true;
        } catch (NoResultException ex) {
            System.out.println(ex.getMessage());
        } catch (NonUniqueResultException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

//    public Warehouse buscaClienteXid(int id) {
//        Warehouse cliente = null;
//        try {
//
//        } catch (NoResultException ex) {
//            System.out.println(ex.getMessage());
//        } catch (NonUniqueResultException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return cliente;
//    }
}
