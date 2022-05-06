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
        System.out.println(FileOperation.sortedVariablesList.size());
        for ( ; quarter < 4 ; quarter++){
            kth = FileOperation.sortedVariablesArray.length / 4 * quarter;
            for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
                FileOperation.inputSize = FileOperation.inputSizes[j];
                kthSmallest(FileOperation.reversedSortedVariablesArray, 0, FileOperation.sortedVariablesArray.length - 1, kth);

                System.out.println("quarter : " + quarter + " input size : " + FileOperation.inputSize + " count: " + count);
            }
        }
        //System.out.println("K-th smallest element in array : " + kthSmallest(array, 0, length - 1, kPosition));


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
