import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;


public class InsertionSort {
    static int time=0;

    static ArrayList<Integer> sortedArray;
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        FileOperation fileOperation = new FileOperation();
        System.out.println(InsertionSort(FileOperation.sortedVariablesList));
        long end = System.currentTimeMillis();

        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println();
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }


    public static ArrayList<Integer> InsertionSort(ArrayList<Integer> inputs){
        sortedArray = new ArrayList<Integer>();
           int temp=0;
           for (int i =1;i<=inputs.size()-1 ;i++){
               temp=inputs.get(i);
               int j=i-1;
               while (j>=0 && inputs.get(j)>temp){
                   inputs.set(j+1,inputs.get(j));
                   j--;
                   time++;
               }
               inputs.set(j+1,temp);
           }
           sortedArray=inputs;
           return inputs;
    }
    public void Find(int index){
         System.out.println("The "+index+". element is "+sortedArray.get(index)+" in Insertion Sort.");
         System.out.println("The time is "+time);
    }
}
