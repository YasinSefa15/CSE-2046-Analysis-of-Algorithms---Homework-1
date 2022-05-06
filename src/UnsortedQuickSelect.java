import java.text.DecimalFormat;
import java.text.NumberFormat;

//part 6
public class UnsortedQuickSelect {
    static int count;
    public static void main(String[] args) {

        FileOperation fileOperation = new FileOperation();

        //index + 1
        int kth = 1;

        int quarter = 1;
        for ( ; quarter < 4 ; quarter++){
            for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
                FileOperation.inputSize = FileOperation.inputSizes[j];
                FileOperation.inputArray();
                count = 0;
                kth = FileOperation.sortedVariablesArray.length / 4 * quarter;
                kthSmallest(FileOperation.sortedVariablesArray, 0, FileOperation.sortedVariablesArray.length - 1, kth);

                System.out.println("quarter : " + quarter + " kth " + kth + " input size : " + FileOperation.inputSize + " count: " + count);
            }
        }

    }

    public static int kthSmallest(int[] arr, int low, int high, int k) {
        int partition = partition(arr, low, high);

        if (partition == k - 1){
            return arr[partition];
        }
        else if (partition < k - 1){
            return kthSmallest(arr, partition + 1, high, k);
        }
        else{
            return kthSmallest(arr, low, partition - 1, k);
        }
    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low], pivotLoc = low;
        int lastMinIndex = low;
        for (int i = low ; i <= high ; i++){
            count++;
            if (arr[i] < pivot){
                lastMinIndex = i;
                int temp = arr[i];
                arr[i] = arr[pivotLoc];
                arr[pivotLoc] = temp;
                pivotLoc++;
            }
        }
        int temp = arr[lastMinIndex];
        arr[lastMinIndex] = arr[pivotLoc];
        arr[pivotLoc] = temp;

        return pivotLoc;
    }

}
