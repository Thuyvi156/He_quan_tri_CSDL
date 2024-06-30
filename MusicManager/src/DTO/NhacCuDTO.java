package DTO;

public class NhacCuDTO {

    private String maNC, maLNC, tenNC, hang, hinh;
    private double giaNhap, giaBan;
    private int tongSL = 0;

    public NhacCuDTO() {
    }

    public NhacCuDTO(String maNC, String maLNC, String tenNC, String hang, String hinh, double giaNhap, double giaBan, int tongSL) {
        this.maNC = maNC;
        this.maLNC = maLNC;
        this.tenNC = tenNC;
        this.hang = hang;
        this.hinh = hinh;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.tongSL = tongSL;
    }

    public String getMaNC() {
        return maNC;
    }

    public void setMaNC(String maNC) {
        this.maNC = maNC;
    }

    public String getMaLNC() {
        return maLNC;
    }

    public void setMaLNC(String maLNC) {
        this.maLNC = maLNC;
    }

    public String getTenNC() {
        return tenNC;
    }

    public void setTenNC(String tenNC) {
        this.tenNC = tenNC;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getTongSL() {
        return tongSL;
    }

    public void setTongSL(int tongSL) {
        this.tongSL = tongSL;
    }

}
