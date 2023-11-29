package com.yz.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
 * 磁盘的容量单位常用的有 M，G，T这=人等级，它们之间的换算关系为 1T= 1024G，1G = 1024M，现在给定 块磁盘的容量，请对户们按从小到大的顺序进行稳定排序Q，例如给定 5 块盘的容量，1T，20M，3G，10G6T，3M12G9M 排席后的结果为 20M.3G3M12G9M.1T.10G6T.
 * 注意单位可以重复出现，上述 3M12G9M 表示的容量即为 3M+12G+9M，和 12M12G 相等.
 * 输入描述
 * 输入第一行包含一个整数 n(2 <= n <= 100)，表示磁盘的个数，接下的n行，每行一个字符(长度大于2，小于 30)，表示磁盘的容量，由一个或多人格式为 mv 的子组成，其中 m表示容量大小，u 表示容量单位，例如 20M，1T.30G，10G6T，3M12G9M。
 * 磁盘容量 m 的范围为 1到 1024 的正整数，容量单位 的范用只包题日中提到的 M，G，T二种，管关系如题目描述
 * 输出描述
 * 输出 n 行，表示 n 块磁盘容量排序后的结果
 *
 * @author yu.zh-neu
 * @create 2023-09-07 18:00
 */
public class DiskCapacity {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        int[][] nums = new int[n][2];
        Map<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int index = -1;
            String value = s.nextLine();
            hashMap.put(i + 1, value);
            for (int j = 0; j < value.length(); ++j) {
                if ('M' == value.charAt(j)) {
                    sum += Integer.parseInt(value.substring(index + 1, j));
                    index = j;
                } else if ('G' == value.charAt(j)) {
                    sum += Integer.parseInt(value.substring(index + 1, j)) * 1024;
                    index = j;
                } else if ('T' == value.charAt(j)) {
                    sum += Integer.parseInt(value.substring(index + 1, j)) * 1024 * 1024;
                    index = j;
                }
            }
            nums[i][0] = i + 1;
            nums[i][1] = sum;

        }
        Arrays.sort(nums, (e1, e2) -> (e1[1] == e2[1] ? (e1[0] - e2[0]) :
                (e1[1] - e2[1])));

        for (int i = 0; i < n; ++i) {
            if (i == n - 1) {
                System.out.print(hashMap.get(nums[i][0]));
            } else {
                System.out.println(hashMap.get(nums[i][0]));
            }
        }

    }
}

