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
import modelo.Fotosproductos;

/**
 *
 * @author fers15
 */
@Stateless
public class FotosproductosFacade extends AbstractFacade<Fotosproductos> {

    @PersistenceContext(unitName = "pasteleriaPrimeFacesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FotosproductosFacade() {
        super(Fotosproductos.class);
    }
    
    public List<Fotosproductos> consultarActivos(){
     
        Query consulta = em.createNamedQuery("Fotosproductos.fotosProductosActivas",Fotosproductos.class);
        List<Fotosproductos> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
    }
    
    public List<Fotosproductos> consultarEliminados(){
     
        Query consulta = em.createNamedQuery("Fotosproductos.fotosProductosEliminadas",Fotosproductos.class);
        List<Fotosproductos> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
        
    }
    
}
