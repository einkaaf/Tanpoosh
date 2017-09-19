package com.example.erfankazemi.tanposh;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;

public class ShowClothes extends AppCompatActivity {
  private RecyclerView rcv1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_show_clothes);

    rcv1 = (RecyclerView) findViewById(R.id.show_thing_rcv);
    JsonProvider JsonProvider = new JsonProvider();

    Context con = getApplicationContext();


    Bundle bundle1 = getIntent().getExtras();
    int pageNum = bundle1.getInt("PageNum");

    switch (pageNum) {
      case 0:
        JSONArray Array0 = JsonProvider.sendJson("pirahan", con, R.raw.pirahan);
        rcv1.setAdapter(new ShowThingsAdapter(ShowClothes.this, Array0, R.drawable.pirahan));
        rcv1.setLayoutManager(new LinearLayoutManager(ShowClothes.this, LinearLayoutManager.VERTICAL, false));
        break;
      case 1:
        JSONArray Array1 = JsonProvider.sendJson("tshirt", con, R.raw.tshirt);
        rcv1.setAdapter(new ShowThingsAdapter(ShowClothes.this, Array1, R.drawable.tshirt));
        rcv1.setLayoutManager(new LinearLayoutManager(ShowClothes.this, LinearLayoutManager.VERTICAL, false));
        break;
      case 2:
        JSONArray Array2 = JsonProvider.sendJson("shalvar", con, R.raw.shalvar);
        rcv1.setAdapter(new ShowThingsAdapter(ShowClothes.this, Array2, R.drawable.shalvar));
        rcv1.setLayoutManager(new LinearLayoutManager(ShowClothes.this, LinearLayoutManager.VERTICAL, false));
        break;
      case 3:
        JSONArray Array3 = JsonProvider.sendJson("kafsh", con, R.raw.kafsh);
        rcv1.setAdapter(new ShowThingsAdapter(ShowClothes.this, Array3, R.drawable.kafsh));
        rcv1.setLayoutManager(new LinearLayoutManager(ShowClothes.this, LinearLayoutManager.VERTICAL, false));
        break;
    }

  }
}
