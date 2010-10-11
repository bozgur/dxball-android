package com.mrcongwang.games.dxball.model;

import com.mrcongwang.games.dxball.R;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Paddle extends DrawableEntity {

	
	public Paddle() {
		super();
		_bitmap = _bitmap_paddle_mid;
		_width = _bitmap.getWidth();
		_height = _bitmap.getHeight();
	}

	@Override
	public void drawSelf(Canvas c) {
		c.drawBitmap(_bitmap, _x, _y, null);		
	}

}
