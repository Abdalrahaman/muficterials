package OR1_DEA;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DEA {

    String[] objects;
    String[] inoutputs;
                        double[][] effx ; 


//        String[] data = {"hsh","njk","kknkj","jkjbkj"};
    private int obj;
    private int out;
    private int in;
    
    Map<String, Object[]> outputArrays;
    Map<String, Object[]> inputArrays;
    Map<String, Object[]> effArrays;

    public DEA() {
     
//                effx = new double[3];

    }

    public void DEAalgo(int Noofobjects, int Noofoutput, int Noofinput) {
        this.obj = Noofobjects;
        this.out = Noofoutput;
        this.in = Noofinput;
        effx = new double[obj][out*in];
        objects = new String[Noofobjects];
        inoutputs = new String[(Noofinput + Noofoutput)]; 
        int c = 0;
// Naming arrays for inputs        
        inputArrays = new HashMap<String, Object[]>();
        for (int i = 0; i < Noofinput; i++) {
            //This is going to be the name of your new array
            String arrayName = String.valueOf("Input" + (i + 1));
            //Map an new int[] to this name
            inputArrays.put(arrayName, new Object[Noofobjects]);
            inoutputs[c] = arrayName;
            c++;
        }

//naming arrays for outputs
        outputArrays = new HashMap<String, Object[]>();
        for (int i = 0; i < Noofoutput; i++) {
            //This is going to be the name of your new array
            String arrayName = String.valueOf("Output" + (i + 1));
            //Map an new int[] to this name
            outputArrays.put(arrayName, new Object[Noofobjects]);
            inoutputs[c] = arrayName;
            c++;
        }

        int Noofeff = Noofinput * Noofoutput;
        effArrays = new HashMap<String, Object[]>();
        for (int i = 0; i < Noofeff; i++) {
            //This is going to be the name of your new array
            String arrayName = String.valueOf(i);
            //Map an new int[] to this name
            effArrays.put(arrayName, new Object[Noofobjects]);
        }
    }
//getting inpyt & output arrays

    public void algo(double[] outputx , double[] inputx ,int i) {
//        for (int i = 0; i < this.in; i++) {
//            for (int j = 0; j < this.out; j++) {
//                 outputx = outputArrays.get(i);  // what !!!!!
//                outputx = new Object[this.obj];
//                 inputx = inputArrays.get(j);
//                inputx = new Object[this.obj];
 
//                System.out.println("enter the output");
//                for (int k = 0; k < this.obj; k++) {
//
//                    outputx[k] = userinputs.nextInt();
//                }
//                System.out.println("enter the input");
//
//                for (int k = 0; k < this.obj; k++) {
//
//                    inputx[k] = userinputs.nextInt();
//                }

            
        

                    for (int k = 0; k < obj ; k++) {

                        effx[k][i] = outputx[k] / inputx[k];

//                        System.out.println(effx[k]);
                    }

              

            }

//        }
//    }

    
    public double[][] Points(){
        
        for (int i = 0; i < in*out; i++) {
            for (int j = 0; j < objects.length; j++) {
                System.out.println(effx[j][i]);
            }
            
        }
    
    return effx ;
    }
}
