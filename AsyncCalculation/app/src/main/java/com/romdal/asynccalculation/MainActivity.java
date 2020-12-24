package com.romdal.asynccalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //LOGGING
    private TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tv_display);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAsyncCalculation();
            }
        });

    }

    private void startAsyncCalculation() {
        //excute(1, 100_000_000);
        AsyncCalculateTask task = new AsyncCalculateTask();
        task.execute(1, 100_000_000);
        //Integer max값
        //task.execute(1,Integer.MAX_VALUE);
    }

    class AsyncCalculateTask extends AsyncTask<Integer, Integer, Integer>{//넣을 값, 진행사항 값, 리턴 값
        /**UI Thread*/
    //    @Override
    //    protected void onPreExecute() {//시작 전
    //        super.onPreExecute();
    //    }

        /**Async Thread Method*/
        @Override
        protected Integer doInBackground(Integer... integers) {//(Integer... integers)가변형 매개변수 - 배열
            int number = integers[0];
            int count = integers[1];
            int result = 0;
            int percentUnit = count/100;

            for (int i = 0;i<count;i++){
                result += number;
                if (result % percentUnit == 0){//진행사항
                    //1% 3% 15%...
                    publishProgress(result/percentUnit);
                }
            }

            return null;
        }

        /**UI Thread*/
        @Override
        protected void onProgressUpdate(Integer... values) {//진행 사항
            super.onProgressUpdate(values);
            tvDisplay.setText(values[0] + " percent");//화면표시
            Log.d("AsyncCalculateTask", values[0] + " percent");//로그.레벨: 태그, 내용
        }

        /**UI Thread*/
        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            tvDisplay.setText("Result :" + integer);
        }

    }

}
