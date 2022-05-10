import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class PartialSelectionSort {
    public static long count = 0;
    static ArrayList<Integer> myList;

    public static void main(String[] args){
        FileOperation fileOperation = new FileOperation();
        int kth = 0;

        System.out.println("Sorted : ");
        for (int i = 1 ; i < 4 ; i++){
            for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
                count = 0;
                FileOperation.inputSize = FileOperation.inputSizes[j];
                FileOperation.inputList();
                kth = FileOperation.sortedVariablesList.size() / 4 * i;
                System.out.println("Sorted Result List : ");
                myList =  partialSelectionSort(FileOperation.sortedVariablesList,kth);
                for (int k : myList){
                    System.out.print(k + " ");
                }
                System.out.println("\nKth element : " + myList.get(kth));
                System.out.println("quarter : " + i + " | kth : " + kth +" | input size : " + FileOperation.inputSize + " | count: " + count + "\n");
            }
        }

        System.out.println("\n-------------------------------------------------\nReverse Array : \n");
        for (int i = 1 ; i < 4 ; i++){
            for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
                count = 0;
                FileOperation.inputSize = FileOperation.inputSizes[j];
                FileOperation.inputList();
                kth = FileOperation.reversedSortedVariablesList.size() / 4 * i;
                System.out.println("Reverse Sorted Result List : ");
                myList =  partialSelectionSort(FileOperation.reversedSortedVariablesList,kth);
                for (int k : myList){
                    System.out.print(k + " ");
                }
                System.out.println("\nKth element : " + myList.get(kth));
                System.out.println("quarter : " + i + " | kth : " + kth +" | input size : " + FileOperation.inputSize + " | count: " + count + "\n");
            }
        }


    }
    static ArrayList<Integer> partialSelectionSort(ArrayList<Integer> arr, int k) {
        for (int i = 0; i < k ; i++){
            int minIndex = 0;
            int minValue = (int) arr.get(i);
            for (int j = i+1 ; j < arr.size() ; j++){
                count++;
                if (arr.get(j) < minValue){
                    minIndex = j;
                    minValue = arr.get(j);
                    int temp = arr.get(minIndex);
                    arr.set(minIndex,arr.get(i));
                    arr.set(i,temp);
                }
            }
        }
        return arr;
    }
}
