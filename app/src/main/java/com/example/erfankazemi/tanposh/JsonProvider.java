package com.example.erfankazemi.tanposh;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;


public class JsonProvider extends AppCompatActivity {


  Context context1;
  int resource;

  public JSONArray sendJson(String value, Context context, int resource) {
    this.resource = resource;
    context1 = context;
    JSONArray Array = null;
    try {

      Array = new JSONObject(loadJSONFromAsset(resource)).getJSONArray(value);
      return Array;

    } catch (JSONException e) {
      e.printStackTrace();
    }
    return Array;
  }


  private String loadJSONFromAsset(int resource) {
    String json = null;
    try {

      InputStream is = context1.getResources().openRawResource(resource);
      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();
      json = new String(buffer, "UTF-8");
    } catch (UnsupportedEncodingException e1) {
      e1.printStackTrace();
    } catch (IOException ex) {
      ex.printStackTrace();
      return null;
    }

    return json;
  }


}
