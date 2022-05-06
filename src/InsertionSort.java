import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;


public class InsertionSort {
    static long count=0;
    static long innerCount;

    static ArrayList<Integer> sortedArray;
    public static void main(String[] args){
        FileOperation fileOperation = new FileOperation();
        insertionSort(FileOperation.sortedVariablesList);
        System.out.println(count + innerCount);
    }


    public static ArrayList<Integer> insertionSort(ArrayList<Integer> inputs){
        sortedArray = new ArrayList<Integer>();
           int temp=0;
           for (int i =1;i<=inputs.size()-1 ;i++){
               temp=inputs.get(i);
               int j=i-1;
               count++;
               while (j>=0 && inputs.get(j)>temp){
                   innerCount++;
                   inputs.set(j+1,inputs.get(j));
                   j--;
               }
               inputs.set(j+1,temp);
           }
           sortedArray=inputs;
           return inputs;
    }
}
