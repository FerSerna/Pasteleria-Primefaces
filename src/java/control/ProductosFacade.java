/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import static jdk.nashorn.internal.runtime.Debug.id;
import modelo.Productos;

/**
 *
 * @author fers15
 */
@Stateless
public class ProductosFacade extends AbstractFacade<Productos> {

    @PersistenceContext(unitName = "pasteleriaPrimeFacesPU")
    private EntityManager em;
    int idp;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFacade() {
        super(Productos.class);
    }
    
    public List<Productos> consultarActivos(){
     
        Query consulta = em.createNamedQuery("Productos.productosActivos",Productos.class);
        List<Productos> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
    }
    
    public List<Productos> consultarEliminados(){
     
        Query consulta = em.createNamedQuery("Productos.productosEliminados",Productos.class);
        List<Productos> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
        
    }
    
    
    
    public List<Productos> consultarId(int id){
        Query consulta = em.createNamedQuery("Productos.findById",Productos.class)
                .setParameter("id_producto", id);
        List<Productos> lista = consulta.getResultList();
        return lista;
    }
    
}
