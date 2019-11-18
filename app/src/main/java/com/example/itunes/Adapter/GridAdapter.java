package com.example.itunes.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.itunes.R;
import com.example.itunes.models.ResultData;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    private ArrayList<ResultData> data;
    private Context context;

    public GridAdapter(ArrayList<ResultData> list, Context context) {
        this.data = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView thumbnail;
        TextView name, subtitle;
        convertView = LayoutInflater.from(context).inflate(R.layout.custom_layout, parent, false);
        thumbnail = convertView.findViewById(R.id.thumbnail);
        name = convertView.findViewById(R.id.name);
        subtitle = convertView.findViewById(R.id.subtitle);
        Glide.with(context).load(data.get(position).getArtworkUrl100()).into(thumbnail);
        name.setText(data.get(position).getTrackName());
        subtitle.setText(data.get(position).getArtistName());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,data.get(position).getArtistName(),Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }
}
