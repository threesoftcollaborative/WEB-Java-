package cl.duoc.threesoft.entities;

import cl.duoc.threesoft.entities.SgaDetalleOrdenCompra;
import cl.duoc.threesoft.entities.SgaDetalleProducto;
import cl.duoc.threesoft.entities.SgaMarca;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T02:07:23")
@StaticMetamodel(SgaProducto.class)
public class SgaProducto_ { 

    public static volatile SingularAttribute<SgaProducto, Character> estado;
    public static volatile SingularAttribute<SgaProducto, BigInteger> precioCompra;
    public static volatile SingularAttribute<SgaProducto, BigDecimal> idProducto;
    public static volatile ListAttribute<SgaProducto, SgaDetalleOrdenCompra> sgaDetalleOrdenCompraList;
    public static volatile SingularAttribute<SgaProducto, BigInteger> precioVenta;
    public static volatile SingularAttribute<SgaProducto, BigInteger> stock;
    public static volatile ListAttribute<SgaProducto, SgaDetalleProducto> sgaDetalleProductoList;
    public static volatile SingularAttribute<SgaProducto, SgaMarca> idMarca;
    public static volatile SingularAttribute<SgaProducto, String> nombre;

}