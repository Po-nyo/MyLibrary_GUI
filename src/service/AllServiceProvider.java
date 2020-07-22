package service;

import book.dao.BookDAO;
import book.service.BookServiceProvider;
import member.dao.MemberDAO;
//import member.service.MemberServiceProvider;
import rent.dao.RentDAO;
import rent.service.RentServiceProvider;

public class AllServiceProvider {

    private BookServiceProvider bookServiceProvider;
    private RentServiceProvider rentServiceProvider;
//    private MemberServiceProvider memberServiceProvider;


    public AllServiceProvider(BookDAO bookDAO, MemberDAO memberDAO, RentDAO rentDAO) {
        this.bookServiceProvider = new BookServiceProvider(bookDAO);
        this.rentServiceProvider = new RentServiceProvider(bookDAO, memberDAO, rentDAO);
//        this.memberServiceProvider = new MemberServiceProvider(memberDAO);
    }

    public BookServiceProvider getBookServiceProvider() {
        return bookServiceProvider;
    }
    public RentServiceProvider getRentServiceProvider() {
        return rentServiceProvider;
    }
//    public MemberServiceProvider getMemberServiceProvider(){
//        return memberServiceProvider;
//    }
}
