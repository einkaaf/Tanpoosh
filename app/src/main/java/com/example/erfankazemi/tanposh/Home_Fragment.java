package com.example.erfankazemi.tanposh;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.InputType;
import android.util.Log;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;


public class Home_Fragment extends Fragment {
  //-----------------------------------------------------
  private static final int SWIPE_MIN_DISTANCE = 120;
  private static final int SWIPE_THRESHOLD_VELOCITY = 200;
  private ViewFlipper mViewFlipper;
  private Context mContext;
  private final GestureDetector detector = new GestureDetector(new SwipeGestureDetector());
  //----------------------------------------------------------------------------------------


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.fragment_home, container, false);
    //----------------------------------------------------------------------------
    mContext = view.getContext();
    mViewFlipper = (ViewFlipper) view.findViewById(R.id.view_flipper);
    mViewFlipper.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(final View view, final MotionEvent event) {
        detector.onTouchEvent(event);
        return true;
      }
    });
    mViewFlipper.setAutoStart(true);
    mViewFlipper.setFlipInterval(4000);
    mViewFlipper.startFlipping();
    //-------------------------------------------------------------------
    final Button register = (Button) view.findViewById(R.id.register);
    final Button aboutUs = (Button) view.findViewById(R.id.about);
    final TextView regText = (TextView) view.findViewById(R.id.regText);
    final CardView cardreg = (CardView) view.findViewById(R.id.cardreg);
    aboutUs.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(mContext, aboutUs.class);
        mContext.startActivity(intent);

      }
    });
    regText.setText("");
    register.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (regText.getText().toString().matches("")) {
          //Toast.makeText(mContext, "please enter your email", Toast.LENGTH_SHORT).show();
          Snackbar snackbar = Snackbar.make(v, "Please Enter Your Email", Snackbar.LENGTH_LONG);
          snackbar.show();
          regText.onEditorAction(EditorInfo.IME_ACTION_DONE);
        } else {
          // Toast.makeText(mContext, "Thank you for Register", Toast.LENGTH_SHORT).show();

          regText.setText("");
          Snackbar snackbar = Snackbar.make(v, "Thank you for Register", Snackbar.LENGTH_LONG);
          snackbar.show();
          regText.onEditorAction(EditorInfo.IME_ACTION_DONE);
          //cardreg.setVisibility(View.GONE);
        }
      }
    });

    //-------------------------------------------------------


    return view;
  }

  //------------------------------------class------------------
  class SwipeGestureDetector extends GestureDetector.SimpleOnGestureListener {
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
      try {
        // right to left swipe
        if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
          mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_in));
          mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_out));
          mViewFlipper.showNext();
          return true;
        } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
          mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.right_in));
          mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.right_out));
          mViewFlipper.showPrevious();
          return true;
        }

      } catch (Exception e) {
        e.printStackTrace();
      }

      return false;
    }
  }

}
