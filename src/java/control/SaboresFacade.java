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
import modelo.Sabores;

/**
 *
 * @author fers15
 */
@Stateless
public class SaboresFacade extends AbstractFacade<Sabores> {

    @PersistenceContext(unitName = "pasteleriaPrimeFacesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SaboresFacade() {
        super(Sabores.class);
    }
    
    public List<Sabores> consultarActivos(){
     
        Query consulta = em.createNamedQuery("Sabores.saboresActivos",Sabores.class);
        List<Sabores> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
    }
    
    public List<Sabores> consultarEliminados(){
     
        Query consulta = em.createNamedQuery("Sabores.saboresEliminados",Sabores.class);
        List<Sabores> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
        
    }
}
