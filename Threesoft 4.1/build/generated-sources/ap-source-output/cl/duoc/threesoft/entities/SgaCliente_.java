package cl.duoc.threesoft.entities;

import cl.duoc.threesoft.entities.SgaAlmacen;
import cl.duoc.threesoft.entities.SgaBoleta;
import cl.duoc.threesoft.entities.SgaComuna;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T02:07:23")
@StaticMetamodel(SgaCliente.class)
public class SgaCliente_ { 

    public static volatile SingularAttribute<SgaCliente, String> rut;
    public static volatile SingularAttribute<SgaCliente, Character> estado;
    public static volatile SingularAttribute<SgaCliente, BigDecimal> idCliente;
    public static volatile SingularAttribute<SgaCliente, Date> fechaNacimiento;
    public static volatile SingularAttribute<SgaCliente, SgaAlmacen> idAlmacen;
    public static volatile ListAttribute<SgaCliente, SgaBoleta> sgaBoletaList;
    public static volatile SingularAttribute<SgaCliente, String> apellido;
    public static volatile SingularAttribute<SgaCliente, String> direccion;
    public static volatile SingularAttribute<SgaCliente, SgaComuna> idComuna;
    public static volatile SingularAttribute<SgaCliente, BigInteger> telefono;
    public static volatile SingularAttribute<SgaCliente, String> nombre;
    public static volatile SingularAttribute<SgaCliente, String> email;

}