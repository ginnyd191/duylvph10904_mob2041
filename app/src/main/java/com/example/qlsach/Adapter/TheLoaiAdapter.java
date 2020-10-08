package com.example.qlsach.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qlsach.R;
import com.example.qlsach.SQlite.SQLNguoiDung;
import com.example.qlsach.SQlite.SQLSach;
import com.example.qlsach.SQlite.SQLTheLoai;
import com.example.qlsach.model.TheLoai;

import java.util.List;

public class TheLoaiAdapter extends BaseAdapter {
    List<TheLoai> theLoaiList;
    public TheLoaiAdapter(List<TheLoai> theLoaiList){
        this.theLoaiList = theLoaiList;
    }
    @Override
    public int getCount() {
        return theLoaiList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hienthitheloai,viewGroup,false);
        TextView idTheLoai = view.findViewById(R.id.idtheloai);
        TextView nameTheLoai = view.findViewById(R.id.tentheloai);
        TextView vitri = view.findViewById(R.id.vitri);
        TextView mota = view.findViewById(R.id.mota);
        TheLoai theLoai = theLoaiList.get(i);
        idTheLoai.setText(theLoai.id);
        nameTheLoai.setText(theLoai.ten);
        vitri.setText(theLoai.vitri);
        mota.setText(theLoai.mota);
        view.findViewById(R.id.btnXoa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLTheLoai sqlTheLoai= new SQLTheLoai(viewGroup.getContext());
                String id = theLoaiList.get(i).id;
                boolean ketqua = sqlTheLoai.xoaTheLoai(id);
                if (ketqua){
                    Toast.makeText(viewGroup.getContext(),"Xóa thành công",Toast.LENGTH_SHORT).show();
                    theLoaiList.remove(i);
                    notifyDataSetChanged();
                }
                else {
                    Toast.makeText(viewGroup.getContext(),"Xóa không thành công",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
