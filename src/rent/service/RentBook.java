package rent.service;

import book.Book;
import book.dao.BookDAO;
import member.Member;
import member.dao.MemberDAO;
import rent.Rent;
import rent.dao.RentDAO;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RentBook {
    private BookDAO bookDAO;
    private MemberDAO memberDAO;
    private RentDAO rentDAO;

    public RentBook(BookDAO bookDAO, MemberDAO memberDAO, RentDAO rentDAO) {
        this.bookDAO = bookDAO;
        this.memberDAO = memberDAO;
        this.rentDAO = rentDAO;
    }

    public void rent(String bookName, String memberName) {
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
        Calendar rightNow = Calendar.getInstance();
        String currentDate = formatter.format(rightNow.getTime());

        Book b = bookDAO.search(bookName);
        Member m = memberDAO.search(memberName);
        b.setIsAvailable("불가능");
        m.getRents().add(b.getName());
        Rent rent = new Rent(b, m, currentDate);

        rentDAO.insert(bookName, rent);
    }

}
