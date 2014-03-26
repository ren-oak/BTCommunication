package com.renguowen.btcommunication;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.*;
import android.widget.*;
import android.util.*;
import android.content.*;
import android.view.animation.*;


public class AnimationTabHost extends TabHost {

	
	private int mCurrentTabID = 0;
	private final long durationMillis = 400;
	
	public AnimationTabHost(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public AnimationTabHost(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	
	
	@Override
	public void setCurrentTab(int index) {	
				
		if(index > mCurrentTabID)
		{
        	 TranslateAnimation translateAnimation = new TranslateAnimation //位置移动     
             (      // x和y轴的起始和结束位置  
                     Animation.RELATIVE_TO_SELF, 0f,       
                     Animation.RELATIVE_TO_SELF, -1.0f,      
                     Animation.RELATIVE_TO_SELF, 0f,      
                     Animation.RELATIVE_TO_SELF, 0f      
             );//第一个参数fromXDelta ,第二个参数toXDelta:分别是动画起始、结束时X坐标。

        	   //第三个参数fromYDelta ,第四个参数toYDelta:分别是动画起始、结束时Y坐标。
        	 translateAnimation.setDuration(durationMillis);      
             getCurrentView().startAnimation(translateAnimation); 
		}
		else if(index < mCurrentTabID)
		{
        	 TranslateAnimation translateAnimation = new TranslateAnimation      
             (      //x和y轴的起始和结束位置  
                     Animation.RELATIVE_TO_SELF, 0f,       
                     Animation.RELATIVE_TO_SELF, 1.0f,       
                     Animation.RELATIVE_TO_SELF, 0f,      
                     Animation.RELATIVE_TO_SELF, 0f      
             );
        	 translateAnimation.setDuration(durationMillis);      
             getCurrentView().startAnimation(translateAnimation); 
		}
		else
		{
			//when first entry, getCurrentView()==null, must notify it.
		}

		super.setCurrentTab(index);

		//View target=(View)findViewById(android.R.id.tabcontent);//android.R.id.tabhost
		if(index > mCurrentTabID)
		{
        	 TranslateAnimation translateAnimation = new TranslateAnimation      
             (      // x和y轴的起始和结束位置  
                     Animation.RELATIVE_TO_PARENT, 1.0f,//RELATIVE_TO_SELF
                     Animation.RELATIVE_TO_PARENT, 0f,       
                     Animation.RELATIVE_TO_PARENT, 0f,      
                     Animation.RELATIVE_TO_PARENT, 0f      
             );
        	 translateAnimation.setDuration(durationMillis);      
        	 getCurrentView().startAnimation(translateAnimation); 
        	 //target.startAnimation(translateAnimation);
		}
		else if(index < mCurrentTabID)
		{
        	 TranslateAnimation translateAnimation = new TranslateAnimation      
             (      // x和y轴的起始和结束位置  
                     Animation.RELATIVE_TO_PARENT, -1.0f,       
                     Animation.RELATIVE_TO_PARENT, 0f,       
                     Animation.RELATIVE_TO_PARENT, 0f,      
                     Animation.RELATIVE_TO_PARENT, 0f      
             );
        	 translateAnimation.setDuration(durationMillis);      
        	 getCurrentView().startAnimation(translateAnimation); 
        	 //target.startAnimation(translateAnimation);
		}
		mCurrentTabID = index;
	}
}


/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
*/
