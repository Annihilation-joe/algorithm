package com.yz.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 题目
 * VLAN 是一种对局域网Q设备进行逻辑划分的技术，为了标识不同的 VLAN，入 VLAN ID(1-4094 之间的整数)的概念。定义一个VLANID 的源池(下称 VLAN 资源池)，资源池中连续的 VLAN 用开始VLAN-结束 VLAN 表示，不连续的用单个整数表示，所有的 VLAN 用文逗号连接起来。现在有一个VLAN 资源池，业务需要从资源池中申请一个VLAN，需要你输出从 VLAN 资源池中移除申请的 VLAN后的资源池。
 * 输入输出描述:
 * 输入描述:
 * 第一行为字符串格式的 VLAN 资源池，第二行为业务要申请的 VLAN，VLAN 的取值范围为 1,4094] 之间的整数
 * 输出描述:
 * 从输入 VLAN 资源池中移除申请的 VLAN 后字符审格式的 VLAN 资源池，输出要求满足题目描述中的格式，并目按照 VLAN 从小到序输出。
 * 如果申请的 VLAN 不在原 VLAN 资源池内，输出原 VLAN 资源池升序排序后的字符串即可
 *
 * @author yu.zh-neu
 * @create 2023-09-08 9:55
 */
public class VLANInterval {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] vlans = s.nextLine().split(",");
        int vlanNeed = s.nextInt();
        // 字符串中所有包含的数字加入list
        List<Integer> myList = new ArrayList<>();
        // 数字数组存储起来
        for (String vlan : vlans) {
            String[] temp = vlan.split("-");
            if (temp.length > 1) {
                for (int i = Integer.parseInt(temp[0]); i <= Integer.parseInt(temp[1]); i++) {
                    myList.add(i);
                }
            } else {
                myList.add(Integer.parseInt(temp[0]));
            }
        }
        // 若list包含申请的vlan，从list删除
        for (int i = 0; i < myList.size(); ++i) {
            if (myList.get(i) == vlanNeed) { //先找到对应索引，字符串的话用equals判断相等
                myList.remove(i);
            }
        }
        // 数组排序
        Collections.sort(myList);
        StringBuilder stringBuilder = new StringBuilder();
        // 对排序后的数组进行重组，遍历，若下个数等于上个数加1，继续遍历，否则直接加入stringBuilder
        int i = 0;
        while (i < myList.size()) {
            int firstNum = myList.get(i);
            int j = 1;
            while (j <= myList.size() - 1 - i) {
                if (myList.get(i) + j == myList.get(i + j)) {
                    j++;
                } else {
                    break;
                }
            }
            if (j == 1) { // 如果下个数不等于上个数加1，直接加入stringBuilder,同时++i
                stringBuilder.append(firstNum);
                stringBuilder.append(",");
                ++i;
            } else { // 否则第一个数-递增的最后一个数加入stringBuilder,同时i=i+j
                stringBuilder.append(firstNum + "-" + (firstNum + j - 1) + ",");
                i = i + j;
            }
        }
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1)); // 去除最后一个","
    }
}

