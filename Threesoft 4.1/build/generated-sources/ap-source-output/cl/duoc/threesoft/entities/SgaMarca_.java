package cl.duoc.threesoft.entities;

import cl.duoc.threesoft.entities.SgaCategoria;
import cl.duoc.threesoft.entities.SgaProducto;
import cl.duoc.threesoft.entities.SgaProveedor;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T02:07:23")
@StaticMetamodel(SgaMarca.class)
public class SgaMarca_ { 

    public static volatile SingularAttribute<SgaMarca, String> marca;
    public static volatile SingularAttribute<SgaMarca, Character> estado;
    public static volatile SingularAttribute<SgaMarca, SgaProveedor> idProveedor;
    public static volatile SingularAttribute<SgaMarca, BigDecimal> idMarca;
    public static volatile SingularAttribute<SgaMarca, SgaCategoria> idCategoria;
    public static volatile ListAttribute<SgaMarca, SgaProducto> sgaProductoList;

}