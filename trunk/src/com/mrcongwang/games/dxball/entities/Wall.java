package com.mrcongwang.games.dxball.entities;

import com.mrcongwang.games.dxball.managers.ConfManager;

public class Wall extends CollisionDetectableEntity {
	
	@Override
	public int detectCollision(DrawableEntity target) {
		if(target.get_x() <= 0 || target.get_x() + target.get_width() >= ConfManager.WIDTH ){
			return VERTICAL;
		}
		if(target.get_y() <= 0){
			return HORIZONTAL;
		}
		return NO_COLLISION;
	}
	
	

}
