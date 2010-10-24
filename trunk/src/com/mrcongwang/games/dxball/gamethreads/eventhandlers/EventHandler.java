package com.mrcongwang.games.dxball.gamethreads.eventhandlers;

import com.mrcongwang.games.dxball.entities.Ball;
import com.mrcongwang.games.dxball.entities.Wall;
import com.mrcongwang.games.dxball.entities.Paddle;
import com.mrcongwang.games.dxball.managers.EntityManager;

public abstract class EventHandler {
	
	protected final static Paddle _paddle = EntityManager.PADDLE;
	protected final static Ball _ball = EntityManager.BALL;
	protected final static Wall _wall = new Wall();
	
	public abstract boolean isInvokable();
	public abstract void invoke();

}
