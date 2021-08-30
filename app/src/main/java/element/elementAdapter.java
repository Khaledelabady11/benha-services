package element;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banha_services.MainActivity;
import com.example.banha_services.R;

import java.util.List;

import Firms.Firmsitem;

public class elementAdapter extends RecyclerView.Adapter <elementAdapter.elementHolder>{
    private List<Firmsitem> list;
    private Context context;
    public class elementHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView desc;
        private Button call_btn;
        private TextView address;
        public elementHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            desc=(TextView)itemView.findViewById(R.id.description);
            address=(TextView)itemView.findViewById(R.id.address);
            call_btn=(Button)itemView.findViewById(R.id.btnCall);


        }

    }

    public elementAdapter(List<Firmsitem> data, Context context) {
        this.list = data;
        this.context = context;
    }

    @NonNull
    @Override
    public elementHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.elementdesign,parent,false);
        elementHolder holder=new elementHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull elementHolder holder, int position) {
      holder.name.setText(list.get(position).getName());
      holder.desc.setText(list.get(position).getDescribtion());
      holder.address.setText(list.get(position).getAdress());
      holder.call_btn.setText(list.get(position).getPhone_number());


        }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
