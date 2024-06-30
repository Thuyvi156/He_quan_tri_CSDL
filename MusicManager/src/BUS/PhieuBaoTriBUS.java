package BUS;

import DAO.PhieuBaoTriDAO;
import DTO.PhieuBaoTriDTO;
import java.sql.SQLException;
import java.util.List;

public class PhieuBaoTriBUS {

    public static List<PhieuBaoTriDTO> select() throws SQLException {
        return PhieuBaoTriDAO.select();
    }
    
    public static PhieuBaoTriDTO select(String maPBT) throws SQLException {
        return PhieuBaoTriDAO.select(maPBT);
    }
    
    public static boolean exists(String maPBT) throws SQLException {
        return PhieuBaoTriDAO.exists(maPBT);
    }

    public static int insert(PhieuBaoTriDTO pbt) throws SQLException {
        return PhieuBaoTriDAO.exists(pbt.getMaPBT()) ? 0 : PhieuBaoTriDAO.insert(pbt);
    }

    public static int update(PhieuBaoTriDTO pbt) throws SQLException {
        return PhieuBaoTriDAO.exists(pbt.getMaPBT()) ? PhieuBaoTriDAO.update(pbt) : 0;
    }

    public static int delete(String maPBT) throws SQLException {
        return PhieuBaoTriDAO.exists(maPBT) ? PhieuBaoTriDAO.delete(maPBT) : 0;
    }
}