package DAO;

import DTO.LoaiNhacCuDTO;
import DTO.SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiNhacCuDAO {

    private static final String SELECT = "SELECT * FROM LOAINHACCU",
            SELECT_ID = SELECT + " WHERE MALNC = ?",
            INSERT = "INSERT INTO LOAINHACCU (MALNC, TEN_LNC) VALUES (?, ?)",
            UPDATE = "UPDATE LOAINHACCU SET TEN_LNC = ? WHERE MALNC = ?",
            DELETE = "DELETE FROM LOAINHACCU WHERE MALNC = ?";

    private static LoaiNhacCuDTO getEntity(ResultSet rs) throws SQLException {
        LoaiNhacCuDTO lnc = new LoaiNhacCuDTO();
        lnc.setMaLNC(rs.getString("MALNC"));
        lnc.setTenLNC(rs.getString("TEN_LNC"));
        return lnc;
    }
    
    public static List<LoaiNhacCuDTO> query(String query, Object... args) throws SQLException {
        ResultSet rs = SQL.Query(query, args);
        List<LoaiNhacCuDTO> list = new ArrayList<>();
        while (rs.next()) {
            list.add(getEntity(rs));
        }
        return list;
    }
    
    public static List<LoaiNhacCuDTO> select() throws SQLException {
        return query(SELECT);
    }
    
    public static LoaiNhacCuDTO select(String maLNC) throws SQLException {
        ResultSet rs = SQL.Query(SELECT_ID, maLNC);
        return rs.next() ? getEntity(rs) : null;
    }
    
    public static boolean exists(String maLNC) throws SQLException {
        return SQL.Query(SELECT_ID, maLNC).next();
    }

    public static int insert(LoaiNhacCuDTO lnc) throws SQLException {
        return SQL.Update(INSERT, lnc.getMaLNC(), lnc.getTenLNC());
    }

    public static int update(LoaiNhacCuDTO lnc) throws SQLException {
        return SQL.Update(UPDATE, lnc.getTenLNC(), lnc.getMaLNC());
    }

    public static int delete(String maLNC) throws SQLException {
        return SQL.Update(DELETE, maLNC);
    }
    
}