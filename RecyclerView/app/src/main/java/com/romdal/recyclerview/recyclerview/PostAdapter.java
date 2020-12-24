package com.romdal.recyclerview.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.romdal.recyclerview.R;
import com.romdal.recyclerview.model.PostItem;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private Context mContext;
    private ArrayList<PostItem> postItems;

    public PostAdapter(Context mContext, ArrayList<PostItem> listItem) {
        this.mContext = mContext;
        this.postItems = listItem;
    }

    @NonNull
    @Override//필수
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View baseView =  View.inflate(mContext, R.layout.post_item, null);
        PostViewHolder postViewHolder = new PostViewHolder(baseView, this);
        return postViewHolder;
    }

    @Override//필수
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostItem item = postItems.get(position);
        holder.tvUserName.setText(item.getUserName());
        holder.tvPostText.setText(item.getPostText());
        holder.tvLikeCount.setText( String.valueOf( item.getPostLikeCount() ) );
    }

    @Override//필수
    public int getItemCount() {
        return postItems.size();
    }

    public void onLikeClicked(int position) {
        PostItem item = postItems.get(position);
        Toast.makeText(mContext, position + ":" + item.getPostText(), Toast.LENGTH_SHORT).show();
    }
}
