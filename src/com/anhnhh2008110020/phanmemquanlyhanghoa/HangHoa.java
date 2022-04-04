package com.anhnhh2008110020.phanmemquanlyhanghoa; //OOP: Object Oriented Programming

//Author: NguyenHoHaiAnh-2008110020-PM01

public abstract class HangHoa {
    // lớp cha trừu tượng-abstract class
    // thuộc tính - attribute
    private String maHang;
    private String tenHang;
    private double donGia;
    private int soLuongTon;

    private static int count;

    //method
    // Phương thức set get

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    private void tangCount() {
        count++;
    }
    public abstract double danhGia();

// Default Constructor
    public HangHoa(){
        this.tangCount();
    }
// Paramenteried Constructor

    public HangHoa(String maHang, String tenHang, double donGia, int soLuongTon) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
    }

    @Override
    public String toString() {
        return "HangHoa [donGia=" + donGia + ", maHang=" + maHang + ", soLuongTon=" + soLuongTon + ", tenHang="
                + tenHang + "]";
    }

    




}
