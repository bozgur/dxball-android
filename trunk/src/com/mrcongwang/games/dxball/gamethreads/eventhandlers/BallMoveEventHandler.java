package com.mrcongwang.games.dxball.gamethreads.eventhandlers;

import com.mrcongwang.games.dxball.entities.Ball;

public class BallMoveEventHandler extends EventHandler {

	@Override
	public boolean isInvokable() {
		return _ball.get_status() == Ball.STATUS_FLYING;
	}

	@Override
	public void invoke() {
		_ball.move();
	}

}
