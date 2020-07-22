package book.service;

import book.Book;
import book.dao.BookDAO;

public class BookRegister {

    private BookDAO bookDAO;

    public BookRegister(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public void insertBook(String name, String year, String author, String publisher, String location, String isAvailable) {
        Book b = new Book(name, year, author, publisher, location, isAvailable);
        this.bookDAO.insert(name, b);
    }
}
