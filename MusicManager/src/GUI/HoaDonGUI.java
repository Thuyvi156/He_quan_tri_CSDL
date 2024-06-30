package GUI;

import BUS.ChiTietHoaDonBUS;
import BUS.HoaDonBUS;
import BUS.NhacCuBUS;
import DAO.HoaDonDAO;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.NhacCuDTO;
import anlavn.ui.Mode;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class HoaDonGUI extends javax.swing.JPanel {

    public HoaDonGUI() {
        initComponents();
        this.setSize(1090, 750);
        fillTableHoaDon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtTongTienHoaDon = new javax.swing.JTextField();
        txtSoLuongHoaDon = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMin = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMax = new javax.swing.JTextField();
        btTim = new javax.swing.JButton();
        txtStart = new com.toedter.calendar.JDateChooser();
        txtEnd = new com.toedter.calendar.JDateChooser();
        btnMaNV = new javax.swing.JButton();
        btnMaKH = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChiTietHoaDon = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("QUẢN LÝ HÓA ĐƠN");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Mã NV", "Mã KH", "Ngày lập", "Giảm giá", "Thời gian bảo hành", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.setSelectionBackground(new java.awt.Color(0, 0, 255));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);
        if (tblHoaDon.getColumnModel().getColumnCount() > 0) {
            tblHoaDon.getColumnModel().getColumn(3).setMinWidth(150);
        }

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Số lượng hóa đơn:");
        jLabel12.setMaximumSize(new java.awt.Dimension(62, 15));
        jLabel12.setMinimumSize(new java.awt.Dimension(62, 15));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Tổng tiền các hóa đơn:");
        jLabel17.setMaximumSize(new java.awt.Dimension(62, 15));
        jLabel17.setMinimumSize(new java.awt.Dimension(62, 15));

        txtTongTienHoaDon.setEditable(false);

        txtSoLuongHoaDon.setEditable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "TÌM KIẾM HÓA ĐƠN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Mã HĐ:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Mã KH:");

        txtMaKH.setEditable(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Mã NV:");

        txtMaNV.setEditable(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Thời gian từ:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("đến:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Giá tiền từ:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("đến");

        btTim.setBackground(new java.awt.Color(204, 204, 204));
        btTim.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btTim.setForeground(new java.awt.Color(255, 255, 255));
        btTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_25px.png"))); // NOI18N
        btTim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimActionPerformed(evt);
            }
        });

        txtStart.setDateFormatString("yyyy-MM-dd");

        txtEnd.setDateFormatString("yyyy-MM-dd");

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

        btnClear.setBackground(new java.awt.Color(204, 204, 204));
        btnClear.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit_hover_25px.png"))); // NOI18N
        btnClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStart, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btTim, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btTim)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMaNV)
                        .addComponent(jLabel20)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMaKH)
                        .addComponent(jLabel11)
                        .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel24)
                        .addComponent(txtStart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "CHI TIẾT HÓA ĐƠN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 0, 204))); // NOI18N

        tblChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hoá đơn", "Mã nhạc cụ", "Tên nhạc cụ", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChiTietHoaDon.setSelectionBackground(new java.awt.Color(0, 204, 0));
        jScrollPane2.setViewportView(tblChiTietHoaDon);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuongHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTongTienHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        anlavn.net.License.check("alk~TYmqkzOTN93bzxn2rf6rSbhmto+k9V5GppStoJmlUFAej2UDu/c9jomeq0gOfKLcbL9wSkFUOLDLC67STg2FDkOVThuS+L3zKWSkLLDDFdI=");
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuongHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTienHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        viewChiTietHoaDon();
    }//GEN-LAST:event_tblHoaDonMouseClicked

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

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtMaHD.setText("");
        txtMaNV.setText("");
        txtMaKH.setText("");
        txtMin.setText("");
        txtMax.setText("");
        txtStart.setDate(null);
        txtEnd.setDate(null);
        fillTableHoaDon();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimActionPerformed
        try {
            searchBy();
        }catch(SQLException ex){
            System.err.println(ex.toString());
            Mode.WMessage(this, "Error try to search HoaDon");
        }
    }//GEN-LAST:event_btTimActionPerformed

    
    private DefaultTableModel model;
    private List<HoaDonDTO> listHD = new ArrayList<>();
    private List<NhacCuDTO> listNC = new ArrayList<>();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btTim;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnMaKH;
    private javax.swing.JButton btnMaNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblChiTietHoaDon;
    private javax.swing.JTable tblHoaDon;
    private com.toedter.calendar.JDateChooser txtEnd;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMax;
    private javax.swing.JTextField txtMin;
    private javax.swing.JTextField txtSoLuongHoaDon;
    private com.toedter.calendar.JDateChooser txtStart;
    private javax.swing.JTextField txtTongTienHoaDon;
    // End of variables declaration//GEN-END:variables

    
    private void fillTableHoaDon(){
        try {
            listNC = NhacCuBUS.select();
            fillTableHoaDon(HoaDonBUS.select());
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            Mode.WMessage(this, "Error try to query HoaDon");
        }
    }
    
    private void fillTableHoaDon(List<HoaDonDTO> list){
        listHD = list;
        model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        double total = 0;
        for(HoaDonDTO e : list){
            total += e.getTriGia();
            model.addRow(new Object[]{e.getMaHD(), e.getMaNV(), e.getMaKH(), e.getNgLap().toString(), e.getDiscount(), e.getTgBaoHanh(), String.format("%.0f", e.getTriGia())});
        }
        tblHoaDon.setModel(model);
        txtSoLuongHoaDon.setText(String.valueOf(list.size()));
        txtTongTienHoaDon.setText(String.format("%.0f", total));
    }
    
    private void viewChiTietHoaDon(){
        try {
            final int i = tblHoaDon.getSelectedRow();
            final List<ChiTietHoaDonDTO> listCTHD = ChiTietHoaDonBUS.select(listHD.get(i).getMaHD());
            DefaultTableModel modelCTHD = (DefaultTableModel) tblChiTietHoaDon.getModel();
            modelCTHD.setRowCount(0);
            for(ChiTietHoaDonDTO e : listCTHD){
                NhacCuDTO nhacCu = listNC.stream().filter(nc -> nc.getMaNC().equals(e.getMaNC())).findFirst().orElse(null);
                modelCTHD.addRow(new Object[]{e.getMaHD(), e.getMaNC(), nhacCu.getTenNC(), String.format("%.0f", nhacCu.getGiaBan()), e.getSoLuong(), e.getThanhTien()});
            }
            tblChiTietHoaDon.setModel(modelCTHD);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            Mode.WMessage(this, "Error try to query ChiTietHoaDon");
        }
    }
    
    private void searchBy() throws SQLException{
        final String maHD = txtMaHD.getText().trim(),
                     maNV = txtMaNV.getText(),
                     maKH = txtMaKH.getText(),
                    mint = txtMin.getText().trim(),
                    maxt = txtMax.getText().trim();
        final Date start = txtStart.getDate(),
                    end = txtEnd.getDate();
        
        if(maHD.isBlank() && maNV.isBlank() && maKH.isBlank() && mint.isBlank() && maxt.isBlank() && start == null && end == null) {fillTableHoaDon(); return;}
        
        final double min = !mint.isBlank() ? Double.valueOf(mint): 0, max = !maxt.isBlank() ? Double.valueOf(maxt) : 0;
        String query = "SELECT * FROM HOADON WHERE ";
        List<Object> args = new ArrayList<>();
        if(!maHD.isBlank()) {query += "LOWER(MAHD) LIKE LOWER(?) AND "; args.add("%"+maHD+"%");}
        if(!maNV.isBlank()) {query += "MANV = ? AND "; args.add(maNV);}
        if(!maKH.isBlank()) {query += "MAKH = ? AND "; args.add(maKH);}
        if(min>0 && max>0)  {query += "TRIGIA BETWEEN ? AND ?";args.add(min);args.add(max);}
        if(start!= null && end != null && start.before(end)) {query += "NGLAP BETWEEN ? AND ?";args.add(new java.sql.Date(start.getTime()));args.add(new java.sql.Date(end.getTime()));}
        if(query.endsWith("AND ")) query = query.substring(0, query.length() - 5);
        fillTableHoaDon(HoaDonDAO.query(query, args.toArray()));
    }
}