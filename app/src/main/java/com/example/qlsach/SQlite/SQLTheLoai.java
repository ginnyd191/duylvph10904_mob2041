package com.example.qlsach.SQlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.qlsach.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class SQLTheLoai extends SQLiteOpenHelper {
    public SQLTheLoai(@Nullable Context context) {
        super(context, "SQLiteTheLoai.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_TheLoai = "Create table TheLoai(ID text primary key , Name Nvarchar(50), ViTri Nvarchar(50), MoTa text)";
        db.execSQL(create_TheLoai);
    }
    public void addTheLoai(TheLoai theLoai){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID",theLoai.getId());
        contentValues.put("Name",theLoai.getTen());
        contentValues.put("ViTri",theLoai.getVitri());
        contentValues.put("MoTa",theLoai.getMota());
        db.insert("TheLoai",null,contentValues);
    }
    public List<TheLoai> getall(){
        List<TheLoai> theLoaiList = new ArrayList<>();
        String get_all = "SELECT * FROM TheLoai";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(get_all,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String id,name,vitri,mota;
            id = cursor.getString(0);
            name = cursor.getString(1);
            vitri = cursor.getString(2);
            mota = cursor.getString(3);
            TheLoai theLoai = new TheLoai(id,name,vitri,mota);
            theLoaiList.add(theLoai);
            cursor.moveToNext();
        }
        cursor.close();
        return theLoaiList;
    }
    public boolean xoaTheLoai(String id) {
        SQLiteDatabase db =getWritableDatabase();
        int kq = db.delete("TheLoai","ID = ?",new String[]{id});
        if (kq > 0){
            return true;
        }
        return false;
    }
    public void suaTheLoai(TheLoai theLoai) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", theLoai.id);
        contentValues.put("Name", theLoai.ten);
        contentValues.put("ViTri", theLoai.vitri);
        contentValues.put("MoTa", theLoai.mota);

        db.update("TheLoai", contentValues,
                "ID=?", new String[]{theLoai.getId()});
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
