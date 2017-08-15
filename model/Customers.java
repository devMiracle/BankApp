package abcbankpack.model;

import abcbankpack.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customers {
    private int accountNo;
    private String name;
    private String surname;
    private String homeAddress;
    private String phoneNumber;
    private double balance;
    private String officerId;

    public Customers(){}
    
    public boolean isRegister(String newName, String newSurname, String newGender, String newHomeAddress, String newPhoneNumber, double newBalance, String newOfficerId){
        
        boolean isRegOk = false;
        try(
                Connection con = Database.getMyConnection();
                PreparedStatement prs = con.prepareStatement("insert into CustomersAcct (vCusName, vCusSurname, cSex, vAddress, cPhoneNo, mBal, staffid) values (?, ?, ?, ?, ?, ?, ?)");
            )
        {
            prs.setString(1, newName);
            prs.setString(2, newSurname);
            prs.setString(3, newGender);
            prs.setString(4, newHomeAddress);
            prs.setString(5, newPhoneNumber);
            prs.setDouble(6, newBalance);
            prs.setString(7, newOfficerId);
            
            int rowsAffected =prs.executeUpdate();
            if(rowsAffected>0){
                isRegOk = true;
            }
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());  
        }
        return isRegOk;
    }
    
    public void checkAccountBal(int newAccNo){
        try(
                Connection con = Database.getMyConnection();
                PreparedStatement prs = con.prepareStatement("Select * from customersAcct where iAcNo = ?");
            )
        {
            prs.setInt(1, newAccNo);
            ResultSet resultSet = prs.executeQuery();
            resultSet.next();
            
            setAccountNo(resultSet.getInt("iacno"));
            setBalance(resultSet.getDouble("mbal"));
            setName(resultSet.getString("vcusname"));
            setSurname(resultSet.getString("vcussurname"));
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    /**
     * @return the accountNo
     */
    public int getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo the accountNo to set
     */
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the homeAddress
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * @param homeAddress the homeAddress to set
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the officerId
     */
    public String getOfficerId() {
        return officerId;
    }

    /**
     * @param officerId the officerId to set
     */
    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }
    
}
