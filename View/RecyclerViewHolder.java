package com.example.cyb.dynamicblur.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.cyb.dynamicblur.R;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
    }
}
