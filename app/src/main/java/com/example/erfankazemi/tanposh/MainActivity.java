package com.example.erfankazemi.tanposh;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.ImageSwitcher;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    //----------------------------------BottomBar--------------------------------------------------
    BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
    bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
      @Override
      public void onTabSelected(@IdRes int tabId) {
        switch (tabId) {
          case R.id.bbHome:
            getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new Home_Fragment()).commit();

            break;
          case R.id.bbCategory:

            getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new Category_Fragment()).commit();
            break;
          case R.id.bbProfile:

            getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new YourBag_Fragment()).commit();
            break;
        }
      }
    });

  }
}
