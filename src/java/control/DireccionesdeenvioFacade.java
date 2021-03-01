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
import modelo.Direccionesdeenvio;

/**
 *
 * @author fers15
 */
@Stateless
public class DireccionesdeenvioFacade extends AbstractFacade<Direccionesdeenvio> {

    @PersistenceContext(unitName = "pasteleriaPrimeFacesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DireccionesdeenvioFacade() {
        super(Direccionesdeenvio.class);
    }
    
    public List<Direccionesdeenvio> consultarActivos(){
     
        Query consulta = em.createNamedQuery("Direccionesdeenvio.direccionesDeEnvioActivas",Direccionesdeenvio.class);
        List<Direccionesdeenvio> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
    }
    
    public List<Direccionesdeenvio> consultarEliminados(){
     
        Query consulta = em.createNamedQuery("Direccionesdeenvio.direccionesDeEnvioEliminadas",Direccionesdeenvio.class);
        List<Direccionesdeenvio> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
        
    }
    
}

