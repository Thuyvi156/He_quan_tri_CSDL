package DTO;

public class ChiTietHoaDonDTO {

    private String maHD, maNC;
    private int soLuong, thanhTien;

    public ChiTietHoaDonDTO() {
    }

    public ChiTietHoaDonDTO(String maHD, String maNC, int soLuong, int thanhTien) {
        this.maHD = maHD;
        this.maNC = maNC;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNC() {
        return maNC;
    }

    public void setMaNC(String maNC) {
        this.maNC = maNC;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

}