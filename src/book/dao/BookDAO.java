package book.dao;

import book.Book;
import java.util.HashMap;
import java.util.Set;

public class BookDAO {
    // 필드
    private static HashMap<String, Book> bookDB;        // Book 정보를 담은 DB 객체 레퍼런스

    // 생성자
    public BookDAO() {
        bookDB = new HashMap<String, Book>();           // book DB를 HashMap 객체로 생성
    }

    public void insert(String name, Book book) {
        bookDB.put(name, book);
    }

    public Book search(String name) {
        return bookDB.get(name);
    }

    public void delete(String name) {
        bookDB.remove(name);
    }

    public Set<String> getKeySet() {
        return bookDB.keySet();
    }

    public void printBookInfo(Book book) {
        System.out.println("1. 도서 제목: " + book.getName());
        System.out.println("2. 도서 발행 연도: " + book.getYear());
        System.out.println("3. 도서 저자: " + book.getAuthor());
        System.out.println("4. 도서 출판사: " + book.getPublisher());
        System.out.println("5. 도서 위치: " + book.getLocation());
    }
}
