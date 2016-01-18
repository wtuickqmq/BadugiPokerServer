package com.badugi.game.logic.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.configuration.CompositeConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;

public class LogicPropertyUtil implements InitializingBean, FactoryBean<Properties> {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogicPropertyUtil.class);
	private static boolean localOverride = false;

	private static Properties props = new Properties();
	private static CompositeConfiguration compositeConfiguration;

	public static Integer getInteger(String key, Integer defaultValue) {
		try {
			if (localOverride && props.containsKey(key))
				return Integer.parseInt(props.get(key).toString());
			return compositeConfiguration.getInteger(key, defaultValue);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static Integer getInteger(String key) {
		try {
			if (localOverride && props.containsKey(key))
				return Integer.parseInt(props.get(key).toString());
			return compositeConfiguration.getInteger(key, null);
		} catch (Exception e) {
			return null;
		}
	}

	public static Long getLong(String key, Long defaultValue) {
		try {
			if (localOverride && props.containsKey(key))
				return Long.parseLong(props.get(key).toString());
			return compositeConfiguration.getLong(key, defaultValue);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static Long getLong(String key) {
		try {
			if (localOverride && props.containsKey(key))
				return Long.parseLong(props.get(key).toString());
			return compositeConfiguration.getLong(key);
		} catch (Exception e) {
			return null;
		}
	}

	public static Double getDouble(String key) {
		try {
			if (localOverride && props.containsKey(key))
				return Double.parseDouble(props.get(key).toString());
			return compositeConfiguration.getDouble(key);
		} catch (Exception e) {
			return null;
		}
	}

	public static Float getFloat(String key) {
		try {
			if (localOverride && props.containsKey(key))
				return Float.parseFloat(props.get(key).toString());
			return compositeConfiguration.getFloat(key);
		} catch (Exception e) {
			return null;
		}
	}

	public static void removeKey(String key) {
		try {
			if (localOverride && props.containsKey(key)) {
				props.remove(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Boolean getBoolean(String key, Boolean defaultValue) {
		try {
			if (localOverride && props.containsKey(key))
				return Boolean.parseBoolean(props.get(key).toString());
			return compositeConfiguration.getBoolean(key, defaultValue);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static String getString(String key) throws NullPointerException, NoSuchElementException {
		if (localOverride && props.containsKey(key))
			return props.get(key).toString();
		if (compositeConfiguration == null)
			throw new NullPointerException("compositeConfiguration is null ! key = " + key);
		return compositeConfiguration.getString(key);
	}

	public static String getString(String key, String defaultValue) {
		try {
			if (localOverride && props.containsKey(key))
				return props.get(key).toString();
			return compositeConfiguration.getString(key, defaultValue);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static void put(Object key, Object value) {
		props.put(key, value);
	}

	public static void putAll(Map<?, ?> map) {
		props.putAll(map);
	}

	/**
	 * 
	 * @param datasource
	 * @param query
	 */
	public LogicPropertyUtil() {
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		String configLocal = System.getProperty("config.local.table");
		String configMysql = System.getProperty("config.mysql.table");
		if (null != configLocal) {
			initPropertiesFromLocal(configLocal);
		} else if (null != configMysql) {

		}
		;
		initPropertiesFromSystem();
		;
	}

	@Override
	public Properties getObject() throws Exception {
		return props;
	}

	@Override
	public Class<Properties> getObjectType() {
		return Properties.class;
	}

	/**
	 * 读入系统属性
	 * 
	 * @throws IOException
	 */
	private void initPropertiesFromSystem() throws IOException {
		Set<Object> keys = System.getProperties().keySet();
		for (Object key : keys) {
			Object value = System.getProperties().get(key);
			props.setProperty(key.toString(), value.toString());
		}
	}

	/**
	 * 从本地文件读取配置
	 * 
	 * @param configTable
	 * @throws IOException
	 */
	private void initPropertiesFromLocal(String configTable) throws IOException {
		File file = new File(configTable);
		if (file.exists() && file.isFile()) {
			LOGGER.info("load property from path={}", configTable);
			Properties properties = new Properties();
			FileInputStream fis = new FileInputStream(file);
			properties.load(new InputStreamReader(fis, "UTF-8"));
			Set<Object> keys = properties.keySet();
			for (Object key : keys) {
				Object value = properties.get(key);
				LOGGER.debug("load property. Key={} ,Value={}", key, value);
				String _key = key.toString();
				String _value = value.toString();
				props.setProperty(_key, _value);
				System.setProperty(_key, _value);
			}
			LOGGER.info("load property complete ！ size = {}", props.size());
		} else {
			LOGGER.warn("configTable filePath={} not exists or a file", configTable);
		}
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Required
	public void setCompositeConfiguration(CompositeConfiguration compositeConfiguration) {
		synchronized (LogicPropertyUtil.class) {
			LogicPropertyUtil.compositeConfiguration = compositeConfiguration;
		}
	}

	/**
	 * @param localOverride
	 *            the localOverride to set
	 */
	public void setLocalOverride(boolean localOverride) {
		synchronized (LogicPropertyUtil.class) {
			LogicPropertyUtil.localOverride = localOverride;
		}
	}

}
