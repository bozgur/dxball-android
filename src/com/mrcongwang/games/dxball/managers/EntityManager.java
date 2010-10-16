package com.mrcongwang.games.dxball.managers;

import com.mrcongwang.games.dxball.entities.Ball;
import com.mrcongwang.games.dxball.entities.Wall;
import com.mrcongwang.games.dxball.entities.Paddle;
import com.mrcongwang.games.dxball.models.Player;

public abstract class EntityManager {
	
	public final static Paddle PADDLE = new Paddle();
	public final static Ball BALL = new Ball();
	public final static Wall WALL = new Wall();

}
