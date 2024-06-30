-- Tạo Schema
alter session set "_ORACLE_SCRIPT"=true;
CREATE USER QLNHACCU IDENTIFIED BY password;
GRANT CONNECT, RESOURCE, DBA TO QLNHACCU
-- Sử dụng Schema
ALTER SESSION SET CURRENT_SCHEMA = QLNHACCU;


--Tạo bảng 
drop table KHACHHANG;
select * from KHACHHANG;
--Bảng KHACHHANG
CREATE TABLE KHACHHANG (
  MAKH CHAR(10) PRIMARY KEY,
  HOTEN_KH VARCHAR2(40),
  SDT_KH VARCHAR2(20),
  DIACHI_KH VARCHAR2(50),
  NGSINH_KH DATE,
  TICHLUY NUMBER DEFAULT 0 
)
--Thêm khóa ngoại
--Thêm ràng buộc 
ALTER TABLE KHACHHANG
      ADD CONSTRAINT HOTEN_KH CHECK('HOTEN_KH' IS NOT NULL)
      ADD CONSTRAINT SDT_KH CHECK('SDT_KH' IS NOT NULL)
      ADD CONSTRAINT DIACHI_KH CHECK('DIACHI_KH' IS NOT NULL)
      ADD CONSTRAINT NGSINH_KH CHECK('NGSINH_KH' IS NOT NULL);

-------
--Bảng NHANVIEN 
CREATE TABLE NHANVIEN (
  MANV CHAR(10) PRIMARY KEY,
  HOTEN_NV VARCHAR2(40),
  NGSINH_NV DATE,
  SDT_NV VARCHAR2(40),
  EMAIL_NV VARCHAR2(40),
  VAITRO VARCHAR2(40),
  NGVL DATE
)
--Thêm khóa ngoại
--Thêm ràng buộc 
ALTER TABLE NHANVIEN 
       ADD CONSTRAINT HOTEN_NV CHECK('HOTEN_NV' IS NOT NULL)
       ADD CONSTRAINT SDT_NV CHECK('SDT_NV' IS NOT NULL)
       ADD CONSTRAINT EMAIL_NV CHECK('EMAIL_NV' IS NOT NULL)
       ADD CONSTRAINT VAITRO CHECK('VAITRO' IS NOT NULL)
       ADD CONSTRAINT NGVL CHECK('NGVL' IS NOT NULL)
       ADD CONSTRAINT NGSINH_NV CHECK('NGSINH_NV' IS NOT NULL)
       ADD CONSTRAINT CH_NV1 CHECK (NGVL>NGSINH_NV)
       ADD CONSTRAINT CH_NV2 CHECK (VAITRO IN ('Nhân viên bán hàng','Nhân viên quản lý','Nhân viên bảo trì'));


-------
--Bảng TAIKHOAN 
CREATE TABLE TAIKHOAN (
  ID_TK NUMBER PRIMARY KEY,
  MANV CHAR(10),
  EMAIL VARCHAR2(50),
  MATKHAU VARCHAR2(20),
  VER_CODE VARCHAR2(10) DEFAULT NULL,
  TRANGTHAI VARCHAR2(20),
  VAITRO_NV VARCHAR2(40)
)
ALTER TABLE TAIKHOAN MODIFY TRANGTHAI VARCHAR2(20);
ALTER TABLE TAIKHOAN MODIFY VAITRO_NV VARCHAR2(40);

--Thêm khóa ngoại
ALTER TABLE TAIKHOAN ADD CONSTRAINT FK_TK FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV);
--Thêm ràng buộc
ALTER TABLE TAIKHOAN
        ADD CONSTRAINT CK_EMAIL CHECK('EMAIL' IS NOT NULL)
        ADD CONSTRAINT MATKHAU CHECK('MATKHAU' IS NOT NULL)
        ADD CONSTRAINT TRANGTHAI CHECK('TRANGTHAI' IS NOT NULL)
        ADD CONSTRAINT VAITRO_NV CHECK('NGVL' IS NOT NULL)
        ADD CONSTRAINT CH_TK1 CHECK (VAITRO_NV IN ('Nhân viên bán hàng','Nhân viên quản lý','Nhân viên bảo trì'))
        ADD CONSTRAINT CH_TK2 CHECK (TRANGTHAI IN ('Đã xác minh','Chưa xác minh'));

 
-------
--Bảng LOAINHACCU 
CREATE TABLE LOAINHACCU (
  MALNC CHAR(10) PRIMARY KEY,
  TEN_LNC VARCHAR2(40)
)
--Thêm khóa ngoại
--Thêm ràng buộc 
ALTER TABLE LOAINHACCU ADD CONSTRAINT TEN_LNC CHECK('TEN_LNC' IS NOT NULL);


-------
--Bảng NHACCU 
CREATE TABLE NHACCU (
  MANC CHAR(10) PRIMARY KEY,
  MALNC CHAR(10),
  TENNC VARCHAR2(40),
  HANG VARCHAR2(40),
  GIANHAP NUMBER,
  GIABAN NUMBER,
  TONGSL NUMBER DEFAULT 0
)
ALTER TABLE NHACCU MODIFY TENNC VARCHAR2(60);
--Thêm khóa ngoại
ALTER TABLE NHACCU ADD CONSTRAINT FK_NC FOREIGN KEY (MALNC) REFERENCES LOAINHACCU(MALNC);
--Thêm ràng buộc 
ALTER TABLE NHACCU
        ADD CONSTRAINT TENNC CHECK ('TENNC' IS NOT NULL)
        ADD CONSTRAINT HANG CHECK ('HANG' IS NOT NULL)
        ADD CONSTRAINT GIABAN CHECK ('GIABAN' IS NOT NULL)
        ADD CONSTRAINT GIANHAP CHECK ('GIANHAP' IS NOT NULL)
        ADD CONSTRAINT CH_NC CHECK (HANG IN ('Yamaha', 'KORG', 'Kawai', 'Young Chang', 'Roland', 'Enya Group Music', 'Cort', 'Sqoe', 'Joyo', 'KHALY', 'FULLY', 'NISSI', 'Gecko', 'Alto', 'Takstar', 'Mackie', 'Samson', 'PreSonus'));
ALTER TABLE NHACCU ADD CONSTRAINT CH_NC CHECK (GIABAN>GIANHAP);

-------
--Bảng HOADON 
CREATE TABLE HOADON (
  MAHD CHAR(10) PRIMARY KEY,
  MANV CHAR(10),
  MAKH CHAR(10),
  DISCOUNT NUMBER DEFAULT 0,  
  NGLAP DATE,
  TGBAOHANH NUMBER DEFAULT 0,
  TRIGIA NUMBER DEFAULT 0
)
--Thêm khóa ngoại
ALTER TABLE HOADON ADD CONSTRAINT FK_HD1 FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV);
ALTER TABLE HOADON ADD CONSTRAINT FK_HD2 FOREIGN KEY (MAKH) REFERENCES KHACHHANG(MAKH);
--Thêm ràng buộc 
ALTER TABLE HOADON ADD CONSTRAINT NGLAP CHECK ('NGLAP' IS NOT NULL); 


-------
--Bảng CTHD 
CREATE TABLE CTHD (
  MAHD CHAR(10),
  MANC CHAR(10),
  SL NUMBER DEFAULT 0,
  THANHTIEN NUMBER DEFAULT 0,
  CONSTRAINT PK_CTHD PRIMARY KEY (MAHD,MANC)
)
--Thêm khóa ngoại
ALTER TABLE CTHD ADD CONSTRAINT FK_CTHD1 FOREIGN KEY (MAHD) REFERENCES HOADON(MAHD);
ALTER TABLE CTHD ADD CONSTRAINT FK_CTHD2 FOREIGN KEY (MANC) REFERENCES NHACCU(MANC);
--Thêm ràng buộc 


-------
--Bảng NHACUNGCAP 
CREATE TABLE NHACUNGCAP (
  MANCC CHAR(10) PRIMARY KEY,
  TENNCC VARCHAR2(40),
  SDT_NCC VARCHAR2(20),
  DIACHI_NCC VARCHAR2(50),
  EMAIL_NCC VARCHAR2(40)
)
--Thêm khóa ngoại
--Thêm ràng buộc 
ALTER TABLE NHACUNGCAP
        ADD CONSTRAINT TENNCC CHECK ('TENNCC' IS NOT NULL)
        ADD CONSTRAINT SDT_NCC CHECK ('SDT_NCC' IS NOT NULL)
        ADD CONSTRAINT DIACHI_NCC CHECK ('DIACHI_NCC' IS NOT NULL)
        ADD CONSTRAINT EMAIL_NCC CHECK ('EMAIL_NCC' IS NOT NULL);


-------
--Bảng PHIEUNHAPKHO 
CREATE TABLE PHIEUNHAPKHO (
  MAPNK CHAR(10) PRIMARY KEY,
  MANC CHAR(10),
  MANCC CHAR(10),
  SL_NHAP NUMBER,
  NGNHAP DATE,
  NOIDUNG_PNK VARCHAR2(40) DEFAULT NULL
)
--Thêm khóa ngoại
ALTER TABLE PHIEUNHAPKHO ADD CONSTRAINT FK_PNK1 FOREIGN KEY (MANCC) REFERENCES NHACUNGCAP(MANCC);
ALTER TABLE PHIEUNHAPKHO ADD CONSTRAINT FK_PNK2 FOREIGN KEY (MANC) REFERENCES NHACCU(MANC);
--Thêm ràng buộc 
ALTER TABLE PHIEUNHAPKHO
        ADD CONSTRAINT NGNHAP CHECK ('NGNHAP' IS NOT NULL);

-------
--Bảng PHIEUXUATKHO 
CREATE TABLE PHIEUXUATKHO (
  MAPXK CHAR(10) PRIMARY KEY,
  MANC CHAR(10),
  SL_XUAT NUMBER,
  NGXUAT DATE,
  NOIDUNG_PXK VARCHAR2(40) DEFAULT NULL
)
--Thêm khóa ngoại
ALTER TABLE PHIEUXUATKHO ADD CONSTRAINT FK_PXK FOREIGN KEY (MANC) REFERENCES NHACCU(MANC);
--Thêm ràng buộc 
ALTER TABLE PHIEUXUATKHO
        ADD CONSTRAINT NGXUAT CHECK (NGXUAT IS NOT NULL);


-------
--Bảng PHIEUBAOTRI 
CREATE TABLE PHIEUBAOTRI (
  MAPBT CHAR(10) PRIMARY KEY,
  MANC CHAR(10),
  MAHD CHAR(10),
  NGBT DATE,
  CHITIET_BT VARCHAR2(40) DEFAULT NULL
)
--Thêm khóa ngoại
ALTER TABLE PHIEUBAOTRI ADD CONSTRAINT FK_PBT1 FOREIGN KEY (MAHD) REFERENCES HOADON(MAHD);
ALTER TABLE PHIEUBAOTRI ADD CONSTRAINT FK_PBT2 FOREIGN KEY (MANC) REFERENCES NHACCU(MANC);
--Thêm ràng buộc 
ALTER TABLE PHIEUBAOTRI
        ADD CONSTRAINT NGBT CHECK ('NGBT' IS NOT NULL);

-------
--Bảng BAOCAO 
CREATE TABLE BAOCAO (
  MABC CHAR(10) PRIMARY KEY,
  MANV CHAR(10),
  NGAYBC DATE,
  CHITIETBC VARCHAR2(50) DEFAULT NULL
)
--Thêm khóa ngoại
ALTER TABLE BAOCAO ADD CONSTRAINT FK_BC FOREIGN KEY (MANV) REFERENCES NHANVIEN(MANV);
--Thêm ràng buộc 
ALTER TABLE BAOCAO
        ADD CONSTRAINT NGAYBC CHECK ('NGAYBC' IS NOT NULL);


--Tạo sequence và trigger tăng tự động 
--KHACHHANG
--sequence 
CREATE SEQUENCE increase_MAKH
 INCREMENT BY 1
 START WITH 100
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE;
 --trigger  
CREATE OR REPLACE TRIGGER auto_increase_MAKH
BEFORE INSERT ON KHACHHANG
FOR EACH ROW 
BEGIN
    :NEW.MAKH := 'KH' || increase_MAKH.nextval;
END;
/


--NHANVIEN
--sequence 
CREATE SEQUENCE increase_MANV
 INCREMENT BY 1
 START WITH 100
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE;
--trigger 
CREATE OR REPLACE TRIGGER auto_increase_NV
BEFORE INSERT ON NHANVIEN
FOR EACH ROW 
BEGIN
    :NEW.MANV := 'NV' || increase_MANV.nextval;
END;
/ 

--TAIKHOAN
--sequence 
CREATE SEQUENCE increase_ID_TK
 INCREMENT BY 1
 START WITH 100
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE;
--trigger 
CREATE OR REPLACE TRIGGER auto_increase_ID_TK
BEFORE INSERT ON TAIKHOAN
FOR EACH ROW 
BEGIN
    :NEW.ID_TK := 0 || increase_ID_TK.nextval;
END;
/

--LOAINHACCU
--sequence 
CREATE SEQUENCE increase_MALNC
 INCREMENT BY 1
 START WITH 100
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE;
--trigger 
CREATE OR REPLACE TRIGGER auto_increase_MALNC
BEFORE INSERT ON LOAINHACCU
FOR EACH ROW 
BEGIN
    :NEW.MALNC := 'LNC' || increase_MALNC.nextval;
END;
/

--NHACCU
--sequence 
CREATE SEQUENCE increase_MANC
 INCREMENT BY 1
 START WITH 100
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE;
--trigger  
CREATE OR REPLACE TRIGGER auto_increase_MANC
BEFORE INSERT ON NHACCU
FOR EACH ROW 
BEGIN
    :NEW.MANC := 'NC' || increase_MANC.nextval;
END;
/

--HOADON
--sequence 
CREATE SEQUENCE increase_MAHD
 INCREMENT BY 1
 START WITH 100
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE;
--trigger  
CREATE OR REPLACE TRIGGER auto_increase_MAHD
BEFORE INSERT ON HOADON
FOR EACH ROW 
BEGIN
    :NEW.MAHD := 'HD' || increase_MAHD.nextval;
END;
/

--NHACUNGCAP
--sequence 
CREATE SEQUENCE increase_MANCC
 INCREMENT BY 1
 START WITH 100
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE;
--trigger  
CREATE OR REPLACE TRIGGER auto_increase_MANCC
BEFORE INSERT ON NHACUNGCAP
FOR EACH ROW 
BEGIN
    :NEW.MANCC := 'NCC' || increase_MANCC.nextval;
END;
/

--PHIEUNHAPKHO
--sequence 
CREATE SEQUENCE increase_MAPNK
 INCREMENT BY 1
 START WITH 100
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE;
--trigger   
CREATE OR REPLACE TRIGGER auto_increase_MAPNK
BEFORE INSERT ON PHIEUNHAPKHO
FOR EACH ROW 
BEGIN
    :NEW.MAPNK := 'PNK' || increase_MAPNK.nextval;
END;
/

--PHIEUXUATKHO
--sequence 
CREATE SEQUENCE increase_MAPXK
 INCREMENT BY 1
 START WITH 100
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE;
--trigger   
CREATE OR REPLACE TRIGGER auto_increase_MAPXK
BEFORE INSERT ON PHIEUXUATKHO
FOR EACH ROW 
BEGIN
    :NEW.MAPXK := 'PXK' || increase_MAPXK.nextval;
END;
/

--PHIEUBAOTRI
--sequence 
CREATE SEQUENCE increase_MAPBT
 INCREMENT BY 1
 START WITH 100
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE;
--trigger   
CREATE OR REPLACE TRIGGER auto_increase_MAPBT
BEFORE INSERT ON PHIEUBAOTRI
FOR EACH ROW 
BEGIN
    :NEW.MAPBT := 'PBT' || increase_MAPBT.nextval;
END;
/

--BAOCAO
--sequence 
CREATE SEQUENCE increase_MABC
 INCREMENT BY 1
 START WITH 100
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE;
--trigger   
CREATE OR REPLACE TRIGGER auto_increase_MABC
BEFORE INSERT ON BAOCAO
FOR EACH ROW 
BEGIN
    :NEW.MABC := 'BC' || increase_MABC.nextval;
END;
/

--Trigger/Func/Proc

--Trigger

/*R18: Chỉ có nhân viên bán hàng mới được lập hóa đơn*/
--Bảng HOADON 
CREATE OR REPLACE TRIGGER TRIGGER_LAPHD_HDNV1
BEFORE INSERT OR UPDATE ON HOADON
FOR EACH ROW
DECLARE 
  v_VAITRO NHANVIEN.VAITRO%TYPE;
BEGIN
  --Lấy thông tin VAITRO từ bảng NHANVIEN 
  SELECT VAITRO INTO v_VAITRO
  FROM NHANVIEN
  WHERE MANV= :NEW.MANV;
  --Kiểm tra điều kiện và xử lý 
  IF(v_VAITRO='Nhân viên bán hàng') THEN 
    DBMS_OUTPUT.PUT_LINE('YEU CAU THANH CONG');
   ELSE
    -- Nếu muốn hủy thêm hoặc sửa, hãy sử dụng RAISE_APPLICATION_ERROR
    RAISE_APPLICATION_ERROR(-20001, 'ERROR: SAI VAI TRO!');
  END IF;
END;
/
--nv ban hang: 102 103 104 105 106
/*
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV100', 'KH100', 0, TO_DATE('2023-12-01', 'YYYY-MM-DD'), 12,0); --Loi
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV102', 'KH100', 0, TO_DATE('2023-12-01', 'YYYY-MM-DD'), 12,0); --Khong loi, dung vai tro


SELECT * FROM HOADON;
*/
--Bảng NHANVIEN 
CREATE OR REPLACE TRIGGER TRIGGER_LAPHD_HDNV2
BEFORE UPDATE ON NHANVIEN
FOR EACH ROW
DECLARE 
    v_MANV NHANVIEN.MANV%TYPE;
    v_MAHD HOADON.MAHD%TYPE;
    CURSOR cursorNV IS
      SELECT MAHD
      FROM HOADON
      WHERE MANV= :NEW.MANV;
BEGIN
    OPEN cursorNV;
    FETCH cursorNV INTO v_MAHD;
    WHILE cursorNV%FOUND LOOP
      SELECT MANV INTO v_MANV
      FROM HOADON 
      WHERE MAHD=v_MAHD;
      
      --Nhân viên bán hàng thì kh được sửa 
      IF (v_MANV=:NEW.MANV AND :NEW.VAITRO = 'Nhân viên bán hàng') THEN 
        RAISE_APPLICATION_ERROR(-20001, 'ERROR: KHONG THE SUA VAI TRO!');
        ROLLBACK;
        EXIT;
      END IF;
    END LOOP;
    CLOSE cursorNV;
  DBMS_OUTPUT.PUT_LINE('YEU CAU THANH CONG!');
END;
/
/*
UPDATE NHANVIEN
SET VAITRO='Nhân viên bảo trì'
WHERE MANV='NV103';
SELECT * FROM NHANVIEN;
*/

/*R19: Ngày nhân viên lập hóa đơn phải lớn hơn hoặc bằng ngày vào làm.*/
CREATE OR REPLACE TRIGGER TRIGGER_NGAY_HDNV
BEFORE INSERT OR UPDATE ON HOADON
FOR EACH ROW
DECLARE
    v_ngvl DATE;
BEGIN
    IF INSERTING THEN
    SELECT NGVL INTO v_ngvl 
		FROM NHANVIEN 
		WHERE MANV = :NEW.MANV;

        IF :NEW.NGLAP <= v_ngvl THEN
            RAISE_APPLICATION_ERROR(-20001, 'Ngay nhan vien lap hoa don phai lon hon hoac bang ngay vao lam');
        END IF;
    ELSIF UPDATING('NGLAP') OR UPDATING('MANV') THEN
        SELECT NGVL INTO v_ngvl 
		FROM NHANVIEN WHERE 
		MANV = :NEW.MANV;

        IF (:NEW.NGLAP <= v_ngvl) THEN
            RAISE_APPLICATION_ERROR(-20001, 'Ngay nhan vien lap hoa don phai lon hon hoac bang ngay vao lam');
        END IF;
    END IF;
END;
/

/*
SELECT * FROM HOADON;
SELECT * FROM NHANVIEN;

INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV100', 'KH100', 0, TO_DATE('2019-12-30', 'YYYY-MM-DD'), 12,0); --Loi
*/

/*R28: Ngày nhập phải bé hơn ngày xuất kho của nhạc cụ đó.*/
--Bảng PHIEUXUATKHO
CREATE OR REPLACE TRIGGER TRIGGER_NGAYNHAPXUAT_PNKPXK1 
BEFORE INSERT OR UPDATE ON PHIEUXUATKHO
FOR EACH ROW
DECLARE
    v_NGNHAP PHIEUNHAPKHO.NGNHAP%TYPE;
    v_MANC NHACCU.MANC%TYPE;
BEGIN
    --Lấy MANC từ NHACCU 
    SELECT MANC INTO v_MANC
    FROM NHACCU
    WHERE MANC = :NEW.MANC;
    --Lấy thông tin NGNHAP từ bảng PHIEUNHAPKHO 
    SELECT NGNHAP INTO v_NGNHAP
    FROM PHIEUNHAPKHO
    WHERE MANC=v_MANC;
    
    --Ktra điều kiện và xử lý 
    IF(:NEW.NGXUAT < v_NGNHAP) THEN 
    -- Nếu muốn hủy thêm hoặc sửa, hãy sử dụng RAISE_APPLICATION_ERROR
      RAISE_APPLICATION_ERROR(-20001, 'ERROR: NGAY XUAT KHO PHAI LON HON NGAY NHAP KHO!');
    ELSE
      DBMS_OUTPUT.PUT_LINE('YEU CAU THANH CONG!');
    END IF;
END;
/
/*
SELECT * FROM PHIEUXUATKHO;
SELECT * FROM PHIEUNHAPKHO;
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC101', 5, TO_DATE('2022-08-20','YYYY-MM-DD'), 'Xuất hàng bán lẻ cho khách hàng');
*/

--Bảng PHIEUNHAPKHO 
CREATE OR REPLACE TRIGGER TRIGGER_NGAYNHAPXUAT_PNKPXK2 
BEFORE UPDATE ON PHIEUNHAPKHO
FOR EACH ROW
DECLARE 
  v_MANC NHACCU.MANC%TYPE;
  v_NGXUAT PHIEUXUATKHO.NGXUAT%TYPE;
  CURSOR cursorHD IS
    SELECT MANC 
    FROM NHACCU
    WHERE MANC=:NEW.MANC;
BEGIN
    OPEN cursorHD;
    FETCH cursorHD INTO v_MANC;
    WHILE cursorHD%FOUND LOOP
      SELECT NGXUAT INTO v_NGXUAT
      FROM PHIEUXUATKHO
      WHERE MANC=v_MANC;
       
      IF(v_NGXUAT<:NEW.NGNHAP) THEN
        RAISE_APPLICATION_ERROR(-20001, 'ERROR: YEU CAU KHONG THANH CONG!');
        ROLLBACK;
        EXIT;
      END IF;

    END LOOP;
    CLOSE cursorHD;
  DBMS_OUTPUT.PUT_LINE('YEU CAU THANH CONG!');
END;
/
--test



/*R32: Ngày lập hóa đơn sản phẩm phải bé hơn ngày lập phiếu bảo trì.*/
--Bảng PHIEUBAOTRI 
CREATE OR REPLACE TRIGGER TRIGGER_NGAY_HDPBT1 
BEFORE INSERT OR UPDATE ON PHIEUBAOTRI
FOR EACH ROW
DECLARE
    v_NGLAP HOADON.NGLAP%TYPE;
BEGIN
    --Lấy thông tin NGLAP từ bảng HOADON 
    SELECT NGLAP INTO v_NGLAP
    FROM HOADON
    WHERE MAHD=:NEW.MAHD;
    
    --Ktra điều kiện và xử lý 
    IF(:NEW.NGBT < v_NGLAP) THEN 
    -- Nếu muốn hủy thêm hoặc sửa, hãy sử dụng RAISE_APPLICATION_ERROR
      RAISE_APPLICATION_ERROR(-20001, 'ERROR: SAI VAI TRO!');
    ELSE
      DBMS_OUTPUT.PUT_LINE('YEU CAU THANH CONG');
    END IF;
END;
/
/*
SELECT * FROM HOADON;
SELECT * FROM PHIEUBAOTRI;
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC100', 'HD100', TO_DATE('2023-11-01','YYYY-MM-DD'), 'Bảo trì đàn organ Yamaha'); -- LOI
*/

--Bảng HOADON 
CREATE OR REPLACE TRIGGER TRIGGER_NGAY_HDPBT2
BEFORE UPDATE ON HOADON
FOR EACH ROW
DECLARE 
  v_MAPBT PHIEUBAOTRI.MAPBT%TYPE;
  v_NGBT PHIEUBAOTRI.NGBT%TYPE;
  CURSOR cursorHD IS
    SELECT MAPBT 
    FROM PHIEUBAOTRI
    WHERE MAHD=:NEW.MAHD;
BEGIN
    OPEN cursorHD;
    FETCH cursorHD INTO v_MAPBT;
    WHILE cursorHD%FOUND LOOP
      SELECT NGBT INTO v_NGBT
      FROM PHIEUBAOTRI
      WHERE MAPBT=v_MAPBT;
       
      IF(v_NGBT<:NEW.NGLAP) THEN
        RAISE_APPLICATION_ERROR(-20001, 'ERROR: YEU CAU KHONG THANH CONG!');
        ROLLBACK;
        EXIT;
      END IF;

    END LOOP;
    CLOSE cursorHD;
  DBMS_OUTPUT.PUT_LINE('YEU CAU THANH CONG');
END;
/
--test 



/*R34: Chỉ có nhân viên quản lý mới được tạo báo cáo*/
--Bảng BAOCAO 
CREATE OR REPLACE TRIGGER TRIGGER_TAOBC_BCNV1
BEFORE INSERT OR UPDATE ON BAOCAO
FOR EACH ROW
DECLARE 
  v_VAITRO NHANVIEN.VAITRO%TYPE;
BEGIN
  --Lấy thông tin VAITRO từ bảng NHANVIEN 
  SELECT VAITRO INTO v_VAITRO
  FROM NHANVIEN
  WHERE MANV= :NEW.MANV;
  --Kiểm tra điều kiện và xử lý 
  IF(v_VAITRO='Nhân viên quản lý') THEN 
    DBMS_OUTPUT.PUT_LINE('YEU CAU THANH CONG!');
   ELSE
    -- Nếu muốn hủy thêm hoặc sửa, hãy sử dụng RAISE_APPLICATION_ERROR
    RAISE_APPLICATION_ERROR(-20001, 'ERROR: SAI VAI TRO!');
  END IF;
END;
/
/*
--NV QUAN LY: 100 101
SELECT * FROM BAOCAO;
SELECT * FROM NHANVIEN;
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV103', TO_DATE('2022-11-20','YYYY-MM-DD'), 'Báo cáo doanh thu tháng 11/2022');

*/

--Bảng NHANVIEN 
CREATE OR REPLACE TRIGGER TRIGGER_TAOBC_BCNV2
BEFORE UPDATE ON NHANVIEN
FOR EACH ROW
DECLARE 
    v_MANV NHANVIEN.MANV%TYPE;
    v_MABC BAOCAO.MABC%TYPE;
    CURSOR cursorNV IS
      SELECT MABC 
      FROM BAOCAO
      WHERE MANV= :NEW.MANV;
BEGIN
    OPEN cursorNV;
    FETCH cursorNV INTO v_MABC;
    WHILE cursorNV%FOUND LOOP
      SELECT MANV INTO v_MANV
      FROM BAOCAO
      WHERE MABC=v_MABC;
       
      IF (v_MANV=:NEW.MANV AND :NEW.VAITRO = 'Nhân viên quản lý') THEN 
        RAISE_APPLICATION_ERROR(-20001, 'ERROR: KHONG THE SUA VAI TRO!');
        ROLLBACK;
        EXIT;
      END IF;
    END LOOP;
    CLOSE cursorNV;
  DBMS_OUTPUT.PUT_LINE('YEU CAU THANH CONG!');
END;
/
/* test
*/





----Function 
--Tích lũy ở bảng khách hàng bằng tổng tiền các hóa đơn mà khách hàng đã mua
CREATE OR REPLACE FUNCTION cap_nhat_tich_luy_khach_hang (
    p_makh CHAR
) RETURN NUMBER IS
    v_tichluy NUMBER := 0;  -- Biến tích lũy ban đầu là 0
BEGIN
    -- Tính tổng tiền các hóa đơn của khách hàng
    SELECT NVL(SUM(TRIGIA), 0)
    INTO v_tichluy
    FROM HOADON
    WHERE MAKH = p_makh;

    -- Cập nhật giá trị tích lũy vào bảng KHACHHANG
    UPDATE KHACHHANG
    SET TICHLUY = v_tichluy
    WHERE MAKH = p_makh;

    -- Trả về giá trị tích lũy sau khi cập nhật
    RETURN v_tichluy;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        -- Nếu không tìm thấy dữ liệu, trả về 0
        RETURN 0;
    WHEN OTHERS THEN
        -- Xử lý ngoại lệ khác bằng cách raise lên
        RAISE;
END;
/

select * from khachhang;
/*
DECLARE
    v_result NUMBER;
BEGIN
    -- Gọi hàm và lưu kết quả vào biến v_result
    v_result := cap_nhat_tich_luy_khach_hang('KH100');

    -- Hiển thị kết quả
    DBMS_OUTPUT.PUT_LINE('Giá trị tích lũy mới: ' || v_result);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Lỗi: ' || SQLERRM);
END;
*/

--Tich Luy
CREATE OR REPLACE FUNCTION CAP_VOUCHER(
    p_MAKH CHAR,
    p_MAHD CHAR
) RETURN VARCHAR2 IS
    v_TICHLUY NUMBER;
    v_TRIGIA NUMBER;
    v_VOUCHER VARCHAR2(20);
BEGIN
    -- L?y tr? giá hóa ðõn
    SELECT TRIGIA INTO v_TRIGIA
    FROM HOADON
    WHERE MAHD = p_MAHD;

    -- C?p nh?t tích l?y cho khách hàng
    UPDATE KHACHHANG
    SET TICHLUY = TICHLUY + v_TRIGIA
    WHERE MAKH = p_MAKH;

    -- L?y t?ng s? ti?n tích l?y sau khi c?p nh?t
    SELECT TICHLUY INTO v_TICHLUY
    FROM KHACHHANG
    WHERE MAKH = p_MAKH;

    -- Xác ð?nh m?c voucher
    IF v_TICHLUY >= 5000000 AND v_TICHLUY < 8000000 THEN
        v_VOUCHER := 'VOUCHER 10%';
    ELSIF v_TICHLUY >= 8000000 AND v_TICHLUY < 10000000 THEN
        v_VOUCHER := 'VOUCHER 15%';
    ELSIF v_TICHLUY >= 10000000 THEN
        v_VOUCHER := 'VOUCHER 20%';
        -- Ð?t l?i tích l?y v? 0 khi ð?t m?c cao nh?t và nh?n voucher
        UPDATE KHACHHANG
        SET TICHLUY = 0
        WHERE MAKH = p_MAKH;
    ELSE
        v_VOUCHER := 'KHONG CO VOUCHER';
    END IF;

    RETURN v_VOUCHER;
END;


select * from HOADON
--Thanh tien cho CTHD
CREATE OR REPLACE FUNCTION calculate_thanh_tien_cthd(
    p_mahd CHAR
) RETURN NUMBER IS
    v_thanh_tien NUMBER := 0;
BEGIN
    -- Cập nhật thành tiền cho từng chi tiết hóa đơn (CTHD)
    UPDATE CTHD
    SET THANHTIEN = SL * (SELECT GIABAN FROM NHACCU WHERE MANC = CTHD.MANC)
    WHERE MAHD = p_mahd;

    -- Tính tổng thành tiền của các chi tiết hóa đơn
    SELECT SUM(THANHTIEN)
    INTO v_thanh_tien
    FROM CTHD
    WHERE MAHD = p_mahd;
    RETURN v_thanh_tien;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0; -- Xử lý khi không tìm thấy dữ liệu
    WHEN OTHERS THEN
        RAISE; -- Xử lý ngoại lệ khác
END;

/*
DECLARE
    v_thanh_tien NUMBER;
BEGIN
    -- Gọi hàm để cập nhật lại thành tiền cho các chi tiết hóa đơn của MAHD cụ thể
    v_thanh_tien := calculate_thanh_tien_cthd('HD101');
    -- In ra tổng thành tiền đã tính toán
    DBMS_OUTPUT.PUT_LINE('Tổng thành tiền của hóa đơn: ' || v_thanh_tien);

EXCEPTION
    WHEN OTHERS THEN
        -- Xử lý ngoại lệ nếu có lỗi xảy ra
        DBMS_OUTPUT.PUT_LINE('Lỗi: ' || SQLERRM);
END;
/
*/

select * from CTHD
select * from NHACCU
/
CREATE OR REPLACE FUNCTION calculate_and_update_trigia(
    v_mahd CHAR
) RETURN NUMBER IS
    v_thanh_tien NUMBER := 0;
    v_discount NUMBER := 0;
    v_trigia NUMBER := 0;
BEGIN
    -- Cập nhật lại thành tiền của các chi tiết hóa đơn (CTHD)
    UPDATE CTHD
    SET THANHTIEN = SL * (SELECT GIABAN FROM NHACCU WHERE MANC = CTHD.MANC)
    WHERE MAHD = v_mahd;

    -- Tính tổng thành tiền từ các chi tiết hóa đơn
    SELECT NVL(SUM(THANHTIEN), 0)
    INTO v_thanh_tien
    FROM CTHD
    WHERE MAHD = v_mahd;

    -- Lấy giảm giá từ voucher (nếu có)
    SELECT NVL(DISCOUNT, 0)
    INTO v_discount
    FROM HOADON
    WHERE MAHD = v_mahd;

    -- Áp dụng giảm giá từ voucher nếu có
    v_trigia := v_thanh_tien * (1 - v_discount / 100);

    -- Cập nhật trị giá hóa đơn trong bảng HOADON
    UPDATE HOADON
    SET TRIGIA = v_trigia
    WHERE MAHD = v_mahd;

    RETURN v_trigia;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0; -- Xử lý khi không tìm thấy dữ liệu
    WHEN OTHERS THEN
        RAISE; -- Xử lý ngoại lệ khác
END;
/
DECLARE
    v_mahd CHAR(10):= 'HD100'; -- Thay thế bằng mã hóa đơn cần tính lại TRIGIA
    v_trigia NUMBER;
BEGIN
    -- Gọi lại hàm để tính và cập nhật TRIGIA cho hóa đơn
    v_trigia := calculate_and_update_trigia(v_mahd);

    -- In ra giá trị TRIGIA đã tính toán và cập nhật
    DBMS_OUTPUT.PUT_LINE('TRIGIA của hóa đơn ' || v_mahd || ' sau khi tính toán là: ' || v_trigia);
EXCEPTION
    WHEN OTHERS THEN
        -- Xử lý ngoại lệ nếu có lỗi xảy ra
        DBMS_OUTPUT.PUT_LINE('Lỗi: ' || SQLERRM);
END;
/

--Tang giam so luong nhac cu
CREATE OR REPLACE FUNCTION update_soluong_nhap(
    p_manc CHAR,
    p_sl_nhap NUMBER
) RETURN NUMBER IS
    v_soluong NUMBER;
BEGIN
    -- L?y s? lý?ng hi?n t?i t? b?ng NHACCU
    SELECT TONGSL INTO v_soluong
    FROM NHACCU
    WHERE MANC = p_manc;

    -- C?p nh?t s? lý?ng m?i
    v_soluong := v_soluong + p_sl_nhap;

    -- C?p nh?t s? lý?ng trong b?ng NHACCU
    UPDATE NHACCU
    SET TONGSL = v_soluong
    WHERE MANC = p_manc;

    RETURN v_soluong;
END;

/*
--Nhap
DECLARE
    v_new_soluong NUMBER;
BEGIN
    -- Gọi hàm để cập nhật số lượng cho một MANC cụ thể và số lượng nhập
    v_new_soluong := update_soluong_nhap('NC100', 20);

    -- In ra kết quả số lượng mới đã cập nhật
    DBMS_OUTPUT.PUT_LINE('Số lượng mới: ' || v_new_soluong);
EXCEPTION
    WHEN OTHERS THEN
        -- Xử lý ngoại lệ nếu có lỗi xảy ra
        DBMS_OUTPUT.PUT_LINE('Lỗi: ' || SQLERRM);
END;
/
*/

---Cap nhat so luong nhac cu khi xuat
CREATE OR REPLACE FUNCTION update_soluong_xuat(
    p_manc CHAR,
    p_sl_xuat NUMBER
) RETURN NUMBER IS
    v_soluong NUMBER;
BEGIN
    -- L?y s? lý?ng hi?n t?i t? b?ng NHACCU
    SELECT TONGSL INTO v_soluong
    FROM NHACCU
    WHERE MANC = p_manc;

    -- Ki?m tra n?u s? lý?ng xu?t l?n hõn s? lý?ng hi?n t?i
    IF p_sl_xuat > v_soluong THEN
        RAISE_APPLICATION_ERROR(-20001, 'S? lý?ng xu?t l?n hõn s? lý?ng hi?n có.');
    END IF;

    -- C?p nh?t s? lý?ng m?i
    v_soluong := v_soluong - p_sl_xuat;

    -- C?p nh?t s? lý?ng trong b?ng NHACCU
    UPDATE NHACCU
    SET TONGSL = v_soluong
    WHERE MANC = p_manc;

    RETURN v_soluong;
END;

/*
DECLARE
    v_new_soluong NUMBER;
BEGIN
    -- Gọi hàm để cập nhật số lượng xuất cho một MANC cụ thể và số lượng xuất
    v_new_soluong := update_soluong_xuat('NC100', 5);

    -- In ra kết quả số lượng mới đã cập nhật
    DBMS_OUTPUT.PUT_LINE('Số lượng mới: ' || v_new_soluong);
EXCEPTION
    WHEN OTHERS THEN
        -- Xử lý ngoại lệ nếu có lỗi xảy ra
        DBMS_OUTPUT.PUT_LINE('Lỗi: ' || SQLERRM);
END;
/
*/


---Cap nhat so luong nhac cu khi ban
CREATE OR REPLACE FUNCTION update_soluong_ban(
    p_manc CHAR,
    p_sl_ban NUMBER
) RETURN NUMBER IS
    v_soluong NUMBER;
BEGIN
    -- L?y s? lý?ng hi?n t?i t? b?ng NHACCU
    SELECT TONGSL INTO v_soluong
    FROM NHACCU
    WHERE MANC = p_manc;

    -- Ki?m tra n?u s? lý?ng bán l?n hõn s? lý?ng hi?n t?i
    IF p_sl_ban > v_soluong THEN
        RAISE_APPLICATION_ERROR(-20001, 'S? lý?ng bán l?n hõn s? lý?ng hi?n có.');
    END IF;

    -- C?p nh?t s? lý?ng m?i
    v_soluong := v_soluong - p_sl_ban;

    -- C?p nh?t s? lý?ng trong b?ng NHACCU
    UPDATE NHACCU
    SET TONGSL = v_soluong
    WHERE MANC = p_manc;

    RETURN v_soluong;
END;

/*
DECLARE
    v_new_soluong NUMBER;
BEGIN
    -- Gọi hàm để cập nhật số lượng bán cho một MANC cụ thể và số lượng bán
    v_new_soluong := update_soluong_ban('NC100', 3);

    -- In ra kết quả số lượng mới đã cập nhật
    DBMS_OUTPUT.PUT_LINE('Số lượng mới: ' || v_new_soluong);
EXCEPTION
    WHEN OTHERS THEN
        -- Xử lý ngoại lệ nếu có lỗi xảy ra
        DBMS_OUTPUT.PUT_LINE('Lỗi: ' || SQLERRM);
END;
/

*/

---Stored Procedure
--Thêm khách hàng
CREATE OR REPLACE PROCEDURE them_khachhang (
    p_makh CHAR,
    p_hoten_kh VARCHAR2,
    p_sdt_kh VARCHAR2,
    p_diachi_kh VARCHAR2,
    p_ngsinh_kh DATE,
    p_tichluy NUMBER
) IS
BEGIN
    INSERT INTO KHACHHANG (MAKH, HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY)
    VALUES (p_makh, p_hoten_kh, p_sdt_kh, p_diachi_kh, p_ngsinh_kh, p_tichluy);
    
    COMMIT; -- Lýu thay ð?i vào cõ s? d? li?u
END;
/
--Thêm nhân viên
CREATE OR REPLACE PROCEDURE them_nhanvien (
    p_manv CHAR,
    p_hoten_nv VARCHAR2,
    p_ngsinh_nv DATE,
    p_sdt_nv VARCHAR2,
    p_email_nv VARCHAR2,
    p_vaitro VARCHAR2,
    p_ngvl DATE
) IS
BEGIN
    INSERT INTO NHANVIEN (MANV, HOTEN_NV, NGSINH_NV, SDT_NV, EMAIL_NV, VAITRO, NGVL)
    VALUES (p_manv, p_hoten_nv, p_ngsinh_nv, p_sdt_nv, p_email_nv, p_vaitro, p_ngvl);
    
    COMMIT; -- Lýu thay ð?i vào cõ s? d? li?u
END;

--Thêm tài kho?n:
CREATE OR REPLACE PROCEDURE them_taikhoan (
    p_id_tk NUMBER,
    p_manv CHAR,
    p_email VARCHAR2,
    p_matkhau VARCHAR2,
    p_ver_code VARCHAR2,
    p_trangthai VARCHAR2,
    p_vaitro_nv VARCHAR2
) IS
BEGIN
    INSERT INTO TAIKHOAN (ID_TK, MANV, EMAIL, MATKHAU, VER_CODE, TRANGTHAI, VAITRO_NV)
    VALUES (p_id_tk, p_manv, p_email, p_matkhau, p_ver_code, p_trangthai, p_vaitro_nv);
    
    COMMIT; -- Lýu thay ð?i vào cõ s? d? li?u
END;
/
--Thêm nh?c c?
CREATE OR REPLACE PROCEDURE them_nhaccu (
    p_manc CHAR,
    p_malnc CHAR,
    p_tennc VARCHAR2,
    p_hang VARCHAR2,
    p_gianhap NUMBER,
    p_giaban NUMBER,
    p_tongsl NUMBER
) IS
BEGIN
    INSERT INTO NHACCU (MANC, MALNC, TENNC, HANG, GIANHAP, GIABAN, TONGSL)
    VALUES (p_manc, p_malnc, p_tennc, p_hang, p_gianhap, p_giaban, p_tongsl);
    
    COMMIT; -- Lýu thay ð?i vào cõ s? d? li?u
END;

--Thêm phi?u xu?t kho
CREATE OR REPLACE PROCEDURE them_phieuxuatkho (
    p_mapxk CHAR,
    p_manc CHAR,
    p_sl_xuat NUMBER,
    p_ngxuat DATE,
    p_noidung_pxk VARCHAR2
) IS
BEGIN
    INSERT INTO PHIEUXUATKHO (MAPXK, MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK)
    VALUES (p_mapxk, p_manc, p_sl_xuat, p_ngxuat, p_noidung_pxk);
    
    COMMIT; -- Lýu thay ð?i vào cõ s? d? li?u
END;

--Thêm phi?u nh?p kho
CREATE OR REPLACE PROCEDURE them_phieunhapkho (
    p_mapnk CHAR,
    p_manc CHAR,
    p_mancc CHAR,
    p_sl_nhap NUMBER,
    p_ngnhap DATE,
    p_noidung_pnk VARCHAR2
) IS
BEGIN
    INSERT INTO PHIEUNHAPKHO (MAPNK, MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
    VALUES (p_mapnk, p_manc, p_mancc, p_sl_nhap, p_ngnhap, p_noidung_pnk);
    
    COMMIT; -- Lýu thay ð?i vào cõ s? d? li?u
END;
/
--Thêm nhà cung c?p
CREATE OR REPLACE PROCEDURE them_nhacungcap (
    p_mancc CHAR,
    p_tenncc VARCHAR2,
    p_sdt_ncc VARCHAR2,
    p_diachi_ncc VARCHAR2,
    p_email_ncc VARCHAR2
) IS
BEGIN
    INSERT INTO NHACUNGCAP (MANCC, TENNCC, SDT_NCC, DIACHI_NCC, EMAIL_NCC)
    VALUES (p_mancc, p_tenncc, p_sdt_ncc, p_diachi_ncc, p_email_ncc);
    
    COMMIT; -- Lýu thay ð?i vào cõ s? d? li?u
END;

--Thêm báo cáo
CREATE OR REPLACE PROCEDURE them_baocao (
    p_mabc CHAR,
    p_manv CHAR,
    p_ngaybc DATE,
    p_chitietbc VARCHAR2
) IS
BEGIN
    INSERT INTO BAOCAO (MABC, MANV, NGAYBC, CHITIETBC)
    VALUES (p_mabc, p_manv, p_ngaybc, p_chitietbc);
    
    COMMIT; -- Lýu thay ð?i vào cõ s? d? li?u
END;

--Tạo hóa đơn
CREATE OR REPLACE TYPE CTHD_REC_TYPE AS OBJECT (
    MAHD CHAR(10),
    MANC CHAR(10),
    SL NUMBER,
    THANHTIEN NUMBER
);

CREATE OR REPLACE TYPE CTHD_TABLE_TYPE AS TABLE OF CTHD_REC_TYPE;

---Stored update so luong ban
CREATE OR REPLACE PROCEDURE update_soluong_ban_stored(
    p_manc CHAR,
    p_sl_ban NUMBER
) IS
    v_soluong NUMBER;
BEGIN
    -- L?y s? lý?ng hi?n t?i t? b?ng NHACCU
    SELECT TONGSL INTO v_soluong
    FROM NHACCU
    WHERE MANC = p_manc;

    -- Ki?m tra n?u s? lý?ng bán l?n hõn s? lý?ng hi?n t?i
    IF p_sl_ban > v_soluong THEN
        RAISE_APPLICATION_ERROR(-20001, 'S? lý?ng bán l?n hõn s? lý?ng hi?n có.');
    END IF;

    -- C?p nh?t s? lý?ng m?i
    v_soluong := v_soluong - p_sl_ban;

    -- C?p nh?t s? lý?ng trong b?ng NHACCU
    UPDATE NHACCU
    SET TONGSL = v_soluong
    WHERE MANC = p_manc;
END;


CREATE OR REPLACE PROCEDURE tao_hoadon_va_them_chitiet (
    p_mahd CHAR,
    p_manv CHAR,
    p_makh CHAR,
    p_discount NUMBER,
    p_nglap DATE,
    p_tgbaohanh NUMBER,
    p_cthd_table CTHD_TABLE_TYPE
) IS
    v_trigia NUMBER := 0;
BEGIN
    -- T?o hóa ðõn m?i
    INSERT INTO HOADON (MAHD, MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA)
    VALUES (p_mahd, p_manv, p_makh, p_discount, p_nglap, p_tgbaohanh, 0);

    -- Thêm chi ti?t hóa ðõn t? b?ng CTHD
    FOR i IN 1..p_cthd_table.COUNT LOOP
        INSERT INTO CTHD (MAHD, MANC, SL, THANHTIEN)
        VALUES (p_mahd, p_cthd_table(i).MANC, p_cthd_table(i).SL, p_cthd_table(i).THANHTIEN);

        -- C?p nh?t s? lý?ng nh?c c?
        update_soluong_ban_stored(p_cthd_table(i).MANC, p_cthd_table(i).SL);

        -- Tính t?ng tr? giá hóa ðõn
        v_trigia := v_trigia + p_cthd_table(i).THANHTIEN;
    END LOOP;

    -- C?p nh?t tr? giá hóa ðõn
    UPDATE HOADON
    SET TRIGIA = v_trigia * (1 - p_discount / 100)
    WHERE MAHD = p_mahd;

    COMMIT; -- Lýu thay ð?i vào cõ s? d? li?u
END;


--Xóa nhân viên
CREATE OR REPLACE PROCEDURE xoa_nhanvien (
    p_manv CHAR
) IS
BEGIN
    DELETE FROM NHANVIEN
    WHERE MANV = p_manv;
    
    COMMIT; -- Lýu thay ð?i vào cõ s? d? li?u
END;

--Xóa khách hàng
CREATE OR REPLACE PROCEDURE xoa_khachhang (
    p_makh CHAR
) IS
BEGIN
    DELETE FROM KHACHHANG
    WHERE MAKH = p_makh;
    
    COMMIT; -- Lýu thay ð?i vào cõ s? d? li?u
END;

--Xóa nh?c c?
CREATE OR REPLACE PROCEDURE xoa_nhaccu (
    p_manc CHAR
) IS
BEGIN
    DELETE FROM NHACCU
    WHERE MANC = p_manc;
    
    COMMIT; -- Lýu thay ð?i vào cõ s? d? li?u
END;

--Xóa nhà cung c?p
CREATE OR REPLACE PROCEDURE xoa_nhacungcap (
    p_mancc CHAR
) IS
BEGIN
    DELETE FROM NHACUNGCAP
    WHERE MANCC = p_mancc;
    
    COMMIT; -- Lýu thay ð?i vào cõ s? d? li?u
END;

--Xem thông tin nhân viên
CREATE OR REPLACE PROCEDURE xem_thongtin_nhanvien (
    p_manv CHAR
) IS
    v_nhanvien NHANVIEN%ROWTYPE; -- Khai báo bi?n v?i cùng c?u trúc nhý b?ng NHANVIEN
BEGIN
    SELECT *
    INTO v_nhanvien -- Lýu k?t qu? c?a truy v?n vào bi?n v_nhanvien
    FROM NHANVIEN
    WHERE MANV = p_manv;
    
    -- Hi?n th? thông tin nhân viên
    DBMS_OUTPUT.PUT_LINE('MANV: ' || v_nhanvien.MANV || ', HOTEN_NV: ' || v_nhanvien.HOTEN_NV || ', NGSINH_NV: ' || v_nhanvien.NGSINH_NV || ', SDT_NV: ' || v_nhanvien.SDT_NV || ', EMAIL_NV: ' || v_nhanvien.EMAIL_NV || ', VAITRO: ' || v_nhanvien.VAITRO || ', NGVL: ' || v_nhanvien.NGVL);
END;
/

--Xem thông tin khách hàng
CREATE OR REPLACE PROCEDURE xem_thongtin_khachhang (
    p_makh CHAR
) IS
    v_khachhang KHACHHANG%ROWTYPE; -- Khai báo bi?n v?i cùng c?u trúc nhý b?ng KHACHHANG
BEGIN
    SELECT *
    INTO v_khachhang -- Lýu k?t qu? c?a truy v?n vào bi?n v_khachhang
    FROM KHACHHANG
    WHERE MAKH = p_makh;
    
    -- Hi?n th? thông tin khách hàng
    DBMS_OUTPUT.PUT_LINE('MAKH: ' || v_khachhang.MAKH || ', HOTEN_KH: ' || v_khachhang.HOTEN_KH || ', SDT_KH: ' || v_khachhang.SDT_KH || ', DIACHI_KH: ' || v_khachhang.DIACHI_KH || ', NGSINH_KH: ' || v_khachhang.NGSINH_KH || ', TICHLUY: ' || v_khachhang.TICHLUY);
END;
/

--Xem thông tin nh?c c?
CREATE OR REPLACE PROCEDURE xem_thongtin_nhaccu (
    p_manc CHAR
) IS
    v_nhaccu NHACCU%ROWTYPE; -- Khai báo bi?n v?i cùng c?u trúc nhý b?ng NHACCU
BEGIN
    SELECT *
    INTO v_nhaccu -- Lýu k?t qu? c?a truy v?n vào bi?n v_nhaccu
    FROM NHACCU
    WHERE MANC = p_manc;
    
    -- Hi?n th? thông tin nh?c c?
    DBMS_OUTPUT.PUT_LINE('MANC: ' || v_nhaccu.MANC || ', MALNC: ' || v_nhaccu.MALNC || ', TENNC: ' || v_nhaccu.TENNC || ', HANG: ' || v_nhaccu.HANG || ', GIANHAP: ' || v_nhaccu.GIANHAP || ', GIABAN: ' || v_nhaccu.GIABAN || ', TONGSL: ' || v_nhaccu.TONGSL);
END;
/

--Li?t kê hóa ðõn t? ngày A ð?n ngày B
CREATE OR REPLACE PROCEDURE lietke_hoadon (
    p_ngay_a DATE,
    p_ngay_b DATE
) IS
    CURSOR c_hoadon IS
        SELECT *
        FROM HOADON
        WHERE NGLAP BETWEEN p_ngay_a AND p_ngay_b;
BEGIN
    FOR r_hoadon IN c_hoadon LOOP
        DBMS_OUTPUT.PUT_LINE('MAHD: ' || r_hoadon.MAHD || ', MANV: ' || r_hoadon.MANV || ', MAKH: ' || r_hoadon.MAKH || ', DISCOUNT: ' || r_hoadon.DISCOUNT || ', NGLAP: ' || r_hoadon.NGLAP || ', TGBAOHANH: ' || r_hoadon.TGBAOHANH || ', TRIGIA: ' || r_hoadon.TRIGIA);
    END LOOP;
END;
/
/*
/*CHAY DEMO
SET SERVEROUTPUT ON;

BEGIN
    lietke_hoadon(
        TO_DATE('2024-01-01', 'YYYY-MM-DD'),  -- Ngày bắt đầu
        TO_DATE('2024-12-31', 'YYYY-MM-DD')   -- Ngày kết thúc
    );
 
END;

*/
-- Liet khe phieu nhap kho tý ngay A den ngay B
CREATE OR REPLACE PROCEDURE lietke_phieunhapkho (
    p_ngay_a DATE,
    p_ngay_b DATE
) IS
    CURSOR c_phieunhapkho IS
        SELECT *
        FROM PHIEUNHAPKHO
        WHERE NGNHAP BETWEEN p_ngay_a AND p_ngay_b;
BEGIN
    FOR r_phieunhapkho IN c_phieunhapkho LOOP
        DBMS_OUTPUT.PUT_LINE('MAPNK: ' || r_phieunhapkho.MAPNK || ', MANC: ' || r_phieunhapkho.MANC || ', MANCC: ' || r_phieunhapkho.MANCC || ', NGNHAP: ' || r_phieunhapkho.NGNHAP || ', NOIDUNG_PNK: ' || r_phieunhapkho.NOIDUNG_PNK);
    END LOOP;
END;
/
/*CHAY DEMO
SET SERVEROUTPUT ON;

BEGIN
    lietke_phieunhapkho(
        TO_DATE('2024-01-01', 'YYYY-MM-DD'),  -- Ngày bắt đầu
        TO_DATE('2024-12-31', 'YYYY-MM-DD')   -- Ngày kết thúc
    );
 
END;
*/

--Li?t kê phi?u xu?t kho t? ngày A ð?n ngày B
CREATE OR REPLACE PROCEDURE lietke_phieuxuatkho (
    p_ngay_a DATE,
    p_ngay_b DATE
) IS
    CURSOR c_phieuxuatkho IS
        SELECT *
        FROM PHIEUXUATKHO
        WHERE NGXUAT BETWEEN p_ngay_a AND p_ngay_b;
BEGIN
    FOR r_phieuxuatkho IN c_phieuxuatkho LOOP
        DBMS_OUTPUT.PUT_LINE('MAPXK: ' || r_phieuxuatkho.MAPXK || ', MANC: ' || r_phieuxuatkho.MANC || ', NGXUAT: ' || r_phieuxuatkho.NGXUAT || ', NOIDUNG_PXK: ' || r_phieuxuatkho.NOIDUNG_PXK);
    END LOOP;
END;
/

/*CHAY DEMO
SET SERVEROUTPUT ON;

BEGIN
    lietke_phieuxuatkho(
        TO_DATE('2024-01-01', 'YYYY-MM-DD'),  -- Ngày bắt đầu
        TO_DATE('2024-12-31', 'YYYY-MM-DD')   -- Ngày kết thúc
    );
   xem_chitiet_hoadon('HD001');
END;
*/


--Xem CTHD c?a 1 HOADON
CREATE OR REPLACE PROCEDURE xem_chitiet_hoadon (
    p_mahd CHAR
) IS
BEGIN
    -- S? d?ng câu l?nh SELECT ð? l?y các chi ti?t hóa ðõn t? b?ng CTHD d?a trên m? hóa ðõn (MAHD)
    FOR cthd_row IN (SELECT * FROM CTHD WHERE MAHD = p_mahd) LOOP
        -- Hi?n th? thông tin chi ti?t hóa ðõn
        DBMS_OUTPUT.PUT_LINE('MAHD: ' || cthd_row.MAHD || ', MANC: ' || cthd_row.MANC || ', SL: ' || cthd_row.SL || ', THANHTIEN: ' || cthd_row.THANHTIEN);
    END LOOP;
END;
/
--Truy xuat dong thoi



--Insert data
--KHACHHANG
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Nguyen Tuan Anh', '0123456789', 'Thu Duc, HCM', TO_DATE('1987-08-22', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Le Ngoc Minh', '0987654321', 'Quan 2 , HCM', TO_DATE('1990-02-20', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Tran Ngoc Bao Yen', '0946218463', 'Quan 7, HCM', TO_DATE('1999-03-10', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Nguyen Anh Thu', '0183716391', 'Phan Thiet, Binh Thuan', TO_DATE('2000-02-10', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Le Anh Khoi', '0962077650', 'Thu Duc, HCM', TO_DATE('1995-08-04', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Tran Minh An', '0326884478', 'Go Vap, HCM', TO_DATE('2000-03-04', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Tran Vu Bao Thang', '0947834157', 'Binh Thanh, HCM', TO_DATE('1998-09-21', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Nguyen Anh Thu', '0988433090', 'Thu Duc, HCM', TO_DATE('2000-07-31', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Le Anh Khoi', '0962433090', 'Quan 1, HCM', TO_DATE('2001-05-10', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Tran Minh An', '032589150', 'Go Vap, HCM', TO_DATE('2000-01-09', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Nguyen Hoang Long', '0900140236', 'Di An, Binh Duong', TO_DATE('1995-07-23', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Nguyen Hoang Duong', '0988722479', 'Binh Thanh, HCM', TO_DATE('1998-07-24', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Le Minh Bao Dang', '0977125347', 'Di An, Binh Duong', TO_DATE('2000-01-01', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Nguyen Hoang Quan', '0962433090', 'Quan 3, HCM', TO_DATE('2002-07-06', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Vu Minh Quan', '0322008765', 'Go Vap, HCM', TO_DATE('2000-04-21', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Huynh Minh An', '0988725631', 'Di An, Binh Duong', TO_DATE('1995-05-23', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Le Ly', '0965432123', 'Binh Thanh, HCM', TO_DATE('1998-10-24', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Le Phuong Vy', '0987911256', 'Di An, Binh Duong', TO_DATE('2000-05-01', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Pham Ha Anh Thu', '0832321478', 'Quan 3, HCM', TO_DATE('2002-08-06', 'YYYY-MM-DD'), 0);
INSERT INTO KHACHHANG (HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY) VALUES ('Phan Hoang Tu Uyen', '0865441213', 'Go Vap, HCM', TO_DATE('2000-11-21', 'YYYY-MM-DD'), 0);


--NHANVIEN
INSERT INTO NHANVIEN (HOTEN_NV, NGSINH_NV, SDT_NV, EMAIL_NV, VAITRO, NGVL) VALUES ('Le Yen Vi', TO_DATE('2000-08-21', 'YYYY-MM-DD'), '0955231989', 'thevilyy@gmail.com', 'Nhân viên quản lý', TO_DATE('2020-01-01', 'YYYY-MM-DD'));
INSERT INTO NHANVIEN (HOTEN_NV, NGSINH_NV, SDT_NV, EMAIL_NV, VAITRO, NGVL) VALUES ('Huynh Cong Thanh', TO_DATE('2001-11-07', 'YYYY-MM-DD'), '0928876518', 'thanhhc@gmail.com', 'Nhân viên quản lý', TO_DATE('2021-06-01', 'YYYY-MM-DD'));
INSERT INTO NHANVIEN (HOTEN_NV, NGSINH_NV, SDT_NV, EMAIL_NV, VAITRO, NGVL) VALUES ('Pham Thanh Thuy Vi', TO_DATE('2001-06-15', 'YYYY-MM-DD'), '0925765489', 'vipt@gmail.com', 'Nhân viên bán hàng', TO_DATE('2021-06-15', 'YYYY-MM-DD'));
INSERT INTO NHANVIEN (HOTEN_NV, NGSINH_NV, SDT_NV, EMAIL_NV, VAITRO, NGVL) VALUES ('Nguyen Duy Tan', TO_DATE('2001-01-06', 'YYYY-MM-DD'), '0947326754', 'tannd@gmail.com', 'Nhân viên bán hàng', TO_DATE('2021-06-04', 'YYYY-MM-DD'));
INSERT INTO NHANVIEN (HOTEN_NV, NGSINH_NV, SDT_NV, EMAIL_NV, VAITRO, NGVL) VALUES ('Le Thi Kim Oanh', TO_DATE('2001-12-09', 'YYYY-MM-DD'), '0919233456', 'oanhltk@gmail.com', 'Nhân viên bán hàng', TO_DATE('2021-06-04', 'YYYY-MM-DD'));
INSERT INTO NHANVIEN (HOTEN_NV, NGSINH_NV, SDT_NV, EMAIL_NV, VAITRO, NGVL) VALUES ('Nguyen Thi Thuy Linh', TO_DATE('2000-02-02', 'YYYY-MM-DD'), '0123478911', 'linhntt@gmail.com', 'Nhân viên bán hàng', TO_DATE('2021-11-20', 'YYYY-MM-DD'));
INSERT INTO NHANVIEN (HOTEN_NV, NGSINH_NV, SDT_NV, EMAIL_NV, VAITRO, NGVL) VALUES ('Nguyen Anh Thu', TO_DATE('2000-02-10', 'YYYY-MM-DD'), '0911245678', 'thuna@gmail.com', 'Nhân viên bán hàng', TO_DATE('2021-11-20', 'YYYY-MM-DD'));
INSERT INTO NHANVIEN (HOTEN_NV, NGSINH_NV, SDT_NV, EMAIL_NV, VAITRO, NGVL) VALUES ('Nguyen Hong Nhat Long', TO_DATE('2000-08-22', 'YYYY-MM-DD'), '0123456789', 'longnhn@gmail.com', 'Nhân viên bảo trì', TO_DATE('2021-11-20', 'YYYY-MM-DD'));
INSERT INTO NHANVIEN (HOTEN_NV, NGSINH_NV, SDT_NV, EMAIL_NV, VAITRO, NGVL) VALUES ('Huynh Van Nhat', TO_DATE('2000-08-25', 'YYYY-MM-DD'), '09478142699', 'nhathv@gmail.com', 'Nhân viên bảo trì', TO_DATE('2020-12-01', 'YYYY-MM-DD'));
INSERT INTO NHANVIEN (HOTEN_NV, NGSINH_NV, SDT_NV, EMAIL_NV, VAITRO, NGVL) VALUES ('Nguyen Cao Nguyen', TO_DATE('2000-08-18', 'YYYY-MM-DD'), '0876524361', 'nguyencn@gmail.com', 'Nhân viên bảo trì', TO_DATE('2021-11-20', 'YYYY-MM-DD'));


--TAIKHOAN
--nv quan ly: 100 101
--nv ban hang: 102 103 104 105 106
--nv bao tri: 107 108 109
INSERT INTO TAIKHOAN (MANV, EMAIL, MATKHAU, VER_CODE, TRANGTHAI, VAITRO_NV) VALUES ('NV100', 'tk1@gmail.com', 'matkhau1', 'code1', 'Đã xác minh', 'Nhân viên quản lý');
INSERT INTO TAIKHOAN (MANV, EMAIL, MATKHAU, VER_CODE, TRANGTHAI, VAITRO_NV) VALUES ('NV101', 'tk2@gmail.com', 'matkhau2', 'code2', 'Đã xác minh', 'Nhân viên quản lý');
INSERT INTO TAIKHOAN (MANV, EMAIL, MATKHAU, VER_CODE, TRANGTHAI, VAITRO_NV) VALUES ('NV102', 'tk3@gmail.com', 'matkhau3', 'code3', 'Đã xác minh', 'Nhân viên bán hàng');
INSERT INTO TAIKHOAN (MANV, EMAIL, MATKHAU, VER_CODE, TRANGTHAI, VAITRO_NV) VALUES ('NV103', 'tk4@gmail.com', 'matkhau4', 'code4', 'Đã xác minh', 'Nhân viên bán hàng');
INSERT INTO TAIKHOAN (MANV, EMAIL, MATKHAU, VER_CODE, TRANGTHAI, VAITRO_NV) VALUES ('NV104', 'tk5@gmail.com', 'matkhau5', 'code5', 'Đã xác minh', 'Nhân viên bán hàng');
INSERT INTO TAIKHOAN (MANV, EMAIL, MATKHAU, VER_CODE, TRANGTHAI, VAITRO_NV) VALUES ('NV105', 'tk6@gmail.com', 'matkhau6', 'code6', 'Đã xác minh', 'Nhân viên bán hàng');
INSERT INTO TAIKHOAN (MANV, EMAIL, MATKHAU, VER_CODE, TRANGTHAI, VAITRO_NV) VALUES ('NV106', 'tk7@gmail.com', 'matkhau7', 'code7', 'Đã xác minh', 'Nhân viên bán hàng');
INSERT INTO TAIKHOAN (MANV, EMAIL, MATKHAU, VER_CODE, TRANGTHAI, VAITRO_NV) VALUES ('NV107', 'tk8@gmail.com', 'matkhau8', 'code8', 'Đã xác minh', 'Nhân viên bảo trì');
INSERT INTO TAIKHOAN (MANV, EMAIL, MATKHAU, VER_CODE, TRANGTHAI, VAITRO_NV) VALUES ('NV108', 'tk9@gmail.com', 'matkhau9', 'code9', 'Đã xác minh', 'Nhân viên bảo trì');
INSERT INTO TAIKHOAN (MANV, EMAIL, MATKHAU, VER_CODE, TRANGTHAI, VAITRO_NV) VALUES ('NV109', 'tk10@gmail.com', 'matkhau10', 'code10', 'Đã xác minh', 'Nhân viên bảo trì');


--LOAINHACCU
INSERT INTO LOAINHACCU (TEN_LNC) VALUES ('Organ');
INSERT INTO LOAINHACCU (TEN_LNC) VALUES ('Piano');
INSERT INTO LOAINHACCU (TEN_LNC) VALUES ('Guitar');
INSERT INTO LOAINHACCU (TEN_LNC) VALUES ('Nhạc cụ dây');
INSERT INTO LOAINHACCU (TEN_LNC) VALUES ('Bộ gõ');
INSERT INTO LOAINHACCU (TEN_LNC) VALUES ('Bộ thổi');
INSERT INTO LOAINHACCU (TEN_LNC) VALUES ('Âm thanh');
INSERT INTO LOAINHACCU (TEN_LNC) VALUES ('Phòng thu');

--Yamaha, KORG, Kawai, Young Chang, Roland, Enya Group Music, Cort, Sqoe, Joyo, KHALY, FULLY, NISSI, Gecko, Alto, Takstar, Mackie, Samson, PreSonus
select * from loainhaccu;
select * from nhaccu;


--NHACCU 
--Organ 
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC100', 'Đàn Organ Yamaha PSR-F52', 'Yamaha', 2500000, 2790000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC100', 'Đàn Organ Yamaha PSR E273', 'Yamaha', 3500000, 3750000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC100', 'Đàn Organ KORG Pa300', 'KORG', 15000000, 16000000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC100', 'Synthesizer Yamaha REFACE CP', 'Yamaha', 9500000, 10400000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC100', 'Synthesizer Vocoder Korg microKORG', 'KORG', 8000000, 9000000);
--Piano 
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC101', 'Stage Piano KORG D1 WH', 'KORG', 13900000, 15000000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC101', 'Piano Điện Kawai CN29', 'Kawai', 21000000, 22500000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC101', 'Piano Điện Korg Liano L1 Metallic Red', 'KORG', 7000000, 8100000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC101', 'Piano Upright Young Chang Y131', 'Young Chang', 61000000, 65000000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC101', 'Piano Điện Roland GO 88P', 'Roland', 11500000, 13000000);
--Guitar 
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC102', 'Ukulele 23 Enya EUS X1 HPL Soprano', 'Enya Group Music', 1100000, 1550000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC102', 'Guitar Acoustic Cort AF510', 'Cort', 2700000, 3300000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC102', 'Guitar Điện Sqoe SEST200 Sunburst', 'Sqoe', 1900000, 2500000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC102', 'Guitar Bass Cort Action PJ OPB', 'Cort', 3900000, 4200000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC102', 'Ampli Guitar Điện Joyo MA-10E', 'Joyo', 850000, 1000000);
--Nhạc cụ dây  
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC103', 'Violin Yamaha V3SKA 1/2 3/4 4/4', 'Yamaha', 6000000, 6700000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC103', 'Violin 44 N. KHALYH', 'KHALY', 6000000, 6500000);
--Bộ gõ 
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC104', 'Cymbal Nissi FULLY 10”', 'FULLY', 500000, 600000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC104', 'Cajon NISSI Travel Box CJTRV-965', 'NISSI', 680000, 750000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC104', 'Đàn Kalimba Gecko K17BA 17 Keys', 'Gecko', 390000, 450000);
--Bộ thổi
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC105', 'Sáo Recorder Yamaha YRS-24B', 'Yamaha', 100000, 150000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC105', 'Kèn Trumpet Yamaha TR3500', 'Yamaha', 3000000, 3500000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC105', 'Kèn Saxophone Alto MK007', 'Alto', 6000000, 6500000);
--Âm thanh 
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC106', 'Micro Dynamic Takstar E-340', 'Takstar', 250000, 300000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC106', 'Mixer Mackie 402VLZ4o', 'Mackie', 2950000, 3200000);
--Phòng thu 
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC107', 'Màng Chắn Micro Samson (USA) PS04', 'Samson', 420000, 500000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC107', 'Bộ Giữ Micro Phòng Thu PreSonus SHK-1', 'PreSonus', 920000, 1000000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC107', 'Thiết Bị Chia Headphone Mackie HM 4', 'Mackie', 1200000, 1300000);
INSERT INTO NHACCU (MALNC, TENNC, HANG, GIANHAP, GIABAN) VALUES ('LNC107', 'Tai Nghe Kiểm Âm PreSonus HD9', 'PreSonus', 2150000, 2300000);
--29 NHAC CU


SELECT * FROM HOADON;
DELETE FROM HOADON WHERE TRIGIA=0;
--HOADON
--nv ban hang: 102 103 104 105 106 
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV102', 'KH100', 0, TO_DATE('2023-12-01', 'YYYY-MM-DD'), 12,0); --0
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV103', 'KH101', 0, TO_DATE('2023-12-01', 'YYYY-MM-DD'), 24,0); --1
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV102', 'KH102',0, TO_DATE('2023-12-01', 'YYYY-MM-DD'), 6,0); --2
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV102', 'KH103',0, TO_DATE('2023-12-02', 'YYYY-MM-DD'), 12,0); --3
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV103', 'KH104', 0, TO_DATE('2023-12-02', 'YYYY-MM-DD'), 24,0); --4
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV104', 'KH105', 0, TO_DATE('2023-12-05', 'YYYY-MM-DD'), 6,0); --5
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV105', 'KH106', 0, TO_DATE('2023-12-06', 'YYYY-MM-DD'), 12,0); --6
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV106', 'KH107', 0, TO_DATE('2023-12-08', 'YYYY-MM-DD'), 24,0); --7
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV104', 'KH108', 0, TO_DATE('2023-12-09', 'YYYY-MM-DD'), 6,0); --8
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV102', 'KH109', 0, TO_DATE('2023-12-12', 'YYYY-MM-DD'), 12,0); --9
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV104', 'KH110', 0, TO_DATE('2023-12-15', 'YYYY-MM-DD'), 24,0); --10
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV105', 'KH111', 0, TO_DATE('2023-12-17', 'YYYY-MM-DD'), 6,0); --11
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV106', 'KH112', 0, TO_DATE('2023-12-20', 'YYYY-MM-DD'), 12,0); --12
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV103', 'KH113', 0, TO_DATE('2023-12-25', 'YYYY-MM-DD'), 24,0); --13
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV104', 'KH114', 0, TO_DATE('2023-12-28', 'YYYY-MM-DD'), 6,0); --14
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV105', 'KH110', 0, TO_DATE('2024-01-01', 'YYYY-MM-DD'), 12,0); --15
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV102', 'KH111', 0, TO_DATE('2024-01-03', 'YYYY-MM-DD'), 12,0); --16
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV106', 'KH112', 0, TO_DATE('2024-01-03', 'YYYY-MM-DD'), 24,0); --17
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV104', 'KH113', 0, TO_DATE('2024-01-03', 'YYYY-MM-DD'), 6,0); --18
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV105', 'KH114', 0, TO_DATE('2024-01-05', 'YYYY-MM-DD'), 12,0); --19
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV103', 'KH115', 0, TO_DATE('2024-01-05', 'YYYY-MM-DD'), 24,0); --20
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV104', 'KH116', 0, TO_DATE('2024-01-06', 'YYYY-MM-DD'), 6,0); --21
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV102', 'KH117', 0, TO_DATE('2024-01-07', 'YYYY-MM-DD'), 12,0); --22
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV104', 'KH118', 0, TO_DATE('2024-01-08', 'YYYY-MM-DD'), 24,0); --23
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV105', 'KH119', 0, TO_DATE('2024-01-08', 'YYYY-MM-DD'), 6,0); --24
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV102', 'KH114', 0, TO_DATE('2024-01-09', 'YYYY-MM-DD'), 12,0); --26
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV103', 'KH113', 0, TO_DATE('2024-01-10', 'YYYY-MM-DD'), 24,0); --27
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV106', 'KH111', 0, TO_DATE('2024-01-11', 'YYYY-MM-DD'), 6,0); --28
INSERT INTO HOADON (MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA) VALUES ('NV106', 'KH110', 0, TO_DATE('2024-01-12', 'YYYY-MM-DD'), 12,0); --29



--CTHD
--HD100
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD100', 'NC100', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD100', 'NC107', 1);
--HD101
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD101', 'NC114', 1);
--HD102
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD102', 'NC115', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD103', 'NC106', 1);
--HD103
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD104', 'NC120', 1);
--HD104
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD105', 'NC128', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD105', 'NC126', 1);
--HD105
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD105', 'NC104', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD105', 'NC124', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD105', 'NC108', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD105', 'NC125', 1);
--HD106
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD106', 'NC111', 2);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD106', 'NC114', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD106', 'NC128', 1);
--HD107
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD107', 'NC103', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD107', 'NC119', 1);
--HD108
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD108', 'NC109', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD108', 'NC114', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD108', 'NC121', 1);
--HD109
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD109', 'NC102', 1);
--HD110
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD110', 'NC123', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD110', 'NC116', 1);
--HD111
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD111', 'NC125', 1);
--HD112
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD112', 'NC121', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD112', 'NC127', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD112', 'NC126', 1);
--HD113
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD113', 'NC120', 2);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD113', 'NC105', 1);
--HD114
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD114', 'NC122', 1);
--HD115
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD115', 'NC101', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD115', 'NC120', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD115', 'NC125', 1);
--HD116
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD116', 'NC128', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD116', 'NC125', 1);
--HD117
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD117', 'NC102', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD117', 'NC105', 1);
--HD118
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD118', 'NC117', 1);
--HD119
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD119', 'NC102', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD119', 'NC109', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD119', 'NC125', 1);
--HD120
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD120', 'NC104', 1);
--HD121
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD121', 'NC111', 2);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD121', 'NC104', 1);
--HD122
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD122', 'NC101', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD122', 'NC109', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD122', 'NC118', 1);
--HD123
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD123', 'NC112', 1);
--HD124
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD124', 'NC118', 2);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD124', 'NC113', 1);
--HD125
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD125', 'NC109', 2);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD125', 'NC110', 1);
--HD126
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD126', 'NC118', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD126', 'NC123', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD126', 'NC106', 1);
--HD127
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD127', 'NC105', 1);
--HD128
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD128', 'NC105', 1);
--HD129
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD129', 'NC117', 1);
INSERT INTO CTHD (MAHD, MANC, SL) VALUES ('HD129', 'NC105', 1);


--NHACUNGCAP
INSERT INTO NHACUNGCAP (TENNCC, SDT_NCC, DIACHI_NCC, EMAIL_NCC) VALUES ('Công ty 1', '0323245678', '775 Duong ABC, Hanoi', 'congty1@gmail.com');
INSERT INTO NHACUNGCAP (TENNCC, SDT_NCC, DIACHI_NCC, EMAIL_NCC) VALUES ('Công ty 2', '0987612345', '456 Duong XYZ, HCM', 'congty2@gmail.com');
INSERT INTO NHACUNGCAP (TENNCC, SDT_NCC, DIACHI_NCC, EMAIL_NCC) VALUES ('Công ty 3', '0778864321', '789 Duong DEF, Da Nang', 'congty3@gmail.com');
INSERT INTO NHACUNGCAP (TENNCC, SDT_NCC, DIACHI_NCC, EMAIL_NCC) VALUES ('Công ty 4', '0765098123', '123 Duong ABC, Da Lat', 'congty4@gmail.com');
INSERT INTO NHACUNGCAP (TENNCC, SDT_NCC, DIACHI_NCC, EMAIL_NCC) VALUES ('Công ty 5', '0145609234', '218 Duong XYZ, HCM', 'congty5@gmail.com');
INSERT INTO NHACUNGCAP (TENNCC, SDT_NCC, DIACHI_NCC, EMAIL_NCC) VALUES ('Công ty 6', '0997156743', '228 Duong DEF, Hai Phong', 'congty6@gmail.com');
INSERT INTO NHACUNGCAP (TENNCC, SDT_NCC, DIACHI_NCC, EMAIL_NCC) VALUES ('Công ty 7', '0197423124', '123 Duong ABC, Hanoi', 'congty7@gmail.com');
INSERT INTO NHACUNGCAP (TENNCC, SDT_NCC, DIACHI_NCC, EMAIL_NCC) VALUES ('Công ty 8', '0987124254', '456 Duong XYZ, HCM', 'congty8@gmail.com');
INSERT INTO NHACUNGCAP (TENNCC, SDT_NCC, DIACHI_NCC, EMAIL_NCC) VALUES ('Công ty 9', '0111789531', '789 Duong DEF, Binh Thuan', 'congty9@gmail.com');
INSERT INTO NHACUNGCAP (TENNCC, SDT_NCC, DIACHI_NCC, EMAIL_NCC) VALUES ('Công ty 10', '0857432412', '123 Duong ABC, Hai Phong', 'congty10@gmail.com');
INSERT INTO NHACUNGCAP (TENNCC, SDT_NCC, DIACHI_NCC, EMAIL_NCC) VALUES ('Công ty 11', '0892123456', '888 Duong ABC, Hanoi', 'congty11@gmail.com');
INSERT INTO NHACUNGCAP (TENNCC, SDT_NCC, DIACHI_NCC, EMAIL_NCC) VALUES ('Công ty 12', '0977654321', '034 Duong XYZ, HCM', 'congty12@gmail.com');
INSERT INTO NHACUNGCAP (TENNCC, SDT_NCC, DIACHI_NCC, EMAIL_NCC) VALUES ('Công ty 13', '0773876123', '218 Duong DEF, Da Nang', 'congty13@gmail.com');
INSERT INTO NHACUNGCAP (TENNCC, SDT_NCC, DIACHI_NCC, EMAIL_NCC) VALUES ('Công ty 14', '0965145812', '228 Duong ABC, Da Lat', 'congty14@gmail.com');
INSERT INTO NHACUNGCAP (TENNCC, SDT_NCC, DIACHI_NCC, EMAIL_NCC) VALUES ('Công ty 15', '0123914578', '511 Duong XYZ, HCM', 'congty15@gmail.com');

select * from phieunhapkho;
--PHIEUNHAPKHO
INSERT INTO PHIEUNHAPKHO (MANC, MANCC,SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC101', 'NCC100', 6, TO_DATE('2022-12-15', 'YYYY-MM-DD'), 'Nhập lô hàng đàn piano Yamaha');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC105', 'NCC101', 5, TO_DATE('2023-01-10', 'YYYY-MM-DD'), 'Nhập lô hàng đàn guitar Cort');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC115', 'NCC102', 4, TO_DATE('2023-02-05', 'YYYY-MM-DD'), 'Nhập lô hàng đàn violin');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC110', 'NCC103', 7, TO_DATE('2023-03-20', 'YYYY-MM-DD'), 'Nhập lô hàng đàn Ukulele');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC122', 'NCC104', 4,  TO_DATE('2023-04-16', 'YYYY-MM-DD'), 'Nhập lô hàng Kèn Saxophone');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC103', 'NCC105', 3, TO_DATE('2023-05-20', 'YYYY-MM-DD'), 'Nhập lô hàng Synthesizer');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC118', 'NCC106', 5, TO_DATE('2023-06-30', 'YYYY-MM-DD'), 'Nhập lô hàng Cajon NISSI');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC113', 'NCC107', 5, TO_DATE('2023-07-25', 'YYYY-MM-DD'), 'Nhập lô hàng Guitar Bass');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC121', 'NCC108', 4, TO_DATE('2023-08-21', 'YYYY-MM-DD'), 'Nhập lô hàng Kèn Trumpet Yamaha');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC100', 'NCC109', 7, TO_DATE('2023-09-29', 'YYYY-MM-DD'), 'Nhập lô hàng Đàn Organ Yamaha');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC,SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC104', 'NCC100', 6, TO_DATE('2023-10-15', 'YYYY-MM-DD'), 'Nhập lô hàng Synthesizer Korg');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC109', 'NCC111', 5, TO_DATE('2023-11-10', 'YYYY-MM-DD'), 'Nhập lô hàng Piano Điện Roland');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC116', 'NCC112', 4, TO_DATE('2023-12-05', 'YYYY-MM-DD'), 'Nhập lô hàng Violin KHALYH');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC110', 'NCC113', 7, TO_DATE('2024-01-20', 'YYYY-MM-DD'), 'Nhập lô hàng đàn Ukulele Enya');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC121', 'NCC114', 4,  TO_DATE('2024-02-16', 'YYYY-MM-DD'), 'Nhập lô hàng Kèn Trumpet Yamaha');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC108', 'NCC105', 3, TO_DATE('2024-03-20', 'YYYY-MM-DD'), 'Nhập lô hàng Piano Young Chang');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC117', 'NCC106', 5, TO_DATE('2024-04-30', 'YYYY-MM-DD'), 'Nhập lô hàng Cymbal Nissi FULLY');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC112', 'NCC107', 5, TO_DATE('2024-05-15', 'YYYY-MM-DD'), 'Nhập lô hàng Guitar Điện Sqoe');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC122', 'NCC108', 4, TO_DATE('2024-05-28', 'YYYY-MM-DD'), 'Nhập lô hàng Kèn Saxophone Alto');

INSERT INTO PHIEUNHAPKHO (MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
VALUES ('NC100', 'NCC109', 7, TO_DATE('2024-06-29', 'YYYY-MM-DD'), 'Nhập lô hàng Đàn Organ Yamaha');


--PHIEUXUATKHO 
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC101', 7, TO_DATE('2023-01-20','YYYY-MM-DD'), 'Xuất hàng bán lẻ cho khách hàng');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC102', 5, TO_DATE('2023-02-25','YYYY-MM-DD'), 'Xuất hàng cho đại lý');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC105', 3, TO_DATE('2023-04-01','YYYY-MM-DD'), 'Xuất hàng bán cho nhà hàng');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC115', 7, TO_DATE('2023-04-25','YYYY-MM-DD'), 'Xuất hàng bán lẻ cho khách hàng');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC103', 4, TO_DATE('2023-05-22','YYYY-MM-DD'), 'Xuất hàng bán lẻ cho khách hàng');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC115', 4, TO_DATE('2023-06-19','YYYY-MM-DD'), 'Xuất hàng cho chi nhánh Hà Nội');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC105', 7, TO_DATE('2023-07-25','YYYY-MM-DD'), 'Xuất hàng cho chi nhánh TP.HCM');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC115', 2, TO_DATE('2023-08-28','YYYY-MM-DD'), 'Xuất hàng cho nhà hàng');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC101', 3, TO_DATE('2023-09-15','YYYY-MM-DD'), 'Xuất hàng cho chi nhánh Hải Phòng');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC105', 5, TO_DATE('2023-10-20','YYYY-MM-DD'), 'Xuất hàng bán lẻ cho khách hàng');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC103', 3, TO_DATE('2023-11-20','YYYY-MM-DD'), 'Xuất hàng bán lẻ cho khách hàng');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC115', 8, TO_DATE('2023-12-25','YYYY-MM-DD'), 'Xuất hàng cho đại lý');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC103', 4, TO_DATE('2024-01-22','YYYY-MM-DD'), 'Xuất hàng bán cho nhà hàng');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC113', 9, TO_DATE('2024-02-25','YYYY-MM-DD'), 'Xuất hàng bán lẻ cho khách hàng');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC105', 3, TO_DATE('2024-03-22','YYYY-MM-DD'), 'Xuất hàng bán lẻ cho khách hàng');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC118', 4, TO_DATE('2024-04-19','YYYY-MM-DD'), 'Xuất hàng cho chi nhánh Hà Nội');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC113', 7, TO_DATE('2024-05-25','YYYY-MM-DD'), 'Xuất hàng cho chi nhánh TP.HCM');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC108', 6, TO_DATE('2024-06-28','YYYY-MM-DD'), 'Xuất hàng cho đại lý');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC116', 3, TO_DATE('2024-07-15','YYYY-MM-DD'), 'Xuất hàng cho chi nhánh Hải Phòng');
INSERT INTO PHIEUXUATKHO (MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK) VALUES ('NC101', 5, TO_DATE('2024-08-20','YYYY-MM-DD'), 'Xuất hàng bán lẻ cho khách hàng');


--PHIEUBAOTRI 
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC100', 'HD100', TO_DATE('2024-02-18','YYYY-MM-DD'), 'Bảo trì đàn organ Yamaha');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC101', 'HD115', TO_DATE('2024-02-19','YYYY-MM-DD'), 'Kiểm tra đàn organ Yamaha');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC102', 'HD109', TO_DATE('2024-03-11','YYYY-MM-DD'), 'Vệ sinh đàn piano KORG');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC103', 'HD107', TO_DATE('2024-03-15','YYYY-MM-DD'), 'Sửa chữa synthesizer Yamaha');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC104', 'HD105', TO_DATE('2024-03-19','YYYY-MM-DD'), 'Thay thế linh kiện cho synthesizer');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC105', 'HD113', TO_DATE('2024-03-26','YYYY-MM-DD'), 'Kiểm tra guitar ukulele Enya');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC106', 'HD102', TO_DATE('2024-04-15','YYYY-MM-DD'), 'Sửa chữa guitar acoustic Cort');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC107', 'HD100', TO_DATE('2024-04-18','YYYY-MM-DD'), 'Vệ sinh guitar điện Sqoe');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC108', 'HD105', TO_DATE('2024-04-20','YYYY-MM-DD'), 'Thay dây cho guitar bass Cort');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC109', 'HD108', TO_DATE('2024-04-25','YYYY-MM-DD'), 'Kiểm tra và sửa chữa ampli guitar');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC110', 'HD100', TO_DATE('2024-05-07','YYYY-MM-DD'), 'Bảo trì hàng tháng');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC111', 'HD115', TO_DATE('2024-05-11','YYYY-MM-DD'), 'Kiểm tra định kì');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC112', 'HD109', TO_DATE('2024-05-12','YYYY-MM-DD'), 'Vệ sinh đàn');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC113', 'HD107', TO_DATE('2024-05-14','YYYY-MM-DD'), 'Sửa chữa dây');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC114', 'HD105', TO_DATE('2024-05-16','YYYY-MM-DD'), 'Thay thế linh kiện');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC115', 'HD113', TO_DATE('2024-06-02','YYYY-MM-DD'), 'Kiểm tra định kì');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC116', 'HD102', TO_DATE('2024-06-19','YYYY-MM-DD'), 'Sửa chữa dây');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC117', 'HD100', TO_DATE('2024-06-20','YYYY-MM-DD'), 'Vệ sinh đànt');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC118', 'HD105', TO_DATE('2024-06-25','YYYY-MM-DD'), 'Thay dây');
INSERT INTO PHIEUBAOTRI (MANC, MAHD, NGBT, CHITIET_BT) VALUES ('NC119', 'HD108', TO_DATE('2024-06-28','YYYY-MM-DD'), 'Kiểm tra và sửa chữa');

select * from PHIEUBAOTRI;

--BAOCAO 
--nv quan ly: 100 101
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV101', TO_DATE('2022-11-20','YYYY-MM-DD'), 'Báo cáo doanh thu tháng 11/2022');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV100', TO_DATE('2022-12-20','YYYY-MM-DD') ,'Báo cáo doanh thu tháng tháng 12/2022');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV101', TO_DATE('2023-01-20','YYYY-MM-DD'),'Báo cáo chi tiết hóa đơn tháng 1/2023');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV100', TO_DATE('2023-02-20','YYYY-MM-DD'), 'Báo cáo doanh thu tháng tháng 2/2023');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV101', TO_DATE('2024-03-20','YYYY-MM-DD'), 'Báo cáo doanh thu tháng tháng 3/2023');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV101', TO_DATE('2024-04-20','YYYY-MM-DD'),  'Báo cáo doanh thu tháng 4/2023');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV100', TO_DATE('2024-05-20','YYYY-MM-DD'), 'Báo cáo doanh thu tháng tháng 5/2023');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV100', TO_DATE('2024-06-20','YYYY-MM-DD'), 'Báo cáo doanh thu tháng tháng 5/2023');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV101', TO_DATE('2024-07-15','YYYY-MM-DD'), 'Báo cáo doanh thu tháng tháng 7/2023');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV101', TO_DATE('2024-08-10','YYYY-MM-DD'), 'Báo cáo doanh thu tháng tháng 8/2023');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV100', TO_DATE('2023-09-20','YYYY-MM-DD'), 'Báo cáo doanh thu tháng 9/2023');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV101', TO_DATE('2023-10-20','YYYY-MM-DD') ,'Báo cáo doanh thu tháng tháng 10/2023');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV100', TO_DATE('2023-11-20','YYYY-MM-DD'),'Báo cáo doanh thu tháng tháng 11/2023');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV100', TO_DATE('2023-12-20','YYYY-MM-DD'), 'Báo cáo doanh thu tháng tháng 12/2023');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV101', TO_DATE('2024-01-20','YYYY-MM-DD'), 'Báo cáo doanh thu tháng tháng 1/2024');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV100', TO_DATE('2024-02-20','YYYY-MM-DD'),  'Báo cáo doanh thu tháng 2/2024');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV100', TO_DATE('2024-03-20','YYYY-MM-DD'), 'Báo cáo doanh thu tháng tháng 3/2024');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV101', TO_DATE('2024-04-20','YYYY-MM-DD'), 'Báo cáo doanh thu tháng tháng 4/2024');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV101', TO_DATE('2024-05-15','YYYY-MM-DD'), 'Báo cáo doanh thu tháng tháng 5/2024');
INSERT INTO BAOCAO (MANV, NGAYBC, CHITIETBC) VALUES ('NV100', TO_DATE('2024-06-10','YYYY-MM-DD'), 'Báo cáo doanh thu tháng tháng 6/2024');




-- Dat muc co lap
ALTER SESSION SET ISOLATION_LEVEL = READ COMMITTED;

-- Thu tuc cap nhat  tránh dirty read
CREATE OR REPLACE PROCEDURE update_kho_dirty_read(
    p_MANC IN NUMBER, 
    p_TONGSL IN NUMBER    
) AS
BEGIN
    
    UPDATE NHACCU
    SET TONGSL = TONGSL - p_TONGSL
    WHERE TONGSL = p_TONGSL;

    -- Commit transaction luu thay doi
    COMMIT;
END;
/



-- Ð?t m?c cô l?p cho session
ALTER SESSION SET ISOLATION_LEVEL = SERIALIZABLE;

-- Th? t?c thêm nh?c c? m?i tránh phantom read
CREATE OR REPLACE PROCEDURE add_kho_phantom_read(
    p_TENNC IN VARCHAR2, 
    p_TONGSL IN NUMBER        
) AS
BEGIN
    -- Thêm nh?c c? m?i vào csdl
    INSERT INTO NHACCU (TENNC, TONGSL)
    VALUES (p_TENNC, p_TONGSL);

    
    COMMIT;
END;
/

-- Ð?t m?c cô l?p cho session hi?n t?i
ALTER SESSION SET ISOLATION_LEVEL = SERIALIZABLE;

-- Th? t?c c?p nh?t nh?c c? d? tránh non-repeatable read
CREATE OR REPLACE PROCEDURE update_kho_non_repeatable_read(
    p_MANC IN NUMBER,  
    p_TONGSL IN NUMBER     
) AS
     v_TONGSL NUMBER;
BEGIN
    -- Khóa dòng d? li?u d? c?p nh?t
    SELECT TONGSL
    INTO v_TONGSL
    FROM NHACCU
    WHERE MANC = p_MANC
    FOR UPDATE;

    -- C?p nh?t nh?c c?
    UPDATE NHACCU
    SET TONGSL = TONGSL - p_TONGSL
    WHERE MANC = p_MANC;

    
    COMMIT;
END;
/


-- Ð?t m?c cô l?p
ALTER SESSION SET ISOLATION_LEVEL = SERIALIZABLE;

-- Th? t?c c?p nh?t SL nh?c c? d? tránh lost update
CREATE OR REPLACE PROCEDURE update_kho_lost_update(
    p_MANC IN CHAR, -- ID nh?c c?
    p_TONGSL IN NUMBER    -- S? lu?ng nh?c c? c?n gi?m
) AS
 v_TONGSL NUMBER;
BEGIN
    -- Khóa dòng d? li?u c?p nh?t
    SELECT TONGSL
    INTO v_TONGSL
    FROM NHACCU
    WHERE MANC = p_MANC
    FOR UPDATE;

    -- C?p nh?t s? lu?ng nh?c c?
    UPDATE NHACCU
    SET TONGSL = TONGSL + p_TONGSL
    WHERE MANC = p_MANC;

    -- Commit transaction d? luu thay d?i
    COMMIT;
END;
/

BEGIN
 update_kho_lost_update('NC100',100);

 END;
 

 SELECT * FROM NHACCU WHERE MANC = 'NC100';
