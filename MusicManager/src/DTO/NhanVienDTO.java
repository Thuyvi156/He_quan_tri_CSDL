package DTO;

import java.sql.Date;

public class NhanVienDTO {

    private String maNV, hoTen, sdt, email, vaiTro;
    private Date ngaySinh, ngayVL;

    public NhanVienDTO() {
    }

    public NhanVienDTO(String maNV, String hoTen, Date ngaySinh, String sdt, String email, String vaiTro, Date ngayVL) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.email = email;
        this.vaiTro = vaiTro;
        this.ngayVL = ngayVL;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public Date getNgayVL() {
        return ngayVL;
    }

    public void setNgayVL(Date ngayVL) {
        this.ngayVL = ngayVL;
    }

}