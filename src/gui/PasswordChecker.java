package gui;

import dataManagement.DataManager;
import gui.book.BookGUI;
import service.AllServiceProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordChecker extends JFrame {

    public PasswordChecker(DataManager dm, AllServiceProvider asp, int i) {
        this.setTitle("관리자 확인");
        this.setLayout(new GridLayout(2, 2));
        JLabel label = new JLabel("관리자인 경우 비밀번호");
        JTextField tf = new JTextField(20);
        JButton jButton1 = new JButton("일반 사용자");
        JButton jButton2 = new JButton("관리자 로그인");

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(i == 0) {
                    new BookGUI(dm, asp, false);
                    dispose();
                }
                else {
                    // 멤버
                }
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(i == 0) {
                    if(tf.getText().equals(MainGUI.getPassword())) {
                        new BookGUI(dm, asp, true);
                        dispose();
                    }
                    else {
                        MainGUI.showMessage("비밀번호가 틀립니다");
                        dispose();
                    }
                }
                else {
                    // 멤버
                }
            }
        });

        this.add(label);
        this.add(tf);
        this.add(jButton1);
        this.add(jButton2);
        this.setVisible(true);
        this.setLocationRelativeTo(null);    // 화면 중앙에 위치
        this.setSize(300, 150);
    }
}
