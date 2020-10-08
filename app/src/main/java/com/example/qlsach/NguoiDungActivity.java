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

import com.example.qlsach.List.ListUser;
import com.example.qlsach.SQlite.SQLNguoiDung;
import com.example.qlsach.model.NguoiDung;

public class NguoiDungActivity extends AppCompatActivity {
    Button btAdd, btList, btCancel,xoa;
    EditText id, phone, fullname, gmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung);
        btAdd = findViewById(R.id.btnAdd);
        btList = findViewById(R.id.btnList);
        id = findViewById(R.id.edtIDUser);
        phone = findViewById(R.id.edtPhoneUser);
        fullname = findViewById(R.id.edtFullName);
        gmail = findViewById(R.id.edtGmail);
        btCancel = findViewById(R.id.btnCancel);
        xoa = findViewById(R.id.btnXoa);
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NguoiDungActivity.this, TrangChuActivity.class);
                startActivity(i);
            }
        });

        btAdd.setOnClickListener(new View.OnClickListener() {
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
                if (fullname.length() == 0) {
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
                        SQLNguoiDung sqlNguoiDung = new SQLNguoiDung(NguoiDungActivity.this);
                        NguoiDung nguoiDung = new NguoiDung(id.getText().toString(), fullname.getText().toString(), phone.getText().toString(), gmail.getText().toString());
                        sqlNguoiDung.addNguoiDung(nguoiDung);
                        Intent i = new Intent(NguoiDungActivity.this, ListUser.class);
                        startActivity(i);
                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NguoiDungActivity.this, ListUser.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Hiển thị thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


