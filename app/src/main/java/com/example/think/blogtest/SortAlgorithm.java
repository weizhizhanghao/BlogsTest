package com.example.think.blogtest;

/**
 * Created by HuangMei on 2017/3/27.
 */

public class SortAlgorithm {

    //bubble sort part
    public static void bubbleSort(int[] numbers){
        int tmp;
        int length = numbers.length;
        boolean isChange = false;
        for (int i = 0; i < length; i ++){
            for (int j = i + 1; j < length; j ++){
                if (numbers[j] > numbers[j + 1]){
                    isChange = true;
                    tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
                if (!isChange){
                    return;
                }
            }
        }
    }


    //quick sort part

    public static int getMiddle(int[] numbers, int high, int low){
        int middle = low;
        int tmp = numbers[middle];
        while (low < high){
            while (low < high && numbers[low] < tmp){
                low ++;
            }
            numbers[high] = numbers[low];

            while (low < high && numbers[high] > tmp){
                high --;
            }
            numbers[low] = numbers[high];
        }

        numbers[low] = tmp;
        return middle;
    }

    public static void quickSort(int[] numbers, int high, int low){
        if (low < high){
            int middle = getMiddle(numbers, high, low);
            quickSort(numbers, high, middle + 1);
            quickSort(numbers, middle - 1, low);
        }
    }

}
