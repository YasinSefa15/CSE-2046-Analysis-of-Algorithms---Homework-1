public class UnsortedQuickSelect {

    static int count;//stands for the number of executions

    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperation();//to use constructor in FileOperation created object
        int kth;

        ////****IMPORTANT NOTE : PRINTED MESSAGES ON THE LOOP CONSISTS OF RANDOM VALUES DOES NOT FIT THE CONSOLE****////
        ////****WE SUGGEST TO UNCOMMENT LINE 30 TO SEE RESULTS BELONG TO RANDOM VALUE LIST****////
        System.out.println("\n------------------------------------------------------");
        System.out.println("Operation on RandomValuesArray : ");
        System.out.println("------------------------------------------------------");
        for (int i = 1 ; i < 4 ; i++){
            for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
                count = 0;
                FileOperation.inputSize = FileOperation.inputSizes[j];
                FileOperation.inputArray();
                kth = FileOperation.sortedVariablesArray.length / 4 * i;
                System.out.println("Result Array in RandomVariableArray: ");
                kthSmallest(FileOperation.randomVariablesArray, 0, FileOperation.randomVariablesArray.length - 1, kth);
                for (int k : FileOperation.randomVariablesArray){
                    System.out.print(k + " ");
                }
                System.out.println("\nKth element : " + FileOperation.randomVariablesArray[kth - 1]);
                System.out.println("quarter : " + i + " | kth : " + kth +" | input size : " + FileOperation.inputSize + " | count: " + count + "\n");
            }
        }

        //System.exit(41);
        System.out.println("\n------------------------------------------------------");
        System.out.println("Operation on Sorted Array : ");
        System.out.println("------------------------------------------------------");
        for (int i = 1 ; i < 4 ; i++){
            for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
                count = 0;
                FileOperation.inputSize = FileOperation.inputSizes[j];
                FileOperation.inputArray();
                kth = FileOperation.sortedVariablesArray.length / 4 * i;
                System.out.println("Result Array in SortedVariableArray: ");
                kthSmallest(FileOperation.sortedVariablesArray, 0, FileOperation.sortedVariablesArray.length - 1, kth);
                for (int k : FileOperation.sortedVariablesArray){
                    System.out.print(k + " ");
                }
                System.out.println("\nKth element : " + FileOperation.sortedVariablesArray[kth - 1]);
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
                kth = FileOperation.reversedSortedVariablesArray.length / 4 * i;
                System.out.println("Result Array in ReverseSortedVariableArray : ");
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
