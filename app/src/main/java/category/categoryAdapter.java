package category;

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

import java.util.List;

import element.ElementActivity;

public class categoryAdapter extends RecyclerView.Adapter <categoryAdapter.recyclerHolder>{
private List<categoryData> data;
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

    public categoryAdapter(List<categoryData> data, Context context) {
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
        categoryData data1=data.get(position);
        holder.s1.setText(data1.getName());
        holder.img.setImageResource(data1.getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ElementActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}

