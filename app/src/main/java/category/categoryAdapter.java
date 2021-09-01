package category;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banha_services.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import com.example.banha_services.API.categoryitem;

import Firms.Firmsitem;
import element.ElementActivity;

public class categoryAdapter extends RecyclerView.Adapter <categoryAdapter.recyclerHolder>{
private List<categoryitem> cat_list;
private Context context;

    public class recyclerHolder extends RecyclerView.ViewHolder {
        private TextView s1;
        private ImageView img;
        private CardView cardView;
        public recyclerHolder(@NonNull View itemView) {
            super(itemView);
            s1=(TextView)itemView.findViewById(R.id.firstTxt);
            img=(ImageView)itemView.findViewById(R.id.imageview);
            cardView=(CardView)itemView.findViewById(R.id.card);
        }

    }

    public categoryAdapter(List<categoryitem> lists, Context context) {
    this.context=context;
    this.cat_list=lists;
    }
    @NonNull
    @Override
    public recyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerdesign,parent,false);
        recyclerHolder holder=new recyclerHolder(row);

        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.s1.setText(cat_list.get(position).getName());
       Picasso.get().load(cat_list.get(position).getIcon()).into(holder.img);
               holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ElementActivity.class);
                intent.putExtra("id",position+1);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cat_list.size();
    }


}

