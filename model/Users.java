package abcbankpack.model;

import abcbankpack.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Users {
    private String userId;
    private String username;
    private String password;
  
    public Users(){
        
    }
    
    public boolean isLoginOk(String newUsername,String newPassword){
        boolean loginOk = false;
        try(
              Connection connect = Database.getMyConnection();
              PreparedStatement prs = connect.prepareStatement("select * from Accountusers where cAu =001");
            )
         {
                
                ResultSet resultSet = prs.executeQuery();
                resultSet.next();
                setUsername(resultSet.getString("cusername"));
                setPassword(resultSet.getString("cpassword"));
                
                    
                if((newUsername.equalsIgnoreCase(getUsername().trim())) && newPassword.equals(getPassword().trim()))
                {
                  loginOk = true;
                }
         }
         catch(Exception e){
           System.out.println(e.getMessage()); 
        }
        return loginOk;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
