package com.romdal.ireneglide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    /**이미지 라이브러리 사용법 - LRU Cache - Glide*/
    //Glide 라이브러리 다운 오류
    ImageView ivIrene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivIrene = findViewById(R.id.iv_irene);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLoadingIreneImage();
            }
        });
    }

    private void startLoadingIreneImage() {
        //이미지가 안 나올때 권한이 필요한 경우 XML->uses-permission 추가
        String url = "http://blogfiles.naver.net/MjAxNzA3MjJfMTU1/MDAxNTAwNjgxOTA0MzMw.MQHT3Y_o6bE3NdyUZSX1ZZkfdPcaXTz6cwS4lqDFaPwg.7uX9aG1DeTHTEgsWlEHjNgb62vdrF7qJXOAkC0jEn3Mg.PNG.joyryu/%BC%D2%B3%FA%C0%A7%C3%E0%C1%F5_%C5%F5%BA%B4%C4%AB%C6%E4_-_%BA%B9%BB%E7%BA%BB.png";

        Glide.with(this).load(url).into(ivIrene);
    }
}
