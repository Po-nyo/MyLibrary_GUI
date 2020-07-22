package gui;

//import dataManagement.DataManager;
import dataManagement.DataManager;
import service.AllServiceProvider;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {

    private static final String password = "helloworld!";
    private DataManager dm;
    private AllServiceProvider asp;

    public MainGUI(DataManager dm) {
        setTitle("도서관 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.dm = dm;
        this.asp = new AllServiceProvider(dm.getBookDAO(), dm.getMemberDAO(), dm.getRentDAO());

        MainPanel panel = new MainPanel(dm, asp);
        setContentPane(panel);

        setVisible(true);
        setLocationRelativeTo(null);
        setSize(300, 300);
    }

    class MainPanel extends JPanel {

        public MainPanel(DataManager dm, AllServiceProvider asp) {
            this.setLayout(null);

            JButton bookPageBtn = new JButton("도서");
            bookPageBtn.setSize(70, 50);
            bookPageBtn.setLocation(60, 100);

            JButton memberPageBtn = new JButton("회원");
            memberPageBtn.setSize(70, 50);
            memberPageBtn.setLocation(170, 100);

            bookPageBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new PasswordChecker(dm, asp, 0);
                }
            });

            memberPageBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new PasswordChecker(dm, asp, 1);
                }
            });

            this.add(bookPageBtn);
            this.add(memberPageBtn);
        }
    }
    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "메세지", JOptionPane.INFORMATION_MESSAGE);
    }

    public static String getPassword() {
        return password;
    }

}
