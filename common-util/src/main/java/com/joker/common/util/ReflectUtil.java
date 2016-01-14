package com.joker.common.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 反射工具类
 */
public class ReflectUtil {

    /**
     * Attempts to create a class from a String.
     * @param className the name of the class to create.
     * @return the class.  CANNOT be NULL.
     * @throws IllegalArgumentException if the className does not exist.
     */
    @SuppressWarnings("unchecked")
	public static <T> Class<T> loadClass(final String className) throws IllegalArgumentException {
        try {
            return (Class<T>) Class.forName(className);
        } catch (final ClassNotFoundException e) {
            throw new IllegalArgumentException(className + " class not found.");
        }
    }


    /**
     * Creates a new instance of the given class by passing the given arguments
     * to the constructor.
     * @param className Name of class to be created.
     * @param args Constructor arguments.
     * @return New instance of given class.
     */
    public static <T> T newInstance(final String className, final Object ... args) {
        return newInstance(ReflectUtil.<T>loadClass(className), args);
    }
    
    /**
     * Creates a new instance of the given class by passing the given arguments
     * to the constructor.
     * @param clazz Class of instance to be created.
     * @param args Constructor arguments.
     * @return New instance of given class.
     */
    public static <T> T newInstance(final Class<T> clazz, final Object ... args) {
        final Class<?>[] argClasses = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            argClasses[i] = args[i].getClass();
        }
        try {
            return clazz.getConstructor(argClasses).newInstance(args);
        } catch (final Exception e) {
            throw new IllegalArgumentException("Error creating new instance of " + clazz, e);
        }
    }

    /**
     * Gets the property descriptor for the named property on the given class.
     * @param clazz Class to which property belongs.
     * @param propertyName Name of property.
     * @return Property descriptor for given property or null if no property with given
     * name exists in given class.
     */
    public static PropertyDescriptor getPropertyDescriptor(final Class<?> clazz, final String propertyName) {
        try {
            return getPropertyDescriptor(Introspector.getBeanInfo(clazz), propertyName);
        } catch (final IntrospectionException e) {
            throw new RuntimeException("Failed getting bean info for " + clazz, e);
        }
    }

    /**
     * Gets the property descriptor for the named property from the bean info describing
     * a particular class to which property belongs.
     * @param info Bean info describing class to which property belongs.
     * @param propertyName Name of property.
     * @return Property descriptor for given property or null if no property with given
     * name exists.
     */
    public static PropertyDescriptor getPropertyDescriptor(final BeanInfo info, final String propertyName) {
        for (int i = 0; i < info.getPropertyDescriptors().length; i++) {
            final PropertyDescriptor pd = info.getPropertyDescriptors()[i];
            if (pd.getName().equals(propertyName)) {
                return pd;
            }
        }
        return null;
    }

    /**
     * Sets the given property on the target JavaBean using bean instrospection.
     * @param propertyName Property to set.
     * @param value Property value to set.
     * @param target Target java bean on which to set property.
     */
    public static void setProperty(final String propertyName, final Object value, final Object target) {
        try {
            setProperty(propertyName, value, target, Introspector.getBeanInfo(target.getClass()));
        } catch (final IntrospectionException e) {
            throw new RuntimeException("Failed getting bean info on target JavaBean " + target, e);
        }
    }

    /**
     * Sets the given property on the target JavaBean using bean instrospection.
     * @param propertyName Property to set.
     * @param value Property value to set.
     * @param target Target JavaBean on which to set property.
     * @param info BeanInfo describing the target JavaBean.
     */
    public static void setProperty(final String propertyName, final Object value, final Object target, final BeanInfo info) {
        try {
            final PropertyDescriptor pd = getPropertyDescriptor(info, propertyName);
            pd.getWriteMethod().invoke(target, value);
        } catch (final InvocationTargetException e) {
            throw new RuntimeException("Error setting property " + propertyName, e.getCause());
        } catch (final Exception e) {
            throw new RuntimeException("Error setting property " + propertyName, e);
        }
    }
    
    /**
     * 
     * @param target
     * @param fname
     * @param ftype
     * @param fvalue
     */
	public static void setFieldValue(Object target, String fname, Class<String> ftype,
			Object fvalue) { // 设置字段值 如：username 字段,setUsername(String username)
		if (target == null || fname == null || "".equals(fname) || (fvalue != null &&
				!ftype.isAssignableFrom(fvalue.getClass()))) {// 如果类型不匹配，直接退出
			return;
		}
		Class<? extends Object> clazz = target.getClass();
		try { // 先通过setXxx()方法设置类属性值
			String methodname = "set" + Character.toUpperCase(fname.charAt(0))
					+ fname.substring(1);
			System.out.println(methodname);
			Method method = clazz.getDeclaredMethod(methodname, ftype); // 获取定义的方法
			if (!Modifier.isPublic(method.getModifiers())) { // 设置非共有方法权限
				method.setAccessible(true);
			}
			method.invoke(target, fvalue); // 执行方法回调
		} catch (Exception me) {// 如果set方法不存在，则直接设置类属性值
			try {
				Field field = clazz.getDeclaredField(fname); // 获取定义的类属性
				if (!Modifier.isPublic(field.getModifiers())) { // 设置非共有类属性权限
					field.setAccessible(true);
				}
				field.set(target, fvalue); // 设置类属性值

			} catch (Exception fe) {
				fe.printStackTrace();
			}
		}
	}

	/**
	 * 获取字段值, 如：username字段, getUsername()
	 * @param target
	 * @param fname
	 * @param ftype
	 * @return
	 */
	public static Object getFieldValue(Object target, String fname, Class<String> ftype) {
		if (target == null || fname == null || "".equals(fname)) {
			return null;
		}
		Class<? extends Object> clazz = target.getClass();
		try { // 先通过getXxx()方法获取类属性值
			String methodname = "get" + Character.toUpperCase(fname.charAt(0))
					+ fname.substring(1);
			System.out.println(methodname);
			Method method = clazz.getDeclaredMethod(methodname); // 获取定义的方法
			if (!Modifier.isPublic(method.getModifiers())) { // 设置非共有方法权限
				method.setAccessible(true);
			}
			return method.invoke(target); // 方法回调，返回值
		} catch (Exception me) {// 如果get方法不存在，则直接获取类属性值
			System.out.println(me.getMessage());
			try {
				Field field = clazz.getDeclaredField(fname); // 获取定义的类属性
				if (!Modifier.isPublic(field.getModifiers())) { // 设置非共有类属性权限
					field.setAccessible(true);
				}
				return field.get(target);// 返回类属性值
			} catch (Exception fe) {
				fe.printStackTrace();
			}
		}
		return null;
	}
}