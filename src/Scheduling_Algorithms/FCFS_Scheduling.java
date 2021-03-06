/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Scheduling_Algorithms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.ScrollPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author power
 */
public class FCFS_Scheduling {
    
    
     double[]BurstTime ;
        double[]ArrivalTime ;
        String [] ProcessName ;
        int [] processNumber ;
        
        double [] StartTime ;
        double [] WaitingTime ;
        double [] EndTime ;
        double [] TurnaroundTime ;
        
         double Total_WaitingTime  ;
         double Average_WaitingTime ;
          double Total_TurnaroundTime  ;
         double Average_TurnaroundTime ;
         

    
    public FCFS_Scheduling(){
    
    
    }
    
    
    public FCFS_Scheduling(double[]BT_Time , double[]AT_Time , String[]P_Name , int [] P_Number){
    
        this.BurstTime = BT_Time ;
        this.ArrivalTime = AT_Time ;
        this.ProcessName = P_Name ;
        this.processNumber = P_Number ;
        
        
        StartTime = new double [BurstTime.length] ;
        WaitingTime = new double [BurstTime.length] ;
        EndTime = new double [BurstTime.length] ;
        TurnaroundTime = new double [BurstTime.length] ;
        
          Total_WaitingTime = 0 ;
          Average_WaitingTime =0 ;
          Total_TurnaroundTime = 0 ;
          Average_TurnaroundTime = 0 ;
          
    }
    
    
    
     public void Sort_Processes(){
        
    
        int min ;
    for(int i=0 ; i<ArrivalTime.length-1 ; i++){
    
                min = i ;

    for(int j=i+1 ; j<=ArrivalTime.length-1 ; j++)
    
    if(ArrivalTime[j]<ArrivalTime[min])
        
        min = j ;
        
    Swap(i , min);
    
    }
    
    
    
    }
    
    public void Swap(int one , int two){
    
double temp1 = ArrivalTime[one];
ArrivalTime[one] = ArrivalTime[two];
ArrivalTime[two]= temp1 ; 
    
    
double temp2 = BurstTime[one];
BurstTime[one] = BurstTime[two];
BurstTime[two]= temp2 ;


String temp3 = ProcessName[one] ;
ProcessName[one] = ProcessName[two];
ProcessName[two]= temp3 ; 


int temp4 = processNumber[one] ;
processNumber[one] = processNumber[two];
processNumber[two]= temp4 ; 

    }
    
    
    public void AVG_WaitingTime(){
    
       
    
        double sum = BurstTime[0] ;
        
    StartTime[0] = 0 ;
    int i ;
    
        for ( i = 1 ; i < BurstTime.length ; i++) {

            StartTime[i] = sum ;
            
            EndTime[i-1] = StartTime[i] ;
            
            sum += BurstTime[i];
            
        }
        
        EndTime[i-1] = sum  ;
        
        System.out.println("====================================\n");
        System.out.println("*  Waiting Time :- \n");
    
    
    for ( i = 0 ; i < BurstTime.length ; i++) {

            WaitingTime[i] = StartTime[i] - ArrivalTime[i] ;
            
            System.out.println("    - " + ProcessName[i] + " = " +  WaitingTime[i]);
            
            Total_WaitingTime += WaitingTime[i] ;
            
        }
    
    
     Average_WaitingTime =  Total_WaitingTime / ProcessName.length ;
    
        System.out.println("\n*  Total Waiting Time = " + Total_WaitingTime);
        
   System.out.println("*   Average Waiting Time = " + Average_WaitingTime);
    
    
     System.out.println("====================================\n");
        System.out.println("*  Turnaround Time :- \n");
        
    
        for (int j = 0; j < BurstTime.length; j++) {

            TurnaroundTime[j] = EndTime[j] - ArrivalTime[j] ;
            
           System.out.println("    - " + ProcessName[j] + " = " +  TurnaroundTime[j]);

            Total_TurnaroundTime += TurnaroundTime[j] ;

        }
        
    
        Average_TurnaroundTime = Total_TurnaroundTime / ProcessName.length ;

    System.out.println("\n*  Total Turnaround Time = " + Total_TurnaroundTime);
        
   System.out.println("*   Average Turnaround Time = " + Average_TurnaroundTime);
   
      
        DrawingPanel drawingPanel = new DrawingPanel(EndTime , StartTime , WaitingTime , TurnaroundTime , ProcessName ,processNumber ,Total_WaitingTime,Average_WaitingTime,Total_TurnaroundTime,Average_TurnaroundTime);
//       drawingPanel.setBackground(Color.red);
double W = (EndTime[EndTime.length-1]*30)+120;
double H = (50*processNumber.length)+(20*processNumber.length)+150;
        System.out.println(W+"-"+H);

drawingPanel.setPreferredSize(new Dimension((int)W , (int)H));
        
JScrollPane scrollPane = new JScrollPane(drawingPanel , JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

Gantt_Chart per = new Gantt_Chart();

        per.setTitle("Solution !!");
        per.add(scrollPane , BorderLayout.CENTER);
                per.setSize(1000,700);
                per.setLocationRelativeTo(null);
                per.setVisible(true);
                
                
//   Gantt_Chart test = new Gantt_Chart(EndTime , StartTime , WaitingTime , TurnaroundTime , ProcessName ,processNumber ,Total_WaitingTime,Average_WaitingTime,Total_TurnaroundTime,Average_TurnaroundTime);
//                JFrame frame = new JFrame();
//                JScrollPane scrollPane = new JScrollPane(test);
//                frame.add(scrollPane);
//                frame.pack();
//                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                frame.setVisible(true);
    
    
    }
    
    
}
