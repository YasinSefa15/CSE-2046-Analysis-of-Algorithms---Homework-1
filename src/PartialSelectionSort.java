import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class PartialSelectionSort {
    public static int count = 0;

    public static void main(String[] args){
        FileOperation fileOperation = new FileOperation();
        int kth = FileOperation.sortedVariablesList.size() / 4 * 1;
        for (int i = 0 ; i < FileOperation.inputSizes.length ; i++){
            FileOperation.inputSize = FileOperation.inputSizes[i];
            partialSelectionSort(FileOperation.sortedVariablesList,kth);

            System.out.println("input size : " + FileOperation.inputSize + " count: " + count);
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
