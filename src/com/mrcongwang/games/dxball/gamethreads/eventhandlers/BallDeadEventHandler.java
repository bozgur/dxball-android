package com.mrcongwang.games.dxball.gamethreads.eventhandlers;

import com.mrcongwang.games.dxball.managers.ConfManager;

public class BallDeadEventHandler extends EventHandler {

	@Override
	public boolean isInvokable() {
		return _ball.get_y() >= ConfManager.HEIGHT;
	}

	@Override
	public void invoke() {
		_ball.stickToPaddle();

	}

}
