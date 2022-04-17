package com.anhnhh2008110020.phanmemquanlyhanghoa;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class ListHangHoa {


    private ArrayList<HangHoa> listHH;
   private Scanner varInput = new Scanner(System.in);
    ListHangHoa(){
        listHH = new ArrayList<HangHoa>();
    }
    public ArrayList<HangHoa> getDanhSach(){
        return listHH;
    }
    public void setDanhSach(ArrayList<HangHoa> listHH){
        this.listHH = listHH;
    }

    //Phuong thuc them hang hoa
    public void themHangHoa(HangHoa ha) throws ParseException{
        int bienDem = 0;
        for(int i=0; i < listHH.size();i++){
            HangHoa hangHoa = listHH.get(i);
            if(hangHoa.getMaHang().equalsIgnoreCase(ha.getMaHang()) || hangHoa.getMaHang().equalsIgnoreCase("Hang Thuc Pham") || hangHoa.getMaHang().equalsIgnoreCase("Hang Dien May") || hangHoa.getMaHang().equalsIgnoreCase("Hang Sanh SU")){
                System.out.println("Bi trung hang hoa.Vui long thu lai!!!");
                bienDem++;
               themHH();
                break;
            }
        }
        if(bienDem == 0){
            listHH.add(ha);
        }
        //The hien tinh da hinh - polymorphism
        //lua chon nhap thong tin
    }
    public void themHH() throws ParseException{
        System.out.println("======== Cac loai hang hoa=========");
        System.out.println("1. Hang Thuc Pham");
        System.out.println("2. Hang Dien may");
        System.out.println("3. Hang Sanh Su");
        System.out.println("============ Thoat============");
        System.out.print("Su lua chon (1-3): ");
        int suLuaChon = varInput.nextInt();
        HangHoa ha;
        switch(suLuaChon){
            case 1:{
            //Loai hang thuc pham
            System.out.print("Nhap thong tin hang thuc pham nhap kho");
            varInput.nextLine();
            System.out.print("\nNhap ma hang hoa: ");
            String maHH = varInput.nextLine();
            System.out.print("Nhap ten hang hoa: ");
            String tenHH = varInput.nextLine();
            System.out.print("Nhap so luong ton kho: ");
            int soluongTonKho = varInput.nextInt();
            System.out.print("Nhap don gia: ");
            double donGia = varInput.nextDouble();
            System.out.print("Nhap ngay het han: ");
            String ngayHetHan = varInput.next();
            System.out.print("Nhap ngay san xuat: ");
            String ngaySanXuat = varInput.next();
            System.out.print("Nha cung cap: ");
            String nhaCungCap = varInput.next();
            ha = new HangThucPham(maHH, tenHH, donGia, soluongTonKho, ngaySanXuat, ngayHetHan, nhaCungCap);
            themHangHoa(ha);
            
            break; //ngắt
            }

            case 2:{
            //loai hang dien may
            System.out.println(" Nhap thong tin hang dien tu nhap kho ");
            varInput.nextLine();
            System.out.print("Nhap ma hang hoa: ");
            String mHang = varInput.nextLine();
            System.out.print("Nhap ten hang hoa: ");
            String tenHang = varInput.nextLine();
            
            System.out.print("Nhap so luong ton kho:");
            int soLuongTonKho = varInput.nextInt();
            System.out.print("Nhap don gia: ");
            double donG = varInput.nextDouble();
            System.out.print("Nhap thoi gian bao hanh: ");
            long thoiGianBaoHanh = varInput.nextLong();
            System.out.print("Nhap cong suat: ");
            int congS = varInput.nextInt();
            ha = new HangDienMay(mHang, tenHang, donG, soLuongTonKho, thoiGianBaoHanh, congS);

            themHangHoa(ha);
            break;
            }

            case 3: {
            //loai hang sanh su
            System.out.println("\nNhap thong tin hang sanh su nhap kho ");
            System.out.print("Nhap ma hang hoa: ");
            String idHang = varInput.nextLine();
            varInput.nextLine();
            System.out.println("Nhap ten hang hoa: ");
            String tenH = varInput.nextLine();
            System.out.println("Nhap so luong ton kho: ");
            int soLuong = varInput.nextInt();
            System.out.println("Nhap don gia: ");
            double gia = varInput.nextDouble();
            varInput.nextLine();
            System.out.println("Nha san xuat: ");
            String nhaSX = varInput.nextLine();
            System.out.println("Ngay nhap kho: ");
            String ngayNK = varInput.nextLine();
            ha = new HangSanhSu(idHang, tenH, gia, soLuong, nhaSX, ngayNK);

            themHangHoa(ha);
            break;
            }

            default:
            System.out.println("Nhap sai su lua chon!");
            break;

        }

    }
    //Phuong thuc sua hang hoa
    public void suaHangHoa() throws ParseException{
        System.out.print("Nhap ma hang can sua: ");
        String maHang = varInput.nextLine();
        
        varInput.nextLine();
       
        
        for(int i=0; i<listHH.size();i++){
            HangHoa ha = listHH.get(i);
            if(ha.getMaHang().equals(maHang)){
            if(ha instanceof HangThucPham){
                String[] maHH = maHang.split("Ma Hang ", 2);
                System.out.println(" Nhap thong tin hang hoa ");
                System.out.print("Nhap ten hang hoa: ");
                String tenHH = varInput.next();
                System.out.print("Nhap so luong ton kho: ");
                int soluongTonKho = varInput.nextInt();
                System.out.print("Nhap don gia: ");
                double donGia = varInput.nextDouble();
                System.out.print("Nhap ngay het han: ");
                String ngayHetHan = varInput.next();
                System.out.println("Nhap ngay San xuat: ");
                String ngaySanXuat = varInput.next();
                System.out.print("Nhap nha cung cap: ");
                String nhaCungCap = varInput.next();
                HangHoa h = new HangThucPham(maHH[1], tenHH, donGia, soluongTonKho, ngaySanXuat, ngayHetHan, nhaCungCap);
                listHH.add(listHH.indexOf(ha), h);
                listHH.remove(ha);

            }
            else if(ha instanceof HangDienMay){
                String[] mHang = maHang.split("Dien may", 2);
                System.out.println("Nhap thong tin hang dien may ");
                System.out.println("Nhap ten hang hoa: ");
                String tenHang = varInput.nextLine();
                System.out.println("Nhap so luong ton kho: ");
                int soLuongTonKho = varInput.nextInt();
                System.out.println("Nhap don gia: ");
                double donG = varInput.nextDouble();
                System.out.println("Nhap thoi gian bao hanh: ");
                long thoiGianBaoHanh = varInput.nextLong();
                System.out.println("Nhap cong suat: ");
                int congS = varInput.nextInt();
                HangHoa h = new HangDienMay(mHang[1], tenHang, donG, soLuongTonKho, thoiGianBaoHanh, congS);
                listHH.add(listHH.indexOf(ha),h);
                listHH.remove(ha);
            }
            else if(ha instanceof HangSanhSu){
                String[] idHang = maHang.split("Sanh su", 2);
                System.out.println("Nhap thong tin hang sanh su");
                    System.out.println("Nhap ten hang hoa: ");
                    String tenH = varInput.nextLine();
                    System.out.println("Nhap so luong ton kho: ");
                    int soLuongTonKho = varInput.nextInt();
                    System.out.println("Nhap don gia: ");
                    double gia = varInput.nextDouble();
                    System.out.println("Nhap nha san xuat");
                    String nhaSX = varInput.nextLine();
                    System.out.println("Nhap ngay nhap kho: ");
                    String ngayNK = varInput.nextLine();
                    HangHoa h = new HangSanhSu(idHang[1], tenH, gia, soLuongTonKho, nhaSX, ngayNK);
                    listHH .add(listHH.indexOf(ha),h);
                    listHH.remove(ha);
                
            }
          
            
        } 
       
        
         }
        
    }
    //Phuong thuc xoa hang hoa
    public void xoaHangHoaTheoMa(){
        System.out.print("Nhap ma hang can xoa: ");
        String maHang = varInput.nextLine();
        for(int i =0; i<listHH.size();i++){
            HangHoa ha = listHH.get(i);
            if(ha.getMaHang().equals(maHang)){
                listHH.remove(ha);
            }
        }

    }

    //Phuong thuc xuat hang hoa
    
    public void xuatHangThucPham(){
        System.out.println("Hang Thuc Pham");
        for(int i=0; i<1;i++){
            System.out.println();
            
        }
        System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang Hoa","So Luong ton Kho","Gia Nhap Kho","Ngay san xuat","Ngay het han","Nha cung cap","Tong gia tri");
        for(int i = 0;i<1;i++){
            System.out.println();
        }
        System.out.println();
        for (HangHoa hangHoa : listHH) {
            if(hangHoa instanceof HangThucPham){
                System.out.println(hangHoa);
            }
            
        }
        for(int i = 0; i<1; i++){
            System.out.println();
        }
        System.out.println();

    }
    public void xuatHangDienMay(){
        System.out.println("Hang Dien May");
        for(int i=0; i<1;i++){
            System.out.println();
        }
        System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang Hoa","So Luong ton Kho","Gia Nhap Kho","Thoi gian bao hanh","Cong suat","Tong gia tri");
        for(int i=0; i<1;i++){
            System.out.println();
        }
        System.out.println();
        for (HangHoa hangHoa : listHH) {
            if(hangHoa instanceof HangDienMay){
                System.out.println(hangHoa);
            }
        }
        for(int i =0; i<1; i++){
            System.out.println();
        }
        System.out.println();
    }

    public void xuatHangSanhSu(){
        System.out.println("Hang Sanh Su");
        for(int i=0; i<1;i++){
            System.out.println();
        }
        System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang Hoa","So Luong ton Kho","Gia Nhap Kho","Nha san xuat", "Ngay nhap kho","Tong gia tri");
        for(int i=0; i<1; i++){
            System.out.println();
        }
        System.out.println();
        for (HangHoa hangHoa : listHH) {
            if(hangHoa instanceof HangSanhSu){
                System.out.println(hangHoa);
            }
        }
        for(int i =0; i<1; i++){
            System.out.println();
        }
        System.out.println();
    }

    public void xuatHangThucPhamTrucTiep(HangHoa ha){
        for(int i = 0;i<1;i++){
            System.out.print("Xuat hang thuc pham");
        }
        System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang Hoa","So Luong ton Kho","Gia Nhap Kho","Ngay san xuat","Ngay het han","Nha cung cap","Tong gia tri");
        for(int i=0;i<1;i++){
            System.out.println();
        }
        System.out.println();
        System.out.println(ha);
        for(int i=0;i<1;i++){
            System.out.println();
        }
        System.out.println();
    }
    public void xuatHangDienMayTrucTiep(HangHoa ha){
        for(int i =0;i<1;i++){
            System.out.print("Xuat hang dien may");
        }
        System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang Hoa","So Luong ton Kho","Gia Nhap Kho","Thoi gian bao hanh","Cong suat","Tong gia tri");
        for(int i = 0;i<1;i++){
            System.out.println();
        }
        System.out.println();

    }
    public void xuatHangSanhSuTrucTiep(HangHoa ha){
        for(int i=0; i<1;i++){
            System.out.print("Xuat hang sanh su");
        }
        System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang Hoa","So Luong ton Kho","Gia Nhap Kho","Nha san xuat", "Ngay nhap kho","Tong gia tri");
        for(int i =0; i<1;i++){
            System.out.println();
        }
        System.out.println();
    }
    public void xuatHangThucPhamTheoDanhSach(ArrayList<HangHoa> arr){
        System.out.println("******Hang Thuc Pham*****");
        for(int i=0; i<1;i++){
            System.out.println("Xuat hang thuc pham");
        }
        System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang Hoa","So Luong ton Kho","Gia Nhap Kho","Ngay san xuat","Ngay het han","Nha cung cap","Tong gia tri");
        for(int i=0; i<1;i++){
            System.out.println();
        }
        System.out.println();
        for (HangHoa hangHoa : arr) {
            System.out.println(hangHoa);
        }
        for(int i=0; i<1;i++){
            System.out.println();
        }
        System.out.println();

    }
    public void xuatHangDienMayTheoDanhSach(ArrayList<HangHoa> arr){
        System.out.println("******Hang Dien May*****");
        for(int i=0; i<1;i++){
            System.out.println();
        }
        System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang Hoa","So Luong ton Kho","Gia Nhap Kho","Thoi gian bao hanh","Cong suat","Tong gia tri");
        for(int i=0; i<1;i++){
            System.out.println();
        }
        System.out.println();
        for (HangHoa hangHoa : listHH) {
            System.out.println(hangHoa);
        }
        for(int i=0; i<1;i++){
            System.out.println();
        }
        System.out.println();
    }
    public void xuatHangSanhSuTheoDanhSach(ArrayList<HangHoa> arr){
        System.out.println("******Hang Sanh Su*******");
        for(int i=0; i<1;i++){
            System.out.println();
        }
        System.out.println();
      
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang Hoa","So Luong ton Kho","Gia Nhap Kho","Nha san xuat", "Ngay nhap kho","Tong gia tri");
         for(int i =0; i<1;i++){
             System.out.println();
         }
         System.out.println();
         for (HangHoa hangHoa : listHH) {
             System.out.println(hangHoa);
         }
         for(int i=0; i<1;i++){
             System.out.println();
         }
         System.out.println();
    }     
    public void xuatALLHangHoa(){
        for(int i=0; i<listHH.size();i++){
            HangHoa ha = listHH.get(i);
            if(ha instanceof HangThucPham){
                xuatHangThucPhamTrucTiep(ha);
            }
            else if(ha instanceof HangDienMay){
                xuatHangSanhSuTrucTiep(ha);
            }
            else if(ha instanceof HangDienMay){
                xuatHangDienMayTrucTiep(ha);
            }
        }
    }
    //Phuong thuc sap xep tang giam hang hoa theo gia
    public void sapXepHangHoaTangDanTheoGia(){
        Collections.sort(listHH, new Comparator<HangHoa>() {

            @Override
            public int compare(HangHoa o1, HangHoa o2) {
             
                if(o1.getDonGia() < o2.getDonGia()){
                    return -1;
                }
                else{
                    if(o1.getDonGia() == o2.getDonGia()){
                        return 0;
                    }
                    else{
                        return 1;
                    }
                }
                
            }
            
        });
        xuatALLHangHoa();
    }
    public void sapXepHangHoaGiamDanTheoGia(){
        Collections.sort(listHH, new Comparator<HangHoa>() {

            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getDonGia()<o2.getDonGia()){
                    return 1;
                }
                else{
                    if(o1.getDonGia()==o2.getDonGia()){
                        return 0;
                    }
                    else{
                        return -1;
                    }
                }
            }
            
        });
        xuatALLHangHoa();
    }
    //phuong thuc sap xep theo loai va soLUong
    public void sapXepHangHoaTangDanTheoLoaiVaSoLuongTonKho(){
        ArrayList<HangHoa> listHH1 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> listHH2 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> listHH3 = new ArrayList<HangHoa>();
        for(int i=0; i<listHH.size(); i++){
            HangHoa ha = listHH.get(i);
            if(ha instanceof HangThucPham){
                listHH1.add(ha);
            }
            else if(ha instanceof HangDienMay){
                listHH2.add(ha);
            }
            else if(ha instanceof HangSanhSu){
                listHH3.add(ha);
            }
        }
        Collections.sort(listHH1,new Comparator<HangHoa>() {

            @Override
            public int compare(HangHoa o1, HangHoa o2) {
               if(o1.getSoLuongTon() < o2.getSoLuongTon()){
                   return -1;
               }
                else{
                    if(o1.getSoLuongTon() == o2.getSoLuongTon()){
                        return 0;
                    }
                    else{
                        return 1;
                    }
                }
            }
            
        });
        xuatHangThucPhamTheoDanhSach(listHH1);
        Collections.sort(listHH2, new Comparator<HangHoa>() {

            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getSoLuongTon()<o2.getSoLuongTon()){
                    return -1;
                }
                else{
                    if(o1.getSoLuongTon() == o2.getSoLuongTon()){
                        return 0;
                    }
                    else{
                        return 1;
                    }

                }
            }
            
        });
        xuatHangDienMayTheoDanhSach(listHH2);
        Collections.sort(listHH3, new Comparator<HangHoa>() {

            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getSoLuongTon() < o2.getSoLuongTon()){
                    return -1;
                }
                else{
                    if(o1.getSoLuongTon()==o2.getSoLuongTon()){
                        return 0;
                    }
                    else{
                        return 1;
                    }
                }
            }
            
        });
        xuatHangSanhSuTheoDanhSach(listHH3);
    }
    public void sapXepGiamDanTheoLoaiVaSoLuongTonKho(){
        ArrayList <HangHoa> listHH1 = new ArrayList<>();
        ArrayList <HangHoa> listHH2 = new ArrayList<>();
        ArrayList <HangHoa> listHH3 = new ArrayList<>();

        for(int i=0; i<listHH1.size() ; i++){
            HangHoa ha = listHH.get(i);
            if(ha instanceof HangThucPham){
                listHH1.add(ha);
            
            }
            else if(ha instanceof HangDienMay){
                listHH2.add(ha);
                
            }
            else if(ha instanceof HangSanhSu){
                listHH3.add(ha);
            }

        }
        Collections.sort(listHH1, new Comparator<HangHoa>() {

            @Override
            public int compare(HangHoa o1, HangHoa o2) {
               if(o1.getSoLuongTon()<o2.getSoLuongTon()){
                   return 1;
               }
                else{
                    if(o1.getSoLuongTon()==o2.getSoLuongTon()){
                        return 0;
                    }
                    else{
                        return -1;
                    }
                }
            }
            
        });
        xuatHangThucPhamTheoDanhSach(listHH1);
        Collections.sort(listHH2, new Comparator<HangHoa>() {

            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getSoLuongTon()<o2.getSoLuongTon()){
                    return 1;
                }
                else{
                    if(o1.getSoLuongTon()==o2.getSoLuongTon()){
                        return 0;
                    }
                    else{
                        return -1;
                    }
                }
            }
            
        });
        xuatHangDienMayTheoDanhSach(listHH2);
        Collections.sort(listHH3, new Comparator<HangHoa>() {

            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getSoLuongTon()<o2.getSoLuongTon()){
                    return 1;
                }
                else{
                    if(o1.getSoLuongTon()==o2.getSoLuongTon()){
                        return 0;
                    }
                    else{
                        return -1;
                    }
                }
            }
            
        });
        xuatHangSanhSuTheoDanhSach(listHH3);
    }
    // phuong thuc sap xep tang dan theo loai va don gia
    public void sapXepTangDanTheoLoaiVaDonGia(){
        ArrayList<HangHoa> listHH1 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> listHH2 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> listHH3 = new ArrayList<HangHoa>();

        for(int i=0; i<listHH.size();i++){
            HangHoa ha = listHH.get(i);
            if(ha instanceof HangThucPham){
                listHH1.add(ha);
            }
            else if(ha instanceof HangSanhSu){
                listHH2.add(ha);
            }
            else if(ha instanceof HangDienMay){
                listHH3.add(ha);
            }
        }

        Collections.sort(listHH1, new Comparator<HangHoa>() {

            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getDonGia()<o2.getDonGia()){
                    return -1;
                }
                else{
                    if(o1.getDonGia()==o2.getDonGia()){
                        return 0;
                    }
                    else{
                        return 1;
                    }
                }
            }
            
        });
        xuatHangThucPhamTheoDanhSach(listHH1);
        Collections.sort(listHH2, new Comparator<HangHoa>() {

            @Override
            public int compare(HangHoa o1, HangHoa o2) {
               if(o1.getDonGia()<o2.getDonGia()){
                   return -1;
               }
               else{
                   if(o1.getDonGia() == o2.getDonGia()){
                       return 0;
                   }
                   else{
                       return 1;
                   }
               }
            }
            
        });
        xuatHangDienMayTheoDanhSach(listHH2);
        Collections.sort(listHH3, new Comparator<HangHoa>() {

            @Override
            public int compare(HangHoa o1, HangHoa o2) {
               if(o1.getDonGia()<o2.getDonGia()){
                   return -1;
               }else{
                   if(o1.getDonGia()==o2.getDonGia()){
                       return 0;
                   }
                   else{
                       return 1;
                   }
               }
                
            }
            
        });
        xuatHangSanhSuTheoDanhSach(listHH3);
    }
    public void sapXepGiamDanTheoLoaiVaDonGia(){
        ArrayList<HangHoa> listHH1 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> listHH2 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> listHH3 = new ArrayList<HangHoa>();
        for(int i=0; i<listHH.size();i++){
            HangHoa ha = listHH.get(i);
            if(ha instanceof HangThucPham){
                listHH1.add(ha);
            }
            else if(ha instanceof HangSanhSu){
                listHH2.add(ha);
            }
            else if(ha instanceof HangDienMay){
                listHH3.add(ha);
            }
        }

        Collections.sort(listHH1, new Comparator<HangHoa>() {

            @Override
            public int compare(HangHoa o1, HangHoa o2) {
               if(o1.getDonGia() < o2.getDonGia()){
                   return 1;
               }
                else{
                    if(o1.getDonGia()==o2.getDonGia()){
                        return 0;
                    }
                    else{
                        return -1;
                    }
                }
            }
            
        });
        xuatHangThucPhamTheoDanhSach(listHH1);
        Collections.sort(listHH2, new Comparator<HangHoa>() {

            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                
               if(o1.getDonGia()<o2.getDonGia()){
                   return 1;
               }
               else{
                   if(o1.getDonGia()==o2.getDonGia()){
                       return 0;
                   }
                   else{
                       return -1;
                   }
               }
            }
            
        });
        xuatHangDienMayTheoDanhSach(listHH2);
        Collections.sort(listHH3, new Comparator<HangHoa>() {

            @Override
            public int compare(HangHoa o1, HangHoa o2) {
             if(o1.getDonGia()<o2.getDonGia()){
                 return 1;
             }
                else{
                    if(o1.getDonGia() == o2.getDonGia()){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            }
            
        });
        xuatHangSanhSuTheoDanhSach(listHH3);
    }
   public void timKiemTheoLoai(){
       int luaChon = 0;
       System.out.println("=============MENU=================");
       System.out.println("1.Hang thuc pham ");
       System.out.println("2.Hang sanh su");
       System.out.println("3.Hang dien may");
       System.out.println("Nhap lua chon cua ban: ");
       luaChon = varInput.nextInt();
       switch(luaChon){
           case 1: {
               System.out.println("Cac loai hang thuc pham la");
               xuatHangThucPham();
                break;
           }
           case 2: {
               System.out.println("Cac loai hang dien may la: ");
               xuatHangDienMay();
               break;
           }
           case 3: {
               System.out.println("Cac loai hang sanh su la: ");
               xuatHangSanhSu();
               break;
           }
       }
   }
   public void timkiemTheoMaHangHoa() {
       System.out.println("Nhap ten hang hoa can tim va xoa ");
       String ma = varInput.next();
       HangHoa ha = null;

       for (HangHoa hangHoa : listHH) {
           if(hangHoa.getMaHang().equals(ma)){
               ha = hangHoa;
               break;
           }
       }
       if(ha != null){
           listHH.remove(ha);
           System.out.println("Ma Hang hoa duoc xoa khoi danh sach ");
       }else{
           System.out.println("Ma Hang hoa khong co trong danh sach");
       }

   }
   public void timKiemTheoDonGia(){
       System.out.println("Nhap don gia can tim kiem: ");
       double giaKhoiDiem = varInput.nextDouble();
       System.out.println("Nhap don gia ket thuc: ");
       double giaKetThuc = varInput.nextDouble();
       for(int i=0; i<listHH.size();i++){
           HangHoa ha =listHH.get(i);
           if(ha.getDonGia()>=giaKhoiDiem && ha.getDonGia() <=giaKetThuc){
           if(ha instanceof HangThucPham){
               xuatHangThucPhamTrucTiep(ha);
           }
           else if(ha instanceof HangDienMay){
               xuatHangDienMayTrucTiep(ha);
           }
           else if(ha instanceof HangSanhSu){
               xuatHangSanhSuTrucTiep(ha);
            }
         }
     }
   }
   public void timKiemSanPhamGiaTriCao(){
       HangHoa ha =  listHH.get(0);
       double max  = ha.getDonGia();

       for(int i=0; i<listHH.size();i++){
           HangHoa ah = listHH.get(i);
           if(ha.getDonGia() > max){
               max = ah.getDonGia();
           }
       }
       for(int i=0; i<listHH.size();i++){
           HangHoa ah = listHH.get(i);
           if(ah.getDonGia() == max){
            System.out.println("San pham co gia tri cao nhat la: ");
            xuatHangSanhSuTrucTiep(ah);
           }
       }
   }
   public void timKiemSanPhamTongGiaCaoNhat(){
       HangHoa ha = listHH.get(0);
       double max = ha.tinhTien();

       for(int i=0; i<listHH.size();i++){
           HangHoa ah = listHH.get(i);
           if(ah.tinhTien()>max){
                max =ah.tinhTien();
          }
     }
     for(int i=0;i<listHH.size();i++){
         HangHoa ah = listHH.get(i);
         if(ah.tinhTien() == max){
             System.out.println("San pham co tong gia tri cao nhat: ");
             xuatHangSanhSuTrucTiep(ah);
         }
     }
    
    }
    public void timKiemSanPhamGiaTriThapNhat(){
        HangHoa ha = listHH.get(0);
        double max = ha.getDonGia();

        for(int i=0; i<listHH.size();i++){
            HangHoa ah = listHH.get(i);
            if(ah.getDonGia() < max){
                max = ah.getDonGia();
            }
        }
    }
    public void timKiemSanPhamTongGiaTriThap(){
        HangHoa ha = listHH.get(0);
        double max = ha.tinhTien();

        for(int i = 0; i<listHH.size();i++){
            HangHoa ah = listHH.get(0);
            if(ah.tinhTien()<max){
                max = ah.tinhTien();
            }
        }
        for(int i =0; i<listHH.size();i++){
            HangHoa ah = listHH.get(i);
            if(ah.tinhTien() == max){
                System.out.println(" San pham co tong gia tri thap nhat la: ");
                xuatHangSanhSuTrucTiep(ah);
            }
        }
    }
    Locale locale = new Locale("VN");
    NumberFormat tienVietNam = NumberFormat.getCurrencyInstance(locale);
    
    public void thongKeTongHangHoa(){
        double tongSoLuong = 0, tongChiPhi = 0;
        for (HangHoa hangHoa : listHH) {
            tongSoLuong += hangHoa.getSoLuongTon();
            tongChiPhi += hangHoa.tinhTien();
        }
        sapXepTangDanTheoLoaiVaDonGia();
        System.out.println("Thong ke");
        for(int i = 0; i<149; i++){
            System.out.print("");

        }
        System.out.println();
        System.out.printf("%-34s|%-112d|\n","Tong so luong",tongSoLuong);
        for(int i =0; i<149;i++){
            System.out.println("");
        }
        System.out.println();

        System.out.printf("%-34s|%-25s%-67s%-20s|\n","Tong chi phi"," ","",tienVietNam.format(tongChiPhi));
        for(int i = 0; i<149; i++){
            System.out.print("");

        }
        System.out.println();
    }
    public void thongKeTheoLoaiHangHoa(){
        double tongGiaTriHTP = 0;
        double tongGiaTriHDM = 0;
        double tongGiaTriHSS = 0;
        double tongSoLuongHTP = 0;
        double tongSoLuongHDM = 0;
        double tongSoLuongHSS = 0;
        for(int i =0; i<listHH.size();i++){
            HangHoa ha = listHH.get(i);
           
                if(ha instanceof HangThucPham){
                    tongGiaTriHTP += ha.tinhTien();
                    tongSoLuongHTP += ha.getSoLuongTon();
                }
                else if(ha instanceof HangDienMay){
                    tongGiaTriHDM += ha.tinhTien();
                    tongSoLuongHDM += ha.getSoLuongTon();
                }
                else if(ha instanceof HangSanhSu){
                    tongGiaTriHSS += ha.tinhTien();
                    tongSoLuongHSS += ha.getSoLuongTon();
                }
            
        }
        System.out.println("===========MENU============");
        System.out.println("1.Hang thuc pham");
        System.out.println("2.Hang sanh su");
        System.out.println("3.Hang dien may");
        System.out.println("0. Quay lai");

        System.out.print("Nhap lua chon loai hang hoa: ");
        int luaChon = varInput.nextInt();
        switch(luaChon){
            case 1: {
                xuatHangThucPham();
                for(int i =0; i<149; i++){
                    System.out.print("");
                }
                System.out.println();
                System.out.printf("%-34s|%-112d|\n","Tong so luong",tongSoLuongHTP);
                for(int i=0;i<149;i++){
                    System.out.println("");
                }
                System.out.println();
                System.out.printf("%-34s|%-25s%-67s%-20s|\n","Tong chi phi"," "," ",tienVietNam.format(tongGiaTriHTP));
                for(int i=0; i<149;i++){
                    System.out.println();
                }
                System.out.print("");
                break;
            }
            case 2:
            {
                xuatHangDienMay();
                for(int i=0;i<149;i++){
                    System.out.println("");
                }
                System.out.println();
                System.out.printf("%-34s|%-112d|\n","Tong so luong",tongSoLuongHDM);
                for(int i=0; i<149; i++){
                    System.out.print("");
                }
                System.out.println();
                System.out.printf("%-34s|%-25s%-67s%-20s|\n","Tong chi phi"," "," ",tienVietNam.format(tongGiaTriHDM));
                break;
            }
            case 3:
            {
                xuatHangSanhSu();
                for(int i=0; i<1;i++){
                    System.out.println();
                }
                System.out.println();
                System.out.printf("%-34s|%-112d|\n","Tong so luong",tongSoLuongHSS);
                for(int i=0; i<1; i++){
                    System.out.println();
                }
                System.out.println();
                System.out.printf("|%-34s|%-25s%-67s%-20s|\n","Tong chi phi"," "," ",tienVietNam.format(tongGiaTriHSS));
                for(int i=0; i<1; i++){
                    System.out.println();
                }
                System.out.println();
                break;
            }
        }
    }
        
    
}