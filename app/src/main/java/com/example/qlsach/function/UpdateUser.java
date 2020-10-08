package com.example.qlsach.function;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlsach.List.ListUser;
import com.example.qlsach.R;
import com.example.qlsach.SQlite.SQLNguoiDung;
import com.example.qlsach.model.NguoiDung;

public class UpdateUser extends AppCompatActivity {
EditText id,name,phone,gmail;
Button btUpdate,btCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        id = findViewById(R.id.edtIDUser);
        name = findViewById(R.id.edtFullName);
        phone = findViewById(R.id.edtPhoneUser);
        gmail = findViewById(R.id.edtGmail);
        btUpdate = findViewById(R.id.btnUpdate);
        btCancel = findViewById(R.id.btnCancel);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            public boolean validateEmail(CharSequence email) {
                return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }
            public  boolean validateNumber(CharSequence number){
                return  !TextUtils.isEmpty(number) && Patterns.PHONE.matcher(number).matches();
            }
            @Override
            public void onClick(View view) {
                if (id.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống ID Người dùng", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (name.length() == 0) {
                    Toast.makeText(getApplicationContext(), "không được để trống họ tên", Toast.LENGTH_SHORT).show();
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

                if (gmail.length() == 0) {
                    Toast.makeText(getApplicationContext(), "không được để trống gmail", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!validateEmail(gmail.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đúng định dạng email", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Toast.makeText(getApplicationContext(), "Thay đổi thành công", Toast.LENGTH_SHORT).show();
                    SQLNguoiDung sqlNguoiDung = new SQLNguoiDung(UpdateUser.this);
                    NguoiDung nguoiDung = new NguoiDung(id.getText().toString(), name.getText().toString(), phone.getText().toString(), gmail.getText().toString());
                    sqlNguoiDung.suaNguoiDung(nguoiDung);
                    Intent i = new Intent(UpdateUser.this, ListUser.class);
                    startActivity(i);
                }
            }
        });
btCancel.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i = new Intent(UpdateUser.this,ListUser.class);
        startActivity(i);
    }
});
    }


}