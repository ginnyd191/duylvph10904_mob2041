package com.example.qlsach.model;

public class HoaDonChiTiet {
    String idhoadonchitiet, idhoadon, idsach, soluong;

    public HoaDonChiTiet(String idhoadonchitiet, String idhoadon, String idsach, String soluong) {
        this.idhoadonchitiet = idhoadonchitiet;
        this.idhoadon = idhoadon;
        this.idsach = idsach;
        this.soluong = soluong;
    }

    public String getIdhoadonchitiet() {
        return idhoadonchitiet;
    }

    public void setIdhoadonchitiet(String idhoadonchitiet) {
        this.idhoadonchitiet = idhoadonchitiet;
    }

    public String getIdhoadon() {
        return idhoadon;
    }

    public void setIdhoadon(String idhoadon) {
        this.idhoadon = idhoadon;
    }

    public String getIdsach() {
        return idsach;
    }

    public void setIdsach(String idsach) {
        this.idsach = idsach;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }
}
