import java.text.DecimalFormat;
import java.text.NumberFormat;

//part 6
public class UnsortedQuickSelect {
    static int count;
    static int[] arr;
    public static void main(String[] args) {

        FileOperation fileOperation = new FileOperation();

        int kth = 1;

        int quarter = 1;
        /*for ( ; quarter < 4 ; quarter++){
            for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
                FileOperation.inputSize = FileOperation.inputSizes[j];
                FileOperation.inputArray();
                count = 0;
                kth = FileOperation.sortedVariablesArray.length / 4 * quarter;
                kthSmallest(FileOperation.sortedVariablesArray, 0, FileOperation.sortedVariablesArray.length - 1, kth);
                System.out.println();
                System.out.println("quarter : " + quarter + " kth " + kth + " input size : " + FileOperation.inputSize + " count: " + count);
            }
        }*/

        int kthValue = 0;

        System.out.println("Sorted : ");
        for (int i = 1 ; i < 4 ; i++){
            for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
                count = 0;
                FileOperation.inputSize = FileOperation.inputSizes[j];
                FileOperation.inputArray();
                kth = FileOperation.sortedVariablesArray.length / 4 * i;
                System.out.println("Partial Sorted Array List : ");
                kthSmallest(FileOperation.sortedVariablesArray, 0, FileOperation.sortedVariablesArray.length - 1, kth);
                for (int k : FileOperation.sortedVariablesArray){
                    System.out.print(k + " ");
                }
                System.out.println("\nKth element : " + FileOperation.sortedVariablesArray[kth - 1]);
                System.out.println("quarter : " + i + " | kth : " + kth +" | input size : " + FileOperation.inputSize + " | count: " + count + "\n");
            }
        }

        System.out.println("\n-------------------------------------------------\nReverse Array : \n");
        for (int i = 1 ; i < 4 ; i++){
            for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
                count = 0;
                FileOperation.inputSize = FileOperation.inputSizes[j];
                FileOperation.inputArray();
                kth = FileOperation.reversedSortedVariablesArray.length / 4 * i;
                System.out.println("Partial Sorted Array List : ");
                kthSmallest(FileOperation.reversedSortedVariablesArray, 0, FileOperation.reversedSortedVariablesArray.length - 1, kth);
                for (int k : FileOperation.reversedSortedVariablesArray){
                    System.out.print(k + " ");
                }
                System.out.println("\nKth element : " + FileOperation.reversedSortedVariablesArray[kth - 1]);
                System.out.println("quarter : " + i + " | kth : " + kth +" | input size : " + FileOperation.inputSize + " | count: " + count + "\n");
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
