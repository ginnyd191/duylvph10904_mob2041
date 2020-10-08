package com.example.qlsach.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.qlsach.R;
import com.example.qlsach.model.HoaDonChiTiet;

import java.util.List;

public class HoaDonChiTietAdapter extends BaseAdapter {
    List<HoaDonChiTiet> hoaDonChiTietList;
    public HoaDonChiTietAdapter(List<HoaDonChiTiet> hoaDonChiTietList){
        this.hoaDonChiTietList = hoaDonChiTietList;
    }
    @Override
    public int getCount() {
        return hoaDonChiTietList.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hienthihoadonchitiet,viewGroup,false);
        TextView idHDCT = view.findViewById(R.id.idhdct);
        TextView idHoaDon = view.findViewById(R.id.idhd);
        TextView idSach = view.findViewById(R.id.idsach);
        TextView idSoLuong = view.findViewById(R.id.soluong);
        HoaDonChiTiet hdct= hoaDonChiTietList.get(i);
        idHDCT.setText(hdct.getIdhoadonchitiet());
        idHoaDon.setText(hdct.getIdhoadon());
        idSach.setText(hdct.getIdsach());
        idSoLuong.setText(hdct.getSoluong());
        return view;
    }
}
