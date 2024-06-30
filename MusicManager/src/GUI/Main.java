package GUI;

import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import GUI.model.header;
import GUI.model.navItem;
import anlavn.ui.Mode;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Main extends JFrame implements MouseListener {

    private boolean flag = true;
    private JPanel header, nav, main;
    private int DEFAULT_HEIGHT = 1000, DEFALUT_WIDTH = 1300;
    private ArrayList<String> navItem = new ArrayList<>();  //Chứa thông tin có button cho menu gồm
    private ArrayList<navItem> navObj = new ArrayList<>();  //Chứa cái button trên thanh menu

    public Main() {
        try {
            init();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void init() throws Exception {
        Font font = new Font("Segoe UI", Font.BOLD, 14);
        ImageIcon logo = new ImageIcon("./src/img/header_icon.png");
        setIconImage(logo.getImage());
        setLayout(new BorderLayout());
        setSize(DEFALUT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        //setShape(new RoundRectangle2D.Double(0, 0, DEFALUT_WIDTH, DEFAULT_HEIGHT, 30, 30)); //Bo khung Frame

        /**
         * ********** PHẦN HEADER ************************************
         */
        header = new JPanel(null);
        header.setBackground(new Color(27, 27, 30));
        header.setPreferredSize(new Dimension(DEFALUT_WIDTH, 40));

        header hmain = new header(DEFALUT_WIDTH, 40);
        JLabel user = new JLabel("Chào, " + NhanVienBUS.select(TaiKhoanBUS.LOGGED.getMaNV()).getHoTen());
        user.setFont(font);
        user.setForeground(Color.WHITE);
        user.setBounds(new Rectangle(DEFALUT_WIDTH - 300, -7, 150, 50));
        hmain.add(user);

        //Tạo btn Logout
        navItem btnLogOut = new navItem("", new Rectangle(DEFALUT_WIDTH - 150, -8, 50, 50), "logout_25px.png", "logout_25px.png", "logout_hover_25px.png", new Color(80, 80, 80));
        hmain.add(btnLogOut.isButton());
        btnLogOut.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                TaiKhoanBUS.LOGGED = null;
                DangNhapGUI lg = new DangNhapGUI();
                dispose();
            }
        });

        //Tạo btn EXIT & MINIMIZE
        navItem exit = new navItem("", new Rectangle(DEFALUT_WIDTH - 50, -8, 50, 50), "exit_25px.png", "exit_25px.png", "exit_hover_25px.png", new Color(240, 71, 74));
        navItem minimize = new navItem("", new Rectangle(DEFALUT_WIDTH - 100, -8, 50, 50), "minimize_25px.png", "minimize_25px.png", "minimize_hover_25px.png", new Color(80, 80, 80));

        hmain.add(exit.isButton());
        hmain.add(minimize.isButton());

        exit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        minimize.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setState(Frame.ICONIFIED);
            }
        });

        header.add(hmain);

        /**
         * *************************************************************
         */
        /**
         * ********** PHẦN NAVIGATION ( MENU ) *************************
         */
        nav = new JPanel(null);
        nav.setBackground(new Color(55, 63, 81));
        nav.setPreferredSize(new Dimension(210, DEFAULT_HEIGHT));

        JScrollPane scroll = new JScrollPane(nav);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(1, 100));
        scroll.setHorizontalScrollBarPolicy(scroll.HORIZONTAL_SCROLLBAR_NEVER);

        //Thêm item vào thanh menu (Tên item : icon : icon hover)
        navItem = new ArrayList<>();  //Chứa thông tin có button cho menu gồm ( Tên btn : icon : icon hover )
        navItem.add("Bán Hàng:Shop_20px.png:Shop_20px_active.png");
        navItem.add("Quản Lý Khách Hàng:KhachHang_20px.png:KhachHang_20px_active.png");
        navItem.add("Quản Lý Nhạc Cụ:QLSP_20px.png:QLSP_20px_active.png");
        navItem.add("Quản Lý Nhà Cung Cấp:CongCu_20px.png:CongCu_20px_active.png");
        navItem.add("Quản Lý Nhân Viên:NhanVien_20px.png:NhanVien_20px_active.png");
        navItem.add("Quản Lý Tài Khoản:CaiDat_20px.png:CaiDat_20px_active.png");
        navItem.add("Quản Lý Hoá Đơn:ThongKe_20px.png:ThongKe_20px_active.png");

        outNav();

        /**
         * ********** PHẦN MAIN ( HIỂN THỊ ) *************************
         */
        main = new JPanel(null);
        main.setBackground(Color.WHITE);
//        navObj.get(0).doActive();
//        changeMainInfo(0);
        /**
         * ***********************************************************
         */

        add(header, BorderLayout.NORTH);
        add(scroll, BorderLayout.WEST);
        add(main, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        for (int i = 0; i < navObj.size(); i++) {
            navItem item = navObj.get(i); // lấy vị trí item trong menu
            if (e.getSource() == item) {
                item.doActive(); // Active NavItem đc chọn 
                try {
                    changeMainInfo(i); // Hiển thị ra phần main
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                item.noActive();
            }
        }
    }
    
    private void useFeature(Component cpn, String permission){
        final String vaitro = TaiKhoanBUS.LOGGED.getVaiTroNV();
        if(vaitro.equals(permission)) {
            main.removeAll();
            main.add(cpn);
            main.repaint();
            main.revalidate();
        } else Mode.WMessage(this, "You don't have Permission["+permission+"] to use this feature.\nYour permission is ["+vaitro+"]");
    }

    public void changeMainInfo(int i) throws Exception {
        switch (i) {
            case 0 -> useFeature(new BanHangGUI(), "NV_BH");    // Bán Hàng
            case 1 -> useFeature(new KhachHangGUI(), "NV_BH");  // Quản Lý Khách Hàng
            case 2 -> useFeature(new NhacCuGUI(), "NV_QL");     // Quản Lý Nhạc Cụ
            case 3 -> useFeature(new NhaCungCapGUI(), "NV_QL"); // Quản Lý Nhà Cung Cấp
            case 4 -> useFeature(new NhanVienGUI(), "NV_QL");   // Quản Lý Nhân Viên
            case 5 -> useFeature(new TaiKhoanGUI(), "NV_QL");   // Quản Lý Tài Khoản
            case 6 -> useFeature(new HoaDonGUI(), "NV_BH");     // Quản Lý Hoá Đơn
            default -> Mode.WMessage(this, "We don't have this feature");
        }
    }

    public void outNav() {
        //Gắn cái NavItem vào NavOBJ
        navObj.clear();
        for (int i = 0; i < navItem.size(); i++) {
            String s = navItem.get(i).split(":")[0];
            String icon = navItem.get(i).split(":")[1];
            String iconActive = navItem.get(i).split(":")[2];
            navObj.add(new navItem(s, new Rectangle(0, 200 + 50 * i, 210, 50), icon, iconActive));
            navObj.get(i).addMouseListener(this);
        }
        if (!flag && navObj.size() > 8) //Đổi màu phần DropDown của thống kê
        {
            navObj.get(5).setColorNormal(new Color(86, 94, 127));
            navObj.get(6).setColorNormal(new Color(86, 94, 127));
        }

        //Xuất ra Naigation
        nav.removeAll();
        JLabel profile = new JLabel(new ImageIcon("./src/img/profile01-250px.png"));
        profile.setBounds(0, 0, 210, 200);
        nav.add(profile);
        for (navItem n : navObj) {
            nav.add(n);
        }
        repaint();
        revalidate();
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

    }

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(() -> {
//            Main dialog = new Main();
//            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                @Override
//                public void windowClosing(java.awt.event.WindowEvent e) {
//                    System.exit(0);
//                }
//            });
//        });
//    }

}
