package com.atrium.hibernate.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.atrium.hibernate.Pedidos;

/**
 * DAO de Pedido
 * 
 * @see com.atrium.hibernate.Pedidos
 * @author Sergio Sánchez García
 */

public class PedidosDAO {
	private static final Logger log = LoggerFactory.getLogger(PedidosDAO.class);

	// Constantes de búsqueda 
	private static final String NUMERO_PEDIDO = "numeroPedido";
	private static final String FECHA_PEDIDO = "fechaPedido";
	private static final String PORTE_PEDIDO = "portePedido";
	private static final String SEGURO_PEDIDO = "seguroPedido";
	private static final String OTROS_CARGOS_PEDIDO = "otrosCargosPedido";
	private static final String TOTAL_CARGOS_PEDIDO = "totalCargosPedido";
	private static final String TOTAL_BRUTO_PEDIDO = "totalBrutoPedido";
	private static final String PORCENTAJE_IVA_PEDIDO = "porcentajeIvaPedido";
	private static final String IVA_PEDIDO = "ivaPedido";
	private static final String TOTAL_FACTURA_PEDIDO = "totalFacturaPedido";
	private static final String CODIGO_CLIENTE = "codigoCliente";
	
	// Session 
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Pedidos transientInstance) {
		log.debug("saving Pedidos instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Pedidos persistentInstance) {
		log.debug("deleting Pedidos instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pedidos findById(Integer numero_pedido) {
		log.debug("getting Pedidos instance with id: " + numero_pedido);
		try {
			Pedidos instance = (Pedidos) getCurrentSession().get(
					"com.atrium.hibernate.Pedidos", numero_pedido);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Pedidos> findByExample(Pedidos instance) {
		log.debug("finding Pedidos instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Pedidos> results = (List<Pedidos>) getCurrentSession()
					.createCriteria("com.atrium.hibernate.Pedidos")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Pedidos> findByProperty(String propertyName, Object value) {
		log.debug("finding Pedidos instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Pedidos as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	
	// Métodos de búsqueda por caracteristica 
	
	public List<Pedidos> findByNumeroPedido(Object numeroPedido) {
		return findByProperty(NUMERO_PEDIDO, numeroPedido);
	}
	public List<Pedidos> findByFechaPedido(Object fechaPedido) {
		return findByProperty(FECHA_PEDIDO, fechaPedido);
	}
	public List<Pedidos> findByPortePedido(Object portePedido) {
		return findByProperty(PORTE_PEDIDO, portePedido);
	}
	public List<Pedidos> findBySeguroPedido(Object seguroPedido) {
		return findByProperty(SEGURO_PEDIDO, seguroPedido);
	}
	public List<Pedidos> findByOtrosCargosPedido(Object otrosCargosPedido) {
		return findByProperty(OTROS_CARGOS_PEDIDO, otrosCargosPedido);
	}
	public List<Pedidos> findByTotalCargosPedido(Object totalCargosPedido) {
		return findByProperty(TOTAL_CARGOS_PEDIDO, totalCargosPedido);
	}
	public List<Pedidos> findByTotalBrutoPedido(Object totalBrutoPedido) {
		return findByProperty(TOTAL_BRUTO_PEDIDO, totalBrutoPedido);
	}
	public List<Pedidos> findByPorcentajeIvaPedido(Object porcentajeIvaPedido) {
		return findByProperty(PORCENTAJE_IVA_PEDIDO, porcentajeIvaPedido);
	}
	public List<Pedidos> findByIvaPedido(Object ivaPedido) {
		return findByProperty(IVA_PEDIDO, ivaPedido);
	}
	public List<Pedidos> findByTotalFacturaPedido(Object totalFacturaPedido) {
		return findByProperty(TOTAL_FACTURA_PEDIDO, totalFacturaPedido);
	}
	public List<Pedidos> findByCodigoCliente(Object codigoCliente) {
		return findByProperty(CODIGO_CLIENTE, codigoCliente);
	}

	// Búsqueda de Todos los pedidos 
	public List<Pedidos> findAll() {
		log.debug("finding all Pedidos instances");
		try {
			String queryString = "from Pedidos";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Pedidos merge(Pedidos detachedInstance) {
		log.debug("merging Pedidos instance");
		try {
			Pedidos result = (Pedidos) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Pedidos instance) {
		log.debug("attaching dirty Pedidos instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pedidos instance) {
		log.debug("attaching clean Pedidos instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PedidosDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PedidosDAO) ctx.getBean("PedidosDAO");
	}
}