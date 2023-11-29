package com.yz.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yu.zh-neu
 * @create 2023-09-08 17:44
 */
public class RemoveM {


    private static void solveMethod(int n) {
        if (n <= 1 || n >= 100) {
            System.out.println("ERROR");
            return;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= 100; ++i) {
            arrayList.add(i);
        }

        int currentNumber = 0;
        int pos = 0;
        while (arrayList.size() >= n) {
            currentNumber++;
            if (currentNumber == n) {
                arrayList.remove(pos);
                currentNumber = 0;
            } else {
                pos++;
            }

            if (pos == arrayList.size()) {
                pos = 0;
            }
        }

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i));
            if (i != arrayList.size() - 1) {
                System.out.print(',');
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int number = scanner.nextInt();
            solveMethod(number);
        }
    }
}


