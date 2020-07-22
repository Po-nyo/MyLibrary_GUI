package gui.book.panels;

import book.dao.BookDAO;

import javax.swing.*;
import java.awt.*;

public class BookTablePanel extends JPanel {

    private JTable bookTable;
    private BookDAO bookDAO;

    public BookTablePanel(JTable bookTable) {
        this.bookTable = bookTable;

        this.setBackground(Color.MAGENTA);
        this.setLayout(null);
        this.setSize(700, 470);


        JScrollPane scrollPane = new JScrollPane(this.bookTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 0, 700, 470);
        this.add(scrollPane);
    }


}
