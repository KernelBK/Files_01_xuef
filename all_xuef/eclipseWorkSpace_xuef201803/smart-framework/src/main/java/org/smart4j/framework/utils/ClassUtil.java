package org.smart4j.framework.utils;

import java.io.File;
import java.io.FileFilter;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 类操作 工具
 * @author moveb
 *
 */
public class ClassUtil {

	// 获取类加载器
	public static ClassLoader getClassLoader(){
		// 获取当前线程中的 ClassLoader ???
		return Thread.currentThread().getContextClassLoader();
	}
	/**
	 * 根据类名 加载类
	 * @param className
	 * @param isInitialized
	 * @return
	 */
	public static Class<?> loadClass(String className, 
			boolean isInitialized){
		Class<?> clazz = null;
		try{
			System.out.println("className: " + className);
			clazz = Class.forName(className, isInitialized, getClassLoader());
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return clazz;
	}
	/**
	 * 获取指定包下的所有类
	 * @param packageName
	 * @return
	 */
	public static Set<Class<?>> getClassSet(String packageName){
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		try{
			Enumeration<URL> urls = getClassLoader().
					getResources(packageName.replace(".", "/")); // 根据包名将其转为文件路径
			while(urls.hasMoreElements()){
				URL url = urls.nextElement();
				if(url != null){
					String protocol = url.getProtocol();
					if(protocol.equals("file")){
						String packagePath = url.getPath().
								replaceAll("%20", " ");
						addClass(classSet, packagePath, packageName);
					}else if(protocol.equals("jar")){
						JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
						if(jarURLConnection != null){
							JarFile jarFile = jarURLConnection.getJarFile();
							if(jarFile != null){
								Enumeration<JarEntry> jarEntries = jarFile.entries();
								while(jarEntries.hasMoreElements()){
									JarEntry jarEntry = jarEntries.nextElement();
									String jarEntryName = jarEntry.getName();
									if(jarEntryName.endsWith(".class")){
										String className = jarEntryName.substring(0, 
												jarEntryName.lastIndexOf(".")).replaceAll("/", ".");
										doAddClass(classSet, className);
									}
								}
							}
						}
					}
				}
			}
		
		} catch(Exception e){ e.printStackTrace(); }
		return classSet;
	}
	private static void doAddClass(Set<Class<?>> classSet, String className) {
		Class<?> cls = loadClass(className, false);
		classSet.add(cls);
	}
	private static void addClass(Set<Class<?>> classSet, String packagePath,
			String packageName) {
		File[] files = new File(packagePath).listFiles(new FileFilter(){
			@Override
			public boolean accept(File file) {
				return (file.isFile() && file.getName().
						endsWith(".class")) || file.isDirectory();
			}
		});
		for(File file:files){
			String fileName = file.getName();
			if(file.isFile()){
				String className = fileName.substring(0, fileName.lastIndexOf("."));
				if(!"".equals(packageName)){
					className = packageName + "." + className;
				}
				doAddClass(classSet, className);
			} else{
				String subPackagePath = fileName;
				if(!"".equals(packagePath)){
					subPackagePath = packagePath + "/"+subPackagePath;
				}
				String subPackageName = fileName;
				if(!"".equals(packageName)){
					subPackageName = packageName+"."+subPackageName;
				}
				addClass(classSet, subPackagePath, subPackageName);
			}
		}
	}
}
