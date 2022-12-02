package com.may.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends BaseActivity {
    public static void actionStart(Context context,String data1,String data2){
        Intent intent=new Intent(context,SecondActivity.class);
        intent.putExtra("parma1",data1);
        intent.putExtra("parma2",data2);
        context.startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondActivity", "Task id is "+getTaskId());
        setContentView(R.layout.activity_second);
        TextView tvContent = findViewById(R.id.tv_content);
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String data="hello FirstActivity";
//                Intent intent=new Intent();
//                intent.putExtra("data_return",data);
//                setResult(RESULT_OK,intent);
//                finish();

                Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);

            }

        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity", "onDestroy");
    }
}