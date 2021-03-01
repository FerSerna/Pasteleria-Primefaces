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
import modelo.Paqueterias;

/**
 *
 * @author fers15
 */
@Stateless
public class PaqueteriasFacade extends AbstractFacade<Paqueterias> {

    @PersistenceContext(unitName = "pasteleriaPrimeFacesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaqueteriasFacade() {
        super(Paqueterias.class);
    }
    
    public List<Paqueterias> consultarActivos(){
     
        Query consulta = em.createNamedQuery("Paqueterias.paqueteriasActivas",Paqueterias.class);
        List<Paqueterias> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
    }
    
    public List<Paqueterias> consultarEliminados(){
     
        Query consulta = em.createNamedQuery("Paqueterias.paqueteriasEliminadas",Paqueterias.class);
        List<Paqueterias> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
        
    }
    
}

