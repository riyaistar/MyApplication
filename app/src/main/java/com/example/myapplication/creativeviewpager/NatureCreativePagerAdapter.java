package com.example.myapplication.creativeviewpager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.tbuonomo.creativeviewpager.adapter.CreativePagerAdapter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NatureCreativePagerAdapter implements CreativePagerAdapter {
    private Context context;
    private List<Profile> profiles;
    private RequestManager requestManager;

    public NatureCreativePagerAdapter(Context context, List<Profile> profiles) {
        this.context = context;
        this.profiles = profiles;
    }

    @Override
    public int getCount() {
        return profiles.size();
    }

    @NotNull
    @Override
    public View instantiateContentItem(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup container, int position) {
        // Inflate page layout
        View headerRoot = layoutInflater.inflate(R.layout.item_creative_header_profile, container, false);

        // Bind the views
        ImageView imageView = (ImageView) headerRoot.findViewById(R.id.itemCreativeImage);

        imageView.setImageDrawable(
                (context.getResources().getDrawable(R.drawable.profile_default)));

        return headerRoot;
    }

    @NotNull
    @Override
    public View instantiateHeaderItem(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup container, int position) {
        View contentRoot = layoutInflater.inflate(R.layout.item_creative_content_nature, container,
                false);

        // Bind the views
        TextView title = (TextView) contentRoot.findViewById(R.id.itemCreativeNatureTitle);
        ImageView image = (ImageView) contentRoot.findViewById(R.id.itemCreativeNatureImage);

        title.setText(profiles.get(position).getName());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.download);
        requestOptions.error(R.drawable.profile_default);
        requestManager = Glide.with(context);
        requestManager.setDefaultRequestOptions(requestOptions)
                .load(profiles.get(position).getImageURL())
                .into(image);
        return contentRoot;
    }

    @Override
    public boolean isUpdatingBackgroundColor() {
        return true;
    }

    @Nullable
    @Override
    public Bitmap requestBitmapAtPosition(int position) {
        BitmapFactory bitmapFactory = new BitmapFactory();
        bitmapFactory.decodeResource(context.getResources(),
                R.drawable.ic_launcher_background);
        return null;
    }
}
