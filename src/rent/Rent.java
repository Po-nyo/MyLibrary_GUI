package rent;

import book.Book;
import member.Member;


public class Rent implements Comparable<Rent> {

    private Book book;
    private Member member;
    private String rentDate;
    private String returnDate = "-";
    private boolean done = false;

    public Rent(Book book, Member member, String rentDate) {
        this.book = book;
        this.member = member;
        this.rentDate = rentDate;
    }

    public Rent(Book book, Member member, String rentDate, boolean done) {
        this(book, member, rentDate);
        this.done = done;
    }

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }
    public void setMember(Member member) {
        this.member = member;
    }

    public String getRentDate() {
        return rentDate;
    }
    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public int compareTo(Rent o) {
        return this.getRentDate().compareTo(o.getRentDate());
    }
}
