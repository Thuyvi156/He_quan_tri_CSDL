package DAO;

import DTO.NhaCungCapDTO;
import DTO.SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAO {

    private static final String SELECT = "SELECT * FROM NHACUNGCAP",
            SELECT_ID = SELECT + " WHERE MANCC = ?",
            INSERT = "INSERT INTO NHACUNGCAP (MANCC, TENNCC, SDT_NCC, DIACHI_NCC, EMAIL_NCC) VALUES (?, ?, ?, ?, ?)",
            UPDATE = "UPDATE NHACUNGCAP SET TENNCC = ?, SDT_NCC = ?, DIACHI_NCC = ?, EMAIL_NCC = ? WHERE MANCC = ?",
            DELETE = "DELETE FROM NHACUNGCAP WHERE MANCC = ?";

    private static NhaCungCapDTO getEntity(ResultSet rs) throws SQLException {
        NhaCungCapDTO ncc = new NhaCungCapDTO();
        ncc.setMaNCC(rs.getString("MANCC"));
        ncc.setTenNCC(rs.getString("TENNCC"));
        ncc.setSdt(rs.getString("SDT_NCC"));
        ncc.setDiaChi(rs.getString("DIACHI_NCC"));
        ncc.setEmail(rs.getString("EMAIL_NCC"));
        return ncc;
    }
    
    public static List<NhaCungCapDTO> query(String query, Object... args) throws SQLException {
        ResultSet rs = SQL.Query(query, args);
        List<NhaCungCapDTO> list = new ArrayList<>();
        while (rs.next()) {
            list.add(getEntity(rs));
        }
        return list;
    }
    
    public static List<NhaCungCapDTO> select() throws SQLException {
        return query(SELECT);
    }
    
    public static NhaCungCapDTO select(String maNCC) throws SQLException {
        ResultSet rs = SQL.Query(SELECT_ID, maNCC);
        return rs.next() ? getEntity(rs) : null;
    }
    
    public static boolean exists(String maNCC) throws SQLException {
        return SQL.Query(SELECT_ID, maNCC).next();
    }

    public static int insert(NhaCungCapDTO ncc) throws SQLException {
        return SQL.Update(INSERT, ncc.getMaNCC(), ncc.getTenNCC(), ncc.getSdt(), ncc.getDiaChi(), ncc.getEmail());
    }

    public static int update(NhaCungCapDTO ncc) throws SQLException {
        return SQL.Update(UPDATE, ncc.getTenNCC(), ncc.getSdt(), ncc.getDiaChi(), ncc.getEmail(), ncc.getMaNCC());
    }

    public static int delete(String maNCC) throws SQLException {
        return SQL.Update(DELETE, maNCC);
    }
}