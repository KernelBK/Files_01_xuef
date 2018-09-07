package algs.xuef201806.chap01.exercise;

import java.io.File;
import java.io.UnsupportedEncodingException;

import algs.base.StdOut;
import algs.xuef201806.chap01.Queue;

/**
 * �ļ��б�
 * @author moveb
 *
 */
public class Ex_1_3_43_list_files {
	public static void main(String[] args) {
		String folderPath = "C:\\code_dxf\\xuefgit\\Files_01_xuef\\all_xuef\\code\\design_of_computer_program";
		Queue<String> q = new Queue<String>();
		listFiles("  ", folderPath, q);
		for(String fname:q){
			System.out.println(fname);
		}
	}
	
	public static void listFiles(String tab, String folder, Queue q) {
		/**
		 * "file.encoding"Ӱ������ļ����ݵı��룬�������ļ����ı��룬Ӱ���ļ���������ǡ�sun.jnu.encoding��������ԣ�
		 * ��getProperty("sun.jnu.encoding")���Ի�ȡ�ļ������롣�������"file.encoding"�õ�ʱ��Ҳ���׳����⣬��Ϊ
		 * ���Ǹ����л������������й�ϵ��
		 */
		//String fileCode=(String)System.getProperties().get("sun.jnu.encoding");
		//fileCode = "utf-8";
		tab = tab + "  ";
		File file = new File(folder);
		File[] files = file.listFiles();
		for (File f:files){
			//String fname = new String(f.getName().getBytes(), fileCode);
			//System.out.println(f.getName());
			if(f.isFile()){
				q.enqueue(tab + f.getName());
			}else if(f.isDirectory()){
				q.enqueue(tab + f.getName());
				listFiles(tab, f.getAbsolutePath(), q);
			}
		}
	}
}
