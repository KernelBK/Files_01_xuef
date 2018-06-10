package com.xuef201803.book_dp.maze;

import java.util.Map;

public class Room extends MapSite  {
	private Map<Direction, MapSite> sides;
	private int rootNumber; // ��ǰ�����
	
	public Room(){}
	public Room(int roomNo){
		this.rootNumber = roomNo;
	}
	
	public MapSite getSide(Direction d){ // ö����ô��?
		return sides.get(d);
	}
	public void setSide(Direction d, MapSite site){
		sides.put(d, site);
	}
	public void enter(){
		
	}
	public int getRootNumber() {
		return rootNumber;
	}
	public void setRootNumber(int rootNumber) {
		this.rootNumber = rootNumber;
	}
}