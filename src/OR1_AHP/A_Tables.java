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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author power
 */
public class A_Tables extends JFrame {
    
     int C_number , A_number , A_change;
    String C_names[] , A_names[];
    
     double G_array[] ;
     double [][] PV_Final ;
double [] hmax ;
double [] CI ;
    
    double  A_GeomtricMeanTOTAL ;
      
    JTextField jTextFieldArray[];
    JLabel jLabelArray[];
    
JButton bt2 ;
    
    public A_Tables(){
    
    }
    
    
    public A_Tables(String C_Array[] , String A_Array[] , int A_Number , int C_Number , double [][] PV_Array ,double[]hMax,double[]C_I,  int NA){
        
        ImageIcon icon = new ImageIcon("src/Images/ImageIcon.png");
        this.setIconImage(icon.getImage());
        
        this.C_number = C_Number ;
        this.A_number = A_Number ;
        this.A_change = NA ;
        this.C_names = C_Array ;
        this.A_names = A_Array ;
        this.PV_Final = PV_Array ;
        this.hmax = hMax ;
        this.CI = C_I ;
             
        A_GeomtricMeanTOTAL = 0 ;
        
        
//        for (int i = 0; i < PV_Final.length; i++) {
//            
//            for (int j = 0; j < PV_Final[i].length; j++) {
//            
//                System.out.println(PV_Final[i][j]);
//            }
//        }
        
         getContentPane().setBackground(new Color(0,204,0));
         
         Font f = new Font("Tahoma", Font.ITALIC , 17);
        
         jTextFieldArray = new JTextField[A_Number*A_Number];
        jLabelArray = new JLabel[A_Number];
        
        G_array = new double [A_Number];
//        PV_Final = new double [A_Number+1][C_Array.length];

        
                     setLayout(new BorderLayout(3,3));

        Font flb = new Font("Arial", Font.BOLD , 16);
                     
             JPanel np1 = new JPanel();
              JPanel np2 = new JPanel();
              JPanel np3 = new JPanel();
               JPanel npadd = new JPanel();
               
               
              np1.setBackground(new Color(0,45,126));
               np2.setBackground(new Color(0,45,126));
                np3.setBackground(new Color(0,45,126));

             np1.setLayout(new GridLayout(1,A_Number+1));
        
        JLabel b = new JLabel(""+C_names[A_change]);
        
        b.setFont(new Font("Yu Gothic", Font.BOLD, 17));
        b.setForeground(new Color(51,102,255));
        
        np1.add(b);
        
        
        for (int i = 0; i < jLabelArray.length; i++) {
            
            jLabelArray[i] = new JLabel(""+A_Array[i]);
            
            jLabelArray[i].setForeground(new Color(0,153,153));
            jLabelArray[i].setFont(flb);
            
           np1.add(jLabelArray[i]);
        }
             
        
        
        np2.setLayout(new GridLayout(A_Number,1));
        
        for (int i = 0; i < jLabelArray.length; i++) {
            
            jLabelArray[i] = new JLabel(""+A_Array[i]);
            
            jLabelArray[i].setForeground(new Color(0,153,153));
            jLabelArray[i].setFont(flb);
            
           np2.add(jLabelArray[i]);
        }
        
        
        
        
         np3.setLayout(new GridLayout(A_Number,A_Number));
        
         int c = 0 ;
        int n = 0 ;
        int z =A_Number;
       for (int i = 0; i < jTextFieldArray.length; i++) {
         jTextFieldArray[i] = new JTextField(10);
         jTextFieldArray[i].setFont(new Font("Tahoma", Font.PLAIN, 18));
            jTextFieldArray[i].setHorizontalAlignment((int) CENTER_ALIGNMENT);
            
            if(c == 0 || c == A_Number+1){
                
                jTextFieldArray[i].setText("1");
                jTextFieldArray[i].setBackground(new Color(153, 153, 153));
                jTextFieldArray[i].setEditable(false);
                n = i+1;
                             np3.add(jTextFieldArray[i]);
                             
                             if(c == A_Number+1){
                                 c =0 ;
                             z+=A_Number;
                             }
                             

            }else
                  {
                      
                      if(n<jTextFieldArray.length && n < z){
                     action(n);
                             np3.add(jTextFieldArray[i]);
                             
                             n++;
                             
                      }else{
                          
                         np3.add(jTextFieldArray[i]);
                         n=0;
                      }
            }
            
            c++ ;
            
            
       }
       
       
       int v = A_Number+1 ;
        for (int i = A_Number ; i < jTextFieldArray.length; i+=A_Number) {

            for (int j = i ; j < v ; j++) {

                 jTextFieldArray[j].setBackground(new Color(153, 153, 153));

                jTextFieldArray[j].setEditable(false);
            }
            v+=A_Number+1;
        }
      
        
         npadd.setLayout(new BorderLayout(5,5));
        
        npadd.add(np1 , BorderLayout.NORTH);
        
        npadd.add(np2 , BorderLayout.WEST);
        
        npadd.add(np3 , BorderLayout.CENTER);
        
        
        JScrollPane scroll = new JScrollPane(npadd);
                     scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll , BorderLayout.CENTER);
        
        
        
         bt2 = new JButton("NEXT");
        
        bt2.setFont(f);
        
        bt2.setBackground(new Color(153,204,0));
       
       bt2.setForeground(new Color(153,0,0));
       
        add(bt2 , BorderLayout.SOUTH);
        
        
        readnumbers();
        
    }
    
    
    
        public void readnumbers(){
            
            
             bt2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                
                int c =0 ;
                                             double sumcol=0 ;

                             double n = 1.0 ;
                          String[] parts = new String[2];

                             try{
                             
                             for (int i = 0; i < jTextFieldArray.length; i+=A_number) {
                                 
                                 for (int j = i ; j < A_number+i; j++) {
                                     
//                                     n *= Double.parseDouble(jTextFieldArray[j].getText());

 String string = jTextFieldArray[j].getText();
                     if (string.contains("/")) {
                     parts = string.split("/");
double part1 = Integer.parseInt(parts[0]); 
double part2 = Integer.parseInt(parts[1]); 

                                     n *= part1/part2;

                     
//                                     n *= Double.parseDouble(jTextFieldArray[j].getText());
                                     
                                 }else{
                         
                         
                         n *= Double.parseDouble(string);
                         
                         
                     }
                                     
                                 }
                                 
              G_array[c]= Math.pow(n , 1.0/A_number);
              
              A_GeomtricMeanTOTAL += G_array[c];
              
              n = 1.0 ;
              
              c++ ;
                             }
                             
                      
                             for (int i = 0; i < A_number; i++) {
                                 
                  PV_Final[i+1][A_change] =  G_array[i] / A_GeomtricMeanTOTAL ;
                  
//                                 System.out.println( PV_Final[i+1][A_change]);
                  
                             }
          
                             
                 //Add

                                 for (int j = 0 ; j < A_number; j++) {

                             for (int i = 0; i < jTextFieldArray.length; i+=A_number) {
                                 
                                 
//                           sumcol += Double.parseDouble(jTextFieldArray[i+j].getText());
                                 
                                 String string = jTextFieldArray[i+j].getText();
                     if (string.contains("/")) {
                     parts = string.split("/");
double part1 = Integer.parseInt(parts[0]); 
double part2 = Integer.parseInt(parts[1]); 

                        sumcol += part1/part2 ;         
                     }else{
                     
                sumcol += Double.parseDouble(string);

                     }
                                 
                             }
                             
                             hmax[A_change+1]+=sumcol*PV_Final[j+1][A_change];
                             sumcol = 0 ;

                                 }
                                 
                       CI[A_change+1] = (hmax[A_change+1]-A_number)/(A_number-1);
//Add
                             
                             
                             
//                JOptionPane.showMessageDialog(null, "The priority Vector : "+
//                   PV_array[0]+"$"+PV_array[1]+"$"+PV_array[2]  );
                
                
                
                        

                
                

          
        
                CreateFrame(C_number , A_change);
                
           
                             }catch(Exception ec){
                             
        JOptionPane.showMessageDialog(null,"Please ?! Enter Numbers in the TextFields");

                             
                             }
            }
        });
    
            
            
             
        bt2.addKeyListener(new KeyListener() {
                 @Override
                 public void keyTyped(KeyEvent e) {
                 }

                 @Override
                 public void keyPressed(KeyEvent e) {
                     
                                  if(e.getKeyCode() == KeyEvent.VK_ENTER){
                                      
                                      int c =0 ;
                                             double sumcol=0 ;

                             double n = 1.0 ;
                                                          String[] parts = new String[2];

                             try{
                             
                             for (int i = 0; i < jTextFieldArray.length; i+=A_number) {
                                 
                                 for (int j = i ; j < A_number+i; j++) {
                                     
                                     
//                                     n *= Double.parseDouble(jTextFieldArray[j].getText());

 String string = jTextFieldArray[j].getText();
                     if (string.contains("/")) {
                     parts = string.split("/");
double part1 = Integer.parseInt(parts[0]); 
double part2 = Integer.parseInt(parts[1]); 

                                     n *= part1/part2;

                     
//                                     n *= Double.parseDouble(jTextFieldArray[j].getText());
                                     
                                 }else{
                         
                         
                         n *= Double.parseDouble(string);
                         
                         
                     }
                                     
                                 }
                                 
              G_array[c]= Math.pow(n , 1.0/A_number);
              
              A_GeomtricMeanTOTAL += G_array[c];
              
              n = 1.0 ;
              
              c++ ;
                             }
                             
                      
                             for (int i = 0; i < A_number; i++) {
                                 
                  PV_Final[i+1][A_change] =  G_array[i] / A_GeomtricMeanTOTAL ;
                  
//                                 System.out.println( PV_Final[i+1][A_change]);
                  
                             }
          
                             
                 //Add

                                 for (int j = 0 ; j < A_number; j++) {

                             for (int i = 0; i < jTextFieldArray.length; i+=A_number) {
                                 
                                 
//                           sumcol += Double.parseDouble(jTextFieldArray[i+j].getText());
                                 String string = jTextFieldArray[i+j].getText();
                     if (string.contains("/")) {
                     parts = string.split("/");
double part1 = Integer.parseInt(parts[0]); 
double part2 = Integer.parseInt(parts[1]); 

                        sumcol += part1/part2 ;         
                     }else{
                     
                sumcol += Double.parseDouble(string);

                     }
                                 
                                 
                             }
                             
                             hmax[A_change+1]+=sumcol*PV_Final[j+1][A_change];
                             sumcol = 0 ;

                                 }
                                 
                       CI[A_change+1] = (hmax[A_change+1]-A_number)/(A_number-1);
//Add
                             
                             
                             
//                JOptionPane.showMessageDialog(null, "The priority Vector : "+
//                   PV_array[0]+"$"+PV_array[1]+"$"+PV_array[2]  );
                
                
                
                        

                
                

          
        
                CreateFrame(C_number , A_change);
                
           
                             }catch(Exception ec){
                             
        JOptionPane.showMessageDialog(null,"Please ?! Enter Numbers in the TextFields");

                             
                             } 
                                      
                                  }
                 }

                 @Override
                 public void keyReleased(KeyEvent e) {
                 }
             });
            
        }
        
        
        
        
        
    public void CreateFrame(int Nframe , int na){
    
    if(Nframe >= 1){
        setVisible(false);
     A_Tables frame4 = new A_Tables( C_names , A_names , A_number , Nframe-1 , PV_Final ,hmax,CI, na+1);
        frame4.setTitle("Alternative Table "+(na+2));
        frame4.setSize(800, 400);
                        frame4.setResizable(false);
        frame4.setLocationRelativeTo(null);
        frame4.setVisible(true);
    
    }else{
        
//  ERROR      for (int i = 0; i < PV_Final.length; i++) {
//            
//            for (int j = 0; j < PV_Final[i].length; j++) {
//            
//                System.out.println(PV_Final[i][j]);
//            }
//        }

        setVisible(false);
    SolutionResult frame5 = new SolutionResult(C_names , A_names ,PV_Final ,hmax ,CI );
        frame5.setTitle("The Result");
        frame5.setSize(530, 650);
                        frame5.setResizable(false);
        frame5.setLocationRelativeTo(null);
        frame5.setVisible(true);
    
    
    
    }
    
    }
   
    
    
     public void action(int n){
    
    
     jTextFieldArray[n].getDocument().addDocumentListener(new DocumentListener() {
         @Override
         public void insertUpdate(DocumentEvent e) {
                          warn();
         }

         @Override
         public void removeUpdate(DocumentEvent e) {
                          warn();

         }

         @Override
         public void changedUpdate(DocumentEvent e) {
                          warn();
         }
         
         public void warn(){
         
             try{
                 
                 String[] parts = new String[2];

                 
             int index = (n*A_number)%(jTextFieldArray.length-1) ;
                              
//                     float x = Float.parseFloat(jTextFieldArray[n].getText()) ;
//                     
//
//                        jTextFieldArray[index].setText(""+1.0/x); 

 String string = jTextFieldArray[n].getText();
                     if (string.contains("/")) {
                     parts = string.split("/");
double part1 = Integer.parseInt(parts[0]); 
double part2 = Integer.parseInt(parts[1]); 


                     jTextFieldArray[index].setText(""+(int)part2+"/"+(int)part1); 
                     } else {

                                          jTextFieldArray[index].setText("1/"+string); 

                         
                     }

                       
             }catch(Exception e){
                          
             }

         }
                 
     });
    
     
    
    
    }
   
}
