package com.mrcongwang.games.dxball.views;

import com.mrcongwang.games.dxball.entities.Paddle;
import com.mrcongwang.games.dxball.gamethreads.LogicThread;
import com.mrcongwang.games.dxball.managers.ConfManager;
import com.mrcongwang.games.dxball.managers.EntityManager;
//import com.mrcongwang.games.dxball.threads.RenderThread;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class DXBallView extends SurfaceView implements SurfaceHolder.Callback{		
	
	private LogicThread _logic_thread;
	//private RenderThread _render_thread;
	
	private final Handler _handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			if(msg.getData().getBoolean("redraw")){
				invalidate();
			}
		}
		
	};
	
	public DXBallView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setBackgroundColor(Color.GREEN);
		getHolder().addCallback(this);
	}

//	@Override
//	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//		setMeasuredDimension(widthMeasureSpec, MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels - 50, MeasureSpec.getMode(heightMeasureSpec)));		
//	}

	@Override
	public void draw(Canvas canvas) {		
		super.draw(canvas);
		EntityManager.PADDLE.drawSelf(canvas);
		EntityManager.BALL.drawSelf(canvas);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		ConfManager.HEIGHT = height;
		ConfManager.WIDTH = width;
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		ConfManager.HEIGHT = holder.getSurfaceFrame().height();
		ConfManager.WIDTH = holder.getSurfaceFrame().width();
		_logic_thread = new LogicThread(_handler);
		_logic_thread.setRunningStatus(LogicThread.STATUS_RUNNING);		
		_logic_thread.start();	
//		_render_thread = new RenderThread(_handler);
//		_render_thread.setRunningStatus(RenderThread.STATUS_RUNNING);
//		_render_thread.start();
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		switch(ev.getAction()){
		case MotionEvent.ACTION_DOWN:		
			EntityManager.BALL.fire();
			break;
		}
		return true;
	}
	
	

	
}
