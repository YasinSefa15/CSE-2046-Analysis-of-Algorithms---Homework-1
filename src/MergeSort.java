import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
public class MergeSort {
    public static long count = 0;

    public static void main (String[] args){
        FileOperation fileOperation = new FileOperation();

        System.out.println("Sorted : ");
        for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
            count = 0;
            FileOperation.inputSize = FileOperation.inputSizes[j];
            FileOperation.inputList();
            System.out.println("Result List : ");
            System.out.println(mergeSort(FileOperation.sortedVariablesList,0,FileOperation.sortedVariablesList.size() - 1));
            System.out.println("input size : " + FileOperation.inputSize + " | count: " + count + "\n");
        }

        System.out.println("\n-------------------------------------------------\nReverse Array : \n");
        for (int j = 0 ; j < FileOperation.inputSizes.length ; j++){
            count = 0;
            FileOperation.inputSize = FileOperation.inputSizes[j];
            FileOperation.inputList();
            System.out.println("Result List : ");
            System.out.println(mergeSort(FileOperation.reversedSortedVariablesList,0,FileOperation.sortedVariablesList.size() - 1));
            System.out.println("input size : " + FileOperation.inputSize + " | count: " + count + "\n");
        }
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> A, int l, int r) {
        if(l < r) {
            int m = l+(r-l)/2;

            mergeSort(A,l,m);
            mergeSort(A,m+1,r);
            Merge(A,l,m,r);
        }
        return A;
    }


    public static void Merge(ArrayList<Integer> A, int l, int m, int r) {
        int i,j,k;
        int n1 = m - l + 1;
        int n2 = r - m;
        ArrayList<Integer> L = new ArrayList<Integer>();
        ArrayList<Integer> R = new ArrayList<Integer>();

        for(i = 0; i < n1; i++) {
            count++;
            L.add(A.get(l+i));
        }
        for(j = 0; j < n2; j++) {
            count++;
            R.add(A.get(m+1+j));
        }
        i=0;j=0;k=l;
        while(i < n1 && j < n2) {
            count++;
            if(L.get(i) <= R.get(j)) {
                A.set(k, L.get(i));
                i++;
            }
            else {
                A.set(k,R.get(j));
                j++;
            }
            k++;
        }
        while(i < n1) {
            count++;
            A.set(k, L.get(i));
            i++;k++;
        }
        while(j < n2) {
            count++;
            A.set(k, R.get(j));
            j++;k++;
        }

    }
}
