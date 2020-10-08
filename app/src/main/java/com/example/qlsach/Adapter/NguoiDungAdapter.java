package com.example.qlsach.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qlsach.List.ListUser;
import com.example.qlsach.R;
import com.example.qlsach.SQlite.SQLNguoiDung;
import com.example.qlsach.model.NguoiDung;

import java.util.List;

public class NguoiDungAdapter extends BaseAdapter {
    List<NguoiDung> nguoiDungList;
    public NguoiDungAdapter(List<NguoiDung> nguoiDungList){
        this.nguoiDungList = nguoiDungList;
    }
    @Override
    public int getCount() {
        return nguoiDungList.size();
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
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hienthiuser, viewGroup, false);
        final TextView idUser = view.findViewById(R.id.id);
        TextView nameUser = view.findViewById(R.id.name);
        TextView phoneUser = view.findViewById(R.id.phone);
        TextView gmailUser = view.findViewById(R.id.gmail);
        idUser.setText(nguoiDungList.get(i).id );
        nameUser.setText(nguoiDungList.get(i).ten);
        phoneUser.setText(nguoiDungList.get(i).sdt);
        gmailUser.setText(nguoiDungList.get(i).gmail);
        view.findViewById(R.id.btnXoa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLNguoiDung sqlNguoiDung = new SQLNguoiDung(viewGroup.getContext());
                String id = nguoiDungList.get(i).id;
                boolean ketqua = sqlNguoiDung.xoaNguoiDung(id);
                if (ketqua){
                    Toast.makeText(viewGroup.getContext(),"Xóa thành công",Toast.LENGTH_SHORT).show();
                    nguoiDungList.remove(i);
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
