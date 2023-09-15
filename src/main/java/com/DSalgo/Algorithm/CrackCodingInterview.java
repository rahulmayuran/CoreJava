package com.DSalgo.Algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class CrackCodingInterview {
    public static void main(String[] args) {

        System.out.println("Minimum cost incurred by frog -> " + frogJump(Arrays.asList(30, 10, 60, 10, 60, 50), 5));
        System.out.println("Url'ified string is = " + printChars("Mr Black Smith    ".toCharArray(), 14));

        //Basic Maths
        reversedBits(1L);
        lcmAndGcd(5l, 3l);
        minJumps(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9});
        recursionTest1(4);
        reverseNumRecursion(10);

        System.out.println();
        System.out.println(recursiveSum(5));

        int[][] twodArr = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        isElementFoundBottomUpApproach(twodArr, 16);
        isElementFoundTopDownApproach(twodArr, 16);
        findTheElement(twodArr, 16);

        String str = "A man, a plan, a canal: Panama";
        str = str.toLowerCase();
        str = str.replaceAll("[^a-z]","");
        System.out.println("String is " + str);

        numbersWithConsecutiveDiffDFS(3, 7);

        int[] arr = {4, 1, 5, 9 ,3};

        minValInArray(arr, 5);
        System.out.print("Selection Sort -> "); selectionSort(arr, 5);
        System.out.print("Bubble Sort -> "); bubbleSort(arr, 5);
        System.out.print("Insertion Sort -> "); insertionSort(arr, 5);
        System.out.print("Recursive Insertion Sort -> "); recursiveInsertionSort(arr, 5);
        mergeSort(arr, 0, 5);

        Map<Integer, Integer> distinct = new HashMap<>();
        distinct.put(1, 1);
        for (int i = 0; i < 2 ; i++) {
            distinct.put(arr[i], distinct.getOrDefault(arr[i], 0) + 1);
        }

        for (int val : distinct.keySet()) {
            System.out.println("val = " + val);
        }
        distinct.entrySet().stream().map(e-> e.getValue()).collect(Collectors.toList());

        int [] binArr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        System.out.println("MaxConsecutiveOnes = " + findMaxConsOnes(binArr, 11, 2));
    }


    public static int frogJump(List<Integer> stonesList, int jumps) {

        if (jumps == 1)
            return Math.abs(stonesList.get(0) - stonesList.get(jumps)); //20
        if (jumps == 0)
            return 0;

        int max = Integer.MAX_VALUE;

        int smallJump = Math.min(max, Math.abs(stonesList.get(jumps - 1) - stonesList.get(jumps)))
                + frogJump(stonesList, jumps - 1); //f(3){20 + f(2){10 + f(1) {20}}} = 50

        int bigJump = Math.min(max, Math.abs(stonesList.get(jumps - 2) - stonesList.get(jumps)))
                + frogJump(stonesList, jumps - 2); // f(2){10 + f(1){20}} = 30

        return Math.min(smallJump, bigJump);
    }

    //str = "Apple Tree    ", length = 10;
    //o/p = "Apple%20Tree"
    public static String printChars(char[] str, int truelength){
        int spaceCount = 0, index = 0, i = 0;
        for (i = 0; i < truelength; i++) {
            if(str[i] == ' '){
                spaceCount++;
            }
        }

        index = truelength + spaceCount * 2; // 10 + 2 -> "Apple Tree  "
        if(truelength < str.length){
            str[truelength] = '\0'; //end the array //Apple Tree
        }
        for (i = truelength - 1; i >= 0; i--) {
            if(str[i] == ' '){
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
        return String.valueOf(str);
    }

    private static Long reversedBits(Long X) { //8
        StringBuilder b = new StringBuilder(Long.toBinaryString(X)); // 1000
        int len = b.length();
        if(len <= 0){
            return 0L;
        }

        b.reverse();
        for (int i = len; i < 32; i++) {
            b = b.append(0);
        }
        double a = Math.pow(2,32)*1;
        Long c = (long) a;
        System.out.println("reversed bits " + a);

//        System.out.println("Binary Val " + Long.valueOf(b));
        return Long.parseLong(String.valueOf(b), 2);
    }

    private static Long[] lcmAndGcd(Long A , Long B) {
            Long[] solution = new Long[2];
            solution[1] = gcd(A, B);
            solution[0] = (A * B) / gcd(A, B);

            return solution;
        }

        static Long gcd(Long A, Long B) {
            if (A == 0) {
                return B;
            }
            return gcd(B % A, A);
        }

        private static int minJumps(int[] arr){
            int N = arr.length;
            int max = 0;
            int jump = 0;
            int jCount = 0;

            for(int i = 0; i < N-1 ; i++){
                max = Math.max(max, i + arr[i]);
                if(i == jCount){
                    jump++;
                    jCount = max;
                }
                if(i >= max)
                    return -1;
            }

            return jump;
        }

        private static void recursionTest1(int n){
            if(n == 0){
                return;
            } else {
                System.out.println("Recurse me!!");
            }
            recursionTest1(n - 1);
        }

        private static void reverseNumRecursion(int n){
            if(n == 0){
                return;
            }
            System.out.print(n + " ");
            reverseNumRecursion(n - 1);
        }

        private static int recursiveSum(int n){
            if(n == 1){
                return 1;
            }
            return (int) Math.pow(3, n + recursiveSum(n - 1));
        }

        // 2-D matrix
        // Rows are sorted
        // First element of Current Row > last element of Previous Row
        // given a target value, search its existence

        // [[1, 3 ,5 ,7],
        //  [10, 11, 16, 20],
        //  [23, 30, 34, 60]]

        // Search 16. Output : true


        private static boolean findTheElement(int[][] arr, int target){
            int rowStart = 0; //0
            int rowEnd = arr.length - 1; //2
            int col = arr[0].length;

            //find the correct row using BS
            while(rowStart < rowEnd) {
                int mid = rowStart + (rowEnd - rowStart)/2; //1
                if (target > arr[mid][0] && target < arr[mid][col - 1]){
                    int column = Arrays.binarySearch(arr[mid], target);
                    if (column > 0) {
                        System.out.println("Element found at " + mid + " "+ column);
                        return true;
                    }
                } else if(target > arr[mid][0]){
                    rowStart = mid+1;
                } else {
                    rowEnd = mid-1;
                }
            }
            return false;
        }

        private static boolean isElementFoundBottomUpApproach(int[][] arr, int target){ //16 O(m + n)

            int row = arr.length - 1;
            int col = 0;

            while (row >= 0 && col < arr.length)
            {
                if (arr[row][col] == target) {
                    System.out.println("Element found at row-> " + row + " col-> "+ col);
                    return true;
                } else if (target > arr[row][col]) {
                    col++;
                } else {
                    row--;
                }
            }
            System.out.println("Not found");
            return false;
        }

        private static boolean isElementFoundTopDownApproach(int[][] arr, int target){ //16

            int row = 0;
            int col = arr.length - 1;

            while (col >= 0 && row < arr.length)
            {
                if (arr[row][col] == target) {
                    System.out.println("Element found at row-> " + row + " col-> "+ col);
                    return true;
                } else if (target > arr[row][col]) {
                    row++;
                } else {
                    col--;
                }
            }
            System.out.println("Not found");
            return false;
        }

    private static int[] numbersWithConsecutiveDiffDFS(int n, int k) {
        List<Integer> numbers = new ArrayList<>();

        for (int num = 1; num < 10; num++) {
            dfs(num, num, n - 1, k, numbers);
        }

        int[] answer = new int[numbers.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = numbers.get(i);
        }

        return answer;
    }

    private static void dfs(int num, int digit, int n, int k, List<Integer> numbers) {

        if (n == 0) {
            numbers.add(num);
            return;
        }
        if (digit + k <= 9) {
            dfs(num * 10 + (digit + k), digit + k, n - 1, k, numbers);
        }
        if (k != 0 && digit - k >= 0) {
            dfs(num * 10 + (digit - k), digit - k, n - 1, k, numbers);
        }
    }

    static int[] selectionSort(int arr[], int i) // 41359 , 5
    {
        int arrLen = arr.length; //5

        for (i = 0; i < arrLen - 1; i++) {
            for (int j = i + 1; j < arrLen; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j]; //1
                    arr[j] = arr[i]; //4
                    arr[i] = temp; //1
                }
            }
        }
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
        return arr;
    }

    static int minValInArray(int arr[], int n){ // 4 4 5 2 1
        int min = Integer.MAX_VALUE;
        int index = n;
        for (int j= 0; j < arr.length ; j++) {
            if(min > arr[j]){
                min = arr[j];
                index = j;
            }
        }
        System.out.println("min = " + min);
        return index;
    }

    static int[] bubbleSort(int arr[], int n){
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
        return arr;
    }

    static int[] insertionSort(int[] arr, int n){
        int marker, j, i;
        for (i = 1; i < n ; i++){
            marker = arr[i]; // Let the marker be at second index, assuming first element is sorted
            j = i - 1; // To compare with the previous indices

            while(j >= 0 && arr[j] > arr[i]){
                arr[j + 1] = arr[j]; // Shift the elements to right
                j -= 1; // move the index of elements to left
            }
            arr[j + 1] = marker; // Let the marker pos change.
        }
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
        return arr;
    }

    static void insert(int arr[], int i)
    {
        int marker = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > marker) {
            arr[j + 1] = arr[j];
            j -= 1; // -1
        }
        arr[j + 1] = marker;
    }

    static void recursiveInsertionSort(int[] arr, int n){
        if(n == 0){
            Arrays.stream(arr).forEach(System.out::print);
            return;
        }
        insert(arr, n-1);
        recursiveInsertionSort(arr, n-1);
    }



    static void mergeSort(int[] arr, int left , int right){ // 0 5
        if(left < right){
            int middle = left + (right - left) / 2;
//            mergeSort(arr, left, middle + 1); //sort left half
//            mergeSort(arr, middle, right); //sort right half
            merge(arr, left, middle, right); // merge both halves
        }
    }

    private static void merge(int[] arr, int left, int middle, int right){

    }

    static int print2largest(int arr[], int n) { // 45, 33, 11
        int max = Integer.MIN_VALUE;
        int second_max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max){
                second_max = max;
                max = Math.max(max, arr[i]); //45
            } else if(arr[i] > second_max && arr[i] != max){
                second_max = arr[i]; //33
            } else {
                second_max = -1;
            }
        }
        return second_max;
    }


    private static int findMaxConsOnes(int[] arr, int n, int m) {
        int maxConsecutiveOnes= 0;
        int i= 0, start= 0;
        int zeroCount= 0;

        for(i=0;i<n;i++) //0->10 ,0 1 2 3 4 5
        {
            if(arr[i]==0)
                zeroCount++; //1 at i=1, 2 at i=2, 3 at i=5

            if(zeroCount > m) // enters when i = 5
            {
                if(arr[start]== 0)
                    zeroCount--;
                start++;
            }
            else
            {
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, i-start+1);
                //1 2 3 4 5
            }
        }
        return maxConsecutiveOnes;
    }
}
