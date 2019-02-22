package com.example.myapplication.replace_fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReplaceFragmentActivity extends AppCompatActivity {
    @BindView(R.id.showFragment)
    Button showFragment;
    @BindView(R.id.mainLayout)
    FrameLayout mainLayout;
    Boolean isfragmentvisible = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replace_fragment);
        ButterKnife.bind(this);
        FragmentOne simpleFragment = FragmentOne.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.add(R.id.mainLayout,
                simpleFragment).addToBackStack(null).commit();
    }

    @OnClick(R.id.showFragment)
    public void showFragment(){
        if(!isfragmentvisible){
            displayFragment();
        }
        else{
            closeFragment();
        }
    }

    public void displayFragment() {
        mainLayout.setVisibility(View.VISIBLE);
        showFragment.setText("hide fragment");
        isfragmentvisible=true;
    }

    public void closeFragment() {
        mainLayout.setVisibility(View.GONE);
        showFragment.setText("Show Fragment");
        isfragmentvisible = false;
    }
}
