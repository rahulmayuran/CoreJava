package com.corejava.HackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static com.BaseLogger.Logger.commmonLogger;

/*
* 'n' number of lines have 0 or more integers, 'd' denotes number of integers
* 'q' denotes number of queries, Each query consists of x and y.
* */
public class ArrayListProblem
{

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);

            List<List<Integer>> matrix = new ArrayList();

            Stream.iterate(0, x -> x + 1).limit(scan.nextInt())
                    .forEach(x -> {
                final List<Integer> line = new ArrayList();
                Stream.iterate(0, y -> y + 1)
                        .limit(scan.nextInt())
                        .forEach(y -> {
                    line.add(scan.nextInt());
                });
                matrix.add(line);
            });

            Stream.iterate(0, n -> n + 1)
                    .limit(scan.nextInt())
                    .forEach(n -> {
                try {
                    commmonLogger.info(String.valueOf(matrix.get(scan.nextInt() - 1).get(scan.nextInt() - 1)));
                } catch (Exception ex) {
                    commmonLogger.info("ERROR!");
                }
            });
        }
    }