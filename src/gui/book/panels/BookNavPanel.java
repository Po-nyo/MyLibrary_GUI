package gui.book.panels;

import dataManagement.DataManager;
import gui.MainGUI;
import gui.book.BookGUI;
import gui.book.service.*;
import service.AllServiceProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookNavPanel extends JPanel {
    // 필드
    private final int navWidth = 100;
    private final int navBtnHeight = 106;
    private String[] menuName = {"대여", "반납", "등록", "수정", "삭제"};

    // 생성자
    public BookNavPanel(JTable bookTable, DataManager dm, AllServiceProvider asp) {
        this.setLayout(null);
        this.setBackground(Color.YELLOW);


        /**
         * 대여 버튼
         */
        JButton menuBtn1 = new JButton(menuName[0]);
        menuBtn1.setSize(navWidth, navBtnHeight);
        menuBtn1.setLocation(0, 0);
        menuBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = bookTable.getSelectedRow();
                if (row < 0)
                    MainGUI.showMessage("선택된 정보가 없습니다!");
                else {
                    String bookName = (String) bookTable.getModel().getValueAt(row, 0);
                    new BookRenter(bookName, dm, asp);
                }
            }
        });
        this.add(menuBtn1);

        /**
         * 반납 버튼
         */
        JButton menuBtn2 = new JButton(menuName[1]);
        menuBtn2.setSize(navWidth, navBtnHeight);
        menuBtn2.setLocation(0, navBtnHeight*1);
        menuBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookReturner(dm, asp);
            }
        });
        this.add(menuBtn2);


        /**
         * 등록 버튼
         */
        JButton menuBtn3 = new JButton(menuName[2]);
        menuBtn3.setSize(navWidth, navBtnHeight);
        menuBtn3.setLocation(0, navBtnHeight*2);
        menuBtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(BookGUI.isAuthorized())
                    new BookRegister(dm, asp);
                else
                    MainGUI.showMessage("관리자 권한이 필요합니다.");
            }
        });
        this.add(menuBtn3);

        /**
         * 수정 버튼
         */
        JButton menuBtn4 = new JButton(menuName[3]);
        menuBtn4.setSize(navWidth, navBtnHeight);
        menuBtn4.setLocation(0, navBtnHeight*3);
        menuBtn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(BookGUI.isAuthorized()) {
                    int row = bookTable.getSelectedRow();
                    if (row < 0)
                        MainGUI.showMessage("선택된 정보가 없습니다!");
                    else {
                        if (bookTable.getModel().getValueAt(row, 5).equals("불가능"))
                            MainGUI.showMessage("현재 수정이 불가능합니다!");
                        else
                            new BookModifier(bookTable.getModel(), row, dm, asp);
                    }
                }
                else
                    MainGUI.showMessage("관리자 권한이 필요합니다.");
            }
        });
        this.add(menuBtn4);


        /**
         * 삭제 버튼
         */
        JButton menuBtn5 = new JButton(menuName[4]);
        menuBtn5.setSize(navWidth, navBtnHeight);
        menuBtn5.setLocation(0, navBtnHeight*4);
        menuBtn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(BookGUI.isAuthorized()) {
                    int row = bookTable.getSelectedRow();
                    if (row < 0)
                        MainGUI.showMessage("선택된 정보가 없습니다!");
                    else {
                        if (bookTable.getModel().getValueAt(row, 5).equals("불가능"))
                            MainGUI.showMessage("현재 삭제가 불가능합니다!");
                        else
                            new BookDeleter(bookTable.getModel(), row, dm, asp);
                    }
                }
                else
                    MainGUI.showMessage("관리자 권한이 필요합니다.");
            }
        });
        this.add(menuBtn5);


        this.setSize(navWidth, 530);
    }
}
