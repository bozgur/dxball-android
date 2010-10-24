package com.mrcongwang.games.dxball.utils;

import android.text.format.Time;

public final class DateUtils {
	
	public static final Time getNow(){
		Time t = new Time();
		t.setToNow();
		return t;
		
	}

}
