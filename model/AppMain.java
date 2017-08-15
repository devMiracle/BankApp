package abcbankpack.model;

import abcbankpack.view.Home;
import javax.swing.UIManager;

public class AppMain {
    
    public static void main(String args[]){
        
        try
        {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());   
        }
        catch(Exception e)
        {
            System.out.println("Error In Setting WLAF "+e);
        }
    
        Home frame = new Home();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
       
    }
    
}
