package com.yz.exercise;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;
/**
 * @author yu.zh-neu
 * @create 2023-09-08 16:51
 */
public class FindRelationOfYAndT {

        public static void main(String[] args) {
            // 数据点
            double[] tData = {0, 2, 4, 6, 8};
            double[] yData = {0, 22, 40, 54, 64};

            // 使用Apache Commons Math库进行多项式拟合
            WeightedObservedPoints points = new WeightedObservedPoints();
            for (int i = 0; i < tData.length; i++) {
                points.add(tData[i], yData[i]);
            }

            // 设置多项式次数为2，表示二次函数
            PolynomialCurveFitter fitter = PolynomialCurveFitter.create(2);

            // 执行拟合
            double[] coefficients = fitter.fit(points.toList());

            // 拟合结果
            double a = coefficients[2];
            double b = coefficients[1];
            double c = coefficients[0];

            System.out.println("拟合结果：");
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("c = " + c);

            double result = a * 6*6 + b * 6 + c;
            System.out.println(result);
        }
    }

