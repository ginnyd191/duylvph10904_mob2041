package com.example.qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class TrangChuActivity extends AppCompatActivity {
    ImageButton nguoidung, theloai, sach, hoadon, sachbanchay, thongke;
    private long backPressedTime;
    private Toast backToast;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
       nguoidung = findViewById(R.id.usermanage);
        theloai = findViewById(R.id.category);
        sach = findViewById(R.id.book);
        hoadon = findViewById(R.id.invoice);
        sachbanchay = findViewById(R.id.bestbook);
        thongke = findViewById(R.id.statistical);
        nguoidung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangChuActivity.this,NguoiDungActivity.class);
                startActivity(i);
            }
        });
        theloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangChuActivity.this,TheLoaiActivity.class);
                startActivity(i);
            }
        });
        sach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangChuActivity.this,SachActivity.class);
                startActivity(i);
            }
        });
        hoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangChuActivity.this,HoaDonActivity.class);
                startActivity(i);
            }
        });
        sachbanchay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangChuActivity.this,SachBanChayActivity.class);
                startActivity(i);
            }
        });
        thongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangChuActivity.this,ThongKeActivity.class);
                startActivity(i);
            }
        });

    }
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Bấm thêm lần nữa để thoát ứng dụng", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();

    }

}