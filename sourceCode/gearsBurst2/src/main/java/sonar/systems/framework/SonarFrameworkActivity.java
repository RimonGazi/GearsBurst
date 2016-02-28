package sonar.systems.framework;

import org.cocos2dx.lib.Cocos2dxActivity;

import com.flurry.android.FlurryAgent;
import com.sdkbox.plugin.SDKBox;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class SonarFrameworkActivity extends Cocos2dxActivity
{
	
	private static SonarFrameworkFunctions functions = null;
	
	protected SonarFrameworkActivity()
	{
		super();
	}
	
	@Override
	protected void onCreate(Bundle b) 
	{
		super.onCreate(b);
		try {
			functions = new SonarFrameworkFunctions(this);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		functions.onCreate(b);
		
		SDKBox.init(this);
		
	    
	    FlurryAgent.onStartSession(this);
	    Log.d("MyLog", "Start session Flurry!");
	}

	@Override
	protected void onStart() 
	{
		super.onStart();
		functions.onStart();
		SDKBox.onStart();
	}

	@Override
	protected void onStop() 
	{
		super.onStop();
		functions.onStop();
	    SDKBox.onStop();
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		functions.onResume();
		SDKBox.onResume();
	}
	
	@Override
	protected void onActivityResult(int request, int response, Intent data)
	{
		if(!SDKBox.onActivityResult(request, response, data)) {
			super.onActivityResult(request, response, data);
			functions.onActivityResult(request, response, data);
          }
		
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) 
	{
	    super.onSaveInstanceState(outState);
	    functions.onSaveInstanceState(outState);
	}

	@Override
	public void onPause() 
	{
	    super.onPause();
	    functions.onPause();
	    SDKBox.onPause();
	    
	}

	@Override
	public void onDestroy() 
	{
	    super.onDestroy();
	    functions.onDestroy();
	    
	    Log.d("MyLog", "onDestroyHahaha");
		FlurryAgent.onEndSession(this);
	}
	
	@Override
	public void onBackPressed() 
	{
		 if(!SDKBox.onBackPressed()) {
			 if(functions.onBackPressed())
					return;
				else
					super.onBackPressed();
	          }
			
	}
	//Cocos2d-x
	static 
	{
			System.loadLibrary("cocos2dcpp");
	}
}