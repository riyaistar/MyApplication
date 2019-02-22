package com.example.myapplication.collapsingimage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LeadActivity extends AppCompatActivity {
    @BindView(R.id.mainLayout)
    FrameLayout mainLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.scrollView2)
    ScrollView scrollView;

    @BindView(R.id.imageView)
    ImageView imageView;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_layout);
        unbinder = ButterKnife.bind(this);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        setWidgetsLocations();

    }

    private void setWidgetsLocations() {
        int scrollViewTopY = scrollView.getScrollY();
        int stickyViewTopY = Math.max(0, 192 - scrollViewTopY);
        float relativeLayoutRefinedMaxY = (192 + 56);
        toolbar.getBackground().setAlpha(getProportion(scrollViewTopY));
        imageView.setY(-(scrollViewTopY * 0.5f));
    }

    private int getProportion(int scrollViewTopY) {
        float totalUsableHeight = 192 - toolbar.getHeight();
        float proportion = (scrollViewTopY / totalUsableHeight) * 255;
        proportion = Math.max(0, proportion);
        return Math.min(255, (int) proportion);
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}