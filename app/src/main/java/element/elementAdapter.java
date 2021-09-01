package element;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banha_services.MainActivity;
import com.example.banha_services.R;

import java.util.ArrayList;
import java.util.List;

import Firms.Firmsitem;

public class elementAdapter extends RecyclerView.Adapter <elementAdapter.elementHolder>implements Filterable {
    private List<Firmsitem> list;
    private Context context;
    List<Firmsitem> arrayList,arrayListFiltered;


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
        this.arrayList=data;
        this.arrayListFiltered=data;
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
        holder.call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = list.get(position).getPhone_number();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+0+ Integer.parseInt(phoneNumber)));
                context.startActivity(callIntent);
            }
        });


    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();

                List<Firmsitem> arrayListFilter = new ArrayList<Firmsitem>();

                if(constraint == null|| constraint.length() == 0) {
                    results.count = arrayList.size();
                    results.values = arrayList;
                } else {
                    for (Firmsitem itemModel : arrayList) {
                        if(itemModel.getName().contains(constraint.toString())) {
                            arrayListFilter.add(itemModel);
                        }
                    }
                    results.count = arrayListFilter.size();
                    results.values = arrayListFilter;

                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                list = (List<Firmsitem>)results.values;
                notifyDataSetChanged();

                if(arrayListFiltered.size() == 0) {
                    Toast.makeText(context, "Not Found", Toast.LENGTH_LONG).show();
                }

            }
        };
        return filter;
    }

    }

