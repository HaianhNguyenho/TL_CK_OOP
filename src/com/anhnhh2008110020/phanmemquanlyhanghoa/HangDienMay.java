package com.anhnhh2008110020.phanmemquanlyhanghoa;


import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class HangDienMay extends HangHoa{

    private long timeBH;

    private int congSuat;

    public HangDienMay(){
        super();
        this.timeBH = 0;
        this.congSuat = 0;
    }

    public HangDienMay(String maHang, String tenHang, double donGia, int soLuongTon, long timeBH, int congSuat) throws ParseException {
        super(maHang, tenHang, donGia, soLuongTon);
        this.timeBH = timeBH;
        this.congSuat = congSuat;
    }

    public long getTimeBH() {
        return timeBH;
    }

    public void setTimeBH(long timeBH) {
        if(timeBH >= 0){
            this.timeBH = timeBH;
        }else{
            System.out.println("Thoi gian bao hanh bao nhieu thang?");
        }
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        if(congSuat>0){
            this.congSuat = congSuat;
        }else{
            System.out.println("Cong suat bao nhieu KW?");
        }
    }
    Locale localeVN = new Locale("Vi", "VND");
    Locale localeKW = new Locale("VI","KW");
    NumberFormat tienVietNam = NumberFormat.getCurrencyInstance(localeVN);
    NumberFormat donViCongSuat = NumberFormat.getCurrencyInstance(localeKW);

    @Override
    public String toString() {
        return super.toString()+"HangDienMay [congSuat=" + donViCongSuat.format(congSuat) + ", timeBH=" + timeBH + "Tinh Tien: "+tienVietNam.format(tinhTien())+"]";
    }

    

    
}
