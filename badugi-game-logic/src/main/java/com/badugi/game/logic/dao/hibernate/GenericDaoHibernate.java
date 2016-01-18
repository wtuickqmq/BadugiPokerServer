package com.badugi.game.logic.dao.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.transaction.annotation.Transactional;

import com.badugi.game.logic.dao.GenericDao;

/**
 * This class serves as the Base class for all other DAOs - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * <p/>
 * <p>
 * To register this class in your Spring context file, use the following XML.
 * 
 * <pre>
 *      &lt;bean id="fooDao" class="com.yxpai.user.dao.hibernate.GenericDaoHibernate"&gt;
 *          &lt;constructor-arg value="com.yxpai.user.model.Foo"/&gt;
 *      &lt;/bean&gt;
 * </pre>
 * 
 * @param <T>
 *            a type variable
 * @param <PK>
 *            the primary key for that type
 */
@Transactional(value="logicTransactionManager") 
public class GenericDaoHibernate<T, PK extends Serializable> implements GenericDao<T, PK> {
	/**
	 * Log variable for all child classes. Uses LogFactory.getLog(getClass())
	 * from Commons Logging
	 */
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private Class<T> persistentClass;

	@Resource
	@Autowired  
    @Qualifier("logicSessionFactory")  
	private SessionFactory sessionFactory;

	/**
	 * Constructor that takes in a class to see which type of entity to persist.
	 * Use this constructor when subclassing.
	 * 
	 * @param persistentClass
	 *            the class type you'd like to persist
	 */
	public GenericDaoHibernate(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	/**
	 * Constructor that takes in a class and sessionFactory for easy creation of
	 * DAO.
	 * 
	 * @param persistentClass
	 *            the class type you'd like to persist
	 * @param sessionFactory
	 *            the pre-configured Hibernate SessionFactory
	 */
	public GenericDaoHibernate(final Class<T> persistentClass, SessionFactory sessionFactory) {
		this.persistentClass = persistentClass;
		this.sessionFactory = sessionFactory;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public boolean exists(PK id) {
		Session sess = getSession();
		IdentifierLoadAccess byId = sess.byId(persistentClass);
		T entity = (T) byId.load(id);
		return entity != null;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
		Session sess = getSession();
		Query namedQuery = sess.getNamedQuery(queryName);

		for (String s : queryParams.keySet()) {
			namedQuery.setParameter(s, queryParams.get(s));
		}

		return namedQuery.list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public T get(PK id) {
		Session sess = getSession();
		IdentifierLoadAccess byId = sess.byId(persistentClass);
		T entity = (T) byId.load(id);

		if (entity == null) {
			logger.warn("Uh oh, '" + this.persistentClass + "' object with id '" + id + "' not found...");
			throw new ObjectRetrievalFailureException(this.persistentClass, id);
		}

		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Session sess = getSession();
		return sess.createCriteria(persistentClass).list();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<T> getAllDistinct() {
		Collection<T> result = new LinkedHashSet<T>(getAll());
		return new ArrayList<T>(result);
	}

	public Session getSession() throws HibernateException {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public void remove(PK id) {
		Session sess = getSession();
		IdentifierLoadAccess byId = sess.byId(persistentClass);
		T entity = (T) byId.load(id);
		sess.delete(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove(T object) {
		Session sess = getSession();
		sess.delete(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public T save(T object) {
		Session sess = getSession();
		Object result = sess.merge(object);
		return (T) result;
	}

//	@Autowired
//	@Required
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * {@inheritDoc}
	 */
	public Query queryHQL(String sql) {
		Session session = getSession();
		Query query = session.createQuery(sql);
		return query;
	}

	/**
	 * {@inheritDoc}
	 */
	public Query querySQL(String sql) {
		Session session = getSession();
		Query query = session.createSQLQuery(sql);
		return query;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> querySQLList(String sql) {
		Session session = getSession();
		List<Object[]> query = session.createSQLQuery(sql).list();
		return query;
	}
	
	public int execSQL(String sql) {
		Session session = getSession();
		
		int query = session.createSQLQuery(sql).executeUpdate();
		return query;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> querySQLListWithMap(String sql) {
		Session session = getSession();
		// List<K> query =
		// session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(clazz)).list();
		List<Map<String, Object>> query = session.createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		return query;
	}

	@Override
	public <K> List<K> querySQLListWithClass(String sql, Class<K> clazz, Map<String, org.hibernate.type.Type> mapping) {
		Session session = getSession();
		SQLQuery query = session.createSQLQuery(sql);
		if (null != mapping && !mapping.isEmpty()) {
			Set<String> mappingKeys = mapping.keySet();
			for (String key : mappingKeys) {
				query.addScalar(key, mapping.get(key));
			}
		}
		@SuppressWarnings("unchecked")
		List<K> list = query.setResultTransformer(Transformers.aliasToBean(clazz)).list();
		return list;
	}

	public <K> List<K> querySQLList2(String sql, Class<K> cl) {
		Session session = getSession();
		@SuppressWarnings("unchecked")
		List<K> query = session.createSQLQuery(sql).addEntity(cl).list();
		
		return query;
	}
}
