package com.mrcongwang.games.dxball.utils;

public final class GameUtils {
	
	public static final boolean isDirectionUpwards(int direction){
		return (direction < 90 || direction > 270);
	}
	
	public static final boolean isDirectionDownwards(int direction){
		return (direction >= 90 && direction <= 270);
	}

}
