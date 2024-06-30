package BUS;

import DAO.NhanVienDAO;
import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.sql.SQLException;
import java.util.List;

public class TaiKhoanBUS {

    public static List<TaiKhoanDTO> select() throws SQLException {
        return TaiKhoanDAO.select();
    }

    public static TaiKhoanDTO select(int idTK) throws SQLException {
        return TaiKhoanDAO.select(idTK);
    }

    public static boolean exists(int idTK) throws SQLException {
        return TaiKhoanDAO.exists(idTK);
    }

    public static int insert(TaiKhoanDTO tk) throws SQLException {
        return TaiKhoanDAO.exists(tk.getIdTK()) || !NhanVienDAO.exists(tk.getMaNV()) ? 0 : TaiKhoanDAO.insert(tk);
    }

    public static int update(TaiKhoanDTO tk) throws SQLException {
        return TaiKhoanDAO.exists(tk.getIdTK()) ? TaiKhoanDAO.update(tk) : 0;
    }

    public static int delete(int idTK) throws SQLException {
        return TaiKhoanDAO.exists(idTK) ? TaiKhoanDAO.delete(idTK) : 0;
    }
    
    
    
    public static TaiKhoanDTO LOGGED = null;
    public static boolean login(String maNV, String matKhau) throws SQLException {
        TaiKhoanDTO tk = TaiKhoanDAO.selectByMaNV(maNV);
        if(tk != null && tk.getMatKhau().equals(matKhau)) {
            LOGGED = tk;
            return true;
        } else {
            LOGGED = null;
            return false;
        }
    }
}