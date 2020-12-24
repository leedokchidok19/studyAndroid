package com.romdal.objectandcollections.model;

public class PostItem {

    boolean isUserLike;
    //좋아요 갯수
    int postLikeCount;
    //유저명
    String userName;
    //이미지가 저장된 주소
    String postImgUrl;
    //텍스트
    String postText;
    //생성자 생성 : 우클릭 -> Generate...-> Constructor
    public PostItem(boolean isUserLike, int postLikeCount
                    , String userName, String postImgUrl, String postText) {
        this.isUserLike = isUserLike;
        this.postLikeCount = postLikeCount;
        this.userName = userName;
        this.postImgUrl = postImgUrl;
        this.postText = postText;
    }

    public boolean isUserLike() {
        return isUserLike;
    }

    public int getPostLikeCount() {
        return postLikeCount;
    }

    public String getUserName() {
        return userName;
    }

    public String getPostImgUrl() {
        return postImgUrl;
    }

    public String getPostText() {
        return postText;
    }
}
