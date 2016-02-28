package com.cocos.gearsburst;

import android.util.Log;

import com.flurry.android.FlurryAgent;

public class Application extends android.app.Application {
	@Override
	public void onCreate() {
	    super.onCreate();
	    FlurryAgent.setLogEnabled(true);
	    FlurryAgent.init(this, "M5FY59NJRJ6K5GTB2T55");
	}
}

