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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fers15
 */
@Entity
@Table(name = "Tarjetas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjetas.findAll", query = "SELECT t FROM Tarjetas t")
    , @NamedQuery(name = "Tarjetas.findById", query = "SELECT t FROM Tarjetas t WHERE t.id = :id")
    , @NamedQuery(name = "Tarjetas.findByTipoTarjeta", query = "SELECT t FROM Tarjetas t WHERE t.tipoTarjeta = :tipoTarjeta")
    , @NamedQuery(name = "Tarjetas.findByNumeroTarjeta", query = "SELECT t FROM Tarjetas t WHERE t.numeroTarjeta = :numeroTarjeta")
    , @NamedQuery(name = "Tarjetas.findByMesExpiracion", query = "SELECT t FROM Tarjetas t WHERE t.mesExpiracion = :mesExpiracion")
    , @NamedQuery(name = "Tarjetas.findByAnioExpiracion", query = "SELECT t FROM Tarjetas t WHERE t.anioExpiracion = :anioExpiracion")
    , @NamedQuery(name = "Tarjetas.findByNumeroCVV", query = "SELECT t FROM Tarjetas t WHERE t.numeroCVV = :numeroCVV")
    , @NamedQuery(name = "Tarjetas.tarjetasActivas", query = "SELECT t FROM Tarjetas t WHERE t.status = 1")
    , @NamedQuery(name = "Tarjetas.tarjetasEliminadas", query = "SELECT t FROM Tarjetas t WHERE t.status = 0")
    , @NamedQuery(name = "Tarjetas.findByStatus", query = "SELECT t FROM Tarjetas t WHERE t.status = :status")})
public class Tarjetas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "tipo_tarjeta")
    private String tipoTarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_tarjeta")
    private int numeroTarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mes_expiracion")
    private int mesExpiracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio_expiracion")
    private int anioExpiracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_CVV")
    private int numeroCVV;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users idUsuario;

    public Tarjetas() {
    }

    public Tarjetas(Integer id) {
        this.id = id;
    }

    public Tarjetas(Integer id, String tipoTarjeta, int numeroTarjeta, int mesExpiracion, int anioExpiracion, int numeroCVV, int status) {
        this.id = id;
        this.tipoTarjeta = tipoTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.mesExpiracion = mesExpiracion;
        this.anioExpiracion = anioExpiracion;
        this.numeroCVV = numeroCVV;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getMesExpiracion() {
        return mesExpiracion;
    }

    public void setMesExpiracion(int mesExpiracion) {
        this.mesExpiracion = mesExpiracion;
    }

    public int getAnioExpiracion() {
        return anioExpiracion;
    }

    public void setAnioExpiracion(int anioExpiracion) {
        this.anioExpiracion = anioExpiracion;
    }

    public int getNumeroCVV() {
        return numeroCVV;
    }

    public void setNumeroCVV(int numeroCVV) {
        this.numeroCVV = numeroCVV;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Users getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Users idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Tarjetas)) {
            return false;
        }
        Tarjetas other = (Tarjetas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tarjetas[ id=" + id + " ]";
    }
    
}
