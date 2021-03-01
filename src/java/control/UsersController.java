package control;

import modelo.Users;
import control.util.JsfUtil;
import control.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.ArrayList;
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
import org.apache.commons.codec.digest.DigestUtils;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import modelo.Paises;
import modelo.Entidades;
import modelo.Municipios;


@Named("usersController")
@SessionScoped
public class UsersController implements Serializable {

    @EJB
    private control.UsersFacade ejbFacade;
    private List<Users> items = null;
    private List<Users> itemsEliminados = null;
    private Users selected;
    private String mensaje;
    String nuevo;
    //MECANISMO AJAX
    @EJB
    private control.PaisesFacade paisesFacade;
    
    @EJB
    private control.EntidadesFacade entidadesFacade;
    
    @EJB
    private control.MunicipiosFacade municipiosFacade;
    
    @EJB
    private UsersFacade usersFacade;
    
    private List<Paises> listPaises1;
    private List<Entidades> listEntidades1;
    private List<Municipios> listMunicipios1;

    public List<Paises> getListPaises1() {
        return listPaises1;
    }

    public void setListPaises1(List<Paises> listPaises1) {
        this.listPaises1 = listPaises1;
    }

    public List<Entidades> getListEntidades1() {
        return listEntidades1;
    }

    public void setListEntidades1(List<Entidades> listEntidades1) {
        this.listEntidades1 = listEntidades1;
    }

    public List<Municipios> getListMunicipios1() {
        return listMunicipios1;
    }

    public void setListMunicipios1(List<Municipios> listMunicipios1) {
        this.listMunicipios1 = listMunicipios1;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNuevo() {
        return nuevo;
    }

    public void setNuevo(String nuevo) {
        this.nuevo = nuevo;
    }
    
    
    public UsersController() {
    }
    
    @PostConstruct
    private void initialize(){
       listPaises1 = paisesFacade.consultarActivos();
    }
    
    //METODOS MECANISMOS AJAX
    public void buscarEntidades(final AjaxBehaviorEvent event){
        listEntidades1 = entidadesFacade.Buscar(selected.getIdPais().getId());
        listMunicipios1 = municipiosFacade.Buscar(0);
    }
    
    public void buscarMunicipios(final AjaxBehaviorEvent event){
        listMunicipios1 = municipiosFacade.Buscar(selected.getIdEntidad().getId());
        
    }
    
    public void verificarUsername(AjaxBehaviorEvent event){
        if(usersFacade.consultarUsername(selected.getUsername()).equals("OK")){
            mensaje= "Username existente,intente uno nuevo";
        }else{
            mensaje= "Username disponible";
        }
    }

    // consultarEliminados() -> sustituye a findAll() que venia por defecto
    //Y se crea en el Facade
    public List<Users> getItemsEliminados() {
        if (itemsEliminados == null) {
            //items = getFacade().findAll();
            itemsEliminados = getFacade().consultarEliminados();
        }
        return itemsEliminados;
    }

    public void setItemsEliminados(List<Users> itemsEliminados) {
        this.itemsEliminados = itemsEliminados;
    }

    
    
    public Users getSelected() {
        return selected;
    }

    public void setSelected(Users selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private UsersFacade getFacade() {
        return ejbFacade;
    }

    public Users prepareCreate() {
        selected = new Users();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        //Hacer el valor por defecto del status
        selected.setStatus(1);
        
        String password = selected.getPassword();
        String password_encrip = DigestUtils.sha1Hex(password);
        selected.setPassword(password_encrip);
        
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UsersCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        
        String password = selected.getPassword();
        String password_encrip = DigestUtils.sha1Hex(password);
        selected.setPassword(password_encrip);
        
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UsersUpdated"));
    }

    public void destroy() {
        //BORRADO LOGICO: cambio para que en lugar de eliminar solo actualice el status a baja (0)
        selected.setStatus(0);
        //persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("UsersDeleted"));
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UsersDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
            //Llamamos a estos itemsEliminados para que los vuelva a referescar
            itemsEliminados = null;
        }
    }
    
    public void restaurar() {
        selected.setStatus(1);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PaisesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            itemsEliminados = null;
            //Llamamos a estos items para que los vuelva a referescar
            items = null;// Invalidate list of items to trigger re-query.
        }
    }

    // consultarActivos() -> sustituye a findAll() que venia por defecto
    //Y se crea en Facade
    public List<Users> getItems() {
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

    public Users getUsers(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Users> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Users> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Users.class)
    public static class UsersControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsersController controller = (UsersController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usersController");
            return controller.getUsers(getKey(value));
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
            if (object instanceof Users) {
                Users o = (Users) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Users.class.getName()});
                return null;
            }
        }

    }

}
