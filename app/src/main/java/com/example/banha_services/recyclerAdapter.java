package com.example.banha_services;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class recyclerAdapter extends RecyclerView.Adapter <recyclerAdapter.recyclerHolder>{
private List<recyclerData> data;
private Context context;
public class recyclerHolder extends RecyclerView.ViewHolder {
    private TextView s1;
    private ImageView img;
    private CardView cardView;
    public recyclerHolder(@NonNull View itemView) {
        super(itemView);
        s1=(TextView)itemView.findViewById(R.id.txt);
        img=(ImageView)itemView.findViewById(R.id.img);
        cardView=(CardView)itemView.findViewById(R.id.car);
    }

}

    public recyclerAdapter(List<recyclerData> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public recyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerdesign,parent,false);
        recyclerHolder holder=new recyclerHolder(row);

        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerHolder holder, int position) {
        recyclerData data1=data.get(position);
        holder.s1.setText(data1.getName());
        holder.img.setImageResource(data1.getImage());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}

