import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class PartialSelectionSort {

    public static void main(String[] args){
        FileOperation fileOperation = new FileOperation();
        long start = System.currentTimeMillis();
        System.out.println(partialSelectionSort(FileOperation.reversedSortedVariablesList,4));

        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println();
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");

    }
    static ArrayList<Integer> partialSelectionSort(ArrayList<Integer> arr, int k) {
        for (int i = 0; i < k ; i++){
            int minIndex = 0;
            int minValue = (int) arr.get(i);
            for (int j = i+1 ; j < arr.size() ; j++){
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
