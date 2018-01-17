/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OR1_AHP;

import java.util.Scanner;

/**
 *
 * @author power
 */
public class operationTable {
    
    Scanner r = new Scanner(System.in);
    
    
    private double Uarray[][];
    private double Larray[][];
    private double Farray[][];
        private String n_c_array[];
        private String n_A_array[];
        int Csize , Asize ;
        int count1 , count2;
        
         public operationTable(){
         }
    
    public operationTable(int u , int l){
    
    Uarray = new double [u+1][u+2];
    Larray = new double [l+1][l+2];
    Farray = new double [l][u+1];
     n_c_array = new String [u];
     n_A_array = new String [l];
    Csize = u ;
    Asize = l ;
    count1 =0 ;
    count2 = 0;
    }
    
    public void criteriaName(){
    
    for(int i=0 ; i<Csize ; i++){
    
        System.out.print("Criteria Name "+(i+1)+" : ");
        n_c_array[i] = r.next();
    
    }
    
        System.out.println("==================================");
    
    }
    
    
    public void AlternativeName(){
    
    for(int i=0 ; i<Asize ; i++){
    
        System.out.print("Alternative Name "+(i+1)+" : ");
        n_A_array[i] = r.next();
    
    }
            System.out.println("==================================");

    }
    
    
    public void C_GeomtricMean(){
        
    
    for(int i=0 ; i<n_c_array.length ; i++){
    
        System.out.print("        "+n_c_array[i]);
     
    }
    
    int i ,j ;
    double multi ;
    for( i=0 ; i<Csize ; i++){
        
             multi = 1.0;

        System.out.print("\n"+n_c_array[i]+"     ");
        
    for( j=0 ; j <Csize ; j++){
    
    Uarray[i][j] = r.nextDouble();
        System.out.print("      ");
    
    }
    
    for(j=0 ; j<Csize ; j++){

    multi *=Uarray[i][j];
        
    }
    
       Uarray[i][j]  = Math.pow(multi, (1.0/Csize));

    }
//    int k = 0 ;
//    while (k!=4){
//    
//            System.out.println(Uarray[k][Csize]);
//            k++;
//    }
    
    }
    
    
    public void C_total(){
    
        double sum = 0 ;
        int i ;
        
        for( i =0 ; i<Csize+1 ; i++){
        
                  for(int j =0 ; j<Csize ; j++){
                  
                       sum +=  Uarray[j][i];
                  
                  }

                   Uarray[Csize][i] = sum ;
        
                    sum =0  ;
        }

    
    }
    
    
    public void C_priority_vector(){
    
    for(int i =0 ; i<Csize ; i++){
    
     Uarray[i][Csize+1] =( Uarray[i][Csize])/(Uarray[Csize][Csize]);

    
    
    }
    
    System.out.print("\nP.V ==> ");
    
    for(int i =0 ; i<Csize ; i++){
        System.out.print(Uarray[i][Csize+1] + " || ");
    }
    
        System.out.println();
    }
    
    
    public void A_GeomtricMean(){
        
    
    for(int i=0 ; i<n_A_array.length ; i++){
    
        System.out.print("        "+n_A_array[i]);
     
    }
    
    int i ,j ;
    double multi ;
    for( i=0 ; i<Asize ; i++){
        
             multi = 1.0;

        System.out.print("\n"+n_A_array[i]+"     ");
        
    for( j=0 ; j <Asize ; j++){
    
    Larray[i][j] = r.nextDouble();
        System.out.print("      ");
    
    }
    
    for(j=0 ; j<Asize ; j++){

    multi *=Larray[i][j];
        
    }
    
       Larray[i][j]  = Math.pow(multi, 1.0/Asize);

    }
    
//    int k = 0 ;
//    while (k!=3){
//    
//            System.out.println(Larray[k][Asize]);
//            k++;
//    }
    
    }
    
    
    public void A_total(){
    
        double sum = 0 ;
        int i ;
        
        for( i =0 ; i<Asize+1 ; i++){
        
                  for(int j =0 ; j<Asize ; j++){
                  
                       sum +=  Larray[j][i];
                  
                  }

                   Larray[Asize][i] = sum ;
                    sum =0  ;
        }

    
    }
    
    
    public void A_priority_vector(){
        
    
    for(int i =0 ; i<Asize ; i++){
    
     Larray[i][Asize+1] =( Larray[i][Asize])/(Larray[Asize][Asize]);

    Farray[i][count1] = Larray[i][Asize+1] ;
    
    
    }
    
    count1++;
    
    System.out.print("\nP.V ==> ");
    
    for(int i =0 ; i<Asize ; i++){
        System.out.print(Larray[i][Asize+1] + " || ");
    }
    
        System.out.println("\n");
    }
    
    
    public void Solution(){
    
    double product = 0 ;    
    double max ;
    int IDname ;
    int i ;
        
    for( i =0 ; i<Farray.length ; i++){
        
                  for(int j =0 ; j<Farray[i].length ; j++){
                      
          product +=( Farray[i][j] )*( Uarray[count2][Csize+1] );
                      
                                 count2++;
                  }
                  
                  Farray[i][Csize] = product ;
                  
                  product = 0 ;
                  
                  count2 = 0 ;
                  
    }
    
    max = Farray[i-1][Csize] ;
    IDname = i-1 ;
    
    for( i=0 ; i<Farray.length ; i++){
    
        System.out.println(n_A_array[i] + " = "+ Farray[i][Csize]);
        
        if(max < Farray[i][Csize]){
        
        max = Farray[i][Csize];
        IDname = i ;
        
        }
             
         }
    
    System.out.println("\n\nThe Best is "+n_A_array[IDname] +" = "+ max +"\n");
        
        
//        for(int  i =0 ; i<Farray.length ; i++){
//        
//                  for(int j =0 ; j<Farray[i].length ; j++){
//                      
//                      System.out.println("\n"+Farray[i][j]);
//                  }
//        }
    }
    
  }
