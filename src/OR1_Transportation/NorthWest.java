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

/**
 *
 * @author power
 */
public class NorthWest extends JFrame{
    
    int S_Number , D_Number ;
    double [][] Costs_Array ;
    int S_Array[] , D_Array[];
    int [][] NW_Value ;
    double  TotalCost ;
    int TotalSources  , TotalDemonds    ;
    
    JTextField jtextfield_Source[];
    JTextField jtextfield_Demond[];
    
    JLabel D_name[];
    JLabel S_name[];
    JLabel CN_LP[][];
    JLabel TC_lb  , TotalSD;
    
    JPanel pn1 ;
    JPanel pn2 ;
    JPanel pn3 ;
    JPanel pn4 ;
    JPanel pn5 ;
    JPanel pnadd ;
    
    JButton Solve ;
    
    public NorthWest(){
    
    }
    
    
    public NorthWest(int S_number , int D_number , double [][] Cost_array){
    
        ImageIcon icon = new ImageIcon("src/Images/ImageIcon.png");
        this.setIconImage(icon.getImage());
        
    this.S_Number = S_number ;
    this.D_Number = D_number ;
    this.Costs_Array = Cost_array ;
    TotalCost = 0 ;
    TotalSources = 0 ; TotalDemonds = 0   ;
    
         S_Array = new int [S_number];
         D_Array = new int [D_number];
           NW_Value = new int [S_number][D_number];
           
         
         jtextfield_Source = new JTextField[S_number];
         jtextfield_Demond = new JTextField[D_number];

         D_name = new JLabel[D_number+3];       //       Change from 2 to 3
         S_name = new JLabel[S_number+2];        // Change from 1 to 2
         CN_LP = new JLabel[S_number+1][D_number+1]; // Change +1 , +1
         
         pn1 = new JPanel();
         pn2 = new JPanel();
         pn3 = new JPanel();
         pn4 = new JPanel();
         pn5 = new JPanel();
         pnadd = new JPanel();

            setLayout(new BorderLayout(3,3));

    pn1.setLayout(new GridLayout(1 , D_number+3,3,3)); // north      Change from 2 to 3
    pn2.setLayout(new GridLayout(S_number+2 , 1)); // west          Change from 1 to 2
    pn3.setLayout(new GridLayout(S_number+1 , 1));    // east
    pn4.setLayout(new GridLayout(1 , 2 , 3 , 5));    // south
    pn5.setLayout(new GridLayout(S_number+2 , D_number+1)); // center    Change +1 to +2  And  not to +1
    pnadd.setLayout(new BorderLayout(5,5));
    
    pn1.setBackground(new Color(51,71,91));
    pn2.setBackground(new Color(51,71,91));
    pn3.setBackground(new Color(51,71,91));
    pn4.setBackground(new Color(51,71,91));
    pn5.setBackground(new Color(51,71,91));
    
    Demond_name();
    Source_name();
    SD_Value();
    
        JScrollPane scroll = new JScrollPane(pnadd);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
    pnadd.add(pn1 , BorderLayout.NORTH);
     pnadd.add(pn2 , BorderLayout.WEST);
      pnadd.add(pn3 , BorderLayout.EAST);
       pnadd.add(pn5 , BorderLayout.CENTER);
        add(scroll , BorderLayout.CENTER);
    
         Solve = new JButton("Solve");
         
         Solve.setFont(new Font("Arial", Font.BOLD, 18));
        Solve.setBackground(new Color(0,115,133));
        Solve.setForeground(new Color(0,102,102));
         
          TC_lb = new JLabel(" Total Cost = 0.0 ");
         
          TC_lb.setFont(new Font("Arial", Font.BOLD, 16));
        TC_lb.setForeground(new Color(204,51,0));
        
         pn4.add(TC_lb);
         pn4.add(Solve);
         
        
         add(pn4 , BorderLayout.SOUTH);
         
         
        
    SolveAction(); 
    
    
    }
    
    
    public void Demond_name(){
        
        int i , j;
        
        D_name[0] = new JLabel("North West");
        
        D_name[0].setFont(new Font("Yu Gothic", Font.BOLD, 17));
           D_name[0].setForeground(new Color(0,204,204));
       
        for ( i = 1; i < D_name.length-2 ; i++) {
            
            D_name[i] = new JLabel("Demond " + i);
            
        }
    
           
        D_name[i] = new JLabel("       ");
        
                 D_name[i+1] = new JLabel("Sources");

        for ( j = 0; j < D_name.length ; j++) {

            if(j!=0){
            D_name[j].setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
           D_name[j].setForeground(new Color(255,255,255));
            }
            pn1.add(D_name[j]);
        }
        
           
    }
    
    
    public void Source_name(){
    
    int i ;
    
        for ( i = 0; i < S_name.length -2 ; i++) {
            
            S_name[i] = new JLabel("Source "+ (i+1));
            
        }
    
        S_name[i] = new JLabel("       ");
        
                S_name[i+1] = new JLabel("Demonds");

       for (int j = 0; j < S_name.length; j++) {

           S_name[j].setFont(new Font("Yu Gothic Light", Font.BOLD, 16));
           S_name[j].setForeground(new Color(255,255,255));
           
            pn2.add(S_name[j]);
        }
    
    }
    
    
    public void SD_Value(){
    
        int i , j;
        
        for ( i = 0; i < S_Array.length; i++) {
            
            for ( j = 0; j < D_Array.length; j++) {

                CN_LP[i][j] = new JLabel("      ");
                
                CN_LP[i][j].setFont(new Font("Yu Gothic Light", Font.BOLD, 17));
                CN_LP[i][j].setForeground(new Color(0,153,153));
                
                pn5.add(CN_LP[i][j]);
                
            }
            
            // Add
            
                            CN_LP[i][j] = new JLabel("      ");
                            
                            CN_LP[i][j].setFont(new Font("Yu Gothic Light", Font.BOLD, 17));
                CN_LP[i][j].setForeground(new Color(0,153,153));
                                            pn5.add(CN_LP[i][j]);

// Add
            
            jtextfield_Source[i] = new JTextField(10);
            jtextfield_Source[i].setFont(new Font("Tahoma", Font.PLAIN, 18));
            jtextfield_Source[i].setHorizontalAlignment((int) CENTER_ALIGNMENT);
            
            pn3.add(jtextfield_Source[i]);
            
        }
        
        //Add

        for (int k = 0 ; k < D_Array.length+1 ; k++) {
            
                 CN_LP[i][k] = new JLabel("      ");
                 
                 CN_LP[i][k].setFont(new Font("Yu Gothic Light", Font.BOLD, 17));
                CN_LP[i][k].setForeground(new Color(0,153,153));
                                 pn5.add(CN_LP[i][k]);

        }

//Add
        
       TotalSD = new JLabel("    ");
       pn3.add(TotalSD);
        
        
        for (int k = 0 ; k < D_Array.length; k++) {
            
        jtextfield_Demond[k] = new JTextField(10);
            jtextfield_Demond[k].setFont(new Font("Tahoma", Font.PLAIN, 18));
            jtextfield_Demond[k].setHorizontalAlignment((int) CENTER_ALIGNMENT);
            pn5.add(jtextfield_Demond[k]);
    
        }
    
    
    }
    
    
    public void SolveAction(){
    
        
            Solve.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    
                    int  Value ;
                    
                    try{
                    
                    for (int i = 0; i < S_Array.length  ; i++) {

                  S_Array[i] = Integer.parseInt(jtextfield_Source[i].getText());
                  
                  TotalSources += S_Array[i] ;
                        
                    }
                    
                    
                    for (int i = 0; i < D_Array.length; i++) {

                  D_Array[i] = Integer.parseInt(jtextfield_Demond[i].getText());
                  
                  TotalDemonds += D_Array[i] ;
                        
                    }
                    
                    // Add
                    
                    
                    if(TotalSources != TotalDemonds){
                    
                        if(TotalSources > TotalDemonds){
                            
                            Value = TotalSources - TotalDemonds ;
                            
                            D_name[D_Number+1].setText("Dummy");
                              
                               D_Array = new int [D_Number+1];
                               
                               for (int i = 0; i < D_Array.length-1; i++) {

                  D_Array[i] = Integer.parseInt(jtextfield_Demond[i].getText());
                  
//                  TotalDemonds += D_Array[i] ;
                        
                    }
                               
                               D_Array[D_Number] = Value ;
                            
                               NW_Value = new int [S_Number][D_Number+1];

                        }else{
                        
                            Value = TotalDemonds - TotalSources ;
                            
                            S_name[S_Number].setText("Dummy");
                            
                             S_Array = new int [S_Number+1];
                             
                             for (int i = 0; i < S_Array.length-1  ; i++) {

                  S_Array[i] = Integer.parseInt(jtextfield_Source[i].getText());
                  
//                  TotalSources += S_Array[i] ;
                        
                    }
                             
                             S_Array[S_Number] = Value ;

                             NW_Value = new int [S_Number+1][D_Number];

                        }
                    
                    
                    }
                    
                    
    // Add
                    
                    
                    for (int i = 0; i < S_Array.length; i++) {

                        for (int j = 0; j < D_Array.length; j++) {

                            
                            if(NW_Value[i][j] == 0){
                            
                            
                            if(S_Array[i] > D_Array[j] ){
                            
                            NW_Value[i][j] = D_Array[j] ;
                            
                            S_Array[i] = S_Array[i] - NW_Value[i][j] ;
                            D_Array[j] = D_Array[j] - NW_Value[i][j] ;
                            
                            
                            for (int k = 0; k < S_Array.length; k++) {

            System.out.println(S_Array[k]);            
        }
        System.out.println("\n");
        
        for (int k = 0; k < D_Array.length; k++) {

            System.out.println(D_Array[k]);            
        }
                            

                              CN_LP[i][j].setText("           "+NW_Value[i][j]+" * "+Costs_Array[i][j]);
                            
                            
                            TotalCost += NW_Value[i][j]*Costs_Array[i][j] ;
                            
                                
                                    for (int l = 0 ; l < S_Array.length ; l++) {
                                        
                                        if(NW_Value[l][j] <= 0){
                                        
                                            NW_Value[l][j] = -1 ;
                                        }
                                    }
                                
                            
                            }else
                                if(S_Array[i] < D_Array[j]){
                                
                                NW_Value[i][j] = S_Array[i] ;
                                
                                S_Array[i] = S_Array[i] - NW_Value[i][j] ;
                                D_Array[j] = D_Array[j] - NW_Value[i][j] ;
                                
                                for (int k = 0; k < S_Array.length; k++) {

            System.out.println(S_Array[k]);            
        }
        System.out.println("\n");
        
        for (int k = 0; k < D_Array.length; k++) {

            System.out.println(D_Array[k]);            
        }
        System.out.println("\n");

        
                              CN_LP[i][j].setText("           "+NW_Value[i][j]+" * "+Costs_Array[i][j]);

                            
                            TotalCost += NW_Value[i][j]*Costs_Array[i][j] ;
                            
                                
                                for (int l = 0 ; l < D_Array.length ; l++) {
                                        
                                        if(NW_Value[i][l] <= 0){
                                        
                                            NW_Value[i][l] = -1 ;
                                        }
                                    }
                                
                            }else{
                                
                                if(S_Array[i] == D_Array[j]){
                                
                                NW_Value[i][j] = D_Array[j] ;
                                
                                S_Array[i] = S_Array[i] - NW_Value[i][j] ;
                                D_Array[j] = D_Array[j] - NW_Value[i][j] ;
                                
                                for (int k = 0; k < S_Array.length; k++) {

            System.out.println(S_Array[k]);            
        }
        System.out.println("\n");
        
        for (int k = 0; k < D_Array.length; k++) {

            System.out.println(D_Array[k]);            
        }
                                             System.out.println("\n");
                   
                                
                              CN_LP[i][j].setText("           "+NW_Value[i][j]+" * "+Costs_Array[i][j]);
                            
              
                            TotalCost += NW_Value[i][j]*Costs_Array[i][j] ;
                            
                                
                                for (int l = 0 ; l < S_Array.length ; l++) {
                                        
                                        if(NW_Value[l][j] <= 0){
                                        
                                            NW_Value[l][j] = -1 ;
                                        }
                                    }
                                
                                
                                for (int l = 0 ; l < D_Array.length ; l++) {
                                        
                                        if(NW_Value[i][l] <= 0){
                                        
                                            NW_Value[i][l] = -1 ;
                                        }
                                    }
                                
                                }
                                }
                            
                            

                            }else{
                                 if(NW_Value[i][j] == -1){
                                 
                              CN_LP[i][j].setText("                X ");
                            
                                 }
                            }
                        }
                    }
                    
                    
                    Total_Cost();
                    
                    }catch(Exception ec){
                    
                    JOptionPane.showMessageDialog(null,"Please ?! Enter numbers in the TextFields");

                    
                    }
                    
                    
                        
                }
            });
    
    
    Solve.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                }

                @Override
                public void keyPressed(KeyEvent e) {

             if(e.getKeyCode() == KeyEvent.VK_ENTER){
                 
                  int  Value ;
                    
                    try{
                    
                    for (int i = 0; i < S_Array.length  ; i++) {

                  S_Array[i] = Integer.parseInt(jtextfield_Source[i].getText());
                  
                  TotalSources += S_Array[i] ;
                        
                    }
                    
                    
                    for (int i = 0; i < D_Array.length; i++) {

                  D_Array[i] = Integer.parseInt(jtextfield_Demond[i].getText());
                  
                  TotalDemonds += D_Array[i] ;
                        
                    }
                    
                    // Add
                    
                    
                    if(TotalSources != TotalDemonds){
                    
                        if(TotalSources > TotalDemonds){
                            
                            Value = TotalSources - TotalDemonds ;
                            
                            D_name[D_Number+1].setText("Dummy");
                              
                               D_Array = new int [D_Number+1];
                               
                               for (int i = 0; i < D_Array.length-1; i++) {

                  D_Array[i] = Integer.parseInt(jtextfield_Demond[i].getText());
                  
//                  TotalDemonds += D_Array[i] ;
                        
                    }
                               
                               D_Array[D_Number] = Value ;
                            
                               NW_Value = new int [S_Number][D_Number+1];

                        }else{
                        
                            Value = TotalDemonds - TotalSources ;
                            
                            S_name[S_Number].setText("Dummy");
                            
                             S_Array = new int [S_Number+1];
                             
                             for (int i = 0; i < S_Array.length-1  ; i++) {

                  S_Array[i] = Integer.parseInt(jtextfield_Source[i].getText());
                  
//                  TotalSources += S_Array[i] ;
                        
                    }
                             
                             S_Array[S_Number] = Value ;

                             NW_Value = new int [S_Number+1][D_Number];

                        }
                    
                    
                    }
                    
                    
    // Add
                    
                    
                    for (int i = 0; i < S_Array.length; i++) {

                        for (int j = 0; j < D_Array.length; j++) {

                            
                            if(NW_Value[i][j] == 0){
                            
                            
                            if(S_Array[i] > D_Array[j] ){
                            
                            NW_Value[i][j] = D_Array[j] ;
                            
                            S_Array[i] = S_Array[i] - NW_Value[i][j] ;
                            D_Array[j] = D_Array[j] - NW_Value[i][j] ;
                            
                            
                            for (int k = 0; k < S_Array.length; k++) {

            System.out.println(S_Array[k]);            
        }
        System.out.println("\n");
        
        for (int k = 0; k < D_Array.length; k++) {

            System.out.println(D_Array[k]);            
        }
                            

                              CN_LP[i][j].setText("           "+NW_Value[i][j]+" * "+Costs_Array[i][j]);
                            
                            
                            TotalCost += NW_Value[i][j]*Costs_Array[i][j] ;
                            
                                
                                    for (int l = 0 ; l < S_Array.length ; l++) {
                                        
                                        if(NW_Value[l][j] <= 0){
                                        
                                            NW_Value[l][j] = -1 ;
                                        }
                                    }
                                
                            
                            }else
                                if(S_Array[i] < D_Array[j]){
                                
                                NW_Value[i][j] = S_Array[i] ;
                                
                                S_Array[i] = S_Array[i] - NW_Value[i][j] ;
                                D_Array[j] = D_Array[j] - NW_Value[i][j] ;
                                
                                for (int k = 0; k < S_Array.length; k++) {

            System.out.println(S_Array[k]);            
        }
        System.out.println("\n");
        
        for (int k = 0; k < D_Array.length; k++) {

            System.out.println(D_Array[k]);            
        }
        System.out.println("\n");

        
                              CN_LP[i][j].setText("           "+NW_Value[i][j]+" * "+Costs_Array[i][j]);

                            
                            TotalCost += NW_Value[i][j]*Costs_Array[i][j] ;
                            
                                
                                for (int l = 0 ; l < D_Array.length ; l++) {
                                        
                                        if(NW_Value[i][l] <= 0){
                                        
                                            NW_Value[i][l] = -1 ;
                                        }
                                    }
                                
                            }else{
                                
                                if(S_Array[i] == D_Array[j]){
                                
                                NW_Value[i][j] = D_Array[j] ;
                                
                                S_Array[i] = S_Array[i] - NW_Value[i][j] ;
                                D_Array[j] = D_Array[j] - NW_Value[i][j] ;
                                
                                for (int k = 0; k < S_Array.length; k++) {

            System.out.println(S_Array[k]);            
        }
        System.out.println("\n");
        
        for (int k = 0; k < D_Array.length; k++) {

            System.out.println(D_Array[k]);            
        }
                                             System.out.println("\n");
                   
                                
                              CN_LP[i][j].setText("           "+NW_Value[i][j]+" * "+Costs_Array[i][j]);
                            
              
                            TotalCost += NW_Value[i][j]*Costs_Array[i][j] ;
                            
                                
                                for (int l = 0 ; l < S_Array.length ; l++) {
                                        
                                        if(NW_Value[l][j] <= 0){
                                        
                                            NW_Value[l][j] = -1 ;
                                        }
                                    }
                                
                                
                                for (int l = 0 ; l < D_Array.length ; l++) {
                                        
                                        if(NW_Value[i][l] <= 0){
                                        
                                            NW_Value[i][l] = -1 ;
                                        }
                                    }
                                
                                }
                                }
                            
                            

                            }else{
                                 if(NW_Value[i][j] == -1){
                                 
                              CN_LP[i][j].setText("                X ");
                            
                                 }
                            }
                        }
                    }
                    
                    
                    Total_Cost();
                    
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
    
    
    
    public void Total_Cost(){
    
TC_lb.setText("  Total Cost =  " + TotalCost );

        TC_lb.setForeground(new Color(0,204,102));

TotalSD.setText("      T = "+TotalSources);

TotalSD.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
           TotalSD.setForeground(new Color(102,0,102));
           
        for (int i = 0; i < S_Array.length; i++) {

            System.out.println(S_Array[i]);            
        }
        System.out.println("\n");
        
        for (int i = 0; i < D_Array.length; i++) {

            System.out.println(D_Array[i]);            
        }
    
    
    }

    
    
    
    
    
}
