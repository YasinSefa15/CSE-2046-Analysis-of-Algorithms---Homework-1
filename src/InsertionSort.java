import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;


public class InsertionSort {
    static long count=0;


    static ArrayList<Integer> sortedArray;
    public static void main(String[] args){
        FileOperation fileOperation = new FileOperation();
        System.out.println("Sorted : ");
        for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
            count = 0;
            FileOperation.inputSize = FileOperation.inputSizes[j];
            FileOperation.inputList();
            System.out.println("Result Array : ");
            System.out.print(insertionSort(FileOperation.sortedVariablesList) + "\n");
            System.out.println("input size : " + FileOperation.inputSize + " | count: " + count + "\n");
        }
        System.out.println("\nReverse Array : ");
        for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
            count = 0;
            FileOperation.inputSize = FileOperation.inputSizes[j];
            FileOperation.inputList();
            insertionSort(FileOperation.reversedSortedVariablesList);
            System.out.println("Result Array : ");
            System.out.print(insertionSort(FileOperation.sortedVariablesList) + "\n");
            System.out.println("input size : " + FileOperation.inputSize + " | count: " + count + "\n");
        }
    }


    public static ArrayList<Integer> insertionSort(ArrayList<Integer> inputs){
        sortedArray = new ArrayList<Integer>();
           int temp=0;
           for (int i =1;i<=inputs.size()-1 ;i++){
               temp=inputs.get(i);
               int j=i-1;
               count++;
               while (j>=0 && inputs.get(j)>temp){
                   count++;
                   inputs.set(j+1,inputs.get(j));
                   j--;
               }
               inputs.set(j+1,temp);
           }
           sortedArray=inputs;
           return inputs;
    }
}
