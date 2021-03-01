package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Compras;
import modelo.Direccionesdeenvio;
import modelo.Entidades;
import modelo.Municipios;
import modelo.Paises;
import modelo.Tarjetas;
import modelo.Tiposusuario;
import modelo.Ventas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:16:37")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile CollectionAttribute<Users, Direccionesdeenvio> direccionesdeenvioCollection;
    public static volatile CollectionAttribute<Users, Compras> comprasCollection;
    public static volatile SingularAttribute<Users, Date> fechaNacimiento;
    public static volatile SingularAttribute<Users, Paises> idPais;
    public static volatile SingularAttribute<Users, String> calle;
    public static volatile CollectionAttribute<Users, Ventas> ventasCollection;
    public static volatile SingularAttribute<Users, Municipios> idMunicipio;
    public static volatile SingularAttribute<Users, String> nombre;
    public static volatile SingularAttribute<Users, Integer> cp;
    public static volatile SingularAttribute<Users, Tiposusuario> idTiposUsuarios;
    public static volatile SingularAttribute<Users, String> colonia;
    public static volatile SingularAttribute<Users, Entidades> idEntidad;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, String> apMat;
    public static volatile SingularAttribute<Users, String> telefono;
    public static volatile CollectionAttribute<Users, Tarjetas> tarjetasCollection;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> apPat;
    public static volatile SingularAttribute<Users, String> username;
    public static volatile SingularAttribute<Users, Integer> status;

}