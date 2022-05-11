import java.io.*;
import java.util.ArrayList;
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



    public FileOperation()  { //constructor
        inputSizes = new int[]{1000,2000,5000,10000,15000}; //defines the input sizes
        inputSize = 1000;
        inputList();
        inputArray();
    }

    //updates the arrays with inputs
    static void inputArray(){
        randomVariablesArray = new int[inputSize];
        sortedVariablesArray = new int[inputSize];
        reversedSortedVariablesArray = new int[inputSize];

        Scanner input;
        int value = 0;
        int lineCount = 0;
        int index = 0;
        try {
            FileInputStream fis = new FileInputStream("input" + inputSize +".txt"); //dynamic input file
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
                    if (lineCount == 0){ // add to proper array
                        randomVariablesArray[index] = value;
                    }else if(lineCount == 1){
                        sortedVariablesArray[index] = value;
                    }else {
                        reversedSortedVariablesArray[index] = value;
                    }
                    index++;
                }
                index = 0; //stands for the line number. first, second etc.
                lineCount++;
            }
            input.close();
        }
        catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    //updates the lists with input
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

            input.close();
        }
        catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


}
