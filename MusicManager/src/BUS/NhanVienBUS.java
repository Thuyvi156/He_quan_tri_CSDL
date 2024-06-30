package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.sql.SQLException;
import java.util.List;

public class NhanVienBUS {

    public static List<NhanVienDTO> select() throws SQLException {
        return NhanVienDAO.select();
    }
    
    public static NhanVienDTO select(String maNV) throws SQLException {
        return NhanVienDAO.select(maNV);
    }
    
    public static boolean exists(String maNV) throws SQLException {
        return NhanVienDAO.exists(maNV);
    }

    public static int insert(NhanVienDTO nv) throws SQLException {
        return NhanVienDAO.exists(nv.getMaNV()) ? 0 : NhanVienDAO.insert(nv);
    }

    public static int update(NhanVienDTO nv) throws SQLException {
        return NhanVienDAO.exists(nv.getMaNV()) ? NhanVienDAO.update(nv) : 0;
    }

    public static int delete(String maNV) throws SQLException {
        return NhanVienDAO.exists(maNV) ? NhanVienDAO.delete(maNV) : 0;
    }
    
    
    
    public static List<NhanVienDTO> selectAllByMaKH(String maKH) throws SQLException {
        return NhanVienDAO.query("SELECT * FROM NHANVIEN WHERE LOWER(MANV) LIKE LOWER(?)", "%"+maKH+"%");
    }
    
    public static List<NhanVienDTO> selectAllByHoTen(String hoTen) throws SQLException {
        return NhanVienDAO.query("SELECT * FROM NHANVIEN WHERE LOWER(HOTEN_NV) LIKE LOWER(?)", "%"+hoTen+"%");
    }

}