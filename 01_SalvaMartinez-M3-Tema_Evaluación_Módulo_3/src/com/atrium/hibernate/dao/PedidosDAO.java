package com.atrium.hibernate.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Pedidos;

/**
 * A data access object (DAO) providing persistence and search support for
 * Pedidos entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.atrium.hibernate.Pedidos
 * @author MyEclipse Persistence Tools
 */
public class PedidosDAO {
	private static final Logger log = LoggerFactory.getLogger(PedidosDAO.class);
	// property constants
	public static final String PORTE_PEDIDO = "portePedido";
	public static final String SEGURO_PEDIDO = "seguroPedido";
	public static final String OTROS_CARGOS_PEDIDO = "otrosCargosPedido";
	public static final String TOTAL_CARGOS_PEDIDO = "totalCargosPedido";
	public static final String TOTAL_BRUTO_PEDIDO = "totalBrutoPedido";
	public static final String PORCENTAJE_IVA_PEDIDO = "porcentajeIvaPedido";
	public static final String IVA_PEDIDO = "ivaPedido";
	public static final String TOTAL_FACTURA_PEDIDO = "totalFacturaPedido";
	public static final String CODIGO_CLIENTE = "codigoCliente";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession() {
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

	public Pedidos findById(java.lang.Integer id) {
		log.debug("getting Pedidos instance with id: " + id);
		try {
			Pedidos instance = (Pedidos) getCurrentSession().get(
					"com.atrium.hibernate.Pedidos", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Pedidos> findByExample(Pedidos instance) {
		log.debug("finding Pedidos instance by example");
		try {
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

	public List findByProperty(String propertyName, Object value) {
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

	public List findAll() {
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
			Pedidos result = (Pedidos) getCurrentSession().merge(
					detachedInstance);
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