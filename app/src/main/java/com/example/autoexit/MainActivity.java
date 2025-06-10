package com.example.autoexit;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 显示一个简短的提示
        Toast.makeText(this, "应用正在退出...", Toast.LENGTH_SHORT).show();
        
        // 延迟500毫秒后退出应用，以便Toast能够显示
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 结束当前活动
                finish();
                
                // 确保应用完全退出，不留后台进程
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
            }
        }, 500);
    }
} 