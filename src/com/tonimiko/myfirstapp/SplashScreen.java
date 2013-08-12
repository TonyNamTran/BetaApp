package com.tonimiko.myfirstapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

public class SplashScreen extends Activity {
	private static final long SPLASHTIME = 5000;
	private static final int STOP = 0;
	private ImageView splashimg;

	/**
	 * Create a handler to handle the splash message. When it receives the
	 * notification to stop, it will render the splash screen invisible.
	 */
	private Handler splashHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case STOP:
				splashimg.setVisibility(View.GONE);
				break;
			}
			super.handleMessage(msg);
		}
	};













	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		splashimg = (ImageView) findViewById(R.drawable.menu_btn);
		Message msg = new Message();
		msg.what = STOP;
		splashHandler.sendMessageDelayed(msg, SPLASHTIME);
	}

}
