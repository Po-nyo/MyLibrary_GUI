package dataManagement;

import book.dao.BookDAO;
import dataManagement.load.LoadData;
import dataManagement.save.SaveData;
import member.dao.MemberDAO;
import rent.dao.RentDAO;

public class DataManager {

    private BookDAO bookDAO;
    private MemberDAO memberDAO;
    private RentDAO rentDAO;

    private SaveData saveData;
    private LoadData loadData;

    public DataManager() {
        this.bookDAO = new BookDAO();
        this.memberDAO = new MemberDAO();
        this.rentDAO = new RentDAO();

        this.saveData = new SaveData(bookDAO, memberDAO, rentDAO);
        this.loadData = new LoadData(bookDAO, memberDAO, rentDAO);
    }

    public BookDAO getBookDAO() {
        return bookDAO;
    }
    public MemberDAO getMemberDAO() {
        return memberDAO;
    }
    public RentDAO getRentDAO() {
        return rentDAO;
    }
    public SaveData getSaveData() {
        return saveData;
    }
    public LoadData getLoadData() {
        return loadData;
    }
}
