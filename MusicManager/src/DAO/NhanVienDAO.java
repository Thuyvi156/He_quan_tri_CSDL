package DAO;

import DTO.NhanVienDTO;
import DTO.SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {

    private static final String SELECT = "SELECT * FROM NHANVIEN",
            SELECT_ID = SELECT + " WHERE MANV = ?",
            INSERT = "INSERT INTO NHANVIEN (MANV, HOTEN_NV, NGSINH_NV, SDT_NV, EMAIL_NV, VAITRO, NGVL) VALUES (?, ?, ?, ?, ?, ?, ?)",
            UPDATE = "UPDATE NHANVIEN SET HOTEN_NV = ?, NGSINH_NV = ?, SDT_NV = ?, EMAIL_NV = ?, VAITRO = ?, NGVL = ? WHERE MANV = ?",
            DELETE = "DELETE FROM NHANVIEN WHERE MANV = ?";

    private static NhanVienDTO getEntity(ResultSet rs) throws SQLException {
        NhanVienDTO nv = new NhanVienDTO();
        nv.setMaNV(rs.getString("MANV"));
        nv.setHoTen(rs.getString("HOTEN_NV"));
        nv.setNgaySinh(rs.getDate("NGSINH_NV"));
        nv.setSdt(rs.getString("SDT_NV"));
        nv.setEmail(rs.getString("EMAIL_NV"));
        nv.setVaiTro(rs.getString("VAITRO"));
        nv.setNgayVL(rs.getDate("NGVL"));
        return nv;
    }

    public static List<NhanVienDTO> query(String query, Object... args) throws SQLException {
        ResultSet rs = SQL.Query(query, args);
        List<NhanVienDTO> list = new ArrayList<>();
        while (rs.next()) {
            list.add(getEntity(rs));
        }
        return list;
    }

    public static List<NhanVienDTO> select() throws SQLException {
        return query(SELECT);
    }

    public static NhanVienDTO select(String maNV) throws SQLException {
        ResultSet rs = SQL.Query(SELECT_ID, maNV);
        return rs.next() ? getEntity(rs) : null;
    }

    public static boolean exists(String maNV) throws SQLException {
        return SQL.Query(SELECT_ID, maNV).next();
    }

    public static int insert(NhanVienDTO nv) throws SQLException {
        return SQL.Update(INSERT, nv.getMaNV(), nv.getHoTen(), nv.getNgaySinh(), nv.getSdt(), nv.getEmail(), nv.getVaiTro(), nv.getNgayVL());
    }

    public static int update(NhanVienDTO nv) throws SQLException {
        return SQL.Update(UPDATE, nv.getHoTen(), nv.getNgaySinh(), nv.getSdt(), nv.getEmail(), nv.getVaiTro(), nv.getNgayVL(), nv.getMaNV());
    }

    public static int delete(String maNV) throws SQLException {
        return SQL.Update(DELETE, maNV);
    }

}
