package DAO;

import DTO.PhieuBaoTriDTO;
import DTO.SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhieuBaoTriDAO {

    private static final String SELECT = "SELECT * FROM PHIEUBAOTRI",
            SELECT_ID = SELECT + " WHERE MAPBT = ?",
            INSERT = "INSERT INTO PHIEUBAOTRI (MAPBT, MANC, MAHD, NGBT, CHITIET_BT) VALUES (?, ?, ?, ?, ?)",
            UPDATE = "UPDATE PHIEUBAOTRI SET MANC = ?, MAHD = ?, NGBT = ?, CHITIET_BT = ? WHERE MAPBT = ?",
            DELETE = "DELETE FROM PHIEUBAOTRI WHERE MAPBT = ?";

    private static PhieuBaoTriDTO getEntity(ResultSet rs) throws SQLException {
        PhieuBaoTriDTO pbt = new PhieuBaoTriDTO();
        pbt.setMaPBT(rs.getString("MAPBT"));
        pbt.setMaNC(rs.getString("MANC"));
        pbt.setMaHD(rs.getString("MAHD"));
        pbt.setNgBT(rs.getDate("NGBT"));
        pbt.setChiTietBT(rs.getString("CHITIET_BT"));
        return pbt;
    }

    public static List<PhieuBaoTriDTO> query(String query, Object... args) throws SQLException {
        ResultSet rs = SQL.Query(query, args);
        List<PhieuBaoTriDTO> list = new ArrayList<>();
        while (rs.next()) {
            list.add(getEntity(rs));
        }
        return list;
    }

    public static List<PhieuBaoTriDTO> select() throws SQLException {
        return query(SELECT);
    }

    public static PhieuBaoTriDTO select(String maPBT) throws SQLException {
        ResultSet rs = SQL.Query(SELECT_ID, maPBT);
        return rs.next() ? getEntity(rs) : null;
    }

    public static boolean exists(String maPBT) throws SQLException {
        return SQL.Query(SELECT_ID, maPBT).next();
    }

    public static int insert(PhieuBaoTriDTO pbt) throws SQLException {
        return SQL.Update(INSERT, pbt.getMaPBT(), pbt.getMaNC(), pbt.getMaHD(), pbt.getNgBT(), pbt.getChiTietBT());
    }

    public static int update(PhieuBaoTriDTO pbt) throws SQLException {
        return SQL.Update(UPDATE, pbt.getMaNC(), pbt.getMaHD(), pbt.getNgBT(), pbt.getChiTietBT(), pbt.getMaPBT());
    }

    public static int delete(String maPBT) throws SQLException {
        return SQL.Update(DELETE, maPBT);
    }

}
