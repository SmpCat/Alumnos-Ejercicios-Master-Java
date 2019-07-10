package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.LineaPedidoSmp;

public interface IGestionLineaPedidoSmp {

	public abstract LineaPedidoSmp consultarPorCodigoLineaPedido(Long codigoLineaPedido);

	public abstract List<LineaPedidoSmp> consultarLineaPedidoSmpTodos();
	
	public abstract List<LineaPedidoSmp> consultarPorPedidoLineaPedido(Integer numeroPedido);

	public abstract void altaLineaPedidoSmp(LineaPedidoSmp lineaPedidoSmp);

	public abstract void bajaLineaPedidoSmp(LineaPedidoSmp lineaPedidoSmp);

	public abstract void modificionLineaPedidoSmp(LineaPedidoSmp lineaPedidoSmp);
}
