package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Direccionesdeenvio;
import modelo.Entidades;
import modelo.Proveedores;
import modelo.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:16:37")
@StaticMetamodel(Paises.class)
public class Paises_ { 

    public static volatile CollectionAttribute<Paises, Direccionesdeenvio> direccionesdeenvioCollection;
    public static volatile SingularAttribute<Paises, String> clave;
    public static volatile CollectionAttribute<Paises, Proveedores> proveedoresCollection;
    public static volatile SingularAttribute<Paises, Integer> id;
    public static volatile CollectionAttribute<Paises, Users> usersCollection;
    public static volatile SingularAttribute<Paises, String> nombre;
    public static volatile CollectionAttribute<Paises, Entidades> entidadesCollection;
    public static volatile SingularAttribute<Paises, Integer> status;

}