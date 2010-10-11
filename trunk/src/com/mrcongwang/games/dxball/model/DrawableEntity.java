package com.mrcongwang.games.dxball.model;

import com.mrcongwang.games.dxball.R;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public abstract class DrawableEntity extends Entity {
	
	protected Bitmap _bitmap;
	protected int _x;
	protected int _y;
	
	protected int _width;
	protected int _height;
	
	protected static Bitmap _bitmap_paddle_mid;
	protected static Bitmap _bitmap_paddle_long;
	protected static Bitmap _bitmap_paddle_short;
	
	public abstract void drawSelf(Canvas c);

	public static void loadResource(Resources r){
		_bitmap_paddle_mid = BitmapFactory.decodeResource(r, R.drawable.paddle_mid);
		
	}	

	public int get_width() {
		return _width;
	}

	public void set_width(int _width) {
		this._width = _width;
	}

	public int get_height() {
		return _height;
	}

	public void set_height(int _height) {
		this._height = _height;
	}

	public int get_x() {
		return _x;
	}

	public void set_x(int _x) {
		this._x = _x;
	}

	public int get_y() {
		return _y;
	}

	public void set_y(int _y) {
		this._y = _y;
	}
}
