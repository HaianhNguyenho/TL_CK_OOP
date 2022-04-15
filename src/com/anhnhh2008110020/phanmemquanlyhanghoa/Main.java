package com.anhnhh2008110020.phanmemquanlyhanghoa;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) throws ParseException {
       int luaChon = 0;
       Scanner varInput = new Scanner(System.in);
    //Tao danh sach HH
       ListHangHoa list = new ListHangHoa();
       //Tao doi tuong hang thuc pham
       HangHoa sp1= new HangThucPham("MH01", "Banh su kem",20.000 , 4, "10/11/2021", "10/12/2021", "Sieu thi BigC");
       list.themHangHoa(sp1);
       HangHoa sp2 = new HangThucPham("MH02", "Trung", 10.000, 5, "11/11/2021", "11/12/2021", "Sieu thi BigC");
       list.themHangHoa(sp2);
       HangHoa sp3 = new HangThucPham("MH03", "Banh chung", 200.000, 1, "24/10/2021", "26/10/2021", "Sieu thi BigC");
       list.themHangHoa(sp3);
       HangHoa sp4 = new HangThucPham("MH04", "Kem", 100.000, 10, "15/12/2021", "16/12/2021", "Sieu Thi BigC");
       list.themHangHoa(sp4);

       //Tao doi tuong hang dien may
       HangHoa sp5 = new HangDienMay("MH05", "TV", 5.000000, 1, 3, 50);
       list.themHangHoa(sp5);
       HangHoa sp6 = new HangDienMay("MH06", "May Giat", 6.000000, 2, 0, 5);
       list.themHangHoa(sp6);
       HangHoa sp7 = new HangDienMay("MH07", "May rua chen", 600.000, 4, 3, 4);
       list.themHangHoa(sp7);
       HangHoa sp8 = new HangDienMay("MH08", "May pha che cafe", 500.000, 1, 2, 4);
       list.themHangHoa(sp8);

       //Tao doi tuong hang sanh su
       HangHoa sp9 = new HangSanhSu("MH09", "Lo hoa", 30.000, 3, "Viet Nam", "10/12/2022");
       list.themHangHoa(sp9);
       HangHoa sp10 = new HangSanhSu("MH10", "Dia su", 200.000, 20, "Viet Nam", "20/10/2021");
       list.themHangHoa(sp10);
       HangHoa sp11 = new HangSanhSu("MH11", "Coc su", 70.000, 5, "Viet Nam", "30/11/2021");
       list.themHangHoa(sp11);
       HangHoa sp12 = new HangSanhSu("MH12", "Bat su", 110.000, 11, "Viet Nam", "11/11/2021");
       list.themHangHoa(sp12);

       while(luaChon !=5){
           System.out.println("===========MENU-PHAN MEM QUAN LY HANG HOA=========== ");
           System.out.println(">>   1. Thao tac tren danh sach hang hoa             ");
           System.out.println("         1.1 Phuong thuc them hang hoa`              ");
           System.out.println("         1.2 Phuong thuc sua hang hoa                ");
           System.out.println("         1.3 Phuong thuc xoa hang hoa                ");
           System.out.println(">>   2. Tim kiem theo:                               ");
           System.out.println("         2.1 Loai                                    ");
           System.out.println("         2.2 Ngay Nhap                               ");
           System.out.println("         2.3 Gia                                     ");
           System.out.println("         2.4 Gia tri cao nhat                        ");
           System.out.println("         2.5 Tong gia tri cao nhat                   ");
           System.out.println("         2.6 Gia tri thap nhat                       ");
           System.out.println("         2.7 Tong gia tri thap nhat                  ");
           System.out.println(">>   3. Sap xep:                                     ");
           System.out.println("         3.1 <Tang dan>                              ");
           System.out.println("             3.1.1 Gia nhap                          ");
           System.out.println("             3.1.2 Ngay nhap                         ");
           System.out.println("             3.1.3 Loai va ngay nhap                 ");
           System.out.println("             3.1.4 Loai va gia nhap                  ");
           System.out.println("         3.2 >Giam gia<                              ");
           System.out.println("             3.2.1 Gia nhap                          ");
           System.out.println("             3.2.2 Ngay nhap                         ");
           System.out.println("             3.2.3 Loai va ngay nhap                 ");
           System.out.println("             3.2.4 Loai va gia nhap                  ");
           System.out.println(">>   4. Thong ke:                                    ");
           System.out.println("         4.1 Tong so luong hang hoa                  ");
           System.out.println("         4.2 Tong chi phi hang hoa                   ");
           System.out.println("         4.3 So luong tung loai hang                 ");
           System.out.println(">>   0 Thoat chuong chinh                            ");
           System.out.println("=====================================================");
           System.out.print("Nhap lua chon cua ban (1-4): ");
           luaChon = varInput.nextInt();
           switch(luaChon){
               case 1:{
               System.out.println("=========MENU============");
               System.out.println("1. Them hang hoa         ");
               System.out.println("2. Sua hang hoa          ");
               System.out.println("3. Xoa hang hoa theo ma  ");
               System.out.println("0 Thoat                  ");
               System.out.println("=========================");
               System.out.print("Nhap lua chon cua ban (1-3): ");
               luaChon = varInput.nextInt();
               switch(luaChon){
                   case 1: list.themHH();
                   break;
                   case 2: list.suaHangHoa();
                   break;
                   case 3: list.xoaHangHoaTheoMa();
                   break;

                   default:
                   System.out.println("Khong thao tac duoc!");
                   break;
               }
             break;
            }
            case 2: {
                System.out.println("=============MENU=============");
                System.out.println("2.1 Tim kiem theo loai        ");
                System.out.println("2.2 Tim kiem theo ma va xoa    ");
                System.out.println("2.3 Tim kiem theo gia         ");
                System.out.println("2.4 Tim kiem gia tri cao nhat ");
                System.out.println("2.5 Tim kiem tong gia tri cn  ");
                System.out.println("2.6 tim kiem gia tri thap nhat");
                System.out.println("2.7 Tim kiem tong gt thap nhat");
                System.out.println("0       Thoat                  ");
                System.out.print("Moi ban nhap lua chon(1-7): ");
                luaChon = varInput.nextInt();
                switch(luaChon){
                    case 1: list.timKiemTheoLoai();
                    break;
                    case 2: list.timkiemTheoMaHangHoa();
                    break;
                    case 3: list.timKiemTheoDonGia();
                    break;
                    case 4: list.timKiemSanPhamGiaTriCao();
                    break;
                    case 5: list.timKiemSanPhamTongGiaCaoNhat();
                    break;
                    case 6: list.timKiemSanPhamGiaTriThapNhat();
                    break;
                    case 7: list.timKiemSanPhamTongGiaTriThap();
                    break;
                    default:
                    System.out.println("Nhap sai.Vui long thu lai");
                    break;
                }
                break;
            }
               
           }
           






       }

   } 
}
