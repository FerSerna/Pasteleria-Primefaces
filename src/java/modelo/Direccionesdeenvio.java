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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Direcciones_de_envio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccionesdeenvio.findAll", query = "SELECT d FROM Direccionesdeenvio d")
    , @NamedQuery(name = "Entidades.buscar", query = "SELECT e FROM Entidades e WHERE e.idPais.id = :id_pais")
    
    , @NamedQuery(name = "Direccionesdeenvio.findById", query = "SELECT d FROM Direccionesdeenvio d WHERE d.id = :id")
    , @NamedQuery(name = "Direccionesdeenvio.findByCalle", query = "SELECT d FROM Direccionesdeenvio d WHERE d.calle = :calle")
    , @NamedQuery(name = "Direccionesdeenvio.findByColonia", query = "SELECT d FROM Direccionesdeenvio d WHERE d.colonia = :colonia")
    , @NamedQuery(name = "Direccionesdeenvio.findByCp", query = "SELECT d FROM Direccionesdeenvio d WHERE d.cp = :cp")
    , @NamedQuery(name = "Direccionesdeenvio.findByNumExterior", query = "SELECT d FROM Direccionesdeenvio d WHERE d.numExterior = :numExterior")
    , @NamedQuery(name = "Direccionesdeenvio.findByReferenciaConstruccion", query = "SELECT d FROM Direccionesdeenvio d WHERE d.referenciaConstruccion = :referenciaConstruccion")
    , @NamedQuery(name = "Direccionesdeenvio.findByReferenciaCalle1", query = "SELECT d FROM Direccionesdeenvio d WHERE d.referenciaCalle1 = :referenciaCalle1")
    , @NamedQuery(name = "Direccionesdeenvio.findByReferenciaCalle2", query = "SELECT d FROM Direccionesdeenvio d WHERE d.referenciaCalle2 = :referenciaCalle2")
    , @NamedQuery(name = "Direccionesdeenvio.direccionesDeEnvioActivas", query = "SELECT d FROM Direccionesdeenvio d WHERE d.status = 1")
    , @NamedQuery(name = "Direccionesdeenvio.direccionesDeEnvioEliminadas", query = "SELECT d FROM Direccionesdeenvio d WHERE d.status = 0")
    , @NamedQuery(name = "Direccionesdeenvio.findByStatus", query = "SELECT d FROM Direccionesdeenvio d WHERE d.status = :status")})
public class Direccionesdeenvio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "calle")
    private String calle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "colonia")
    private String colonia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cp")
    private int cp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_exterior")
    private int numExterior;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "referencia_construccion")
    private String referenciaConstruccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "referencia_calle1")
    private String referenciaCalle1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "referencia_calle2")
    private String referenciaCalle2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDireccionesDeEnvio")
    private Collection<Envios> enviosCollection;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users idUsuario;
    @JoinColumn(name = "id_pais", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Paises idPais;
    @JoinColumn(name = "id_entidad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Entidades idEntidad;
    @JoinColumn(name = "id_municipio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Municipios idMunicipio;

    public Direccionesdeenvio() {
    }

    public Direccionesdeenvio(Integer id) {
        this.id = id;
    }

    public Direccionesdeenvio(Integer id, String calle, String colonia, int cp, int numExterior, String referenciaConstruccion, String referenciaCalle1, String referenciaCalle2, int status) {
        this.id = id;
        this.calle = calle;
        this.colonia = colonia;
        this.cp = cp;
        this.numExterior = numExterior;
        this.referenciaConstruccion = referenciaConstruccion;
        this.referenciaCalle1 = referenciaCalle1;
        this.referenciaCalle2 = referenciaCalle2;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getNumExterior() {
        return numExterior;
    }

    public void setNumExterior(int numExterior) {
        this.numExterior = numExterior;
    }

    public String getReferenciaConstruccion() {
        return referenciaConstruccion;
    }

    public void setReferenciaConstruccion(String referenciaConstruccion) {
        this.referenciaConstruccion = referenciaConstruccion;
    }

    public String getReferenciaCalle1() {
        return referenciaCalle1;
    }

    public void setReferenciaCalle1(String referenciaCalle1) {
        this.referenciaCalle1 = referenciaCalle1;
    }

    public String getReferenciaCalle2() {
        return referenciaCalle2;
    }

    public void setReferenciaCalle2(String referenciaCalle2) {
        this.referenciaCalle2 = referenciaCalle2;
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

    public Users getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Users idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Paises getIdPais() {
        return idPais;
    }

    public void setIdPais(Paises idPais) {
        this.idPais = idPais;
    }

    public Entidades getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Entidades idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Municipios getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Municipios idMunicipio) {
        this.idMunicipio = idMunicipio;
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
        if (!(object instanceof Direccionesdeenvio)) {
            return false;
        }
        Direccionesdeenvio other = (Direccionesdeenvio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //Para obtener los valores de nuestra FK sustituimos
        //return "modelo.Direccionesdeenvio[ id=" + id + " ]";
        return calle;
    }
    
}
