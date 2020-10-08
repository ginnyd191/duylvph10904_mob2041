package com.example.qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlsach.List.ListCategory;
import com.example.qlsach.List.ListUser;
import com.example.qlsach.SQlite.SQLNguoiDung;
import com.example.qlsach.SQlite.SQLTheLoai;
import com.example.qlsach.model.NguoiDung;
import com.example.qlsach.model.TheLoai;

public class TheLoaiActivity extends AppCompatActivity {
    Button btAdd, btShow, btCancel;
    EditText id, name, vitri, mota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);
        id = findViewById(R.id.edtIDUser);
        name = findViewById(R.id.edtNameBook);
        vitri = findViewById(R.id.edtLocation);
        mota = findViewById(R.id.edtMoTa);
        btAdd = findViewById(R.id.btnAdd);
        btShow = findViewById(R.id.btnShow);
        btCancel = findViewById(R.id.btnCancel);
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TheLoaiActivity.this, TrangChuActivity.class);
                startActivity(i);
            }
        });
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống ID Thể Loại", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (name.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống tên sách", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (vitri.length() == 0) {
                    Toast.makeText(getApplicationContext(), "không được để trống vị trí", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mota.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống mô tả", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    SQLTheLoai sqlTheLoai = new SQLTheLoai(TheLoaiActivity.this);
                    TheLoai theLoai = new TheLoai(id.getText().toString(), name.getText().toString(), vitri.getText().toString(), mota.getText().toString());
                    sqlTheLoai.addTheLoai(theLoai);
                    Intent i = new Intent(TheLoaiActivity.this, ListCategory.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TheLoaiActivity.this, ListCategory.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Hiển thị thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}