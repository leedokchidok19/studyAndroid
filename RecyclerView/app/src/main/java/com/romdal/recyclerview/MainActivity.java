package com.romdal.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.romdal.recyclerview.model.PostItem;
import com.romdal.recyclerview.recyclerview.PostAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<PostItem> listItem = new ArrayList<>();
        RecyclerView rvList = findViewById(R.id.rv_list);
        //ViewHolder
        //입력
        for (int i=0; i<30;i++){
            PostItem item = new PostItem(
                    true, 125
                    ,"irene","http://www.etoland.co.kr/data/daumeditor02/191110/78056515733891280.gif"
                    ,"wow!!"
            );
            listItem.add(i, item);
        }

        PostAdapter adapter = new PostAdapter(this, listItem);
        rvList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) );
        rvList .setAdapter(adapter);

    }
}
