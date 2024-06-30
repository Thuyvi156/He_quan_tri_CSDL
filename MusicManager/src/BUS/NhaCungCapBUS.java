package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.sql.SQLException;
import java.util.List;

public class NhaCungCapBUS {

    public static List<NhaCungCapDTO> select() throws SQLException {
        return NhaCungCapDAO.select();
    }
    
    public static NhaCungCapDTO select(String maNCC) throws SQLException {
        return NhaCungCapDAO.select(maNCC);
    }
    
    public static boolean exists(String maNCC) throws SQLException {
        return NhaCungCapDAO.exists(maNCC);
    }

    public static int insert(NhaCungCapDTO ncc) throws SQLException {
        return NhaCungCapDAO.exists(ncc.getMaNCC()) ? 0 : NhaCungCapDAO.insert(ncc);
    }

    public static int update(NhaCungCapDTO ncc) throws SQLException {
        return NhaCungCapDAO.exists(ncc.getMaNCC()) ? NhaCungCapDAO.update(ncc) : 0;
    }

    public static int delete(String maNCC) throws SQLException {
        return NhaCungCapDAO.exists(maNCC) ? NhaCungCapDAO.delete(maNCC) : 0;
    }
}
