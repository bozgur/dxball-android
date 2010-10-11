package com.mrcongwang.games.dxball.view;

import com.mrcongwang.games.dxball.controller.DXBallController;
import com.mrcongwang.games.dxball.model.EntityManager;
import com.mrcongwang.games.dxball.model.Paddle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class DXBallView extends SurfaceView implements SurfaceHolder.Callback{		
	
	private DXBallController _controller;
	
	public DXBallView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setBackgroundColor(Color.GREEN);
		getHolder().addCallback(this);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(widthMeasureSpec, MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels - 50, MeasureSpec.getMode(heightMeasureSpec)));		
	}

	@Override
	public void draw(Canvas canvas) {		
		super.draw(canvas);
		EntityManager.PADDLE.drawSelf(canvas);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		_controller.set_height(height);
		_controller.set_width(width);
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		_controller = new DXBallController(holder.getSurfaceFrame().width(), holder.getSurfaceFrame().height());
		_controller.start();
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	
}
