package com.xuef201803.book_dp.maze.abstractFactory;

import com.xuef201803.book_dp.maze.Direction;
import com.xuef201803.book_dp.maze.Door;
import com.xuef201803.book_dp.maze.Maze;
import com.xuef201803.book_dp.maze.Room;

public class MazeGameWithFactory {

	public static Maze createMaze(MazeFactory mazeFactory){
		
		Maze aMaze = mazeFactory.createMaze();
		Room r1 = mazeFactory.makeRoom();
		Room r2 = mazeFactory.makeRoom();
		Door aDoor = mazeFactory.makeDoor(r1, r2);
		
		aMaze.addRoom(r1);
		aMaze.addRoom(r2);
		
		r1.setSide(Direction.NORTH, mazeFactory.makeWall());
		r1.setSide(Direction.EAST, aDoor);
		r1.setSide(Direction.SOUTH, mazeFactory.makeWall());
		r1.setSide(Direction.WEST, mazeFactory.makeWall());
		
		r2.setSide(Direction.NORTH, mazeFactory.makeWall());
		r2.setSide(Direction.EAST, mazeFactory.makeWall());
		r2.setSide(Direction.SOUTH, mazeFactory.makeWall());
		r2.setSide(Direction.WEST, aDoor);
		return aMaze;
	}
}
