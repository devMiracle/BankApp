package abcbankpack.model;

import java.awt.Image;
import javax.swing.ImageIcon;

public class MyIconImage {
    
    
    
    public MyIconImage(){}
    
    public Image getIconImage()
    {
      ImageIcon logoimage2 = new ImageIcon(getClass().getResource("/abcbankpack/imgFol/zt.gif"));
      Image im = logoimage2.getImage();
      return im;
    }
}
