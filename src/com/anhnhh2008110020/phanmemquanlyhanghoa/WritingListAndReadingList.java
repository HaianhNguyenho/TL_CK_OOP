package com.anhnhh2008110020.phanmemquanlyhanghoa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class WritingListAndReadingList {
    //1 write list object

    // 2 read data from file
    public void writeToFile(List<HangThucPham> list1,List<HangDienMay> list2, List<HangSanhSu> list3){
        try{
            FileWriter fw = new FileWriter("data.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (HangThucPham hangThucPham : list1) {
                bw.write(hangThucPham.toString());
                bw.newLine();
                
            }
            for (HangDienMay hangDienMay : list2) {
                bw.write(hangDienMay.toString());
                bw.newLine();
            }
            for (HangSanhSu hangSanhSu : list3) {
                bw.write(hangSanhSu.toString());
                bw.newLine();
            }

            bw.close();
            fw.close();
        }catch (Exception e){
    
        }
    }
    public List<HangThucPham> readFromFile(){
        List<HangThucPham> list1 = new ArrayList<>();
        try{
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
           while(true){
               
               line = br.readLine();
               if(line == null){
                 break;
               }
               String txt[] = line.split("");
               String maHang = txt[0];
               String tenHang = txt[1];
               Double donGia = Double.parseDouble(txt[3]);
               int soLuongTon = Integer.parseInt(txt[4]);
               String ngaySanXuat = txt[5];
               String ngayHetHan = txt[6];
               String nhaCungCap = txt[7];
              list1 .add(new HangThucPham(maHang, tenHang, donGia, soLuongTon, ngaySanXuat, ngayHetHan, nhaCungCap));
           }
        }catch (Exception e){}
        return list1;
    }
    public List<HangDienMay> readFromFile2(){
        List<HangDienMay> list2 = new ArrayList<>();
        try{
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
           while(true){
               
               line = br.readLine();
               if(line == null){
                 break;
               }
               String txt[] = line.split("");
               String maHang = txt[0];
               String tenHang = txt[1];
               Double donGia = Double.parseDouble(txt[3]);
               int soLuongTon = Integer.parseInt(txt[4]);
              long timeBH = Long.parseLong(txt[5]);
              int congSuat = Integer.parseInt(txt[6]);
              list2 .add(new HangDienMay(maHang, tenHang, donGia, soLuongTon, timeBH, congSuat));
           }
        }catch (Exception e){}
        return list2;
    }
    public List<HangSanhSu> readFromFile3(){
        List<HangSanhSu> list3 = new ArrayList<>();
        try{
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
           while(true){
               
               line = br.readLine();
               if(line == null){
                 break;
               }
               String txt[] = line.split("");
               String maHang = txt[0];
               String tenHang = txt[1];
               Double donGia = Double.parseDouble(txt[3]);
               int soLuongTon = Integer.parseInt(txt[4]);
              String nhaSanXuat = txt[5];
              String ngayNhapKho = txt[6];

              list3 .add(new HangSanhSu(maHang, tenHang, donGia, soLuongTon, nhaSanXuat, ngayNhapKho));
           }
        }catch (Exception e){}
        return list3;
    }
    
    public static void main(String[] args) throws ParseException{
        WritingListAndReadingList m = new WritingListAndReadingList();
        List<HangThucPham> list1 = m.readFromFile();
        for (HangThucPham hangThucPham : list1) {
            System.out.println(hangThucPham);
        }
        List<HangDienMay> list2 = m.readFromFile2();
        for (HangDienMay hangDienMay : list2) {
            System.out.println(hangDienMay);
        }
        List<HangSanhSu> list3 = m.readFromFile3();
        for (HangSanhSu hangSanhSu : list3) {
            System.out.println(hangSanhSu);
        }
    
  
    }
    
}
