package rent.service;

import rent.Rent;
import rent.dao.RentDAO;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReturnBook {

    private RentDAO rentDAO;

    public ReturnBook(RentDAO rentDAO) {
        this.rentDAO = rentDAO;
    }

    public void returnBook(String bookName) {
        Rent rent = rentDAO.search(bookName);
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
        Calendar rightNow = Calendar.getInstance();
        String currentDate = formatter.format(rightNow.getTime());

        rent.getBook().setIsAvailable("가능");
        rent.setReturnDate(currentDate);
        rent.setDone(true);
        rent.getMember().getRents().remove(bookName);
    }
}
