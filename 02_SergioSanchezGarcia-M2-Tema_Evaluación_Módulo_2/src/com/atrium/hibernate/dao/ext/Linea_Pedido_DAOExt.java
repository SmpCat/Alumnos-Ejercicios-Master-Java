package com.atrium.hibernate.dao.ext;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.atrium.hibernate.Linea_Pedido;
import com.atrium.hibernate.dao.LineaPedidoDAO;

/**
 * Clase para añadir consultas propias y consultas con resolución de "Carga Vaga" de Linea de Pedidos
 * 
 * @author Sergio Sánchez García 
 * @version 1.0
 * @since 10/05/2019
 *
 */

@Component("lineaPedido_dao")
@Scope("prototype")
public class Linea_Pedido_DAOExt extends LineaPedidoDAO {

	public Linea_Pedido consultar_porCodigoConArticulos(Integer codigoLineaPedido) {
		// 1. Apertura de la consulta
		Criteria criteria = getCurrentSession().createCriteria(Linea_Pedido.class);
		// 2. JOIN entre las tablas para resolver la relación
		criteria.setFetchMode("articulos", FetchMode.JOIN);
		// 3. Clave primaria
		criteria.add(Restrictions.idEq(codigoLineaPedido));
		// 4. Realizamos la consulta
		List<Linea_Pedido> lista =  criteria.list();
		Linea_Pedido lineaPedido = null;
		if (!lista.isEmpty()) {
			lineaPedido = lista.get(0);
		}
		
		return lineaPedido;
	}

	public List<Linea_Pedido> consultar_TodoConArticulos() {
		// 1. Apertura de la consulta
		Criteria criteria = getCurrentSession().createCriteria(Linea_Pedido.class);
		// 2. JOIN entre las tablas para resolver la relación
		criteria.setFetchMode("articulos", FetchMode.JOIN);
		// 4. Resolvemos producto cartesiano
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		// 5. Realizamos la consulta
		List<Linea_Pedido> lista =  criteria.list();
		return lista;
	}

}
