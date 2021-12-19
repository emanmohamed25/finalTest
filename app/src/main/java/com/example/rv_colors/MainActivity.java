package com.example.rv_colors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Class_New_Modle_Item> new_modle_item = new ArrayList<>();
    MyAdapter myAdapter = new MyAdapter(new_modle_item);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton Btn_Increase_Item = findViewById(R.id.Btn_Increase_Item);
        RecyclerView recyclerView = findViewById(R.id.RecyclerView_item);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdapter);


        new_modle_item.add(new Class_New_Modle_Item(getRandomColor(), "This is 1", "1"));

        new_modle_item.add(new Class_New_Modle_Item(getRandomColor(), "This is 2", "2"));

        new_modle_item.add(new Class_New_Modle_Item(getRandomColor(), "This is 3", "3"));


        Btn_Increase_Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index=new_modle_item.size()+1;

                new_modle_item.add(new Class_New_Modle_Item(getRandomColor(), "This is "+index, ""+index));
                myAdapter.notifyItemInserted(new_modle_item.size()+2);
                Toast.makeText(getApplicationContext(), "new item", Toast.LENGTH_LONG).show();

            }
        });


    }



    public static int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}