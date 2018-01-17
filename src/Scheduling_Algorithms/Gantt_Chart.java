/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduling_Algorithms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author dell
 */
public class Gantt_Chart extends JFrame{
    
   
    public Gantt_Chart(){
        
        setLayout(new BorderLayout(3, 3));
        
    ImageIcon icon = new ImageIcon("src/Images/ImageIcon.png");
        this.setIconImage(icon.getImage());
        
    }
    
    
    
}



 class DrawingPanel extends JPanel {
   
  double End_Time[] ;
    double Start_Time[];
    double [] WaitingTime ;
        double [] TurnaroundTime ;
        
                String [] ProcessName ;
                int [] ProcessNumber ;
                
                double Total_WaitingTime  ;
         double Average_WaitingTime ;
          double Total_TurnaroundTime  ;
         double Average_TurnaroundTime ;
         

  
    JPanel pn1 ;
    
    int height ;
    int Weight ;
    
    public DrawingPanel(){
        
    }
    public DrawingPanel(double endtime[] , double starttime[] , double waitingtime[] , double turnarroundtime[] , String processname[] ,int processnumber[],double TWT , double AWT , double TTT , double ATT) {
       
                setLayout(new FlowLayout(FlowLayout.LEFT));

         End_Time = endtime ;
        
        Start_Time = starttime ;
        
        WaitingTime = waitingtime ;
        
        TurnaroundTime = turnarroundtime ;
        
        ProcessName = processname ;
        
        ProcessNumber = processnumber ;
        
        
          Total_WaitingTime = TWT ;
          Average_WaitingTime =(float)AWT ;
          Total_TurnaroundTime = TTT ;
          Average_TurnaroundTime = (float)ATT ;
          
          height = 100 ;
          Weight = 100 ;
          
    }
  
   
   public void paint(Graphics g) {
        
        super.paint(g);
        
        int c =0 ;
        
        
        
        for (int i = 0; i <= End_Time[End_Time.length-1]; i++) {
         
                    g.drawString(""+i , 100+c , 90 );
                    c+=30 ;
                                        Weight += c ;

        }
        
        
        // processes
                                    g.setFont(new Font("Arial", Font.BOLD , 15));

        c=20 ;
        for (int i = 0; i < ProcessNumber.length; i++) {
         
                    g.drawString("Process "+(i+1) , 20 , 118+c );
                    
                    c+=20 ;
        }
        
            g.drawLine(100, 100 , 100 , (30*ProcessNumber.length)+100 ); //    الصادى  
            
            height += 50*ProcessNumber.length ;
            
       //         g.drawLine(100, 300, 400, 300);   //                    السينى


            c=0 ;
            
        for (int i = 0; i <= End_Time[End_Time.length-1] ; i++) {
            
                g.drawLine(100+c , 100 , 100+c , (30*ProcessNumber.length)+100 ); //    الصادى  

                c+=30 ;
                
        }
        
            g.setColor(new Color(51, 102, 255));

    c = 0 ;
    int comp ;
    
        for (int i = 0; i < End_Time.length ; i++) {
            
            comp = 30*(int)(End_Time[i] - Start_Time[i]);
            
            g.fillRect(100+c , 120+(20*ProcessNumber[i]), comp , 20);
            
            c += comp ;
           
        }
        
                    g.setColor(new Color(0, 0, 0));
                    g.setFont(new Font("Trebuchet", Font.BOLD , 24));

        g.drawString("*  Waiting Time :- ", 150 , (30*ProcessNumber.length)+30+100);
                    height += 30 ;

                            g.setFont(new Font("Arial", Font.BOLD , 18));

        c = 20 ;
        
        for (int i = 0; i < End_Time.length; i++) {

                    g.drawString("*  - "+ProcessName[i] + " = " +  WaitingTime[i], 200 , (30*ProcessNumber.length)+30+c+100);
                                height += c ;

c += 20 ;
        }
        
                            g.setFont(new Font("Arial", Font.BOLD , 20));

                                 g.drawString("*    Total Waiting Time = "+Total_WaitingTime, 200 , (30*ProcessNumber.length)+30+c+30+100);
                                 
                      g.drawString("*   Average Waiting Time = "+(float)Average_WaitingTime, 200 , (30*ProcessNumber.length)+30+c+50+100);
                      
                      
                                          g.setFont(new Font("Trebuchet", Font.BOLD , 24));

                      
                       g.drawString("*  Turnaround Time :- ", 500 , (30*ProcessNumber.length)+30+100);
        
                                                   g.setFont(new Font("Arial", Font.BOLD , 18));
        c = 20 ;
        
        for (int i = 0; i < End_Time.length; i++) {

                    g.drawString("*  - "+ProcessName[i] + " = " +  TurnaroundTime[i], 550 , (30*ProcessNumber.length)+30+c+100);
                    
c += 20 ;
        }
        
                            g.setFont(new Font("Arial", Font.BOLD , 20));

                                 g.drawString("*  Total Turnaround Time = "+Total_TurnaroundTime, 550 , (30*ProcessNumber.length)+30+c+30+100);
                                 
                      g.drawString("*   Average Turnaround Time = "+(float)Average_TurnaroundTime, 550 , (30*ProcessNumber.length)+30+c+50+100);
 
               height += 50 ;

               System.out.println(Weight+"-"+height);
   }
   
   
   
    
}