package com.example.parcelableexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.MyViewHolder> {

    ArrayList<ExampleItem> arrayList;

    Context context;
    OnItemClickListener mListener;

//    Create Listener interface to perform action event on item which is located in recyclerView.
    interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnClickListener(OnItemClickListener listener){
        mListener = listener;
    }
    public ExampleAdapter(ArrayList<ExampleItem> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.example_item, parent, false);
        return new MyViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(arrayList.get(position).getImageResourceId());
        holder.textView1.setText(arrayList.get(position).getLine1());
        holder.textView2.setText(arrayList.get(position).getLine2());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView1, textView2;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {

            super(itemView);
            imageView = itemView.findViewById(R.id.iv_icons);
            textView1 = itemView.findViewById(R.id.tv_line1);
            textView2 = itemView.findViewById(R.id.tv_line2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
