package cl.duoc.threesoft.entities;

import cl.duoc.threesoft.entities.SgaDetalleBoleta;
import cl.duoc.threesoft.entities.SgaProducto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T02:07:23")
@StaticMetamodel(SgaDetalleProducto.class)
public class SgaDetalleProducto_ { 

    public static volatile SingularAttribute<SgaDetalleProducto, Date> fechaCaducidad;
    public static volatile SingularAttribute<SgaDetalleProducto, Character> estado;
    public static volatile ListAttribute<SgaDetalleProducto, SgaDetalleBoleta> sgaDetalleBoletaList;
    public static volatile SingularAttribute<SgaDetalleProducto, String> codBarra;
    public static volatile SingularAttribute<SgaDetalleProducto, SgaProducto> idProducto;

}