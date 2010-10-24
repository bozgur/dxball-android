package com.mrcongwang.games.dxball.gamethreads;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.mrcongwang.games.dxball.managers.ConfManager;
import com.mrcongwang.games.dxball.views.DXBallView;

public class RenderThread extends GameThread {
	
	private Handler _handler;
	
	public static final int STATUS_READY = 0; 
	public static final int STATUS_RUNNING = 1;
	public static final int STATUS_PAUSED = 2; 
	public static final int STATUS_END = 3; 
	
	private int _running_status = STATUS_READY;
	
	public RenderThread(Handler handler){
		_handler = handler;		
	}
	
	@Override
	public void run() {
		while(_running_status == STATUS_RUNNING){
			redraw();			
			try {
				sleep(ConfManager.FRAME_DELAY);
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
