package com.example.banha_services;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class listAdpter extends ArrayAdapter<userData> {

    public listAdpter(@NonNull Context context, ArrayList<userData> userData) {
        super(context,R.layout.listitem,userData);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        userData userData=getItem(position);
        if (convertView==null)
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.listitem,parent,false);
        ImageView imageView=convertView.findViewById(R.id.image_list);
        TextView textViewName=convertView.findViewById(R.id.Name_list);
        TextView textViewdisc=convertView.findViewById(R.id.discription_list);
        imageView.setImageResource(userData.imageId);
        textViewName.setText(userData.name);
        textViewdisc.setText(userData.discription);
        return super.getView(position, convertView, parent);
    }
}
