package com.mrcongwang.games.dxball.gamethreads.eventhandlers;

import com.mrcongwang.games.dxball.entities.CollisionDetectableEntity;
import com.mrcongwang.games.dxball.utils.GameUtils;

public class PaddleReflectEventHandler extends BallReflectionEventHandler {
	
	@Override
	public boolean isInvokable() {
		_collision_angle = _paddle.detectCollision(_ball);
		return GameUtils.isDirectionDownwards(_ball.get_direction()) && !(_collision_angle == CollisionDetectableEntity.NO_COLLISION);
	}

	@Override
	public void invoke() {
		_ball.reflect(_collision_angle);
	}

}
