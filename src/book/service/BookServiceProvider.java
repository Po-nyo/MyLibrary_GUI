package book.service;

import book.dao.BookDAO;

public class BookServiceProvider {

    private BookRegister bookRegister;
    private BookModifier bookModifier;
    private BookDeleter bookDeleter;
    private BookSearch bookSearch;

    public BookServiceProvider(BookDAO bookDAO) {
        this.bookRegister = new BookRegister(bookDAO);
        this.bookModifier = new BookModifier(bookDAO);
        this.bookDeleter = new BookDeleter(bookDAO);
        this.bookSearch = new BookSearch(bookDAO);
    }

    public BookRegister getBookRegister() {
        return bookRegister;
    }
    public BookModifier getBookModifier() {
        return bookModifier;
    }
    public BookDeleter getBookDeleter() {
        return bookDeleter;
    }
    public BookSearch getBookSearch() {
        return bookSearch;
    }

}
