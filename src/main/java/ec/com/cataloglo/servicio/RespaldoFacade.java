/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.Respaldo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author carlosballadares
 */
@Stateless
public class RespaldoFacade extends AbstractFacade<Respaldo> implements RespaldoFacadeLocal {

    @PersistenceContext(unitName = "catalogoSoftwarePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RespaldoFacade() {
        super(Respaldo.class);
    }
    
}
