package cl.duoc.threesoft.entities;

import cl.duoc.threesoft.entities.SgaAlmacen;
import cl.duoc.threesoft.entities.SgaComuna;
import cl.duoc.threesoft.entities.SgaMarca;
import cl.duoc.threesoft.entities.SgaOrdenCompra;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T02:07:23")
@StaticMetamodel(SgaProveedor.class)
public class SgaProveedor_ { 

    public static volatile SingularAttribute<SgaProveedor, String> rut;
    public static volatile ListAttribute<SgaProveedor, SgaMarca> sgaMarcaList;
    public static volatile SingularAttribute<SgaProveedor, Character> estado;
    public static volatile ListAttribute<SgaProveedor, SgaOrdenCompra> sgaOrdenCompraList;
    public static volatile SingularAttribute<SgaProveedor, BigDecimal> idProveedor;
    public static volatile SingularAttribute<SgaProveedor, SgaAlmacen> idAlmacen;
    public static volatile SingularAttribute<SgaProveedor, String> direccion;
    public static volatile SingularAttribute<SgaProveedor, BigInteger> fono;
    public static volatile SingularAttribute<SgaProveedor, SgaComuna> idComuna;
    public static volatile SingularAttribute<SgaProveedor, String> nombre;
    public static volatile SingularAttribute<SgaProveedor, String> email;

}