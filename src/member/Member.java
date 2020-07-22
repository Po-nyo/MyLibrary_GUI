package member;

import java.util.HashSet;
import java.util.Set;

public class Member {
    // 필드
    private String name;                   // 이름
    private String gender;                 // 성별
    private String phoneNumber;            // 핸드폰번호
    private String address;                // 주소
    private Set<String> rents;             // 해당 회원이 빌린 책 목록

    // 생성자
    public Member(String name, String gender, String phoneNumber, String address) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.rents = new HashSet<>();
    }

    public Member(String name, String gender, String phoneNumber, String address, Set<String> rents) {
        this(name, gender, phoneNumber, address);
        this.rents = rents;
    }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Set<String> getRents() { return rents; }
}
