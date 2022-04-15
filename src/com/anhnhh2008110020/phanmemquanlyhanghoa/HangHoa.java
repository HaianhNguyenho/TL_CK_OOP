package com.anhnhh2008110020.phanmemquanlyhanghoa; 
//OOP: Object Oriented Programming

//Author: NguyenHoHaiAnh-2008110020-PM01
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public abstract class HangHoa {
    // lớp cha trừu tượng-abstract class
    // thuộc tính - attribute
    private String maHang;
    private String tenHang;
    private double donGia;
    private int soLuongTon;

    
    //method
    // Phương thức set get

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        if(maHang != null){
            this.maHang = maHang;
        }else{
            System.out.println("Ma hang khong duoc rong");
        }
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        //code rang buoc
        if(tenHang != null){
            this.tenHang = tenHang;
        }else{
            System.out.println("Ten hang khong duoc rong");
           
        }
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if(donGia > 0){
            this.donGia = donGia;
        }else{
            System.out.println("Don gia > 0");
        }
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
      if(soLuongTon>=0){
          this.soLuongTon = soLuongTon;
      }else{
          System.out.println("So luong ton >=0 ");
      }
    }

    
// Default Constructor
    public HangHoa(){

        
    }
// Paramenteried Constructor

    public HangHoa(String maHang, String tenHang, double donGia, int soLuongTon) {
        this.setMaHang(maHang);
        this.setTenHang(tenHang);
        this.setDonGia(donGia);
        this.setSoLuongTon(soLuongTon);
        
    }

    public double tinhTien(){
        return (getSoLuongTon() * getDonGia());
    }

    public static Date chuoiSangNgay(String chuoi) throws ParseException{
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = simpleDateFormat.parse(chuoi);
        return date;
    }

    public static String ngaySangChuoi(Date date){
        String ngay = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        ngay = simpleDateFormat.format(date);
        return ngay;
    }
    
    
    Locale localeVN = new Locale("Vi", "VN");
    Locale localeKW = new Locale("KW");
    NumberFormat tienVietNam = NumberFormat.getCurrencyInstance(localeVN);
    NumberFormat donViCongSuat = NumberFormat.getCurrencyInstance(localeKW);

    @Override
    public String toString() {
        return "HangHoa [donGia=" +tienVietNam.format(donGia) + ", maHang=" + maHang + ", soLuongTon=" + soLuongTon + ", tenHang="
                + tenHang + "]";
    }

    




}
