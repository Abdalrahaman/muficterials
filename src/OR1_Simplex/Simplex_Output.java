/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OR1_Simplex;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author dell
 */
public class Simplex_Output extends javax.swing.JFrame {

    /**
     * Creates new form Output
     */
    
//  int numberOfConstraints; 
//  int numberOfOriginalVariables; 
//  double [][]tableV ;
//  String [][]tableValues ;
//double[]Xvalues ;
//double OptSolution ;
//int countTable ;
//double []x ;
//
//        JTable[] tables ;
       
int numtable  ;
 double[][] tableaux; // tableaux
 String [][] tablevalues;
 JTable []tables ;
  int numberOfConstraints; // number of constraints
  int numberOfOriginalVariables; // number of original variables

 boolean maximizeOrMinimize;

//   final boolean MAXIMIZE = true;
//  final boolean MINIMIZE = false;

  int[] basis; // basis[i] = basic variable corresponding to row i
 String [] names ;
    JPanel [] paneltable ;
  JScrollPane[]scroll ;
    JTextArea textarea ;
  double []x;
  String [] basicVar ;
  int p = 0 ;
  int flag ;
int flagmn ;
int count = 0 ;
    public Simplex_Output() {
//        initComponents();
                      

    }
     

 public Simplex_Output(double[][] tableaux, int numberOfConstraint,
   int numberOfOriginalVariable, boolean maximizeOrMinimize , int flagm) {
     
             initComponents();
             
             ImageIcon icon = new ImageIcon(getClass().getResource("/Images/ImageIcon.png"));
this.setIconImage(icon.getImage());
             
//             jPanel3.setLayout(new GridLayout(3,1,5,5));

numtable = 0 ;
flagmn = flagm ;
     System.out.println("f = "+flagmn);
  this.maximizeOrMinimize = maximizeOrMinimize;
  this.numberOfConstraints = numberOfConstraint;
  this.numberOfOriginalVariables = numberOfOriginalVariable;
  this.tableaux = tableaux;
  
  paneltable = new JPanel[30];
    scroll = new JScrollPane[30];
    
    basicVar = new String[numberOfConstraints+1]; 
  
  tablevalues = new String [numberOfConstraints + 1][numberOfOriginalVariables
     + numberOfConstraints + 1]; // 1
  
      tables = new JTable[30]; 
      
       names = new String[numberOfOriginalVariables+numberOfConstraints+1];//1
       
    int i ;
        for ( i = 0 ; i < numberOfOriginalVariables+numberOfConstraints; i++) {

            names[i] = "X"+(i+1) ;
        }
        names[i] = "  b" ;


  basis = new int[numberOfConstraints];
       x = new double[basis.length];

  for ( i = 0; i < numberOfConstraints; i++)
   basis[i] = numberOfOriginalVariables + i;

  solve();
  
  showw();
  
//     for (int j = 0; j < numberOfOriginalVariables+numberOfConstraints; j++) {
//           if(tableaux[numberOfConstraint][j] == 0 ){
//           count++;
//           }
//              
//     }
  
      
      
     for (int j = 0; j < numtable+1 ; j++) {
            jPanel3.add(paneltable[j]);

     }

  jPanel3.validate();
  
//  if(count>numberOfConstraint){
//           JOptionPane.showMessageDialog(null," Infeasible Solution ");
//           }
  
      System.out.println(numtable);
      
       
  
 }

 
 // run simplex algorithm starting from initial BFS
 public int unbounded(){
 
 return p ;
 
 
         }
 
// public int infeasible(){
// 
// return count ;
// }
// 
 
 public void solve() {
  while (true) {
  try{

   showw();
    }catch(Exception ec){

                    JOptionPane.showMessageDialog(null," Self Practise :) ");
                    break;

}
     int num = 0 ;
    for (int i = 0; i < numberOfOriginalVariables; i++) {

           if(flagmn == 1 && maximizeOrMinimize == true && tableaux[numberOfConstraints][i] < 0){
   
             maximizeOrMinimize = false ;
             num = 0 ;
                  break;
   }else
               if(flagmn == 1 && maximizeOrMinimize == false && tableaux[numberOfConstraints][i] > 0){
                            maximizeOrMinimize = true ;
                            num = 0 ;
                            break;
               }
               else{
               num = 1 ;
               }
      }
   
   int q = 0;
   // find entering column q
   if (maximizeOrMinimize) {
    q = dantzig();
   } else {
    q = dantzigNegative();
   }
   if (q == -1)
    break; // optimal

   // find leaving row p
    p = minRatioRule(q);
   if (p == -1){
//       JOptionPane.showMessageDialog(null,"Linear program is unbounded");
       break;
   }
//    throw new ArithmeticException("Linear program is unbounded");
   numtable+=1 ;

   // pivot
   pivot(p, q);

   // update basis
   basis[p] = q;
   
//   if(num == 1 && maximizeOrMinimize == true){
//       maximizeOrMinimize = false;
//       flagmn = 0 ;
//   }else
//   if(num == 1 && maximizeOrMinimize == false){
//   maximizeOrMinimize = true;
//       flagmn = 0 ;
//   }

    for (int i = 0; i < numberOfOriginalVariables; i++) {

           if(flagmn == 1 && maximizeOrMinimize == true && tableaux[numberOfConstraints][i] < 0){
   
             maximizeOrMinimize = false ;
             
                  break;
   }else
               if(flagmn == 1 && maximizeOrMinimize == false && tableaux[numberOfConstraints][i] > 0){
                            maximizeOrMinimize = true ;
                            
                            break;
               }
      }
   
   for (int j = 0; j < numberOfOriginalVariables+numberOfConstraints; j++){
       if(maximizeOrMinimize == true && tableaux[numberOfConstraints][j] > 0){
           flag = 1 ;
            break ;
   
   }else
           if(maximizeOrMinimize == false && tableaux[numberOfConstraints][j] < 0){
               flag = 1 ;
               break ;
                   }else{
           flag = 0 ;
           }
   }
   
   if(flag == 0)
       break;

  }
 }

 // index of a non-basic column with most positive cost
 public int dantzig() {
  int q = 0;
  for (int j = 1; j < numberOfConstraints + numberOfOriginalVariables; j++)
   if (tableaux[numberOfConstraints][j] > tableaux[numberOfConstraints][q])
    q = j;

  if (tableaux[numberOfConstraints][q] <= 0)
   return -1; // optimal
  else
   return q;
 }

 // index of a non-basic column with most negative cost
 public int dantzigNegative() {
  int q = 0;
  for (int j = 1; j < numberOfConstraints + numberOfOriginalVariables; j++)
   if (tableaux[numberOfConstraints][j] < tableaux[numberOfConstraints][q])
    q = j;

  if (tableaux[numberOfConstraints][q] >= 0)
   return -1; // optimal
  else
   return q;
 }

 // find row p using min ratio rule (-1 if no such row)
 public int minRatioRule(int q) {
  int p = -1;
  for (int i = 0; i < numberOfConstraints; i++) {
   if (tableaux[i][q] <= 0)
    continue;
   else if (p == -1)
    p = i;
   else if ((tableaux[i][numberOfConstraints
     + numberOfOriginalVariables] / tableaux[i][q]) < (tableaux[p][numberOfConstraints
     + numberOfOriginalVariables] / tableaux[p][q]))
    p = i;
  }
  return p;
 }

 // pivot on entry (p, q) using Gauss-Jordan elimination
 public void pivot(int p, int q) {

  // everything but row p and column q
  for (int i = 0; i <= numberOfConstraints; i++)
   for (int j = 0; j <= numberOfConstraints
     + numberOfOriginalVariables; j++)
    if (i != p && j != q)
     tableaux[i][j] -= tableaux[p][j] * tableaux[i][q]
       / tableaux[p][q];

  // zero out column q
  for (int i = 0; i <= numberOfConstraints; i++)
   if (i != p)
    tableaux[i][q] = 0.0;

  // scale row p
  for (int j = 0; j <= numberOfConstraints + numberOfOriginalVariables; j++)
   if (j != q)
    tableaux[p][j] /= tableaux[p][q];
  tableaux[p][q] = 1.0;
 }

 // return optimal objective value
 public double value() {
  return -tableaux[numberOfConstraints][numberOfConstraints+ numberOfOriginalVariables];
 }

 // return primal solution vector
 public double[] primal() {
  double[] x1 = new double[numberOfOriginalVariables];
  for (int i = 0; i < numberOfConstraints; i++)
   if (basis[i] < numberOfOriginalVariables)
    x1[basis[i]] = tableaux[i][numberOfConstraints
      + numberOfOriginalVariables];
  return x1;
 }

 // print tableaux
 public void showw() {
     DecimalFormat numberFormat = new DecimalFormat("#.00");
     
     paneltable[numtable]= new JPanel();
               paneltable[numtable].setLayout(new BorderLayout());


     
     if(numberOfConstraints !=0 && numberOfOriginalVariables !=0 ){
         
  System.out.println("M = " + numberOfConstraints);
  System.out.println("N = " + numberOfOriginalVariables);
  for (int i = 0; i <= numberOfConstraints; i++) {
   for (int j = 0; j <= numberOfConstraints
     + numberOfOriginalVariables; j++) {
    System.out.printf("%7.2f ", tableaux[i][j]);
    tablevalues[i][j] = numberFormat.format(tableaux[i][j]);
   }
   System.out.println();
  }
  System.out.println("value = " + value());
     textarea = new JTextArea("The Intial Solution = "+value()+"\n", numberOfOriginalVariables+1 , 20);

  int i ;
  for ( i = 0; i < numberOfConstraints; i++){
   if (basis[i] < numberOfOriginalVariables){
    System.out.println("x_"+ (basis[i]+1)+ " = "+ tableaux[i][numberOfConstraints+ numberOfOriginalVariables]);
   x[i] = tableaux[i][numberOfConstraints+ numberOfOriginalVariables];
   textarea.setText(textarea.getText() + "x"+ (basis[i]+1)+ " = "+ numberFormat.format(tableaux[i][numberOfConstraints+ numberOfOriginalVariables])+"\n");
   }
   
   basicVar[i] = "X"+(basis[i]+1) ;
  }
  
   basicVar[i] = "Cj-Zj";
  
//      System.out.println(numtable);
//      
//      for (int i = 0; i < names.length; i++) {
//
//          System.out.print(names[i]+"   ");
//     }
//      
//      for (int i = 0; i <= numberOfConstraints; i++) {
//   for (int j = 0; j <= numberOfConstraints
//     + numberOfOriginalVariables; j++) {
//    
//    tablevalues[i][j] = Double.toString(tableaux[i][j]);
//    
//    System.out.print(tablevalues[i][j]+"   ");
//   }
//   System.out.println();
//  }


  DefaultTableModel model = new DefaultTableModel(tablevalues, names){
        
        
         @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }
        
        
        }; 
  
  
model.addColumn("XB" , basicVar);
         
    
  tables[numtable] = new JTable(model);
  
  tables[numtable].moveColumn(tables[numtable].getColumnCount()-1, 0);
  tables[numtable].getTableHeader().setFont(new Font("Arial", Font.ITALIC, 16));
  tables[numtable].setFont(new Font("Arial", Font.PLAIN, 15));
  tables[numtable].setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
int index = 0;
                while (index < numberOfConstraints+numberOfOriginalVariables+2) {
                    TableColumn a = tables[numtable].getColumnModel().getColumn(index);
                    a.setPreferredWidth(150);
                    index++;
                }
                
 scroll[numtable] = new JScrollPane(tables[numtable], JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
 scroll[numtable].setPreferredSize(new Dimension(400 , 200));
 paneltable[numtable].add(scroll[numtable] , BorderLayout.CENTER);
 
textarea.setEditable(false);
             textarea.setFont(new Font("Serif", Font.ITALIC, 18));
textarea.setLineWrap(true);
textarea.setWrapStyleWord(true);

paneltable[numtable].add(textarea , BorderLayout.SOUTH);

// jPanel3.add(paneltable[numtable]);
jPanel3.setLayout(new GridLayout(numtable+1,1,5,5));

  System.out.println();
  
     }
     
    
     
 }

 // test client
// public void GetValues(double[] ObjFunc , double[][] leftside , double [] rightside , String objcase , String [] concase)  {
//
//  
//
//  
//   x = simplex.primal();
//  for (int i = 0; i < x.length; i++)
//   System.out.println("x[" + i + "] = " + x[i]);
//  System.out.println("Solution: " + simplex.value());
//  
// 
//
// }

 public enum Constraint {
  lessThan, equal, greatherThan
 }

 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Solution");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("The Result");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(0, 102, 102));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1004, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
