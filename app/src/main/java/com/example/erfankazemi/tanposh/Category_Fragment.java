package com.example.erfankazemi.tanposh;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class Category_Fragment extends Fragment {

  private RecyclerView rcvCat;
  private Context context;
  private final int[] CAT_IMG = {
    R.drawable.mencat,
    R.drawable.womencat,
    R.drawable.babycat

  };


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_category, container, false);

    context = getContext();
    rcvCat = (RecyclerView) view.findViewById(R.id.rcvCat);
    rcvCat.setAdapter(new RcvCatAdapter(context, CAT_IMG));
    rcvCat.setLayoutManager(new GridLayoutManager(context, 1, LinearLayoutManager.VERTICAL, false));


    return view;
  }

}
