package rent.dao;

import rent.Rent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RentDAO {

    private Map<String, Rent> rentDB;

    public RentDAO() {
        this.rentDB = new HashMap<>();
    }

    public void insert(String bookName, Rent rent) {
        rentDB.put(bookName, rent);
    }

    public Rent search(String key) {
        return rentDB.get(key);
    }

    public void delete(String key) {
        rentDB.remove(key);
    }

    public Set<String> getKeySet() {
        return rentDB.keySet();
    }
}
