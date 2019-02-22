package com.example.myapplication.utility;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class CustomSpinnerAdapter extends ArrayAdapter<String> {
    private final List<String> months;
    private Context mContext;
    private final LayoutInflater mInflater;
    private final int mResource;

    public CustomSpinnerAdapter(@NonNull Context context, @LayoutRes int resource,
                                @NonNull List<String> months) {
        super(context, resource, 0, months);

        mContext = context;
        mInflater = LayoutInflater.from(context);
        mResource = resource;
        this.months = months;
    }


    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public @NonNull View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent){
        final View view = mInflater.inflate(mResource, parent, false);
        TextView month_text = (TextView) view.findViewById(R.id.spinner_text);
        month_text.setText(months.get(position));
        return view;
    }
}