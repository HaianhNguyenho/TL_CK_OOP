package com.anhnhh2008110020.phanmemquanlyhanghoa;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class HangThucPham extends HangHoa{
    //ke thua
    private Date ngaySanXuat;

    private Date ngayHetHan;

   private String nhaCungCap;

   public HangThucPham(){
       super();
       this.ngaySanXuat = null;
       this.ngayHetHan = null;
       this.nhaCungCap = "";
   }

    public HangThucPham(String maHang, String tenHang, double donGia, int soLuongTon, String ngaySanXuat, String ngayHetHan,
            String nhaCungCap) throws ParseException {
        super(maHang, tenHang, donGia, soLuongTon);
        this.ngaySanXuat = chuoiSangNgay(ngaySanXuat);
        this.ngayHetHan = chuoiSangNgay(ngayHetHan);
        this.nhaCungCap = nhaCungCap;
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        //code rang buoc
        if(ngayHetHan != null){
            if(ngayHetHan.after(this.ngaySanXuat));
        }else{
            System.out.println("Ngay Het Han phai sau ngay san xuat");
            this.ngayHetHan = new Date();
        }
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
    
    public boolean kiemtraHSD(){
        boolean isHetHan = false; //con han

        if(this.ngayHetHan.before(new Date())){
            isHetHan = true;
        }
        return isHetHan;
    }
    Locale localeVN = new Locale("Vi", "VND");
    NumberFormat tienVietNam = NumberFormat.getCurrencyInstance(localeVN);


    

    @Override
    public String toString() {
        return super.toString()+"HangThucPham [ngaySanXuat=" + ngaySangChuoi(getNgaySanXuat()) + ", ngayHetHan=" + ngaySangChuoi(getNgayHetHan()) + ", nhaCungCap=" + nhaCungCap
        + ", Tinh tien= "+tienVietNam.format(tinhTien())+"]";
}
    }
    
    
    

