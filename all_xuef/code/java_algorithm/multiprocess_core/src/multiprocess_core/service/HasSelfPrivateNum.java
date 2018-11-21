package multiprocess_core.service;

public class HasSelfPrivateNum {
	private int num = 0;
	/**
	 * synchronized ��õ������Ƕ��������ĸ��߳��Ƚ���ͬ������飬�����߳�
	 * ��ֻ�ܵȴ�����ǰ���Ƕ���̷߳��ʵ���ͬһ������
	 * @param uname
	 */
	synchronized public void addI(String uname){
		
		try{
			if(uname.equals("a")){
				num = 100;
				System.out.println("a set over");
				Thread.sleep(2000);
			}else{
				num  = 200;
				System.out.println("b set over");
			}
			System.out.println(uname + " num = " + num);
		} catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
}
