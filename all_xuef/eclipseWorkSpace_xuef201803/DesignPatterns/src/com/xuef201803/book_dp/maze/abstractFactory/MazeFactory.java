package com.xuef201803.book_dp.maze.abstractFactory;

import com.xuef201803.book_dp.maze.Door;
import com.xuef201803.book_dp.maze.Maze;
import com.xuef201803.book_dp.maze.Room;
import com.xuef201803.book_dp.maze.Wall;

/**
 * �������Դ����Թ��ĸ������
 * @author moveb
 *
 */
public class MazeFactory {
	public Maze createMaze() {
		return new Maze();
	}
	
	public Wall makeWall(){
		return new Wall();
	}
	public Room makeRoom(){
		return new Room();
	}
	public Door makeDoor(Room r1, Room r2){
		return new Door(r1, r2);
	}
}
