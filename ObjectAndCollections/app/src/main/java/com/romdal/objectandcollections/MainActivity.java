package com.romdal.objectandcollections;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.romdal.objectandcollections.model.PostItem;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<PostItem> listItem = new ArrayList<>();
        LinearLayout llScrollParent = findViewById(R.id.ll_scorll);

        //입력
        for (int i=0; i<5;i++){
            PostItem item = new PostItem(
                     true, 125
                    ,"irene","http://www.etoland.co.kr/data/daumeditor02/191110/78056515733891280.gif"
                    ,"wow!!"
                );
            listItem.add(i, item);
        }
        //출력
        for (PostItem item : listItem){
            View v = View.inflate(this, R.layout.post_item, null);
            TextView tvUserName = v.findViewById(R.id.tv_UserName);
            TextView tvPostText = v.findViewById(R.id.tv_PostText);

            tvUserName.setText(item.getUserName());
            tvPostText.setText(item.getPostText());

            llScrollParent.addView(v);
        }

    }
}
