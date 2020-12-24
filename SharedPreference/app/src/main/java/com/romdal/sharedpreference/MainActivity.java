package com.romdal.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //default = -1 -> first user
    //user = 1
    public  static  final String SHARED_PREF_FIRST_USER_KEY = "1000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);

        TextView tvHello = findViewById(R.id.tv_hello);

        int fristUser =  sharedPref.getInt(SHARED_PREF_FIRST_USER_KEY, -1);

        if(fristUser == 1){
            //기존 유저
            //오늘도 감사합니다 호갱님
        //    tvHello.setText("오늘도 감사합니다 호갱님");
            //R.string.설정하는 방법 res->values->strings->strings.xml 클릭->xml형식에 맞게 추가->지구모양 클릭(korea클릭)->한국어 입력
            tvHello.setText(R.string.hellow_user);
        }else if(fristUser == -1){
            //최초 실행 유저
            //만나서 반갑습니다. 고갱님
        //    tvHello.setText("만나서 반갑습니다. 고갱님");
            tvHello.setText(R.string.hellow_first);
            saveUserIsNotFirst();
        }

 //       int defaultValue = getResources().getInteger(R.string.save_high_score_default);
        //long highScore = SharedPref.getInt(getString(R.string.save_high_score), defaultValue);
    }

    private void saveUserIsNotFirst() {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(SHARED_PREF_FIRST_USER_KEY, 1);
        editor.commit();
    }
}
