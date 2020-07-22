package gui.book.panels;
import book.service.BookSearch;
import service.AllServiceProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookSearchPanel extends JPanel {

    private JTextField tf;
    private JButton btn;
    private JTable bookTable;
    private BookSearch bookSearch;
    private AllServiceProvider asp;

    public BookSearchPanel(JTable bookTable, AllServiceProvider asp) {
        this.asp = asp;
        this.bookTable = bookTable;

        this.setBackground(Color.PINK);
        this.setLayout(null);
        this.setSize(700, 60);

        tf = new JTextField(20);
        tf.setBounds(130, 20, 200,20);
        this.add(tf);

        btn = new JButton("검색");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookName = tf.getText();
                bookTable.setModel(asp.getBookServiceProvider().getBookSearch().getTableModel(bookName));
                tf.setText("");
            }
        });
        btn.setSize(60, 30);
        btn.setLocation(330, 15);
        this.add(btn);
    }

}
