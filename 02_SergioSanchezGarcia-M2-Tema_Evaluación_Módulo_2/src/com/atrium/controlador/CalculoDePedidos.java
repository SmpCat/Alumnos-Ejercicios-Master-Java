package com.atrium.controlador;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atrium.hibernate.Articulos;
import com.atrium.hibernate.Linea_Pedido;
import com.atrium.hibernate.Pedidos;

public class CalculoDePedidos {
	
	private static final Logger log = LoggerFactory
			.getLogger(CalculoDePedidos.class);
	
	
	/**
	 * Clase que genera el Pedido a partir de las correspondientes Lineas
	 * de Pedidos. 
	 * @author Sergio Sánchez 
	 * @param listaLineasPedido
	 * @return
	 */
	public Pedidos generarPedido(HashSet<Linea_Pedido> listaLineasPedido) {
		
		Pedidos pedido = new Pedidos();
		Double totalFacturaPedido= new Double(Constantes.VALOR_CERO); 
		Double totalBrutoPedido = new Double(Constantes.VALOR_CERO);
		Double ivaPedido = new Double(Constantes.VALOR_CERO);
		
		log.info("* Comienza la generación del Pedido");
		
		for (Linea_Pedido linea_Pedido : listaLineasPedido) {
			totalFacturaPedido += linea_Pedido.getPrecioUnidadArticulo(); 
			linea_Pedido.setPedidos(pedido);
		}
		
		ivaPedido = getValorPorcentaje(totalFacturaPedido, Constantes.PORCENTAJE_IVA);
		totalBrutoPedido = totalFacturaPedido - ivaPedido; 
		
		// Se añaden los campos obtenidos
		pedido.setFechaPedido(new Date());
		pedido.setTotalBrutoPedido(totalBrutoPedido);
		pedido.setPorcentajeIvaPedido(Constantes.PORCENTAJE_IVA.intValue());
		pedido.setIvaPedido(ivaPedido);
		pedido.setTotalFacturaPedido(totalFacturaPedido);
		pedido.setLineaPedido(listaLineasPedido);
		pedido.setCodigoCliente(new Integer(5));
		
		return pedido; 
	}




	/**
	 * Clase que Genera las Lineas de Pedido a partir de los Articulos
	 * 
	 * @author Sergio Sánchez García
	 * @param map
	 * @return List<Linea_Pedido> 
	 */
	public HashSet<Linea_Pedido> generarLineasPedidos(Map<Articulos, Integer> map) {
		
		HashSet<Linea_Pedido> listaLineasPedidos = new HashSet<Linea_Pedido>();
		
		for (Map.Entry<Articulos, Integer> entradaArticulo : map.entrySet()) {
			
			// Creamos linea_Pedido
			Linea_Pedido lineaPedido = new Linea_Pedido();
			
			// Obtenemos el articulo y número de unidades
			Articulos articulo = entradaArticulo.getKey(); 
			Integer numeroUnidades = entradaArticulo.getValue(); 
			
			lineaPedido.setArticulos(articulo);
			lineaPedido.setNumeroUnidadesArticulo(numeroUnidades);
			
			if (articuloTieneDescuento(articulo.getCodigoArticulo())) {
				lineaPedido.setPorcentajeDescuento(Constantes.PORCENTAJE_DIEZ);
				lineaPedido.setPrecioUnidadArticulo(articulo.getPrecioUnidadArticulo() - getValorPorcentaje(articulo.getPrecioUnidadArticulo(), lineaPedido.getPorcentajeDescuento()));
			} else {
				lineaPedido.setPorcentajeDescuento(Constantes.PORCENTAJE_CERO);
				lineaPedido.setPrecioUnidadArticulo(articulo.getPrecioUnidadArticulo());
			}
			
		
			// Se añade la linea Pedido
			listaLineasPedidos.add(lineaPedido);
			log.info("* Se añade la línea de Pedido que contiene " + numeroUnidades + " " + articulo.getDescripcionArticulo());
		}	
		
		log.info("-- Ya no hay más Artículos en el Pedido --");
		return listaLineasPedidos; 
	}
	
	
	
	/**
	 * Clase que verifica si tiene descuento un Artículo
	 * 
	 * @autor Sergio Sanchez 
	 * @param codigoArticulo
	 * @return Descuento
	 */
	public boolean articuloTieneDescuento(Integer codigoArticulo) {
		boolean descuento = false; 
		if (Constantes.LISTA_ARTICULOS_DESCUENTO.contains(codigoArticulo)) {
			descuento = true;
		}	
		return descuento; 
	}
	
	
	/**
	 * Clase que devuelve el valor del IVA correspondiente a un Importe
	 * 
	 * @param totalValor
	 * @param porcentajeIva
	 * @return Valor del IVA
	 */
	private Double getValorPorcentaje(Double totalValor, Double porcentajeIva) {
		return (totalValor * (porcentajeIva/Constantes.PORCENTAJE_CIEN)); 
	}
	
	
	
}
