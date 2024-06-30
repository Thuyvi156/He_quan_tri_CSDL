package DAO;

import DTO.HoaDonDTO;
import DTO.SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO {

    private static final String SELECT = "SELECT * FROM HOADON",
            SELECT_ID = SELECT + " WHERE MAHD = ?",
            INSERT = "INSERT INTO HOADON (MAHD, MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES (?, ?, ?, ?, ?, ?, ?)",
            UPDATE = "UPDATE HOADON SET MANV = ?, MAKH = ?, DISCOUNT = ?, NGLAP = ?, TGBAOHANH = ?, TRIGIA = ? WHERE MAHD = ?",
            DELETE = "DELETE FROM HOADON WHERE MAHD = ?";

    private static HoaDonDTO getEntity(ResultSet rs) throws SQLException {
        HoaDonDTO hd = new HoaDonDTO();
        hd.setMaHD(rs.getString("MAHD"));
        hd.setMaNV(rs.getString("MANV"));
        hd.setMaKH(rs.getString("MAKH"));
        hd.setDiscount(rs.getDouble("DISCOUNT"));
        hd.setNgLap(rs.getDate("NGLAP"));
        hd.setTgBaoHanh(rs.getInt("TGBAOHANH"));
        hd.setTriGia(rs.getDouble("TRIGIA"));
        return hd;
    }
    
    public static List<HoaDonDTO> query(String query, Object... args) throws SQLException {
        ResultSet rs = SQL.Query(query, args);
        List<HoaDonDTO> list = new ArrayList<>();
        while (rs.next()) {
            list.add(getEntity(rs));
        }
        return list;
    }
    
    public static List<HoaDonDTO> select() throws SQLException {
        return query(SELECT);
    }
    
    public static HoaDonDTO select(String maHD) throws SQLException {
        ResultSet rs = SQL.Query(SELECT_ID, maHD);
        return rs.next() ? getEntity(rs) : null;
    }
    
    public static boolean exists(String maHD) throws SQLException {
        return SQL.Query(SELECT_ID, maHD).next();
    }

    public static int insert(HoaDonDTO hd) throws SQLException {
        return SQL.Update(INSERT, hd.getMaHD(), hd.getMaNV(), hd.getMaKH(), hd.getDiscount(), hd.getNgLap(), hd.getTgBaoHanh(), hd.getTriGia());
    }

    public static int update(HoaDonDTO hd) throws SQLException {
        return SQL.Update(UPDATE, hd.getMaNV(), hd.getMaKH(), hd.getDiscount(), hd.getNgLap(), hd.getTgBaoHanh(), hd.getTriGia(), hd.getMaHD());
    }

    public static int delete(String maHD) throws SQLException {
        return SQL.Update(DELETE, maHD);
    }

}