package BUS;

import DAO.NhacCuDAO;
import DTO.NhacCuDTO;
import java.sql.SQLException;
import java.util.List;

public class NhacCuBUS {

    public static List<NhacCuDTO> select() throws SQLException {
        return NhacCuDAO.select();
    }
    
    public static NhacCuDTO select(String maNC) throws SQLException {
        return NhacCuDAO.select(maNC);
    }
    
    public static boolean exists(String maNC) throws SQLException {
        return NhacCuDAO.exists(maNC);
    }

    public static int insert(NhacCuDTO nc) throws SQLException {
        return NhacCuDAO.exists(nc.getMaNC()) ? 0 : NhacCuDAO.insert(nc);
    }

    public static int update(NhacCuDTO nc) throws SQLException {
        return NhacCuDAO.exists(nc.getMaNC()) ? NhacCuDAO.update(nc) : 0;
    }

    public static int delete(String maNC) throws SQLException {
        return NhacCuDAO.exists(maNC) ? NhacCuDAO.delete(maNC) : 0;
    }
}