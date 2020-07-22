package gui.book.service;

import dataManagement.DataManager;
import gui.MainGUI;
import service.AllServiceProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookRegister extends JFrame {
    private DataManager dm;
    private AllServiceProvider asp;

    // 생성자
    public BookRegister(DataManager dm, AllServiceProvider asp) {
        this.dm = dm;
        this.asp = asp;

        setTitle("책 등록하기");

        setLayout(new GridLayout(6, 2));

        String[] labels = {"책 이름", "연도", "저자", "출판사", "위치"};
        JLabel[] jLabels = new JLabel[5];
        for(int i=0; i<labels.length; i++)
            jLabels[i] = new JLabel(labels[i]);

        JTextField[] tfs = new JTextField[5];
        for(int i=0; i<tfs.length; i++)
            tfs[i] = new JTextField(20);

        JButton jButton1 = new JButton("취소하기");
        JButton jButton2 = new JButton("등록하기");

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(JTextField tf : tfs) {
                    if(tf.getText().equals("")) {
                        MainGUI.showMessage("필드를 모두 작성해주세요.");
                        return;
                    }
                }

                asp.getBookServiceProvider().getBookRegister().insertBook(
                        tfs[0].getText(),
                        tfs[1].getText(),
                        tfs[2].getText(),
                        tfs[3].getText(),
                        tfs[4].getText(),
                        "가능");

                dm.getSaveData().saveBook();
                MainGUI.showMessage("등록이 완료되었습니다!");
                dispose();
            }
        });

        for(int i=0; i<jLabels.length; i++) {
            this.add(jLabels[i]);
            this.add(tfs[i]);
        }
        this.add(jButton1);
        this.add(jButton2);

        this.setVisible(true);
        this.setLocationRelativeTo(null);    // 화면 중앙에 위치
        this.setSize(200, 200);
    }
}

