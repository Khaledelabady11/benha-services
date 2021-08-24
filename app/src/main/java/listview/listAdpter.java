package listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.banha_services.R;

import java.util.ArrayList;

public class listAdpter extends ArrayAdapter<userData> {
    private Context context;
    private ArrayList<userData>arrayList;
    public static class ViewHolder {
        TextView text;
        TextView text2;
        ImageView image;
    }

    public listAdpter(@NonNull Context context, ArrayList<userData> userData) {
        super(context, R.layout.listitem,userData);
        this.context=context;
        this.arrayList=userData;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        userData userData=getItem(position);
        ViewHolder viewHolder = new ViewHolder();
        if(convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem, parent, false);
            viewHolder.text = convertView.findViewById(R.id.txt1);
            viewHolder.text2 = convertView.findViewById(R.id.txt2);
            viewHolder.image = convertView.findViewById(R.id.circleImageView);
            convertView.setTag(viewHolder);
        }else{
            convertView.getTag();
        }
        viewHolder.text.setText(userData.getName());
        viewHolder.text2.setText(userData.getDiscription());
        viewHolder.image.setImageResource(userData.getImageId());
        return convertView;
        }
    }

