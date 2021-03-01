package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Detalleventaproducto;
import modelo.Envios;
import modelo.Tipospago;
import modelo.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:16:37")
@StaticMetamodel(Ventas.class)
public class Ventas_ { 

    public static volatile SingularAttribute<Ventas, Date> fecha;
    public static volatile SingularAttribute<Ventas, Double> total;
    public static volatile SingularAttribute<Ventas, Tipospago> idTipoPago;
    public static volatile SingularAttribute<Ventas, Double> iva;
    public static volatile SingularAttribute<Ventas, Double> subtotal;
    public static volatile CollectionAttribute<Ventas, Detalleventaproducto> detalleventaproductoCollection;
    public static volatile SingularAttribute<Ventas, Users> idUsuario;
    public static volatile CollectionAttribute<Ventas, Envios> enviosCollection;
    public static volatile SingularAttribute<Ventas, Integer> id;
    public static volatile SingularAttribute<Ventas, Integer> status;

}