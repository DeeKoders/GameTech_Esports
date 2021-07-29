package com.example.gametech;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
  /*  String[] Names = {};
    String[] Price = {};*/
    int Images[] = {R.drawable.gm, R.drawable.gk, R.drawable.gmt};
    String Names[] = {"Gaming Mouse", "Gaming Keyboard", "Monitor"};
    String Description[] = {"Rs 3000", "Rs 5000", "Rs 10000"};

    FirebaseDatabase database;
    DatabaseReference myRef;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        String calledName = getIntent().getStringExtra("Name");

        /*database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("Categories").child("Mouse");
        int count = 0;
        myRef.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren())
                {

                    Names[count] = ds.getKey();
                    Price[count] = ds.getValue().toString();



                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }



        });*/
        ListView lv = findViewById(R.id.listview);
        ProductListAdapter pa = new ProductListAdapter();
        lv.setAdapter(pa);

    }
    public class ProductListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return Names.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.activity_productlist,null);
            ImageView iv = convertView.findViewById(R.id.productImage);
            TextView tv = (TextView)convertView.findViewById(R.id.productName);
            TextView tv1 = (TextView)convertView.findViewById(R.id.productPrice);
            tv.setText(Names[position]);
            tv1.setText(Description[position]);
            iv.setImageResource(Images[position]);


            return convertView;
        }
    }
}
