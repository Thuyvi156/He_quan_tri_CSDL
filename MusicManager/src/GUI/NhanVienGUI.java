package GUI;

import BUS.NhanVienBUS;
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import anlavn.ui.Mode;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class NhanVienGUI extends javax.swing.JPanel {
    
     public NhanVienGUI(){
        initComponents();
        setSize(1050, 680);
        getListComboBox();
        fillTable();
    }
    
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lbNV = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbKetQua = new javax.swing.JLabel();
        lbKQ = new javax.swing.JLabel();
        cbbSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btTimKiem = new java.awt.Button();
        jPanel4 = new javax.swing.JPanel();
        lbEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lbID = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        lbHo = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        lbDT = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        lbNgaySinh = new javax.swing.JLabel();
        txtNgayVL = new com.toedter.calendar.JDateChooser();
        lbNgaySinh1 = new javax.swing.JLabel();
        lbChucVu = new javax.swing.JLabel();
        cbbVaiTro = new javax.swing.JComboBox<>();
        btThem = new java.awt.Button();
        btSua = new java.awt.Button();
        btXoa = new java.awt.Button();
        jSeparator1 = new javax.swing.JSeparator();
        btALL = new java.awt.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Họ tên", "Ngày sinh", "SĐT", "Email", "Vai Trò", "Ngày vào làm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        jPanel1.setBackground(new java.awt.Color(0, 0, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        lbNV.setBackground(new java.awt.Color(0, 0, 204));
        lbNV.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbNV.setForeground(new java.awt.Color(255, 255, 255));
        lbNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNV.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbNV, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 0, 0), 2, true), "Tìm Kiếm Nâng Cao", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        lbKetQua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbKetQua.setForeground(new java.awt.Color(255, 0, 0));
        lbKetQua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbKQ.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbKQ.setForeground(new java.awt.Color(255, 0, 0));
        lbKQ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cbbSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã nhân viên", "Họ tên", "SĐT", "Email", "Vai trò" }));

        btTimKiem.setBackground(new java.awt.Color(0, 0, 0));
        btTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btTimKiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btTimKiem.setLabel("Tìm Kiếm");
        btTimKiem.setName(""); // NOI18N
        btTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(cbbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1117, 1117, 1117)
                        .addComponent(lbKQ, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(17, 17, 17)))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbKetQua, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbKQ, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        lbEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbEmail.setText("Email:");

        lbID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbID.setText("Mã nhân viên");

        lbHo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbHo.setText("Họ Tên:");

        lbDT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbDT.setText("SĐT:");

        lbNgaySinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbNgaySinh.setText("Ngày Sinh:");

        lbNgaySinh1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbNgaySinh1.setText("Ngày vào làm");

        lbChucVu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbChucVu.setText("Vai Trò");

        btThem.setBackground(new java.awt.Color(0, 0, 255));
        btThem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btThem.setForeground(new java.awt.Color(255, 255, 255));
        btThem.setLabel("Thêm");
        btThem.setName(""); // NOI18N
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btSua.setBackground(new java.awt.Color(255, 153, 0));
        btSua.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btSua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btSua.setForeground(new java.awt.Color(255, 255, 255));
        btSua.setLabel("Sửa");
        btSua.setName(""); // NOI18N
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        btXoa.setBackground(new java.awt.Color(204, 0, 0));
        btXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btXoa.setForeground(new java.awt.Color(255, 255, 255));
        btXoa.setLabel("Xóa");
        btXoa.setName(""); // NOI18N
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(lbHo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbID)
                                .addGap(20, 20, 20)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtHoTen)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(txtMaNV)))
                    .addComponent(lbNgaySinh))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbDT, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDT))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbNgaySinh1)
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNgayVL, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(txtEmail)
                            .addComponent(cbbVaiTro, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbHo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbNgaySinh1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtNgayVL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jSeparator1.setBackground(new java.awt.Color(153, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(51, 0, 51));

        btALL.setBackground(new java.awt.Color(0, 102, 0));
        btALL.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btALL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btALL.setForeground(new java.awt.Color(255, 255, 255));
        btALL.setLabel("Làm mới");
        btALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btALLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(btALL, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btALL, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        try {
            int eff = NhanVienBUS.insert(getView());
            if(eff == 0) throw new RuntimeException();
            cleanView();
            fillTable();
        } catch (RuntimeException | SQLException ex) {
            System.err.println(ex.toString());
            Mode.WMessage(this, "Error try to insert NhanVien");
        }
    }//GEN-LAST:event_btThemActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        try {
            int eff = NhanVienBUS.update(getView());
            if(eff == 0) throw new RuntimeException();
            cleanView();
            fillTable();
        } catch (RuntimeException | SQLException ex) {
            System.err.println(ex.toString());
            Mode.WMessage(this, "Error try to update NhanVien");
        }
    }//GEN-LAST:event_btSuaActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        try {
            if(Mode.WConfirm(this, "Are you sure to delete this NhanVien") != JOptionPane.YES_OPTION) return;
            int eff = NhanVienBUS.delete(getView().getMaNV());
            if(eff == 0) throw new RuntimeException();
            cleanView();
            fillTable();
        } catch (RuntimeException | SQLException ex) {
            System.err.println(ex.toString());
            Mode.WMessage(this, "Error try to delete NhanVienv");
        }
    }//GEN-LAST:event_btXoaActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        viewDetail();
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btALLActionPerformed
        cleanView();
        fillTable();
    }//GEN-LAST:event_btALLActionPerformed

    private void btTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemActionPerformed
        try {
            searchBy();
        }catch(SQLException ex){
            System.err.println(ex.toString());
            Mode.WMessage(this, "Error try to search NhanVienv");
        }
    }//GEN-LAST:event_btTimKiemActionPerformed


    private DefaultTableModel model;
    List<NhanVienDTO> listNV = new ArrayList<>();
    List<String> listVaiTro = new ArrayList<>();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btALL;
    private java.awt.Button btSua;
    private java.awt.Button btThem;
    private java.awt.Button btTimKiem;
    private java.awt.Button btXoa;
    private javax.swing.JComboBox<String> cbbSearch;
    private javax.swing.JComboBox<String> cbbVaiTro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbChucVu;
    private javax.swing.JLabel lbDT;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbHo;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbKQ;
    private javax.swing.JLabel lbKetQua;
    private javax.swing.JLabel lbNV;
    private javax.swing.JLabel lbNgaySinh;
    private javax.swing.JLabel lbNgaySinh1;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private com.toedter.calendar.JDateChooser txtNgayVL;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void getListComboBox(){
        listVaiTro.clear();
        listVaiTro.add("NV_BH:Nhân viên Bán Hàng");
        listVaiTro.add("NV_BT:Nhân viên Bảo Trì");
        listVaiTro.add("NV_QL:Nhân viên Quản Lý");
        for (String vaitro : listVaiTro) {
            cbbVaiTro.addItem(vaitro.split(":")[1]);
        }
    }
    
    private void fillTable() {
        try {
            fillTable(NhanVienBUS.select());
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            Mode.WMessage(this, "Error try to query NhacCu");
        }
    }

    private void fillTable(List<NhanVienDTO> list) {
        listNV = list;
        model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        for (NhanVienDTO e : list) {
            final String vaiTro = listVaiTro.stream().filter(v -> v.startsWith(e.getVaiTro())).findFirst().orElse("None");
            model.addRow(new Object[]{e.getMaNV(), e.getHoTen(), e.getNgaySinh().toString(), e.getSdt(), e.getEmail(), vaiTro.split(":")[1], e.getNgayVL().toString()});
        }
        
        tblNhanVien.setModel(model);
    }

    private void viewDetail() {
        final int i = tblNhanVien.getSelectedRow();
        final NhanVienDTO nv = listNV.get(i);
        txtMaNV.setText(nv.getMaNV());
        txtHoTen.setText(nv.getHoTen());
        txtNgaySinh.setDate(new java.util.Date(nv.getNgaySinh().getTime()));
        txtSDT.setText(nv.getSdt());
        txtEmail.setText(nv.getEmail());
        for(int j = 0 ; j < listVaiTro.size() ; j++){
            if(listVaiTro.get(j).startsWith(nv.getVaiTro())) cbbVaiTro.setSelectedIndex(j);
        }
        txtNgayVL.setDate(new java.util.Date(nv.getNgayVL().getTime()));
    }

    private NhanVienDTO getView() {
        NhanVienDTO nv = new NhanVienDTO();
        nv.setMaNV(txtMaNV.getText().trim());
        nv.setHoTen(txtHoTen.getText().trim());
        nv.setNgaySinh(new java.sql.Date(txtNgaySinh.getDate().getTime()));
        nv.setSdt(txtSDT.getText().trim());
        nv.setEmail(txtEmail.getText().trim());
        nv.setVaiTro(listVaiTro.get(cbbVaiTro.getSelectedIndex()).split(":")[0]);
        nv.setNgayVL(new java.sql.Date(txtNgayVL.getDate().getTime()));
        return nv;
    }
    
    private void cleanView(){
        txtMaNV.setText("");
        txtHoTen.setText("");
        txtNgaySinh.setDate(null);
        txtSDT.setText("");
        txtEmail.setText("");
        cbbVaiTro.setSelectedIndex(0);
        txtNgayVL.setDate(null);
    }
    
    private void searchBy() throws SQLException{
        final String search = txtSearch.getText().trim();
        final int typeSearch= cbbSearch.getSelectedIndex();
        String searchBy = "MANV";
        
        switch (typeSearch) {
            case 0 -> searchBy = "MANV";    // Search by MANV
            case 1 -> searchBy = "HOTEN_NV";// Search by HOTEN_NV
            case 2 -> searchBy = "SDT_NV";  // Search by SDT_NV
            case 3 -> searchBy = "EMAIL_NV";// Search by EMAIL_NV
            case 4 -> searchBy = "VAITRO";  // Search by VAITRO
        }
        
        fillTable(NhanVienDAO.query("SELECT * FROM NHANVIEN WHERE LOWER("+searchBy+") LIKE LOWER(?)", "%"+search+"%"));
    }
}