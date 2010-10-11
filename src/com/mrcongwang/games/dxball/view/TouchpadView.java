package com.mrcongwang.games.dxball.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

public class TouchpadView extends View {

	private void init(){
		setBackgroundColor(Color.BLUE);
	}
	public TouchpadView(Context context) {
		super(context);		
		init();
	}

	public TouchpadView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public TouchpadView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);		
	}
	
	

}
