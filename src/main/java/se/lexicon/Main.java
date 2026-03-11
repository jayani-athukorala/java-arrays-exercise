package se.lexicon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static void main(){

        IO.println("==========Hello and welcome!============");
        //Exercise 1:
        IO.println("Exercise 1: Store elements in an array of type int and print it out.");
        IO.println(Arrays.toString(storePrintArray()));
        IO.println("----------------------------------------\n");

        //Exercise 2:
        IO.println("Exercise 2: Create a method 'indexOf' which will find and return the index of an array element");
        int[] indexArray = {12, 7, 5, 2, 8, 11};
        int returnedIndex = indexOf(indexArray);
        IO.println("Index position of "+indexArray[returnedIndex]+" is : "+returnedIndex);
        IO.println("----------------------------------------\n");

        //Exercise 3:
        IO.println("Exercise 3: Sort a string array");
        String[] strArray = {"Paris", "London", "New York", "Stockholm"};
        String sortedArray = sortStringArray(strArray);
        IO.println(Arrays.toString(strArray)+"\n"+sortedArray);
        IO.println("----------------------------------------\n");

        //Exercise 4:
        IO.println("Exercise 4: Copy the elements of one array into another array");
        int[] firstArray = {1, 15, 20, 35};
        IO.println(String.format("Elements from first array: %s \n" +
                        "Elements from second array: %s",
                Arrays.toString(firstArray), Arrays.toString(copyElementsInArray(firstArray))));
        IO.println("----------------------------------------\n");

        //Exercise 5:
        IO.println("Exercise 5: Create a two-dimensional string array [2][2] and assign values");
        String[][] twoDArray = twoDimensionalArray();
        IO.println(Arrays.deepToString(twoDArray));
        IO.println("----------------------------------------\n");

        //Exercise 6:
        IO.println("Exercise 6: Print the average of 6 numbers holds in an array");
        int[] numbers = { 43, 5, 23, 17, 2, 14};
        double average = findAverage(numbers);
        IO.println("Average is : "+ average);
        IO.println("----------------------------------------\n");

        //Exercise 7:
        IO.println("Exercise 7: Set up an array to hold 10 numbers and print out only the uneven numbers");
        int[] numbersArray = {1, 2, 4,7, 9, 12};
        IO.println(String.format("Array : %s\nOdd Array : %s",
                Arrays.toString(numbersArray), Arrays.toString(findOddNumbersArray(numbersArray))));
        IO.println("----------------------------------------\n");

        //Exercise 8:
        IO.println("Exercise 8: Remove the duplicate elements of a given array");
        int[] numbersArray2 ={20, 20, 40, 20, 30, 40, 50, 60, 50};
        IO.println(String.format("Array : %s\nDistinct Array : %s",
                Arrays.toString(numbersArray2), Arrays.toString(removeDuplicates(numbersArray2))));
        IO.println("----------------------------------------\n");

        //Exercise 9:
        IO.println("Exercise 9: ArrayList -> “Expand” the array as user needs");
        ArrayList<Integer> numbersList = addArrayElements();
        IO.println("Expanded Array List: "+numbersList);
        IO.println("----------------------------------------\n");

        //Exercise 10:
        IO.println("Exercise 10: Ask the user to enter number or to exit, and when exit display the ArrayList in reverse order");
        ArrayList<Integer> numbersArrayList = addArrayElements();
        IO.println("Original Array: "+numbersList);
        ArrayList<Integer> numbersArrayListReversed = reverseArray(numbersArrayList);
        IO.println("Reversed Array: "+numbersArrayListReversed);
        IO.println("----------------------------------------\n");

        //Exercise 11:
        IO.println("Exercise 11: Represent multiplication table using two‑dimensional array");
        int[] multipliers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[][] multiplicationTable = createMultiplicationTable(multipliers);
        for (int[] row : multiplicationTable) {
            for (int num : row) {
                IO.print(num+"\t");
            }
            IO.println();
        }
        IO.println("----------------------------------------\n");

        //Exercise 12:
        IO.println("Exercise 12: Copy random numbers from arraylist1 to arraylist2 in a way that,\n" +
                " the even numbers are located in the rear (the right side) part of the array \n" +
                "and the odd numbers are located in the front part (the left side)");
        copyArrayLists();
        IO.println("==============Bye Bye!===================");
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

    //This method will let the user add elements to arraylist until they want to stop
    static ArrayList<Integer> addArrayElements(){
        ArrayList<Integer> numbersList = new ArrayList<>();
        int newNumber;
        do{

            IO.print("Enter a number  (Enter -1 to exit): ");
            newNumber = validateInt();
            if(newNumber != -1) {
                numbersList.add(newNumber);
            }
        } while(newNumber != -1);

        return numbersList;
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

    //This method reverse the array elements in an ArrayList and return it.
    static ArrayList<Integer> reverseArray(ArrayList<Integer> arrayList){
        Collections.reverse(arrayList);
        return arrayList;
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

    //
    static void copyArrayLists(){
        int size = 10; // arbitrary size

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        Random rand = new Random();

        // Fill first list with random numbers
        for (int i = 0; i < size; i++) {
            int randomNumber = rand.nextInt(101);
            list1.add(randomNumber); // 0–100
            if(randomNumber%2 ==0){
                list2.add(randomNumber);
            }else{
                list2.addFirst(randomNumber);
            }
        }

        IO.println(list1);
        IO.println(list2);
    }

}
