package DAO;

import DTO.PhieuXuatKhoDTO;
import DTO.SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhieuXuatKhoDAO {

    private static final String SELECT = "SELECT * FROM PHIEUXUATKHO",
            SELECT_ID = SELECT + " WHERE MAPXK = ?",
            INSERT = "INSERT INTO PHIEUXUATKHO (MAPXK, MANC, NGXUAT, SL_XUAT, NOIDUNG_PXK) VALUES (?, ?, ?, ?, ?)",
            UPDATE = "UPDATE PHIEUXUATKHO SET MANC = ?, NGXUAT = ?, SL_XUAT = ?, NOIDUNG_PXK = ? WHERE MAPXK = ?",
            DELETE = "DELETE FROM PHIEUXUATKHO WHERE MAPXK = ?";

    private static PhieuXuatKhoDTO getEntity(ResultSet rs) throws SQLException {
        PhieuXuatKhoDTO pxk = new PhieuXuatKhoDTO();
        pxk.setMaPXK(rs.getString("MAPXK"));
        pxk.setMaNC(rs.getString("MANC"));
        pxk.setNgXuat(rs.getDate("NGXUAT"));
        pxk.setSoLuong(rs.getInt("SL_XUAT"));
        pxk.setNoiDung(rs.getString("NOIDUNG_PXK"));
        return pxk;
    }

    public static List<PhieuXuatKhoDTO> query(String query, Object... args) throws SQLException {
        ResultSet rs = SQL.Query(query, args);
        List<PhieuXuatKhoDTO> list = new ArrayList<>();
        while (rs.next()) {
            list.add(getEntity(rs));
        }
        return list;
    }

    public static List<PhieuXuatKhoDTO> select() throws SQLException {
        return query(SELECT);
    }

    public static PhieuXuatKhoDTO select(String maPXK) throws SQLException {
        ResultSet rs = SQL.Query(SELECT_ID, maPXK);
        return rs.next() ? getEntity(rs) : null;
    }

    public static boolean exists(String maPXK) throws SQLException {
        return SQL.Query(SELECT_ID, maPXK).next();
    }

    public static int insert(PhieuXuatKhoDTO pxk) throws SQLException {
        return SQL.Update(INSERT, pxk.getMaPXK(), pxk.getMaNC(), pxk.getNgXuat(), pxk.getSoLuong(), pxk.getNoiDung());
    }

    public static int update(PhieuXuatKhoDTO pxk) throws SQLException {
        return SQL.Update(UPDATE, pxk.getMaNC(), pxk.getNgXuat(), pxk.getSoLuong(), pxk.getNoiDung(), pxk.getMaPXK());
    }

    public static int delete(String maPXK) throws SQLException {
        return SQL.Update(DELETE, maPXK);
    }
}
