package DAO;

import DTO.PhieuNhapKhoDTO;
import DTO.SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhieuNhapKhoDAO {

    private static final String SELECT = "SELECT * FROM PHIEUNHAPKHO",
            SELECT_ID = SELECT + " WHERE MAPNK = ?",
            INSERT = "INSERT INTO PHIEUNHAPKHO (MAPNK, MANC, NGNHAP, MANCC, SL_NHAP, NOIDUNG_PNK) VALUES (?, ?, ?, ?, ?, ?)",
            UPDATE = "UPDATE PHIEUNHAPKHO SET MANC = ?, NGNHAP = ?, MANCC = ?, SL_NHAP = ?, NOIDUNG_PNK = ? WHERE MAPNK = ?",
            DELETE = "DELETE FROM PHIEUNHAPKHO WHERE MAPNK = ?";

    private static PhieuNhapKhoDTO getEntity(ResultSet rs) throws SQLException {
        PhieuNhapKhoDTO pnk = new PhieuNhapKhoDTO();
        pnk.setMaPNK(rs.getString("MAPNK"));
        pnk.setMaNC(rs.getString("MANC"));
        pnk.setNgNhap(rs.getDate("NGNHAP"));
        pnk.setMaNCC(rs.getString("MANCC"));
        pnk.setSoLuong(rs.getInt("SL_NHAP"));
        pnk.setNoiDung(rs.getString("NOIDUNG_PNK"));
        return pnk;
    }

    public static List<PhieuNhapKhoDTO> query(String query, Object... args) throws SQLException {
        ResultSet rs = SQL.Query(query, args);
        List<PhieuNhapKhoDTO> list = new ArrayList<>();
        while (rs.next()) {
            list.add(getEntity(rs));
        }
        return list;
    }

    public static List<PhieuNhapKhoDTO> select() throws SQLException {
        return query(SELECT);
    }

    public static PhieuNhapKhoDTO select(String maPNK) throws SQLException {
        ResultSet rs = SQL.Query(SELECT_ID, maPNK);
        return rs.next() ? getEntity(rs) : null;
    }

    public static boolean exists(String maPNK) throws SQLException {
        return SQL.Query(SELECT_ID, maPNK).next();
    }

    public static int insert(PhieuNhapKhoDTO pnk) throws SQLException {
        return SQL.Update(INSERT, pnk.getMaPNK(), pnk.getMaNC(), pnk.getNgNhap(), pnk.getMaNCC(), pnk.getSoLuong(), pnk.getNoiDung());
    }

    public static int update(PhieuNhapKhoDTO pnk) throws SQLException {
        return SQL.Update(UPDATE, pnk.getMaNC(), pnk.getNgNhap(), pnk.getMaNCC(), pnk.getSoLuong(), pnk.getNoiDung(), pnk.getMaPNK());
    }

    public static int delete(String maPNK) throws SQLException {
        return SQL.Update(DELETE, maPNK);
    }
}
