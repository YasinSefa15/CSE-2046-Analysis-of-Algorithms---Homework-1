import java.text.DecimalFormat;
import java.text.NumberFormat;

//part 6
public class UnsortedQuickSelect {
    static int count;
    public static void main(String[] args) {

        FileOperation fileOperation = new FileOperation();
        int[] array = FileOperation.randomVariablesArray;

        //index + 1
        int kPosition = 1;
        int length = array.length;

        if (kPosition > length) {
            System.out.println("Index out of bound");
        }
        else {
            long start = System.currentTimeMillis();
            System.out.println("K-th smallest element in array : " + kthSmallest(array, 0, length - 1, kPosition));

            NumberFormat formatter = new DecimalFormat("#0.00000");

            long end = System.currentTimeMillis();
            System.out.println();
            System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
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
