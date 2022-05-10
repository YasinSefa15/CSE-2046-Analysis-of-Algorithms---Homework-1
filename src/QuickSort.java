import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class QuickSort {
    public static int count;

    public static void main(String[] args) throws InterruptedException {
        FileOperation fileOperation = new FileOperation();


        System.out.println("\n------------------------------------------------------");
        System.out.println("Operation on RandomValuesArray : ");
        System.out.println("------------------------------------------------------");
        for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
            count = 0;
            FileOperation.inputSize = FileOperation.inputSizes[j];
            FileOperation.inputArray();
            System.out.println("Result Array in RandomVariableArray: ");
            quickSort(FileOperation.randomVariablesArray, 0, FileOperation.randomVariablesArray.length - 1);
            for (int k : FileOperation.randomVariablesArray ){
                System.out.print(k + " ");
            }
            System.out.println("\ninput size : " + FileOperation.inputSize + " | count: " + count + "\n");
        }


        System.out.println("\n------------------------------------------------------");
        System.out.println("Operation on Sorted Array : ");
        System.out.println("------------------------------------------------------");
        for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
            count = 0;
            FileOperation.inputSize = FileOperation.inputSizes[j];
            FileOperation.inputArray();
            quickSort(FileOperation.sortedVariablesArray, 0, FileOperation.randomVariablesArray.length - 1);
            System.out.println("Result Array in SortedVariableArray: ");
            for (int k : FileOperation.sortedVariablesArray ){
                System.out.print(k + " ");
            }
            System.out.println("\ninput size : " + FileOperation.inputSize + " count: " + count + "\n");
        }

        System.out.println("------------------------------------------------------");
        System.out.println("\nOperation on ReverseSorted Array : ");
        System.out.println("------------------------------------------------------");
        for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
            count = 0;
            FileOperation.inputSize = FileOperation.inputSizes[j];
            FileOperation.inputArray();
            quickSort(FileOperation.reversedSortedVariablesArray, 0, FileOperation.randomVariablesArray.length - 1);//System.out.println(arr[kth]);
            System.out.println("Result Array in ReverseSortedVariableArray : ");
            for (int k : FileOperation.reversedSortedVariablesArray ){
                System.out.print(k + " ");
            }

            System.out.println("\ninput size : " + FileOperation.inputSize + " count: " + count + "\n");
        }
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

}
