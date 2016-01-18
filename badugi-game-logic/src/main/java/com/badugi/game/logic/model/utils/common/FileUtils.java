package com.badugi.game.logic.model.utils.common;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @copyright：JACKSTUDIO 未经许可，不得以任何方式复制或使用本程序任何部分
 * @author: jackie
 * @email: <a href="mailto:jackstudiomaster@gmail.com">jackie</a>
 * @createTime: May 1, 2008
 * @description：
 */
public class FileUtils {
	
	
    private static Log getLogger() {
    	Log log = LogFactory.getLog(FileUtils.class);
        return log;
    }
	
	  public static void touchPath(String path) {
	        try {
	            new File(path).mkdirs();
	        } catch (Exception e) {
	            getLogger().error("mkdirs failure, path = " + path, e);
	        }
	    }

	    public static boolean delete(String path) {
	        try {
	            File file = new File(path);
	            return file.delete();
	        } catch (Exception e) {
	            getLogger().error("delete failure, path = " + path, e);
	            return false;
	        }
	    }

	    public static void deleteAllSubFiles(String dirPath) throws Exception {
	        getLogger().info("delete all sub files, dir = " + dirPath);
	        try {
	            File dir = new File(dirPath);
	            if (dir.isDirectory()) {
	                File[] subFiles = dir.listFiles();
	                for (int i = 0; i < subFiles.length; i++) {
	                    File subFile = subFiles[i];
	                    try {
	                        subFile.delete();
	                    } catch (Exception e) {
	                        getLogger().error("delete sub file failure, file = " + subFile.getName(), e);
	                    }
	                }
	            }
	        } catch (Exception e) {
	            getLogger().error("delete all sub files failure, dir = " + dirPath, e);
	            throw e;
	        }
	    }

	    public static void deleteDirectory(String filePathName) {
	        deleteDirectory(new File(filePathName));
	    }

	    public static void deleteDirectory(File f) {
	        if (f.isDirectory()) {
	            File files[] = f.listFiles();
	            for (int i = 0; i < files.length; i++) {
	                deleteDirectory(files[i]);
	            }
	        }
	        f.delete();
	    }


	    public static boolean copy(InputStream src, final String dstPath) {
	        String srcPath = null;
	        try {
	            File dstFile = new File(dstPath);
	            byte[] buffer = new byte[64 * 1024];
	            int length = 0;
	            OutputStream os = new FileOutputStream(dstFile);

	            try {
	                while ((length = src.read(buffer, 0, buffer.length)) != -1) {
	                    os.write(buffer, 0, length);
	                }
	            } finally {
	                close(os);
	            }
	            return true;
	        } catch (Exception e) {
	            getLogger().error("backup failure, src path = " + srcPath + ", dst path = " + dstPath, e);
	            return false;
	        }
	    }

	    public static void copyFileAsString(String srcFilePathName, String dstFilePathName) throws IOException {
	        File inputFile = new File(srcFilePathName);
	        File outputFile = new File(dstFilePathName);
	        File tempfolder = outputFile.getParentFile();
	        if (!tempfolder.exists()) {
	            tempfolder.mkdirs();
	        }
	        outputFile = new File(tempfolder.getPath(), outputFile.getName());
	        while (!outputFile.exists()) {
	            outputFile.createNewFile();
	        }
	        FileReader in = new FileReader(inputFile);
	        FileWriter out = new FileWriter(outputFile);
	        int c;
	        while ((c = in.read()) != -1) {
	            out.write(c);
	        }
	        in.close();
	        out.close();
	    }

	    public static void copyFileAsStream(String srcFilePathName, String dstFilePathName) throws IOException {
	        FileInputStream fis = new FileInputStream(srcFilePathName);
	        FileOutputStream fos = new FileOutputStream(dstFilePathName);
	        byte[] buf = new byte[1024];
	        int i = 0;
	        while ((i = fis.read(buf)) != -1) {
	            fos.write(buf, 0, i);
	        }
	        fis.close();
	        fos.close();
	    }

	    public static void copyDirectiory(String srcFilePathName, String dstFilePathName) throws IOException {
	        (new File(dstFilePathName)).mkdirs();
	        File[] file = (new File(srcFilePathName)).listFiles();
	        for (int i = 0; i < file.length; i++) {
	            File srcFile = file[i];
	            String dstPathName = dstFilePathName + "/" + srcFile.getName();
	            if (srcFile.isFile()) {
	                FileInputStream input = new FileInputStream(srcFile);
	                FileOutputStream output = new FileOutputStream(dstPathName);
	                byte[] b = new byte[1024 * 5];
	                int len;
	                while ((len = input.read(b)) != -1) {
	                    output.write(b, 0, len);
	                }
	                output.flush();
	                output.close();
	                input.close();
	            }
	            if (srcFile.isDirectory()) {
	                String srcPathName = srcFilePathName + "/" + srcFile.getName();
	                copyDirectiory(srcPathName, dstPathName);
	            }
	        }
	    }

	    public static void rename(String path, String suffix) {
	        try {
	            File file = new File(path);
	            File dstFile = new File(path + "." + suffix);
	            file.renameTo(dstFile);
	        } catch (Exception e) {
	            getLogger().error("rename failure, path = " + path, e);
	        }
	    }

	    public static void close(InputStream stream) {
	        try {
	            stream.close();
	        } catch (Exception e) {
	        }
	    }

	    public static void close(OutputStream stream) {
	        try {
	            stream.flush();
	            stream.close();
	        } catch (Exception e) {
	        }
	    }

	    public static void close(Reader reader) {
	        try {
	            reader.close();
	        } catch (Exception e) {
	        }
	    }

	    public static void close(Writer writer) {
	        try {
	            writer.flush();
	            writer.close();
	        } catch (Exception e) {
	        }
	    }

	 

	    public static boolean isFileExisted(String filePathname) {
	        boolean existed;
	        try {
	            File f = new File(filePathname);
	            existed = f.isFile();
	        } catch (Exception e) {
	            existed = false;
	        }
	        return existed;
	    }

	    public static String removePath(String pathname) {
	        String fname = pathname;
	        int index1 = pathname.lastIndexOf("/");
	        int index2 = pathname.lastIndexOf("\\");
	        int index = Math.max(index1, index2);
	        if (index >= 0) {
	            fname = pathname.substring(index + 1);
	        }
	        return fname;
	    }

	    public static String removeFileName(String pathname) {
	        String fname = pathname;
	        int index1 = pathname.lastIndexOf("/");
	        int index2 = pathname.lastIndexOf("\\");
	        int index = Math.max(index1, index2);
	        if (index >= 0) {
	            fname = pathname.substring(0, index);
	        }
	        return fname;
	    }

	    public static String addTokenToFileName(String pathname, String token) {
	        String pname = "";
	        String fname = pathname;
	        int index = pathname.lastIndexOf(".");
	        if (index >= 0) {
	            fname = pathname.substring(index);
	            pname = pathname.substring(0, index);
	        }
	        return pname + token + fname;
	    }



	    /**
	     * 创建目录函数,如果存在就不创建
	     * 参数：要创建目录的路径
	     * 返回值：如果创建成功则返回0，否则返回-1
	     */
	    public static void createFolderNoExist(String dir) {
	        File file = new File(dir);
	        if (file.isDirectory() && file.exists()) {
	        } else {
	            createFolder(dir);
	        }
	    }

	    /**
	     * 创建目录函数
	     * 参数：要创建目录的路径
	     * 返回值：如果创建成功则返回0，否则返回-1
	     */
	    public static int createFolder(String dir) {
	        File file = new File(dir);
	        if (file.mkdirs()) {
	            return 0;
	        } else {
	            return -1;
	        }
	    }

	    /**
	     * @param filepath
	     * @return String b
	     */
	    public static String file2String(String filepath) throws UnsupportedEncodingException {
	        byte b[] = null;
	        try {
	            FileInputStream fin = new FileInputStream(filepath);
	            int bytelen = fin.available();//判断有效字节数
	            b = new byte[bytelen];
	            fin.read(b);//将文件写入字节数组中
	            fin.close();
	        } catch (Exception e) {
	            getLogger().error("read file eorro, dir = " + filepath, e);
	            //   throw e;
	            return null;
	        }
	        return new String(b,"UTF-8");
	        //return new String(b);
	    }

	    /**
	     * @param srcPathname
	     * @param dstfilepathname
	     */
	    public static void copyFile(String srcPathname, String dstfilepathname) throws IOException {
	        try {
	            String txt = file2String(srcPathname);
	            writeFile(txt,dstfilepathname);
	        } catch (Exception e) {
	            getLogger().error("copyFile eorro!, src path = " + srcPathname + ", dst path = " + dstfilepathname, e);
	        }
	    }

	    public static void writeFile(String str, String dstfilepathname) throws IOException {
	        try {
	            byte[] t = str.getBytes("UTF-8");
	            File ccc = new File(dstfilepathname);
	            createFolder(ccc.getParent());
	            makeFile(dstfilepathname);
	            FileOutputStream fout = new FileOutputStream(dstfilepathname);
	            fout.write(t);
	            fout.flush();
	            fout.close();
	        } catch (Exception e) {
	            getLogger().error("writeFile error!, str = " + str + ", dst path = " + dstfilepathname, e);
	        }
	    }

	    public static boolean makeFile(String filepath) throws IOException {
	        boolean result = false;
	        File file = new File(filepath);
	        result = file.createNewFile();
	        file = null;
	        return result;
	    }
	    
	    public static boolean makeFileByInputStream(String filepath, InputStream inputStream) throws IOException {
	        boolean result = false;
	        try {
		        File file = new File(filepath);
		        OutputStream bos = new FileOutputStream(file);
	            int bytesRead = 0;
	            byte[] buffer = new byte[8192];
	            while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
	                bos.write(buffer, 0, bytesRead);
	            }
	            bos.close();
	            inputStream.close();
	            getLogger().info("upload file " + filepath + " success!!!!!!");
	            result = true;
			} catch (Exception e) {
				throw new IOException(e.getMessage());
			}
	        return result;
	    }
}

