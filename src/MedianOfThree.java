import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MedianOfThree {
    private static int []a;
    public static long count;
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperation();
        a = FileOperation.randomVariablesArray;

        //index + 1
        int kth = 1;
        count = 0;
        sort();
        System.exit(66);
        for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
            FileOperation.inputSize = FileOperation.inputSizes[j];
            sort();

            System.out.println("input size : " + FileOperation.inputSize + " count: " + count);
        }
    }

    // This method sorts an array and internally calls quickSort
    public static void sort(){
        System.out.println("sort");
        int left = 0;
        int right = a.length-1;

        quickSort(left, right);
    }

    // This method is used to sort the array using quicksort algorithm.
    // It takes left and the right end of the array as two cursors
    private static void quickSort(int left,int right){
        count++;
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
        int c1 = 0,c2 = 0;
        int leftCursor = left-1;
        int rightCursor = right;
        while(leftCursor < rightCursor){
            while(a[++leftCursor] < pivot){
            c1++;
                };
            while(rightCursor > 0 && a[--rightCursor] > pivot){
            c2++;
            };
            if(leftCursor >= rightCursor){
                break;
            }else{
                swap(leftCursor, rightCursor);
            }
        }
        swap(leftCursor, right);
        count=c1+c2;
        return leftCursor;
    }

    public static int getMedian(int left,int right){
        int center = (left+right)/2;
        count++;
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
        count++;
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

}
