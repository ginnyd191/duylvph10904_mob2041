package com.example.qlsach.Passmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.qlsach.R;
import com.example.qlsach.TrangChuActivity;

public class DoiMK extends AppCompatActivity {
Button btLogin, btCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doimk);
        btLogin = findViewById(R.id.btnLogin);
        btCancel = findViewById(R.id.btnCancel);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(DoiMK.this,Change.class);
                startActivity(i);
            }
        });
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DoiMK.this, TrangChuActivity.class);
                startActivity(i);
            }
        });
    }
}