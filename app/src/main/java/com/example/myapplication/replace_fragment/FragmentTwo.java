package com.example.myapplication.replace_fragment;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentTwo extends Fragment {
    private ViewGroup container;
    private LayoutInflater inflater;
    @BindView(R.id.switch_fragment)
    Button switch_fragment;
    @BindView(R.id.mainLayout)
    ConstraintLayout mainLayout;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        this.container = container;
        this.inflater = inflater;
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(
                R.layout.fragment_two_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.switch_fragment)
    public void switchFragment() {
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.mainLayout, new FragmentThree(), "NewFragmentTag");
        ft.commit();
    }
}
