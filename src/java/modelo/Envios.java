/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fers15
 */
@Entity
@Table(name = "Envios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Envios.findAll", query = "SELECT e FROM Envios e")
    , @NamedQuery(name = "Envios.findById", query = "SELECT e FROM Envios e WHERE e.id = :id")
    , @NamedQuery(name = "Envios.findByNumeroGuia", query = "SELECT e FROM Envios e WHERE e.numeroGuia = :numeroGuia")
    , @NamedQuery(name = "Envios.findByFechaEnvio", query = "SELECT e FROM Envios e WHERE e.fechaEnvio = :fechaEnvio")
    , @NamedQuery(name = "Envios.findByFechaEntrega", query = "SELECT e FROM Envios e WHERE e.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "Envios.findByDescripcion", query = "SELECT e FROM Envios e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "Envios.enviosActivos", query = "SELECT e FROM Envios e WHERE e.status = 1")
    , @NamedQuery(name = "Envios.enviosEliminados", query = "SELECT e FROM Envios e WHERE e.status = 0")
    , @NamedQuery(name = "Envios.findByStatus", query = "SELECT e FROM Envios e WHERE e.status = :status")})
public class Envios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "numero_guia")
    private String numeroGuia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_envio")
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "id_paqueteria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Paqueterias idPaqueteria;
    @JoinColumn(name = "id_estados_envio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estadosdeenvio idEstadosEnvio;
    @JoinColumn(name = "id_direcciones_de_envio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Direccionesdeenvio idDireccionesDeEnvio;
    @JoinColumn(name = "id_venta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ventas idVenta;

    public Envios() {
    }

    public Envios(Integer id) {
        this.id = id;
    }

    public Envios(Integer id, String numeroGuia, Date fechaEnvio, Date fechaEntrega, String descripcion, int status) {
        this.id = id;
        this.numeroGuia = numeroGuia;
        this.fechaEnvio = fechaEnvio;
        this.fechaEntrega = fechaEntrega;
        this.descripcion = descripcion;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Paqueterias getIdPaqueteria() {
        return idPaqueteria;
    }

    public void setIdPaqueteria(Paqueterias idPaqueteria) {
        this.idPaqueteria = idPaqueteria;
    }

    public Estadosdeenvio getIdEstadosEnvio() {
        return idEstadosEnvio;
    }

    public void setIdEstadosEnvio(Estadosdeenvio idEstadosEnvio) {
        this.idEstadosEnvio = idEstadosEnvio;
    }

    public Direccionesdeenvio getIdDireccionesDeEnvio() {
        return idDireccionesDeEnvio;
    }

    public void setIdDireccionesDeEnvio(Direccionesdeenvio idDireccionesDeEnvio) {
        this.idDireccionesDeEnvio = idDireccionesDeEnvio;
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
        if (!(object instanceof Envios)) {
            return false;
        }
        Envios other = (Envios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Envios[ id=" + id + " ]";
    }
    
}
