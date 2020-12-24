package com.romdal.recyclerview.recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.romdal.recyclerview.R;

public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public CheckBox cbLike;
    public ImageView ivImg, ivShare;//, ivLike
    public TextView tvLikeCount, tvUserName, tvPostText;
    private PostAdapter mAdapter;

    public PostViewHolder(@NonNull View itemView, PostAdapter postAdapter) {
        super(itemView);
        mAdapter = postAdapter;

        ivImg   = itemView.findViewById(R.id.iv_img);
      //  ivLike  = itemView.findViewById(R.id.iv_like);
        cbLike = itemView.findViewById(R.id.cb_like);
        ivShare = itemView.findViewById(R.id.iv_share);

        tvLikeCount = itemView.findViewById(R.id.tv_likecount);
        tvUserName  = itemView.findViewById(R.id.tv_username);
        tvPostText  = itemView.findViewById(R.id.tv_posttext);

      //  ivLike.setOnClickListener(this);//몇번째인지 모른다
        cbLike.setOnClickListener(this);
        ivShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //몇번째인지 구분
        int position = getAdapterPosition();

        switch (v.getId()){
            //case R.id.iv_like:
            case R.id.cb_like:
                mAdapter.onLikeClicked(position);
                break;
            case  R.id.iv_share:
                break;
        }
    }
}
