package com.example.erfankazemi.tanposh;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {
  final int SPLASH_TIME = 2000;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    getSupportActionBar().hide();
    setContentView(R.layout.activity_splash);
    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        Intent intent0 = new Intent(Splash.this, MainActivity.class);
        startActivity(intent0);
        finish();
      }
    }, SPLASH_TIME);
  }
}
