package GUI;

import BUS.ChiTietHoaDonBUS;
import BUS.HoaDonBUS;
import BUS.KhachHangBUS;
import BUS.NhacCuBUS;
import BUS.NhanVienBUS;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.NhacCuDTO;
import anlavn.net.RandomORG;
import anlavn.ui.Mode;
import java.awt.Image;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BanHangGUI extends javax.swing.JPanel {
    
    public BanHangGUI() {
        initComponents();
        this.setSize(1090, 750);
        panelCTHD.setVisible(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtMaKH = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        btnMaNV = new javax.swing.JButton();
        btnMaKH = new javax.swing.JButton();
        txtNgayLap = new javax.swing.JTextField();
        btTaoHD = new javax.swing.JButton();
        panelCTHD = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMaNC = new javax.swing.JTextField();
        txtTenNC = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        btnMaNC = new javax.swing.JButton();
        btThem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCTHD = new javax.swing.JTable();
        btXacNhan = new javax.swing.JButton();
        btHuy = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        txtGiamGia = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtBaoHanh = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(248, 248, 248), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("TẠO HÓA HƠN BÁN HÀNG");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã NV:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Mã KH:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Mã HĐ:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Ngày lập:");

        txtMaHD.setEditable(false);
        txtMaHD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtMaKH.setEditable(false);
        txtMaKH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtMaNV.setEditable(false);
        txtMaNV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnMaNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMaNV.setText("...");
        btnMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaNVActionPerformed(evt);
            }
        });

        btnMaKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMaKH.setText("...");
        btnMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaKHActionPerformed(evt);
            }
        });

        txtNgayLap.setEditable(false);
        txtNgayLap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btTaoHD.setBackground(new java.awt.Color(0, 153, 51));
        btTaoHD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btTaoHD.setForeground(new java.awt.Color(255, 255, 255));
        btTaoHD.setText("TẠO HÓA ĐƠN");
        btTaoHD.setBorder(null);
        btTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTaoHDActionPerformed(evt);
            }
        });

        panelCTHD.setBackground(new java.awt.Color(255, 255, 255));
        panelCTHD.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "THÔNG TIN HÓA ĐƠN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 153, 51))); // NOI18N

        lblHinh.setBackground(new java.awt.Color(51, 255, 51));
        lblHinh.setForeground(new java.awt.Color(204, 204, 204));
        lblHinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("MÃ NHẠC CỤ:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("TÊN NHẠC CỤ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("SỐ LƯỢNG:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("ĐƠN GIÁ:");

        txtMaNC.setEditable(false);

        txtTenNC.setEditable(false);

        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyReleased(evt);
            }
        });

        txtDonGia.setEditable(false);

        btnMaNC.setBackground(new java.awt.Color(255, 153, 0));
        btnMaNC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMaNC.setText("...");
        btnMaNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaNCActionPerformed(evt);
            }
        });

        btThem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnAdd_150px.png"))); // NOI18N
        btThem.setBorder(null);
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        tblCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhạc cụ", "Tên nhạc cụ", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCTHD.setSelectionBackground(new java.awt.Color(0, 204, 51));
        tblCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCTHD);
        if (tblCTHD.getColumnModel().getColumnCount() > 0) {
            tblCTHD.getColumnModel().getColumn(1).setMinWidth(150);
        }

        btXacNhan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnConfirm_150px.png"))); // NOI18N
        btXacNhan.setBorder(null);
        btXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXacNhanActionPerformed(evt);
            }
        });

        btHuy.setBackground(new java.awt.Color(0, 102, 255));
        btHuy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btHuy.setForeground(new java.awt.Color(255, 255, 255));
        btHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_delete_forever_30px_1.png"))); // NOI18N
        btHuy.setText("HỦY");
        btHuy.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHuyActionPerformed(evt);
            }
        });

        btSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnEdit_150px.png"))); // NOI18N
        btSua.setBorder(null);
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        btXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnDelete_150px.png"))); // NOI18N
        btXoa.setBorder(null);
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("TỔNG TIỀN:");

        txtTongTien.setEditable(false);

        txtGiamGia.setText("0");
        txtGiamGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiamGiaKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("GIẢM GIÁ");

        txtThanhTien.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("THÀNH TIỀN");

        txtBaoHanh.setText("0");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("BẢO HÀNH");

        javax.swing.GroupLayout panelCTHDLayout = new javax.swing.GroupLayout(panelCTHD);
        panelCTHD.setLayout(panelCTHDLayout);
        panelCTHDLayout.setHorizontalGroup(
            panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCTHDLayout.createSequentialGroup()
                .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCTHDLayout.createSequentialGroup()
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCTHDLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCTHDLayout.createSequentialGroup()
                                .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelCTHDLayout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMaNC, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnMaNC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelCTHDLayout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                        .addComponent(txtTenNC, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCTHDLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCTHDLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelCTHDLayout.createSequentialGroup()
                                .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(29, 29, 29)
                                .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDonGia, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(panelCTHDLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(19, 19, 19)
                                .addComponent(txtThanhTien)))
                        .addGap(18, 18, 18)
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelCTHDLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCTHDLayout.createSequentialGroup()
                                .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(202, 202, 202)))))
                .addContainerGap())
        );
        panelCTHDLayout.setVerticalGroup(
            panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCTHDLayout.createSequentialGroup()
                .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCTHDLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtMaNC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMaNC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenNC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(panelCTHDLayout.createSequentialGroup()
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelCTHDLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel17)
                            .addComponent(txtBaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btSua)
                            .addComponent(btXoa)
                            .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCTHDLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(6, 6, 6)
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))))
                .addGap(107, 107, 107))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("----------------------------------------------------------------------------------------------------------------");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addComponent(jLabel1)
                .addContainerGap(388, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(223, 223, 223))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaNV)
                    .addComponent(btnMaKH))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaNVActionPerformed
        JDNV dialog = new JDNV();
        String s = dialog.getMaNV();
        txtMaNV.setText(s);
    }//GEN-LAST:event_btnMaNVActionPerformed

    private void btnMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaKHActionPerformed
        JDKH dialog = new JDKH();
        String s = dialog.getMaKH();
        txtMaKH.setText(s);
    }//GEN-LAST:event_btnMaKHActionPerformed

    private void txtSoLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyReleased
        setThanhTien();
    }//GEN-LAST:event_txtSoLuongKeyReleased

    private void txtGiamGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiamGiaKeyReleased
        setTongTien();
    }//GEN-LAST:event_txtGiamGiaKeyReleased

    private void btnMaNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaNCActionPerformed
        JDNC dialog = new JDNC();
        try {
            NhacCuDTO nhacCu = NhacCuBUS.select(dialog.getMaNC());
            txtMaNC.setText(nhacCu.getMaNC());
            txtTenNC.setText(nhacCu.getTenNC());
            final String donGia = String.format("%.0f", nhacCu.getGiaBan());
            txtDonGia.setText(donGia);
            txtSoLuong.setText("1");
            txtThanhTien.setText(donGia);
            lblHinh.setIcon(new ImageIcon(new ImageIcon(nhacCu.getHinh()).getImage().getScaledInstance(92, 105, Image.SCALE_DEFAULT)));
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }//GEN-LAST:event_btnMaNCActionPerformed

    private void btTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTaoHDActionPerformed
        try{
            final String maNV = txtMaNV.getText(),
                         maKH = txtMaKH.getText();
            
            if(maNV.isBlank() || !NhanVienBUS.exists(maNV)) {
                Mode.WMessage(this, "Error create HoaDon. NhanVien["+maNV+"] is not exists");
                return;
            }
            if(maKH.isBlank() || !KhachHangBUS.exists(maKH)){
                Mode.WMessage(this, "Error create HoaDon. KhachHang["+maKH+"] is not exists");
                return;
            }
            
            String maHD = null;
            do {
                maHD = RandomORG.getString(10, true, true, true);
            } while (HoaDonBUS.exists(maHD));
            txtMaHD.setText(maHD);
            txtNgayLap.setText(LocalDate.now().toString());
            panelCTHD.setVisible(true);
            btnMaNV.setEnabled(false);
            btnMaKH.setEnabled(false);
        }catch(IOException | SQLException ex){
            System.err.println(ex.toString());
            Mode.WMessage(this, "Error create HoaDon");
        }
    }//GEN-LAST:event_btTaoHDActionPerformed

    private void tblCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTHDMouseClicked
        viewDetail();
    }//GEN-LAST:event_tblCTHDMouseClicked

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        insertListCTHD();
    }//GEN-LAST:event_btThemActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        updateListCTHD();
    }//GEN-LAST:event_btSuaActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        deleteListCTHD();
    }//GEN-LAST:event_btXoaActionPerformed

    private void btHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHuyActionPerformed
        cancelHoaDon();
    }//GEN-LAST:event_btHuyActionPerformed

    private void btXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXacNhanActionPerformed
        if(listCTHD.size() < 1){
            Mode.WMessage(this, "Error create HoaDon. List ChiTietHoaDon is empty.");
            return;
        }
        // Create HoaDon with value
        HoaDonDTO hoaDon = new HoaDonDTO();
        hoaDon.setMaHD(txtMaHD.getText());
        hoaDon.setMaNV(txtMaNV.getText());
        hoaDon.setMaKH(txtMaKH.getText());
        hoaDon.setNgLap(new Date(System.currentTimeMillis()));
        try {
            hoaDon.setTgBaoHanh(Double.valueOf(txtBaoHanh.getText().trim()));
        }catch (NumberFormatException e){
            hoaDon.setTgBaoHanh(0);
        }
        hoaDon.setDiscount(getGiamGia());
        hoaDon.setTriGia(getTongTien());
        
        // Insert HoaDon to database
        try {
            int eff = HoaDonBUS.insert(hoaDon);
            if(eff == 0) throw new RuntimeException();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            Mode.WMessage(this, "Error try to insert HoaDon");
            return;
        }

        // Insert ChiTietHoaDon to database
        for(ChiTietHoaDonDTO e : listCTHD){
            try {
                e.setMaHD(hoaDon.getMaHD());
                ChiTietHoaDonBUS.insert(e);
            } catch (SQLException ex) {
                System.err.println(ex.toString());
                Mode.WMessage(this, "Error try to insert ChiTietHoaDon");
            }
        }
        Mode.WMessage(this, "HoaDon was insert successfully");
        cancelHoaDon();
    }//GEN-LAST:event_btXacNhanActionPerformed

    
    
    private ArrayList<ChiTietHoaDonDTO> listCTHD = new ArrayList<>();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btHuy;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btTaoHD;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btXacNhan;
    private javax.swing.JButton btXoa;
    private javax.swing.JButton btnMaKH;
    private javax.swing.JButton btnMaNC;
    private javax.swing.JButton btnMaNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JPanel panelCTHD;
    private javax.swing.JTable tblCTHD;
    private javax.swing.JTextField txtBaoHanh;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNC;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenNC;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

    private int getSoLuong(){
        try {
            return Integer.valueOf(txtSoLuong.getText().trim());
        }catch (NumberFormatException e){
            return 1;
        }
    }
    private double getGiamGia(){
        try {
            return Integer.valueOf(txtGiamGia.getText().trim());
        }catch (NumberFormatException e){
            return 0.0;
        }
    }
    private int getThanhTien(){
        return (int) Math.ceil(Double.valueOf(txtDonGia.getText()) * getSoLuong());
    }
    private void setThanhTien(){
        txtThanhTien.setText(String.valueOf(getThanhTien()));
    }
    private double getTongTien(){
        double total = 0;
        for(ChiTietHoaDonDTO cthd : listCTHD){
            total += cthd.getThanhTien();
        }
        return total - getGiamGia();
    }
    private void setTongTien(){
        txtTongTien.setText(String.format("%.0f", getTongTien()));
    }
    
    private void fillTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) tblCTHD.getModel();
            model.setRowCount(0);
            for (ChiTietHoaDonDTO e : listCTHD) {
                NhacCuDTO nc = NhacCuBUS.select(e.getMaNC());
                model.addRow(new Object[]{e.getMaNC(), nc.getTenNC(), e.getSoLuong(), String.format("%.0f", nc.getGiaBan()), e.getThanhTien()});
            }
            tblCTHD.setModel(model);
            setTongTien();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            Mode.WMessage(this, "Error try to query ChiTietHoaDon");
        }
    }
    
    private void viewDetail(){
        try {
            final int i = tblCTHD.getSelectedRow();
            final ChiTietHoaDonDTO cthd = listCTHD.get(i);
            final NhacCuDTO nc = NhacCuBUS.select(cthd.getMaNC());
            txtMaNC.setText(nc.getMaNC());
            txtTenNC.setText(nc.getTenNC());
            txtSoLuong.setText(String.valueOf(cthd.getSoLuong()));
            txtDonGia.setText(String.format("%.0f", nc.getGiaBan()));
            txtThanhTien.setText(String.valueOf(cthd.getThanhTien()));
            lblHinh.setIcon(new ImageIcon(new ImageIcon(nc.getHinh()).getImage().getScaledInstance(92, 105, Image.SCALE_DEFAULT)));
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            Mode.WMessage(this, "Error try to query ChiTietHoaDon");
        }
    }
    
    private ChiTietHoaDonDTO getView() {
        ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO();
        cthd.setMaNC(txtMaNC.getText());
        cthd.setSoLuong(getSoLuong());
        cthd.setThanhTien(getThanhTien());
        return cthd;
    }
    
    private void cleanView(){
        txtMaNC.setText("");
        txtTenNC.setText("");
        txtSoLuong.setText("0");
        txtDonGia.setText("0");
        txtThanhTien.setText("0");
        lblHinh.setIcon(null);
    }
    
    private void insertListCTHD(){
        ChiTietHoaDonDTO cthd = getView();
        boolean isDuplicate = false;
        for(ChiTietHoaDonDTO e : listCTHD){
            if(e.getMaNC().equals(cthd.getMaNC())) {
                isDuplicate = true;
                break;
            }
        }
        if(!isDuplicate) {
            listCTHD.add(cthd);
            cleanView();
            fillTable();
        }
        else Mode.WMessage(this, "This item was exists.");
    }
    
    private void updateListCTHD(){
        ChiTietHoaDonDTO cthd = getView();
        for(int i = 0 ; i < listCTHD.size() ; i++){
            ChiTietHoaDonDTO e = listCTHD.get(i);
            if(e.getMaNC().equals(cthd.getMaNC())) {
                e.setSoLuong(getSoLuong());
                e.setThanhTien(getThanhTien());
                listCTHD.set(i, e);
                cleanView();
                fillTable();
                break;
            }
        }
    }
    
    private void deleteListCTHD(){
        if(Mode.WConfirm(this, "Are you sure to delete this ChiTietHoaDon") != JOptionPane.YES_OPTION) return;
        ChiTietHoaDonDTO cthd = getView();
        for(int i = 0 ; i < listCTHD.size() ; i++){
            if(listCTHD.get(i).getMaNC().equals(cthd.getMaNC())) {
                listCTHD.remove(i);
                cleanView();
                fillTable();
                break;
            }
        }
    }
    
    private void cancelHoaDon(){
        listCTHD.clear();
        cleanView();
        fillTable();
        txtMaHD.setText("");
        txtNgayLap.setText("");
//        txtMaNV.setText("");
        txtMaKH.setText("");
        panelCTHD.setVisible(false);
        btnMaNV.setEnabled(true);
        btnMaKH.setEnabled(true);
    }

}