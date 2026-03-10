package se.lexicon;

import java.util.Arrays;

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
                        "Elements from first array: %s",
                Arrays.toString(firstArray), Arrays.toString(copyElementsInArray(firstArray))));

        //Exercise 5:
        String[][] twoDArray = twoDimensionalArray();
        IO.println(Arrays.deepToString(twoDArray));

        //Exercise 6:
        int[] numbers = { 43, 5, 23, 17, 2, 14};
        double average = findAverage(numbers);
        IO.println("Average is : "+ average);
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

    static double findAverage(int[] numbers){
        int sum = 0;
        for (int number : numbers) {
            sum = sum + number;
        }
        return (double) sum / numbers.length;
    }
}
