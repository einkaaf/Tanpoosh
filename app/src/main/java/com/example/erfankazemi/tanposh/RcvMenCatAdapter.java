package com.example.erfankazemi.tanposh;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class RcvMenCatAdapter extends RecyclerView.Adapter<RcvMenCatAdapter.MyViewHolder> {
  private Context context;
  private String[] menCatTitle;
  private int[] menCatimages;


  public RcvMenCatAdapter(Context context, String[] menCatTitle, int[] menCatimages) {
    this.context = context;
    this.menCatTitle = menCatTitle;
    this.menCatimages = menCatimages;

  }


  @Override
  public RcvMenCatAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.men_category_layout, parent, false);
    return new MyViewHolder(view);
  }

  @Override
  public void onBindViewHolder(RcvMenCatAdapter.MyViewHolder holder, int position) {

    holder.mentext.setText(menCatTitle[position]);
    holder.menCatimages.setImageResource(menCatimages[position]);

  }

  @Override
  public int getItemCount() {
    return menCatTitle.length;
  }

  public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView mentext;
    ImageView menCatimages;
    //FrameLayout mainFrame;


    public MyViewHolder(final View itemView) {
      super(itemView);

      mentext = (TextView) itemView.findViewById(R.id.mentext);
      menCatimages = (ImageView) itemView.findViewById(R.id.img1);

      itemView.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
          final int IDClick = getAdapterPosition();
          switch (IDClick) {
            default:
              Intent intent1 = new Intent(context, ShowClothes.class);
              intent1.putExtra("PageNum", IDClick);
              context.startActivity(intent1);
              break;
          }


        }
      });


    }
  }

}
