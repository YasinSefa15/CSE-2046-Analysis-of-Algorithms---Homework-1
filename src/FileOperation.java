import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FileOperation {

    static ArrayList<Integer> randomVariablesList;
    static ArrayList<Integer> sortedVariablesList;
    static ArrayList<Integer> reversedSortedVariablesList;
    static int[] randomVariablesArray;
    static int[] sortedVariablesArray;
    static int[] reversedSortedVariablesArray;
    static int[] inputSizes; //will show the all input sizes
    static int inputSize; // shows which input we are working on depending on the size

/*    public static void main(String[] args){
        //inputSizes = new int[]{1000,2000,5000,10000,33001,50000,75000,100000};
        inputSizes = new int[]{20000};
        fileWrite();
    }*/

    public FileOperation()  {
        //inputSizes = new int[]{7500};
        //fileWrite();
        inputSizes = new int[]{1000,2000,5000,10000,15000};
        inputSize = 1000;
        inputList();
        inputArray();
    }

    static void inputArray(){
        randomVariablesArray = new int[inputSize];
        sortedVariablesArray = new int[inputSize];
        reversedSortedVariablesArray = new int[inputSize];

        Scanner input;
        int value = 0;
        int lineCount = 0;
        int index = 0;
        try {
            FileInputStream fis = new FileInputStream("input" + inputSize +".txt");
            input = new Scanner(fis);
            while(input.hasNextLine()) {
                String line = input.nextLine();
                int startingIndex = -1;
                int nextIndex = line.indexOf("-");

                while (nextIndex > 0){

                    if (!line.substring(startingIndex+1).contains("-")){ //read the last value
                        value = Integer.parseInt(line.substring(startingIndex + 1));
                        startingIndex = nextIndex;
                        nextIndex = line.substring(startingIndex+1).indexOf("-");
                    }
                    else if (line.substring(startingIndex+1).contains("-")){
                        value = Integer.parseInt(line.substring(startingIndex + 1, nextIndex));
                        startingIndex = nextIndex;
                        nextIndex = nextIndex + 1 + line.substring(nextIndex+1).indexOf("-");
                    }
                    if (lineCount == 0){ // add to randomVariablesList
                        randomVariablesArray[index] = value;
                    }else if(lineCount == 1){
                        sortedVariablesArray[index] = value;
                    }else {
                        reversedSortedVariablesArray[index] = value;
                    }
                    index++;
                }
                index = 0;
                lineCount++;
            }
           /* System.out.println("random : ");
            for (int i = 0 ; i < randomVariablesArray.length ; i++ ){
                System.out.print(randomVariablesArray[i] + " ");
            }
            System.out.println("\nsorted : ");
            for (int i = 0 ; i < sortedVariablesArray.length ; i++ ){
                System.out.print(sortedVariablesArray[i] + " ");
            }
            System.out.println("\nreversed : ");
            for (int i = 0 ; i < reversedSortedVariablesArray.length ; i++ ){
                System.out.print(reversedSortedVariablesArray[i] + " ");
            }*/
            input.close();
        }
        catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static void inputList(){
        randomVariablesList = new ArrayList<>();
        sortedVariablesList = new ArrayList<>();
        reversedSortedVariablesList = new ArrayList<>();
        Scanner input;
        int value = 0;
        int lineCount = 0;
        try {
            FileInputStream fis = new FileInputStream("input" + inputSize +".txt");
            input = new Scanner(fis);
            while(input.hasNextLine()) {
                String line = input.nextLine();
                int startingIndex = -1;
                int nextIndex = line.indexOf("-");

                while (nextIndex > 0){
                    if (!line.substring(startingIndex+1).contains("-")){ //read the last value
                        value = Integer.parseInt(line.substring(startingIndex + 1));
                        startingIndex = nextIndex;
                        nextIndex = line.substring(startingIndex+1).indexOf("-");
                    }
                    else if (line.substring(startingIndex+1).contains("-")){
                        value = Integer.parseInt(line.substring(startingIndex + 1, nextIndex));
                        startingIndex = nextIndex;
                        nextIndex = nextIndex + 1 + line.substring(nextIndex+1).indexOf("-");
                    }
                    if (lineCount == 0){ // add to randomVariablesList
                        randomVariablesList.add(value);
                    }else if(lineCount == 1){
                        sortedVariablesList.add(value);
                    }else {
                        reversedSortedVariablesList.add(value);
                    }
                }
                    lineCount++;
            }
          /*  System.out.println("random : ");
            for (int i = 0 ; i < randomVariablesList.size() ; i++ ){
                System.out.print(randomVariablesList.get(i) + " ");
            }
            System.out.println("\nsorted : ");
            for (int i = 0 ; i < sortedVariablesList.size() ; i++ ){
                System.out.print(sortedVariablesList.get(i) + " ");
            }
            System.out.println("\nreversed : ");
            for (int i = 0 ; i < reversedSortedVariablesList.size() ; i++ ){
                System.out.print(reversedSortedVariablesList.get(i) + " ");
            }*/
            input.close();
        }
        catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    public static void fileWrite() {
        try {
            ArrayList<Integer> values = new ArrayList<>();
            ArrayList<Integer> ascendingSort = new ArrayList<>();
            String filename = "";
            FileWriter fw;
            for (int i = 0 ; i < inputSizes.length ; i++ ){
                values = createRandomVariables(inputSizes[i]);
                filename = "input" + inputSizes[i] + ".txt";
                fw = new FileWriter(filename,true);

                for (int j = 0 ; j < values.size() ; j++){
                    if (j != values.size() - 1){
                        fw.write(values.get(j) + "-");
                    }else{
                        fw.write("" +values.get(j));
                    }
                    if (j == values.size() -1 ){
                        fw.write("\n");
                    }
                }
                ascendingSort = MergeSort.mergeSort(values,0,values.size() -1);
                for (int j = 0 ; j < ascendingSort.size() ; j++){
                    if (j != values.size() - 1){
                        fw.write(ascendingSort.get(j) + "-");
                    }else{
                        fw.write("" + ascendingSort.get(j));
                    }
                    if (j == ascendingSort.size() -1 ){
                        fw.write("\n");
                    }
                }
                for (int j = ascendingSort.size() - 1 ; j >= 0 ; j--){
                    if (j != 0){
                        fw.write(ascendingSort.get(j) + "-");
                    }else{
                        fw.write("" +ascendingSort.get(j));
                    }
                }
                fw.close();
            }
        }catch (Exception e){
            System.out.println("Problem reading the file");
            System.exit(1);
        }

    }

    static ArrayList<Integer> createRandomVariables(int range){
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 0 ; i < range ; i++){
            inputs.add(rand.nextInt(range + 1));
        }
        return inputs;
    }
}
