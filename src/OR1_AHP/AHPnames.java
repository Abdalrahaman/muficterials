/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OR1_AHP;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author power
 */
public class AHPnames extends JFrame {
    
    
            public String n_c_array[];
            public String n_A_array[];
            
            JTextField jtextfield_C_Names[];
            JTextField jtextfield_A_Names[];
            
            JLabel lb1;
            JLabel lb2;
            
            public AHPnames(){
            
                
            }

    
    public AHPnames(final int number1 ,final int number2){
        
        getContentPane().setBackground(new Color(0,204,0));
                          
     n_c_array = new String [number1];
     n_A_array = new String [number2];
     
      
    jtextfield_C_Names = new JTextField[number1];
        jtextfield_A_Names = new JTextField[number2];
 
     JPanel np1 = new JPanel();
     JPanel np2 = new JPanel();
     
    setLayout(new FlowLayout(FlowLayout.CENTER , 10 , 20));
    
    np1.setLayout(new GridLayout(number1,1));
    
    np1.setBackground(new Color(0,204,0));
    
    np2.setLayout(new GridLayout(number2,1));
    
    np2.setBackground(new Color(0,204,0));
    
    
    Font f = new Font("Tahoma", Font.ITALIC , 16);
    
     lb1 = new JLabel("Enter the criteria name");
    
    lb1.setFont(f);
    
    lb1.setForeground(new Color(255,255,0));
    
     lb2 = new JLabel("Enter the Alternative name");
    
        lb2.setFont(f);
        
        lb2.setForeground(new Color(255,255,0));

    
    add(lb1);
    
    
            for (int i = 0; i < jtextfield_C_Names.length; i++) {
            
                jtextfield_C_Names[i] = new JTextField(10);
                
                np1.add(jtextfield_C_Names[i]);
                
        }
    
        add(np1);

    
        add(lb2);
        
        
            for (int i = 0; i < jtextfield_A_Names.length; i++) {
            
                jtextfield_A_Names[i] = new JTextField(10);
                
                np2.add(jtextfield_A_Names[i]);
                
        }
            
            add(np2); 
   
        
       JButton b1 = new JButton("OK");
       
       b1.setSize(120, 70);
       
       b1.setFont(f);
       
       b1.setBackground(new Color(153,204,0));
       
       b1.setForeground(new Color(153,0,0));
       
       add(b1);
       
       b1.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
            for (int i = 0; i < jtextfield_C_Names.length; i++) {
               
                n_c_array[i] = jtextfield_C_Names[i].getText();
                
            }
            
           
            for (int i = 0; i < jtextfield_A_Names.length; i++) {
               
                n_A_array[i] = jtextfield_A_Names[i].getText();
                
            }
            
       
            
            Table1 frame3 = new Table1(number1 , n_c_array , number2 , n_A_array);
        frame3.setTitle("Table1");
        frame3.setSize(500, 300);
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(true);
        dispose();
            
        }
    });
        
        

    }

    

   
    
    

    
     
}
