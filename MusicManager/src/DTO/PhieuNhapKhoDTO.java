package DTO;

import java.sql.Date;

public class PhieuNhapKhoDTO {

    private String maPNK, maNC, maNCC, noiDung;
    private Date ngNhap;
    private int soLuong;

    public PhieuNhapKhoDTO() {
    }

    public PhieuNhapKhoDTO(String maPNK, String maNC, String maNCC, String noiDung, Date ngNhap, int soLuong) {
        this.maPNK = maPNK;
        this.maNC = maNC;
        this.maNCC = maNCC;
        this.noiDung = noiDung;
        this.ngNhap = ngNhap;
        this.soLuong = soLuong;
    }

    public String getMaPNK() {
        return maPNK;
    }

    public void setMaPNK(String maPNK) {
        this.maPNK = maPNK;
    }

    public String getMaNC() {
        return maNC;
    }

    public void setMaNC(String maNC) {
        this.maNC = maNC;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getNgNhap() {
        return ngNhap;
    }

    public void setNgNhap(Date ngNhap) {
        this.ngNhap = ngNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
