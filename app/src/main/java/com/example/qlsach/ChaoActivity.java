package com.example.qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chao);
       setTitle("SachManager");
       Thread thread = new Thread(){
           @Override
           public void run() {
               super.run();
               int cho = 0;
               while (cho < 2000){
                   try {
                       sleep(1000);
                   }
                   catch (InterruptedException e){
                       e.printStackTrace();
                   }
                   cho += 500;
               }
               Intent i = new Intent(ChaoActivity.this,DangkiActivity.class);
               i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
               startActivity(i);
               finish();
           }
       };
       thread.start();
    }
}