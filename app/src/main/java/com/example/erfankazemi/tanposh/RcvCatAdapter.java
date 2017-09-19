package com.example.erfankazemi.tanposh;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
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

import static com.example.erfankazemi.tanposh.R.id.imageView;
import static com.example.erfankazemi.tanposh.R.id.imgTitle;
import static com.example.erfankazemi.tanposh.R.id.myimg;

/**
 * Created by Erfan Kazemi on 8/23/2017.
 */

public class RcvCatAdapter extends RecyclerView.Adapter<RcvCatAdapter.MyViewHolder> {
  private Context context;
  private int[] images;


  public RcvCatAdapter(Context context, int[] images) {
    this.context = context;
    this.images = images;

  }


  @Override
  public RcvCatAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.category_layout, parent, false);
    return new MyViewHolder(view);
  }

  @Override
  public void onBindViewHolder(RcvCatAdapter.MyViewHolder holder, int position) {
    holder.myimg.setImageResource(images[position]);
  }

  @Override
  public int getItemCount() {
    return images.length;
  }

  public class MyViewHolder extends RecyclerView.ViewHolder {


    FrameLayout mainFrame;
    ImageView myimg;


    public MyViewHolder(final View itemView) {
      super(itemView);
      myimg = (ImageView) itemView.findViewById(R.id.myimg);
      mainFrame = (FrameLayout) itemView.findViewById(R.id.mainFrame);
      itemView.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
          final int IDClick = getAdapterPosition();
          switch (IDClick) {
            case 0:
              Fragment fragment = new MenCat_Fragment();
              FragmentManager fm = ((MainActivity) context).getSupportFragmentManager();
              FragmentTransaction ft = fm.beginTransaction();
              ft.replace(R.id.mainFrame, fragment).commit();
              break;
            default:
              Snackbar snackbar = Snackbar.make(v, "Coming soon", Snackbar.LENGTH_SHORT);
              snackbar.show();
              //Toast.makeText(context, "you click: " + IDClick, Toast.LENGTH_SHORT).show();
              break;
          }


        }
      });


    }
  }

}
