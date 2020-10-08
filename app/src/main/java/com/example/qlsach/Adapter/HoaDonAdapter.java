package com.example.qlsach.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qlsach.R;
import com.example.qlsach.SQlite.SQLHoaDon;
import com.example.qlsach.SQlite.SQLNguoiDung;
import com.example.qlsach.model.HoaDon;

import java.util.List;

public class HoaDonAdapter extends BaseAdapter {
    List<HoaDon> hoaDonList;
    public HoaDonAdapter(List<HoaDon> hoaDonList){
        this.hoaDonList = hoaDonList;
    }
    @Override
    public int getCount() {
        return hoaDonList.size();
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
        view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hienthihoadon,viewGroup,false);
        TextView idHoaDon = view.findViewById(R.id.idhd);
        TextView date = view.findViewById(R.id.date);
        HoaDon hoaDon = hoaDonList.get(i);
        idHoaDon.setText(hoaDon.id);
        date.setText(hoaDon.ngay);
        view.findViewById(R.id.btnXoa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLHoaDon sqlHoaDon = new SQLHoaDon(viewGroup.getContext());
                String id = hoaDonList.get(i).id;
                boolean ketqua = sqlHoaDon.xoaHoaDon(id);
                if (ketqua){
                    Toast.makeText(viewGroup.getContext(),"Xóa thành công",Toast.LENGTH_SHORT).show();
                    hoaDonList.remove(i);
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
