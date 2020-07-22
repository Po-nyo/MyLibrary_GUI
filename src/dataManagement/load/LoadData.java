package dataManagement.load;

import book.Book;
import book.dao.BookDAO;
import member.Member;
import member.dao.MemberDAO;
import rent.Rent;
import rent.dao.RentDAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LoadData {
    // 필드
    private BookDAO bookDAO;                // Book 접근 객체 레퍼런스
    private MemberDAO memberDAO;            // Member 접근 객체 레퍼런스
    private RentDAO rentDAO;                // Rent 접근 객체 레퍼런스

    // 생성자
    public LoadData(BookDAO bookDAO, MemberDAO memberDAO, RentDAO rentDAO) {
        this.bookDAO = bookDAO;
        this.memberDAO = memberDAO;
        this.rentDAO = rentDAO;
        this.call();
    }

    public void call() {
        loadBook();
        loadMember();
        loadRent();
    }

    private void loadBook() {
        try {
            Scanner scan = new Scanner(new File("bookTest.txt"));

            while(scan.hasNextLine()) {                 // 다음 line이 있는 동안 계속 루프를 돈다.
                String line = scan.nextLine();          // txt파일로부터 한 줄 얻어온다.
                if(line.equals(""))                     // 만약 "\n"라면, 즉 EOF이라면
                    break;                              // 반복문 종료

                String[] splitted = line.split("/");    // 문자열 '/'를 기준으로 split한다.
                Book book = new Book(splitted[0], splitted[1], splitted[2], splitted[3], splitted[4], splitted[5]); // 읽어들인 데이터로부터 Book객체를 생성
                bookDAO.insert(splitted[0], book);       // 전체 데이터를 담는 BookDAO 객체에 put한다.
            }
            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("기존 데이터가 없슴둥!!!! 뿌우~~~ ㅠ3ㅠ");
        }
    }


    /**
     *
     */
    private void loadMember() {
        try {
            Scanner scan = new Scanner(new File("memberTest.txt"));

            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                if(line.equals(""))
                    break;

                String[] splitted = line.split("/");
                splitted[4] = splitted[4].replace("[", "");
                splitted[4] = splitted[4].replace("]", "");
                String[] bookList = splitted[4].split(", ");
                Set<String> list = new HashSet<>(Arrays.asList(bookList));
                Member member;
                if(splitted[4].equals(""))
                    member = new Member(splitted[0], splitted[1], splitted[2], splitted[3]);
                else
                    member = new Member(splitted[0], splitted[1], splitted[2], splitted[3], list);
                memberDAO.insert(splitted[0], member);
            }
            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("기존 데이터가 없습니다");
        }
    }

    /**
     *
     */
    private void loadRent() {
        try {
            Scanner scan = new Scanner(new File("./rentTest.txt"));

            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println(line);
                if(line.equals(""))
                    break;

                String[] splitted = line.split("/");
                Book book = bookDAO.search(splitted[0]);
                Member member = memberDAO.search(splitted[1]);
                String rentDate = splitted[2];
                String returnDate = splitted[3];
                String done = splitted[4];
                Rent rent = new Rent(book, member, rentDate, done.equals("true"));
                rentDAO.insert(book.getName(), rent);
            }
            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("기존 데이터가 없습니다");
        }
    }
}
