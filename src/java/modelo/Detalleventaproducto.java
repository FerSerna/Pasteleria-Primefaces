/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fers15
 */
@Entity
@Table(name = "Detalle_venta_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleventaproducto.findAll", query = "SELECT d FROM Detalleventaproducto d")
    , @NamedQuery(name = "Detalleventaproducto.findById", query = "SELECT d FROM Detalleventaproducto d WHERE d.id = :id")
    , @NamedQuery(name = "Detalleventaproducto.findByCantidad", query = "SELECT d FROM Detalleventaproducto d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detalleventaproducto.findByPrecioCompra", query = "SELECT d FROM Detalleventaproducto d WHERE d.precioCompra = :precioCompra")
    , @NamedQuery(name = "Detalleventaproducto.findByPrecioVenta", query = "SELECT d FROM Detalleventaproducto d WHERE d.precioVenta = :precioVenta")
    , @NamedQuery(name = "Detalleventaproducto.detalleVentaProductoActivos", query = "SELECT d FROM Detalleventaproducto d WHERE d.status = 1")
    , @NamedQuery(name = "Detalleventaproducto.detalleVentaProductoEliminados", query = "SELECT d FROM Detalleventaproducto d WHERE d.status = 0")
    , @NamedQuery(name = "Detalleventaproducto.findByStatus", query = "SELECT d FROM Detalleventaproducto d WHERE d.status = :status")})
public class Detalleventaproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_compra")
    private double precioCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private double precioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Productos idProducto;
    @JoinColumn(name = "id_venta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ventas idVenta;

    public Detalleventaproducto() {
    }

    public Detalleventaproducto(Integer id) {
        this.id = id;
    }

    public Detalleventaproducto(Integer id, int cantidad, double precioCompra, double precioVenta, int status) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    public Ventas getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Ventas idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleventaproducto)) {
            return false;
        }
        Detalleventaproducto other = (Detalleventaproducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Detalleventaproducto[ id=" + id + " ]";
    }
    
}
