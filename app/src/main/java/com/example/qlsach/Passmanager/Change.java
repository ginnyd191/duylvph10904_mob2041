package com.example.qlsach.Passmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.qlsach.R;
import com.example.qlsach.TrangChuActivity;

public class Change extends AppCompatActivity {
Button btChange, btCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thaydoi);
        btChange = findViewById(R.id.btnChange);
        btCancel = findViewById(R.id.btnCancel);
        btChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Thay đổi mật khẩu thành công",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Change.this, TrangChuActivity.class);
                startActivity(i);
            }
        });
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Change.this, TrangChuActivity.class);
                startActivity(i);
            }
        });
    }
}