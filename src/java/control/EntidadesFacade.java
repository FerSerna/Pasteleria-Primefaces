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
import modelo.Entidades;

/**
 *
 * @author fers15
 */
@Stateless
public class EntidadesFacade extends AbstractFacade<Entidades> {

    @PersistenceContext(unitName = "pasteleriaPrimeFacesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntidadesFacade() {
        super(Entidades.class);
    }
    
    public List<Entidades> consultarActivos(){
     
        Query consulta = em.createNamedQuery("Entidades.entidadesActivas",Entidades.class);
        List<Entidades> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
    }
    
    public List<Entidades> consultarEliminados(){
     
        Query consulta = em.createNamedQuery("Entidades.entidadesEliminadas",Entidades.class);
        List<Entidades> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
        
    }
    
    public List<Entidades> Buscar(int idPais){
        Query consulta = em.createNamedQuery("Entidades.buscar",Entidades.class)
                .setParameter("id_pais", idPais);
        List<Entidades> lista = consulta.getResultList();
        return lista;
    }

    
}
