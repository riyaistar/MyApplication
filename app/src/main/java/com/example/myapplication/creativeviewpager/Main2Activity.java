package com.example.myapplication.creativeviewpager;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.R;
import com.github.javafaker.Faker;
import com.tbuonomo.creativeviewpager.CreativeViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {
    private List<Profile> profileList = new ArrayList<>();
    Faker faker = new Faker();


    @BindView(R.id.creativeViewPagerView)
    CreativeViewPager creativeViewPagerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        for(int i=0;i<10;i++){
            Profile profile = new Profile();
            profile.setName(faker.name().fullName());
            profile.setImageURL(faker.internet().avatar());
            profileList.add(profile);
        }


        creativeViewPagerView.setCreativeViewPagerAdapter(new NatureCreativePagerAdapter(this, profileList));

    }
}
