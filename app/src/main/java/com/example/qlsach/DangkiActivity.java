package com.example.qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DangkiActivity extends AppCompatActivity {
Button btSignIn, btSignUp, btCancel;
EditText user, pass, repass, phone, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        btSignIn = findViewById(R.id.btnSignIn);
        btSignUp = findViewById(R.id.btnSignUp);
        btCancel = findViewById(R.id.btnCancel);
        user = findViewById(R.id.edtUsername);
        pass = findViewById(R.id.edtPassword);
        repass = findViewById(R.id.edtPass);
        phone = findViewById(R.id.edtPhone);
        email = findViewById(R.id.edtEmail);
        btSignUp.setOnClickListener(new View.OnClickListener() {
            public boolean validateEmail(CharSequence email) {
                return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }
            public  boolean validateNumber(CharSequence number){
                return  !TextUtils.isEmpty(number) && Patterns.PHONE.matcher(number).matches();
            }
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
                if (repass.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập lại mật khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(repass.length()<4) {
                    Toast.makeText(getApplicationContext(), "Mật khẩu phải ít nhất 4 kí tự", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!pass.getText().toString().equals(repass.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Mật khẩu không trùng khớp vui lòng nhập đúng mật khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (phone.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống số điện thoại", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (phone.length()!=10){
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đúng định dạng số điện thoại", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!validateNumber(phone.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đúng định dạng số điện thoại", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (email.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!validateEmail(email.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đúng định dạng email", Toast.LENGTH_SHORT).show();
                    return;
 //               }
//                    if(pass.getText().toString() != repass.getText().toString()){
//                        Toast.makeText(getApplicationContext(), "Vui lòng nhập đúng mật khẩu", Toast.LENGTH_SHORT).show();
//                        return;

                } else {
                    Toast.makeText(getApplicationContext(), "Đăng kí thành công, vui lòng đăng nhập", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(DangkiActivity.this, DangNhapActivity.class);
                    startActivity(i);
                }
            }
        });
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DangkiActivity.this,DangNhapActivity.class);
                startActivity(i);
            }
        });
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DangkiActivity.this,ChaoActivity.class);
                startActivity(i);
            }

        });


    }

}