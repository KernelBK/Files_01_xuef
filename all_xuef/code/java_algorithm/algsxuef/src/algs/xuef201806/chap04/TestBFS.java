package algs.xuef201806.chap04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import algs.base.In;
import algs.base.Point2D;
import algs.base.StdDraw;
import algs.base.StdRandom;

public class TestBFS {
	public static void main(String[] args) {
		In in = new In("mediumG.txt");
		UndirectGraph g = new UndirectGraph(in);
		int firstN = 0; // ԭ��Ľڵ��
		
		Point2D[] points = new Point2D[250];
		
		// ����firstN��ÿ���ڵ�Ĳ���
		DepthFirstPaths dfp = new DepthFirstPaths(g, firstN);
		
		List<Degree> degrees = new ArrayList();
		for(int i=0; i<250; i++){
			if(dfp.hasPathTo(i)){
				degrees.add(new Degree(i, dfp.stepsTo(i)));
				points[i] = randomP();
			}
		}
		Collections.sort(degrees);
		
		Collections.sort(Arrays.asList(points), new Point2D(0,0).distanceToOrder());
		Point2D[] newPoints = new Point2D[250];
		/**
		 * paths Ϊ1���кܶ�
		 */
		for(int i=0; i<250; i++){
			Degree d = degrees.get(i);
			newPoints[d.getIdx()] = points[i];
		}
		
		
		in = new In("connectG.txt");
		int V = in.readInt(); // �ڵ�����
		int E = in.readInt(); // ������
		setXY();
		
		// ����ͼ(������ݽڵ�Ķ��������������Դ���λ��)
		for(int i=0; i<E; i++){
			int v = in.readInt();
			int w = in.readInt();
			newPoints[v].drawTo(points[w]);
		}
		
		BreadthFirstPaths bfp = new BreadthFirstPaths(g, firstN, newPoints);
	}
	
	public static Point2D randomP(){
        return new Point2D(StdRandom.uniform(0, 100.0), StdRandom.uniform(0, 100.0));
	}
	// ��ʼ������
	public static void setXY(){
		int N = 100;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N);
		StdDraw.setPenRadius(0.0005);//.0002
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
	}
}
