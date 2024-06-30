package DAO;

import DTO.BaoCaoDTO;
import DTO.SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaoCaoDAO {

    private static final String SELECT = "SELECT * FROM BAOCAO",
            SELECT_ID = SELECT + " WHERE MABC = ?",
            INSERT = "INSERT INTO BAOCAO (MABC, MANV, NGAYBC, CHITIETBC) VALUES (?, ?, ?, ?)",
            UPDATE = "UPDATE BAOCAO SET MANV = ?, NGAYBC = ?, CHITIETBC = ? WHERE MABC = ?",
            DELETE = "DELETE FROM BAOCAO WHERE MABC = ?";
    
    private static BaoCaoDTO getEntity(ResultSet rs) throws SQLException{
        BaoCaoDTO bc = new BaoCaoDTO();
        bc.setMaBC(rs.getString("MABC"));
        bc.setMaNV(rs.getString("MANV"));
        bc.setNgayBC(rs.getDate("NGAYBC"));
        bc.setChiTietBC(rs.getString("CHITIETBC"));
        return bc;
    }

    public static List<BaoCaoDTO> query(String query, Object... args) throws SQLException {
        ResultSet rs = SQL.Query(query, args);
        List<BaoCaoDTO> list = new ArrayList<>();
        while (rs.next()) {
            list.add(getEntity(rs));
        }
        return list;
    }
    
    public static List<BaoCaoDTO> select() throws SQLException {
        return query(SELECT);
    }
    
    public static BaoCaoDTO select(String maBC) throws SQLException {
        ResultSet rs = SQL.Query(SELECT_ID, maBC);
        return rs.next() ? getEntity(rs) : null;
    }
    
    public static boolean exists(String maBC) throws SQLException {
        return SQL.Query(SELECT_ID, maBC).next(); 
    }

    public static int insert(BaoCaoDTO bc) throws SQLException {
        return SQL.Update(INSERT, bc.getMaBC(), bc.getMaNV(), bc.getNgayBC(), bc.getChiTietBC());
    }

    public static int update(BaoCaoDTO bc) throws SQLException {
        return SQL.Update(UPDATE, bc.getMaNV(), bc.getNgayBC(), bc.getChiTietBC(), bc.getMaBC());
    }

    public static int delete(String maBC) throws SQLException {
        return SQL.Update(DELETE, maBC);
    }
    
}