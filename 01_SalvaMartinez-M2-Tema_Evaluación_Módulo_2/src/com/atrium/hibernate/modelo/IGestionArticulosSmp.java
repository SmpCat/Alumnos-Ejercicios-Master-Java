package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.ArticulosSmp;

public interface IGestionArticulosSmp {

	public abstract ArticulosSmp consultarPorCodigoArticulo(Integer codigoArticulo);
	
	public abstract List<ArticulosSmp> consultarArticulosSmpTodos();
	
	public abstract List<ArticulosSmp> consultarArticulosSmpTodosOrdenados();

	public abstract void altaArticulosSmp(ArticulosSmp articulosSmp);

	public abstract void bajaArticulosSmp(ArticulosSmp articulosSmp);

	public abstract void modificionArticulosSmp(ArticulosSmp articulosSmp);
	
}