package BUS;

import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDonDTO;
import java.sql.SQLException;
import java.util.List;

public class ChiTietHoaDonBUS {

    public static List<ChiTietHoaDonDTO> select() throws SQLException {
        return ChiTietHoaDonDAO.select();
    }
    
    public static List<ChiTietHoaDonDTO> select(String maHD) throws SQLException {
        return ChiTietHoaDonDAO.select(maHD);
    }
    
    public static boolean exists(String soHD) throws SQLException {
        return ChiTietHoaDonDAO.exists(soHD);
    }

    public static int insert(ChiTietHoaDonDTO cthd) throws SQLException {
        return ChiTietHoaDonDAO.insert(cthd);
    }

    public static int update(ChiTietHoaDonDTO cthd) throws SQLException {
        return ChiTietHoaDonDAO.update(cthd);
    }

    public static int delete(int soHD) throws SQLException {
        return ChiTietHoaDonDAO.delete(soHD);
    }
}