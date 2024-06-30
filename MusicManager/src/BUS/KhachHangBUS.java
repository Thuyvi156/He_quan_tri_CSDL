package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.sql.SQLException;
import java.util.List;

public class KhachHangBUS {

    public static List<KhachHangDTO> select() throws SQLException {
        return KhachHangDAO.select();
    }
    
    public static KhachHangDTO select(String maKH) throws SQLException {
        return KhachHangDAO.select(maKH);
    }
    
    public static boolean exists(String maKH) throws SQLException {
        return KhachHangDAO.exists(maKH);
    }

    public static int insert(KhachHangDTO kh) throws SQLException {
        return KhachHangDAO.exists(kh.getMaKH()) ? 0 : KhachHangDAO.insert(kh);
    }

    public static int update(KhachHangDTO kh) throws SQLException {
        return KhachHangDAO.exists(kh.getMaKH()) ? KhachHangDAO.update(kh) : 0;
    }

    public static int delete(String maKH) throws SQLException {
        return KhachHangDAO.exists(maKH) ? KhachHangDAO.delete(maKH) : 0;
    }
    
    
    
    public static List<KhachHangDTO> selectAllByMaKH(String maKH) throws SQLException {
        return KhachHangDAO.query("SELECT * FROM KHACHHANG WHERE LOWER(MAKH) LIKE LOWER(?)", "%"+maKH+"%");
    }
    
    public static List<KhachHangDTO> selectAllByHoTen(String hoTen) throws SQLException {
        return KhachHangDAO.query("SELECT * FROM KHACHHANG WHERE LOWER(HOTEN_KH) LIKE LOWER(?)", "%"+hoTen+"%");
    }
    
}