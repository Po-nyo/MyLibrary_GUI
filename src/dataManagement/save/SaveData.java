package dataManagement.save;

import book.Book;
import book.dao.BookDAO;
import member.Member;
import member.dao.MemberDAO;
import rent.Rent;
import rent.dao.RentDAO;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class SaveData {
    // 필드
    public BookDAO bookDAO;
    public MemberDAO memberDAO;
    public RentDAO rentDAO;

    // 생성자
    public SaveData(BookDAO bookDAO, MemberDAO memberDAO, RentDAO rentDAO) {
        this.bookDAO = bookDAO;
        this.memberDAO = memberDAO;
        this.rentDAO = rentDAO;
    }

    public void saveAllData() {
        this.saveRent();
        this.saveBook();
        this.saveMember();
    }

    public void saveBook() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("bookTest.txt"), StandardCharsets.UTF_8));
            for(String key : bookDAO.getKeySet()) {
                Book book = bookDAO.search(key);
                String s = book.getName()+"/"+book.getYear()+"/"+book.getAuthor()+"/"+book.getPublisher()+"/"+book.getLocation()+"/"+book.getIsAvailable()+"\n";
                bw.write(s);
            }

            bw.close();
            System.out.println("완료");
        }
        catch (IOException e ){
            System.out.println("오류");
        }
    }

    public void saveMember() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("memberTest.txt"), StandardCharsets.UTF_8));
            for(String key : memberDAO.getKeySet()) {
                Member member = memberDAO.search(key);
                String s = member.getName()+"/"+member.getGender()+"/"+member.getPhoneNumber()+"/"+member.getAddress()+"/"+member.getRents().toString()+"\n";
                bw.write(s);
            }

            bw.close();
            System.out.println("완료");
        }
        catch (IOException e ){
            System.out.println("오류");
        }
    }

    public void saveRent() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("rentTest.txt"), StandardCharsets.UTF_8));
            for(String key : rentDAO.getKeySet()) {
                Rent rent = rentDAO.search(key);
                Book b = rent.getBook();
                Member m = rent.getMember();
                String s = b.getName()+"/"+m.getName()+"/"+rent.getRentDate()+"/"+rent.getReturnDate()+"/"+rent.isDone()+"\n";
                bw.write(s);
            }

            bw.close();
            System.out.println("완료");
        }
        catch (IOException e ){
            System.out.println("오류");
        }
    }


}
