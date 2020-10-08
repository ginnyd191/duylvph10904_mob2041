package com.example.qlsach.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.qlsach.Adapter.TheLoaiAdapter;
import com.example.qlsach.DangkiActivity;
import com.example.qlsach.Passmanager.DoiMK;
import com.example.qlsach.R;
import com.example.qlsach.SQlite.SQLTheLoai;
import com.example.qlsach.TheLoaiActivity;
import com.example.qlsach.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class ListCategory extends AppCompatActivity {
    ListView listView;
    List<TheLoai> theLoaiList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_category);
        listView = findViewById(R.id.lvListCategory);
        theLoaiList=new ArrayList<>();
        SQLTheLoai sql = new SQLTheLoai(ListCategory.this);
        theLoaiList = sql.getall();
        TheLoaiAdapter theLoaiAdapter = new TheLoaiAdapter(theLoaiList);
        listView.setAdapter(theLoaiAdapter);
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
                Intent i = new Intent(ListCategory.this, TheLoaiActivity.class);
                startActivity(i);
                break;
            case R.id.menuchange:
                Toast.makeText(this,"Bạn chọn thay đổi mật khẩu",Toast.LENGTH_SHORT).show();
                Intent it = new Intent(ListCategory.this, DoiMK.class);
                startActivity(it);
                break;
            case R.id.menulog:
                Toast.makeText(this,"Bạn chọn đăng xuất",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListCategory.this, DangkiActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}