package com.atrium.hibernate.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.PedidosSmp;

/**
 * A data access object (DAO) providing persistence and search support for
 * PedidosSmp entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.atrium.hibernate.PedidosSmp
 * @author MyEclipse Persistence Tools
 */
@Repository("pedidoSmpDAO")
@Scope("prototype")
public class PedidosSmpDAO {
	private static final Logger log = LoggerFactory.getLogger(PedidosSmpDAO.class);
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

	public void save(PedidosSmp transientInstance) {
		log.debug("saving PedidosSmp instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PedidosSmp persistentInstance) {
		log.debug("deleting PedidosSmp instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PedidosSmp findById(java.lang.Integer id) {
		log.debug("getting PedidosSmp instance with id: " + id);
		try {
			PedidosSmp instance = (PedidosSmp) getCurrentSession().get("com.atrium.hibernate.PedidosSmp", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PedidosSmp instance) {
		log.debug("finding PedidosSmp instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.atrium.hibernate.PedidosSmp")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding PedidosSmp instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from PedidosSmp as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPortePedido(Object portePedido) {
		return findByProperty(PORTE_PEDIDO, portePedido);
	}

	public List findBySeguroPedido(Object seguroPedido) {
		return findByProperty(SEGURO_PEDIDO, seguroPedido);
	}

	public List findByOtrosCargosPedido(Object otrosCargosPedido) {
		return findByProperty(OTROS_CARGOS_PEDIDO, otrosCargosPedido);
	}

	public List findByTotalCargosPedido(Object totalCargosPedido) {
		return findByProperty(TOTAL_CARGOS_PEDIDO, totalCargosPedido);
	}

	public List findByTotalBrutoPedido(Object totalBrutoPedido) {
		return findByProperty(TOTAL_BRUTO_PEDIDO, totalBrutoPedido);
	}

	public List findByPorcentajeIvaPedido(Object porcentajeIvaPedido) {
		return findByProperty(PORCENTAJE_IVA_PEDIDO, porcentajeIvaPedido);
	}

	public List findByIvaPedido(Object ivaPedido) {
		return findByProperty(IVA_PEDIDO, ivaPedido);
	}

	public List findByTotalFacturaPedido(Object totalFacturaPedido) {
		return findByProperty(TOTAL_FACTURA_PEDIDO, totalFacturaPedido);
	}

	public List findByCodigoCliente(Object codigoCliente) {
		return findByProperty(CODIGO_CLIENTE, codigoCliente);
	}

	public List findAll() {
		log.debug("finding all PedidosSmp instances");
		try {
			String queryString = "from PedidosSmp";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PedidosSmp merge(PedidosSmp detachedInstance) {
		log.debug("merging PedidosSmp instance");
		try {
			PedidosSmp result = (PedidosSmp) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PedidosSmp instance) {
		log.debug("attaching dirty PedidosSmp instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PedidosSmp instance) {
		log.debug("attaching clean PedidosSmp instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PedidosSmpDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PedidosSmpDAO) ctx.getBean("PedidosSmpDAO");
	}
}