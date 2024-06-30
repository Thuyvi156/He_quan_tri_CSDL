package DTO;

public class TaiKhoanDTO {

    private int idTK;
    private String maNV;
    private String email;
    private String matKhau;
    private String verCode;
    private String trangThai;
    private String vaiTroNV;

    public TaiKhoanDTO() {
    }

    public TaiKhoanDTO(int idTK, String maNV, String email, String matKhau, String verCode, String trangThai, String vaiTroNV) {
        this.idTK = idTK;
        this.maNV = maNV;
        this.email = email;
        this.matKhau = matKhau;
        this.verCode = verCode;
        this.trangThai = trangThai;
        this.vaiTroNV = vaiTroNV;
    }

    public int getIdTK() {
        return idTK;
    }

    public void setIdTK(int idTK) {
        this.idTK = idTK;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVerCode() {
        return verCode;
    }

    public void setVerCode(String verCode) {
        this.verCode = verCode;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getVaiTroNV() {
        return vaiTroNV;
    }

    public void setVaiTroNV(String vaiTroNV) {
        this.vaiTroNV = vaiTroNV;
    }
}