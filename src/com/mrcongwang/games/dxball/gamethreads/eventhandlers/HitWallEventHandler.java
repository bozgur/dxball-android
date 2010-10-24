package com.mrcongwang.games.dxball.gamethreads.eventhandlers;

import com.mrcongwang.games.dxball.entities.CollisionDetectableEntity;
import com.mrcongwang.games.dxball.utils.GameUtils;

public class HitWallEventHandler extends BallReflectionEventHandler {
	
	@Override
	public boolean isInvokable() {
		_collision_angle = _wall.detectCollision(_ball);
		return !(_collision_angle == CollisionDetectableEntity.NO_COLLISION);
	}

	@Override
	public void invoke() {
		_ball.reflect(_collision_angle);
	}

}
