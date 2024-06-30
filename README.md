# Hệ quản trị Cơ Sở Dữ Liệu
## Giới thiệu đồ án
Dự án "Hệ thống quản lý nội bộ cửa hàng nhạc cụ" nhằm thiết kế và phát triển một giải pháp công nghệ thông tin toàn diện, hỗ trợ quản lý các hoạt động kinh doanh của cửa hàng nhạc cụ. Hệ thống sẽ tích hợp các chức năng quản lý hàng hóa, kho, bán hàng, khách hàng và báo cáo thống kê, đồng thời áp dụng công nghệ hiện đại.
## Mục tiêu đề tài
Mục tiêu chính của đề tài là mong muốn xây dựng một hệ thống tối ưu cho việc quản lý và bán hàng tại cửa hàng nhạc cụ. Bước đầu thực hiện hóa đề tài, sử dụng được những chức năng cơ bản của phần mềm quản lý. Hoàn thiện, phát triển và sửa lỗi của phần mềm. Phát triển và tối ưu hóa các tính năng cơ bản của hệ thống. Cung cấp các báo cáo và phân tích để đánh giá hiệu quả kinh doanh, theo dõi xu hướng và đưa ra chiến lược tốt nhất cho doanh thu.
## Nhóm thực hiện
|    MSSV       |   Họ tên               |   Đánh giá   |
| ------------- |:----------------------:|:------------:|
| 22521657      | Phạm Thanh Thúy Vi     |  100%        |
| 22521654      | Lê Yến Vi              |  100%        |
| 22521305      | Nguyễn Duy Tân         |  100%        |
| 22520816      | Nguyễn Hồng Nhật Long  |  100%        |
## Chức năng của hệ thống
- Quản lý thông tin nhân viên (nhân viên bán hàng, nhân viên bảo trì, nhân viên quản lý).
- Quản lý thông tin khách hàng.
- Quản lý loại nhạc cụ.
- Quản lý hóa đơn.
- Quản lý các phiếu bảo trì.
- Quản lý nhà cung cấp.
- Quản lý kho.
- Báo cáo, thống kê.
## Mô hình thực thể mối kết hợp
https://github.com/Thuyvi156/He_quan_tri_CSDL/assets/148337981/b7abfecc-871c-48e6-a0af-2fb507bcaea2

## Mô hình vật lý
https://github.com/Thuyvi156/He_quan_tri_CSDL/assets/148337981/e7de7066-a1a6-41e7-bb8b-3d12d88ed0ef

## Mô tả dữ liệu quan hệ
- **KHACHHANG** (MAKH, HOTEN_KH, SDT_KH, DIACHI_KH, NGSINH_KH, TICHLUY)
- **NHANVIEN** (MANV, HOTEN_NV, SDT_NV, EMAIL_NV, NGSINH_NV, NGVL, VAITRO)
- **TAIKHOAN** (ID_TK, MANV, EMAIL, MATKHAU, VER_CODE, TRANGTHAI, VAITRO_NV)
- **LOAINHACCU** (MALNC, TEN_LNC)
- **NHACCU** (MANC, MALNC, TENNC, HANG, GIANHAP, GIABAN, TONGSL)
- **HOADON** (MAHD, MANV, MAKH, DISCOUNT, NGLAP, TGBAOHANH, TRIGIA)
- **CTHD** (MAHD, MANC, SL, THANHTIEN)
- **NHACUNGCAP** (MANCC, TENNNC, SDT_NCC, DIACHI_NCC, EMAIL_NCC)
- **PHIEUNHAPKHO** (MAPNK, MANC, MANCC, SL_NHAP, NGNHAP, NOIDUNG_PNK)
- **PHIEUXUATKHO** (MAPXK, MANC, SL_XUAT, NGXUAT, NOIDUNG_PXK)
- **PHIEUBAOTRI** (MAPBT, MANC, MAHD, NGBT, CHITIET_BT)
- **BAOCAO** (MABC, MANV, NGAYBC, CHITIETBC)
