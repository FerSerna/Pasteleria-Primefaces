/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import modelo.Entidades;
import modelo.Municipios;
import modelo.Paises;

/**
 *
 * @author fers15
 */
@Named(value = "ajax")
@RequestScoped
public class Ajax {
    
    @EJB
    private PaisesFacade paisesFacade;
    
    @EJB
    private EntidadesFacade entidadesFacade;
    
    @EJB
    private MunicipiosFacade municipiosFacade;
    
    private int id_pais;
    private int id_entidad;
    private int id_municipio;
    private List<SelectItem> listPaises;
    private List<SelectItem> listEntidades;
    private List<SelectItem> listMunicipios;

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public int getId_entidad() {
        return id_entidad;
    }

    public void setId_entidad(int id_entidad) {
        this.id_entidad = id_entidad;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public List<SelectItem> getListPaises() {
        return listPaises;
    }

    public void setListPaises(List<SelectItem> listPaises) {
        this.listPaises = listPaises;
    }

    public List<SelectItem> getListEntidades() {
        return listEntidades;
    }

    public void setListEntidades(List<SelectItem> listEntidades) {
        this.listEntidades = listEntidades;
    }

    public List<SelectItem> getListMunicipios() {
        return listMunicipios;
    }

    public void setListMunicipios(List<SelectItem> listMunicipios) {
        this.listMunicipios = listMunicipios;
    }
        
    /**
     * Creates a new instance of Ajax
     */
    public Ajax() {
    }
    @PostConstruct
    private void initialize(){
        listPaises = new ArrayList<SelectItem>();
        List<Paises> listPai = paisesFacade.findAll();
        listPaises.clear();
        for(Paises p : listPai){
            SelectItem pais_item = new SelectItem(p.getId(),p.getNombre());
            listPaises.add(pais_item);
        }
        
        listEntidades = new ArrayList<SelectItem>();
        List<Entidades> listEnt = entidadesFacade.findAll();
        listEntidades.clear();
        for(Entidades e : listEnt){
            SelectItem entidad_item = new SelectItem(e.getId(),e.getNombre());
            listEntidades.add(entidad_item);
        }
    }
    
    public List<SelectItem> buscarEntidades(final  AjaxBehaviorEvent event){
        listEntidades = new ArrayList<SelectItem>();
        List<Entidades> listEnt = entidadesFacade.Buscar(id_pais);
        listEntidades.clear();
        for(Entidades e: listEnt){
            SelectItem entidad_item = new SelectItem(e.getId(),e.getNombre());
            listEntidades.add(entidad_item);
        }
        FacesContext.getCurrentInstance().renderResponse();
        return listEntidades;
    }
    
    public List<SelectItem> buscarMunicipios(final  AjaxBehaviorEvent event){
        listMunicipios = new ArrayList<SelectItem>();
        List<Municipios> listMun = municipiosFacade.Buscar(id_entidad);
        listMunicipios.clear();
        for(Municipios m: listMun){
            SelectItem municipio_item = new SelectItem(m.getId(),m.getNombre());
            listMunicipios.add(municipio_item);
        }
        FacesContext.getCurrentInstance().renderResponse();
        return listMunicipios;
    }
    
}
