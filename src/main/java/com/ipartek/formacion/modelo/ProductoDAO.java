package com.ipartek.formacion.modelo;

import java.util.ArrayList;

public interface ProductoDAO extends CrudAble<Producto> {
	
	ArrayList<Producto> getAllByNombre( String palabraBuscada);

}
