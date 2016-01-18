package com.badugi.game.logic.model.redis;

import io.nadron.client.util.ObjectBeanUtil;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.badugi.game.logic.util.AppContext;
import com.google.common.collect.Maps;
import com.joker.game.db.redis.RedisLogin;

public class RedisMapMap<K, V> extends ConcurrentHashMap<String, RedisMapSimple<K, V>> {

	private static final Logger LOGGER = LoggerFactory.getLogger(RedisMapList.class);

	private static final long serialVersionUID = 1L;

	private String redisKey;

	Class<K> classK;
	Class<V> classV;

	public RedisMapMap(String key, Class<K> k, Class<V> v) {
		this.redisKey = key;
		this.classK = k;
		this.classV = v;
	}

	@Override
	public RedisMapSimple<K, V> put(String key, RedisMapSimple<K, V> value) {

		String targetKey = String.format("%s:%s:map", redisKey, key.toString());
		AppContext.getBean(RedisLogin.class).hset(redisKey, String.valueOf(key), targetKey);

		return super.put(key, value);

	}

	// @Override
	// public V get(Object key) {
	// V v = null;
	// if (null != key) {
	// try {
	// String value = AppContext.getBean(RedisLogin.class).hget(redisKey,
	// key.toString());
	// if (null != value) {
	// if (this.v != String.class) {
	// v = ObjectBeanUtil.JACKSON.readValue(value, this.v);
	// } else {
	// v = (V) value;
	// }
	// }
	// } catch (Exception e) {
	// LOGGER.error("", e);
	// }
	//
	// }
	// return v;
	// }

	@Override
	public RedisMapSimple<K, V> get(Object key) {

		String targetKey = String.format("%s:%s:map", redisKey, key.toString());

		Map<String, String> value = AppContext.getBean(RedisLogin.class).hgetAll(targetKey);
		RedisMapSimple<K, V> map = new RedisMapSimple<K, V>(targetKey, this.classK, this.classV);;
		if (null != value) {
//			 map.putAll(value);
			
			Map<K,V> temp = Maps.newHashMap();
			Set<String> keys = value.keySet();
			for(String tempKey:keys){
				String tempValue = value.get(tempKey);
				try {
					map.put(ObjectBeanUtil.JACKSON.readValue(tempKey, this.classK), ObjectBeanUtil.JACKSON.readValue(tempValue, this.classV));
				} catch (Exception e) {
					LOGGER.warn("convert exception: ",e);
					continue;
				}
				
			}
			return map;
		}
		return map;
	}
	
	@Override
	public int size() {
		int size = 0;
		try {
			size = AppContext.getBean(RedisLogin.class).hlen(this.redisKey).intValue();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return size;
	}

	@Override
	public void clear() {
		try {
			Map<String,String> roomsMap = AppContext.getBean(RedisLogin.class).hgetAll(redisKey);
			
			Set<String> roomIdList = roomsMap.keySet();
			
			for(String roomId : roomIdList){
				AppContext.getBean(RedisLogin.class).del(roomsMap.get(roomId));
			}
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

	//
	// @Override
	// public V remove(Object key) {
	// if (null != key) {
	// try {
	// AppContext.getBean(RedisLogin.class).hdel(redisKey, key.toString());
	// } catch (Exception e) {
	// LOGGER.error("", e);
	// }
	//
	// }
	// return null;
	// }

	@Override
	public RedisMapSimple<K, V> remove(Object key) {
		if (null != key) {
			try {
				AppContext.getBean(RedisLogin.class).hdel(redisKey, key.toString());
			} catch (Exception e) {
				LOGGER.error("", e);
			}
		}
		return super.remove(key);
	}

}
