/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OR1_AHP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author dell
 */
public class Names extends JPanel{
    
    
     public String n_c_array[];
            public String n_A_array[];
            
            JTextField jtextfield_C_Names[];
            JTextField jtextfield_A_Names[];
            
            JLabel lb1;
            JLabel lb2;
            
            JButton b1;
            
            int Number1 ;
            int Number2 ;
            
            public Names(){
            
                
            }

    
    public Names( int number1 , int number2){
      
        
        setBackground(new Color(0,45,126));
        
        this.Number1 = number1;
        this.Number2 = number2 ;
                          
     n_c_array = new String [number1];
     n_A_array = new String [number2];
     
      
    jtextfield_C_Names = new JTextField[number1];
        jtextfield_A_Names = new JTextField[number2];
 
     JPanel np1 = new JPanel();
//     JPanel np2 = new JPanel();
     
    setLayout(new BorderLayout(5,5));
    
    np1.setLayout(new GridLayout(number1+number2+2,1));
    
    np1.setBackground(new Color(0,45,126));
    
//    np2.setLayout(new GridLayout(number2+1,1));
//    
//    np2.setBackground(new Color(0,45,126));
    
    
    Font f = new Font("Tahoma", Font.ITALIC , 20);
    
     lb1 = new JLabel("Enter the criteria name");
    
    lb1.setFont(f);
    
    lb1.setForeground(new Color(0,153,153));
    
     lb2 = new JLabel("Enter the Alternative name");
    
        lb2.setFont(f);
        
        lb2.setForeground(new Color(0,153,153));

    
    np1.add(lb1);
    
    
            for (int i = 0; i < jtextfield_C_Names.length; i++) {
            
                jtextfield_C_Names[i] = new JTextField(10);
                jtextfield_C_Names[i].setFont(new Font("Tahoma", Font.PLAIN, 18));
                np1.add(jtextfield_C_Names[i]);
                
        }
    
//        add(np1 , BorderLayout.NORTH);

    
        np1.add(lb2);
        
        
            for (int i = 0; i < jtextfield_A_Names.length; i++) {
            
                jtextfield_A_Names[i] = new JTextField(10);
             jtextfield_A_Names[i].setFont(new Font("Tahoma", Font.PLAIN, 18));
                np1.add(jtextfield_A_Names[i]);
                
        }
            
            JScrollPane scroll = new JScrollPane(np1);
             scroll.getVerticalScrollBar().setUnitIncrement(16);
            add(scroll , BorderLayout.CENTER); 
   
        
        b1 = new JButton("OK");
       
       b1.setSize(120, 70);
       
       b1.setFont(f);
       
       b1.setBackground(new Color(0,103,73));
       
       b1.setForeground(new Color(153,0,0));
       
       add(b1 , BorderLayout.SOUTH);
       

        ReadNames();
      

    }

    

   
    
    public void ReadNames(){
    
    
     b1.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            try{
            
            for (int i = 0; i < jtextfield_C_Names.length; i++) {
               
                n_c_array[i] = jtextfield_C_Names[i].getText();
                
            }
            
           
            for (int i = 0; i < jtextfield_A_Names.length; i++) {
               
                n_A_array[i] = jtextfield_A_Names[i].getText();
                
            }
            
       
            
            Table1 frame3 = new Table1(Number1 , n_c_array , Number2 , n_A_array);
        frame3.setTitle("Criteria Table");
        frame3.setSize(800, 400);
        frame3.setResizable(false);
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(true);
        
            }catch(Exception ec){
            
              JOptionPane.showMessageDialog(null,"Please ?! String Inputs !!");

            
            }
            
        }
    });
        
        
    
     b1.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
         }

         @Override
         public void keyPressed(KeyEvent e) {

             if(e.getKeyCode() == KeyEvent.VK_ENTER){
                 
                  try{
            
            for (int i = 0; i < jtextfield_C_Names.length; i++) {
               
                n_c_array[i] = jtextfield_C_Names[i].getText();
                
            }
            
           
            for (int i = 0; i < jtextfield_A_Names.length; i++) {
               
                n_A_array[i] = jtextfield_A_Names[i].getText();
                
            }
            
       
            
            Table1 frame3 = new Table1(Number1 , n_c_array , Number2 , n_A_array);
        frame3.setTitle("Criteria Table");
        frame3.setSize(800, 400);
        frame3.setResizable(false);
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(true);
        
            }catch(Exception ec){
            
              JOptionPane.showMessageDialog(null,"Please ?! String Inputs !!");

            
            }
            
                 
             }

         }

         @Override
         public void keyReleased(KeyEvent e) {
         }
     });
     
    
     
     jtextfield_A_Names[jtextfield_A_Names.length-1].addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
         }

         @Override
         public void keyPressed(KeyEvent e) {
             
                          if(e.getKeyCode() == KeyEvent.VK_ENTER){

             
             try{
            
            for (int i = 0; i < jtextfield_C_Names.length; i++) {
               
                n_c_array[i] = jtextfield_C_Names[i].getText();
                
            }
            
           
            for (int i = 0; i < jtextfield_A_Names.length; i++) {
               
                n_A_array[i] = jtextfield_A_Names[i].getText();
                
            }
            
       
            
            Table1 frame3 = new Table1(Number1 , n_c_array , Number2 , n_A_array);
        frame3.setTitle("Criteria Table");
        frame3.setSize(800, 400);
        frame3.setResizable(false);
        frame3.setLocationRelativeTo(null);
        frame3.setVisible(true);
        
            }catch(Exception ec){
            
              JOptionPane.showMessageDialog(null,"Please ?! String Inputs !!");

            
            }
             
                          }
             
         }

         @Override
         public void keyReleased(KeyEvent e) {
         }
     });
    }

    
    
    
}
