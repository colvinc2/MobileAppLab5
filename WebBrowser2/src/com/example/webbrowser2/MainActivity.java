package com.example.webbrowser2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {


	WebView display;
	Button goButton;
	//Message msg;
	EditText urlEditText;


	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		display = (WebView) findViewById(R.id.display);
		urlEditText = (EditText) findViewById(R.id.urlText);
		goButton = (Button) findViewById(R.id.go);
		display.getSettings().setJavaScriptEnabled(true);
		goButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {


				Thread thread = new Thread(){
					@Override
					public void run(){



						URL url2 = null;

						try {
							url2 = new URL(urlEditText.getText().toString());
							//url2 = new URL("http://www.google.com");

							BufferedReader reader = new BufferedReader(new InputStreamReader(url2.openStream()));
							String reply = " ", temp = " ";

							temp = reader.readLine();
							while (temp != null){
								reply = reply + temp;
								temp = reader.readLine();
							}

							Message msg = Message.obtain();
							msg.obj = reply;
							

						} catch (Exception e) {
							e.printStackTrace();
						}


					}


				};

				thread.start();

			}
		});


	}





}
