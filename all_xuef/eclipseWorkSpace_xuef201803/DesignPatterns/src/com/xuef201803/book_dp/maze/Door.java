package com.xuef201803.book_dp.maze;

public class Door extends MapSite {
	/**
	 * �����е�Door ֱ���ŵı���
	 * ����˼��: ʲô��һ����
	 */
	private Room roomA;
	private Room roomB;
	public Door(Room roomA, Room roomB){
		this.roomA = roomA;
		this.roomB = roomB;
	}
	
	public boolean isOpen(){
		return false;
	}
}
