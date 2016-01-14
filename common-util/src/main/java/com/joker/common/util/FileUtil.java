package com.joker.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * 文件操作类
 */
public final class FileUtil {
	// 验证字符串是否为正确路径名的正则表达式
	private static String matches = "[A-Za-z]:\\\\[^:?\"><*]*";
	// 通过 sPath.matches(matches) 方法的返回值判断是否正确
	// sPath 为路径字符串
	/**
	 * 根据路径删除指定的目录或文件，无论存在与否
	 * 
	 * @param sPath
	 *            要删除的目录或文件
	 * @return 删除成功返回 true，否则返回 false。
	 */
	boolean flag;
	File file;

	public boolean DeleteFolder(String sPath) {
		flag = false;
		file = new File(sPath);
		// 判断目录或文件是否存在
		if (!file.exists()) { // 不存在返回 false
			return flag;
		} else {
			// 判断是否为文件
			if (file.isFile()) { // 为文件时调用删除文件方法
				return deleteFile(sPath);
			} else { // 为目录时调用删除目录方法
				return deleteDirectory(sPath);
			}
		}
	}

	/**
	 * 删除单个文件
	 * 
	 * @param sPath
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public boolean deleteFile(String sPath) {
		flag = false;
		file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists() && file.canExecute()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

	/**
	 * 删除目录（文件夹）以及目录下的文件
	 * 
	 * @param sPath
	 *            被删除目录的文件路径
	 * @return 目录删除成功返回true，否则返回false
	 */
	public boolean deleteDirectory(String sPath) {
		// 如果sPath不以文件分隔符结尾，自动添加文件分隔符
		if (!sPath.endsWith(File.separator)) {
			sPath = sPath + File.separator;
		}
		File dirFile = new File(sPath);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			return false;
		}
		flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			} // 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag)
			return false;
		// 删除当前目录
		if (dirFile.delete()) {
			return true;
		} else {
			return false;
		}
	}

	// 显示目录的方法
	public static List<File> tree(File f, String match, List<File> files) {
		// 判断传入对象是否为一个文件夹对象
		if (!f.isDirectory()) {
			System.out.println("你输入的不是一个文件夹，请检查路径是否有误！！");
		} else {
			File[] t = f.listFiles();
			for (int i = 0; i < t.length; i++) {
				// 判断文件列表中的对象是否为文件夹对象，如果是则执行tree递归，直到把此文件夹中所有文件输出为止
				if (t[i].isDirectory()) {
					// System.out.println(t[i].getName() + "\tttdir");
					tree(t[i], match, files);
				} else {
					String fileName = t[i].getPath();
					if (check(match, fileName)) {
						files.add(new File(fileName));
					}
					// System.out.println(t[i].getName() + "tFile");
				}
			}
		}
		return files;
	}

	public static boolean check(String _regex, CharSequence _input) {
		if ("*".equals(_input)) {
			return true;
		}
		return _input.toString().lastIndexOf(_regex) == -1 ? false : true;
	}

	public void test() {
		FileUtil hfc = new FileUtil();
		String path = "e:\\robot";
		// boolean result = hfc.CreateFolder(path);
		// System.out.println(result);
		// path = "D:\\Abc\\124";
		boolean result = hfc.DeleteFolder(path);
		// result =
		path = "E:\\uonee\\server\\jparse\\src\\other\\Test1.java";
		Pattern p = Pattern.compile(matches);
		Matcher m = p.matcher(path);
		if (m.find()) {
			System.out.println(m.group());
		}
		// hfc.deleteFile("");
		String dir = System.getProperty("user.dir");
		result = hfc.deleteFile(dir + "/src/other/Test1.java");
		System.out.println(result);
	}

	public static String readFile(String FileName) {
		BufferedInputStream bis = null;

		try {
			// 创建BufferedInputStream 对象
			FileInputStream fis = new FileInputStream(FileName);
			bis = new BufferedInputStream(fis);

			// 分配空间
			int iSize = fis.available();
			byte[] buffer = new byte[iSize];

			int iReaded = bis.read(buffer);
			if (iReaded < 0) {
				return "";
			}

			return new String(buffer, 0, iReaded);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return "";
	}

	public static void writeFile(String FileName, String sData) {
		BufferedOutputStream bos = null;

		try {
			// 创建BufferedInputStream 对象
			bos = new BufferedOutputStream(new FileOutputStream(FileName));
			bos.write(sData.getBytes());
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 将文件转换成字节数组
	 */
	public static byte[] getBytesFromFile(File f) {
		if (f == null) {
			return null;
		}
		try {
			InputStream stream = new FileInputStream(f);
			ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
			byte[] b = new byte[1000];
			int n;
			while ((n = stream.read(b)) != -1) {
				out.write(b, 0, n);
			}
			stream.close();
			out.close();
			return out.toByteArray();
		} catch (IOException e) {
		}
		return null;
	}
	
	public static String readSmallFile(String filePath) throws IOException {
		if (filePath == null) {
			return null;
		}
		File smallFile = new File(filePath);
		return readSmallFile(smallFile);
	}

	public static String readSmallFile(File smallFile) throws IOException {
		FileReader reader = new FileReader(smallFile);
		BufferedReader bufferedReader = new BufferedReader(reader);
		StringBuffer buf = new StringBuffer();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			buf.append(line);
		}
		bufferedReader.close();
		reader.close();
		return buf.toString();
	}
}
