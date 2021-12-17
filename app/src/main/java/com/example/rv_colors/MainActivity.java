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

 static int counter;
  private ArrayList<Class_New_Modle_Item>  new_modle_item= new ArrayList<>();
  MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton Btn_Increase_Item= findViewById(R.id.Btn_Increase_Item);
        RecyclerView recyclerView =findViewById(R.id.RecyclerView_item);
int color = getRandomColor();

        new_modle_item.add(new Class_New_Modle_Item(getRandomColor(),"1","This is 1")) ;

        new_modle_item.add(new Class_New_Modle_Item(getRandomColor(),"2","This is 2")) ;

        new_modle_item.add(new Class_New_Modle_Item(getRandomColor(),"3","This is 3")) ;



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
                //counter+=1;
               // int num =new_modle_item.size()-1;
                new_modle_item.add(new Class_New_Modle_Item(getRandomColor(),"new","This is ")) ;
               myAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"new item",Toast.LENGTH_LONG).show();

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(new_modle_item);
        recyclerView.setAdapter(adapter);



    }
    public  void changeItem(int colorImage)
    {

    }
    public static int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}