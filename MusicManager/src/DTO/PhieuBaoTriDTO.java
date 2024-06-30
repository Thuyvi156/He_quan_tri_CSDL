package DTO;

import java.sql.Date;

public class PhieuBaoTriDTO {

    private String maPBT, maNC, maHD, chiTietBT;
    private Date ngBT;

    public PhieuBaoTriDTO() {
    }

    public PhieuBaoTriDTO(String maPBT, String maNC, String maHD, String chiTietBT, Date ngBT) {
        this.maPBT = maPBT;
        this.maNC = maNC;
        this.maHD = maHD;
        this.chiTietBT = chiTietBT;
        this.ngBT = ngBT;
    }

    public String getMaPBT() {
        return maPBT;
    }

    public void setMaPBT(String maPBT) {
        this.maPBT = maPBT;
    }

    public String getMaNC() {
        return maNC;
    }

    public void setMaNC(String maNC) {
        this.maNC = maNC;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getChiTietBT() {
        return chiTietBT;
    }

    public void setChiTietBT(String chiTietBT) {
        this.chiTietBT = chiTietBT;
    }

    public Date getNgBT() {
        return ngBT;
    }

    public void setNgBT(Date ngBT) {
        this.ngBT = ngBT;
    }

}
