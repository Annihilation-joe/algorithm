package com.yz.exercise;

import java.util.Scanner;

/**
 * 给定一个 url 前和 url 后缀，通过 ，分割 需要将其连接为一个完整的 url如果前缀结尾和后缀开头都没有 /需要自动补上 / 连接符如果前缀结尾和后缀开头都为
 * 需要自动去重
 * 约束:
 * 不用考虑前后缀 URL 不合法情况
 * 输入
 * url 前缀(一个长度小于 100 的字符串)url 后缀(一个长度小于 100 的字符串)
 * 输出描述
 * 拼接后的 url
 *
 * @author yu.zh-neu
 * @create 2023-09-07 14:43
 */
public class CombineUrl {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        solveMethod(line);
        s.close();
    }

    private static void solveMethod(String line) {
        if (line.isEmpty()) {
            System.out.println("/");
            return;
        }
        String[] split = line.split(",");
        String combine;
        if (split.length >= 2) {
            combine = split[0] + "/" + split[1];
        } else if (split.length == 1) {
            combine = split[0] + "/";
        } else {
            combine = "/";
        }
        String url = combine.replaceAll("/+", "/");
        System.out.println(url);
    }

}


