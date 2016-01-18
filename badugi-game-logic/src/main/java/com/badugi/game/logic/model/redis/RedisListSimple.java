package com.badugi.game.logic.model.redis;

import io.nadron.client.util.ObjectBeanUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.util.AppContext;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.joker.game.db.redis.RedisLogin;


public class RedisListSimple<V> extends ArrayList<V> {

	static final Logger LOGGER = LoggerFactory.getLogger(RedisListSimple.class);
	
	String key;
	
	Class<V> classV;

	private static final long serialVersionUID = 1L;

	public RedisListSimple(String key, Class<V> v) {
		this.key = key;
		this.classV = v;
	}

	public RedisListSimple(String key, Collection<? extends V> c) {
		super(c);
		this.key = key;
	}

	@Override
	public void clear() {
		AppContext.getBean(RedisLogin.class).del(key);
	}

	public List<V> getAll() {
		try {
			List<String> tmplist = AppContext.getBean(RedisLogin.class).lrange(key, 0, -1);
			return Lists.transform(tmplist, new Function<String, V>() {
				@Override
				public V apply(String input) {
					try {
						return ObjectBeanUtil.JACKSON.readValue(input, classV);
					} catch (IOException e) {
						LOGGER.error("", e);
					}
					return null;
				}
			});
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@Override
	public boolean add(V v) {
		try {
			AppContext.getBean(RedisLogin.class).rpush(key, ObjectBeanUtil.JACKSON.writeValueAsString(v));
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return super.add(v);
	}

	@Override
	public boolean remove(Object o) {
		try {
			AppContext.getBean(RedisLogin.class).lrem(key, 1, ObjectBeanUtil.JACKSON.writeValueAsString(o));
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return super.remove(o);
	}

	@Override
	public V remove(int index) {
		if (this.size() > index) {

			V v = this.get(index);
			this.remove(v);
			return v;
		}
		return null;
	}

	@Override
	public V set(int index, V element) {
		if (this.size() > index) {
			try {
				AppContext.getBean(RedisLogin.class).lset(key, index, ObjectBeanUtil.JACKSON.writeValueAsString(element));
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}

	@Override
	public int size() {
		return AppContext.getBean(RedisLogin.class).llen(key).intValue();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
