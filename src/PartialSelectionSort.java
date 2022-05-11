import java.util.ArrayList;

public class PartialSelectionSort {

    public static long count; //stands for the number of executions
    static ArrayList<Integer> myList;

    public static void main(String[] args){
        FileOperation fileOperation = new FileOperation();//to use constructor in FileOperation created object
        int kth = 0;

        ////****IMPORTANT NOTE : PRINTED MESSAGES ON THE LOOP CONSISTS OF RANDOM VALUES DOES NOT FIT THE CONSOLE****////
        ////****WE SUGGEST TO UNCOMMENT LINE 33 TO SEE RESULTS BELONG TO RANDOM VALUE LIST****////
        System.out.println("\n------------------------------------------------------");
        System.out.println("Operation on RandomValues List : ");
        System.out.println("------------------------------------------------------");
        for (int i = 1 ; i < 4 ; i++){
            for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
                count = 0;
                FileOperation.inputSize = FileOperation.inputSizes[j];
                FileOperation.inputList();
                kth = FileOperation.randomVariablesList.size() / 4 * i;
                System.out.println("Result List in RandomVariableList: ");
                myList =  partialSelectionSort(FileOperation.randomVariablesList,kth);
                for (int k : myList){
                    System.out.print(k + " ");
                }
                System.out.println("\nKth element : " + myList.get(kth));
                System.out.println("quarter : " + i + " | kth : " + kth +" | input size : " + FileOperation.inputSize + " | count: " + count + "\n");
            }
        }

        //System.exit(41);

        System.out.println("\n------------------------------------------------------");
        System.out.println("Operation on Sorted List : ");
        System.out.println("------------------------------------------------------");
        for (int i = 1 ; i < 4 ; i++){
            for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
                count = 0;
                FileOperation.inputSize = FileOperation.inputSizes[j];
                FileOperation.inputList();
                kth = FileOperation.sortedVariablesList.size() / 4 * i;
                System.out.println("Result List in SortedVariableList: ");
                myList =  partialSelectionSort(FileOperation.sortedVariablesList,kth);
                for (int k : myList){
                    System.out.print(k + " ");
                }
                System.out.println("\nKth element : " + myList.get(kth));
                System.out.println("quarter : " + i + " | kth : " + kth +" | input size : " + FileOperation.inputSize + " | count: " + count + "\n");
            }
        }

        System.out.println("------------------------------------------------------");
        System.out.println("\nOperation on ReverseSorted List : ");
        System.out.println("------------------------------------------------------");
        for (int i = 1 ; i < 4 ; i++){
            for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
                count = 0;
                FileOperation.inputSize = FileOperation.inputSizes[j];
                FileOperation.inputList();
                kth = FileOperation.reversedSortedVariablesList.size() / 4 * i;
                System.out.println("Result List in ReverseSortedVariableList : ");
                myList =  partialSelectionSort(FileOperation.reversedSortedVariablesList,kth);
                for (int k : myList){
                    System.out.print(k + " ");
                }
                System.out.println("\nKth element : " + myList.get(kth));
                System.out.println("quarter : " + i + " | kth : " + kth +" | input size : " + FileOperation.inputSize + " | count: " + count + "\n");
            }
        }


    }
    static ArrayList<Integer> partialSelectionSort(ArrayList<Integer> arr, int k) {
        int minIndex = 0;
        for (int i = 0; i < k ; i++){
            minIndex = 0;
            int minValue =  arr.get(i);
            for (int j = i+1 ; j < arr.size() ; j++){
                count++;
                if (arr.get(j) < minValue){
                    minIndex = j;
                    minValue = arr.get(j);
                    int temp = arr.get(minIndex);
                    arr.set(minIndex,arr.get(i));
                    arr.set(i,temp);
                }
            }
        }
        return arr;
    }
}
