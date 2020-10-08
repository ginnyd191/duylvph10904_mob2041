package com.example.qlsach.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qlsach.R;
import com.example.qlsach.SQlite.SQLSach;
import com.example.qlsach.model.Sach;

import java.util.List;

public class QuanLiSachAdapter extends BaseAdapter {
    List<Sach> sachList;
    public QuanLiSachAdapter(List<Sach> sachList){
        this.sachList = sachList;
    }
    @Override
    public int getCount() {
        return sachList.size();
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
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.showbook, viewGroup, false);
        final TextView idSach = view.findViewById(R.id.idsach);
        TextView tlBook = view.findViewById(R.id.theloai);
        TextView nameSach = view.findViewById(R.id.tensach);
        TextView tg = view.findViewById(R.id.tacgia);
        TextView nxb = view.findViewById(R.id.nhaxuatban);
        TextView dong = view.findViewById(R.id.dongia);
        TextView sl = view.findViewById(R.id.soluong);
        idSach.setText(sachList.get(i).idsach );
        tlBook.setText(sachList.get(i).tlsach);
        nameSach.setText(sachList.get(i).tensach);
        tg.setText(sachList.get(i).tacgia);
        nxb.setText(sachList.get(i).nhaxuatban);
        dong.setText(sachList.get(i).dongia);
        sl.setText(sachList.get(i).soluong);
        view.findViewById(R.id.btnXoa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               SQLSach sqlSach = new SQLSach(viewGroup.getContext());
                String id = sachList.get(i).idsach;
                boolean ketqua = sqlSach.xoaSach(id);
                if (ketqua){
                    Toast.makeText(viewGroup.getContext(),"Xóa thành công",Toast.LENGTH_SHORT).show();
                    sachList.remove(i);
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
