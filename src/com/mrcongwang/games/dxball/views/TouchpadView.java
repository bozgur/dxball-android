package com.mrcongwang.games.dxball.views;

import com.mrcongwang.games.dxball.managers.EntityManager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

public class TouchpadView extends View {

	private void init(){
		setBackgroundColor(Color.BLUE);
	}

	public TouchpadView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);		
	}
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		switch(ev.getAction()){
		case MotionEvent.ACTION_DOWN:			
		case MotionEvent.ACTION_MOVE:
			EntityManager.PADDLE.movePaddleByCenterPoint((int) ev.getRawX());
			break;
		}
		return true;
	}
	 
	
	

}
