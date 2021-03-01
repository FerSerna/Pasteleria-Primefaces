package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:16:37")
@StaticMetamodel(Tiposusuario.class)
public class Tiposusuario_ { 

    public static volatile SingularAttribute<Tiposusuario, Integer> id;
    public static volatile CollectionAttribute<Tiposusuario, Users> usersCollection;
    public static volatile SingularAttribute<Tiposusuario, String> nombre;
    public static volatile SingularAttribute<Tiposusuario, Integer> nivel;
    public static volatile SingularAttribute<Tiposusuario, Integer> status;

}