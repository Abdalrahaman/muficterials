package Scheduling_Algorithms;

import java.util.Scanner;

public class RR_Scheduling {

    Scanner Processesscan = new Scanner(System.in);
    int quantum ;
    double endtime;
    String[] Names;
    int ProcessesNumber[];
    double[] BurestTime;
    
        double [] StartTime ;
        double [] WaitingTime ;
        double [] EndTime ;
        double [] TurnaroundTime ;
        double [][] ProcessMoved ;
        
         double Total_WaitingTime  ;
         double Average_WaitingTime ;
          double Total_TurnaroundTime  ;
         double Average_TurnaroundTime ;

    public RR_Scheduling(double[]Burst , double[]Arrival , int Q , String[]P_Name , int [] P_Number) {
        
        quantum = Q;
        
        ProcessesNumber = P_Number ;
        
        Names = P_Name ;
        BurestTime = Burst ;
        
        StartTime = new double [Burst.length] ;
        WaitingTime = new double [Burst.length] ;
        EndTime = new double [Burst.length] ;
        TurnaroundTime = new double [Burst.length] ;
        ProcessMoved = new double[Burst.length][10];
        
          Total_WaitingTime = 0 ;
          Average_WaitingTime =0 ;
          Total_TurnaroundTime = 0 ;
          Average_TurnaroundTime = 0 ;
    }

    
     public void findavgTime(){
        
      
        // Function to find waiting time 
        findWaitingTime(ProcessesNumber, ProcessesNumber.length, BurestTime, WaitingTime, quantum);
      
        // Function to find turn around time 
        findTurnAroundTime(ProcessesNumber, ProcessesNumber.length, BurestTime, WaitingTime, TurnaroundTime);
      
       
        System.out.println("Processes " + " Burst time " +
                      " Waiting time " + " Turn around time");
      
        
        // around time
        for (int i=0; i<ProcessesNumber.length; i++)
        {
            Total_WaitingTime = Total_WaitingTime + WaitingTime[i];
            Total_TurnaroundTime = Total_TurnaroundTime + TurnaroundTime[i];
            System.out.println(" " + (i+1) + "\t\t" + BurestTime[i] +"\t " +
                              WaitingTime[i] +"\t\t " + TurnaroundTime[i]);
        }
      
        Average_WaitingTime = (float)Total_WaitingTime / (float)ProcessesNumber.length ;
        Average_TurnaroundTime = (float)Total_TurnaroundTime / (float)ProcessesNumber.length ;
        
        System.out.println("Average waiting time = " + (float)Average_WaitingTime);
        System.out.println("Average turn around time = " + (float)Average_TurnaroundTime);
               

//for ( int k = 0; k < ProcessMoved[k].length; k++) {
//                
//                for (int j = 0; j < ProcessMoved.length; j++) {
//
//                    System.out.println(ProcessMoved[j][k]);
//                }
//
//         }
        
        Gantt_Chart_Pre per = new Gantt_Chart_Pre(ProcessMoved ,endtime ,WaitingTime , TurnaroundTime , Names ,ProcessesNumber ,Total_WaitingTime,Average_WaitingTime,Total_TurnaroundTime,Average_TurnaroundTime);
                per.setTitle("Solution !!");
                per.setSize(1000,700);
                per.setLocationRelativeTo(null);
                per.setVisible(true);
    }
    
     public void findWaitingTime(int processes[], int n,double bt[], double wt[], int quantum) {
        
        double rem_bt[] = new double[n];
        for (int i = 0 ; i < n ; i++)
            rem_bt[i] =  bt[i];
      
        double t = 0; // Current time
        
      StartTime[0] = t ;
        
        int k = 0 ;
        while(true){
            
            boolean done = true;
      
            
            int i ;
            for ( i = 0 ; i < n; i++){
                
                if (rem_bt[i] > 0){
                    done = false; // There is a pending process
      
                    if (rem_bt[i] > quantum){
                        
                        t += quantum;
                        EndTime[i] = t ;
                        
                        if(i < n-1)
                        StartTime[i+1] = EndTime[i] ;
                        
                        rem_bt[i] -= quantum;
                    }
      
                    
                    else{
                        
                        t = t + rem_bt[i];
                        EndTime[i] = t ;
                                           
                        if(i < n-1)
                        StartTime[i+1] = EndTime[i] ;

                        wt[i] = t - bt[i];
      
                        rem_bt[i] = 0;
                    }
                }
                
                if(EndTime[i] < StartTime[i]){
                    if(i<n-1){
                StartTime[i+1] = StartTime[i] ;
                StartTime[i] = 0;
                EndTime[i] = 0 ;
                    }else{
                

//                    StartTime[i] = 0;
                EndTime[i] = 0 ;    
                                            

                    }
                }
            }
      
            
            // If all processes are done
            if (done == true){
                endtime = t ;
                break;
            }
              
            
                
                for (int j = 0; j < Names.length; j++) {

                    ProcessMoved[j][k] = EndTime[j] - StartTime[j] ;
                    
                    if(ProcessMoved[j][k] < 0 )
                        ProcessMoved[j][k] = 0 ;
                }

//             System.out.println(StartTime[i]+" - "+EndTime[i]);             
         
            
            
            
            if(EndTime[i-1] < StartTime[i-1]){
                    if(i-1==n-1){
                StartTime[0] = StartTime[i-1] ;
                StartTime[i-1] = 0;
//                EndTime[i-1] = 0 ;
                    }
        }else
            StartTime[0] = EndTime[i-1];
            
            
            k++ ;
    }
     }
      
    public void findTurnAroundTime(int processes[], int n, double bt[], double wt[], double tat[]) {
        // calculating turnaround time by adding
        // bt[i] + wt[i]
        for (int i = 0; i < n ; i++)
            tat[i] = bt[i] + wt[i];
    }
    
   
}

