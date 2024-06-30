package BUS;

import DAO.PhieuNhapKhoDAO;
import DTO.PhieuNhapKhoDTO;
import java.sql.SQLException;
import java.util.List;

public class PhieuNhapKhoBUS {

    public static List<PhieuNhapKhoDTO> select() throws SQLException {
        return PhieuNhapKhoDAO.select();
    }
    
    public static PhieuNhapKhoDTO select(String maPNK) throws SQLException {
        return PhieuNhapKhoDAO.select(maPNK);
    }
    
    public static boolean exists(String maPNK) throws SQLException {
        return PhieuNhapKhoDAO.exists(maPNK);
    }

    public static int insert(PhieuNhapKhoDTO pnk) throws SQLException {
        return PhieuNhapKhoDAO.exists(pnk.getMaPNK()) ? 0 : PhieuNhapKhoDAO.insert(pnk);
    }

    public static int update(PhieuNhapKhoDTO pnk) throws SQLException {
        return PhieuNhapKhoDAO.exists(pnk.getMaPNK()) ? PhieuNhapKhoDAO.update(pnk) : 0;
    }

    public static int delete(String maPNK) throws SQLException {
        return PhieuNhapKhoDAO.exists(maPNK) ? PhieuNhapKhoDAO.delete(maPNK) : 0;
    }
}