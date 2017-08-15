package abcbankpack.database;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Database {
    
    private static Connection connect;
 
    public static Connection getMyConnection(){
        
        try
        {
             File file = new File("ConnectionString.properties");
            String pathFile = file.getPath();
            Properties fileName = new Properties();
            fileName.load(new FileInputStream(pathFile));
            
            connect = DriverManager.getConnection(
                    //"jdbc:sqlserver://localhost:1433;DatabaseName=ABC","sa","sa"
                    fileName.getProperty("conString"),fileName.getProperty("username"),fileName.getProperty("password")
                    );
             //connect = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"DatabaseName=ABC;user=sa;password=sa");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return connect;
    }
}
