package book;

public class Book {

    private String name;            // 책 제목
    private String year;            // 발행연도
    private String author;          // 저자
    private String publisher;       // 출판사
    private String location;        // 도서관 내 도서 위치
    private String isAvailable;     // 대여 가능 여부

    public Book(String name, String year, String author, String publisher, String location, String isAvailable) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.publisher = publisher;
        this.location = location;
        this.isAvailable = isAvailable;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getIsAvailable() { return isAvailable; }
    public void setIsAvailable(String isAvailable) { this.isAvailable = isAvailable; }
}

