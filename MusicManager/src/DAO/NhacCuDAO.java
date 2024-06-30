package DAO;

import DTO.NhacCuDTO;
import DTO.SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhacCuDAO {

    private static final String SELECT = "SELECT * FROM NHACCU",
            SELECT_ID = SELECT + " WHERE MANC = ?",
            INSERT = "INSERT INTO NHACCU (MANC, TENNC, HANG, HINH, GIANHAP, GIABAN, MALNC, TONGSL) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
            UPDATE = "UPDATE NHACCU SET TENNC = ?, HANG = ?, HINH = ?, GIANHAP = ?, GIABAN = ?, MALNC = ?, TONGSL = ? WHERE MANC = ?",
            DELETE = "DELETE FROM NHACCU WHERE MANC = ?";

    private static NhacCuDTO getEntity(ResultSet rs) throws SQLException {
        NhacCuDTO nc = new NhacCuDTO();
            nc.setMaNC(rs.getString("MANC"));
            nc.setTenNC(rs.getString("TENNC"));
            nc.setHang(rs.getString("HANG"));
            nc.setHinh(rs.getString("HINH"));
            nc.setGiaNhap(rs.getDouble("GIANHAP"));
            nc.setGiaBan(rs.getDouble("GIABAN"));
            nc.setMaLNC(rs.getString("MALNC"));
            nc.setTongSL(rs.getInt("TONGSL"));
            return nc;
    }
    
    public static List<NhacCuDTO> query(String query, Object... args) throws SQLException {
        ResultSet rs = SQL.Query(query, args);
        List<NhacCuDTO> list = new ArrayList<>();
        while (rs.next()) {
            list.add(getEntity(rs));
        }
        return list;
    }
    
    public static List<NhacCuDTO> select() throws SQLException {
        return query(SELECT);
    }

    public static NhacCuDTO select(String maNC) throws SQLException {
        ResultSet rs = SQL.Query(SELECT_ID, maNC);
        return rs.next() ? getEntity(rs) : null;
    }

    public static boolean exists(String maNC) throws SQLException {
        return SQL.Query(SELECT_ID, maNC).next();
    }

    public static int insert(NhacCuDTO nc) throws SQLException {
        return SQL.Update(INSERT, nc.getMaNC(), nc.getTenNC(), nc.getHang(), nc.getHinh(), nc.getGiaNhap(), nc.getGiaBan(), nc.getMaLNC(), nc.getTongSL());
    }

    public static int update(NhacCuDTO nc) throws SQLException {
        return SQL.Update(UPDATE, nc.getTenNC(), nc.getHang(), nc.getHinh(), nc.getGiaNhap(), nc.getGiaBan(), nc.getMaLNC(), nc.getTongSL(), nc.getMaNC());
    }

    public static int delete(String maNC) throws SQLException {
        return SQL.Update(DELETE, maNC);
    }

}