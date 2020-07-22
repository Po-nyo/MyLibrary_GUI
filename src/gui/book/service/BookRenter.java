package gui.book.service;

import book.Book;
import dataManagement.DataManager;
import gui.MainGUI;
import service.AllServiceProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookRenter extends JFrame {

    private DataManager dm;
    private AllServiceProvider asp;

    public BookRenter(String bookName, DataManager dm, AllServiceProvider asp) {
        this.dm = dm;
        this.asp = asp;

        setTitle("책 빌리기");
        Book b = dm.getBookDAO().search(bookName);

        if(b.getIsAvailable().equals("가능")) {
            setLayout(new GridLayout(3, 1));
            JLabel jLabel = new JLabel(bookName);
            JTextField tf = new JTextField(50);
            JButton jButton = new JButton("대여하기");
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = tf.getText().trim();

                    if (dm.getMemberDAO().search(input) != null) {
                        asp.getRentServiceProvider().getRentBook().rent(bookName, input);

                        dm.getSaveData().saveAllData();
                        MainGUI.showMessage("대여 완료했습니다!");
                        dispose();
                    }
                    else {
                        MainGUI.showMessage("없는 회원입니다. \n회원가입을 해주세요.");
                        dispose();
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
        else {
            MainGUI.showMessage("대여 불가능입니다!");
        }
    }
}
