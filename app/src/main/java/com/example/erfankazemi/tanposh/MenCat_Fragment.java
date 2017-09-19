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


public class MenCat_Fragment extends Fragment {

  private RecyclerView rcvMenCat;
  private Context context;
  String[] menCatTitle = {
    "پیراهن",
    "تی شرت",
    "شلوار",
    "کفش"
  };
  int[] menCatImages = {
    R.drawable.pirahan,
    R.drawable.tshirt,
    R.drawable.shalvar,
    R.drawable.kafsh,
  };


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_men_cat, container, false);
    context = getContext();
    rcvMenCat = (RecyclerView) view.findViewById(R.id.rcvMenCat);
    rcvMenCat.setAdapter(new RcvMenCatAdapter(context, menCatTitle, menCatImages));
    rcvMenCat.setLayoutManager(new GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false));


    return view;
  }

}
