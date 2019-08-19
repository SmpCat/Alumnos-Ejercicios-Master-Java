package com.atrium.hibernate.dao.ext;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.atrium.hibernate.Articulos;
import com.atrium.hibernate.dao.ArticulosDAO;

/**
 * Clase para añadir consultas propias y consultas con resolución de "Carga Vaga" de Articulos
 * 
 * @author Sergio Sánchez García 
 * @version 1.0
 * @since 10/05/2019
 *
 */

@Repository("articulos_dao")
@Scope("prototype")
public class Articulos_DAOExt extends ArticulosDAO implements Serializable {

	/**
	 * Serial Version 
	 */
	private static final long serialVersionUID = 1L;

	public Articulos consultar_ConLinea(Integer codigoArticulo) {
		// 1. Apertura de la consulta
		Criteria criteria = getCurrentSession().createCriteria(Articulos.class);
		// 2. JOIN entre las tablas para resolver la relación
		criteria.setFetchMode("lineaPedido", FetchMode.JOIN);
		// 3. Clave primaria
		criteria.add(Restrictions.idEq(codigoArticulo));
		// 4. Realizamos la consulta
		List<Articulos> lista =  criteria.list();
		Articulos articulo = null;
		if (!lista.isEmpty()) {
			articulo = lista.get(0);
		}
		
		return articulo;
	}

	public List<Articulos> consultar_Todo() {
		// 1. Apertura de la consulta
		Criteria criteria = getCurrentSession().createCriteria(Articulos.class);
		// 2. JOIN entre las tablas para resolver la relación
		criteria.setFetchMode("lineaPedido", FetchMode.JOIN);
		// 4. Resolvemos producto cartesiano
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		// 5. Realizamos la consulta
		List<Articulos> lista =  criteria.list();
		return lista;
	}
}
