package cl.duoc.threesoft.entities;

import cl.duoc.threesoft.entities.SgaPerfil;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T02:07:23")
@StaticMetamodel(SgaMenu.class)
public class SgaMenu_ { 

    public static volatile SingularAttribute<SgaMenu, String> descripcion;
    public static volatile SingularAttribute<SgaMenu, Character> estado;
    public static volatile SingularAttribute<SgaMenu, SgaPerfil> idPerfil;
    public static volatile SingularAttribute<SgaMenu, Long> idMenu;
    public static volatile SingularAttribute<SgaMenu, Long> padreMenu;
    public static volatile SingularAttribute<SgaMenu, String> destino;

}