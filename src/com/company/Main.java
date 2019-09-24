package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //write your program here
        Search obj= new Search();
        Map map=new Map();
        int [][] inputMap;
        inputMap=map.getMap().clone();
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print(inputMap[(i-1)][(j-1)] +" ");
            }
            System.out.println(" ");
        }
        obj.checker(inputMap);
    }
}
/* A class made to represent map of real world*/
class Map{
    private int [][] inMap=new int[5][5];
    Map(){
        for (int i = 1; i <= 5; i++) for (int j = 1; j <= 5; j++) inMap[i - 1][j - 1] = (i * 10) + j;
    }

    /* a method that takes the map as input from the user
    * and returns it as an array*/
    int[][] getMap(){
        Scanner s= new Scanner(System.in);
        System.out.println("Enter Map");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                inMap[(i-1)][(j-1)] = s.nextInt();
            }
        }
        return inMap;
    }
}
/*A class that represents the Searching process*/
class Search {
    private int counter;
    Search() {
        /* initialized counter variable so that the program doesn't enter infinite loop
         *and it doesn't loop more than number of cells in the array*/
        counter=0;
    }
    /*method that checks the array elements for the treasure     */
    void checker ( int[][] inpMap){
        int a=1;
        int b=1;
        out:
        for (; a <= 5; ) {
            for (; b <= 5; ) {
                if (inpMap[a - 1][b - 1] == ((a * 10) + b) && counter<=25) {
                    System.out.print("Step" + counter + "- Treasure Found at " + a + b + "Victory!!");
                    break out;
                }
                else if (counter <= 25 ) {
                    System.out.println("Step" + counter + "- Next cell");
                    int cellValue = inpMap[a - 1][b - 1];
                    a = cellValue / 10;
                    b = cellValue % 10;
                    counter++;
                }
            }
        }
    }
}