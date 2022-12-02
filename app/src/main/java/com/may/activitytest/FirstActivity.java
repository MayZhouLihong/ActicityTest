package com.may.activitytest;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

public class FirstActivity extends BaseActivity {

    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity", "Task id is "+getTaskId());
        setContentView(R.layout.first_layout);
        Button button1=(Button) findViewById(R.id.button_1);
        tvContent = (TextView) findViewById(R.id.tv_content);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
//                Intent intent=new Intent("com.may.activitytest.ACTION_START");
//                intent.addCategory("android.intent.category.MY_CATEGORY");
//                startActivity(intent);
//                Intent intent=new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                startActivity(intent);
//                Intent intent=new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
//                startActivity(intent);
//                String data="hello SecondActivity";
//                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
//                intent.putExtra("extra_data",data);
//                startActivity(intent);
//                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
//                startActivityForResult(intent,100);
                SecondActivity.actionStart(FirstActivity.this,"小明","小花");

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull @NotNull Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull @NotNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add",Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_LONG).show();
                break;

        }
        return true;

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FirstActivity", "onRestart");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 100:
                if (resultCode == RESULT_OK) {
                    String data_return = data.getStringExtra("data_return");
                    tvContent.setText(data_return);
                }
                break;
        }
    }
}