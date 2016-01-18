package com.badugi.game.logic.model.utils.common;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 对象操作工具类 
 */
public class BeanUtils{
	
	private static Logger logger = LoggerFactory.getLogger(BeanUtils.class);
	/**
	 *获取对象全部属性名 不包括静态属性
	 */
	public static List<String> getFieldNames(Object obj){
		
		if(obj == null) return null;
		
		return getFieldNames(obj.getClass());
	}
	
	/**
	 *获取对象全部属性名 不包括静态属性
	 */
	public static List<String> getFieldNames(Class<?> cls){
		
		if(cls == null) return null;
		
		List<String> fieldNames = new ArrayList<String>();
		
		addFieldName(cls, fieldNames);
		
		return fieldNames;
	}

	/**
	 *将对象属性名添加到list中 不包括静态属性
	 */
	private static void addFieldName(Class<?> cls,List<String> fieldNames){
		
		Field[] fields = cls.getDeclaredFields();
		
		if(fields == null || fields.length == 0) return;
		
		if(fieldNames == null) fieldNames = new ArrayList<String>();
		
		try 
		{
			for (int i = 0; i < fields.length; i++) 
			{
				
				Field field = fields[i];
				
				int mod = field.getModifiers();
				
				if(Modifier.isStatic(mod)) continue;
				
				String fieldName = field.getName();
				
				fieldNames.add(fieldName);
			}
			
			cls = cls.getSuperclass();
			
			if(cls != null) addFieldName(cls, fieldNames);
			
		} 
		catch (Exception e) 
		{
			logger.error("getFieldNames | Exception: " + e);
		}
	}

	/**
	 * 将对象属性名，值 转换成   “属性名=属性值属性名=属性值”的格式  跟大厅交互的加密字符串格式
	 * @param obj 被操作对象
	 * @throws Exception 
	 */
	public static String toSource(Object obj){
		
		return toSource(obj,null);
	}
	
	/**
	 * 将对象属性名，值 转换成   “属性名=属性值属性名=属性值”的格式  跟大厅交互的加密字符串格式
	 * @param obj 被操作对象
	 * @param except 不需要连接的属性
	 * @throws Exception 
	 */
	public static String toSource(Object obj,String except){
		
		return appendStr(obj,except,null);
	}
	
	/**
	 * 将对象属性名，值 转换成   “属性名=属性值&属性名=属性值”的格式 (url参数格式)
	 * @param obj 被操作对象
	 * @throws Exception 
	 */
	public static String toParam(Object obj){
		
		return toParam(obj,null);
	}
	
	/**
	 * 将对象属性名，值 转换成   “属性名=属性值&属性名=属性值”的格式  (url参数格式)
	 * @param obj 被操作对象
	 * @param except 不需要连接的属性
	 * @throws Exception 
	 */
	public static String toParam(Object obj,String except){
		
		String param = appendStr(obj,except,"&");
		
		return param.substring(0, param.length() -1);
	}

	/**
	 * 字符串连接 
	 */
	private static String appendStr(Object obj,String except,String substr){
		
		if(obj == null) return null;
		
		StringBuilder sb = new StringBuilder();
		
		appendStr(null,obj,sb,except,substr);
		
		return sb.toString();
	}
	
	/**
	 * 字符串连接 
	 */
	private static void appendStr(Class<?> cls,Object obj,StringBuilder sb,String except,String substr) {
		
		if(cls == null) cls = obj.getClass();
		
		Field[] fields = cls.getDeclaredFields();
		
		try 
		{
			for (Field field : fields) 
			{
				
				int mod = field.getModifiers();
				
				if(Modifier.isStatic(mod)) continue;
				
				String fieldName = field.getName();
				
				if(except != null && except.indexOf("{" + fieldName + "}") >= 0) continue;
				
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), cls);  
				
				Method method = pd.getReadMethod();//获得get方法  
				
				Object o = method.invoke(obj);

				sb.append(fieldName).append("=");
				
				if(o != null) sb.append(o);
				
				if(!StringUtils.isEmpty(substr)) sb.append(substr);
			}
		} 
		catch (Exception e) 
		{
			logger.error("BeanUtil.appendStr | Exception: " + e.getMessage());
		}
		
		cls = cls.getSuperclass();
		
		if(cls != null) appendStr(cls, obj, sb,except,substr);
	}
	
	/**
	 * 将对象转成map 
	 */
	public static Map<String,Object> toMap(Object obj) throws Exception{
		
		return toMap(obj, null);
	}
	
	/**
	 * 将对象转成map 
	 * @param obj 对象
	 * @param def 属性值为null时用默认值代替
	 */
	public static Map<String,Object> toMap(Object obj, Object def) throws Exception{
		
		return toMap(obj, null, def);
	}
	
	/**
	 * 将对象转成map 
	 * @param excepts 不需要转的参数
	 */
	public static Map<String, Object> toMap(Object obj ,List<String> excepts, Object def) throws Exception{
		
		if(obj == null) return null;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		toMap(obj.getClass(), obj, map, excepts, def);
		
		return map;
	}
	
	private static void toMap(Class<?> cls, Object obj, Map<String, Object> map, 
			List<String> excepts, Object def) throws Exception{
		
		Field[] fields = cls.getDeclaredFields();
		
		try 
		{
			for (Field field : fields) 
			{
				int mod = field.getModifiers();
				
				if(Modifier.isStatic(mod)) continue;
				
				String fieldName = field.getName();
				
				if(contain(excepts, fieldName))
				{
					excepts.remove(fieldName);
					continue;
				}	
				
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), cls);
				
				Method method = pd.getReadMethod();//获得get方法  
				
				Object o = method.invoke(obj);
				
				if(o == null) o = def;
				
				map.put(fieldName, o);
			}
		} 
		catch (Exception e) 
		{
			logger.error("BeanUtil.toMap | Exception: " + e.getMessage());
			
			throw new Exception(e);
		}
		
		cls = cls.getSuperclass();
		
		if(cls != null) toMap(cls, obj, map, excepts, def);
	}
	
	/**
	 * 根据属性名 获得属性值 
	 */
	public static Object getProperty(Object obj,String proName){
		
		try {
			Class<?> cls = obj.getClass();
			PropertyDescriptor pd = new PropertyDescriptor(proName, cls);  
			Method method = pd.getReadMethod();//获得get方法  
			
			return method.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("BeanUtil.getProperty | Exception: " + e.getMessage());
			return null;
		}
	}
	
	/**
	 * 设置属性值 
	 */
	public static Object setProperty(Object obj,String proName,Object proValue){
		
		if(proName == null || proName.trim().equals("")) return null;
		
		Class<?> cls = obj.getClass();
		
		try {
			PropertyDescriptor pd = new PropertyDescriptor(proName, cls);  
			Method method = pd.getWriteMethod();//鑾峰緱get鏂规硶  
			
			return method.invoke(obj,proValue);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("BeanUtil.getProValueBy | Exception: " + e);
			return null;
		}
	}
	/**
	 * parent数组中是否包含subStr
	 * @param parent
	 * @param subStr
	 * @return
	 */
	public static boolean contain(String[] parent,String subStr){
		
		if(parent==null||parent.length==0) return false;
		
		if(subStr==null||subStr.equals("")) return false;
		
		for (String str : parent) {
			
			if(subStr.equals(str)) return true;
		}
		
		return false;
	}
	
	/**
	 * parent数组中是否包含subStr
	 * @param parent
	 * @param subStr
	 * @return
	 */
	public static boolean contain(List<String> parent, String subStr){
		
		if(parent == null || parent.size() == 0) return false;
		
		if(subStr == null || subStr.equals("")) return false;
		
		for (String string : parent) {
			
			if(subStr.equals(string)) return true;
		}
		
		return false;
	}
	
	/**
	 * parent数组中是否包含s
	 * @param parent
	 * @param s
	 * @return
	 */
	public static boolean contain(short[] parent,short s){
		
		if(parent==null) return false;
		
		for(int i=0;i<parent.length;i++){
			
			if(parent[i] == s) return true;
		}
		return false;
	}
	
	/**
	 * parent数组中是否包含s
	 * @param parent
	 * @param s
	 * @return
	 */
	public static boolean contain(int[] parent,int s){
		
		if(parent==null) return false;
		
		for(int i=0;i<parent.length;i++){
			
			if(parent[i] == s) return true;
		}
		return false;
	}
	
	
	/**
	 * 首字母小写
	 * @param str
	 * @return
	 */
	public static String lowerFirstChar(String str){	
		
		StringBuffer sb = new StringBuffer(str);
		
		int va = (int)sb.charAt(0);
		
		if(((int)'A' <= va) && (va <= (int)'Z')){
			
			sb.setCharAt(0,(char)(va+32));
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String upperFirstChar(String str){	
		
		StringBuffer sb = new StringBuffer(str);
		
		int va = (int)sb.charAt(0);
		
		if(((int)'a' <= va)&&(va <= (int)'z')){
			
			sb.setCharAt(0,(char)(va-32));
		}
		
		return sb.toString();
	}
}
