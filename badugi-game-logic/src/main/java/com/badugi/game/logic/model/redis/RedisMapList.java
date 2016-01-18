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

public class RedisMapList<V> extends ConcurrentHashMap<String, List<V>> {

	private static final Logger LOGGER = LoggerFactory.getLogger(RedisMapList.class);

	private static final long serialVersionUID = 1L;

	private String redisKey;

	Class<V> classV;

	public RedisMapList(String key, Class<V> v) {
		this.redisKey = key;
		this.classV = v;
	}

	public void add(String key, V value) {
		String targetKey = String.format("%s:%s:list", redisKey, key);

		AppContext.getBean(RedisLogin.class).hset(redisKey, String.valueOf(key), targetKey);

		RedisList<V> list = new RedisList<V>(targetKey);
		try {
			list.add(value);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	@Override
	public List<V> put(String key, List<V> value) {

		String targetKey = String.format("%s:%s:list", redisKey, key);

		AppContext.getBean(RedisLogin.class).hset(redisKey, String.valueOf(key), targetKey);

		RedisList<V> list = new RedisList<V>(targetKey);

		list.clear();

		for (V v : value) {
			list.add(v);
		}
		return super.put(key, value);
	}

	// @Override
	// public RedisList<V> put(String key, RedisList<V> value) {
	// boolean flag = true;
	// // flag &= key instanceof java.io.Serializable;
	// // flag &= value instanceof java.io.Serializable;
	// if (flag) {
	// try {
	// AppContext.getBean(RedisLogin.class).hset(redisKey, String.valueOf(key),
	// ObjectBeanUtil.JACKSON.writeValueAsString(value));
	// } catch (IOException e) {
	// LOGGER.error("", e);
	// }
	// }
	// return super.put(key, value);
	// }

	@Override
	public List<V> get(Object key) {

		if (null == key) {
			//String targetKey = String.format("%s:null:list", redisKey);
			String targetKey = String.format("%s:list", redisKey);
			Collection tmp = AppContext.getBean(RedisLogin.class).lrange(targetKey, 0, 0);
			return new RedisList<V>(targetKey, tmp);
			//return new RedisList<V>(targetKey);
		}
		List<V> v = null;
		if (null != key) {
			try {
				String targetKey = AppContext.getBean(RedisLogin.class).hget(redisKey, key.toString());
				if (null != targetKey) {
					List<String> list = AppContext.getBean(RedisLogin.class).lrange(targetKey, 0, -1);

					v = Lists.transform(list, new Function<String, V>() {

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

				} else {
					v = Lists.newArrayList();
				}
			} catch (Exception e) {
				LOGGER.error("", e);
				v = Lists.newArrayList();
			}

		}

		String targetKey = String.format("%s:%s:list", redisKey, key.toString());
		return new RedisList<V>(targetKey, v);
	}

	@Override
	public void clear() {
		try {
			Map<String, String> keyMap = AppContext.getBean(RedisLogin.class).hgetAll(redisKey);
			List<String> keys = Lists.newArrayList(keyMap.keySet());
			int keySize = keys.size();
			String[] targetList = new String[keySize];
			for (int i = 0; i < keySize; i++) {
				String hashKey = keys.get(i);
				String targetKey = String.format("%s:%s:list", redisKey, hashKey);
				targetList[i] = targetKey;
			}
			AppContext.getBean(RedisLogin.class).del(this.redisKey);
			AppContext.getBean(RedisLogin.class).del(targetList);
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
	public RedisList<V> remove(Object key) {
		if (null != key) {
			try {
				String targetKey = String.format("%s:%s:list", redisKey, key.toString());

				AppContext.getBean(RedisLogin.class).hdel(redisKey, key.toString());

				AppContext.getBean(RedisLogin.class).del(targetKey);

			} catch (Exception e) {
				LOGGER.error("", e);
			}

		}
		return null;
	}

	public static class RedisList<V> extends ArrayList<V> {

		private String key;

		private static final long serialVersionUID = 1L;

		public RedisList(String key) {
			this.key = key;
		}

		public RedisList(String key, Collection<? extends V> c) {
			super(c);
			this.key = key;
		}

		@Override
		public void clear() {
			AppContext.getBean(RedisLogin.class).del(key);
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

}
