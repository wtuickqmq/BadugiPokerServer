package com.badugi.game.logic.model.redis;

import io.nadron.client.util.ObjectBeanUtil;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.util.AppContext;
import com.joker.game.db.redis.RedisLogin;

public class RedisMapSimple<K, V> extends ConcurrentHashMap<K, V> {

	private static final Logger LOGGER = LoggerFactory.getLogger(RedisMapSimple.class);

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private String redisKey;

	@JsonIgnore
	Class<K> k;

	@JsonIgnore
	Class<V> v;

	public RedisMapSimple(String key, Class<K> k, Class<V> v) {
		this.redisKey = key;
		this.k = k;
		this.v = v;
	}
	public RedisMapSimple(String key, Class<K> k, Class<V> v,Map<? extends K, ? extends V> m) {
		super(m);
		this.redisKey = key;
		this.k = k;
		this.v = v;
	}

	@Override
	public V put(K key, V value) {
		boolean flag = true;
		// flag &= key instanceof java.io.Serializable;
		// flag &= value instanceof java.io.Serializable;
		if (flag) {
			try {
				if (value instanceof String) {
					AppContext.getBean(RedisLogin.class).hset(redisKey, String.valueOf(key), (String) value);
				} else {
					AppContext.getBean(RedisLogin.class).hset(redisKey, String.valueOf(key), ObjectBeanUtil.JACKSON.writeValueAsString(value));
				}
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
		return super.put(key, value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(Object key) {
		V v = null;
		if (null != key) {
			try {
				String value = AppContext.getBean(RedisLogin.class).hget(redisKey, key.toString());
				if (null != value) {
					if (this.v != String.class) {
						v = ObjectBeanUtil.JACKSON.readValue(value, this.v);
					} else {
						v = (V) value;
					}
				}
			} catch (Exception e) {
				LOGGER.error("", e);
			}

		}
		return v;
	}

	@Override
	public void clear() {
		try {
			AppContext.getBean(RedisLogin.class).del(this.redisKey);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	@Override
	public boolean containsKey(Object key) {
		boolean flag = false;
		try {
			flag = AppContext.getBean(RedisLogin.class).hexists(redisKey, key.toString());
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return flag;
	}

	@Override
	public V remove(Object key) {
		if (null != key) {
			try {
				AppContext.getBean(RedisLogin.class).hdel(redisKey, key.toString());
			} catch (Exception e) {
				LOGGER.error("", e);
			}

		}
		return null;
	}

}
