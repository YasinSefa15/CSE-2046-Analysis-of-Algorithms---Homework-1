import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
public class MergeSort {
    public static int count = 0;

    public static void main (String[] args){
        FileOperation fileOperation = new FileOperation();
        //long start = System.nanoTime();

        Instant start = Instant.now();
        System.out.println(mergeSort(FileOperation.randomVariablesList,0,FileOperation.randomVariablesList.size() - 1));

        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));


        System.exit(44);
        //long end = System.nanoTime() - start;


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
            L.add(A.get(l+i));
        }
        for(j = 0; j < n2; j++) {
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
            A.set(k, L.get(i));
            i++;k++;
        }
        while(j < n2) {
            A.set(k, R.get(j));
            j++;k++;
        }

    }

    public static void printList(ArrayList<Integer> A) {
        for(int i = 0; i < A.size(); i++) {
            System.out.print(A.get(i) + " ");
        }
    }
    public static void findMerge(ArrayList<Integer> A, int k) {

        System.out.println("\n" + A.get(k));
        System.out.println("count: " + count);
    }
}
