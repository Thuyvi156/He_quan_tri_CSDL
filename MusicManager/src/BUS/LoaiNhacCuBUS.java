package BUS;

import DAO.LoaiNhacCuDAO;
import DTO.LoaiNhacCuDTO;
import java.sql.SQLException;
import java.util.List;

public class LoaiNhacCuBUS {

    public static List<LoaiNhacCuDTO> select() throws SQLException {
        return LoaiNhacCuDAO.select();
    }
    
    public static LoaiNhacCuDTO select(String maLNC) throws SQLException {
        return LoaiNhacCuDAO.select(maLNC);
    }
    
    public static boolean exists(String maLNC) throws SQLException {
        return LoaiNhacCuDAO.exists(maLNC);
    }

    public static int insert(LoaiNhacCuDTO lnc) throws SQLException {
        return LoaiNhacCuDAO.exists(lnc.getMaLNC()) ? 0 : LoaiNhacCuDAO.insert(lnc);
    }

    public static int update(LoaiNhacCuDTO lnc) throws SQLException {
        return LoaiNhacCuDAO.exists(lnc.getMaLNC()) ? LoaiNhacCuDAO.update(lnc) : 0;
    }

    public static int delete(String maLNC) throws SQLException {
        return LoaiNhacCuDAO.exists(maLNC) ? LoaiNhacCuDAO.delete(maLNC) : 0;
    }
}