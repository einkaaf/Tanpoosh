package com.example.erfankazemi.tanposh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ShowDetails extends AppCompatActivity {

  String[] item_det = new String[4];

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_show_details);

    TextView t1 = (TextView) findViewById(R.id.t1);
    TextView t2 = (TextView) findViewById(R.id.t2);
    TextView t3 = (TextView) findViewById(R.id.t3);
    TextView t4 = (TextView) findViewById(R.id.t4);
    final FrameLayout frm2 = (FrameLayout) findViewById(R.id.frm2);
    frm2.setVisibility(View.GONE);
    Button buybtn = (Button) findViewById(R.id.buybtn);


    final Bundle bundle1 = getIntent().getExtras();
    final Bundle send = new Bundle();
    item_det = bundle1.getStringArray("item_det");
    t1.setText(item_det[0]);
    t2.setText(item_det[1]);
    t3.setText(item_det[2]);
    t4.setText(item_det[3]);

    buybtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
//        frm2.setVisibility(View.VISIBLE);
//        send.putStringArray("getstring",item_det);
//        YourBag_Fragment YB=new YourBag_Fragment();
//        YB.setArguments(send);
//        getSupportFragmentManager().beginTransaction().replace(R.id.frm2, YB).commit();
        Toast.makeText(ShowDetails.this, "This item added to your list", Toast.LENGTH_SHORT).show();


      }
    });


  }


}
