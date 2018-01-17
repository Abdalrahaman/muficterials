/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduling_Algorithms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author dell
 */
public class Gantt_Chart_Pre extends JFrame{
    
    double End_Time ;
    double Start_Time[];
    double [] WaitingTime ;
        double [] TurnaroundTime ;
        double [][] ProcessMoved ;
        
                String [] ProcessName ;
                int [] ProcessNumber ;
                
                double Total_WaitingTime  ;
         double Average_WaitingTime ;
          double Total_TurnaroundTime  ;
         double Average_TurnaroundTime ;
         

  
    JPanel pn1 ;
    
    public Gantt_Chart_Pre(){
    
    }
    
    public Gantt_Chart_Pre(double processmoved[][] , double endTime ,double waitingtime[] , double turnarroundtime[] , String processname[] ,int processnumber[],double TWT , double AWT , double TTT , double ATT){
        
        ImageIcon icon = new ImageIcon("src/Images/ImageIcon.png");
        this.setIconImage(icon.getImage());
        
        ProcessMoved = processmoved ;
        
        End_Time = endTime ;
        
        WaitingTime = waitingtime ;
        
        TurnaroundTime = turnarroundtime ;
        
        ProcessName = processname ;
        
        ProcessNumber = processnumber ;
        
        
        Total_WaitingTime = TWT ;
          Average_WaitingTime =(float)AWT ;
          Total_TurnaroundTime = TTT ;
          Average_TurnaroundTime = (float)ATT ;
          
          
        
//        setLayout(new BorderLayout(3,3));
//        
//         pn1 = new JPanel();
//         
//        pn1.add(paint(g));
    
    }
    
    public void paint(Graphics g) {
        
        super.paint(g);
        
        int c =0 ;
        // numbers
        for (int i = 0; i <= End_Time; i++) {
         
                    g.drawString(""+i , 100+c , 90 );
                    
                    c+=30 ;
        }
        // processes
                                    g.setFont(new Font("Arial", Font.BOLD , 15));

        c=20 ;
        for (int i = 0; i < ProcessMoved.length; i++) {
         
                    g.drawString("Process "+(i+1) , 20 , 118+c );
                    
                    c+=20 ;
        }
        
        
            g.drawLine(100, 100, 100 , (45*ProcessNumber.length) ); //    الصادى  
            
       //         g.drawLine(100, 300, 400, 300);   //                    السينى


            c=0 ;
        for (int i = 0; i <= End_Time ; i++) {
            
                g.drawLine(100+c , 100 , 100+c , (45*ProcessNumber.length) ); //    الصادى  

                c+=30 ;
                
        }
        
            g.setColor(new Color(51, 102, 255));

    c = 0 ;
    int comp ;
    
        for (int i = 0; i < 10 ; i++) {
            
            for (int j = 0; j < ProcessMoved.length; j++) {
                
            
            
            comp = 30*(int)(ProcessMoved[j][i]);
            
            g.fillRect(100+c , 120+(20*ProcessNumber[j]), comp , 20);
            
            c += comp ;
            
            }
        }
        
                    g.setColor(new Color(0, 0, 0));
                    g.setFont(new Font("Trebuchet", Font.BOLD , 24));

        g.drawString("*  Waiting Time :- ", 150 , 400);
        
                            g.setFont(new Font("Arial", Font.BOLD , 18));

        c = 0 ;
        
        for (int i = 0; i < ProcessMoved.length; i++) {

                    g.drawString("*  - "+ProcessName[i] + " = " +  WaitingTime[i], 200 , 430+c);
                    
c += 20 ;
        }
        
                            g.setFont(new Font("Arial", Font.BOLD , 20));

                                 g.drawString("*    Total Waiting Time = "+Total_WaitingTime, 200 , 430+c+30);
                                 
                      g.drawString("*   Average Waiting Time = "+(float)Average_WaitingTime, 200 , 430+c+50);
                      
                      
                                          g.setFont(new Font("Trebuchet", Font.BOLD , 24));

                      
                       g.drawString("*  Turnaround Time :- ", 500 , 400);
        
                                                   g.setFont(new Font("Arial", Font.BOLD , 18));
        c = 0 ;
        
        for (int i = 0; i < ProcessMoved.length; i++) {

                    g.drawString("*  - "+ProcessName[i] + " = " +  TurnaroundTime[i], 550 , 430+c);
                    
c += 20 ;
        }
        
                            g.setFont(new Font("Arial", Font.BOLD , 20));

                                 g.drawString("*  Total Turnaround Time = "+Total_TurnaroundTime, 550 , 430+c+30);
                                 
                      g.drawString("*   Average Turnaround Time = "+(float)Average_TurnaroundTime, 550 , 430+c+50);
  }
    
    
}
