package cl.duoc.threesoft.entities;

import cl.duoc.threesoft.entities.SgaAlmacen;
import cl.duoc.threesoft.entities.SgaDetalleOrdenCompra;
import cl.duoc.threesoft.entities.SgaProveedor;
import cl.duoc.threesoft.entities.SgaUsuario;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T02:07:23")
@StaticMetamodel(SgaOrdenCompra.class)
public class SgaOrdenCompra_ { 

    public static volatile SingularAttribute<SgaOrdenCompra, BigDecimal> idOrdenCompra;
    public static volatile SingularAttribute<SgaOrdenCompra, Date> fechaOrdenCompra;
    public static volatile SingularAttribute<SgaOrdenCompra, BigInteger> total;
    public static volatile SingularAttribute<SgaOrdenCompra, Character> estado;
    public static volatile SingularAttribute<SgaOrdenCompra, SgaAlmacen> idAlmacen;
    public static volatile SingularAttribute<SgaOrdenCompra, SgaProveedor> idProveedor;
    public static volatile SingularAttribute<SgaOrdenCompra, SgaUsuario> idUsuario;
    public static volatile ListAttribute<SgaOrdenCompra, SgaDetalleOrdenCompra> sgaDetalleOrdenCompraList;
    public static volatile SingularAttribute<SgaOrdenCompra, Date> fechaRecepcion;

}