package com.example.qlsach.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.qlsach.Adapter.QuanLiSachAdapter;
import com.example.qlsach.DangkiActivity;
import com.example.qlsach.Passmanager.DoiMK;
import com.example.qlsach.R;
import com.example.qlsach.SQlite.SQLSach;
import com.example.qlsach.SachActivity;
import com.example.qlsach.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class ListBook extends AppCompatActivity {
    ListView listView;
    List<Sach> sachList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);
        listView = findViewById(R.id.lvSach);
        sachList =new ArrayList<>();
        SQLSach sql = new SQLSach(ListBook.this);
        sachList = sql.getall();
            QuanLiSachAdapter sachAdapter = new QuanLiSachAdapter(sachList);
       listView.setAdapter(sachAdapter);
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
                Intent i = new Intent(ListBook.this, SachActivity.class);
                startActivity(i);
                break;
            case R.id.menuchange:
                Toast.makeText(this,"Bạn chọn thay đổi mật khẩu",Toast.LENGTH_SHORT).show();
                Intent it = new Intent(ListBook.this, DoiMK.class);
                startActivity(it);
                break;
            case R.id.menulog:
                Toast.makeText(this,"Bạn chọn đăng xuất",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListBook.this, DangkiActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}