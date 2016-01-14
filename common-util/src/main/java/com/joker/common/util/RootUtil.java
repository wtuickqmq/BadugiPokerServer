package com.joker.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RootUtil {

	public static String getProcessID() {
		String processName = getProcessName();
		String processID = processName.substring(0, processName.indexOf('@'));
		return processID;
	}

	public static String getProcessName() {
		String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
		return processName;
	}

	/**
	 * @author coldanimal; ProcessHandler windowns version.
	 */
	public static boolean findRunningProcess(String processName) {
		String platform = System.getProperty("os.name");
		if (platform.contains("Windows")) {
			return findRunningWindowsProcess(processName);
		} else if (platform.contains("Linux")) {
			return findRunningLinuxProcess(processName);
		} else {
			throw new RuntimeException("Unknown platform " + platform);
		}
	}

	private static boolean findRunningLinuxProcess(String processName) {
		return false;
	}

	// 获取所有进程列表
	private static boolean findRunningWindowsProcess(String processName) {
		BufferedReader bufferedReader = null;
		Process proc = null;
		try {
			proc = Runtime.getRuntime().exec("tasklist /FI \"IMAGENAME eq " + processName + "\"");
			bufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains(processName)) {
					return true;
				}
			}
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (Exception ex) {
				}
			}
			if (proc != null) {
				try {
					proc.destroy();
				} catch (Exception ex) {
				}
			}
		}
	}

	// 选择操作系统
	public static boolean killRunningProcess(String processName) {
		String platform = System.getProperty("os.name");
		if (platform.contains("Windows")) {
			return killRunningWindowsProcess(processName);
		} else if (platform.contains("Linux")) {
			return false;
		}
		throw new RuntimeException("Unkown platform " + platform);
	}

	// 终止进程
	private static boolean killRunningWindowsProcess(String processName) {
		try {
			Runtime.getRuntime().exec("taskkill /IM " + processName);
			System.out.println("kill process successful");
			System.out.println("Process " + processName + " was killed. Mission completed.");
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("kill process fail");
			System.out.println("Misson failed.");
			return false;
		}
	}

	/**
	 * 杀掉windows进程
	 * 
	 * @param pid
	 */
	public static boolean killWindowsPID(String pid) {
		try {
			String cmd = "taskkill /fi \"PID eq " + pid + "\" /f";
			Runtime.getRuntime().exec(cmd);
			System.out.println("kill process successful");
			System.out.println("ProcessId " + pid + " was killed. Mission completed.");
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("kill process fail");
			System.out.println("Misson failed.");
			return false;
		}
	}

	/**
	 * 杀掉linux进程
	 * 
	 * @param pid
	 */
	public static boolean killLinuxPID(String pid) {
		try {
			String cmd = "kill -9 " + pid;
			Runtime.getRuntime().exec(cmd);
			System.out.println("kill process successful");
			System.out.println("ProcessId " + pid + " was killed. Mission completed.");
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("kill process fail");
			System.out.println("Misson failed.");
			return false;
		}
	}

	public static boolean killPID(String pid) {
		String platform = System.getProperty("os.name");
		if (platform.contains("Windows")) {
			return killWindowsPID(pid);
		} else if (platform.contains("Linux")) {
			return killLinuxPID(pid);
		}
		throw new RuntimeException("Unkown platform " + platform);
	}

}
