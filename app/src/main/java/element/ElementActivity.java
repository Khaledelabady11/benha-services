package element;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.example.banha_services.R;

import java.util.ArrayList;
import java.util.List;

import category.categoryAdapter;
import category.categoryData;
import element.elementAdapter;
import element.elementData;

public class ElementActivity extends AppCompatActivity {

private  RecyclerView element;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosptal);

    List<elementData> arrayList = new ArrayList<>();
    elementData data2 = new elementData();
    data2.setName("Medical");
    data2.setPhone_number("01206458433");
   data2.setDesc("hdhhdhd");
   data2.setAddress("sdsd");
    arrayList.add(data2);

    element=(RecyclerView) findViewById(R.id.element_recycler);
    elementAdapter arrAdapter=new elementAdapter(arrayList,this);
    element.setLayoutManager(new GridLayoutManager(this,1));
    element.setAdapter(arrAdapter);


    }
}