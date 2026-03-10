package se.lexicon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static void main(){

        IO.println("Hello and welcome!");

        //Exercise 1:
        IO.println(Arrays.toString(storePrintArray()));

        //Exercise 2:
        int[] indexArray = {12, 7, 5, 2, 8, 11};
        int returnedIndex = indexOf(indexArray);
        IO.println("Index position of "+indexArray[returnedIndex]+" is : "+returnedIndex);

        //Exercise3
        String[] strArray = {"Paris", "London", "New York", "Stockholm"};
        String sortedArray = sortStringArray(strArray);
        IO.println(Arrays.toString(strArray)+"\n"+sortedArray);

        //Exercise 4:
        int[] firstArray = {1, 15, 20, 35};
        IO.println(String.format("Elements from first array: %s \n" +
                        "Elements from second array: %s",
                Arrays.toString(firstArray), Arrays.toString(copyElementsInArray(firstArray))));

        //Exercise 5:
        String[][] twoDArray = twoDimensionalArray();
        IO.println(Arrays.deepToString(twoDArray));

        //Exercise 6:
        int[] numbers = { 43, 5, 23, 17, 2, 14};
        double average = findAverage(numbers);
        IO.println("Average is : "+ average);

        //Exercise 7:
        int[] numbersArray = {1, 2, 4,7, 9, 12};
        IO.println(String.format("Array : %s\nOdd Array : %s",
                Arrays.toString(numbersArray), Arrays.toString(findOddNumbersArray(numbersArray))));

        //Exercise 8:
        int[] numbersArray2 ={20, 20, 40, 20, 30, 40, 50, 60, 50};
        IO.println(String.format("Array : %s\nDistinct Array : %s",
                Arrays.toString(numbersArray2), Arrays.toString(removeDuplicates(numbersArray2))));

        //Exercise 9:


        //Exercise 10:
        int[] multipliers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[][] multiplicationTable = createMultiplicationTable(multipliers);
        for (int[] row : multiplicationTable) {
            for (int num : row) {
                IO.print(num+"\t");
            }
            IO.println();
        }

        //Exercise 11:
        reverseArray();
    }

    // This method stores elements in an array of type int and print it out.
    //Expected output: 11 23 39
    static int[] storePrintArray(){
        return new int[]{11, 23, 39, 45, 65, 73, 12};
    }

    //This method finds and returns the index of an element in the array or -1
    //Expected output: Index position of number 5 is: 2
    static int indexOf(int[] indexArray){

        for(int index : indexArray){
            if(index == 2){
                return index;
            }
        }
        return -1;
    }

    //This method will sort a string array.
    //Expected output:
    //String array: [Paris, London, New York, Stockholm]
    //Sorted string array: [London, New York, Paris, Stockholm]
    static String sortStringArray(String[] strArray){
        String[] arrayCopy = Arrays.copyOf(strArray, strArray.length);
        Arrays.sort(arrayCopy);
        return Arrays.toString(arrayCopy);
    }

    //This method will copy the elements of one array into another array.
    //Expected output:
    //Elements from first array: 1 15 20
    //Elements from second array: 1 15 20
    static int[] copyElementsInArray(int[] firstArray){
        int[] secondArray = new int[firstArray.length];
        System.arraycopy(firstArray, 0, secondArray, 0, firstArray.length);
        return secondArray;
    }

    // This method creates a two-dimensional string array [2][2]. Assign values containing any Country and City.
    //Expected output:
    //France Paris
    //Sweden Stockholm
    static String[][] twoDimensionalArray(){
        String[][] twoDArray = new String[2][2];

        twoDArray[0][0] = "France";
        twoDArray[0][1] = "Paris";
        twoDArray[1][0] = "Sweden";
        twoDArray[1][1] = "Stockholm";
        return twoDArray;
    }

    //This method returns the average of int array
    // Expected output: Average is: 17.3
    static double findAverage(int[] numbers){
        int sum = 0;
        for (int number : numbers) {
            sum = sum + number;
        }
        return (double) sum / numbers.length;
    }

    //This method will filter the uneven numbers from array based on condition.
    //Example:
    //Array: 1 2 4 7 9 12
    //Odd Array: 1 7 9
    static int[] findOddNumbersArray(int[] numbersArray){
        return Arrays.stream(numbersArray)
                .filter(n -> n % 2 != 0)
                .toArray();
    }

    //This method remove the duplicate elements of a given array [20, 20, 40, 20, 30, 40, 50, 60, 50].
    //Expected output:
    //Array: 20 20 40 20 30 40 50 60 50
    //Array without duplicates: 20 40 30 50 60
    static int[] removeDuplicates(int[] numbersArray){
        return Arrays.stream(numbersArray)
                .distinct()
                .toArray();
    }

    //This method will return multiplication table, stored in multidimensional array
    static int[][] createMultiplicationTable(int[] multipliers){
        int[][] multiplicationTable = new int[10][10];

        for (int row = 0; row< multipliers.length; row++){
            for (int column = 0; column<multipliers.length;column++){
                multiplicationTable[row][column] = (row+1)*(column+1);
            }
        }

        return multiplicationTable;
    }

    //This method will let the user decide array size,
    // Then take user inputs until fills the array and then reverse the array elements and print it.
    static void reverseArray(){

        IO.print("How many numbers you want to Enter: ");
        int arraySize = validateInt();

        Integer[] newArray = new Integer[arraySize];

        for(int i=0;i<newArray.length; i++){

            IO.print("Enter ["+(i+1)+"] number of "+arraySize+" Numbers: ");
            newArray[i] = validateInt();
        }
        IO.println("Original Array: "+Arrays.toString(newArray));
        Collections.reverse(Arrays.asList(newArray));
        IO.println("Reversed Array: "+Arrays.toString(newArray));
    }

    static int validateInt(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.print("Invalid! Please Enter Valid Number: ");
                scanner.next();
            }
        }
    }
}
