package com.atrium.hibernate.modelo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.ArticulosSmp;
import com.atrium.hibernate.dao.ext.ArticulosSmpDAOEXT;

/**
 * 
 * Ejemplo de fachada para el uso de transacciones con spring. La definicion de
 * las transacciones con anotaciones en la clase.
 * 
 */

@Repository("gestionArticulosSmp")
@Scope("prototype")
public class GestionArticulosSmp implements IGestionArticulosSmp {

	private ArticulosSmpDAOEXT articuloSmpDAOEXT;
	
	// ***************** CONSULTAS DE ARTÍCULOS
	@Override
	@Transactional(readOnly = true)
	public ArticulosSmp consultarPorCodigoArticulo(Integer codigoArticulo) {
		return articuloSmpDAOEXT.findById(codigoArticulo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ArticulosSmp> consultarArticulosSmpTodos() {
		List<ArticulosSmp> lista = articuloSmpDAOEXT.findAll();
		return lista;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ArticulosSmp> consultarArticulosSmpTodosOrdenados() {
		return articuloSmpDAOEXT.consultarTodosArticulosOrdenados();
	}
	
	// *************** OPERACIONES CRUD ARTÍCULOS

	@Override
	@Transactional
	public void altaArticulosSmp(ArticulosSmp articulosSmp) {
		articuloSmpDAOEXT.save(articulosSmp);
	}

	@Override
	@Transactional
	public void bajaArticulosSmp(ArticulosSmp articulosSmp) {
		articuloSmpDAOEXT.delete(articulosSmp);
	}

	@Override
	@Transactional
	public void modificionArticulosSmp(ArticulosSmp articulosSmp) {
		articuloSmpDAOEXT.attachDirty(articulosSmp);
	}

	//ACCESORES PARA SPRING
	
	public void setArticuloSmpDAOEXT(ArticulosSmpDAOEXT articuloSmpDAOEXT) {
		this.articuloSmpDAOEXT = articuloSmpDAOEXT;
	}
}
