/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReplacementAlgorithms;

import java.util.Scanner;

/**
 *
 * @author dell
 */
public class OPT_Algorithm {
    
    
    int [] Nnumbers ;
    int [] PageFrame ;    
    int [] Indexes ;
    
    
   int Numbers , pageFrame ; 
   int DefaultPage ;
   int ColCount ;
   
   int [][] Frames ;
            
    public OPT_Algorithm(){
    
    }

    
    public OPT_Algorithm(int Numbers , int pageFrame , int [] numarr){
        
        
        this.Numbers = Numbers ;
        this.pageFrame = pageFrame ;
    
    Nnumbers = numarr;
    
    PageFrame = new int [pageFrame+1];   // change 1
    
    Indexes = new int [pageFrame] ;
    
    Frames = new int [pageFrame+1][Numbers];// change 1
    
    DefaultPage = 0 ;
    ColCount =0 ;
    
    }
    
    
    
    public void Insert_DefaultArray(){
    
        
        PageFrame[0] = Nnumbers[0] ;
        
        for (int i = 0; i < PageFrame.length-1; i++) {  // change -1
            
            Frames[i][ColCount] = PageFrame[i] ;
            
            if(i!=0 && Frames[i][ColCount] == 0){
                            Frames[i][ColCount] = -2 ;
               PageFrame[i] = -2 ;
            }
        }
        ColCount++ ;
        
        int count = 1 ;
        int i ;
        
        for ( i = 1 ; i < Nnumbers.length; i++) {

            if(Scan_INframe(Nnumbers[i]) == true){
            
                if( count != pageFrame ){
                
                  PageFrame[count] = Nnumbers[i] ;
                  
                    for (int j = 0; j < PageFrame.length-1; j++) { // change -1
                        
                           Frames[j][ColCount] = PageFrame[j] ;
                        
                    } 
                    ColCount++ ;
                  
                  count++  ;
                  
                  }else
                    break ;
            }else{    
           
                  for (int j = 0; j < PageFrame.length-1; j++) {// change -1
                        
                           Frames[j][ColCount] = PageFrame[j] ;
                        
                    } 
                    ColCount++ ; 
            }
        }
    
    
    Default_Page(i);
    
    }
    
    
    
    public boolean Scan_INframe(int num){
    
        int flag = 0 ;
    
        for (int i = 0; i < PageFrame.length-1; i++) {// change -1

            if(PageFrame[i] != num)
            
                   flag = 0 ;
            else{
            
                   flag = 1 ;
                   break;
            }
            
        }
    
    
        if(flag == 0 )
            
            return true ;
        else
            return false ;
    
    }
    
    
     public int Scan_INnumbers(int numF , int indexN){
     
     int flag = 0 ;
    int i ;
     
        for ( i = indexN+1 ; i < Nnumbers.length; i++) {

            if(numF != Nnumbers[i])
            
                   flag = 0 ;
            else{
            
                   flag = 1 ;
                   break;
            }
            
        }
    
    
        if(flag == 0 )
            
            return Numbers ;
        else
            return i ;
     
     
     
     }
    
    
    
    public void Default_Page(int Cnum){
    
    int c = 0 , j;
    int flag = 0 ;
        int Longest_Number , Max_Index ;
        
        for (int i = Cnum ; i < Nnumbers.length; i++) {

             if(Scan_INframe(Nnumbers[i]) == true){
             
             
                 for ( j = 0 ; j < PageFrame.length-1 ; j++) {// change -1
                     
                     int numNScan = Scan_INnumbers(PageFrame[j] , i) ;

                     if(numNScan != Numbers){
                         
                         if(c != Indexes.length){
                     
                     Indexes[c] = numNScan ;
                     
                        c++ ;
                        
                        flag = 0 ;
                        
                         }else 
                             
                             break ;
                         
                         
                     }else{
                     
                     flag = 1 ;
                     break ;
                     }
                 }
                 
                 
                 if(flag == 0){
                     
                    Max_Index = Indexes[0] ;
                 
                 for ( j = 1 ; j < Indexes.length; j++) {

                     if(Indexes[j] > Max_Index)
                         
                          Max_Index = Indexes[j] ;
                     
                     Longest_Number = Nnumbers[Max_Index] ;
                 
                 for (int k = 0; k < PageFrame.length-1; k++) {// change -1

                     if(PageFrame[k] == Longest_Number){
                     
                     PageFrame[k] = Nnumbers[i] ;
                     
                     
                     for (int p = 0; p < PageFrame.length-1; p++) {// change -1
                        
                           Frames[p][ColCount] = PageFrame[p] ;
                        
                    } 
                     
                    Frames[PageFrame.length-1][ColCount] = -1 ;// change

                    ColCount++ ;
                     
                     
//                         for (int l = 0; l < PageFrame.length; l++) {
//
//                             System.out.println("F : "+PageFrame[l]);
//                         }
                     

                           DefaultPage += 1 ;
                           
                           break ;

                     }
                 }
                 
                 }
                 }else{
                 
                 PageFrame[j] = Nnumbers[i] ;
                 
//                 for (int l = 0; l < PageFrame.length; l++) {
//
//                             System.out.println("F : "+PageFrame[l]);
//                         }
//                 
               for (int p = 0; p < PageFrame.length-1; p++) {// change -1
                        
                           Frames[p][ColCount] = PageFrame[p] ;
                        
                    } 
                                   Frames[PageFrame.length-1][ColCount] = -1 ;// change

                    ColCount++ ;
                    
                      DefaultPage += 1 ;
                 
                 }
                 
                 
                 
             
             }else{
             
             for (int p = 0; p < PageFrame.length-1; p++) {// change -1
                        
                           Frames[p][ColCount] = PageFrame[p] ;
                        
                    } 
                    ColCount++ ;
             
             }
                             c = 0 ;

        }
    
    
        System.out.println("\n - The fault Page = " + DefaultPage);
    
//        for (int i = 0; i < Nnumbers.length; i++) {
//            for (int k = 0; k < PageFrame.length; k++) {
//
//                System.out.println(Frames[k][i]);                
//            }
//            
//        }
        
    }
    
    
    public int[][] returnTable(){
    
    return Frames ;
    }
    
    public int returnFaultpage(){
    
    return DefaultPage;
    }
}
