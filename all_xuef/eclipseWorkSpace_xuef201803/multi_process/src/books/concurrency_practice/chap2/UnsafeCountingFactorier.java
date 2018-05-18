package books.concurrency_practice.chap2;

import java.math.BigInteger;
/**
 * �ṩ��ʽ�ֽ����� Servlet
 * @author moveb
 */
// Not Thread Safe
public class UnsafeCountingFactorier implements Servlet {
	private long count = 0;
	public long getCount() {
		return count;
	}
	public void service(ServletRequest req, ServletResponse resp){
		// �õ�Ҫ�ֽ����
		BigInteger i = extractFromRequest(req);
		// ��ʽ�ֽ�
		BigInteger[] factors = factor(i);
		++count;
		// ��Ӧ���ͻ���
		encodeIntoResponse(resp, factors);
	}
	private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
		// TODO Auto-generated method stub
		
	}
	private BigInteger[] factor(BigInteger i) {
		// TODO Auto-generated method stub
		return null;
	}
	private BigInteger extractFromRequest(ServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}
}
