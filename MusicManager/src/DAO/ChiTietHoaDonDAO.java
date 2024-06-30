package DAO;

import DTO.ChiTietHoaDonDTO;
import DTO.SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDonDAO {

    private static final String SELECT = "SELECT * FROM CTHD",
            SELECT_ID = SELECT + " WHERE MAHD = ?",
            INSERT = "INSERT INTO CTHD (MAHD, MANC, SL, THANHTIEN) VALUES (?, ?, ?, ?)",
            UPDATE = "UPDATE CTHD SET MANC = ?, SL = ?, THANHTIEN = ? WHERE MAHD = ?",
            DELETE = "DELETE FROM CTHD WHERE MAHD = ?";
    
    private static ChiTietHoaDonDTO getEntity(ResultSet rs) throws SQLException {
        ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO();
        cthd.setMaHD(rs.getString("MAHD"));
        cthd.setMaNC(rs.getString("MANC"));
        cthd.setSoLuong(rs.getInt("SL"));
        cthd.setThanhTien(rs.getInt("THANHTIEN"));
        return cthd;
    }
    
    public static List<ChiTietHoaDonDTO> query(String query, Object... args) throws SQLException {
        ResultSet rs = SQL.Query(query, args);
        List<ChiTietHoaDonDTO> list = new ArrayList<>();
        while (rs.next()) {
            list.add(getEntity(rs));
        }
        return list;
    }
    
    public static List<ChiTietHoaDonDTO> select() throws SQLException {
        return query(SELECT);
    }
    
    public static List<ChiTietHoaDonDTO> select(String maHD) throws SQLException {
        return query(SELECT_ID, maHD);
    }
    
    public static boolean exists(String maHD) throws SQLException {
        return SQL.Query(SELECT_ID, maHD).next();
    }

    public static int insert(ChiTietHoaDonDTO cthd) throws SQLException {
        return SQL.Update(INSERT, cthd.getMaHD(), cthd.getMaNC(), cthd.getSoLuong(), cthd.getThanhTien());
    }

    public static int update(ChiTietHoaDonDTO cthd) throws SQLException {
        return SQL.Update(UPDATE, cthd.getMaNC(), cthd.getSoLuong(), cthd.getThanhTien(), cthd.getMaHD());
    }

    public static int delete(int soHD) throws SQLException {
        return SQL.Update(DELETE, soHD);
    }
   
}