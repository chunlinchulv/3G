package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BrotherAdapter extends RecyclerView.Adapter<BrotherAdapter.ViewHolder> {
    private List<Brother> mBrotherList;
    //为什么用static（内部类都要用static修饰，可直接用类名.调用）
    static class ViewHolder extends RecyclerView.ViewHolder {

        View brotherView;
        ImageView brotherPicture;
        TextView brotherDescription;

        public ViewHolder(View view) {
            super(view);
            brotherView = view;
            brotherPicture = (ImageView)view.findViewById(R.id.brother_picture);
            brotherDescription = (TextView)view.findViewById(R.id.brother_description);
        }
    }

    public BrotherAdapter(List<Brother> brotherList) {
        mBrotherList = brotherList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //返回的类型为RecyclerView.ViewHolder和为ViewHolder有什么不同?
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.brother_item,parent,false);

        final ViewHolder holder = new ViewHolder(view);
        holder.brotherView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Brother brother = mBrotherList.get(position);
                Toast.makeText(view.getContext(),"你点击了"+brother.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.brotherPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Brother brother = mBrotherList.get(position);
                Toast.makeText(view.getContext(), "你点击了"+brother.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }


    public void onBindViewHolder(ViewHolder holder, int position) {
        Brother brother = mBrotherList.get(position);
        holder.brotherPicture .setImageResource(brother.getImageId());
        holder.brotherDescription.setText(brother.getName());
    }

    @Override
    public int getItemCount() {
        return mBrotherList.size();
    }
}