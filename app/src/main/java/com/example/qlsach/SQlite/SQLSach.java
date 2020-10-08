package com.example.qlsach.SQlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import com.example.qlsach.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class SQLSach extends SQLiteOpenHelper {
    public SQLSach(@Nullable Context context) {
        super(context, "SQLiteBook.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_Sach = "Create table Sach(IDSach text primary key , TheLoai Nvarchar(50), TenSach Nvarchar(50), TacGia Nvarchar(50), NhaXuatBan text, DonGia varchar(50), SoLuong varchar(50))";
        db.execSQL(create_Sach);
    }
    public void addSach(Sach sach){
        SQLiteDatabase sachs = getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("IDSach",sach.getIdsach());
        contentValues.put("TheLoai",sach.getTlsach());
        contentValues.put("TenSach",sach.getTensach());
        contentValues.put("TacGia",sach.getTacgia());
        contentValues.put("NhaXuatBan",sach.getNhaxuatban());
        contentValues.put("DonGia",sach.getDongia());
        contentValues.put("SoLuong",sach.getSoluong());
        sachs.insert("Sach",null,contentValues);
    }
    public List<Sach> getall(){
        List<Sach> sachList = new ArrayList<>();
        String get_all = "SELECT * FROM Sach";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(get_all,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String idsach,theloai,tensach,tacgia,nhaxuatban,dongia,soluong;
            idsach = cursor.getString(0);
            theloai = cursor.getString(1);
           tensach= cursor.getString(2);
            tacgia = cursor.getString(3);
            nhaxuatban = cursor.getString(4);
            dongia = cursor.getString(5);
            soluong = cursor.getString(6);
            Sach sach = new Sach(idsach,theloai,tensach,tacgia,nhaxuatban,dongia,soluong);
            sachList.add(sach);
            cursor.moveToNext();
        }
        cursor.close();
        return sachList;
    }
    public boolean xoaSach(String id) {
        SQLiteDatabase db =getWritableDatabase();
        int kq = db.delete("Sach","IDSach = ?",new String[]{id});
        if (kq > 0){
            return true;
        }
        return false;
    }
    public void suaSach(Sach sach) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("IDSach", sach.idsach);
        contentValues.put("TheLoai", sach.tlsach);
        contentValues.put("TenSach", sach.tensach);
        contentValues.put("TacGia", sach.tacgia);
        contentValues.put("NhaXuatBan",sach.nhaxuatban);
        contentValues.put("DonGia",sach.dongia);
        contentValues.put("SoLuong",sach.soluong);

        db.update("Sach", contentValues,
                "IDSach =?", new String[]{sach.getIdsach()});
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
