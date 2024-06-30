package BUS;

import DAO.PhieuXuatKhoDAO;
import DTO.PhieuXuatKhoDTO;
import java.sql.SQLException;
import java.util.List;

public class PhieuXuatKhoBUS {

    public static List<PhieuXuatKhoDTO> select() throws SQLException {
        return PhieuXuatKhoDAO.select();
    }
    
    public static PhieuXuatKhoDTO select(String maPXK) throws SQLException {
        return PhieuXuatKhoDAO.select(maPXK);
    }
    
    public static boolean exists(String maPXK) throws SQLException {
        return PhieuXuatKhoDAO.exists(maPXK);
    }

    public static int insert(PhieuXuatKhoDTO pxk) throws SQLException {
        return PhieuXuatKhoDAO.exists(pxk.getMaPXK()) ? 0 : PhieuXuatKhoDAO.insert(pxk);
    }

    public static int update(PhieuXuatKhoDTO pxk) throws SQLException {
        return PhieuXuatKhoDAO.exists(pxk.getMaPXK()) ? PhieuXuatKhoDAO.update(pxk) : 0;
    }

    public static int delete(String maPXK) throws SQLException {
        return PhieuXuatKhoDAO.exists(maPXK) ? PhieuXuatKhoDAO.delete(maPXK) : 0;
    }
}