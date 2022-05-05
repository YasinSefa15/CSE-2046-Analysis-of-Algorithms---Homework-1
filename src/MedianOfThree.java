import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MedianOfThree {
    private static int []a;
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperation();
        a = FileOperation.randomVariablesArray;
        long start = System.currentTimeMillis();
        sort();
        long end = System.currentTimeMillis();

        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println();
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }

    // This method sorts an array and internally calls quickSort
    public static void sort(){
        int left = 0;
        int right = a.length-1;

        quickSort(left, right);
    }

    // This method is used to sort the array using quicksort algorithm.
    // It takes left and the right end of the array as two cursors
    private static void quickSort(int left,int right){
        // If both cursor scanned the complete array, quicksort exits
        if(left >= right)
            return;

        // Pivot using median of 3 approach
        int pivot = getMedian(left, right);
        int partition = partition(left, right, pivot);

        // Recursively, calls the quicksort with the different left and right parameters of the sub-array
        quickSort(0, partition-1);
        quickSort(partition+1, right);
    }

    // This method is used to partition the given array and returns the integer which points to the sorted pivot index
    private static int partition(int left,int right,int pivot){
        int leftCursor = left-1;
        int rightCursor = right;
        while(leftCursor < rightCursor){
            while(a[++leftCursor] < pivot);
            while(rightCursor > 0 && a[--rightCursor] > pivot);
            if(leftCursor >= rightCursor){
                break;
            }else{
                swap(leftCursor, rightCursor);
            }
        }
        swap(leftCursor, right);
        return leftCursor;
    }

    public static int getMedian(int left,int right){
        int center = (left+right)/2;

        if(a[left] > a[center])
            swap(left,center);

        if(a[left] > a[right])
            swap(left, right);

        if(a[center] > a[right])
            swap(center, right);

        swap(center, right);
        return a[right];
    }

    // This method is used to swap the values between the two given index
    public static void swap(int left,int right){
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

}
