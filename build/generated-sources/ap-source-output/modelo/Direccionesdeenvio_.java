package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Entidades;
import modelo.Envios;
import modelo.Municipios;
import modelo.Paises;
import modelo.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:16:37")
@StaticMetamodel(Direccionesdeenvio.class)
public class Direccionesdeenvio_ { 

    public static volatile SingularAttribute<Direccionesdeenvio, Paises> idPais;
    public static volatile SingularAttribute<Direccionesdeenvio, String> calle;
    public static volatile SingularAttribute<Direccionesdeenvio, Users> idUsuario;
    public static volatile SingularAttribute<Direccionesdeenvio, Integer> numExterior;
    public static volatile CollectionAttribute<Direccionesdeenvio, Envios> enviosCollection;
    public static volatile SingularAttribute<Direccionesdeenvio, Municipios> idMunicipio;
    public static volatile SingularAttribute<Direccionesdeenvio, Integer> cp;
    public static volatile SingularAttribute<Direccionesdeenvio, String> colonia;
    public static volatile SingularAttribute<Direccionesdeenvio, Entidades> idEntidad;
    public static volatile SingularAttribute<Direccionesdeenvio, String> referenciaConstruccion;
    public static volatile SingularAttribute<Direccionesdeenvio, String> referenciaCalle2;
    public static volatile SingularAttribute<Direccionesdeenvio, Integer> id;
    public static volatile SingularAttribute<Direccionesdeenvio, String> referenciaCalle1;
    public static volatile SingularAttribute<Direccionesdeenvio, Integer> status;

}