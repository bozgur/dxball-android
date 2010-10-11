package com.mrcongwang.games.dxball.controller;

import com.mrcongwang.games.dxball.model.EntityManager;
import com.mrcongwang.games.dxball.model.Paddle;

public class DXBallController extends Thread {
	
	private int _width;
	private int _height;
	
	private final Paddle _paddle = EntityManager.PADDLE;
	
	public void initEntity(){
		_paddle.set_x(_width/2 - _paddle.get_width()/2);
		_paddle.set_y(_height - _paddle.get_height());
	}
	
	public DXBallController(int width, int height){
		_width = width;
		_height = height;
		initEntity();
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
	
	
}
