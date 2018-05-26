package cl.duoc.threesoft.entities;

import cl.duoc.threesoft.entities.SgaBoleta;
import cl.duoc.threesoft.entities.SgaCategoria;
import cl.duoc.threesoft.entities.SgaCliente;
import cl.duoc.threesoft.entities.SgaComuna;
import cl.duoc.threesoft.entities.SgaOrdenCompra;
import cl.duoc.threesoft.entities.SgaProveedor;
import cl.duoc.threesoft.entities.SgaUsuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T02:07:23")
@StaticMetamodel(SgaAlmacen.class)
public class SgaAlmacen_ { 

    public static volatile ListAttribute<SgaAlmacen, SgaCliente> sgaClienteList;
    public static volatile SingularAttribute<SgaAlmacen, Character> estado;
    public static volatile ListAttribute<SgaAlmacen, SgaOrdenCompra> sgaOrdenCompraList;
    public static volatile SingularAttribute<SgaAlmacen, BigDecimal> idAlmacen;
    public static volatile ListAttribute<SgaAlmacen, SgaBoleta> sgaBoletaList;
    public static volatile SingularAttribute<SgaAlmacen, String> direccion;
    public static volatile ListAttribute<SgaAlmacen, SgaProveedor> sgaProveedorList;
    public static volatile SingularAttribute<SgaAlmacen, SgaCategoria> idCategoria;
    public static volatile SingularAttribute<SgaAlmacen, SgaComuna> idComuna;
    public static volatile SingularAttribute<SgaAlmacen, String> nombre;
    public static volatile ListAttribute<SgaAlmacen, SgaUsuario> sgaUsuarioList;

}