package listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.banha_services.R;

import java.util.ArrayList;

public class Hosptal_activity extends AppCompatActivity {
ArrayList<listview.userData>HospitalList=new ArrayList<>();
userData userData;
ListView listView;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosptal);
        listView=findViewById(R.id.hospital_lv);
        userData=new userData("Hospital","test",R.drawable.doc);
        for (int i=0;i<5;i++){
            HospitalList.add(userData);
        }
        listAdpter listAdpter=new listAdpter(this,HospitalList);
        listView.setAdapter(listAdpter);


    }
}