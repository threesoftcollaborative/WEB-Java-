package cl.duoc.threesoft.entities;

import cl.duoc.threesoft.entities.SgaMenu;
import cl.duoc.threesoft.entities.SgaUsuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T02:07:23")
@StaticMetamodel(SgaPerfil.class)
public class SgaPerfil_ { 

    public static volatile SingularAttribute<SgaPerfil, String> descripcion;
    public static volatile SingularAttribute<SgaPerfil, Character> estado;
    public static volatile SingularAttribute<SgaPerfil, BigDecimal> idPerfil;
    public static volatile ListAttribute<SgaPerfil, SgaMenu> sgaMenuList;
    public static volatile ListAttribute<SgaPerfil, SgaUsuario> sgaUsuarioList;

}