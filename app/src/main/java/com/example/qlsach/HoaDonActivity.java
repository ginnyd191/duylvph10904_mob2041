package com.example.qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlsach.List.ListInvoice;
import com.example.qlsach.List.ListUser;
import com.example.qlsach.SQlite.SQLHoaDon;
import com.example.qlsach.SQlite.SQLNguoiDung;
import com.example.qlsach.model.HoaDon;
import com.example.qlsach.model.NguoiDung;

public class HoaDonActivity extends AppCompatActivity {
Button btAdd, btShow, btCancel;
EditText id, date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);
        id = findViewById(R.id.edtIDInvoice);
        date = findViewById(R.id.edtDate);
        btAdd = findViewById(R.id.btnAdd);
        btShow = findViewById(R.id.btnShow);
        btCancel = findViewById(R.id.btnCancel);
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HoaDonActivity.this, TrangChuActivity.class);
                startActivity(i);
            }
        });
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống ID thể loại", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (date.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống ngày xuất hóa đơn", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    SQLHoaDon sqlHoaDon = new SQLHoaDon(HoaDonActivity.this);
                    HoaDon hoaDon = new HoaDon(id.getText().toString(), date.getText().toString());
                    sqlHoaDon.addHoaDon(hoaDon);
                    Intent i = new Intent(HoaDonActivity.this, ListInvoice.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HoaDonActivity.this, ListInvoice.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Hiển thị thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }

}