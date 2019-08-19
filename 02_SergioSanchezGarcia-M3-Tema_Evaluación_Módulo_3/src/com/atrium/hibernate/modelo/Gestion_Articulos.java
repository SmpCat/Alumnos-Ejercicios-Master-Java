package com.atrium.hibernate.modelo;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Articulos;
import com.atrium.hibernate.dao.ext.Articulos_DAOExt;

/**
 * Clase para la Gestion de Articulos
 * 
 * @author Sergio Sánchez García 
 * @version 1.0
 * @since 10/05/2019
 *
 */
@Repository("gestion_articulos")
@Scope("prototype") 
public class Gestion_Articulos implements IGestion_Articulos, Serializable  {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;
	private Articulos_DAOExt articulos_dao;

	// **** CONSULTAS DE PEDIDOS ****
	@Override
	@Transactional(readOnly = true)
	public Articulos consultar_PorCodigoConLineas(Integer codigoArticulo) {
		return articulos_dao.consultar_ConLinea(codigoArticulo);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Articulos consultar_PorCodigo(Integer codigoArticulo) {
		return articulos_dao.findById(codigoArticulo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Articulos> consultar_Todos() {
		List<Articulos> lista = articulos_dao.findAll();
		return lista;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Articulos> consultar_TodosConLineas() {
		List<Articulos> lista = articulos_dao.consultar_Todo();
		return lista;
	}

	// ***** OPERACIONES CRUD ******

	@Override
	@Transactional
	public void alta_Articulos(Articulos articulo) {
		articulos_dao.save(articulo);
	}

	@Override
	@Transactional
	public void baja_Articulos(Articulos articulo) {
		articulos_dao.delete(articulo);
	}

	@Override
	@Transactional
	public void modificacion_Articulos(Articulos articulo) {
		articulos_dao.attachDirty(articulo);
	}
	
	
	// Accesor Spring
	public void setArticulos_dao(Articulos_DAOExt articulos_dao) {
		this.articulos_dao = articulos_dao;
	}

}
