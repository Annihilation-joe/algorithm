package com.yz.exercise;

import java.util.*;

/**
 * 统计IP频率输出
 * @author yu.zh-neu
 * @create 2023-07-13 10:13
 */
public class CustomSortedHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("www.baidu.com", 1);
        map.put("www.neusoft.com", 1);
        map.put("www.sina.com", 2);
        map.put("www.alibaba.com", 5);
        map.put("www.huawei.com", 3);
        map.put("www.360.com", 1);

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        // 1.
        list.sort(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));
        // 1.1 value 正序
//        Collections.sort(list, Comparator.comparingInt(Map.Entry::getValue));
        // 2.
//        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        // 3.
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return o2.getValue() - o1.getValue();
//            }
//        });
        int num = 4;
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey());
            num--;
            if (num == 0) {
                break;
            }
        }
    }

}