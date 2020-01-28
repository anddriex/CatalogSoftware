/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.controlador;

import ec.com.catalogo.modelo.Funcionario;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author root
 */

@Named
@ViewScoped
public class TemplateController implements Serializable {
    public void verificarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Funcionario usr = (Funcionario) context.getExternalContext().getSessionMap().get("usuario");
            
            if (usr == null) {
                context.getExternalContext().redirect("permisos.xhtml");
            }
        } catch(Exception e) {
            // err
        }
    }
}
