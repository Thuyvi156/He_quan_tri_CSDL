package DTO;

public class LoaiNhacCuDTO {

    private String maLNC;
    private String tenLNC;

    public LoaiNhacCuDTO() {
    }

    public LoaiNhacCuDTO(String maLNC, String tenLNC) {
        this.maLNC = maLNC;
        this.tenLNC = tenLNC;
    }

    public String getMaLNC() {
        return maLNC;
    }

    public void setMaLNC(String maLNC) {
        this.maLNC = maLNC;
    }

    public String getTenLNC() {
        return tenLNC;
    }

    public void setTenLNC(String tenLNC) {
        this.tenLNC = tenLNC;
    }
}