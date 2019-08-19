package com.atrium.hibernate.modelo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.ArticulosSmp;
import com.atrium.hibernate.PedidosSmp;
import com.atrium.hibernate.dao.ext.PedidosSmpDAOEXT;

/**
 * 
 * Ejemplo de fachada para el uso de transacciones con spring. La definicion de
 * las transacciones con anotaciones en la clase.
 * 
 */

@Repository("gestionPedidosSmp")
@Scope("prototype")
public class GestionPedidosSmp implements IGestionPedidosSmp {

	private PedidosSmpDAOEXT pedidoSmpDAOEXT;

	// ***************** CONSULTAS DE PEDIDOS
	@Override
	@Transactional(readOnly = true)
	public PedidosSmp consultarPorNumeroPedido(Integer numeroPedido) {
		return pedidoSmpDAOEXT.findById(numeroPedido);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PedidosSmp> consultarPedidosSmpTodos() {
		List<PedidosSmp> lista = pedidoSmpDAOEXT.findAll();
		return lista;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<PedidosSmp> consultarPedidosSmpTodosOrdenados() {
		return pedidoSmpDAOEXT.consultarTodosPedidosOrdenados();
	}
	
	@Override
	@Transactional(readOnly = true)
	public PedidosSmp consultarPedidoConLineaPedidoSmp(Integer numeroPedido) {
		return pedidoSmpDAOEXT.consultarConLineaPedidoSmp(numeroPedido);
	}
	
	@Override
	@Transactional(readOnly = true)
	public PedidosSmp consultarPedidoConTodo(Integer numeroPedido) {
		return pedidoSmpDAOEXT.consultarConTodo(numeroPedido);
	}

	// *************** OPERACIONES CRUD PEDIDOS

	@Override
	@Transactional
	public void altaPedidosSmp(PedidosSmp pedidoSmp) {
		pedidoSmpDAOEXT.save(pedidoSmp);
	}

	@Override
	@Transactional
	public void bajaPedidosSmp(PedidosSmp pedidoSmp) {
		pedidoSmpDAOEXT.delete(pedidoSmp);
	}

	@Override
	@Transactional
	public void modificionPedidosSmp(PedidosSmp pedidoSmp) {
		pedidoSmpDAOEXT.attachDirty(pedidoSmp);
	}

	// ACCESORES PARA SPRING

	public void setPedidoSmpDAOEXT(PedidosSmpDAOEXT pedidoSmpDAOEXT) {
		this.pedidoSmpDAOEXT = pedidoSmpDAOEXT;
	}
}
