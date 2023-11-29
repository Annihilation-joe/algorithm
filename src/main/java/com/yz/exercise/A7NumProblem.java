package com.yz.exercise;

import org.springframework.stereotype.Component;
import java.util.Scanner;

/**
 * 喊7是一个传统的聚会游戏，N 个人围成一圈，按顺时针从1到编号。编号为 1 的人从 1开始喊数，下一个人喊的数字为上一个人的数字加 1，但是当将要喊出来的数字是7的倍数或者数字本身含有7 的话，不能把这个数字直接喊出来，而是要喊”过”。假定玩这个游戏的 N 个人都没有失误地在正确的时机喊了"过”，当喊到数字 K 时，可以统计每个人喊”过”的次数
 * 现给定一个长度为 N 的数组，存储了打乱顺序的每个人喊”过"的次数，请把它还原成正确的顺序，即数组的第i元素存储编号i的人喊"过"的次数。
 * 输入描述
 * 输入为一行，为空格分隔的喊”过"的次数，注意 K 并不提供，K 不超过 200，而数字的个数即为 N。
 * 输出描述
 * 输出为一行，为顺序正确的喊”过”的次数，也由空格分隔。
 * @author yu.zh-neu
 * @create 2023-09-07 10:41
 */
@Component
public class A7NumProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        if (input.length == 1) {
            System.out.print(input[0]);
            return;
        }

        int[] nums = new int[input.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int sum = sum(nums);

        int[] sevenNumbers = findSevenNumbers(sum);

        int[] result = new int[nums.length];
        for (int num : sevenNumbers) {
            int index = (num - 1 + nums.length) % nums.length;
            result[index]++;
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }
    }

    public static int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static int[] findSevenNumbers(int times) {
        int count = 0;
        int num = 1;
        int[] result = new int[times];

        while (count < times) {
            if (num % 7 == 0 || String.valueOf(num).contains("7")) {
                result[count] = num;
                count++;
            }
            num++;
        }

        return result;
    }
}

