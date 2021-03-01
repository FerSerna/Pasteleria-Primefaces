/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
@Table(name = "Estados_de_envio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadosdeenvio.findAll", query = "SELECT e FROM Estadosdeenvio e")
    , @NamedQuery(name = "Estadosdeenvio.findById", query = "SELECT e FROM Estadosdeenvio e WHERE e.id = :id")
    , @NamedQuery(name = "Estadosdeenvio.findByEstadoEnvio", query = "SELECT e FROM Estadosdeenvio e WHERE e.estadoEnvio = :estadoEnvio")
    , @NamedQuery(name = "Estadosdeenvio.estadosDeEnvioActivos", query = "SELECT e FROM Estadosdeenvio e WHERE e.status = 1")
    , @NamedQuery(name = "Estadosdeenvio.estadosDeEnvioEliminados", query = "SELECT e FROM Estadosdeenvio e WHERE e.status = 0")
    , @NamedQuery(name = "Estadosdeenvio.findByStatus", query = "SELECT e FROM Estadosdeenvio e WHERE e.status = :status")})
public class Estadosdeenvio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "estado_envio")
    private String estadoEnvio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadosEnvio")
    private Collection<Envios> enviosCollection;

    public Estadosdeenvio() {
    }

    public Estadosdeenvio(Integer id) {
        this.id = id;
    }

    public Estadosdeenvio(Integer id, String estadoEnvio, int status) {
        this.id = id;
        this.estadoEnvio = estadoEnvio;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
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
        if (!(object instanceof Estadosdeenvio)) {
            return false;
        }
        Estadosdeenvio other = (Estadosdeenvio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //Para obtener los valores de nuestra FK sustituimos
        //return "modelo.Estadosdeenvio[ id=" + id + " ]";
        return estadoEnvio;
    }
    
}
