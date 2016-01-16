package com.inkstd.badugi.game.proxy.utils;

import io.nadron.context.AppContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;

public class ProxyBeanUtil {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ProxyBeanUtil.class);
	
	public static <T> T get(Class<T> classes) {
		return AppContext.getBean(classes);
	}

	public static Object get(String name) {
		return AppContext.getBean(name);
	}
	
	public static String executeShell(String shellString) {
		Process process = null;
		List<String> processList = new ArrayList<String>();
		BufferedReader input = null;
		try {
			process = Runtime.getRuntime().exec(shellString);
			input = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
			String line = "";
			while ((line = input.readLine()) != null) {
				processList.add(line);
			}

		} catch (IOException e) {
			processList.add("执行异常:" + e);
			e.printStackTrace();
			LOGGER.error("exception", e);
		} finally {
			if (null != input) {
				try {
					input.close();
				} catch (Exception e2) {
				}
			}
			if(null!=process){
				try {
					process.destroy();
				} catch (Exception e2) {
					
				}
				
			}
		}
		return Joiner.on("").join(processList);

	}

	public static void callShell(String shellString) {
		Process process = null;
		try {
			process  = Runtime.getRuntime().exec(shellString);
			int exitValue = process.waitFor();
			if (0 != exitValue) {
				LOGGER.error("call shell failed. error code is :" + exitValue);
			}
		} catch (Throwable e) {
			LOGGER.error("call shell failed. " + e);
		}finally{
			if(null!=process){
				try {
					process.destroy();
				} catch (Exception e2) {
				}
				
			}
		}
	}

}
