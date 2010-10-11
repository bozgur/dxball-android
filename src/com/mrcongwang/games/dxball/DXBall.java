package com.mrcongwang.games.dxball;

import com.mrcongwang.games.dxball.model.DrawableEntity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class DXBall extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {    	
        super.onCreate(savedInstanceState);

        // load resources
        DrawableEntity.loadResource(getResources());

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        
    }
}