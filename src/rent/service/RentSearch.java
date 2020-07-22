package rent.service;

import rent.Rent;
import rent.dao.RentDAO;

import javax.swing.*;
import java.util.*;

public class RentSearch {

    private RentDAO rentDAO;
    private String[] header = {"책 이름", "빌린 사람", "빌린 날짜", "반납 날짜"};

    public RentSearch(RentDAO rentDAO) {
        this.rentDAO = rentDAO;
    }

    public JTable getCurrentRentTable() {
        return new JTable(contents(false), header);
    }

    public JTable getAllRentLogTable() {
        return new JTable(contents(true), header);
    }

    public String[][] contents(boolean done) {
        Set<String> keys = rentDAO.getKeySet();
        Set<String> supervisedKey;

        if(!done) {
            supervisedKey = new HashSet<>();
            for (String key : keys) {
                if (!rentDAO.search(key).isDone())
                    supervisedKey.add(key);
            }
        }
        else
            supervisedKey = keys;

        String[][] contents;
        contents = new String[supervisedKey.size()][4];
        int index = 0;

        List<Rent> list = new ArrayList<>();

        Collections.sort(list);

        for(String key : supervisedKey) {
            list.add(rentDAO.search(key));
        }

        for(Rent rent : list) {
            contents[index][0] = rent.getBook().getName();
            contents[index][1] = rent.getMember().getName();
            contents[index][2] = rent.getRentDate();
            contents[index++][3] = rent.getReturnDate();
        }

        return contents;
    }
}
