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
import modelo.Tipospago;

/**
 *
 * @author fers15
 */
@Stateless
public class TipospagoFacade extends AbstractFacade<Tipospago> {

    @PersistenceContext(unitName = "pasteleriaPrimeFacesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipospagoFacade() {
        super(Tipospago.class);
    }
    
    public List<Tipospago> consultarActivos(){
     
        Query consulta = em.createNamedQuery("Tipospago.tiposPagoActivos",Tipospago.class);
        List<Tipospago> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
    }
    
    public List<Tipospago> consultarEliminados(){
     
        Query consulta = em.createNamedQuery("Tipospago.tiposPagoEliminados",Tipospago.class);
        List<Tipospago> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
        
    }
    
}
