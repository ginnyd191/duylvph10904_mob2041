package com.example.qlsach.SQlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.qlsach.model.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class SQLHoaDon extends SQLiteOpenHelper {
    public SQLHoaDon(@Nullable Context context) {
        super(context, "SQLiteHoaDon.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_HoaDon = "Create table HoaDon(ID text primary key , Date date)";
        db.execSQL(create_HoaDon);
    }
    public void addHoaDon(HoaDon hoaDon){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID",hoaDon.getId());
        contentValues.put("Date",hoaDon.getNgay());
        db.insert("HoaDon",null,contentValues);
    }
    public List<HoaDon> getall(){
        List<HoaDon> hoaDonList = new ArrayList<>();
        String get_all = "SELECT * FROM HoaDon";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(get_all,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String id,date;
            id = cursor.getString(0);
            date = cursor.getString(1);
            HoaDon hoaDon = new HoaDon(id,date);
            hoaDonList.add(hoaDon);
            cursor.moveToNext();
        }
        cursor.close();
        return hoaDonList;
    }
    public boolean xoaHoaDon(String id) {
        SQLiteDatabase db =getWritableDatabase();
       int kq = db.delete("HoaDon","ID = ?",new String[]{id});
        if (kq > 0){
            return true;
        }
        return false;
    }
    public void suaHoaDon(HoaDon hoaDon) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", hoaDon.id);
        contentValues.put("Date", hoaDon.ngay);
        db.update("HoaDon", contentValues,
                "ID=?", new String[]{hoaDon.getId()});
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
