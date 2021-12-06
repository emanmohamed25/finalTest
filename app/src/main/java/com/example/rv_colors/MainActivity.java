package com.example.rv_colors;

import androidx.appcompat.app.AppCompatActivity;
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

  int counter;
    static Class_New_Modle_Item  new_modle_item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton Btn_Increase_Item= findViewById(R.id.Btn_Increase_Item);
        RecyclerView recyclerView =findViewById(R.id.RecyclerView_item);
        counter++;
        new_modle_item =new Class_New_Modle_Item(getRandomColor(),counter+"","This is "+counter);
        ArrayList<Class_New_Modle_Item> Array_Of_Items = new ArrayList<>();
        Array_Of_Items.add(new_modle_item);
        counter++;
        Array_Of_Items.add(new_modle_item);
        counter++;

        Array_Of_Items.add(new_modle_item);

        //Array_Of_Items.add(R.color.New_Color,counter+"","This is "+counter);
                //= new Class_New_Modle_Item[3];
////        for (int i =0 ; i<3;i++)
//        {
//            Array_Of_Items[i] =new_modle_item;
//            counter++;
//        }


        Btn_Increase_Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                Array_Of_Items.add(new_modle_item);
                Toast.makeText(getApplicationContext(),"new item",Toast.LENGTH_LONG).show();

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(Array_Of_Items);
        recyclerView.setAdapter(adapter);



    }
    public int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}