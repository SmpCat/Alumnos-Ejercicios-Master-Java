package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Articulos;

public interface IGestion_Articulos {
	
	public abstract Articulos consultar_PorCodigoConLineas(Integer codigoArticulo);

	public abstract Articulos consultar_PorCodigo(Integer codigoArticulo);

	public abstract List<Articulos> consultar_Todos();
	
	public abstract List<Articulos> consultar_TodosConLineas();

	public abstract void modificacion_Articulos(Articulos articulo);

	public abstract void baja_Articulos(Articulos articulo);

	public abstract void alta_Articulos(Articulos articulo);

}