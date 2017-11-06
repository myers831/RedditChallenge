package com.example.admin.redditchallenge.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.redditchallenge.R;
import com.example.admin.redditchallenge.model.Child;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Admin on 10/14/2017.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    List<Child> childList = new ArrayList<>();
    Context context;

    public RecycleViewAdapter(List<Child> childList) {
        this.childList = childList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Child child = childList.get(position);
        holder.child = child;
        Log.d(TAG, "onBindViewHolder: " + child.getData().getTitle());

        holder.tvTitle.setText(child.getData().getTitle());
        holder.tvAuthor.setText("Author: " + child.getData().getAuthor());
        holder.tvNumCount.setText("Comment Count: " + String.valueOf(child.getData().getNumComments()));
        holder.tvUp.setText("Up Likes: " + String.valueOf(child.getData().getUps()));
        holder.tvDown.setText("Down Dislikes: " + String.valueOf(child.getData().getDowns()));
        Glide.with(context).load(child.getData().getThumbnail()).into(holder.ivThumbNail);
    }

    @Override
    public int getItemCount() {
        return childList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Child child;
        ImageView ivThumbNail;
        TextView tvTitle, tvAuthor, tvNumCount, tvUp, tvDown;


        public ViewHolder(View itemView) {
            super(itemView);
/*
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ItemViewActivity.class);
                    intent.putExtra("result", result);
                    context.startActivity(intent);
                }
            });
    */

            ivThumbNail = itemView.findViewById(R.id.ivThumbNail);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvNumCount = itemView.findViewById(R.id.tvNumCount);
            tvUp = itemView.findViewById(R.id.tvUp);
            tvDown = itemView.findViewById(R.id.tvDown);

        }
    }
}
