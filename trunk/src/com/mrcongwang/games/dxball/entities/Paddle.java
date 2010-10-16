package com.mrcongwang.games.dxball.entities;

import com.mrcongwang.games.dxball.R;
import com.mrcongwang.games.dxball.managers.ConfManager;
import com.mrcongwang.games.dxball.managers.EntityManager;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Paddle extends CollisionDetectableEntity {

	private static final int EDGE_WIDTH = 18;
	
	public Paddle() {
		super();
		_bitmap = _bitmap_paddle_mid;
		setRectFromBitmap();		
	}

	// x : paddle的中心点位置
	public boolean movePaddleByCenterPoint(int centerX){
		boolean hitWall = false;
		int x = centerX - _width / 2;
		if(x < 0){
			x = 0;
			hitWall = true;			
		}
		else if(x > ConfManager.WIDTH - _width){
			x = ConfManager.WIDTH - _width;
			hitWall = true;
		}
		EntityManager.PADDLE.set_x(x);
		if(EntityManager.BALL.get_status() == EntityManager.BALL.STATUS_READY_TO_FIRE){
			EntityManager.BALL.stickToPaddle();
			EntityManager.BALL.needRedraw();
		}
		needRedraw();
		return hitWall;
	}
	
	public float get_holder_x(){
		return get_x() + EDGE_WIDTH;
		
	}
	
	public float get_holder_y(){
		return get_y();
	}
	
	public int get_holder_width(){
		return get_width() - EDGE_WIDTH*2;
	}
	
	public int get_holder_height(){
		return get_height();
	}

	@Override
	public int detectCollision(DrawableEntity target) {
		final float x = target.get_x();
		final float y = target.get_y();
		if(y + target.get_height() >= get_holder_y() && x >= get_x() && x + target.get_width() <= get_x() + get_width()){
			return HORIZONTAL;
		}
		return NO_COLLISION;
	}
	
}
