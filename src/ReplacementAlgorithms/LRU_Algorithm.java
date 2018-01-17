/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ReplacementAlgorithms;
import java.util.Scanner;


/**
 *
 * @author power
 */
public class LRU_Algorithm {
    
    int [] Nnumbers ;
    int [] PageFrame ;    
    int [] Indexes ;
    
    
   int Numbers , pageFrame ; 
   int DefaultPage ;
   int ColCount ;
   
   int [][] Frames ;
            
    public LRU_Algorithm(){
    
    }

    
    public LRU_Algorithm(int Numbers , int pageFrame , int [] numarr){
        
        
        this.Numbers = Numbers ;
        this.pageFrame = pageFrame ;
    
    Nnumbers = numarr ;
    
    PageFrame = new int [pageFrame+1];// change 1
    
    Indexes = new int [pageFrame] ;
    
    Frames = new int [pageFrame+1][Numbers];// change 1
    
    DefaultPage = 0 ;
    ColCount =0 ;
    
    
    }
    
    
    
    public void Insert_DefaultArray(){
    
        
        PageFrame[0] = Nnumbers[0] ;
        
        for (int p = 0; p < PageFrame.length-1; p++) {// change 1
                        
                           Frames[p][ColCount] = PageFrame[p] ;
                           
                           if(p!=0 && Frames[p][ColCount] == 0){
                            Frames[p][ColCount] = -2 ;
                            PageFrame[p] = -2 ;
                            }
                        
                    } 
                    ColCount++ ;
                    
        int count = 1 ;
        int i ;
        
        for ( i = 1 ; i < Nnumbers.length; i++) {

            if(Scan_INframe(Nnumbers[i]) == true){
            
                if( count != pageFrame ){
                
                  PageFrame[count] = Nnumbers[i] ;
                  
                  for (int p = 0; p < PageFrame.length-1; p++) {// change 1
                        
                           Frames[p][ColCount] = PageFrame[p] ;
                        
                    } 
                    ColCount++ ;
                  
                  count++  ;
                  
                  }else
                    break ;
            }else{
            
            for (int p = 0; p < PageFrame.length-1; p++) {// change 1
                        
                           Frames[p][ColCount] = PageFrame[p] ;
                        
                    } 
                    ColCount++ ;
            
            }    
           
                     
        }
    
    
    Default_Page(i);
    
    }
    
    
    
    public boolean Scan_INframe(int num){
    
        int flag = 0 ;
    
        for (int i = 0; i < PageFrame.length-1; i++) {// change 1

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
    
    
    
    public void Default_Page(int Cnum){
    
    int c = 0 ;
        int Longest_Number , Min_Index ;
        for (int i = Cnum ; i < Nnumbers.length; i++) {

             if(Scan_INframe(Nnumbers[i]) == true){
             
             
                 for (int j = i-1 ; j >= 0 ; j--) {

                     if(Scan_INframe(Nnumbers[j]) == false){
                         
                         if(c != Indexes.length){
                     
                     Indexes[c] = j ;
                     
                        c++ ;
                         }else 
                             break ;
                     }
                 }
                 
                 
                    Min_Index = Indexes[0] ;
                 
                 for (int j = 1 ; j < Indexes.length; j++) {

                     if(Indexes[j] < Min_Index)
                         
                          Min_Index = Indexes[j] ;
                 }
                 
                 
                 Longest_Number = Nnumbers[Min_Index] ;
                 
                 for (int j = 0; j < PageFrame.length-1; j++) {// change 1

                     if(PageFrame[j] == Longest_Number){
                     
                     PageFrame[j] = Nnumbers[i] ;
                     
                     for (int p = 0; p < PageFrame.length-1; p++) {// change 1
                        
                           Frames[p][ColCount] = PageFrame[p] ;
                        
                    } 
                                         Frames[PageFrame.length-1][ColCount] = -1 ;// change

                    ColCount++ ;
                     
                           DefaultPage += 1 ;
                           
                           break ;

                     }
                 }
                 
                 
             
             }else{
             
             for (int p = 0; p < PageFrame.length-1; p++) {// change 1
                        
                           Frames[p][ColCount] = PageFrame[p] ;
                        
                    } 

                    ColCount++ ;
             
             }
                             c = 0 ;

        }
    
    
        System.out.println("\n - The Default Page = " + DefaultPage);
    
//    for (int i = 0; i < Nnumbers.length; i++) {
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
