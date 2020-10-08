package com.example.qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class DangNhapActivity extends AppCompatActivity {
Button btLogin, btCancel;
EditText user, pass;
CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        btLogin = findViewById(R.id.btnLogin);
        btCancel = findViewById(R.id.btnCancel);
        user = findViewById(R.id.edtUsername);
        pass = findViewById(R.id.edtPassword);
        cb = findViewById(R.id.checkbox);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống tên đăng nhập", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (pass.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống mật khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(pass.length()<4){
                    Toast.makeText(getApplicationContext(), "Mật khẩu phải ít nhất 4 kí tự", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(cb.isChecked()==false){
                    Toast.makeText(getApplicationContext(), "Vui lòng nhớ mật khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(DangNhapActivity.this,TrangChuActivity.class);
                startActivity(i);

            }
        });
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DangNhapActivity.this,DangkiActivity.class);
                startActivity(i);
            }
        });
    }
}