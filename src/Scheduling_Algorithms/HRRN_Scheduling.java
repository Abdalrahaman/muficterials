/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Scheduling_Algorithms;

import java.awt.ScrollPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author power
 */
public class HRRN_Scheduling {
    
    
    double[]BurstTime ;
        double[]ArrivalTime ;
        String [] ProcessName ;
        int [] processNumber ;
        
        double [] StartTime ;
        double [] WaitingTime ;
        double [] EndTime ;
        double [] TurnaroundTime ;
        double [] RRi ; 
        
         double Total_WaitingTime  ;
         double Average_WaitingTime ;
          double Total_TurnaroundTime  ;
         double Average_TurnaroundTime ;
         
    double sum ;
    
    public HRRN_Scheduling(){
    
    }
    
    
    public HRRN_Scheduling(double[]BT_Time , double[]AT_Time , String[]P_Name , int [] P_Number){
    
    
    this.BurstTime = BT_Time ;
        this.ArrivalTime = AT_Time ;
        this.ProcessName = P_Name ;
        this.processNumber = P_Number ;
        
        
        StartTime = new double [BurstTime.length] ;
        WaitingTime = new double [BurstTime.length] ;
        EndTime = new double [BurstTime.length] ;
        TurnaroundTime = new double [BurstTime.length] ;
         RRi  = new double [BurstTime.length];
        
          Total_WaitingTime = 0 ;
          Average_WaitingTime =0 ;
           Total_TurnaroundTime = 0 ;
          Average_TurnaroundTime = 0 ;
          sum =0 ;
    
    
    }
    
  
    
    public void WaitingTime(){
    
       StartTime[0] = 0 ;
       WaitingTime[0] = 0 ;
       
        sum = BurstTime[0] ;
        int i ;
        
        for ( i = 1 ; i < 2 ; i++) {
            
            StartTime[i] = sum ;
            
            EndTime[i-1] = StartTime[i] ; 
            
            WaitingTime[i] = StartTime[i] - ArrivalTime[i] ;
            
            TurnaroundTime[i-1] = EndTime[i-1] - ArrivalTime[i-1] ;
            
            sum += BurstTime[i] ;
            
            
        }
        
        StartTime[i] = sum ;
        
        EndTime[i-1] = sum ;    
        
         TurnaroundTime[i-1] = EndTime[i-1] - ArrivalTime[i-1] ;

    
    }
    
    
    public void RRi_process(){
        
       double max ;
       int i , j ;
       int index ;
        
        for ( i = 2 ; i < BurstTime.length-1; i++) {
            
        
    
            for ( j = i ; j < BurstTime.length; j++) {
             
         RRi[j] = ( (StartTime[i]-ArrivalTime[j]) + BurstTime[j])/BurstTime[j];
                
            }
            
            max = RRi[j-1];
            index = j-1 ;
            
            for (int k = i ; k < BurstTime.length-1; k++) {
                
                if (RRi[k] > max){
                
                max = RRi[k] ;
                
                index = k ;
                
                }
                
            }
           
            Swap(i, index);
            RRi_WaitingTime(i);
        }
        
         WaitingTime[i] = StartTime[i] - ArrivalTime[i] ;
        
         EndTime[i] = StartTime[i] + BurstTime[i] ;
         
         TurnaroundTime[i] =  EndTime[i] - ArrivalTime[i] ;
        
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
    
    
    
    public void RRi_WaitingTime(int pn){
    
     WaitingTime[pn] = StartTime[pn] - ArrivalTime[pn] ;
     
      sum += BurstTime[pn] ;  
      
   StartTime[pn+1] = sum ;
  
   EndTime[pn] = sum ;
   
   TurnaroundTime[pn] = EndTime[pn] - ArrivalTime[pn] ;
           
    }
    
    
    
     public void AVG_WaitingTime(){
 
        
        System.out.println("====================================\n");
        System.out.println("*  Waiting Time :- \n");
    
    
    for (int i = 0 ; i < BurstTime.length ; i++) {
            
            System.out.println("    - " + ProcessName[i] + " = " +  WaitingTime[i]);
            
            Total_WaitingTime += WaitingTime[i] ;
            
        }
    
    Average_WaitingTime =  Total_WaitingTime / ProcessName.length ;
    
        System.out.println("\n*  Total Waiting Time = " + Total_WaitingTime);
        
   System.out.println("*   Average Waiting Time = " + Average_WaitingTime);
    
    
    System.out.println("====================================\n");
        System.out.println("*  Turnaround Time :- \n");
    
    
    for (int j = 0 ; j < BurstTime.length ; j++) {
            
            System.out.println("    - " + ProcessName[j] + " = " + TurnaroundTime[j]);
            
            Total_TurnaroundTime += TurnaroundTime[j] ;
            
        }
    
    Average_TurnaroundTime =  Total_TurnaroundTime / ProcessName.length ;
    
        System.out.println("\n*  Total Turnaround Time = " + Total_TurnaroundTime);
        
   System.out.println("*   Average Turnaround Time = " + Average_TurnaroundTime);
    
   
   
   
   
//   Gantt_Chart per = new Gantt_Chart(EndTime , StartTime , WaitingTime , TurnaroundTime , ProcessName ,processNumber ,Total_WaitingTime,Average_WaitingTime,Total_TurnaroundTime,Average_TurnaroundTime);
//        per.setTitle("Solution !!");
//                per.setSize(1000,700);
//                per.setLocationRelativeTo(null);
//                per.setVisible(true);

Gantt_Chart per = new Gantt_Chart();
        per.setTitle("Solution !!");
         DrawingPanel drawingPanel = new DrawingPanel(EndTime , StartTime , WaitingTime , TurnaroundTime , ProcessName ,processNumber ,Total_WaitingTime,Average_WaitingTime,Total_TurnaroundTime,Average_TurnaroundTime);
        JScrollPane scrollPane = new JScrollPane(drawingPanel);
        per.add(scrollPane);
                per.setSize(1000,700);
                per.setLocationRelativeTo(null);
                per.setVisible(true);
    
 
    }
    
    
    
    
    
}
