package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    String[] names;
    int[] photos;
    Context context;

    RecyclerAdapter(Context context, String[] name, int[] photo){
        names = name;
        photos = photo;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_recycler, viewGroup,false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String name1 = names[i];
        int photo1 = photos[i];
        int r = new Random().nextInt(255-0+1) + 0;
        int g = new Random().nextInt(255-0+1) + 0;
        int b = new Random().nextInt(255-0+1) + 0;
        Drawable drawable = context.getResources().getDrawable(photo1);
        viewHolder.textv1.setText(name1);
        viewHolder.textv1.setTextColor(Color.rgb(r,g,b));
        viewHolder.textv1.setBackground(drawable);
        //viewHolder.imgv1.setImageResource(photo1);

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //ImageView imgv1;
        TextView textv1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //imgv1 = itemView.findViewById(R.id.imageView);
            textv1 = itemView.findViewById(R.id.textView);
        }
    }
}
