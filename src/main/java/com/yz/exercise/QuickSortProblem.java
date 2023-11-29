package com.yz.exercise;

/**
 * @author yu.zh-neu
 * @create 2023-07-27 16:40
 */
public class QuickSortProblem {
    public static void quickSort(int[] arr) {
//        quickSort(arr, 0, arr.length - 1);
        quickSort2(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 获取基准值的位置
            int pivot = partition(arr, low, high);

            // 对基准值左边的子数组进行递归排序
            quickSort(arr, low, pivot - 1);

            // 对基准值右边的子数组进行递归排序
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // 选择基准值为数组的最后一个元素
        int pivot = arr[high];

        // 左指针和右指针
        int left = low;
        int right = high - 1;

        while (left <= right) {
            // 左指针找到大于基准值的元素
            while (left <= right && arr[left] <= pivot) {
                left++;
            }

            // 右指针找到小于基准值的元素
            while (left <= right && arr[right] >= pivot) {
                right--;
            }

            // 交换左右指针找到的元素
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        // 将基准值放到合适的位置
        int temp = arr[left];
        arr[left] = arr[high];
        arr[high] = temp;

        // 返回基准值的位置
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 5, 2, 7, 4, 1};
        System.out.println("原始数组：");
        printArray(arr);

        quickSort(arr);

        System.out.println("排序后的数组：");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void quickSort2(int[] arr, int low, int high) {
        if (low >= high){
            return;
        }
        int left = low;
        int right = high;
        int pivot = arr[low];
        while (left < right) {
            if (left < right && arr[left] <= pivot) {
                left ++;
            }
            if (left < right && arr[right] >= pivot) {
                right --;
            }
            swap(arr, left, right);
        }
        swap(arr, low, right);
        quickSort2(arr, low, right - 1);
        quickSort2(arr, right + 1, high);
    }

    private static void swap(int[] arr, int i, int j) {
        if (i < j) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }
}

