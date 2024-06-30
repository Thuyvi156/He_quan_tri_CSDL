package DTO;

import java.sql.Date;

public class KhachHangDTO {

    private String maKH, hoTen, sdt, diaChi;
    private Date ngSinh;
    private double tichLuy;

    public KhachHangDTO() {
    }

    public KhachHangDTO(String maKH, String hoTen, String sdt, String diaChi, Date ngSinh, double tichLuy) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.ngSinh = ngSinh;
        this.tichLuy = tichLuy;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgSinh() {
        return ngSinh;
    }

    public void setNgSinh(Date ngSinh) {
        this.ngSinh = ngSinh;
    }

    public double getTichLuy() {
        return tichLuy;
    }

    public void setTichLuy(double tichLuy) {
        this.tichLuy = tichLuy;
    }
}