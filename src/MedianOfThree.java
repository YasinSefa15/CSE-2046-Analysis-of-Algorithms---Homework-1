public class MedianOfThree {
    public static long count;//stands for the number of executions

    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperation();//to use constructor in FileOperation created object

        System.out.println("\n------------------------------------------------------");
        System.out.println("Operation on RandomValuesArray : ");
        System.out.println("------------------------------------------------------");
        for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
            count = 0;
            FileOperation.inputSize = FileOperation.inputSizes[j];
            FileOperation.inputArray();
            quickSort(FileOperation.randomVariablesArray);
            System.out.println("Result Array in RandomVariableArray: ");
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
            quickSort(FileOperation.sortedVariablesArray);
            System.out.println("Result Array in SortedVariableArray: ");
            for (int k : FileOperation.sortedVariablesArray ){
                System.out.print(k + " ");
            }
            System.out.println("\ninput size : " + FileOperation.inputSize + " | count: " + count + "\n");
        }

        System.out.println("------------------------------------------------------");
        System.out.println("\nOperation on ReverseSorted Array : ");
        System.out.println("------------------------------------------------------");
        for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
            count = 0;
            FileOperation.inputSize = FileOperation.inputSizes[j];
            FileOperation.inputArray();
            quickSort(FileOperation.reversedSortedVariablesArray);
            System.out.println("Result Array in ReverseSortedVariableArray : ");
            for (int k : FileOperation.reversedSortedVariablesArray ){
                System.out.print(k + " ");
            }

            System.out.println("\ninput size : " + FileOperation.inputSize + " | count: " + count + "\n");
        }
    }



    public static void quickSort(int[] intArray) {
        recQuickSort(intArray, 0, intArray.length - 1);
    }

    public static void recQuickSort(int[] intArray, int left, int right) {
        count++;
        int size = right - left + 1;
        if (size <= 3)
            manualSort(intArray, left, right);
        else {
            double median = medianOf3(intArray, left, right);
            int partition = partitionIt(intArray, left, right, median);
            recQuickSort(intArray, left, partition - 1);
            recQuickSort(intArray, partition + 1, right);
        }
    }

    public static int medianOf3(int[] intArray, int left, int right) {
        count++;
        int center = (left + right) / 2;

        if (intArray[left] > intArray[center])
            swap(intArray, left, center);

        if (intArray[left] > intArray[right])
            swap(intArray, left, right);

        if (intArray[center] > intArray[right])
            swap(intArray, center, right);

        swap(intArray, center, right - 1);
        return intArray[right - 1];
    }

    public static void swap(int[] intArray, int dex1, int dex2) {
        count++;
        int temp = intArray[dex1];
        intArray[dex1] = intArray[dex2];
        intArray[dex2] = temp;
    }

    public static int partitionIt(int[] intArray, int left, int right, double pivot) {
        count++;
        int leftPtr = left;
        int rightPtr = right - 1;

        while (true) {
            while (intArray[++leftPtr] < pivot){
                count++;
            };
            while (intArray[--rightPtr] > pivot){
                count++;
            };
            if (leftPtr >= rightPtr)
                break;
            else
                swap(intArray, leftPtr, rightPtr);
        }
        swap(intArray, leftPtr, right - 1);
        return leftPtr;
    }

    public static void manualSort(int[] intArray, int left, int right) {
        count++;
        int size = right - left + 1;
        if (size <= 1)
            return;
        if (size == 2) {
            if (intArray[left] > intArray[right])
                swap(intArray, left, right);
            return;
        } else {
            if (intArray[left] > intArray[right - 1])
                swap(intArray, left, right - 1);
            if (intArray[left] > intArray[right])
                swap(intArray, left, right);
            if (intArray[right - 1] > intArray[right])
                swap(intArray, right - 1, right);
        }
    }


}
