package ec.com.catalogo.modelo;

import ec.com.catalogo.modelo.Menu;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2020-01-28T16:42:13")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, Menu> codigoSubmenu;
    public static volatile SingularAttribute<Menu, Integer> codigo;
    public static volatile SingularAttribute<Menu, String> tipo;
    public static volatile SingularAttribute<Menu, Integer> estado;
    public static volatile ListAttribute<Menu, Menu> menuList;
    public static volatile SingularAttribute<Menu, String> tipoUsuario;
    public static volatile SingularAttribute<Menu, String> nombre;
    public static volatile SingularAttribute<Menu, String> url;

}