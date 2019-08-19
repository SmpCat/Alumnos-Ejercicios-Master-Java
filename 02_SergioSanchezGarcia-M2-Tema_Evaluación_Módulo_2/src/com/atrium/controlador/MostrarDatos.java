package com.atrium.controlador;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atrium.hibernate.Linea_Pedido;
import com.atrium.hibernate.Pedidos;


/**
 * Clase Muestra los datos de Pedidos y Lineas de Pedidos
 * 
 * @author Sergio Sánchez García
 * @version 1.0.
 * @since 24-04-2019.
 */
public class MostrarDatos {
	
	private static final Logger log = LoggerFactory
			.getLogger(MostrarDatos.class);
	
	public static void mostrar(Pedidos pedido) {
		
		if (pedido != null) {
		log.info("**** Pedido número: " + pedido.getNumeroPedido() + " ****");
		if (pedido.getFechaPedido() != null)
			log.info("Fecha de Pedido: " + pedido.getFechaPedido());
		if (pedido.getPortePedido() != null)
			log.info("Porte de Pedido: " + pedido.getPortePedido());
		if (pedido.getSeguroPedido() != null)
			log.info("Seguro de Pedido: " + pedido.getSeguroPedido());
		if (pedido.getOtrosCargosPedido() != null)
			log.info("Otros Cargos de Pedido: " + pedido.getOtrosCargosPedido());
		if (pedido.getTotalCargosPedido() != null)
			log.info("Total Cargos de Pedido: " + pedido.getTotalCargosPedido());
		if (pedido.getTotalBrutoPedido() != null)
			log.info("Total Bruto de Pedido: " + pedido.getTotalBrutoPedido());
		if (pedido.getPorcentajeIvaPedido() != null)
			log.info("Porcentaje IVA de Pedido: " + pedido.getPorcentajeIvaPedido());
		if (pedido.getIvaPedido() != null)
			log.info("IVA de Pedido: " + pedido.getIvaPedido());
		if (pedido.getTotalFacturaPedido() != null)
			log.info("Total Cargo de Pedido: " + pedido.getTotalFacturaPedido());
		if (pedido.getCodigoCliente() != null)
			log.info("Código de Cliente: " + pedido.getCodigoCliente());
		
		
		if (pedido.getLineaPedido() != null) {
			
			log.info("----- Lineas de Pedido asociadas: " + pedido.getLineaPedido().size() + " -----");
			Set<Linea_Pedido> linea_pedidos = pedido.getLineaPedido(); 
			for (Linea_Pedido linea_Pedido : linea_pedidos) {
				log.info("Código de Linea de Pedido: " + linea_Pedido.getCodigoLineaPedido());
				log.info("Código de Artículo: " + linea_Pedido.getArticulos().getCodigoArticulo());
				log.info("Precio Unidad Artículo: " + linea_Pedido.getArticulos().getPrecioUnidadArticulo());
				log.info("Número Unidades de Artículo: " + linea_Pedido.getNumeroUnidadesArticulo());
				log.info("Porcentaje de descuento: " + linea_Pedido.getPorcentajeDescuento() + "%");
				log.info("--------------------------------------"); 
			}	
		}	
		}else {
			log.info("----- No se ha encontrado Pedido en la BBDD "); 
		}
	}
	
	
	public static void mostrar(List<Pedidos> listaPedidos) {
		
		if (listaPedidos != null) {
			log.info("*****************LISTA DE PEDIDOS******************");
			log.info("Número de Pedidos: " + listaPedidos.size());
			for (Pedidos pedido : listaPedidos) {
				mostrar(pedido);
			}
		}
	}
}
