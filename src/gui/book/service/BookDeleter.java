package gui.book.service;

import dataManagement.DataManager;
import gui.MainGUI;
import service.AllServiceProvider;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookDeleter extends JFrame {

    private DataManager dm;
    private AllServiceProvider asp;

    public BookDeleter(TableModel tm, int selectedRow, DataManager dm, AllServiceProvider asp) {
        this.dm = dm;
        this.asp = asp;

        setTitle("책 삭제하기");

        setLayout(new GridLayout(6, 2));

        String[] labels = {"책 이름", "연도", "저자", "출판사", "위치"};
        JLabel[] jLabels = new JLabel[10];
        for(int i=0; i<jLabels.length-1; i+=2) {
            jLabels[i] = new JLabel(labels[i/2]);
            jLabels[i+1] = new JLabel(""+tm.getValueAt(selectedRow, i/2));
        }

        JButton jButton1 = new JButton("취소하기");
        JButton jButton2 = new JButton("삭제하기");

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asp.getBookServiceProvider().getBookDeleter().deleteBook((String)tm.getValueAt(selectedRow, 0));
                dm.getSaveData().saveBook();
                MainGUI.showMessage("삭제가 완료되었습니다.");
                dispose();
            }
        });

        for(JLabel jl : jLabels)
            this.add(jl);

        this.add(jButton1);
        this.add(jButton2);

        this.setVisible(true);
        this.setLocationRelativeTo(null);    // 화면 중앙에 위치
        this.setSize(200, 200);

    }
}
