package com.yz.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给定一组不等式，判断是否成立并输出不等式的最大差 (输出浮点数的整数部分)要求:
 * 1.不等式系数为 double 类型，是一个二维数组
 * 2.不等式的变量为 int 类型，是一维数组
 * 3.不等式的目标值为 double 类型，是一维数组
 * 4.不等式约束为字符串数组，只能是大于，大于等于，小于，小于等于，等于
 * 例如:不等式组:
 * a11*x1+a12*x2+a13*x3+a14*x4+a15*x5<=b1:
 * a21*x1+a22*x2+a23*x3+a24*x4+a25*x5<=b2;
 * @author yu.zh-neu
 * @create 2023-09-07 11:26
 */
public class NoEqualSum {

    private static void solveMethod(String line) {
        String[] split1 = line.split(";");

        double maxError = 0;

        String[] limits = split1[split1.length - 1].split(",");
        String[] aims = split1[split1.length - 2].split(",");
        String[] vars = split1[split1.length - 3].split(",");

        for (int i = 0; i < limits.length; ++i) {
            String[] expression = split1[i].split(",");
            List<Double> expressionList = new ArrayList<>();
            for (String s : expression) {
                expressionList.add(Double.parseDouble(s));
            }
            double value = calculateValue(expressionList, vars);
            double aim = Double.parseDouble(aims[i]);
            double error = Math.abs(value - aim);
            maxError = Math.max(maxError, error);
            if (!checkLimit(limits[i], value, aim)) {
                System.out.print(false + " ");
                System.out.println(new Double(maxError).intValue());
                return;
            }
        }

        System.out.print(true + " ");
        System.out.println(new Double(maxError).intValue());
    }


    private static double calculateValue(List<Double> expression, String[] vars) {
        double value = 0;
        for (int j = 0; j < expression.size(); j++) {
            value += expression.get(j) * Integer.parseInt(vars[j]);
        }
        return value;
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        solveMethod(line);
    }

    private static boolean checkLimit(String limit, double value, double aim) {
        switch (limit) {
            case ">":
                return value > aim;
            case "<":
                return value < aim;
            case ">=":
                return value >= aim;
            case "<=":
                return value <= aim;
            default:
                return false;
        }
    }
}

