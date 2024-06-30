package DTO;

import java.sql.Date;

public class HoaDonDTO {

    private String maHD, maNV, maKH;
    private Date ngLap;
    private double discount, tgBaoHanh, triGia;

    public HoaDonDTO() {
    }

    public HoaDonDTO(String maHD, String maNV, String maKH, Date ngLap, double discount, double tgBaoHanh, double triGia) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.ngLap = ngLap;
        this.discount = discount;
        this.tgBaoHanh = tgBaoHanh;
        this.triGia = triGia;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public Date getNgLap() {
        return ngLap;
    }

    public void setNgLap(Date ngLap) {
        this.ngLap = ngLap;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTgBaoHanh() {
        return tgBaoHanh;
    }

    public void setTgBaoHanh(double tgBaoHanh) {
        this.tgBaoHanh = tgBaoHanh;
    }

    public double getTriGia() {
        return triGia;
    }

    public void setTriGia(double triGia) {
        this.triGia = triGia;
    }

}