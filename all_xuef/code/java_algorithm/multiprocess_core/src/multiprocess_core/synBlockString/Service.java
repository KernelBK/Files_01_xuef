package multiprocess_core.synBlockString;

public class Service {
	String uname;
	String pwd;
	
	String anyStr = new String();
	
	public void setUnamePwd(String uname, String pwd){
		try {
			synchronized (anyStr) {
				System.out.println("�߳���Ϊ: " + Thread.currentThread().getName()
						+ "��" + System.currentTimeMillis() + "����ͬ����");
				this.uname = uname;
				Thread.sleep(3000);
				this.pwd = pwd;
				System.out.println("�߳���Ϊ: " + Thread.currentThread().getName()
						+ "��" + System.currentTimeMillis() + "�뿪ͬ����");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
