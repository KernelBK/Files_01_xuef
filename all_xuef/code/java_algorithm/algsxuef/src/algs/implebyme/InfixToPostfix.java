package algs.implebyme;

import algs.base.StdIn;
import algs.base.StdOut;
//��Ϊ���ʽ������ṹ����ÿ�����㶼�������ţ����Գ����߼�����ô��
public class InfixToPostfix {
	public static void main(String[] args) {
		Statck_byLinkedList<String> stack = new Statck_byLinkedList<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if      (s.equals("+")) stack.push(s);
            else if (s.equals("*")) stack.push(s);
            else if (s.equals(")")) StdOut.print(stack.pop() + " ");
            else if (s.equals("(")) StdOut.print("");
            else                    StdOut.print(s + " ");
        }
        StdOut.println();
    }
}
