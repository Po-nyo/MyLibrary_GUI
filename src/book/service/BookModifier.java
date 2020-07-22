package book.service;

import book.Book;
import book.dao.BookDAO;

public class BookModifier {
    private BookDAO bookDAO;

    public BookModifier(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public void modifyBook(String bookName, String[] changed) {
        Book target = bookDAO.search(bookName);
        bookDAO.delete(bookName);

        target.setName(changed[0]);
        target.setYear(changed[1]);
        target.setAuthor(changed[2]);
        target.setPublisher(changed[3]);
        target.setLocation(changed[4]);

        bookDAO.insert(target.getName(), target);
    }
}
