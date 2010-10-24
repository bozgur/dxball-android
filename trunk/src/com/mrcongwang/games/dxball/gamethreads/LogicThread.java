package com.mrcongwang.games.dxball.gamethreads;

import java.util.LinkedList;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.mrcongwang.games.dxball.entities.Ball;
import com.mrcongwang.games.dxball.entities.Paddle;
import com.mrcongwang.games.dxball.gamethreads.eventhandlers.BallDeadEventHandler;
import com.mrcongwang.games.dxball.gamethreads.eventhandlers.BallMoveEventHandler;
import com.mrcongwang.games.dxball.gamethreads.eventhandlers.EventHandler;
import com.mrcongwang.games.dxball.gamethreads.eventhandlers.HitWallEventHandler;
import com.mrcongwang.games.dxball.gamethreads.eventhandlers.PaddleReflectEventHandler;
import com.mrcongwang.games.dxball.managers.ConfManager;
import com.mrcongwang.games.dxball.managers.EntityManager;
import com.mrcongwang.games.dxball.utils.DateUtils;

public class LogicThread extends GameThread {	
	
	private LinkedList<EventHandler> _eventhandlers = new LinkedList<EventHandler>();
	
	private Handler _handler;
	
	public static final int STATUS_READY = 0; 
	public static final int STATUS_RUNNING = 1;
	public static final int STATUS_PAUSED = 2; 
	public static final int STATUS_END = 3; 
	
	private int _running_status = STATUS_READY;
	
	public void initEntity(){
		_paddle.set_x(get_gameplay_width()/2 - _paddle.get_width()/2);
		_paddle.set_y(get_gameplay_height() - _paddle.get_height());
		_ball.stickToPaddle();
	}
	
	private void initEventHandlers(){
		_eventhandlers.add(new BallMoveEventHandler());
		_eventhandlers.add(new HitWallEventHandler());
		_eventhandlers.add(new PaddleReflectEventHandler());
		_eventhandlers.add(new BallDeadEventHandler());
	}
	
	
	
	public LogicThread(Handler handler){
		_handler = handler;	
		initEntity();
		initEventHandlers();
	}
	
	private int get_gameplay_width(){
		return ConfManager.WIDTH;
	}
	
	private int get_gameplay_height(){
		return ConfManager.HEIGHT;
	}
	
	@Override
	public void run() {
		while(_running_status == STATUS_RUNNING){
			long elapsed = DateUtils.getNow().toMillis(true);
			for(EventHandler h:_eventhandlers){
				if(h.isInvokable()){
					h.invoke();
				}
			}
			redraw();
			elapsed = DateUtils.getNow().toMillis(true) - elapsed; 
			try {
				sleep(ConfManager.FRAME_DELAY - elapsed < 0 ? 0 : ConfManager.FRAME_DELAY - elapsed);
			} catch (InterruptedException e) {
				stop();
			}
		}
	}
	
	public void setRunningStatus(int status){
		_running_status = status;
	}
	
	private void redraw(){
		Bundle data = new Bundle();
		data.putBoolean("redraw", true);
		Message msg = new Message();
		msg.setData(data);
		_handler.sendMessage(msg);
	}
}
