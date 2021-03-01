package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Direccionesdeenvio;
import modelo.Municipios;
import modelo.Paises;
import modelo.Proveedores;
import modelo.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:16:37")
@StaticMetamodel(Entidades.class)
public class Entidades_ { 

    public static volatile CollectionAttribute<Entidades, Direccionesdeenvio> direccionesdeenvioCollection;
    public static volatile CollectionAttribute<Entidades, Proveedores> proveedoresCollection;
    public static volatile SingularAttribute<Entidades, Paises> idPais;
    public static volatile SingularAttribute<Entidades, Integer> id;
    public static volatile CollectionAttribute<Entidades, Users> usersCollection;
    public static volatile SingularAttribute<Entidades, String> nombre;
    public static volatile CollectionAttribute<Entidades, Municipios> municipiosCollection;
    public static volatile SingularAttribute<Entidades, Integer> status;

}