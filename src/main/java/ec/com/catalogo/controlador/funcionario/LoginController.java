/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.controlador.funcionario;

import ec.com.cataloglo.servicio.FuncionarioFacadeLocal;
import ec.com.catalogo.modelo.Funcionario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named
@ViewScoped
public class LoginController implements Serializable {
    
    @EJB
    private FuncionarioFacadeLocal usuarioEJB;
    private Funcionario usuario;
    
    @PostConstruct
    public void init() {
        usuario = new Funcionario();
    }

    public Funcionario getUsuario() {
        return usuario;
    }

    public void setUsuario(Funcionario usuario) {
        this.usuario = usuario;
    }
    
    public String iniciarSesion() {
        Funcionario usr;
        String redireccion = null;
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            usr = usuarioEJB.iniciarSesion(usuario);
            if (usr == null) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
            } else {
                context.getExternalContext().getSessionMap().put("usuario", usr);
                redireccion = "/paginas/protegido/principal";
            }
        } catch(Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
        
        return redireccion;
    }
    
}
