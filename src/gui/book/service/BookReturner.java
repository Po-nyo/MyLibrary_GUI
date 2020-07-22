package gui.book.service;

import dataManagement.DataManager;
import gui.MainGUI;
import service.AllServiceProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookReturner extends JFrame {

    private AllServiceProvider asp;
    private DataManager dm;

    public BookReturner(DataManager dm, AllServiceProvider asp) {
        this.dm = dm;
        this.asp = asp;

        setTitle("책 반납하기");

        this.setLayout(new GridLayout(3, 1));

        JLabel jLabel = new JLabel("반납할 책 이름");
        JTextField tf = new JTextField(50);
        JButton jButton = new JButton("반납하기");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = tf.getText().trim();
                if (dm.getRentDAO().search(input) != null) {
                    asp.getRentServiceProvider().getReturnBook().returnBook(input);

                    dm.getSaveData().saveAllData();

                    MainGUI.showMessage("반납 완료했습니다!");
                    dispose();
                }
                else {
                    MainGUI.showMessage("빌린 적이 없는 책입니다!");
                }
            }
        });

        this.add(jLabel);
        this.add(tf);
        this.add(jButton);

        this.setVisible(true);
        this.setLocationRelativeTo(null);    // 화면 중앙에 위치
        this.setSize(200, 200);

    }
}
