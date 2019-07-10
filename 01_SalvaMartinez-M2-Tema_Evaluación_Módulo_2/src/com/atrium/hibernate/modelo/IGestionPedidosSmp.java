package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.ArticulosSmp;
import com.atrium.hibernate.PedidosSmp;

public interface IGestionPedidosSmp {

	public abstract PedidosSmp consultarPorNumeroPedido(Integer numeroPedido);

	public abstract List<PedidosSmp> consultarPedidosSmpTodos();
	
	public abstract List<PedidosSmp> consultarPedidosSmpTodosOrdenados();

	public abstract void altaPedidosSmp(PedidosSmp pedidoSmp);

	public abstract void bajaPedidosSmp(PedidosSmp pedidoSmp);

	public abstract void modificionPedidosSmp(PedidosSmp pedidoSmp);
	
	public abstract PedidosSmp consultarPedidoConLineaPedidoSmp(Integer numeroPedido);
	
	public abstract PedidosSmp consultarPedidoConTodo(Integer numeroPedido);

}
