package com.ipartek.formacion.modelo;

import java.util.ArrayList;

public interface RolDAO extends CrudAble<Rol>{
	
	ArrayList<Rol> getAllByNombre( String palabraBuscada);
	

}
