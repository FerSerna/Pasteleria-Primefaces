package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:16:37")
@StaticMetamodel(Tarjetas.class)
public class Tarjetas_ { 

    public static volatile SingularAttribute<Tarjetas, Integer> mesExpiracion;
    public static volatile SingularAttribute<Tarjetas, String> tipoTarjeta;
    public static volatile SingularAttribute<Tarjetas, Users> idUsuario;
    public static volatile SingularAttribute<Tarjetas, Integer> anioExpiracion;
    public static volatile SingularAttribute<Tarjetas, Integer> id;
    public static volatile SingularAttribute<Tarjetas, Integer> numeroCVV;
    public static volatile SingularAttribute<Tarjetas, Integer> numeroTarjeta;
    public static volatile SingularAttribute<Tarjetas, Integer> status;

}