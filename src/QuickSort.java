import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
public class QuickSort {
    static int[] arr;
    public static int count;
    public static void main(String[] args)
    {
        FileOperation fileOperation = new FileOperation();
        arr = FileOperation.randomVariablesArray;
        int n = arr.length;

        System.out.println("heyy");
        int kth = 400;

        long start = System.currentTimeMillis();
        quickSort(arr, 0, n - 1);
        long end = System.currentTimeMillis();


        NumberFormat formatter = new DecimalFormat("#0.00000");

        System.out.println();
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
        System.out.println("Sorted array: ");
        //printArray(arr, n);
        System.out.println(arr[kth]);
        printArray(arr,arr.length);
    }

    static void swap(int[] arr, int i, int j)
    {
        count++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr, int low, int high)
    {

        // pivot
        int pivot = arr[high];
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {
            count++;
            if (arr[j] < pivot)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] arr, int low, int high)
    {
        count++;
        if (low < high)
        {
 
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    static void printArray(int[] arr, int size)
    {
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Driver Code

}
