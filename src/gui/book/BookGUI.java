package gui.book;

import dataManagement.DataManager;
import gui.book.panels.BookNavPanel;
import gui.book.panels.BookSearchPanel;
import gui.book.panels.BookTablePanel;
import service.AllServiceProvider;

import javax.swing.*;

public class BookGUI extends JFrame {
    // 필드
    private static boolean authorized;
    private final int bookPanelWidth = 800;
    private final int bookPanelHeight = 500;
    private DataManager dm;
    private AllServiceProvider asp;

    // 생성자
    public BookGUI(DataManager dm, AllServiceProvider asp, boolean authorized) {
        this.dm = dm;
        this.asp = asp;
        BookGUI.authorized = authorized;

        setTitle("도서 서비스");
        BookPanel panel = new BookPanel(dm, asp);
        setContentPane(panel);

        setSize(817, 570);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    class BookPanel extends JPanel {

        private BookNavPanel navPanel;
        private BookSearchPanel searchPanel;
        private BookTablePanel tablePanel;
        private JTable bookTable;

        public BookPanel(DataManager dm, AllServiceProvider asp) {
            // bookTable 가져오기
            bookTable = new JTable(asp.getBookServiceProvider().getBookSearch().getTableModel(""));

            this.setLayout(null);

            // Nav 영역 Panel
            navPanel = new BookNavPanel(bookTable, dm, asp);
            navPanel.setLocation(0,0);
            this.add(navPanel);

            // search 영역 Panel
            searchPanel = new BookSearchPanel(bookTable, asp);
            searchPanel.setLocation(100, 0);
            this.add(searchPanel);

            // Table 영역 Panel
            tablePanel = new BookTablePanel(bookTable);
            tablePanel.setLocation(100, 60);
            this.add(tablePanel);


            this.setSize(bookPanelWidth, bookPanelHeight);
        }
    }

    public static boolean isAuthorized() {
        return authorized;
    }
}
