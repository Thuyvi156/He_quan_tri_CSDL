package DAO;

import DTO.KhachHangDTO;
import DTO.SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {

    private static final String SELECT = "SELECT * FROM KHACHHANG",
            SELECT_ID = SELECT + " WHERE MAKH = ?",
            INSERT = "INSERT INTO KHACHHANG (MAKH, HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES (?, ?, ?, ?, ?, ?)",
            UPDATE = "UPDATE KHACHHANG SET HOTEN_KH = ?, SDT_KH = ?, DIACHI_KH = ?, NGSINH_KH = ?, TICHLUY = ? WHERE MAKH = ?",
            DELETE = "DELETE FROM KHACHHANG WHERE MAKH = ?";

    private static KhachHangDTO getEntity(ResultSet rs) throws SQLException {
        KhachHangDTO kh = new KhachHangDTO();
        kh.setMaKH(rs.getString("MAKH"));
        kh.setHoTen(rs.getString("HOTEN_KH"));
        kh.setSdt(rs.getString("SDT_KH"));
        kh.setDiaChi(rs.getString("DIACHI_KH"));
        kh.setNgSinh(rs.getDate("NGSINH_KH"));
        kh.setTichLuy(rs.getDouble("TICHLUY"));
        return kh;
    }
    
    public static List<KhachHangDTO> query(String query, Object... args) throws SQLException {
        ResultSet rs = SQL.Query(query, args);
        List<KhachHangDTO> list = new ArrayList<>();
        while (rs.next()) {
            list.add(getEntity(rs));
        }
        return list;
    }
    
    public static List<KhachHangDTO> select() throws SQLException {
        return query(SELECT);
    }
    
    public static KhachHangDTO select(String maKH) throws SQLException {
        ResultSet rs = SQL.Query(SELECT_ID, maKH);
        return rs.next() ? getEntity(rs) : null;
    }
    
    public static boolean exists(String maKH) throws SQLException {
        return SQL.Query(SELECT_ID, maKH).next();
    }

    public static int insert(KhachHangDTO kh) throws SQLException {
        return SQL.Update(INSERT, kh.getMaKH(), kh.getHoTen(), kh.getSdt(), kh.getDiaChi(), kh.getNgSinh(), kh.getTichLuy());
    }

    public static int update(KhachHangDTO kh) throws SQLException {
        return SQL.Update(UPDATE, kh.getHoTen(), kh.getSdt(), kh.getDiaChi(), kh.getNgSinh(), kh.getTichLuy(), kh.getMaKH());
    }

    public static int delete(String maKH) throws SQLException {
        return SQL.Update(DELETE, maKH);
    }
    
}