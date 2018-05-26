package cl.duoc.threesoft.entities;

import cl.duoc.threesoft.entities.SgaAlmacen;
import cl.duoc.threesoft.entities.SgaBoleta;
import cl.duoc.threesoft.entities.SgaOrdenCompra;
import cl.duoc.threesoft.entities.SgaPerfil;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T02:07:23")
@StaticMetamodel(SgaUsuario.class)
public class SgaUsuario_ { 

    public static volatile SingularAttribute<SgaUsuario, Character> estado;
    public static volatile ListAttribute<SgaUsuario, SgaOrdenCompra> sgaOrdenCompraList;
    public static volatile SingularAttribute<SgaUsuario, String> pass;
    public static volatile SingularAttribute<SgaUsuario, SgaPerfil> idPerfil;
    public static volatile SingularAttribute<SgaUsuario, BigDecimal> idUsuario;
    public static volatile ListAttribute<SgaUsuario, SgaBoleta> sgaBoletaList;
    public static volatile SingularAttribute<SgaUsuario, SgaAlmacen> idAlmacen;
    public static volatile SingularAttribute<SgaUsuario, String> usuario;
    public static volatile SingularAttribute<SgaUsuario, String> email;

}