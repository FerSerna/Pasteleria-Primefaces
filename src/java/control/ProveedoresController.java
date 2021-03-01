package control;

import modelo.Proveedores;
import control.util.JsfUtil;
import control.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.AjaxBehaviorEvent;
import modelo.Entidades;
import modelo.Municipios;
import modelo.Paises;

@Named("proveedoresController")
@SessionScoped
public class ProveedoresController implements Serializable {

    @EJB
    private control.ProveedoresFacade ejbFacade;
    private List<Proveedores> items = null;
    private List<Proveedores> itemsEliminados = null;
    private Proveedores selected;
    
    //MECANISMO AJAX
    @EJB
    private control.PaisesFacade paisesFacade;
    
    @EJB
    private control.EntidadesFacade entidadesFacade;
    
    @EJB
    private control.MunicipiosFacade municipiosFacade;
    
    private List<Paises> listPaises;
    private List<Entidades> listEntidades;
    private List<Municipios> listMunicipios;

    public List<Paises> getListPaises() {
        return listPaises;
    }

    public void setListPaises(List<Paises> listPaises) {
        this.listPaises = listPaises;
    }

    public List<Entidades> getListEntidades() {
        return listEntidades;
    }

    public void setListEntidades(List<Entidades> listEntidades) {
        this.listEntidades = listEntidades;
    }

    public List<Municipios> getListMunicipios() {
        return listMunicipios;
    }

    public void setListMunicipios(List<Municipios> listMunicipios) {
        this.listMunicipios = listMunicipios;
    }

    
    
    public ProveedoresController() {
    }
    
    @PostConstruct
    private void initialize(){
       listPaises = paisesFacade.consultarActivos();
    }
    
    //METODOS MECANISMOS AJAX
    public void buscarEntidades(final AjaxBehaviorEvent event){
        listEntidades = entidadesFacade.Buscar(selected.getIdPais().getId());
        listMunicipios = municipiosFacade.Buscar(0);
    }
    
    public void buscarMunicipios(final AjaxBehaviorEvent event){
        listMunicipios = municipiosFacade.Buscar(selected.getIdEntidad().getId());
        
    }
    
   

    // consultarEliminados() -> sustituye a findAll() que venia por defecto
    //Y se crea en el Facade
    public List<Proveedores> getItemsEliminados() {
        if (itemsEliminados == null) {
            //items = getFacade().findAll();
            itemsEliminados = getFacade().consultarEliminados();
        }
        return itemsEliminados;
    }

    public void setItemsEliminados(List<Proveedores> itemsEliminados) {
        this.itemsEliminados = itemsEliminados;
    }

    
    
    public Proveedores getSelected() {
        return selected;
    }

    public void setSelected(Proveedores selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProveedoresFacade getFacade() {
        return ejbFacade;
    }

    public Proveedores prepareCreate() {
        selected = new Proveedores();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        //Hacer el valor por defecto del status
        selected.setStatus(1);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProveedoresCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProveedoresUpdated"));
    }

    public void destroy() {
        //BORRADO LOGICO: cambio para que en lugar de eliminar solo actualice el status a baja (0)
        selected.setStatus(0);
        //persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProveedoresDeleted"));
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProveedoresDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
            //Llamamos a estos itemsEliminados para que los vuelva a referescar
            itemsEliminados = null;
        }
    }
    
    public void restaurar() {
        selected.setStatus(1);
        //persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProveedoresDeleted"));
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProveedoresDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            itemsEliminados = null;
            //Llamamos a estos items para que los vuelva a referescar
            items = null;// Invalidate list of items to trigger re-query.
        }
    }

    // consultarActivos() -> sustituye a findAll() que venia por defecto
    //Y se crea en Facade
    public List<Proveedores> getItems() {
        if (items == null) {
            //items = getFacade().findAll();
            items = getFacade().consultarActivos();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Proveedores getProveedores(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Proveedores> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Proveedores> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Proveedores.class)
    public static class ProveedoresControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProveedoresController controller = (ProveedoresController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "proveedoresController");
            return controller.getProveedores(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Proveedores) {
                Proveedores o = (Proveedores) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Proveedores.class.getName()});
                return null;
            }
        }

    }

}
