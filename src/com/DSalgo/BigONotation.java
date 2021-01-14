package com.DSalgo;

/*Time Complexity - The time taken to execute the lines of code, How much
time does it take to run the function largely depends on the speed of your
RAM and the programming language that you use.

There are 3 types of times in Programming

1. Constant time - O(1) , where O(1) + O(1) is still O(1), This applies for all
variables which are defined/ declared where the time stays constant irrespecive
of number of elements ,It takes 0.2 microsecond to run a defined
variable, with 30 elements, it takes 1.25 microseconds
[X = a + b + ...]

2. Linear time - O(N), Where N is the number of inputs that increases along with
time, often represented in loops , where N*O(1) is O(N)
[X =aN + b, where a and b are variables]

3.Quadratic time - O(N^2), where N is number of elements
[X = aN^2 + bN + c, where a is the fastest growing element ]
* */
public class BigONotation {

    public static void main(String[] args) {

        int[] intArray = {5,3,6,4,2,1,5,6,4,9}; //O(1) - constant time

        for(int i=0;i<intArray.length;++i){//O(N)
            System.out.println("Value of array elements :" + intArray[i]); //O(1)
        }
        int total=0; //O(1)
        for (int jArr:intArray) {//O(N) - Linear time X = aN+ b
            total += jArr; //O(1)
            System.out.println("From foreach loop " + jArr + " With" +
                    " a summing of :"+total ); //O(1)
        }

        int[][] twoDArr = {{1,2,3},
                           {1,2,3},
                           {1,2,3}}; //O(1) [3*3] array

        int d2total = 0; //O(1)
        for (int oneD[]: twoDArr) {
            for(int zeroD : oneD){ //O(N^2) - Quadratic time[X = aN^2 = bN + c]
                d2total += zeroD;
                System.out.println("Inside 2nd ForL, The sum of 2-D array is : " + d2total );
            }
            System.out.println("Inside 1st forL, The sum of 2-D array is : " + d2total );
        }
        System.out.println("Outside forL, The sum of 2-D array is : " + d2total );
    }

}
