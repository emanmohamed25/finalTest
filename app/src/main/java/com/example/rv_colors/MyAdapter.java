package com.example.rv_colors;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.AdapterViewHolder> {
   ArrayList<Class_New_Modle_Item> array_OF_Values_Item;

    public MyAdapter(ArrayList<Class_New_Modle_Item> array_of_items) {
        this.array_OF_Values_Item=array_of_items;
    }



    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view=  LayoutInflater.from(parent.getContext()).inflate(R.layout.the_item,parent,false);
        AdapterViewHolder adapter =new AdapterViewHolder(view);
        return adapter;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position)
    {
        Class_New_Modle_Item Temp_Values_Item = array_OF_Values_Item.get(position);
        holder.TV_Number_get_View.setText(Temp_Values_Item.number);
        holder.TextV_get_View.setText(Temp_Values_Item.Text);
        holder.image_get_View.setColorFilter(Temp_Values_Item.image);
    }




    @Override
    public int getItemCount()
    {
        return array_OF_Values_Item.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder
    {
       public ImageView image_get_View ;
        public TextView TextV_get_View , TV_Number_get_View ;
//        public void setImageColor(int color)
//        {
//            Random rnd = new Random();
//            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//            image_get_View.setBackgroundColor(color);
//        }

        public AdapterViewHolder(@NonNull View itemView)
        {
            super(itemView);
           // View item = itemView.findViewById(R.id.IdItem);
            image_get_View=itemView.findViewById(R.id.ImageView_Colcr);
            TV_Number_get_View=itemView.findViewById(R.id.TextView_Number);
            TextV_get_View=itemView.findViewById(R.id.TextView_Text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(),"#"+TV_Number_get_View.getText().toString(), Toast.LENGTH_LONG).show();
                }
            });


        }
    }
}


