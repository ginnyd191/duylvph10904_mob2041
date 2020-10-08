package com.example.qlsach.model;

public class Sach {
    public String idsach, tlsach, tensach, tacgia, nhaxuatban, dongia, soluong;

    public Sach(String idsach, String tlsach, String tensach, String tacgia, String nhaxuatban, String dongia, String soluong) {
        this.idsach = idsach;
        this.tlsach = tlsach;
        this.tensach = tensach;
        this.tacgia = tacgia;
        this.nhaxuatban = nhaxuatban;
        this.dongia = dongia;
        this.soluong = soluong;
    }

    public String getIdsach() {
        return idsach;
    }

    public void setIdsach(String idsach) {
        this.idsach = idsach;
    }

    public String getTlsach() {
        return tlsach;
    }

    public void setTlsach(String tlsach) {
        this.tlsach = tlsach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getNhaxuatban() {
        return nhaxuatban;
    }

    public void setNhaxuatban(String nhaxuatban) {
        this.nhaxuatban = nhaxuatban;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }
}