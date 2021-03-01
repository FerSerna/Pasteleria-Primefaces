/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fers15
 */
@Entity
@Table(name = "Paqueterias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paqueterias.findAll", query = "SELECT p FROM Paqueterias p")
    , @NamedQuery(name = "Paqueterias.findById", query = "SELECT p FROM Paqueterias p WHERE p.id = :id")
    , @NamedQuery(name = "Paqueterias.findByNombreEmpresa", query = "SELECT p FROM Paqueterias p WHERE p.nombreEmpresa = :nombreEmpresa")
    , @NamedQuery(name = "Paqueterias.findByRutaImagenLogo", query = "SELECT p FROM Paqueterias p WHERE p.rutaImagenLogo = :rutaImagenLogo")
    , @NamedQuery(name = "Paqueterias.findByLatitud", query = "SELECT p FROM Paqueterias p WHERE p.latitud = :latitud")
    , @NamedQuery(name = "Paqueterias.findByLongitud", query = "SELECT p FROM Paqueterias p WHERE p.longitud = :longitud")
    , @NamedQuery(name = "Paqueterias.paqueteriasActivas", query = "SELECT p FROM Paqueterias p WHERE p.status = 1")
    , @NamedQuery(name = "Paqueterias.paqueteriasEliminadas", query = "SELECT p FROM Paqueterias p WHERE p.status = 0")
    , @NamedQuery(name = "Paqueterias.findByStatus", query = "SELECT p FROM Paqueterias p WHERE p.status = :status")})
public class Paqueterias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "ruta_imagen_logo")
    private String rutaImagenLogo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitud")
    private BigDecimal latitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitud")
    private BigDecimal longitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaqueteria")
    private Collection<Envios> enviosCollection;

    public Paqueterias() {
    }

    public Paqueterias(Integer id) {
        this.id = id;
    }

    public Paqueterias(Integer id, String nombreEmpresa, String rutaImagenLogo, BigDecimal latitud, BigDecimal longitud, int status) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.rutaImagenLogo = rutaImagenLogo;
        this.latitud = latitud;
        this.longitud = longitud;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRutaImagenLogo() {
        return rutaImagenLogo;
    }

    public void setRutaImagenLogo(String rutaImagenLogo) {
        this.rutaImagenLogo = rutaImagenLogo;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Envios> getEnviosCollection() {
        return enviosCollection;
    }

    public void setEnviosCollection(Collection<Envios> enviosCollection) {
        this.enviosCollection = enviosCollection;
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
        if (!(object instanceof Paqueterias)) {
            return false;
        }
        Paqueterias other = (Paqueterias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //Para obtener los valores de nuestra FK sustituimos
        //return "modelo.Paqueterias[ id=" + id + " ]";
        return nombreEmpresa;
    }
    
}
