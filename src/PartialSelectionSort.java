import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class PartialSelectionSort {
    public static long count = 0;

    public static void main(String[] args){
        FileOperation fileOperation = new FileOperation();
        for (int j = 1 ; j < 4 ; j++){
            for (int i = 0 ; i < FileOperation.inputSizes.length ; i++){
                count = 0;
                FileOperation.inputSize = FileOperation.inputSizes[i];
                int kth = FileOperation.inputSize / 4 * j;
                FileOperation.inputList();
                partialSelectionSort(FileOperation.sortedVariablesList,kth);
                System.out.println("quarter : " + j + " kth " + kth + " input size : " + FileOperation.inputSize + " count: " + count);
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
