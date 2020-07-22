package rent.service;

import book.dao.BookDAO;
import member.dao.MemberDAO;
import rent.dao.RentDAO;

public class RentServiceProvider {

    private RentBook rentBook;
    private ReturnBook returnBook;

    public RentServiceProvider(BookDAO bookDAO, MemberDAO memberDAO, RentDAO rentDAO) {
        rentBook = new RentBook(bookDAO, memberDAO, rentDAO);
        returnBook = new ReturnBook(rentDAO);
    }

    public RentBook getRentBook() {
        return rentBook;
    }
    public ReturnBook getReturnBook() {
        return returnBook;
    }
}
