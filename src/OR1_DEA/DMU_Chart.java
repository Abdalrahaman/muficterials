/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OR1_DEA;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author dell
 */
public class DMU_Chart extends JFrame{
    
    
    double [][] EFFPoints ;
    
    public DMU_Chart(){
    
    
    }
    
    
    public DMU_Chart(double [][] Points){
        
        ImageIcon icon = new ImageIcon("src/Images/ImageIcon.png");
        this.setIconImage(icon.getImage());
    
        EFFPoints = Points ;
        
    
    }
    
    
    
    public void paint(Graphics g) {
    
            super.paint(g);

            int c =0 ;
        
        for (int i = 1 ; i <= 20 ; i++) {              //  num الصادى
         
                    g.drawString(""+i , 180 , 670-c );
                    
                    c+=30 ;
        }
        
        
        c =0 ;
        
        for (int i = 1 ; i <= 20 ; i++) {
         
                    g.drawString(""+i , 230+c, 720 );
                    
                    c+=30 ;
        }
            
             g.drawLine(200, 100, 200 , 700 ); //    الصادى  
            
                g.drawLine(200, 700, 800, 700);   //                    السينى

    
    }
}
