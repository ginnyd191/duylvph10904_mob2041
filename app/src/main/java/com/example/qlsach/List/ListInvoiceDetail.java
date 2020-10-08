package com.example.qlsach.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.qlsach.Adapter.HoaDonChiTietAdapter;
import com.example.qlsach.Adapter.NguoiDungAdapter;
import com.example.qlsach.DangkiActivity;
import com.example.qlsach.NguoiDungActivity;
import com.example.qlsach.Passmanager.DoiMK;
import com.example.qlsach.R;
import com.example.qlsach.SQlite.SQLHoaDonChiTiet;
import com.example.qlsach.SQlite.SQLNguoiDung;
import com.example.qlsach.model.HoaDonChiTiet;
import com.example.qlsach.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class ListInvoiceDetail extends AppCompatActivity {

    ListView listView;
    List<HoaDonChiTiet> hoaDonChiTietList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_invoice_detail);
        listView = findViewById(R.id.listHDCT);
        hoaDonChiTietList =new ArrayList<>();
        SQLHoaDonChiTiet sql = new SQLHoaDonChiTiet(ListInvoiceDetail.this);
        hoaDonChiTietList = sql.getall();
        HoaDonChiTietAdapter hoaDonChiTietAdapter = new HoaDonChiTietAdapter(hoaDonChiTietList);
        listView.setAdapter(hoaDonChiTietAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.menuadd:
                Toast.makeText(this,"Bạn chọn thêm sách",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ListInvoiceDetail.this, NguoiDungActivity.class);
                startActivity(i);
                break;
            case R.id.menuchange:
                Toast.makeText(this,"Bạn chọn thay đổi mật khẩu",Toast.LENGTH_SHORT).show();
                Intent it = new Intent(ListInvoiceDetail.this, DoiMK.class);
                startActivity(it);
                break;
            case R.id.menulog:
                Toast.makeText(this,"Bạn chọn đăng xuất",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListInvoiceDetail.this, DangkiActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}