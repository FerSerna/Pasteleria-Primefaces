package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Detallecompraproducto;
import modelo.Proveedores;
import modelo.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:16:37")
@StaticMetamodel(Compras.class)
public class Compras_ { 

    public static volatile SingularAttribute<Compras, Date> fecha;
    public static volatile CollectionAttribute<Compras, Detallecompraproducto> detallecompraproductoCollection;
    public static volatile SingularAttribute<Compras, Double> total;
    public static volatile SingularAttribute<Compras, Double> iva;
    public static volatile SingularAttribute<Compras, Double> subtotal;
    public static volatile SingularAttribute<Compras, Users> idUsuario;
    public static volatile SingularAttribute<Compras, Proveedores> idProveedor;
    public static volatile SingularAttribute<Compras, Integer> id;
    public static volatile SingularAttribute<Compras, Integer> status;

}