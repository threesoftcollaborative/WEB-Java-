package cl.duoc.threesoft.entities;

import cl.duoc.threesoft.entities.SgaAlmacen;
import cl.duoc.threesoft.entities.SgaCliente;
import cl.duoc.threesoft.entities.SgaProveedor;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T02:07:23")
@StaticMetamodel(SgaComuna.class)
public class SgaComuna_ { 

    public static volatile ListAttribute<SgaComuna, SgaCliente> sgaClienteList;
    public static volatile ListAttribute<SgaComuna, SgaAlmacen> sgaAlmacenList;
    public static volatile SingularAttribute<SgaComuna, Character> estado;
    public static volatile SingularAttribute<SgaComuna, String> comuna;
    public static volatile SingularAttribute<SgaComuna, BigDecimal> idComuna;
    public static volatile ListAttribute<SgaComuna, SgaProveedor> sgaProveedorList;

}