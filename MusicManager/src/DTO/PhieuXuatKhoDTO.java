package DTO;

import java.sql.Date;

public class PhieuXuatKhoDTO {

    private String maPXK, maNC, noiDung;
    private Date ngXuat;
    private int soLuong;

    public PhieuXuatKhoDTO() {
    }

    public PhieuXuatKhoDTO(String maPXK, String maNC, String noiDung, Date ngXuat, int soLuong) {
        this.maPXK = maPXK;
        this.maNC = maNC;
        this.noiDung = noiDung;
        this.ngXuat = ngXuat;
        this.soLuong = soLuong;
    }

    public String getMaPXK() {
        return maPXK;
    }

    public void setMaPXK(String maPXK) {
        this.maPXK = maPXK;
    }

    public String getMaNC() {
        return maNC;
    }

    public void setMaNC(String maNC) {
        this.maNC = maNC;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getNgXuat() {
        return ngXuat;
    }

    public void setNgXuat(Date ngXuat) {
        this.ngXuat = ngXuat;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
