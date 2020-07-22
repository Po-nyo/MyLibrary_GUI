package book.service;

import book.dao.BookDAO;

public class BookDeleter {
    private BookDAO bookDAO;

    public BookDeleter(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public void deleteBook(String bookName) {
        bookDAO.delete(bookName);
    }
}
