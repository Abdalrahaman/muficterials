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
import java.awt.event.KeyAdapter;
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
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

/**
 *
 * @author power
 */
public class Table1 extends JFrame{
    
    int C_number , A_number  , num ;
    double [] hmax ;
    double [] CI;
    private int NA_frame ;
    
    String C_names[] , A_names[];
    
     double GM_array[];
     double PV_array[][];
    double  C_GeomtricMeanTOTAL ;
      
    JTextField jTextFieldArray[];
    JLabel jLabelArray[];
    
    JButton bt1;
    public Table1(){
                num = 0 ;
                 
    }
    
    public Table1(int C_Number , String arr1[] , int A_Number , String arr2[]){
        
        ImageIcon icon = new ImageIcon("src/Images/ImageIcon.png");
        this.setIconImage(icon.getImage());
        
        this.C_number = C_Number ;
        this.A_number = A_Number ;
        this.C_names = arr1 ;
        this.A_names = arr2 ;
        num = 0 ;
        CI = new double[C_Number+1] ;
        hmax = new double[C_Number+1] ;
                 
        jTextFieldArray = new JTextField[C_Number*C_Number];
        jLabelArray = new JLabel[C_Number];
        
        GM_array = new double [C_Number];
        PV_array = new double [A_Number+1][C_Number];
        
                     setLayout(new BorderLayout(3,3));
                     
                     getContentPane().setBackground(new Color(0,204,0));

                     Font f = new Font("Tahoma", Font.ITALIC , 17);
                     Font flb = new Font("Arial", Font.BOLD , 16);

        
             JPanel np1 = new JPanel();
              JPanel np2 = new JPanel();
              JPanel np3 = new JPanel();
                            JPanel npadd = new JPanel();

              
              np1.setBackground(new Color(0,45,126));
               np2.setBackground(new Color(0,45,126));
                np3.setBackground(new Color(0,45,126));

             np1.setLayout(new GridLayout(1,C_Number+1));
        
        JLabel b = new JLabel("Criteria");
        b.setFont(new Font("Yu Gothic", Font.BOLD, 17));
        b.setForeground(new Color(51,102,255));
        
        np1.add(b);
        
        for (int i = 0; i < jLabelArray.length; i++) {
            
            jLabelArray[i] = new JLabel(""+arr1[i]);
            jLabelArray[i].setForeground(new Color(0,153,153));
            jLabelArray[i].setFont(flb);
            
           np1.add(jLabelArray[i]);
        }
             
        
        
        np2.setLayout(new GridLayout(C_Number,1));
        
        for (int i = 0; i < jLabelArray.length; i++) {
            
            jLabelArray[i] = new JLabel(""+arr1[i]);
            jLabelArray[i].setForeground(new Color(0,153,153));
                        jLabelArray[i].setFont(flb);

            
           np2.add(jLabelArray[i]);
        }
        
        

        
         np3.setLayout(new GridLayout(C_Number,C_Number));
        int c = 0 ;
        int n = 0 ;
        int z =C_number;
       for (int i = 0; i < jTextFieldArray.length; i++) {
         jTextFieldArray[i] = new JTextField(10);
         jTextFieldArray[i].setFont(new Font("Tahoma", Font.PLAIN, 18));
            jTextFieldArray[i].setHorizontalAlignment((int) CENTER_ALIGNMENT);
            
            if(c == 0 || c == C_Number+1){
                
                jTextFieldArray[i].setText("1");
                jTextFieldArray[i].setBackground(new Color(153, 153, 153));
                jTextFieldArray[i].setEditable(false);
                n = i+1;
                             np3.add(jTextFieldArray[i]);
                             
                             if(c == C_Number+1){
                                 c =0 ;
                             z+=C_number;
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
       

int v = C_Number+1 ;
        for (int i = C_Number ; i < jTextFieldArray.length; i+=C_Number) {

            for (int j = i ; j < v ; j++) {

                 jTextFieldArray[j].setBackground(new Color(153, 153, 153));

                jTextFieldArray[j].setEditable(false);
            }
            v+=C_Number+1;
        }
       

      
       
        npadd.setLayout(new BorderLayout(5,5));
        
        npadd.add(np1 , BorderLayout.NORTH);
        
        npadd.add(np2 , BorderLayout.WEST);
        
        npadd.add(np3 , BorderLayout.CENTER);
        
        
        JScrollPane scroll = new JScrollPane(npadd);
                     scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll , BorderLayout.CENTER);
        
        
        
        bt1 = new JButton("NEXT");
       
       bt1.setFont(f);
       
       bt1.setBackground(new Color(153,204,0));
       
       bt1.setForeground(new Color(153,0,0));
       
       
        add(bt1 , BorderLayout.SOUTH);
        
        
        
        readnumbers();
        
        
    }
    
    
    public void readnumbers(){
    
    
     bt1.addActionListener(new ActionListener() {

                         @Override
                         public void actionPerformed(ActionEvent e) {
                             
                             int c =0 ;
                             double sumcol=0 ;
                             double n = 1.0 ;
                             String[] parts = new String[2];

                             try{
                             
                                 
                             for (int i = 0; i < jTextFieldArray.length; i+=C_number) {
                                 
                                 for (int j = i ; j < C_number+i; j++) {
                                     
                                      String string = jTextFieldArray[j].getText();
                     if (string.contains("/")) {
                     parts = string.split("/");
double part1 = Integer.parseInt(parts[0]); 
double part2 = Integer.parseInt(parts[1]); 

                                     n *= part1/part2;

                     
//                                     n *= Double.parseDouble(jTextFieldArray[j].getText());
                                     
                                 }else{
                         
                         
                         n *= Double.parseDouble(string);
                         
                         
                     }}
                                 
              GM_array[c]= Math.pow(n , 1.0/C_number);
              
              C_GeomtricMeanTOTAL += GM_array[c];
              
              n = 1.0 ;
              
              c++ ;
                             }
                             
                            
                      
                             for (int i = 0; i < C_number; i++) {
                                 
                  PV_array[0][i] =  GM_array[i] / C_GeomtricMeanTOTAL ;
                  
                  
                             }
                             
                             
                              //Add

                                 for (int j = 0 ; j < C_number; j++) {

                             for (int i = 0; i < jTextFieldArray.length; i+=C_number) {
                                 
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
                             
                             hmax[0]+=sumcol*PV_array[0][j];
                             sumcol = 0 ;

                                 }
                                 
                                 CI[0] = (hmax[0]-C_number)/(C_number-1);
//Add
                             
//                             for (int i = 0; i < PV_array.length; i++) {
//            
//            for (int j = 0; j < PV_array[i].length; j++) {
//            
//                System.out.println(PV_array[i][j]);
//            }
//        }
                    
      
     
                      
//             JOptionPane.showMessageDialog(null, "The priority Vector : "+
//                   PV_array[0][1]+"$"+PV_array[1][1]+"$"+PV_array[2][1]  );


                             
                             setVisible(false);
          A_Tables frame4 = new A_Tables( C_names , A_names , A_number , C_number-1 , PV_array ,hmax ,CI,num);
        frame4.setTitle("Alternative Table 1");
        frame4.setSize(800, 400);
                frame4.setResizable(false);
        frame4.setLocationRelativeTo(null);
        frame4.setVisible(true);
        
                             
                
                             }catch(Exception ec){
                             
                        JOptionPane.showMessageDialog(null,"Please ?! Enter Numbers in the TextFields");

                             
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
                              
                               int c =0 ;
                             double sumcol=0 ;
                             double n = 1.0 ;
                             String[] parts = new String[2];

                             try{
                             
                                 
                             for (int i = 0; i < jTextFieldArray.length; i+=C_number) {
                                 
                                 for (int j = i ; j < C_number+i; j++) {
                                     
                                      String string = jTextFieldArray[j].getText();
                     if (string.contains("/")) {
                     parts = string.split("/");
double part1 = Integer.parseInt(parts[0]); 
double part2 = Integer.parseInt(parts[1]); 

                                     n *= part1/part2;

                     
//                                     n *= Double.parseDouble(jTextFieldArray[j].getText());
                                     
                                 }else{
                         
                         
                         n *= Double.parseDouble(string);
                         
                         
                     }}
              GM_array[c]= Math.pow(n , 1.0/C_number);
              
              C_GeomtricMeanTOTAL += GM_array[c];
              
              n = 1.0 ;
              
              c++ ;
                             }
                             
                            
                      
                             for (int i = 0; i < C_number; i++) {
                                 
                  PV_array[0][i] =  GM_array[i] / C_GeomtricMeanTOTAL ;
                  
                  
                             }
                             
                             
                              //Add

                                 for (int j = 0 ; j < C_number; j++) {

                             for (int i = 0; i < jTextFieldArray.length; i+=C_number) {
                                 
                                 
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
                             
                             hmax[0]+=sumcol*PV_array[0][j];
                             sumcol = 0 ;

                                 }
                                 
                                 CI[0] = (hmax[0]-C_number)/(C_number-1);
//Add
                             
//                             for (int i = 0; i < PV_array.length; i++) {
//            
//            for (int j = 0; j < PV_array[i].length; j++) {
//            
//                System.out.println(PV_array[i][j]);
//            }
//        }
                    
      
     
                      
//             JOptionPane.showMessageDialog(null, "The priority Vector : "+
//                   PV_array[0][1]+"$"+PV_array[1][1]+"$"+PV_array[2][1]  );


                             
                             setVisible(false);
          A_Tables frame4 = new A_Tables( C_names , A_names , A_number , C_number-1 , PV_array ,hmax ,CI,num);
        frame4.setTitle("Alternative Table 1");
        frame4.setSize(800, 400);
                        frame4.setResizable(false);
        frame4.setLocationRelativeTo(null);
        frame4.setVisible(true);
        
                             
                
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
        
             int index = (n*C_number)%(jTextFieldArray.length-1) ;
                              
//                     float x = Float.parseFloat(jTextFieldArray[n].getText()) ;
                     String string = jTextFieldArray[n].getText();
                     if (string.contains("/")) {
                     parts = string.split("/");
double part1 = Integer.parseInt(parts[0]); 
double part2 = Integer.parseInt(parts[1]); 


                     jTextFieldArray[index].setText(""+(int)part2+"/"+(int)part1); 
                     } else {

                                          jTextFieldArray[index].setText("1/"+string); 

                         
                     }

//                        jTextFieldArray[index].setText(""+1.0/x); 
                       
             }catch(Exception e){
                 
                 
                          
             }

         }
                 
     });
    
     
    
    
    }
   
    
    
    
    
}
