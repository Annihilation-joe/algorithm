package com.yz.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 主管期望你来实现英文输入法单词联想功能。需求如下:依据用户输入的单词前缀，从已输入的英文语句中联想出用户想输入的单词，按字典序输出联想到的单词序列，如果联想不到，请输出用
 * 户输入的单词前缀。
 * 注意:
 * 英文单词联想时，区分大小写
 * 缩略形式如”don'”，判定为两个单词，”don”和”
 * 输出的单词序列，不能有重复单词，目只能是英文单词，不能有标点符号
 * 输入描述:
 * 输入为两行
 * 首行输入一段由英文单词 word 和标点符号组成的语句 str:接下来一行为一个英文单词前缀 pre。
 *
 * @author yu.zh-neu
 * @create 2023-09-07 16:32
 */
public class InputWordAdvice {


    public static void solve(String value, String targetStr) {
        if (value == null || value.length() == 0) {
            System.out.println("input error");
            return;
        }
        List<String> myList = new ArrayList<>();
        StringBuilder wordSb = new StringBuilder();
        for (int j = 0; j < value.length(); ++j) {
            char ch = value.charAt(j);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                wordSb.append(ch);
            } else {
                myList.add(wordSb.toString());
                wordSb = new StringBuilder();
            }
        }
        List<String> resultList = new ArrayList<>();
        for (int j = 0; j < myList.size(); ++j) {
            if (myList.get(j).startsWith(targetStr)) {
                resultList.add(myList.get(j));
            }
        }
        //排序
        Collections.sort(resultList);
        if (resultList.size() > 0) {
            for (int j = 0; j < resultList.size(); ++j) {
                String reslut = resultList.get(j) + " ";
                System.out.print(reslut);
            }
            System.out.println();
        } else {
            System.out.println(targetStr);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String value = s.nextLine();
        String targetStr = s.nextLine();
        solve(value, targetStr);
    }
}

