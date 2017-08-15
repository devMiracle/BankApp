package abcbankpack.model;

import abcbankpack.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction {
    private int transId;
    private int accountNo;
    private String transType;
    private double amount;
    private String amtInWords;
    
    public Transaction(){}
    
    public boolean doTransaction(int newAcctNo, String newTransType, double newAmt, String newAmtInWord){
        boolean isDoTrans = false;
        try(
                Connection con = Database.getMyConnection();
                PreparedStatement prs = con.prepareStatement("insert into transactions(Accno,transtype,amount,amtinwords) values(?,?,?,?)");
            )
        {
           prs.setInt(1, newAcctNo);
           prs.setString(2, newTransType);
           prs.setDouble(3, newAmt);
           prs.setString(4, newAmtInWord);
           
           int rowAffected = prs.executeUpdate();
           
           if(rowAffected>0){
               isDoTrans = true;
           }
            
        }
        catch(SQLException sqle){
            sqle.getMessage();
        }
        return isDoTrans;
    }

    /**
     * @return the transId
     */
    public int getTransId() {
        return transId;
    }

    /**
     * @param transId the transId to set
     */
    public void setTransId(int transId) {
        this.transId = transId;
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
     * @return the transType
     */
    public String getTransType() {
        return transType;
    }

    /**
     * @param transType the transType to set
     */
    public void setTransType(String transType) {
        this.transType = transType;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the amtInWords
     */
    public String getAmtInWords() {
        return amtInWords;
    }

    /**
     * @param amtInWords the amtInWords to set
     */
    public void setAmtInWords(String amtInWords) {
        this.amtInWords = amtInWords;
    }
    
}
