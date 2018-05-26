package cl.duoc.threesoft.entities;

import cl.duoc.threesoft.entities.SgaBoleta;
import cl.duoc.threesoft.entities.SgaDetalleProducto;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T02:07:23")
@StaticMetamodel(SgaDetalleBoleta.class)
public class SgaDetalleBoleta_ { 

    public static volatile SingularAttribute<SgaDetalleBoleta, BigDecimal> idDetalleBoleta;
    public static volatile SingularAttribute<SgaDetalleBoleta, SgaDetalleProducto> codBarra;
    public static volatile SingularAttribute<SgaDetalleBoleta, SgaBoleta> idBoleta;
    public static volatile SingularAttribute<SgaDetalleBoleta, BigInteger> precioVenta;

}