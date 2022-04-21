package com.anhnhh2008110020.phanmemquanlyhanghoa;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class HangSanhSu extends HangHoa{
    private String nhaSanXuat;
    private Date ngayNhapKho;

    public HangSanhSu(){
        super();
        this.nhaSanXuat = "";
        this.ngayNhapKho = null;
    }

    public HangSanhSu(String maHang, String tenHang, double donGia, int soLuongTon, String nhaSanXuat,
            String ngayNhapKho) throws ParseException{
        super(maHang, tenHang, donGia, soLuongTon);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = chuoiSangNgay(ngayNhapKho);
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }

    public void setNgayNhapKho(Date ngayNhapKho) {
        this.ngayNhapKho = ngayNhapKho;
    }
    Locale localeVN = new Locale("Vi", "VND");
    NumberFormat tienVietNam = NumberFormat.getCurrencyInstance(localeVN);

    @Override
    public String toString() {
        return super.toString()+ "HangSanhSu [ngayNhapKho=" + ngaySangChuoi(ngayNhapKho) + ", nhaSanXuat=" + nhaSanXuat + ",Tinh Tien: "+tienVietNam.format(tinhTien())+"]";
    }

    

    
    
}
