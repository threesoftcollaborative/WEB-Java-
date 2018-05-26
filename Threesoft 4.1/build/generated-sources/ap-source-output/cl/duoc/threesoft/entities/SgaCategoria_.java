package cl.duoc.threesoft.entities;

import cl.duoc.threesoft.entities.SgaAlmacen;
import cl.duoc.threesoft.entities.SgaMarca;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T02:07:23")
@StaticMetamodel(SgaCategoria.class)
public class SgaCategoria_ { 

    public static volatile SingularAttribute<SgaCategoria, String> descripcion;
    public static volatile ListAttribute<SgaCategoria, SgaMarca> sgaMarcaList;
    public static volatile ListAttribute<SgaCategoria, SgaAlmacen> sgaAlmacenList;
    public static volatile SingularAttribute<SgaCategoria, Character> estado;
    public static volatile SingularAttribute<SgaCategoria, BigDecimal> idCategoria;

}