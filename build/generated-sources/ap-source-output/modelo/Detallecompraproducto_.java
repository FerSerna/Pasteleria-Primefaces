package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Compras;
import modelo.Productos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:16:37")
@StaticMetamodel(Detallecompraproducto.class)
public class Detallecompraproducto_ { 

    public static volatile SingularAttribute<Detallecompraproducto, Double> precioCompra;
    public static volatile SingularAttribute<Detallecompraproducto, Compras> idCompra;
    public static volatile SingularAttribute<Detallecompraproducto, Integer> id;
    public static volatile SingularAttribute<Detallecompraproducto, Integer> cantidad;
    public static volatile SingularAttribute<Detallecompraproducto, Productos> idProducto;
    public static volatile SingularAttribute<Detallecompraproducto, Double> precioVenta;
    public static volatile SingularAttribute<Detallecompraproducto, Integer> status;

}