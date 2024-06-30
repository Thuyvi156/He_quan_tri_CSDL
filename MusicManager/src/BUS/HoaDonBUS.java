package BUS;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import java.sql.SQLException;
import java.util.List;

public class HoaDonBUS {

    public static List<HoaDonDTO> select() throws SQLException {
        return HoaDonDAO.select();
    }
    
    public static HoaDonDTO select(String maHD) throws SQLException {
        return HoaDonDAO.select(maHD);
    }
    
    public static boolean exists(String maHD) throws SQLException {
        return HoaDonDAO.exists(maHD);
    }

    public static int insert(HoaDonDTO hd) throws SQLException {
        return HoaDonDAO.exists(hd.getMaHD()) ? 0 : HoaDonDAO.insert(hd);
    }

    public static int update(HoaDonDTO hd) throws SQLException {
        return HoaDonDAO.exists(hd.getMaHD()) ? HoaDonDAO.update(hd) : 0;
    }

    public static int delete(String maHD) throws SQLException {
        return HoaDonDAO.exists(maHD) ? HoaDonDAO.delete(maHD) : 0;
    }
}