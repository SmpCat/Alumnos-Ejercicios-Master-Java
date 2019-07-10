package com.atrium.hibernate.modelo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Pedidos;
import com.atrium.hibernate.dao.PedidosDAO;
import com.atrium.hibernate.dao.ext.Pedidos_DAOEXT;

@Repository("gestion_pedidos")
@Scope("prototype")
public class Gestion_Pedidos implements IGestion_Pedidos {

	private Pedidos_DAOEXT pedido_dao;

	@Override
	@Transactional(readOnly = true)
	public List<Pedidos> consultar_Pedidos() {
		return pedido_dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pedidos> consultar_ConClientes() {
		return pedido_dao.consultar_ConClientes();
	}

	// ACCESORES PARA SPRING
	public void setPedido_dao(Pedidos_DAOEXT pedido_dao) {
		this.pedido_dao = pedido_dao;
	}

}
