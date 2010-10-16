package com.mrcongwang.games.dxball.entities;

public abstract class CollisionDetectableEntity extends DrawableEntity {

	public static final int NO_COLLISION = -1;
	public static final int VERTICAL = 0;
	public static final int HORIZONTAL = 90;
	
	// 返回反射面的角度，返回-1说明未碰撞
	public abstract int detectCollision(DrawableEntity target);

}
