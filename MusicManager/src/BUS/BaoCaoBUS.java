package BUS;

import DAO.BaoCaoDAO;
import DTO.BaoCaoDTO;
import java.sql.SQLException;
import java.util.List;

public class BaoCaoBUS {

    public static List<BaoCaoDTO> select() throws SQLException {
        return BaoCaoDAO.select();
    }
    
    public static BaoCaoDTO select(String maBC) throws SQLException {
        return BaoCaoDAO.select(maBC);
    }
    
    public static boolean exists(String maBC) throws SQLException {
        return BaoCaoDAO.exists(maBC);
    }

    public static int insert(BaoCaoDTO bc) throws SQLException {
        return BaoCaoDAO.exists(bc.getMaBC()) ? 0 : BaoCaoDAO.insert(bc);
    }

    public static int update(BaoCaoDTO bc) throws SQLException {
        return BaoCaoDAO.exists(bc.getMaBC()) ? BaoCaoDAO.update(bc) : 0;
    }

    public static int delete(String maBC) throws SQLException {
        return BaoCaoDAO.exists(maBC) ? BaoCaoDAO.delete(maBC) : 0;
    }
    
}