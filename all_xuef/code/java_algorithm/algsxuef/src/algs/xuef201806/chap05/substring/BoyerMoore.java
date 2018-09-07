package algs.xuef201806.chap05.substring;

public class BoyerMoore {
	/**
	 * ���ַ���pat�е�����(ģʽ����ҵ���֮ƥ����ַ�������)
	 * �� pat = NEEDLE; ��ôright[E]����5
	 */
	private int[] right;
	private String pat;
	BoyerMoore(String pat){ 
		// Compute skip table.
		this.pat = pat;
		int M = pat.length();
		int R = 256;
		right = new int[R];
		// ��ʼ�� right ����
		for (int c = 0; c < R; c++)
			right[c] = -1; // -1 for chars not in pattern
		for (int j = 0; j < M; j++) // rightmost position for
			right[pat.charAt(j)] = j; // chars in pattern
	}
	/**
	 * �㷨�Ļ�����ܻ��Ǳ������ҵĿ��
	 * ֻ����������������Ծ
	 * @param txt
	 * @return
	 */
	public int search(String txt){
		// Search for pattern in txt.
		int N = txt.length();
		int M = pat.length();
		/**
		 * i j 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
			   F I N D I N A H A Y  S  T  A  C  K  N  E  E  D  L  E  I  N  A
		   0 5 N E E D L E
		   5 5           N E E D L  E
		   11 4                        N  E  E  D  L  E
		   15 0                                    N  E  E  D  L  E
		 */
		int skip;
		for (int i = 0; i <= N-M; i += skip){ 
			// Does the pattern match the text at position i ?
			skip = 0;
			for (int j = M-1; j >= 0; j--)
				if (pat.charAt(j) != txt.charAt(i+j)){
					/**
					 * txt.charAt(i+j)Ϊ��ƥ����ַ�;
					 * 1. ������ַ�������pat��,����j������,��ô skip = j - right[txt.charAt(i+j)];
					 * 2. ������ַ�����pat��, ��ô skip = j + 1; Ҳ���� skip = j - right[txt.charAt(i+j)];
					 * 3. ������ַ�������pat��,ȴ��j������,��ô skipҪ����Ϊ1;
					 * ����������������������
					 */
					skip = j - right[txt.charAt(i+j)]; // ���������1,2
					if (skip < 1) skip = 1; // ���������3
						break;
				}
			if (skip == 0) return i; // found.
		}
		return N; // not found.
	}
	public static void main(String[] args){
		// See page 769.
	}
}
