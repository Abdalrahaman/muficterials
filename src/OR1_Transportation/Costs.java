/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OR1_Transportation;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author power
 */
public class Costs extends JFrame{
    
    int S_Number , D_Number ;
    String TheMethod ;
    
    int S_Array[] , D_Array[];
    double Cost_Array[][];
   
    
    
    JTextField jtextfield_Costs[];
    
                JLabel Names[];
                
                JPanel pn1 ;
                JPanel pn2 ;
                JPanel pnadd ;
                
                JButton bt1 ;
    
    public Costs(){
        
    }
 
    
    
    public Costs(int Snumber , int Dnumber , String method){
        
        ImageIcon icon = new ImageIcon("src/Images/ImageIcon.png");
        this.setIconImage(icon.getImage());
        
        this.S_Number = Snumber ;
        this.D_Number = Dnumber ;
        this.TheMethod = method ;
        
        S_Array = new int [Snumber];
         D_Array = new int [Dnumber];
         Cost_Array = new double[Snumber+1][Dnumber+1];   // Change
        
        jtextfield_Costs = new JTextField[Snumber*Dnumber];
        Names = new JLabel[Snumber*Dnumber];
        
        
        setLayout(new BorderLayout(3,3));
        
         pn1 = new JPanel();
         pn2 = new JPanel();
         pnadd = new JPanel();
         
         pn1.setBackground(new Color(51,71,91));
                 pn2.setBackground(new Color(51,71,91));

        pn1.setLayout(new GridLayout(Snumber*Dnumber,1));
        pn2.setLayout(new GridLayout(Snumber*Dnumber,1));
        pnadd.setLayout(new BorderLayout(5,5));
        
        labels_name();
        
        JScrollPane scroll = new JScrollPane(pnadd);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        pnadd.add(pn1 , BorderLayout.CENTER);
        pnadd.add(pn2 , BorderLayout.EAST);
        add(scroll , BorderLayout.CENTER);
        
         bt1 = new JButton("Next");
        bt1.setFont(new Font("Arial", Font.BOLD, 18));
        bt1.setBackground(new Color(0,115,133));
        bt1.setForeground(new Color(0,102,102));
         add(bt1 , BorderLayout.SOUTH);
        
        ReadCosts();
        
    }
    
    
    public void ReadCosts(){
    
    
     bt1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                int n1 = 0 ;
                
                
                 try{   
                
                for (int i = 0; i < S_Array.length; i++) {
                    
                for (int j = 0; j < D_Array.length; j++) {
                    
           Cost_Array[i][j] = Double.parseDouble(jtextfield_Costs[n1].getText());
           
           n1++ ;
                   
                }
                
                
                }
                
                if("North West".equals(TheMethod)){
                
             NorthWest f3 = new NorthWest( S_Number ,  D_Number , Cost_Array);
                f3.setTitle("NorthWest");
                f3.setSize(910,500);
                f3.setResizable(false);
                f3.setLocationRelativeTo(null);
                f3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                f3.setVisible(true);
                
                
                }else
                    if("Vogal".equals(TheMethod)){

            Vogal f3 = new Vogal( S_Number ,  D_Number , Cost_Array);
                f3.setTitle("Vogal");
                f3.setSize(910,500);
                f3.setResizable(false);
                f3.setLocationRelativeTo(null);
                f3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                f3.setVisible(true);
               
                
                    }else{
                    
                    MinTable f3 = new MinTable( S_Number ,  D_Number , Cost_Array);
                f3.setTitle("MinTable");
                f3.setSize(910,500);
                f3.setResizable(false);
                f3.setLocationRelativeTo(null);
                f3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                f3.setVisible(true);
                    
                     
                    }
                
                dispose();
                
                 }catch(Exception ec){
                 
                 JOptionPane.showMessageDialog(null,"Please ?! Enter numbers in the TextFields");

                 }
            }
        });
        
        
    bt1.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
         }

         @Override
         public void keyPressed(KeyEvent e) {

             if(e.getKeyCode() == KeyEvent.VK_ENTER){
                 
                  int n1 = 0 ;
                
                
                 try{   
                
                for (int i = 0; i < S_Array.length; i++) {
                    
                for (int j = 0; j < D_Array.length; j++) {
                    
           Cost_Array[i][j] = Double.parseDouble(jtextfield_Costs[n1].getText());
           
           n1++ ;
                   
                }
                
                
                }
                
                if("North West".equals(TheMethod)){
                
             NorthWest f3 = new NorthWest( S_Number ,  D_Number , Cost_Array);
                f3.setTitle("NorthWest");
                f3.setSize(910,500);
                f3.setResizable(false);
                f3.setLocationRelativeTo(null);
                f3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                f3.setVisible(true);
                
                
                }else
                    if("Vogal".equals(TheMethod)){

            Vogal f3 = new Vogal( S_Number ,  D_Number , Cost_Array);
                f3.setTitle("Vogal");
                f3.setSize(910,500);
                f3.setResizable(false);
                f3.setLocationRelativeTo(null);
                f3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                f3.setVisible(true);
               
                
                    }else{
                    
                    MinTable f3 = new MinTable( S_Number ,  D_Number , Cost_Array);
                f3.setTitle("MinTable");
                f3.setSize(910,500);
                f3.setResizable(false);
                f3.setLocationRelativeTo(null);
                f3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                f3.setVisible(true);
                    
                     
                    }
                
                dispose();
                
                 }catch(Exception ec){
                 
                 JOptionPane.showMessageDialog(null,"Please ?! Enter numbers in the TextFields");

                 }
                 
             }

         }

         @Override
         public void keyReleased(KeyEvent e) {
         }
     });
    
    }
    
    
   public void labels_name(){
       
      int n2 = 0 ;
   
      for(int i=0 ; i < S_Array.length ; i++){
       for (int j = 0; j < D_Array.length; j++) {
                
           Names[n2] = new JLabel("Cost : Sourse "+(i+1)+",Demond "+(j+1)+" : ");
           Names[n2].setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
           Names[n2].setForeground(new Color(255,255,255));
           pn1.add(Names[n2]);
           
       }
   }
      
       for (int i = 0 ; i < jtextfield_Costs.length ; i++) {

           jtextfield_Costs[i] = new JTextField(10);
           jtextfield_Costs[i].setFont(new Font("Tahoma", Font.PLAIN, 18));
            jtextfield_Costs[i].setHorizontalAlignment((int) CENTER_ALIGNMENT);
           pn2.add(jtextfield_Costs[i]);
           
       }
       
   }
    
    
}
