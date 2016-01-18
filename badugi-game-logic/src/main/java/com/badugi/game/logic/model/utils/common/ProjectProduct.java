package com.badugi.game.logic.model.utils.common;

import java.io.File;
import java.net.URL;

 
/*******************************************************************************
 * @copyright：Copyright 2008 highesthelp.com All Rights Reserved
 * @author: jackie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">jackie</a>
 * @createTime: Apr 27, 2008
 * @description：
 */
public class ProjectProduct
{

 
	/***************************************************************************
	 * 获取系统根路径 WebRoot 文件夹的绝对路径
	 * 
	 * @return
	 */
	public static String getRootPath()
	{
		try
		{
			URL url = ClassLoaderUtils.getExtendResource("../../../");
			String path = url.toString();
			String systemType = System.getProperty("os.name");
			if (systemType.toLowerCase().indexOf("nt") > -1
					|| systemType.toLowerCase().indexOf("window") > -1)
			{
				if (path.startsWith("file:"))
				{
					return EscapeUtils.unescape(path.replace("file:/", ""));
				}
			}
			else
			{
				if (path.startsWith("file:"))
				{
					return EscapeUtils.unescape(path.replace("file:", ""));
				}
			}
			return path;
		}
		catch (Exception e)
		{
			System.out.println("获取路径时出错。" + e);
			return null;
		}
	}


	public static String getFilePathFromRoot(String dir){
		File file = new File("./");
		return file.getAbsolutePath() + "";
	}
	
	
	
	public static String getFilePathFromRoot(){
		File file = new File(".");
		return file.getAbsolutePath();
	}
	
	
 
	public static void main(String[] args)
	{
		System.out.println(getRootPath());
		// System.out.println(getUpRootPath("../src/com/highesthelp/project/service"));

	}

}
