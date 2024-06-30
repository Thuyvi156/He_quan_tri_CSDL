package DTO;

import java.sql.Date;

public class BaoCaoDTO {

    private String maBC, maNV, chiTietBC;
    private Date ngayBC;

    public BaoCaoDTO() {
    }

    public BaoCaoDTO(String maBC, String maNV, Date ngayBC, String chiTietBC) {
        this.maBC = maBC;
        this.maNV = maNV;
        this.ngayBC = ngayBC;
        this.chiTietBC = chiTietBC;
    }

    public String getMaBC() {
        return maBC;
    }

    public void setMaBC(String maBC) {
        this.maBC = maBC;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Date getNgayBC() {
        return ngayBC;
    }

    public void setNgayBC(Date ngayBC) {
        this.ngayBC = ngayBC;
    }

    public String getChiTietBC() {
        return chiTietBC;
    }

    public void setChiTietBC(String chiTietBC) {
        this.chiTietBC = chiTietBC;
    }
}