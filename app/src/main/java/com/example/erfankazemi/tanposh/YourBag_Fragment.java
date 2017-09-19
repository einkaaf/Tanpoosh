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

import java.util.ArrayList;
import java.util.List;


public class YourBag_Fragment extends Fragment {
  private RecyclerView rcvCat1;
  private Context context;
  private int COLL = 1;
  private List<Item> itemes;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_your_bag, container, false);
    context = getContext();
    itemes = new ArrayList<>();
    Item erfan = new Item();
    erfan.setName("nike");
    erfan.setCode("nike");
    erfan.setPrice("nike");

    Item erfan2 = new Item();
    erfan2.setName("adidas");
    erfan2.setCode("adidas");
    erfan2.setPrice("adidas");
    itemes.add(erfan);
    itemes.add(erfan2);


    rcvCat1 = (RecyclerView) view.findViewById(R.id.rcvCat1);
    rcvCat1.setAdapter(new YourBagRcvAdapter(context, itemes));
    rcvCat1.setLayoutManager(new GridLayoutManager(context, COLL, LinearLayoutManager.VERTICAL, false));
    return view;
  }

}
