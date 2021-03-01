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
@StaticMetamodel(Municipios.class)
public class Municipios_ { 

    public static volatile SingularAttribute<Municipios, Entidades> idEntidad;
    public static volatile CollectionAttribute<Municipios, Direccionesdeenvio> direccionesdeenvioCollection;
    public static volatile CollectionAttribute<Municipios, Proveedores> proveedoresCollection;
    public static volatile SingularAttribute<Municipios, Integer> id;
    public static volatile CollectionAttribute<Municipios, Users> usersCollection;
    public static volatile SingularAttribute<Municipios, String> nombre;
    public static volatile SingularAttribute<Municipios, Integer> status;

}