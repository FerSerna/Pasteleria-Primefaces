package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Productos;
import modelo.Ventas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:16:37")
@StaticMetamodel(Detalleventaproducto.class)
public class Detalleventaproducto_ { 

    public static volatile SingularAttribute<Detalleventaproducto, Double> precioCompra;
    public static volatile SingularAttribute<Detalleventaproducto, Integer> id;
    public static volatile SingularAttribute<Detalleventaproducto, Integer> cantidad;
    public static volatile SingularAttribute<Detalleventaproducto, Productos> idProducto;
    public static volatile SingularAttribute<Detalleventaproducto, Double> precioVenta;
    public static volatile SingularAttribute<Detalleventaproducto, Integer> status;
    public static volatile SingularAttribute<Detalleventaproducto, Ventas> idVenta;

}