package com.atrium.logica;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.hibernate.ArticulosSmp;
import com.atrium.hibernate.LineaPedidoSmp;
import com.atrium.hibernate.PedidosSmp;
import com.atrium.hibernate.modelo.IGestionPedidosSmp;
import com.atrium.hibernate.modelo.IGestionArticulosSmp;
import com.atrium.utiles.OrdenacionList;
import com.atrium.utiles.ReplicarSet_List;

public class PruebaCrud {

	private ApplicationContext contexto;

	private IGestionArticulosSmp gestionArticulosSmp;
	private IGestionPedidosSmp gestionPedidosSmp;

	public PruebaCrud() {

		// ARRANQUE DE SPRING
		contexto = new ClassPathXmlApplicationContext("/com/atrium/spring/modelo.xml");

		// CREACION DE LAS FACHADAS
		gestionArticulosSmp = contexto.getBean(IGestionArticulosSmp.class);
		gestionPedidosSmp = contexto.getBean(IGestionPedidosSmp.class);

		// ART�CULOS
		// CREACION DE LOS OBJETOS EN TRANSITO PARA SU ALTA EN LA BASE DE DATOS
		ArticulosSmp articulosSmp = new ArticulosSmp();
		articulosSmp.setDescripcionArticulo("robot");
		articulosSmp.setCantidad(15);
		articulosSmp.setPrecioUnidadArticulo(12.0);
		// PROCESO DE ALTA
		try {
			gestionArticulosSmp.altaArticulosSmp(articulosSmp);
			System.out.println("Alta art�culo " + articulosSmp.getCodigoArticulo() + " realizada correctamente");
		} catch (Exception e) {
			System.out.println("Alta art�culo no realizada");
		}

		// ART�CULOS
		// CREACION DE LOS OBJETOS EN TRANSITO PARA SU ALTA EN LA BASE DE DATOS
		articulosSmp.setDescripcionArticulo("puzzle");
		articulosSmp.setCantidad(22);
		articulosSmp.setPrecioUnidadArticulo(15.0);
		// PROCESO DE ALTA
		try {
			gestionArticulosSmp.altaArticulosSmp(articulosSmp);
			System.out.println("Alta art�culo " + articulosSmp.getCodigoArticulo() + " realizada correctamente");
		} catch (Exception e) {
			System.out.println("Alta art�culo no realizada");
		}

		// MODIFICACION DEL OBJETO EN TRANSITO
		articulosSmp.setDescripcionArticulo("bicicleta");
		// PROCESO DE MODIFICACION
		try {
			gestionArticulosSmp.modificionArticulosSmp(articulosSmp);
			System.out
					.println("Modificaci�n art�culo " + articulosSmp.getCodigoArticulo() + " realizada correctamente");
		} catch (Exception e) {
			System.out.println("Modificaci�n art�culo no realizada");
		}

		// BAJA DEL OBJETO EN TRANSITO
		articulosSmp.setCodigoArticulo(articulosSmp.getCodigoArticulo() - 1);
		// PROCESO DE BAJA
		try {
			gestionArticulosSmp.bajaArticulosSmp(articulosSmp);
			System.out.println("Baja art�culo " + articulosSmp.getCodigoArticulo() + " realizada correctamente");

		} catch (Exception e) {
			System.out.println("Baja art�culo " + articulosSmp.getCodigoArticulo() + " no realizada");
		} finally {
			articulosSmp.setCodigoArticulo(articulosSmp.getCodigoArticulo() + 1);
		}

		// CONSULTAS VARIAS
		// CONSULTA DE TODOS LOS ART�CULOS ORDENADOS
		try {
			List<ArticulosSmp> listaArticulos = gestionArticulosSmp.consultarArticulosSmpTodosOrdenados();

			for (ArticulosSmp articulosSmpAux : listaArticulos) {
				System.out.println("Codigo art�culo: " + articulosSmpAux.getCodigoArticulo());
			}
			System.out.println("Consulta de todos los art�culos realizada correctamente");

		} catch (Exception e) {
			System.out.println("Error al consultar todos los art�culos");
		}

		// CREACION DE LOS OBJETOS EN TRANSITO PARA SU ALTA EN LA BASE DE DATOS

		// CONSULTA DE UN ART�CULO POR C�DIGO DE ART�CULO
		try {
			articulosSmp = gestionArticulosSmp.consultarPorCodigoArticulo(articulosSmp.getCodigoArticulo());
			System.out.println("Codigo art�culo: " + articulosSmp.getCodigoArticulo());
			System.out
					.println("Consulta del art�culo " + articulosSmp.getCodigoArticulo() + " realizada correctamente");

		} catch (Exception e) {
			System.out.println("Error al consultar por c�digo de art�culo " + articulosSmp.getCodigoArticulo());
		}

		// PEDIDOS
		// CREACION DE LOS OBJETOS EN TRANSITO PARA SU ALTA EN LA BASE DE DATOS

		PedidosSmp pedidosSmp = new PedidosSmp();

		LineaPedidoSmp lineaPedidoSmpNuevo1 = new LineaPedidoSmp(articulosSmp, pedidosSmp, 5.0, 2, 7.0);
		LineaPedidoSmp lineaPedidoSmpNuevo2 = new LineaPedidoSmp(articulosSmp, pedidosSmp, 7.0, 12, 23.0);
		LineaPedidoSmp lineaPedidoSmpNuevo3 = new LineaPedidoSmp(articulosSmp, pedidosSmp, 8.0, 14, 26.0);

		Set<LineaPedidoSmp> setLineaPedido = new HashSet<LineaPedidoSmp>();
		setLineaPedido.add(lineaPedidoSmpNuevo1);
		setLineaPedido.add(lineaPedidoSmpNuevo2);
		setLineaPedido.add(lineaPedidoSmpNuevo3);
		
		pedidosSmp.setFechaPedido(new Date(21111971));
		pedidosSmp.setIvaPedido(1.0);
		pedidosSmp.setOtrosCargosPedido(2.0);
		pedidosSmp.setPorcentajeIvaPedido(new Byte((byte) 1));
		pedidosSmp.setCodigoCliente(3);
		pedidosSmp.setLineaPedidoSmps(setLineaPedido);

		// PROCESO DE ALTA
		try {
			gestionPedidosSmp.altaPedidosSmp(pedidosSmp);
			System.out.println("Alta pedido " + pedidosSmp.getNumeroPedido() + " realizada correctamente");
		} catch (Exception e) {
			System.out.println("Alta pedido " + pedidosSmp.getNumeroPedido() + " no realizada");
		}

		// MODIFICACION DEL OBJETO EN TRANSITO
		pedidosSmp.setIvaPedido(21.0);
		// PROCESO DE MODIFICACION
		try {
			gestionPedidosSmp.modificionPedidosSmp(pedidosSmp);
			System.out.println("Modificaci�n pedido " + pedidosSmp.getNumeroPedido() + " realizada correctamente");
		} catch (Exception e) {
			System.out.println("Modificaci�n pedido no realizada");
		}

		// BAJA DEL OBJETO EN TRANSITO
		pedidosSmp.setNumeroPedido(pedidosSmp.getNumeroPedido() - 2);
		// PROCESO DE BAJA
		try {
			pedidosSmp = gestionPedidosSmp.consultarPorNumeroPedido(pedidosSmp.getNumeroPedido());
			gestionPedidosSmp.bajaPedidosSmp(pedidosSmp);
			System.out.println("Baja pedido " + pedidosSmp.getNumeroPedido() + " realizada correctamente");
		} catch (Exception e) {
			System.out.println("Baja pedido " + pedidosSmp.getNumeroPedido() + " no realizada");
		} finally {
			pedidosSmp.setNumeroPedido(pedidosSmp.getNumeroPedido() + 2);
		}

		// CONSULTAS VARIAS
		// CONSULTA DE TODOS LOS PEDIDOS ORDENADOS
		try {
			List<PedidosSmp> listaPedidos = gestionPedidosSmp.consultarPedidosSmpTodosOrdenados();

			for (PedidosSmp pedidosSmpAux : listaPedidos) {
				System.out.println("N�mero pedido: " + pedidosSmpAux.getNumeroPedido());
			}
			System.out.println("Consulta de todos los pedidos realizada correctamente");

		} catch (Exception e) {
			System.out.println("Error al consultar todos los pedidos");
		}

		// CONSULTA DE UN PEDIDO POR N�MERO DE PEDIDO
		try {
			pedidosSmp = gestionPedidosSmp.consultarPorNumeroPedido(pedidosSmp.getNumeroPedido());
			System.out.println("N�mero pedido: " + pedidosSmp.getNumeroPedido());
			System.out.println("Consulta por n�mero de pedido " + pedidosSmp.getNumeroPedido() + " realizada correctamente");

		} catch (Exception e) {
			System.out.println("Error al consultar por n�mero de pedido " + pedidosSmp.getNumeroPedido());
		}

		// CONSULTA DE UN PEDIDO CON SUS LINEAS DE PEDIDO
		try {
			pedidosSmp = gestionPedidosSmp.consultarPedidoConLineaPedidoSmp(pedidosSmp.getNumeroPedido());
			Set<LineaPedidoSmp> setLineaPedidoSmp = pedidosSmp.getLineaPedidoSmps();
			List<LineaPedidoSmp> listaLineaPedidoSmp = (List<LineaPedidoSmp>) ReplicarSet_List.replicar(setLineaPedidoSmp);
			LineaPedidoSmp lineaPedidoSmp = new LineaPedidoSmp();
			OrdenacionList ordenacionList= new OrdenacionList();
			List<LineaPedidoSmp> resultado = (List<LineaPedidoSmp>) ordenacionList.ordenar(listaLineaPedidoSmp, lineaPedidoSmp, 1, "getCodigoLineaPedido");
			
			for (LineaPedidoSmp lineaPedidoSmpAux : resultado) {
				System.out.println("LineaPedido: " + lineaPedidoSmpAux.getCodigoLineaPedido());
			}
			System.out.println("Consulta de lineas de pedido por n�mero de pedido " + pedidosSmp.getNumeroPedido() + " realizada correctamente");
			
		} catch (Exception e) {
			System.out.println("Error al consultar pedido " + pedidosSmp.getNumeroPedido() + " por linea de pedido");
		}

		// CONSULTA DE UN PEDIDO CON SUS LINEAS DE PEDIDO Y ART�CULOS
		try {
			pedidosSmp = gestionPedidosSmp.consultarPedidoConTodo(pedidosSmp.getNumeroPedido());
			Set<LineaPedidoSmp> setLineaPedidoSmp = pedidosSmp.getLineaPedidoSmps();
			List<LineaPedidoSmp> listaLineaPedidoSmp = (List<LineaPedidoSmp>) ReplicarSet_List.replicar(setLineaPedidoSmp);
			LineaPedidoSmp lineaPedidoSmp = new LineaPedidoSmp();
			OrdenacionList ordenacionList= new OrdenacionList();
			List<LineaPedidoSmp> resultado = (List<LineaPedidoSmp>) ordenacionList.ordenar(listaLineaPedidoSmp, lineaPedidoSmp, 1, "getCodigoLineaPedido");
			
			for (LineaPedidoSmp lineaPedidoSmpAux : resultado) {
				System.out.println("LineaPedido: " + lineaPedidoSmpAux.getCodigoLineaPedido() + " art�culo: " + 
						lineaPedidoSmpAux.getArticulosSmp().getCodigoArticulo() + " " + lineaPedidoSmpAux.getArticulosSmp().getDescripcionArticulo());
			}
			System.out.println("Consulta de los art�culos por cada linea de pedido por n�mero de pedido " + pedidosSmp.getNumeroPedido() + " realizada correctamente");
			
		} catch (Exception e) {
			System.out.println(
					"Error al consultar pedido " + pedidosSmp.getNumeroPedido() + " por linea de pedido y art�culos");
		}
	}
}
