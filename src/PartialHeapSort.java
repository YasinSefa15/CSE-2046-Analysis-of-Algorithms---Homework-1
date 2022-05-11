public class PartialHeapSort {
    public static long count;
    private static int[] Heap;//stands for the number of executions
    private static int size;

    public static void main(String[] arg)
    {
        FileOperation fileOperation = new FileOperation();//to use constructor in FileOperation created object
        int kth;
        System.out.println("\n------------------------------------------------------");
        System.out.println("Operation on RandomValuesArray : ");
        System.out.println("------------------------------------------------------");
        for (int i = 1 ; i < 4 ; i++){
            for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
                count = 0;
                FileOperation.inputSize = FileOperation.inputSizes[j];
                FileOperation.inputArray();
                Heap = FileOperation.randomVariablesArray;
                size = FileOperation.inputSize - 1;
                kth = FileOperation.randomVariablesArray.length / 4 * i;
                findHeapSort(kth);
                System.out.println("Result Array in RandomVariableArray: ");
                for (int k : Heap ){
                    System.out.print(k + " ");
                }
                System.out.println("\nKth element : " + Heap[0]);
                System.out.println("quarter : " + i + " | kth : " + kth +" | input size : " + FileOperation.inputSize + " | count: " + count + "\n");
            }
        }


        System.out.println("\n------------------------------------------------------");
        System.out.println("Operation on Sorted Array : ");
        System.out.println("------------------------------------------------------");
        for (int i = 1 ; i < 4 ; i++){
            for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
                count = 0;
                FileOperation.inputSize = FileOperation.inputSizes[j];
                FileOperation.inputArray();
                Heap = FileOperation.sortedVariablesArray;
                size = FileOperation.inputSize - 1;
                kth = FileOperation.sortedVariablesArray.length / 4 * i;
                findHeapSort(kth);
                System.out.println("Result Array in SortedVariableArray: ");
                for (int k : Heap ){
                    System.out.print(k + " ");
                }
                System.out.println("\nKth element : " + Heap[0]);
                System.out.println("quarter : " + i + " | kth : " + kth +" | input size : " + FileOperation.inputSize + " | count: " + count + "\n");
            }
        }

        System.out.println("------------------------------------------------------");
        System.out.println("\nOperation on ReverseSorted Array : ");
        System.out.println("------------------------------------------------------");
        for (int i = 1 ; i < 4 ; i++){
            for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
                count = 0;
                FileOperation.inputSize = FileOperation.inputSizes[j];
                FileOperation.inputArray();
                Heap = FileOperation.reversedSortedVariablesArray;
                size = FileOperation.inputSize - 1;
                kth = FileOperation.reversedSortedVariablesArray.length / 4 * i;
                findHeapSort(kth);
                System.out.println("Result Array in ReverseSortedVariableArray : ");
                for (int k : Heap ){
                    System.out.print(k + " ");
                }
                System.out.println("\nKth element : " + Heap[0]);

                System.out.println("quarter : " + i + " | kth " + kth +" | input size : " + FileOperation.inputSize + " | count: " + count + "\n");
            }
        }

    }

    private static int leftChild(int pos) { return  (2 * pos) + 1 > size ?  pos : (2 * pos) + 1 ; }

    private static int rightChild(int pos){ return (2 * pos) + 2 > size ?  pos : (2 * pos) + 2 ; }

    private static boolean isLeaf(int pos) { return pos > (size / 2) && pos <= size; }

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
