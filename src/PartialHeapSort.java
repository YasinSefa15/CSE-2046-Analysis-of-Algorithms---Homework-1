import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PartialHeapSort {
    //EKSİK
    public static long count;
    private static int[] Heap;
    private static int size;
    private int maxsize;

    public static void main(String[] arg)
    {
        FileOperation fileOperation = new FileOperation();

        int kth = 0;

        System.out.println("Sorted : ");
        for (int i = 1 ; i < 4 ; i++){
            for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
                count = 0;
                FileOperation.inputSize = FileOperation.inputSizes[j];
                FileOperation.inputArray();
                Heap = FileOperation.sortedVariablesArray;
                size = FileOperation.inputSize - 1;
                kth = FileOperation.sortedVariablesArray.length / 4 * i;
                findHeapSort(kth);
                System.out.println("Result Array : ");
                for (int k : Heap ){
                    System.out.print(k + " ");
                }
                System.out.println("\nKth element : " + Heap[kth]);
                System.out.println("quarter : " + i + " | kth : " + kth +" | input size : " + FileOperation.inputSize + " | count: " + count + "\n");
            }
        }

        System.out.println("\n-------------------------------------------------\nReverse Array : \n");
        for (int i = 1 ; i < 4 ; i++){
            for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
                count = 0;
                FileOperation.inputSize = FileOperation.inputSizes[j];
                FileOperation.inputArray();
                Heap = FileOperation.reversedSortedVariablesArray;
                size = FileOperation.inputSize - 1;
                kth = FileOperation.reversedSortedVariablesArray.length / 4 * i;
                findHeapSort(kth);
                System.out.println("Result Array : ");
                for (int k : Heap ){
                    System.out.print(k + " ");
                }
                System.out.println("\nKth element : " + Heap[kth]);

                System.out.println("quarter : " + i + " | kth " + kth +" | input size : " + FileOperation.inputSize + " | count: " + count + "\n");
            }
        }

    }




    private int parent(int pos) { return (pos - 1) / 2; }

    private static int leftChild(int pos) { return  (2 * pos) + 1 > size ?  pos : (2 * pos) + 1 ; }


    private static int rightChild(int pos){

        return (2 * pos) + 2 > size ?  pos : (2 * pos) + 2 ; }


    private static boolean isLeaf(int pos)
    {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private static void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
        count++;
    }

    private static void maxHeapify(int pos)
    {
        count++;
        if (isLeaf(pos))
            return;

        if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {

            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }



    public static int extractMax()
    {
        int popped = Heap[0];
        Heap[0] = Heap[size--];
        maxHeapify(0);
        return popped;
    }

    public static void findHeapSort(int k) {
        int length = size;
        for(int i = 0; i < length - k; i++) {
            extractMax();
        }
        //System.out.println(k+"'th element : " + Heap[0]);
    }


}
