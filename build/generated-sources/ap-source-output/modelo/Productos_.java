package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Categorias;
import modelo.Detallecompraproducto;
import modelo.Detalleventaproducto;
import modelo.Fotosproductos;
import modelo.Proveedores;
import modelo.Sabores;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:16:37")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, String> descripcion;
    public static volatile SingularAttribute<Productos, Double> pesoEnGramos;
    public static volatile CollectionAttribute<Productos, Detalleventaproducto> detalleventaproductoCollection;
    public static volatile SingularAttribute<Productos, String> nombre;
    public static volatile SingularAttribute<Productos, Sabores> idSabor;
    public static volatile SingularAttribute<Productos, Integer> existencia;
    public static volatile CollectionAttribute<Productos, Detallecompraproducto> detallecompraproductoCollection;
    public static volatile SingularAttribute<Productos, Double> precioCompra;
    public static volatile SingularAttribute<Productos, Proveedores> idProveedor;
    public static volatile CollectionAttribute<Productos, Fotosproductos> fotosproductosCollection;
    public static volatile SingularAttribute<Productos, Integer> id;
    public static volatile SingularAttribute<Productos, Integer> rebanadasTotales;
    public static volatile SingularAttribute<Productos, Double> precioVenta;
    public static volatile SingularAttribute<Productos, Integer> stock;
    public static volatile SingularAttribute<Productos, Categorias> idCategoria;
    public static volatile SingularAttribute<Productos, Integer> status;

}