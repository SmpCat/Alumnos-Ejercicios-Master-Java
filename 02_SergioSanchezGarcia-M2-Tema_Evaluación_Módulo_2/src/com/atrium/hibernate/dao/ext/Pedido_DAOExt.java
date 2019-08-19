package com.atrium.hibernate.dao.ext;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.atrium.hibernate.Pedidos;
import com.atrium.hibernate.dao.PedidosDAO;

/**
 * Clase para añadir consultas propies y consultas con resolución de "Carga Vaga" de Pedidos
 * 
 * @author Sergio Sánchez García 
 * @version 1.0
 * @since 10/05/2019
 *
 */

@Repository("pedido_dao")
@Scope("prototype")
public class Pedido_DAOExt extends PedidosDAO {

	public Pedidos consultar_ConLinea(Integer numeroPedido) {
		// 1. Apertura de la consulta
		Criteria criteria = getCurrentSession().createCriteria(Pedidos.class);
		// 2. JOIN entre las tablas para resolver la relación
		criteria.setFetchMode("lineaPedido", FetchMode.JOIN);
		// 3. Resolucion de la relacion con los Artículos 
		criteria.setFetchMode("lineaPedido.articulos", FetchMode.JOIN); 
		// 4. Clave primaria
		criteria.add(Restrictions.idEq(numeroPedido));
		// 5. Realizamos la consulta
		List<Pedidos> lista =  criteria.list();
		Pedidos pedido = null;
		if (!lista.isEmpty()) {
			pedido = lista.get(0);
		}
		
		return pedido;
	}

	public List<Pedidos> consultar_Todo() {
		// 1. Apertura de la consulta
		Criteria criteria = getCurrentSession().createCriteria(Pedidos.class);
		// 2. JOIN entre las tablas para resolver la relación
		criteria.setFetchMode("lineaPedido", FetchMode.JOIN);
		// 3. Resolucion de la relacion con los Artículos 
		criteria.setFetchMode("lineaPedido.articulos", FetchMode.JOIN);
		// 4. Resolvemos producto cartesiano
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		// 5. Realizamos la consulta
		List<Pedidos> lista =  criteria.list();
		return lista;
	}
}
