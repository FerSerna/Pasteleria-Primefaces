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
@Table(name = "Detalle_compra_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallecompraproducto.findAll", query = "SELECT d FROM Detallecompraproducto d")
    , @NamedQuery(name = "Detallecompraproducto.findById", query = "SELECT d FROM Detallecompraproducto d WHERE d.id = :id")
    , @NamedQuery(name = "Detallecompraproducto.findByCantidad", query = "SELECT d FROM Detallecompraproducto d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detallecompraproducto.findByPrecioCompra", query = "SELECT d FROM Detallecompraproducto d WHERE d.precioCompra = :precioCompra")
    , @NamedQuery(name = "Detallecompraproducto.findByPrecioVenta", query = "SELECT d FROM Detallecompraproducto d WHERE d.precioVenta = :precioVenta")
    , @NamedQuery(name = "Detallecompraproducto.detalleCompraProductoActivos", query = "SELECT d FROM Detallecompraproducto d WHERE d.status = 1")
    , @NamedQuery(name = "Detallecompraproducto.detalleCompraProductoEliminados", query = "SELECT d FROM Detallecompraproducto d WHERE d.status = 0")
    , @NamedQuery(name = "Detallecompraproducto.findByStatus", query = "SELECT d FROM Detallecompraproducto d WHERE d.status = :status")})
public class Detallecompraproducto implements Serializable {

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
    @JoinColumn(name = "id_compra", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Compras idCompra;

    public Detallecompraproducto() {
    }

    public Detallecompraproducto(Integer id) {
        this.id = id;
    }

    public Detallecompraproducto(Integer id, int cantidad, double precioCompra, double precioVenta, int status) {
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

    public Compras getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compras idCompra) {
        this.idCompra = idCompra;
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
        if (!(object instanceof Detallecompraproducto)) {
            return false;
        }
        Detallecompraproducto other = (Detallecompraproducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Detallecompraproducto[ id=" + id + " ]";
    }
    
}
