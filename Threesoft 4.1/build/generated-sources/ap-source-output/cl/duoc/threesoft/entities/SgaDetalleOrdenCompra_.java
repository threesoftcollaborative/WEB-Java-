package cl.duoc.threesoft.entities;

import cl.duoc.threesoft.entities.SgaOrdenCompra;
import cl.duoc.threesoft.entities.SgaProducto;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T02:07:23")
@StaticMetamodel(SgaDetalleOrdenCompra.class)
public class SgaDetalleOrdenCompra_ { 

    public static volatile SingularAttribute<SgaDetalleOrdenCompra, SgaOrdenCompra> idOrdenCompra;
    public static volatile SingularAttribute<SgaDetalleOrdenCompra, BigDecimal> idDetalleOrdenCompra;
    public static volatile SingularAttribute<SgaDetalleOrdenCompra, BigInteger> precioCompra;
    public static volatile SingularAttribute<SgaDetalleOrdenCompra, BigInteger> cantidad;
    public static volatile SingularAttribute<SgaDetalleOrdenCompra, SgaProducto> idProducto;

}