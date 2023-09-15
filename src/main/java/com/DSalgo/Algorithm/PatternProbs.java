package com.DSalgo.Algorithm;

public class PatternProbs {

    public static void main(String[] args) {

        //input
        int n = 5;

        printStars(n);
        rightTriangle(n);
        rightTriangleNumbers(n);
        rightTriangleSameNumbers(n);
        invertedRightTriangle(n);
        invertedRightTriangleWithNumbers(n);
        pyramidStars(n);
        reversedPyramidStars(n);
        diamondStars(n);
        rightPointer(n);
        binaryRightTriangle(n);
        funnelledNumbers(n);
        increasingRightTriangle(n); // Check

        increasingAlphaRightTriangle(n);
        decreasingAlphaRightTriangle(n);
        increasingAlphaRightTriangleVariation(n);
        alphabetPyramid(n); //Check
        alphabeticalRightTriangleVariant(n);

        missingDiamondInStars(n);
        bigXWithStars(n);
        matchBoxWithStars(n);
        perfectNumberSquare(n); //Check
    }



    private static void printStars(int n) {

        System.out.println("Star Matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }

    private static void rightTriangle(int n) {

        int i, j;
        System.out.println("Right Angle Triangle");
        for (i = 0; i < n; i++) { //Columns
            for (j = 0; j <= i; j++) { //Rows
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void rightTriangleNumbers(int n){
        System.out.println("Right Triangle with numbers");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void rightTriangleSameNumbers(int n){
        System.out.println("Right Triangle same numbers");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void invertedRightTriangle(int n){
        System.out.println("inverted Right Triangle with stars");

        for (int i = n; i > 0; i--) { //Rows
            for (int j = i; j > 0; j--) { //Columns
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void invertedRightTriangleWithNumbers(int n){

        System.out.println("inverted Right Triangle with numbers");

        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void pyramidStars(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n-i-1 ; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void reversedPyramidStars(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i ; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * (n - i) - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void diamondStars(int n){
        System.out.println("Diamond Stars");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i < n; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * (n - i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void rightPointer(int n){
        System.out.println("Right pointer ");
        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= i ; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    private static void binaryRightTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i ; j++) {
                if((j + i) % 2 == 0)
                    System.out.print(1);
                else
                    System.out.print(0);
            }
            System.out.println();
        }
    }

    private static void funnelledNumbers(int n){
        System.out.println("Number Funnelling");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j + 1);
            }
            for (int j = 1; j <= 2 * (n - i) - 2 ; j++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 0; j--) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }

    private static void increasingRightTriangle(int n){
        int flag = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(flag++ + " ");
            }
            System.out.println();
        }
    }


    private static void increasingAlphaRightTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                char c = 65;
                int o = c + j;
                System.out.print((char) o);
            }
            System.out.println();
        }
    }

    private static void decreasingAlphaRightTriangle(int n){
        System.out.println("Reversed Alphabetical Right Triangle");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int o = 65 + j;
                System.out.print((char) o);
            }
            System.out.println();
        }
    }

    private static void increasingAlphaRightTriangleVariation(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                char c = 65;
                int o = c + i;
                System.out.print((char) o);
            }
            System.out.println();
        }
    }

    private static void alphabetPyramid(int n) {
        System.out.println("Alphabetical pyramid");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1  ; j++) {
                System.out.print(" ");
            }
            //inc
            for (int k = 0; k < i; k++) {
                int c = 65 + k ;
                System.out.print((char) c);
            }
            //dec
            for (int l = i; l >= 0; l--) {
                int x = 65 + l;
                System.out.print((char) x);
            }
            System.out.println();
        }
    }

    private static void alphabeticalRightTriangleVariant(int n) {
        System.out.println("Right Triangle Variant");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                char c = 69;
                int o = c + j - i;
                System.out.print((char) o);
            }
            System.out.println();
        }
    }

    private static void missingDiamondInStars(int n){ //O(n * 2n) + O(n * 2n) = O(2n^2) = O(n^2)
        System.out.println("Missing Diamond in Stars");;
        for (int down = 0; down < n; down++) {
            for (int i = 0; i < (n - down); i++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2 * down ; j++) {
                System.out.print(" ");
            }
            for (int i = 0; i < (n - down); i++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int up = 0; up < n; up++) {
            for (int i = 0; i <= up; i++) {
                System.out.print("*");
            }
            for (int j = 1; j < 2 * (n - up) - 1 ; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= up; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void bigXWithStars(int n){ // O(n^2)
        System.out.println("Big X with stars");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2 * (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j < (2 * i) + 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void matchBoxWithStars(int n){
        System.out.println("Match Box");

        int prevIndex = n-1;
        int secondPreviousIndex = n - 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < prevIndex; j++) {
                if(i == 0 || i == prevIndex || j == 0 || j == secondPreviousIndex){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void perfectNumberSquare(int n) {
        System.out.println("Perfect inner shells");
        for (int i = 0; i < n; i++) {   // Till 4 rows
            for (int j = n; j > n - i; j--) {
                System.out.print(j + "  ");
            }
            for (int j = 0; j < 2 * (n - i) - 1; j++) {
                System.out.print(n - i + "  ");
            }
            for (int j = n - i + 1; j < n + 1; j++) {
                System.out.print(j + "  ");
            }
            System.out.println();
        }
        for (int i = n - 2; i >= 0; i--) {   // Last 3 rows
            for (int j = n; j > n - i; j--) {
                System.out.print(j + "  ");
            }
            for (int j = 0; j < 2 * (n - i) - 1; j++) {
                System.out.print(n - i + "  ");
            }
            for (int j = n - i + 1; j < n + 1; j++) {
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }

}
