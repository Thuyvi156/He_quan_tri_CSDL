package DAO;

import DTO.TaiKhoanDTO;
import DTO.SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO {

    private static final String SELECT = "SELECT * FROM TAIKHOAN",
            SELECT_ID = SELECT + " WHERE ID_TK = ?",
            INSERT = "INSERT INTO TAIKHOAN (ID_TK, MANV, EMAIL, MATKHAU, VER_CODE, TRANGTHAI, VAITRO_NV) VALUES (?, ?, ?, ?, ?, ?, ?)",
            UPDATE = "UPDATE TAIKHOAN SET MANV = ?, EMAIL = ?, MATKHAU = ?, VER_CODE = ?, TRANGTHAI = ?, VAITRO_NV = ? WHERE ID_TK = ?",
            DELETE = "DELETE FROM TAIKHOAN WHERE ID_TK = ?";

    private static TaiKhoanDTO getEntity(ResultSet rs) throws SQLException {
        TaiKhoanDTO tk = new TaiKhoanDTO();
            tk.setIdTK(rs.getInt("ID_TK"));
            tk.setMaNV(rs.getString("MANV"));
            tk.setEmail(rs.getString("EMAIL"));
            tk.setMatKhau(rs.getString("MATKHAU"));
            tk.setVerCode(rs.getString("VER_CODE"));
            tk.setTrangThai(rs.getString("TRANGTHAI"));
            tk.setVaiTroNV(rs.getString("VAITRO_NV"));
            return tk;
    }
    
    public static List<TaiKhoanDTO> query(String query, Object... args) throws SQLException {
        ResultSet rs = SQL.Query(query, args);
        List<TaiKhoanDTO> list = new ArrayList<>();
        while (rs.next()) {
            list.add(getEntity(rs));
        }
        return list;
    }
    
    public static List<TaiKhoanDTO> select() throws SQLException {
        return query(SELECT);
    }
    
    public static TaiKhoanDTO select(int idTK) throws SQLException {
        ResultSet rs = SQL.Query(SELECT_ID, idTK);
        return rs.next() ? getEntity(rs) : null;
    }
    
    public static boolean exists(int idTK) throws SQLException {
        return SQL.Query(SELECT_ID, idTK).next();
    }

    public static int insert(TaiKhoanDTO tk) throws SQLException {
        return SQL.Update(INSERT, tk.getIdTK(), tk.getMaNV(), tk.getEmail(), tk.getMatKhau(), tk.getVerCode(), tk.getTrangThai(), tk.getVaiTroNV());
    }

    public static int update(TaiKhoanDTO tk) throws SQLException {
        return SQL.Update(UPDATE, tk.getMaNV(), tk.getEmail(), tk.getMatKhau(), tk.getVerCode(), tk.getTrangThai(), tk.getVaiTroNV(), tk.getIdTK());
    }

    public static int delete(int idTK) throws SQLException {
        return SQL.Update(DELETE, idTK);
    }
    
    
    
    private static final String SELECT_BY_MANV = "SELECT * FROM TAIKHOAN WHERE MANV = ?";
    public static TaiKhoanDTO selectByMaNV(String maNV) throws SQLException {
        ResultSet rs = SQL.Query(SELECT_BY_MANV, maNV);
        if (rs.next()) {
            TaiKhoanDTO tk = new TaiKhoanDTO();
            tk.setIdTK(rs.getInt("ID_TK"));
            tk.setMaNV(rs.getString("MANV"));
            tk.setEmail(rs.getString("EMAIL"));
            tk.setMatKhau(rs.getString("MATKHAU"));
            tk.setVerCode(rs.getString("VER_CODE"));
            tk.setTrangThai(rs.getString("TRANGTHAI"));
            tk.setVaiTroNV(rs.getString("VAITRO_NV"));
            return tk;
        }else return rs.next() ? getEntity(rs) : null;
    }
    
    
}