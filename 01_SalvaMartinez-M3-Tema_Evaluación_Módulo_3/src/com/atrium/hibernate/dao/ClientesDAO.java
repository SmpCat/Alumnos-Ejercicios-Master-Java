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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Clientes;

/**
 * A data access object (DAO) providing persistence and search support for
 * Clientes entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.atrium.hibernate.Clientes
 * @author MyEclipse Persistence Tools
 */
@Repository("cliente_dao")
@Scope("prototype")
public class ClientesDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ClientesDAO.class);
	// property constants
	public static final String NOMBRE_CLIENTE = "nombreCliente";
	public static final String TIPO_EMPRESA = "tipoEmpresa";
	public static final String CIF_CLIENTE = "cifCliente";
	public static final String NIF_CLIENTE = "nifCliente";
	public static final String NOMBRE_COMERCIAL_CLIENTE = "nombreComercialCliente";
	public static final String CALLE_CLIENTE = "calleCliente";
	public static final String CIUDAD_CLIENTE = "ciudadCliente";
	public static final String CP_CLIENTE = "cpCliente";
	public static final String PROVINCIA_CLIENTE = "provinciaCliente";
	public static final String TELEFONO_CLIENTE = "telefonoCliente";
	public static final String FAX_CLIENTE = "faxCliente";
	public static final String EMAIL_CLIENTE = "emailCliente";
	public static final String CONTADO_CLIENTE = "contadoCliente";
	public static final String CREDITO_CLIENTE = "creditoCliente";
	public static final String CIFRA_VENTAS_CLIENTE = "cifraVentasCliente";
	public static final String BENEFICIOS_CLIENTE = "beneficiosCliente";
	public static final String PREPAGO_CLIENTE = "prepagoCliente";
	public static final String CAPITAL_CLIENTE = "capitalCliente";
	public static final String INMOVILIZADO_CLIENTE = "inmovilizadoCliente";
	public static final String PASIVO_CLIENTE = "pasivoCliente";
	public static final String ACTIVO_CLIENTE = "activoCliente";
	public static final String LIMITE_CLIENTE = "limiteCliente";
	public static final String PENDIENTE_CLIENTE = "pendienteCliente";
	public static final String RESTO_CLIENTE = "restoCliente";
	public static final String CALLE_ENVIO_CLIENTE = "calleEnvioCliente";
	public static final String CIUDAD_ENVIO_CLIENTE = "ciudadEnvioCliente";
	public static final String CP_ENVIO_CLIENTE = "cpEnvioCliente";
	public static final String PROVINCIA_ENVIO_CLIENTE = "provinciaEnvioCliente";
	public static final String TELEFONO_ENVIO_CLIENTE = "telefonoEnvioCliente";
	public static final String FAX_ENVIO_CLIENTE = "faxEnvioCliente";
	public static final String EMAIL_ENVIO_CLIENTE = "emailEnvioCliente";
	public static final String OBSERVACIONES_CLIENTE = "observacionesCliente";
	public static final String ESTADO_CLIENTE = "estadoCliente";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Clientes transientInstance) {
		log.debug("saving Clientes instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Clientes persistentInstance) {
		log.debug("deleting Clientes instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Clientes findById(java.lang.Integer id) {
		log.debug("getting Clientes instance with id: " + id);
		try {
			Clientes instance = (Clientes) getCurrentSession().get(
					"com.atrium.hibernate.Clientes", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Clientes> findByExample(Clientes instance) {
		log.debug("finding Clientes instance by example");
		try {
			List<Clientes> results = (List<Clientes>) getCurrentSession()
					.createCriteria("com.atrium.hibernate.Clientes")
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
		log.debug("finding Clientes instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Clientes as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Clientes> findByNombreCliente(Object nombreCliente) {
		return findByProperty(NOMBRE_CLIENTE, nombreCliente);
	}

	public List<Clientes> findByTipoEmpresa(Object tipoEmpresa) {
		return findByProperty(TIPO_EMPRESA, tipoEmpresa);
	}

	public List<Clientes> findByCifCliente(Object cifCliente) {
		return findByProperty(CIF_CLIENTE, cifCliente);
	}

	public List<Clientes> findByNifCliente(Object nifCliente) {
		return findByProperty(NIF_CLIENTE, nifCliente);
	}

	public List<Clientes> findByNombreComercialCliente(
			Object nombreComercialCliente) {
		return findByProperty(NOMBRE_COMERCIAL_CLIENTE, nombreComercialCliente);
	}

	public List<Clientes> findByCalleCliente(Object calleCliente) {
		return findByProperty(CALLE_CLIENTE, calleCliente);
	}

	public List<Clientes> findByCiudadCliente(Object ciudadCliente) {
		return findByProperty(CIUDAD_CLIENTE, ciudadCliente);
	}

	public List<Clientes> findByCpCliente(Object cpCliente) {
		return findByProperty(CP_CLIENTE, cpCliente);
	}

	public List<Clientes> findByProvinciaCliente(Object provinciaCliente) {
		return findByProperty(PROVINCIA_CLIENTE, provinciaCliente);
	}

	public List<Clientes> findByTelefonoCliente(Object telefonoCliente) {
		return findByProperty(TELEFONO_CLIENTE, telefonoCliente);
	}

	public List<Clientes> findByFaxCliente(Object faxCliente) {
		return findByProperty(FAX_CLIENTE, faxCliente);
	}

	public List<Clientes> findByEmailCliente(Object emailCliente) {
		return findByProperty(EMAIL_CLIENTE, emailCliente);
	}

	public List<Clientes> findByContadoCliente(Object contadoCliente) {
		return findByProperty(CONTADO_CLIENTE, contadoCliente);
	}

	public List<Clientes> findByCreditoCliente(Object creditoCliente) {
		return findByProperty(CREDITO_CLIENTE, creditoCliente);
	}

	public List<Clientes> findByCifraVentasCliente(Object cifraVentasCliente) {
		return findByProperty(CIFRA_VENTAS_CLIENTE, cifraVentasCliente);
	}

	public List<Clientes> findByBeneficiosCliente(Object beneficiosCliente) {
		return findByProperty(BENEFICIOS_CLIENTE, beneficiosCliente);
	}

	public List<Clientes> findByPrepagoCliente(Object prepagoCliente) {
		return findByProperty(PREPAGO_CLIENTE, prepagoCliente);
	}

	public List<Clientes> findByCapitalCliente(Object capitalCliente) {
		return findByProperty(CAPITAL_CLIENTE, capitalCliente);
	}

	public List<Clientes> findByInmovilizadoCliente(Object inmovilizadoCliente) {
		return findByProperty(INMOVILIZADO_CLIENTE, inmovilizadoCliente);
	}

	public List<Clientes> findByPasivoCliente(Object pasivoCliente) {
		return findByProperty(PASIVO_CLIENTE, pasivoCliente);
	}

	public List<Clientes> findByActivoCliente(Object activoCliente) {
		return findByProperty(ACTIVO_CLIENTE, activoCliente);
	}

	public List<Clientes> findByLimiteCliente(Object limiteCliente) {
		return findByProperty(LIMITE_CLIENTE, limiteCliente);
	}

	public List<Clientes> findByPendienteCliente(Object pendienteCliente) {
		return findByProperty(PENDIENTE_CLIENTE, pendienteCliente);
	}

	public List<Clientes> findByRestoCliente(Object restoCliente) {
		return findByProperty(RESTO_CLIENTE, restoCliente);
	}

	public List<Clientes> findByCalleEnvioCliente(Object calleEnvioCliente) {
		return findByProperty(CALLE_ENVIO_CLIENTE, calleEnvioCliente);
	}

	public List<Clientes> findByCiudadEnvioCliente(Object ciudadEnvioCliente) {
		return findByProperty(CIUDAD_ENVIO_CLIENTE, ciudadEnvioCliente);
	}

	public List<Clientes> findByCpEnvioCliente(Object cpEnvioCliente) {
		return findByProperty(CP_ENVIO_CLIENTE, cpEnvioCliente);
	}

	public List<Clientes> findByProvinciaEnvioCliente(
			Object provinciaEnvioCliente) {
		return findByProperty(PROVINCIA_ENVIO_CLIENTE, provinciaEnvioCliente);
	}

	public List<Clientes> findByTelefonoEnvioCliente(Object telefonoEnvioCliente) {
		return findByProperty(TELEFONO_ENVIO_CLIENTE, telefonoEnvioCliente);
	}

	public List<Clientes> findByFaxEnvioCliente(Object faxEnvioCliente) {
		return findByProperty(FAX_ENVIO_CLIENTE, faxEnvioCliente);
	}

	public List<Clientes> findByEmailEnvioCliente(Object emailEnvioCliente) {
		return findByProperty(EMAIL_ENVIO_CLIENTE, emailEnvioCliente);
	}

	public List<Clientes> findByObservacionesCliente(Object observacionesCliente) {
		return findByProperty(OBSERVACIONES_CLIENTE, observacionesCliente);
	}

	public List<Clientes> findByEstadoCliente(Object estadoCliente) {
		return findByProperty(ESTADO_CLIENTE, estadoCliente);
	}

	public List findAll() {
		log.debug("finding all Clientes instances");
		try {
			String queryString = "from Clientes";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Clientes merge(Clientes detachedInstance) {
		log.debug("merging Clientes instance");
		try {
			Clientes result = (Clientes) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Clientes instance) {
		log.debug("attaching dirty Clientes instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Clientes instance) {
		log.debug("attaching clean Clientes instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ClientesDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ClientesDAO) ctx.getBean("ClientesDAO");
	}
}