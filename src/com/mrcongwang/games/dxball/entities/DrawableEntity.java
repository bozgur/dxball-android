package com.mrcongwang.games.dxball.entities;

import com.mrcongwang.games.dxball.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public abstract class DrawableEntity extends AbstractEntity{
	
	protected Bitmap _bitmap;
	protected float _x;
	protected float _y;
	
	protected int _width;
	protected int _height;
	
	protected static Bitmap _bitmap_paddle_mid;
	protected static Bitmap _bitmap_paddle_long;
	protected static Bitmap _bitmap_paddle_short;
	protected static Bitmap _bitmap_ball_normal;
	
	protected boolean _need_to_redraw = false;
	
	public void drawSelf(Canvas c){
		c.drawBitmap(_bitmap, _x, _y, null);		
	}

	public static void loadResource(Resources r){
		_bitmap_paddle_mid = BitmapFactory.decodeResource(r, R.drawable.paddle_mid);
		_bitmap_ball_normal = BitmapFactory.decodeResource(r, R.drawable.ball_b1);
		
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

	public float get_x() {
		return _x;
	}

	public void set_x(float _x) {
		this._x = _x;
	}

	public float get_y() {
		return _y;
	}

	public void set_y(float _y) {
		this._y = _y;
	}
	
	public synchronized boolean isNeedRedraw(){
		return _need_to_redraw;
	}
	
	public synchronized void needRedraw(){
		_need_to_redraw = true;
	}
	
	protected void setRectFromBitmap(){
		_width = _bitmap.getWidth();
		_height = _bitmap.getHeight();
	}
	

}
