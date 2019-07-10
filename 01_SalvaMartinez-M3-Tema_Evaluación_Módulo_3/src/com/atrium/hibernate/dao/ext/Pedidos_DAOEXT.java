package com.atrium.hibernate.dao.ext;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.atrium.hibernate.Pedidos;
import com.atrium.hibernate.dao.PedidosDAO;

@Component("pedido_dao")
@Scope("prototype")
public class Pedidos_DAOEXT extends PedidosDAO {

	
	public List<Pedidos> consultar_ConClientes() {
		Criteria consulta = getCurrentSession().createCriteria(Pedidos.class);
		consulta.setFetchMode("clientes", FetchMode.JOIN);
		return consulta.list();
	}

}
