package com.example.erfankazemi.tanposh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Erfan Kazemi on 8/11/2017.
 */

public class YourBagRcvAdapter extends RecyclerView.Adapter<YourBagRcvAdapter.MyViewHolder> {

  private Context context;
  private List<Item> itemes;

  public YourBagRcvAdapter(Context context, List<Item> itemses) {
    this.context = context;
    this.itemes = itemses;
  }

  @Override
  public YourBagRcvAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.show_item__bag_rcv_layout, parent, false);
    return new MyViewHolder(view);
  }

  @Override
  public void onBindViewHolder(YourBagRcvAdapter.MyViewHolder holder, int position) {
    holder.txtTitle.setText(itemes.get(position).getName());
  }

  @Override
  public int getItemCount() {
    return itemes.size();
  }

  public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    TextView txtTitle;
    TextView txtPrice;
    TextView txtCode;

    public MyViewHolder(View itemView) {
      super(itemView);

      txtTitle = (TextView) itemView.findViewById(R.id.name);
      txtPrice = (TextView) itemView.findViewById(R.id.price);
      txtCode = (TextView) itemView.findViewById(R.id.code);


    }

    @Override
    public void onClick(View v) {

    }
  }
}
