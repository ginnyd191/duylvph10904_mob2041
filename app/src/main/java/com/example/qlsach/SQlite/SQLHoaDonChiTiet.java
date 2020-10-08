package com.example.qlsach.SQlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import com.example.qlsach.model.HoaDonChiTiet;


import java.util.ArrayList;
import java.util.List;

public class SQLHoaDonChiTiet extends SQLiteOpenHelper {
    public SQLHoaDonChiTiet(@Nullable Context context) {
        super(context, "SQLiteHoaDonChiTiet.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_HoaDonChiTiet = "Create table HoaDonChiTiet(IDHDCT text primary key , IDHD text, IDBook, SoLuong varchar(50))";
        db.execSQL(create_HoaDonChiTiet);
    }
    public void addHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("IDHoaDonChiTiet",hoaDonChiTiet.getIdhoadonchitiet());
        contentValues.put("IDHoaDon",hoaDonChiTiet.getIdhoadon());
        contentValues.put("IDSach",hoaDonChiTiet.getIdsach());
        contentValues.put("SoLuong",hoaDonChiTiet.getSoluong());
        db.insert("HoaDonChiTiet",null,contentValues);
    }
    public List<HoaDonChiTiet> getall(){
        List<HoaDonChiTiet> hoaDonChiTietList = new ArrayList<>();
        String get_all = "SELECT * FROM HoaDonChiTiet";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(get_all,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String idhdct,idhd,idsach,soluong;
            idhdct = cursor.getString(0);
            idhd = cursor.getString(1);
            idsach = cursor.getString(2);
            soluong = cursor.getString(3);
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(idhdct,idhd,idsach,soluong);
            hoaDonChiTietList.add(hoaDonChiTiet);
            cursor.moveToNext();
        }
        cursor.close();
        return hoaDonChiTietList;
    }
    public void xoaHDCT(String id) {
        SQLiteDatabase db =getWritableDatabase();
        db.delete("HoaDonChiTiet","ID = ?",new String[]{id});
    }
    public void suaHDCT(HoaDonChiTiet hoaDonChiTiet) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("IDHoaDonChiTiet", hoaDonChiTiet.getIdhoadonchitiet());
        contentValues.put("IDHoaDon", hoaDonChiTiet.getIdhoadon());
        contentValues.put("IDSach", hoaDonChiTiet.getIdsach());
        contentValues.put("SoLuong",hoaDonChiTiet.getSoluong());
        db.update("HoaDonChiTiet", contentValues,
                "ID=?", new String[]{hoaDonChiTiet.getIdhoadonchitiet()});
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
