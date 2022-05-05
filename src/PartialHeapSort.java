import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PartialHeapSort {

    private static int[] Heap;
    private static int size;
    private int maxsize;

    public static void main(String[] arg)
    {
        //BURAYI DÜZENLEYELİM

        FileOperation fileOperation = new FileOperation();
        Heap = FileOperation.randomVariablesArray;
        size = 0;
        //4'th smallest element

        long start = System.currentTimeMillis();
        findHeapSort(4);
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println();
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");

    }




    private int parent(int pos) { return (pos - 1) / 2; }

    private static int leftChild(int pos) { return (2 * pos) + 1; }


    private static int rightChild(int pos){ return (2 * pos) + 2; }


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
    }

    private static void maxHeapify(int pos)
    {
        if (isLeaf(pos))
            return;

        if (Heap[pos] < Heap[leftChild(pos)]
                || Heap[pos] < Heap[rightChild(pos)]) {

            if (Heap[leftChild(pos)]
                    > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    public void insert(int element)
    {
        Heap[size] = element;

        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
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
            System.out.println(extractMax());
        }
        System.out.println(k+"'th element : " + Heap[0]);
    }


}
