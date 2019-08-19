package com.atrium.hibernate.modelo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Pedidos;
import com.atrium.hibernate.dao.ext.Pedido_DAOExt;

/**
 * Clase para la Gestion de Pedidos
 * 
 * @author Sergio Sánchez García 
 * @version 1.0
 * @since 10/05/2019
 *
 */

@Repository("gestion_pedidos")
@Scope("prototype") 
public class Gestion_Pedidos implements IGestion_Pedidos {

	private Pedido_DAOExt pedido_dao;

	// **** CONSULTAS DE PEDIDOS ****
	
	// Consulta por Número de Pedido con Líneas y Artículos
	@Override
	@Transactional(readOnly = true)
	public Pedidos consultar_porNumeroPedido(Integer numero_pedido) {
		return pedido_dao.consultar_ConLinea(numero_pedido);
	}
	
	// Consulta por Número de Pedido "Carga Vaga" 
	@Override
	@Transactional(readOnly = true)
	public Pedidos consultar_porNumeroPedidoVaga(Integer numeroPedido) {
		return pedido_dao.findByNumeroPedido(numeroPedido).get(0); 
	}
	
	// Consulta de Todo con Número de Pedido con Líneas y Artículos
	@Override
	@Transactional(readOnly = true)
	public List<Pedidos> consultar_todos() {
		List<Pedidos> lista = pedido_dao.consultar_Todo();
		return lista;
	}
	
	// Consulta de Todo con "Carga Vaga"
	@Override
	@Transactional(readOnly = true)
	public List<Pedidos> consultar_todosVaga() {
		List<Pedidos> lista = pedido_dao.consultar_Todo();
		return lista;
	}

	// ***** OPERACIONES CRUD ******

	@Override
	@Transactional
	public void alta_Pedido(Pedidos pedido) {
		pedido_dao.save(pedido);
	}

	@Override
	@Transactional
	public void baja_Pedido(Pedidos pedido) {
		pedido_dao.delete(pedido);
	}

	@Override
	@Transactional
	public void modificacion_Pedido(Pedidos pedido) {
		pedido_dao.attachDirty(pedido);
	}
	

	
	

	// Accesor Spring
	public void setPedido_dao(Pedido_DAOExt pedido_dao) {
		this.pedido_dao = pedido_dao;
	}

}
