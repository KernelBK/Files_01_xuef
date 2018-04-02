package com.xuef201803.book_dp.maze;

import java.util.HashMap;
import java.util.Map;

/**
 * 这就是迷宫了
 * @author moveb
 *
 */
public class Maze {
	/**
	 * 一个迷宫是什么?
	 */
	private Map<Integer, Room> maze = new HashMap();
	
	public void addRoom(Room room){
		maze.put(room.getRootNumber(), room);
	}
}
