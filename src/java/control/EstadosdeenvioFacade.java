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
import modelo.Estadosdeenvio;

/**
 *
 * @author fers15
 */
@Stateless
public class EstadosdeenvioFacade extends AbstractFacade<Estadosdeenvio> {

    @PersistenceContext(unitName = "pasteleriaPrimeFacesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadosdeenvioFacade() {
        super(Estadosdeenvio.class);
    }
    
    public List<Estadosdeenvio> consultarActivos(){
     
        Query consulta = em.createNamedQuery("Estadosdeenvio.estadosDeEnvioActivos",Estadosdeenvio.class);
        List<Estadosdeenvio> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
    }
    
    public List<Estadosdeenvio> consultarEliminados(){
     
        Query consulta = em.createNamedQuery("Estadosdeenvio.estadosDeEnvioEliminados",Estadosdeenvio.class);
        List<Estadosdeenvio> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
        
    }
    
}

