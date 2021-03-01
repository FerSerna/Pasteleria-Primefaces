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
@Table(name = "Sabores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sabores.findAll", query = "SELECT s FROM Sabores s")
    , @NamedQuery(name = "Sabores.findById", query = "SELECT s FROM Sabores s WHERE s.id = :id")
    , @NamedQuery(name = "Sabores.findByNombreSabor", query = "SELECT s FROM Sabores s WHERE s.nombreSabor = :nombreSabor")
    , @NamedQuery(name = "Sabores.saboresActivos", query = "SELECT s FROM Sabores s WHERE s.status = 1")
    , @NamedQuery(name = "Sabores.saboresEliminados", query = "SELECT s FROM Sabores s WHERE s.status = 0")
    , @NamedQuery(name = "Sabores.findByStatus", query = "SELECT s FROM Sabores s WHERE s.status = :status")})
public class Sabores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre_sabor")
    private String nombreSabor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSabor")
    private Collection<Productos> productosCollection;

    public Sabores() {
    }

    public Sabores(Integer id) {
        this.id = id;
    }

    public Sabores(Integer id, String nombreSabor, int status) {
        this.id = id;
        this.nombreSabor = nombreSabor;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreSabor() {
        return nombreSabor;
    }

    public void setNombreSabor(String nombreSabor) {
        this.nombreSabor = nombreSabor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
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
        if (!(object instanceof Sabores)) {
            return false;
        }
        Sabores other = (Sabores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //Para obtener los valores de nuestra FK sustituimos
        //return "modelo.Sabores[ id=" + id + " ]";
        return nombreSabor;
    }
    
}
