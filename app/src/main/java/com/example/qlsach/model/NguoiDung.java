package com.example.qlsach.model;

public class NguoiDung {
    public String id, ten, sdt, gmail;

    public NguoiDung(String id, String ten, String sdt, String gmail) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.gmail = gmail;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

}
