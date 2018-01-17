package Scheduling_Algorithms;

import java.util.Scanner;

public class FeedBack {

    Scanner Processesscan = new Scanner(System.in);
    int NumberOfProcesses;
    int quantem;
    String[] Names;
    int ProcessesBurest;
    double[] BurestTime;

    public FeedBack(double[]Burst , double[]Arrival , int Q , String[]P_Name , int [] P_Number) {

        quantem = Q;
        NumberOfProcesses = P_Number.length ;
        
        Names = P_Name ;
        BurestTime = Burst ;
    }

    public void FB_Algorithm() {

        
        boolean flag = false;
        int j;
        int Finish = 0;
        for (int turn = 0;; turn++) {
                    int fbq=1;
            for (int check = 0; check < BurestTime.length; check++) {
                if (BurestTime[check] == 0) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                for (j = 0; j < NumberOfProcesses; j++) {
                    if (BurestTime[j] != 0) {
                        int p = (int) (BurestTime[j] - Math.pow(quantem,fbq ));
                        if (p > 0) {
                            System.out.println("process :" + Names[j]);
                            System.out.println("service time :" + quantem);
                            Finish += quantem;
                            System.out.println("finish time :" + Finish);
                            BurestTime[j] = p;

                        } else if (p <= 0) {
                            System.out.println("process :" + Names[j]);
                            System.out.println("service time :" + BurestTime[j]);
                            Finish += BurestTime[j];
                            System.out.println("finish time :" + Finish);
                            BurestTime[j] = 0;
                        }
                    }
                    fbq++;
                }
            } else {
                break;
            }
        }
    }
}
