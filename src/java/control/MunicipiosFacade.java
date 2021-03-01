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
import modelo.Municipios;

/**
 *
 * @author fers15
 */
@Stateless
public class MunicipiosFacade extends AbstractFacade<Municipios> {

    @PersistenceContext(unitName = "pasteleriaPrimeFacesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MunicipiosFacade() {
        super(Municipios.class);
    }
    
    public List<Municipios> consultarActivos(){
     
        Query consulta = em.createNamedQuery("Municipios.municipiosActivos",Municipios.class);
        List<Municipios> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
    }
    
    public List<Municipios> consultarEliminados(){
     
        Query consulta = em.createNamedQuery("Municipios.municipiosEliminados",Municipios.class);
        List<Municipios> lista = consulta.getResultList();
        if (!lista.isEmpty()){
            return lista;
        }else
            return null;
        
    }
    
    public List<Municipios> Buscar(int idEntidad){
        Query consulta = em.createNamedQuery("Municipios.buscar",Municipios.class)
                .setParameter("id_entidad", idEntidad);
        List<Municipios> lista = consulta.getResultList();
        return lista;
    }
    
}
