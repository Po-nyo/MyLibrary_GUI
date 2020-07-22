package book.service;

import book.Book;
import book.dao.BookDAO;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.Set;

public class BookSearch {

    private BookDAO bookDAO;
    private String[] header = {"이름", "연도", "글쓴이", "출판사", "위치", "대여"};

    public BookSearch(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    private TableModel contents(String bookName) {
        Set<String> keys = bookDAO.getKeySet();
        Set<String> supervisedKey = new HashSet<>();

        DefaultTableModel model = new DefaultTableModel(header, 0);

        for (String key : keys)
            if (key.matches(".*" + bookName + ".*"))
                supervisedKey.add(key);

        for (String key : supervisedKey) {
            Book book = bookDAO.search(key);

            model.addRow(new String[]{book.getName(),
                                      book.getYear(),
                                      book.getAuthor(),
                                      book.getPublisher(),
                                      book.getLocation(),
                                      book.getIsAvailable()});
        }

        return model;
    }

    public TableModel getTableModel(String bookName) {
        return contents(bookName);
    }

}

