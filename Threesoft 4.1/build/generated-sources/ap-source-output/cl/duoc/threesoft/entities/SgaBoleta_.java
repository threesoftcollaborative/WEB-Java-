package cl.duoc.threesoft.entities;

import cl.duoc.threesoft.entities.SgaAlmacen;
import cl.duoc.threesoft.entities.SgaCliente;
import cl.duoc.threesoft.entities.SgaDetalleBoleta;
import cl.duoc.threesoft.entities.SgaUsuario;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T02:07:23")
@StaticMetamodel(SgaBoleta.class)
public class SgaBoleta_ { 

    public static volatile SingularAttribute<SgaBoleta, BigInteger> total;
    public static volatile SingularAttribute<SgaBoleta, Character> estado;
    public static volatile ListAttribute<SgaBoleta, SgaDetalleBoleta> sgaDetalleBoletaList;
    public static volatile SingularAttribute<SgaBoleta, SgaCliente> idCliente;
    public static volatile SingularAttribute<SgaBoleta, Date> fechaBoleta;
    public static volatile SingularAttribute<SgaBoleta, BigDecimal> idBoleta;
    public static volatile SingularAttribute<SgaBoleta, SgaAlmacen> idAlmacen;
    public static volatile SingularAttribute<SgaBoleta, SgaUsuario> idUsuario;

}