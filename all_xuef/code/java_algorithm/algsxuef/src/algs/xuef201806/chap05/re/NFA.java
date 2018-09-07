package algs.xuef201806.chap05.re;

import algs.base.Bag;
import algs.base.Digraph;
import algs.base.DirectedDFS;
import algs.xuef201806.chap01.Stack;

/**
 * ��ȷ������״̬�Զ��� ʵ�ֵ�������ʽ����
 * 
 * һ��������ʽ === ��ʾre����ĸ��(ƥ��ת��) + ����ͼ(epsilonת��)
 * @author moveb
 *
 */
public class NFA {
	private char[] re; // ƥ��ת��
	private Digraph G; // epsilon ת��
	private int M; // ״̬����
	
	// ���ݸ�����������ʽ����NFA
	public NFA(String regexp){
		// ���������ź�"��"�������������ջ
		Stack<Integer> ops = new Stack<Integer>();
		re = regexp.toCharArray();
		M = re.length;
		// ����ͼ, ����ʾepsilonת��; Ϊʲô M+1�����
		G = new Digraph(M+1);
		
		for(int i=0; i<M; i++){
			int lp = i;
			if(re[i] == '(' || re[i] == '|')
				ops.push(i);
			else if(re[i] == ')'){
				int or = ops.pop();
				if(re[or] == '|'){
					lp = ops.pop();
					G.addEdge(lp, or+1);
					G.addEdge(or, i);
				}else{ // ��re[or]=='(' ˵�������հ����ʽ
					lp = or;
				}
			}
			// ���ַ��ıհ� or �հ����ʽ
			if(i < M-1 && re[i+1] == '*'){ // lookahead
				G.addEdge(lp, i+1);
				G.addEdge(i+1, lp);
			}
			if(re[i] == '(' || re[i] == '*' || re[i] == ')')
				G.addEdge(i, i+1);
		}
	}
	/**
	 * ʹ��NFAģ���ģʽƥ��
	 * @param txt
	 * @return
	 */
	public boolean recognizes(String txt){
		// Does the NFA recognize txt?
		Bag<Integer> pc = new Bag<Integer>();
		DirectedDFS dfs = new DirectedDFS(G, 0);
		// ����ʼ״̬(0)��ʼͨ��epsilonת���ܹ����������״̬�ļ���
		for (int v = 0; v < G.V(); v++)
			if (dfs.marked(v)) pc.add(v);
		
		// �����ı���
		for (int i = 0; i < txt.length(); i++){ 
			// Compute possible NFA states for txt[i+1].
			Bag<Integer> match = new Bag<Integer>();
			/**
			 * pc����ǰһ״̬�ļ���(�������ʼ״̬�ļ���);
			 * ��������õ�����: ƥ�� txt.charAt(i)֮���ܵ����״̬�ļ���(match);
			 */
			for (int v : pc)
				if (v < M)
					if (re[v] == txt.charAt(i) || re[v] == '.')
						match.add(v+1);
			
			// ��� pc
			pc = new Bag<Integer>();
			// ƥ�� txt.charAt(i)֮��ͨ��epsilonת���ܹ����������״̬�ļ���
			dfs = new DirectedDFS(G, match);
			for (int v = 0; v < G.V(); v++)
				if (dfs.marked(v)) pc.add(v);
		}
		for (int v : pc) 
			if (v == M) return true;
		
		return false;
	}
}
