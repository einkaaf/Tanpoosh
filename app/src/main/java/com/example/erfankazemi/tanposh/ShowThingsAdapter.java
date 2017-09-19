package com.example.erfankazemi.tanposh;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Erfan Kazemi on 8/23/2017.
 */

public class ShowThingsAdapter extends RecyclerView.Adapter<ShowThingsAdapter.MyViewHolder> {
  private JSONArray jsonArray;
  private Context context;
  int img;
  private String[] item_det = new String[4];

  public ShowThingsAdapter(Context context, JSONArray jsonArray, int img) {
    this.context = context;
    this.jsonArray = jsonArray;
    this.img = img;
  }

  @Override
  public ShowThingsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.show_things_layout, parent, false);
    return new MyViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ShowThingsAdapter.MyViewHolder holder, int position) {
    JSONObject Array = null;
    try {
      Array = jsonArray.getJSONObject(position);
      holder.txtTitle.setText(Array.getString("Cat"));

    } catch (JSONException e) {
      e.printStackTrace();
    }
    holder.imgTitle.setImageResource(img);


  }

  @Override
  public int getItemCount() {
    return jsonArray.length();
  }

  public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView txtTitle;
    ImageView imgTitle;


    public MyViewHolder(final View itemView) {
      super(itemView);

      txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
      imgTitle = (ImageView) itemView.findViewById(R.id.imgTitle);


      itemView.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
          final int IDClick = getAdapterPosition();
          switch (IDClick) {
            default:
              //Toast.makeText(context, "you clicked: " + IDClick, Toast.LENGTH_SHORT).show();
              JSONObject Array2 = null;
              try {
                Array2 = jsonArray.getJSONObject(IDClick);
                item_det[0] = Array2.getString("Cat");
                item_det[1] = Array2.getString("Jens");
                item_det[2] = Array2.getString("Price");
                item_det[3] = Array2.getString("code");
              } catch (JSONException e) {
                e.printStackTrace();
              }

              Intent intent1 = new Intent(context, ShowDetails.class);
              intent1.putExtra("item_det", item_det);
              context.startActivity(intent1);
              break;
          }


        }
      });


    }
  }
}
