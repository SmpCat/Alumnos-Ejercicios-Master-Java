package com.atrium.hibernate.dao.ext;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.atrium.hibernate.PedidosSmp;
import com.atrium.hibernate.dao.PedidosSmpDAO;

@Repository("pedidoSmpDAOEXT")
@Scope("prototype")
public class PedidosSmpDAOEXT extends PedidosSmpDAO {

	public List<PedidosSmp> consultarTodosPedidosOrdenados() {
		// ABRIMOS LA CONSULTA
		Criteria criteria = getCurrentSession().createCriteria(PedidosSmp.class);
		// ORDENACIÓN POR NÚMERO DE PEDIDO
		criteria.addOrder(Order.asc("numeroPedido"));
		// RETORNAMOS EL VALOR DE LA CONSULTA
		return criteria.list();
	}
	
	public PedidosSmp consultarConLineaPedidoSmp(Integer numeroPedido) {
		// ABRIMOS LA CONSULTA
		Criteria criteria = getCurrentSession().createCriteria(PedidosSmp.class);
		// RESOLUCION DE LA RELACION ENTRE pedidosSmp y lineaPedidoSmp
		criteria.setFetchMode("lineaPedidoSmps", FetchMode.JOIN);
		// CONDICION DE IGUALDAD EN CLAVE PRIMARIA
		criteria.add(Restrictions.idEq(numeroPedido));
		// HACEMOS LA CONSULTA
		List<PedidosSmp> lista = criteria.list();
		PedidosSmp pedidosSmp = null;
		if (!lista.isEmpty()) {
			pedidosSmp = lista.get(0);
		}
		// RETORNAMOS EL VALOR DE LA CONSULTA
		return pedidosSmp;
	}

	public PedidosSmp consultarConTodo(Integer numeroPedido) {
		// ABRIMOS LA CONSULTA
		Criteria criteria = getCurrentSession().createCriteria(PedidosSmp.class);
		// RESOLUCION DE LA RELACION ENTRE pedidosSmp y lineaPedidoSmp
		criteria.setFetchMode("lineaPedidoSmps", FetchMode.JOIN);
		// RESOLUCION DE LA RELACION ENTRE lineaPedidoSmp y articulosSmp
		criteria.setFetchMode("lineaPedidoSmps.articulosSmp", FetchMode.JOIN);
		// CONDICION DE IGUALDAD EN CLAVE PRIMARIA
		criteria.add(Restrictions.idEq(numeroPedido));
		// RESOLUCION DE PRODUCTO CARTESIANO
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		// HACEMOS LA CONSULTA
		List<PedidosSmp> lista = criteria.list();
		PedidosSmp pedidosSmp = null;
		if (!lista.isEmpty()) {
			pedidosSmp = lista.get(0);
		}
		// RETORNAMOS EL VALOR DE LA CONSULTA
		return pedidosSmp;
	}
}
