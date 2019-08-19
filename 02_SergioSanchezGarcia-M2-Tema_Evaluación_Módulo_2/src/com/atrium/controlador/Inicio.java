package com.atrium.controlador;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.hibernate.Articulos;
import com.atrium.hibernate.Linea_Pedido;
import com.atrium.hibernate.Pedidos;
import com.atrium.hibernate.modelo.IGestion_Articulos;
import com.atrium.hibernate.modelo.IGestion_Linea_Pedido;
import com.atrium.hibernate.modelo.IGestion_Pedidos;

/**
 * Clase de inicio de la prueba Intermedia
 * 
 * @author Sergio Sánchez García
 * @version 1.0.
 * @since 24-04-2019.
 */

public class Inicio {
	
	/**
	 * Clase inicial de arranque de programa
	 * 
	 * @param args  Argumentos pasados via consola.
	 */
	public static void main(String tabla[]) {
		
		// Arranque del Programa //
		
		@SuppressWarnings("resource")
		ApplicationContext contexto = new ClassPathXmlApplicationContext(
				"/com/atrium/spring/modelo.xml");
		
		// Generamos las fachadas //
		
		IGestion_Pedidos gestion_pedidos = contexto.getBean(IGestion_Pedidos.class); 
		IGestion_Linea_Pedido gestion_linea_pedido = contexto.getBean(IGestion_Linea_Pedido.class); 
		IGestion_Articulos gestion_articulos = contexto.getBean(IGestion_Articulos.class); 

		CalculoDePedidos calculador = new CalculoDePedidos(); 
	
		/******************************************************************
		 ************************ CRUD DE ARTICULOS ***********************
		 ******************************************************************/
		
		// 1. Consulta de Articulos con Lineas de Pedido
		Articulos articuloConLineas = gestion_articulos.consultar_PorCodigoConLineas(9010); 
		
		// 2. Consulta de Artículos "Carga Vaga"
		Articulos articuloVaga = gestion_articulos.consultar_PorCodigo(101); 
		
		// Consulta de todos los Artículos "Carga Vaga" 
		List<Articulos> listaArticulosConLineas = gestion_articulos.consultar_Todos(); 
		
		// Consulta de todos los Artículos con Líneas
		List<Articulos> listaArticulosVaga = gestion_articulos.consultar_TodosConLineas(); 
		
		// 3. Insert de Articulos 
		Articulos articulo = new Articulos(); 
		articulo.setDescripcionArticulo("Disco Música Clásica");
		articulo.setPrecioUnidadArticulo(new Double(2.34));
		articulo.setCantidad(12);
		gestion_articulos.alta_Articulos(articulo);
		
		// 4. Modificación de Artículos
		articulo.setDescripcionArticulo("Disco Duro 3TB");
		gestion_articulos.modificacion_Articulos(articulo);
		
		// Baja de articulos 
		gestion_articulos.baja_Articulos(articulo);
		
		
		
		/******************************************************************
		 ******************** CRUD DE LINEA DE PEDIDOS ********************
		 ******************************************************************/		
		
		
		// 1. Consulta de Lineas de Pedido con Articulos
		Linea_Pedido lineaPedido2 = gestion_linea_pedido.consultar_porCodigoConArticulos(2); 
		
		// 2. Consulta de Lineas de Pedido  "Carga Vaga"
		Linea_Pedido lineaPedido = gestion_linea_pedido.consultar_porCodigoSinArticulos(2); 
		
		// Consulta de todos las Lineas de Pedidos con Artículos
		List<Linea_Pedido> lista1 = gestion_linea_pedido.consultar_TodosConArticulos();
		
		// 2. Consulta de todas las Lineas de Pedido "Carga Vaga"
		List<Linea_Pedido> lista2 = gestion_linea_pedido.consultar_Todos(); 
	
		
		// 3. Insert de Lineas de Pedido 
		Integer unidadesArticulos = new Integer(4); 	
		Map<Articulos, Integer> map = new HashMap<Articulos, Integer>();
		map.put(articulo, unidadesArticulos); 
		
		HashSet<Linea_Pedido> lineasPedidoAInsertar= calculador.generarLineasPedidos(map);
		
		for (Linea_Pedido linea_Pedido : lineasPedidoAInsertar) {
			//   DEBE TENER ASOCIADO UN NUMERO DE PEDIDO (MIRAR ALTA DE PEDIDO)
			// gestion_linea_pedido.alta_Linea_Pedido(linea_Pedido);
		}
		
		// 4. Modificación de Linea de Pedido
		
		lineaPedido.setNumeroUnidadesArticulo(6);
		gestion_linea_pedido.modificacion_Linea_Pedido(lineaPedido);
		
		// Baja de Linea de Pedido 

		gestion_linea_pedido.baja_Linea_Pedido(lineaPedido);
		
		
		
		/******************************************************************
		 ************************* CRUD DE PEDIDOS ************************
		 ******************************************************************/		
		
		
		
		// 1. Consulta de Pedido con Todo
		Pedidos pedido = gestion_pedidos.consultar_porNumeroPedido(1); 
		MostrarDatos.mostrar(pedido);
		
		// 2. Consulta de Pedido  "Carga Vaga"
		Pedidos pedidoVaga = gestion_pedidos.consultar_porNumeroPedidoVaga(1); 
		
		// Consulta de todos los Pedidos con Todo
		List<Pedidos> listaPedidos = gestion_pedidos.consultar_todos(); 
		MostrarDatos.mostrar(listaPedidos);
		
		// 2. Consulta de todas las Lineas de Pedido "Carga Vaga"
		List<Pedidos> listaPedidosVaga = gestion_pedidos.consultar_todosVaga(); 
	
		
		// 3. Insert de Pedido 

		Pedidos pedidoAInsertar = calculador.generarPedido(lineasPedidoAInsertar); 
		gestion_pedidos.alta_Pedido(pedidoAInsertar);
		
		// 4. Modificación de Pedido
		pedidoAInsertar.setIvaPedido(new Double(10.5));
		gestion_pedidos.modificacion_Pedido(pedidoAInsertar);
		
		// Baja de Linea de Pedido 
		gestion_pedidos.baja_Pedido(pedidoAInsertar);
		
	}
}
