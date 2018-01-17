/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OR1_AHP;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author power
 */
public class SolutionResult extends JFrame {
    
    double [][] PV_values ;
     double [] solve;
     double [] hmax ;
     double [] CI ;
     
     int IDname;
     double number ;
     
     double max;
   
     public SolutionResult(){
     
     }
     
     
    
    public SolutionResult(String Cnames [] , String Anames [] , double [][] PV_Array , double[] hMax, double[]C_I){
        
        ImageIcon icon = new ImageIcon("src/Images/ImageIcon.png");
        this.setIconImage(icon.getImage());
        
        getContentPane().setBackground(new Color(153,153,153));
        
        setLayout(new GridLayout(1 , 1));
        
        
    this.PV_values = PV_Array ;
    this.hmax = hMax ;
    this.CI = C_I ;
          String [] text = new String[Anames.length+2];

//    PV_values = new double[Anames.length+1][Cnames.length];
    
    
     solve = new double[Anames.length] ;
    
     number = 0 ;
     max = 0 ;
     IDname = 0 ;
    
     DecimalFormat numberFormat = new DecimalFormat("#0.0000");
     
                 text[0] = "\n \t               - Criteria Table - \n"+"\nPriority Vector :- ";
                 for(int p = 0 ; p < Cnames.length;p++){
                 
                     text[0] +=" "+numberFormat.format(PV_values[0][p])+" - "; 
                 }
                 
                    text[0] += "\n - hmax  =  "+numberFormat.format(hmax[0])
                         +"\n  - C.I   =  "+numberFormat.format(CI[0]);
                 
                 JTextArea textarea = new JTextArea(text[0], 3*text.length, 20);
             JScrollPane scroll = new JScrollPane(textarea);
              scroll.getVerticalScrollBar().setUnitIncrement(14);
             textarea.setEditable(false);
             textarea.setFont(new Font("Serif", Font.ITALIC, 18));
textarea.setLineWrap(true);
textarea.setWrapStyleWord(true);

                 int k ;
        for ( k = 1; k < text.length-1; k++) {

            System.out.println(hmax[k]+" - "+CI[k]); 
            
            text[k] = "\n\n \t        - Alternative Table "+k+"("+Cnames[k-1]+")- \n"+"\nPriority Vector :- ";
            for(int p = 0 ; p < Anames.length;p++){
                 
                     text[k] +=" "+numberFormat.format(PV_values[k][p])+" - "; 
                 }
            
                     text[k] += "\n  - hmax  =  "+numberFormat.format(hmax[k])
                         +"\n  - C.I   =  "+numberFormat.format(CI[k]);
        textarea.setText(textarea.getText() + text[k]);
        
        }
     
     
     
    
        for (int i = 0; i < PV_values.length-1; i++) {
            
            for (int j = 0; j < PV_values[i].length; j++) {

                number += PV_values[i*0][j] * PV_values[i+1][j];
                
                
                
            }
            
            solve[i] = number ;
            
            if(number > max){
            
            max = number ;
            IDname = i ;
            
            }
            
            number = 0 ;
        }
        
        text[k] = "\n\n \t               - Finish Solution - \n"
                         +"\n* The Best is ( "+Anames[IDname]+" )"
                         +"\n* the value : "+numberFormat.format(max);
                       textarea.setText(textarea.getText() + text[k]);


//        for (int i = 0; i < text.length; i++) {
//            
//             JTextArea textarea = new JTextArea(text[i], 3*text.length, 20);
//             JScrollPane scroll = new JScrollPane(textarea);
//                                  scroll.getVerticalScrollBar().setUnitIncrement(14);
//             textarea.setEditable(false);
//             textarea.setFont(new Font("Serif", Font.ITALIC, 18));
//textarea.setLineWrap(true);
//textarea.setWrapStyleWord(true);
//
add(scroll);
//        }
       
    }
}
