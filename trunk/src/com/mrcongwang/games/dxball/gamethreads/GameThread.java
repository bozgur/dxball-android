package com.mrcongwang.games.dxball.gamethreads;

import com.mrcongwang.games.dxball.entities.Ball;
import com.mrcongwang.games.dxball.entities.Paddle;
import com.mrcongwang.games.dxball.managers.EntityManager;

public class GameThread extends Thread {

	protected final static Paddle _paddle = EntityManager.PADDLE;
	protected final static Ball _ball = EntityManager.BALL;
	
}
