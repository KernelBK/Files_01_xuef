package com.xuef201803.book_dp.maze;

import java.util.HashMap;
import java.util.Map;

/**
 * ������Թ���
 * @author moveb
 *
 */
public class Maze {
	/**
	 * һ���Թ���ʲô?
	 */
	private Map<Integer, Room> maze = new HashMap();
	
	public void addRoom(Room room){
		maze.put(room.getRootNumber(), room);
	}
}