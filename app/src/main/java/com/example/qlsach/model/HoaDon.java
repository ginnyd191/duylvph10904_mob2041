package com.example.qlsach.model;


public class HoaDon {
    public String id, ngay;

    public HoaDon(String id, String ngay) {
        this.id = id;
        this.ngay = ngay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
}