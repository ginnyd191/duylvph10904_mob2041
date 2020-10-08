package com.example.qlsach.model;

public class TheLoai {
    public String id, ten, vitri, mota;

    public TheLoai(String id, String ten, String vitri, String mota) {
        this.id = id;
        this.ten = ten;
        this.vitri = vitri;
        this.mota = mota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
